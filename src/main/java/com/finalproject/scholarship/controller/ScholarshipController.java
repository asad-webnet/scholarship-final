package com.finalproject.scholarship.controller;

import com.finalproject.scholarship.model.Application;
import com.finalproject.scholarship.model.Scholarship;
import com.finalproject.scholarship.repository.ApplicationRepository;
import com.finalproject.scholarship.repository.ScholarshipRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class ScholarshipController {

    private final ScholarshipRepository scholarshipRepository;
    private final ApplicationRepository applicationRepository;

    public ScholarshipController(ScholarshipRepository scholarshipRepository, ApplicationRepository applicationRepository) {
        this.scholarshipRepository = scholarshipRepository;
        this.applicationRepository = applicationRepository;
    }

    @GetMapping("/")
    public RedirectView redirectToApply() {
        return new RedirectView("/apply");
    }

    @GetMapping("/apply")
    public String applyPage(Model model) {
        List<Scholarship> scholarships = scholarshipRepository.findAll();
        model.addAttribute("scholarships", scholarships);
        return "apply"; // This refers to apply.html
    }

    @PostMapping("/apply")
    public String submitApplication(@RequestParam String name,
                                    @RequestParam String email,
                                    @RequestParam String schoolName,
                                    @RequestParam Long scholarshipId) {
        Scholarship scholarship = scholarshipRepository.findById(scholarshipId)
                .orElseThrow(() -> new RuntimeException("Scholarship not found"));

        Application application = new Application();
        application.setName(name);
        application.setEmail(email);
        application.setSchoolName(schoolName);
        application.setScholarship(scholarship); // Set the reference

        applicationRepository.save(application);
        return "redirect:/apply?success";
    }

    @GetMapping("/admin/applications")
    public String viewApplications(Model model) {
        List<Application> applications = applicationRepository.findAll();
        model.addAttribute("applications", applications);
        return "applications"; // This refers to applications.html
    }
}

