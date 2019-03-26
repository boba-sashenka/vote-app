package com.boba.repository;

import com.boba.entity.ThemeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ThemeRepository extends JpaRepository<ThemeEntity, Long> {

	Optional<ThemeEntity> findByLink(String link);

}
