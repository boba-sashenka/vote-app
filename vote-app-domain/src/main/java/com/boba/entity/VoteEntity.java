package com.boba.entity;

import javax.persistence.*;

@Entity
public class VoteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String identity;

	@ManyToOne
	@JoinColumn(name = "variant_id")
	private VariantEntity variant;

	private VoteEntity() {

	}

	public VoteEntity(String identity, VariantEntity variant) {

		this.identity = identity;
		this.variant = variant;
	}

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public String getIdentity() {

		return identity;
	}

	public void setIdentity(String identity) {

		this.identity = identity;
	}

	public VariantEntity getVariant() {

		return variant;
	}

	public void setVariant(VariantEntity variant) {

		this.variant = variant;
	}
}
