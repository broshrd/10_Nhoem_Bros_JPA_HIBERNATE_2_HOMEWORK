package com.example.homeworkjpa_book.model.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public class Response {
    public static ResponseEntity<?> RessponseALl(String message, Object data, Integer count) {
        return ResponseEntity.status(HttpStatus.OK).body(APIResponseAll.builder()
                .count(count)
                .message(message)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .data(data)
                .build());
    }
    public static ResponseEntity<?> BookResponse(String message, Object data) {
        return ResponseEntity.status(HttpStatus.OK).body(BookResponse.builder()
                .message(message)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .data(data)
                .build());
    }
}
