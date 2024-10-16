package com.finalproject.scholarship.repository;

import com.finalproject.scholarship.model.Scholarship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScholarshipRepository extends JpaRepository<Scholarship, Long> {
}
