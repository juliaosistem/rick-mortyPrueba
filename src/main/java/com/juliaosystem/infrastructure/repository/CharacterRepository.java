package com.juliaosystem.infrastructure.repository;

import com.juliaosystem.infrastructure.entitis.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {
}
