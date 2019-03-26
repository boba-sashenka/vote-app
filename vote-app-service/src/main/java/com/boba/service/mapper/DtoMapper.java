package com.boba.service.mapper;

import com.boba.dto.theme.ThemeDto;
import com.boba.dto.theme.VariantDto;
import com.boba.entity.ThemeEntity;
import com.boba.entity.VariantEntity;
import com.boba.service.exception.NoInstanceException;

import java.util.List;
import java.util.stream.Collectors;

public class DtoMapper {

	private DtoMapper() {

		throw new NoInstanceException(DtoMapper.class);
	}

	public static ThemeDto toThemeDto(ThemeEntity theme) {

		List<VariantDto> variants = theme.getVariants().stream().map(DtoMapper::toVariantDto).collect(Collectors.toList());

		return new ThemeDto(theme.getId(), theme.getName(), theme.getLink(), theme.isClosed(), variants);
	}

	public static VariantDto toVariantDto(VariantEntity variant) {

		return new VariantDto(variant.getId(), variant.getName());
	}
}
