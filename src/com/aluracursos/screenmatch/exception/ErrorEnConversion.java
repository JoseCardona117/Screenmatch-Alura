package com.aluracursos.screenmatch.exception;

public class ErrorEnConversion extends RuntimeException {
    private String mensaje;


    public ErrorEnConversion(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMessage(){
        return this.mensaje;
    }
}
