package com.rouvsen.repo;

import com.rouvsen.entity.Urbanite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrbaniteRepository
        extends JpaRepository<Urbanite, Long> {
}
