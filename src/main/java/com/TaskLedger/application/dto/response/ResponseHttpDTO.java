package com.TaskLedger.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseHttpDTO {
    private HttpStatus status;
    private String message;
    private Object response;

    public ResponseHttpDTO(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
        this.response = null;
    }
}