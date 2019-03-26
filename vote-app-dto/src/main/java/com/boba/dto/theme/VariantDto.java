package com.boba.dto.theme;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class VariantDto {

	private final Long id;
	private final String name;

	@JsonCreator
	public VariantDto(@JsonProperty("id") Long id, @JsonProperty("name") String name) {

		this.id = id;
		this.name = name;
	}

	public Long getId() {

		return id;
	}

	public String getName() {

		return name;
	}
}
