package dev.victorugons.santanderdevweek.exception;

import lombok.Getter;

@Getter
public class ExceptionsResponse {

    public ExceptionsResponse(String message) {
        this.message = message;
    }
    private String message;
}
