package com.boba.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class ThemeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String link;

	private boolean closed;

	@OneToMany(mappedBy = "theme")
	private List<VariantEntity> variants;

	private ThemeEntity() {

	}

	public ThemeEntity(String name) {

		this.name = name;
	}

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public List<VariantEntity> getVariants() {

		return variants;
	}

	public void setVariants(List<VariantEntity> variants) {

		this.variants = variants;
	}

	public String getLink() {

		return link;
	}

	public void setLink(String link) {

		this.link = link;
	}

	public boolean isClosed() {

		return closed;
	}

	public void setClosed(boolean closed) {

		this.closed = closed;
	}
}
