package com.boba.dto.theme;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ThemeDto {

	private final Long id;
	private final String name;
	private final String link;
	private final boolean closed;
	private final List<VariantDto> variants;

	@JsonCreator
	public ThemeDto(@JsonProperty("id") Long id, @JsonProperty("name") String name, @JsonProperty("link") String link, @JsonProperty("closed") boolean closed,
			@JsonProperty("variants") List<VariantDto> variants) {

		this.id = id;
		this.name = name;
		this.link = link;
		this.closed = closed;
		this.variants = variants;
	}

	public Long getId() {

		return id;
	}

	public String getName() {

		return name;
	}

	public String getLink() {

		return link;
	}

	public boolean isClosed() {

		return closed;
	}

	public List<VariantDto> getVariants() {

		return variants;
	}
}
