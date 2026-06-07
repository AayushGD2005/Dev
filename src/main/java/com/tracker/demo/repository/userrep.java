package com.tracker.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tracker.demo.model.user;

public interface userrep extends JpaRepository<user, Long> {

}