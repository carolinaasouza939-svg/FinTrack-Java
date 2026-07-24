package App;

import Controller.FinTracker;
import Model.Transacao;
import Exceptions.EntradaInvalidaException;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FinTracker tracker = new FinTracker();
        int opcao = 0;

        do {
            System.out.println("\n===== FINTRACK - SEU CONTROLE FINANCEIRO =====");
            System.out.println("1. Adicionar nova transação");
            System.out.println("2. Listar transações");
            System.out.println("3. Mostrar saldo atual");
            System.out.println("4. Remover transação");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer

                switch (opcao) {
                    case 1:
                        System.out.print("Descrição da transação: ");
                        String desc = scanner.nextLine();

                        System.out.print("Valor (Ex: 150,50): ");
                        double valor = scanner.nextDouble();

                        if (valor <= 0) {
                            throw new EntradaInvalidaException("O valor não pode ser zero ou negativo.");
                        }

                        System.out.print("É uma receita? (true para Receita / false para Despesa): ");
                        boolean ehReceita = scanner.nextBoolean();

                        Transacao novaTransacao = new Transacao(desc, valor, ehReceita, LocalDate.now());
                        tracker.adicionarTransacao(novaTransacao);
                        System.out.println("Transação adicionada com sucesso!"); // Mensagem na camada de visão
                        break;

                    case 2:
                        System.out.println("\n--- Suas Transações ---");
                        List<Transacao> lista = tracker.getTransacoes(); // Pega a lista pura do controller
                        if (lista.isEmpty()) {
                            System.out.println("Nenhuma transação registrada.");
                        } else {
                            for (int i = 0; i < lista.size(); i++) {
                                System.out.println((i + 1) + ". " + lista.get(i).toString());
                            }
                        }
                        break;

                    case 3:
                        System.out.println("\n--- Saldo ---");
                        double saldo = tracker.calcularSaldoTotal(); // Pega apenas o valor numérico
                        System.out.println("Saldo Atual: R$ " + String.format("%.2f", saldo)); // Exibe na tela
                        break;

                    case 4:
                        System.out.print("Digite o número da transação para remover: ");
                        int index = scanner.nextInt() - 1;
                        boolean removido = tracker.removerTransacao(index); // Verifica o sucesso da operação
                        if (removido) {
                            System.out.println("Transação removida.");
                        } else {
                            System.out.println("Índice inválido.");
                        }
                        break;

                    case 5:
                        System.out.println("Saindo do FinTrack. Até logo!");
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Erro: Você digitou um formato inválido. Use números onde solicitado.");
                scanner.nextLine();
                opcao = 0;

            } catch (EntradaInvalidaException e) {
                System.out.println("Erro de validação: " + e.getMessage());
                scanner.nextLine();
            }

        } while (opcao != 5);

        scanner.close();
    }
}
