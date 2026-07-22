package Exceptions;

public class EntradaInvalidaException extends RuntimeException {

    // Construtor que recebe a mensagem de erro;
    public EntradaInvalidaException(String mensagem) {
        super(mensagem);
    }
}