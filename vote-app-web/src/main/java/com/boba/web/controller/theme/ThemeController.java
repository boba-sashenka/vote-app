package com.boba.web.controller.theme;

import com.boba.dto.statistics.StatisticsDto;
import com.boba.dto.theme.ThemeDto;
import com.boba.service.theme.ThemeService;
import com.boba.web.Navigation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Navigation.THEME)
public class ThemeController {

	private final ThemeService service;

	@Autowired
	public ThemeController(ThemeService service) {

		this.service = service;
	}

	@PostMapping(Navigation.LOAD_ALL)
	public ResponseEntity<?> getThemes() {

		List<ThemeDto> themes = service.getThemes();
		return ResponseEntity.ok(themes);
	}

	@PostMapping(Navigation.ADD)
	public ResponseEntity<?> addTheme(@RequestBody ThemeDto theme) {

		long id = service.addTheme(theme);
		return ResponseEntity.ok(id);
	}

	@PostMapping(Navigation.START_VOTING_BY_ID)
	public ResponseEntity<?> startVoting(@PathVariable(Navigation.THEME_ID) long themeId) {

		String link = service.startVoting(themeId);
		return ResponseEntity.ok(link);
	}

	@PostMapping(Navigation.CLOSE_VOTING_BY_ID)
	public ResponseEntity<?> closeVoting(@PathVariable(Navigation.THEME_ID) long themeId) {

		service.closeVoting(themeId);
		return ResponseEntity.ok().build();
	}

	@PostMapping(Navigation.LOAD_BY_LINK)
	public ResponseEntity<?> loadTheme(@PathVariable(Navigation.LINK) String link) {

		ThemeDto theme = service.loadTheme(link);
		return ResponseEntity.ok(theme);
	}

	@PostMapping(Navigation.VOTE_BY_LINK_AND_VARIANT_ID)
	public ResponseEntity<?> vote(@PathVariable(Navigation.LINK) String link, @PathVariable(Navigation.VARIANT_ID) long variantId,
			@RequestHeader(Navigation.IDENTITY_HEADER) String identity) {

		service.vote(link, variantId, identity);
		return ResponseEntity.ok().build();
	}

	@PostMapping(Navigation.LOAD_STATISTICS_BY_LINK)
	public ResponseEntity<?> loadStatistics(@PathVariable(Navigation.LINK) String link){

		StatisticsDto statistics = service.loadStatistics(link);
		return ResponseEntity.ok(statistics);
	}
}
