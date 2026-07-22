package Model;

import java.time.LocalDate;

public class Transacao {
    // Atributos privados e o encapsulamento;
    private String descricao;
    private double valor;
    private boolean ehReceita;
    private LocalDate data;

    // Construtor;
    public Transacao(String descricao, double valor, boolean ehReceita, LocalDate data) {
        this.descricao = descricao;
        this.valor = valor;
        this.ehReceita = ehReceita;
        this.data = data;
    }

    // Getters e Setters;
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public boolean isEhReceita() { return ehReceita; }
    public void setEhReceita(boolean ehReceita) { this.ehReceita = ehReceita; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    // Método auxiliar para imprimir a transação;
    @Override
    public String toString() {
        String tipo = ehReceita ? "Receita" : "Despesa";
        return data + " | " + descricao + " | " + tipo + " | R$ " + valor;
    }
}
