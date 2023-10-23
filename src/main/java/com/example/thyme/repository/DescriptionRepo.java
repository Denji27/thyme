package com.example.thyme.repository;

import com.example.thyme.entity.Description;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DescriptionRepo extends JpaRepository<Description, Integer> {
}
