package com.leonidfrolov.spring.pastebox.exception;

public class NotFoundEntityException extends RuntimeException {
    public NotFoundEntityException(String s) {
        super(s);
    }
}
