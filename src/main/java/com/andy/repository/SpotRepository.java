package com.andy.repository;

import com.andy.model.Spot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpotRepository extends JpaRepository<Spot, UUID> {
}
