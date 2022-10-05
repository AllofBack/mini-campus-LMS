package com.example.minicampus.member.exception;

public class MemberStopUserException extends RuntimeException {
    public MemberStopUserException(String error) {
        super(error);
    }
}
