package com.grw.cursos.exceptions;

public class IncorrectPasswordException extends RuntimeException {
    public IncorrectPasswordException(){
        super("Senha está incorreta");
    }
}
