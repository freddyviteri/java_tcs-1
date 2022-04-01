package com.pichicnha.com.cuenta.repository;

import com.pichicnha.com.cuenta.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<Movement,Long> {
}
