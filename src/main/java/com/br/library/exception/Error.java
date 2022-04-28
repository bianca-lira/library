package com.br.library.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.time.LocalDateTime;

@JsonInclude(Include.NON_NULL)
public class Error {
    private final Integer status;
    private final String title;
    private final String detail;
    private final String userMessage;
    private final LocalDateTime timestamp;

    public Integer getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public static class Builder {
        private Integer status;
        private String title;
        private String detail;
        private String userMessage;
        private LocalDateTime timestamp;

        public Builder status(Integer status) {
            this.status = status;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public Builder userMessage(String userMessage) {
            this.userMessage = userMessage;
            return this;
        }

        public Builder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Error build() {
            return new Error(this);
        }

    }

    private Error(Builder builder) {
        status = builder.status;
        title = builder.title;
        detail = builder.detail;
        userMessage = builder.userMessage;
        timestamp = builder.timestamp;
    }
}

