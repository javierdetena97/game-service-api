package com.example.gameserviceapi.commons.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private Integer codeStatus;
    private String message;
}
