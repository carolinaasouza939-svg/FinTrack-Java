# FinTrack - Controle Financeiro Pessoal 💰

Um gerenciador simples e prático de finanças pessoais via console. Este projeto Java foi criado para facilitar o registro de receitas e despesas, ajudando no acompanhamento do seu saldo de forma estruturada e segura. 

O sistema gera um menu interativo diretamente no terminal, otimizado para navegação rápida e validação imediata de dados.

## 🚀 Funcionalidades

- **Cadastro Rápido:** Adiciona novas transações (receitas e despesas) com validação automática de regras de negócio.
- **Listagem Organizada:** Exibe todas as transações registradas em um formato de lista enumerada, fácil de ler e acompanhar.
- **Cálculo em Tempo Real:** Mostra o saldo atualizado instantaneamente com base nas entradas e saídas.
- **Remoção Simples:** Permite excluir transações digitando apenas o número correspondente ao índice da lista.
- **Sistema Anti-Falhas:** Tratamento de erros (exceções) robusto que impede que o programa feche abruptamente se você digitar letras em vez de números ou valores negativos.

## 🛠️ Tecnologias Utilizadas

- **Java (JDK 17+):** Linguagem base do projeto, utilizando os pilares da Orientação a Objetos.
- **Scanner & System.out:** Estruturação da interface de entrada e saída no terminal.
- **Padrão MVC:** Lógica separada em pacotes (`App`, `Controller`, `Model`, `Exceptions`) para um código limpo e escalável.
- **JUnit:** Biblioteca externa usada para rodar testes automatizados e garantir que os cálculos e regras funcionem perfeitamente.

## 📂 Estrutura do Projeto

O projeto está rigorosamente organizado em pacotes para separar responsabilidades:

```text
FinTrack-Java/
├── src/
│   ├── App/
│   │   └── Main.java                      # Ponto de entrada, menu interativo e View
│   ├── Controller/
│   │   ├── FinTracker.java                # Lógica central de gestão das transações
│   │   ├── FinTrackerTest.java            # Testes automatizados
│   │   └── Dao/                           # Camada para futura persistência de dados
│   ├── Model/
│   │   ├── Transacao.java                 # Classe base para as transações
│   │   └── TransacaoMensal.java           # Subclasse demonstrando herança/polimorfismo
│   └── Exceptions/
│       └── EntradaInvalidaException.java  # Exceção personalizada para validação
└── .gitignore
```

## ⚙️ Como usar e executar

Não é necessário instalar bancos de dados complexos nesta versão inicial. Basta ter o Java (JDK) instalado no seu computador e clonar os arquivos deste repositório.

### Executando pela sua IDE (Recomendado)

A forma mais rápida é abrir a pasta do projeto no IntelliJ IDEA, VS Code ou Eclipse:

1. Clone o repositório:
   ```bash
   git clone https://github.com/carolinaasouza939-svg/FinTrack-Java.git
   ```
2. Abra o projeto na sua IDE.
3. Vá até o pacote `src/App/`.
4. Dê um duplo clique no arquivo `Main.java` para abri-lo.
5. Clique no botão de **Run** (Play verde) da sua IDE.

### Executando pelo Terminal (Linha de comando)

Se preferir rodar direto no terminal (Prompt de Comando, PowerShell ou Bash), navegue até a pasta `src` do projeto e execute os comandos abaixo para compilar e iniciar:

```bash
cd FinTrack-Java/src

javac App/*.java Controller/*.java Model/*.java Exceptions/*.java

java App.Main
```

## 💻 Interagindo com o Menu

Ao rodar o projeto, o menu principal aparecerá magicamente no seu console.

Basta digitar o número da opção desejada (ex: `1` para adicionar, `3` para ver o saldo) e pressionar `Enter`. O sistema guiará você com perguntas passo a passo (como descrição, valor e tipo da transação) e avisará caso algum dado seja preenchido incorretamente.

## ✒️ Autoria

Desenvolvido por **Ana Caroline Sousa Alves** - [carolinaasouza939-svg](https://github.com/carolinaasouza939-svg)
