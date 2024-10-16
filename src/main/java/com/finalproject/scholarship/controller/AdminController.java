package com.finalproject.scholarship.controller;


import com.finalproject.scholarship.model.Scholarship;
import com.finalproject.scholarship.service.ScholarshipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final ScholarshipService scholarshipService;

    public AdminController(ScholarshipService scholarshipService) {
        this.scholarshipService = scholarshipService;
    }

    @GetMapping({"/",""})
    public RedirectView redirectToApply() {
        return new RedirectView("/admin/scholarships");
    }


    @GetMapping("/scholarships")
    public String listScholarships(Model model) {
        List<Scholarship> scholarships = scholarshipService.findAll();
        model.addAttribute("scholarships", scholarships);
        return "scholarships";
    }

    @GetMapping("/scholarships/add")
    public String showAddForm(Model model) {
        model.addAttribute("scholarship", new Scholarship());
        return "add-scholarship";
    }

    @PostMapping("/scholarships")
    public String addScholarship(@ModelAttribute Scholarship scholarship) {
        scholarshipService.save(scholarship);
        return "redirect:/admin/scholarships";
    }

    @GetMapping("/scholarships/delete/{id}")
    public String deleteScholarship(@PathVariable Long id) {
        scholarshipService.deleteById(id);
        return "redirect:/admin/scholarships";
    }
}

