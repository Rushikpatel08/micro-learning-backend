package com.microlearning.api.model;

import jakarta.persistence.*;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Student_id;

    private String firstname;
    private String lastname;
    private String email;
    private String college;
    private String program;
}
