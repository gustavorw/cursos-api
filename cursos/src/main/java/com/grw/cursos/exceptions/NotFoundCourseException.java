package com.grw.cursos.exceptions;

public class NotFoundCourseException extends RuntimeException  {
    public NotFoundCourseException(){
        super("Curso não encontrado");
    }
}
