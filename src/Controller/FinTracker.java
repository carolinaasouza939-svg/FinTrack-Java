package Controller;

import Model.Transacao;
import java.util.ArrayList;
import java.util.List;

public class FinTracker {
    // Armazena as transações em memória usando ArrayList;
    private ArrayList<Transacao> transacoes = new ArrayList<>();

    public void adicionarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    // Retorna a lista para a camada de visualização (Main) exibir;
    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    // Retorna booleano indicando se a remoção foi bem-sucedida;
    public boolean removerTransacao(int indice) {
        if (indice >= 0 && indice < transacoes.size()) {
            transacoes.remove(indice);
            return true;
        }
        return false;
    }

    // Retorna o valor numérico do saldo para ser impresso na Main;
    public double calcularSaldoTotal() {
        double saldo = 0.0;
        for (Transacao t : transacoes) {
            if (t.isEhReceita()) {
                saldo += t.getValor();
            } else {
                saldo -= t.getValor();
            }
        }
        return saldo;
    }
}
