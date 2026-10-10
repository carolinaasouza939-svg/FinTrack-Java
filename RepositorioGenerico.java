package br.com.capacita.fintrack.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/** Repositório genérico em memória. Também é o plano B do app quando o banco está fora do ar. */
public class RepositorioGenerico<T> implements Repositorio<T> {

    private final List<T> itens = new ArrayList<>();

    @Override
    public void adicionar(T item) {
        itens.add(Objects.requireNonNull(item, "O item não pode ser nulo."));
    }

    /**
     * Em memória o objeto guardado é o mesmo que a tela edita, então só confirmamos que ele existe.
     */
    @Override
    public boolean atualizar(T item) {
        return itens.contains(item);
    }

    @Override
    public boolean remover(T item) {
        return itens.remove(item);
    }

    /** Devolve uma cópia: quem recebe a lista não consegue bagunçar o repositório. */
    @Override
    public List<T> listar() {
        return new ArrayList<>(itens);
    }

    /** ? extends T (produtor): aceita lista de T ou de qualquer subclasse de T. */
    public void adicionarTodos(Collection<? extends T> novos) {
        itens.addAll(novos);
    }

    /** ? super T (consumidor): aceita destino de T ou de qualquer superclasse de T. */
    public void copiarPara(Collection<? super T> destino) {
        destino.addAll(itens);
    }

    /** ? super T: um filtro escrito para uma superclasse também serve para T. */
    public List<T> buscar(Predicate<? super T> filtro) {
        List<T> encontrados = new ArrayList<>();
        for (T item : itens) {
            if (filtro.test(item)) {
                encontrados.add(item);
            }
        }
        return encontrados;
    }

    public int tamanho() {
        return itens.size();
    }
}
