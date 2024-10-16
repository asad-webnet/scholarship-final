package com.finalproject.scholarship.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
public class Scholarship {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "scholarship", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Application> applications; // List of applications for this scholarship
}
