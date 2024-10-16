package com.finalproject.scholarship.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Application {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String schoolName;
    @ManyToOne
    @JoinColumn(name = "scholarship_id", nullable = false)
    private Scholarship scholarship; // Reference to the Scholarship
}
