package com.boba.service.theme.impl;

import com.boba.dto.statistics.StatisticsDto;
import com.boba.dto.theme.ThemeDto;
import com.boba.dto.theme.VariantDto;
import com.boba.entity.ThemeEntity;
import com.boba.entity.VariantEntity;
import com.boba.repository.ThemeRepository;
import com.boba.repository.VariantRepository;
import com.boba.repository.VoteRepository;
import com.boba.service.exception.EntityNotFoundException;
import com.boba.service.exception.ThemeNotFoundException;
import com.boba.service.exception.ThemeVotingClosedException;
import com.boba.service.exception.ThemeVotingOpenedException;
import com.boba.service.mapper.DtoMapper;
import com.boba.service.mapper.EntityMapper;
import com.boba.service.theme.ThemeService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ThemeServiceImpl implements ThemeService {

	private final ThemeRepository themeRepository;
	private final VariantRepository variantRepository;
	private final VoteRepository voteRepository;

	@Autowired
	public ThemeServiceImpl(ThemeRepository themeRepository, VariantRepository variantRepository, VoteRepository voteRepository) {

		this.themeRepository = themeRepository;
		this.variantRepository = variantRepository;
		this.voteRepository = voteRepository;
	}

	@Override
	public List<ThemeDto> getThemes() {

		return themeRepository.findAll().stream().map(DtoMapper::toThemeDto).collect(Collectors.toList());
	}

	@Override
	public long addTheme(ThemeDto theme) {

		List<VariantEntity> variants = theme.getVariants().stream().map(VariantDto::getName).map(EntityMapper::toVariantEntity).collect(Collectors.toList());
		ThemeEntity entity = EntityMapper.toThemeEntity(theme.getName());
		entity.setClosed(true);
		themeRepository.save(entity);
		variants.forEach(v -> v.setTheme(entity));
		variantRepository.saveAll(variants);

		return entity.getId();
	}

	@Override
	public String startVoting(long themeId) {

		ThemeEntity theme = themeRepository.findById(themeId).orElseThrow(() -> new EntityNotFoundException(ThemeEntity.class, themeId));
		if (theme.isClosed()) {
			String generatedLink = UUID.randomUUID().toString();
			theme.setLink(generatedLink);
			theme.setClosed(false);
			themeRepository.save(theme);
			return generatedLink;
		} else {
			throw new ThemeVotingOpenedException(themeId);
		}
	}

	@Override
	public void closeVoting(long themeId) {

		ThemeEntity theme = themeRepository.findById(themeId).orElseThrow(() -> new EntityNotFoundException(ThemeEntity.class, themeId));

		if (theme.isClosed()) {
			throw new ThemeVotingClosedException(themeId);
		}
		theme.setClosed(true);
		themeRepository.save(theme);
	}

	@Override
	public ThemeDto loadTheme(String link) {

		ThemeEntity theme = themeRepository.findByLink(link).orElseThrow(() -> new ThemeNotFoundException(link));
		return DtoMapper.toThemeDto(theme);
	}

	@Override
	public void vote(String link, long variantId, String identity) {

		ThemeEntity theme = themeRepository.findByLink(link).orElseThrow(() -> new ThemeNotFoundException(link));
		if (theme.isClosed()) {
			throw new ThemeVotingClosedException(theme.getId());
		}
		VariantEntity variant = Optional.ofNullable(theme.getVariants()).orElse(Collections.emptyList()).stream().filter(v -> v.getId().equals(variantId)).findAny()
				.orElseThrow(() -> new EntityNotFoundException("Theme has no variant with such id = " + variantId));

		voteRepository.save(EntityMapper.toVoteEntity(identity, variant));
	}

	@Override
	public StatisticsDto loadStatistics(String link) {

		ThemeEntity theme = themeRepository.findByLink(link).orElseThrow(() -> new ThemeNotFoundException(link));
		List<Pair<String, Integer>> statistics = new ArrayList<>();
		theme.getVariants().forEach(v -> statistics.add(new Pair<String, Integer>(v.getName(), v.getVotes().size())));
		return new StatisticsDto(theme.getName(), statistics);
	}
}
