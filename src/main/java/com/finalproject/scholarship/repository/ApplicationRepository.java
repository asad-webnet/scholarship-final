package com.finalproject.scholarship.repository;

import com.finalproject.scholarship.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
