package ru.netology.javaqa.exeptions;

public class AlreadyExistsException extends RuntimeException{

    public AlreadyExistsException(String e) {
        super(e);
    }
}
