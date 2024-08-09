package com.example.homeworkjpa_book.requestbody;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {

        @Column(nullable = false)
        private String title;

        private String description;

        @Column(nullable = false)
        private String author;

        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @Column(nullable = false)
        private LocalDate s_dob;

    }
