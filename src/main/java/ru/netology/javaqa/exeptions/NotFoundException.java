package ru.netology.javaqa.exeptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String s) {
        super(s);
    }
}
