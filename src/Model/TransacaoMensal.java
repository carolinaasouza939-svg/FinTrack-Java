package Model;

import java.time.LocalDate;

// Herança;
public class TransacaoMensal extends Transacao {

    public TransacaoMensal(String descricao, double valor, boolean ehReceita, LocalDate data) {
        super(descricao, valor, ehReceita, data);
    }
}
