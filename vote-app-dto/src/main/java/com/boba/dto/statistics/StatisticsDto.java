package com.boba.dto.statistics;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javafx.util.Pair;

import java.util.List;

public class StatisticsDto {

	private final String themeName;
	private final List<Pair<String, Integer>> statistics;

	@JsonCreator
	public StatisticsDto(@JsonProperty("themeName") String themeName, @JsonProperty("statistics") List<Pair<String, Integer>> statistics) {

		this.themeName = themeName;
		this.statistics = statistics;
	}

	public String getThemeName() {

		return themeName;
	}

	public List<Pair<String, Integer>> getStatistics() {

		return statistics;
	}
}
