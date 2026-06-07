package com.tracker.demo.repository;

import com.tracker.demo.model.medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tracker.demo.model.medicine;

public interface medrep extends JpaRepository<medicine, Long> {
}