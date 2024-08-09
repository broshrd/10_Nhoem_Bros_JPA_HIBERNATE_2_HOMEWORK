package com.example.homeworkjpa_book.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse<T>{
    String message;
    T data;
    LocalDateTime time;
    HttpStatus status;
}
