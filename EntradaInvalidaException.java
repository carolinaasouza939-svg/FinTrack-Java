package br.com.capacita.fintrack.exceptions;

/** Lançada quando o usuário informa um dado inválido (valor, descrição, data...). */
public class EntradaInvalidaException extends RuntimeException {

    public EntradaInvalidaException(String mensagem) {
        super(mensagem);
    }
}
