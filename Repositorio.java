package br.com.capacita.fintrack.repository;

import java.util.List;

/** Contrato genérico de armazenamento: serve para qualquer tipo T (banco ou memória). */
public interface Repositorio<T> {

    void adicionar(T item);

    /** @return true se o item existia e foi atualizado */
    boolean atualizar(T item);

    /** @return true se o item existia e foi removido */
    boolean remover(T item);

    List<T> listar();
}
