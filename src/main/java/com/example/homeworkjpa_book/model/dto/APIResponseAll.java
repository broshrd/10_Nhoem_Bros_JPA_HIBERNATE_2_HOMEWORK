package com.example.homeworkjpa_book.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class APIResponseAll<T> {
    Integer count;
    String message;
    T data;
    LocalDateTime time;
    HttpStatus status;
}
