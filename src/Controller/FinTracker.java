package Controller;

import Model.Transacao;
import java.util.ArrayList;

public class FinTracker {
    // Armazena as transações em memória usando ArrayList;
    private ArrayList<Transacao> transacoes = new ArrayList<>();

    public void adicionarTransacao(Transacao transacao) {
        transacoes.add(transacao);
        System.out.println("Transação adicionada com sucesso!");
    }

    public void listarTransacoes() {
        if (transacoes.isEmpty()) {
            System.out.println("Nenhuma transação registrada.");
            return;
        }
        for (int i = 0; i < transacoes.size(); i++) {
            System.out.println((i + 1) + ". " + transacoes.get(i).toString());
        }
    }

    public void removerTransacao(int indice) {
        if (indice >= 0 && indice < transacoes.size()) {
            transacoes.remove(indice);
            System.out.println("Transação removida.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void calcularSaldoTotal() {
        double saldo = 0.0;
        for (Transacao t : transacoes) {
            if (t.isEhReceita()) {
                saldo += t.getValor();
            } else {
                saldo -= t.getValor();
            }
        }
        System.out.println("Saldo Atual: R$ " + String.format("%.2f", saldo));
    }
}