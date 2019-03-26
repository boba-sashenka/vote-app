package com.boba.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class VariantEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@ManyToOne
	@JoinColumn(name = "theme_id")
	private ThemeEntity theme;

	@OneToMany(mappedBy = "variant")
	private List<VoteEntity> votes;


	private VariantEntity() {

	}

	public VariantEntity(String name) {

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

	public ThemeEntity getTheme() {

		return theme;
	}

	public void setTheme(ThemeEntity theme) {

		this.theme = theme;
	}

	public List<VoteEntity> getVotes() {

		return votes;
	}

	public void setVotes(List<VoteEntity> votes) {

		this.votes = votes;
	}
}
