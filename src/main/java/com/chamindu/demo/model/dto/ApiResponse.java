package com.chamindu.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Author by chamindu_kaushalya
 */
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private Integer count;
    private LocalDateTime timestamp;

    private T data;
}
