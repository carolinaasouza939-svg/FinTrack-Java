package Controller;

import Model.Transacao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class FinTrackerTest {

    private FinTracker tracker;

    @BeforeEach
    public void setUp() {
        tracker = new FinTracker(); 
    }

    @Test
    public void deveCalcularSaldoCorretamente() {
        // Cenário
        Transacao receita = new Transacao("Salário", 3000.0, true, LocalDate.now());
        Transacao despesa = new Transacao("Aluguel", 1200.0, false, LocalDate.now());

        // Ação
        tracker.adicionarTransacao(receita);
        tracker.adicionarTransacao(despesa);

        // Verificação
        assertEquals(1800.0, tracker.calcularSaldoTotal(), 0.01, "O saldo deve ser 1800.0");
    }

    @Test
    public void deveRemoverTransacaoComSucesso() {
        Transacao t1 = new Transacao("Mercado", 250.0, false, LocalDate.now());
        tracker.adicionarTransacao(t1);

        boolean removido = tracker.removerTransacao(0);

        assertTrue(removido, "A transação deveria ter sido removida");
        assertEquals(0, tracker.getTransacoes().size(), "A lista deve estar vazia após a remoção");
    }
