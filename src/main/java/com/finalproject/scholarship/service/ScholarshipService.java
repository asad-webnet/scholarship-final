package com.finalproject.scholarship.service;


import com.finalproject.scholarship.model.Scholarship;
import com.finalproject.scholarship.repository.ScholarshipRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScholarshipService {
    private final ScholarshipRepository scholarshipRepository;

    public ScholarshipService(ScholarshipRepository scholarshipRepository) {
        this.scholarshipRepository = scholarshipRepository;
    }

    public List<Scholarship> findAll() {
        return scholarshipRepository.findAll();
    }

    public Scholarship save(Scholarship scholarship) {
        return scholarshipRepository.save(scholarship);
    }

    public void deleteById(Long id) {
        scholarshipRepository.deleteById(id);
    }
}
