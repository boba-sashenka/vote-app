package com.boba.service.mapper;

import com.boba.entity.ThemeEntity;
import com.boba.entity.VariantEntity;
import com.boba.entity.VoteEntity;
import com.boba.service.exception.NoInstanceException;

public class EntityMapper {

	private EntityMapper() {

		throw new NoInstanceException(EntityMapper.class);
	}

	public static ThemeEntity toThemeEntity(String name) {

		return new ThemeEntity(name);
	}

	public static VariantEntity toVariantEntity(String name) {

		return new VariantEntity(name);
	}

	public static VoteEntity toVoteEntity(String identity, VariantEntity variant) {

		return new VoteEntity(identity, variant);
	}

}
