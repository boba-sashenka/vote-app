package com.boba.service.theme;

import com.boba.dto.statistics.StatisticsDto;
import com.boba.dto.theme.ThemeDto;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ThemeService {

	List<ThemeDto> getThemes();

	long addTheme(ThemeDto theme);

	String startVoting(long themeId);

	void closeVoting(long themeId);

	ThemeDto loadTheme(String link);

	void vote(String link, long variantId, String identity);

	StatisticsDto loadStatistics(String link);
}
