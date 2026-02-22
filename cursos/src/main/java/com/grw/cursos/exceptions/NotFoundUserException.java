package com.grw.cursos.exceptions;

public class NotFoundUserException extends RuntimeException {
   public NotFoundUserException(){
        super("Usuário não existe na base de dados");
    }
}
