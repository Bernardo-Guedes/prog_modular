package application;

import entities.Aluno;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== CHAPÉU SELETOR =====");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 0) {
                System.out.println("Programa encerrado.");
                break;
            }

            if (opcao == 1) {

                System.out.println("\n--- Cadastro do aluno ---");

                System.out.print("Nome: ");
                String nome = sc.nextLine();

                System.out.print("Idade: ");
                int idade = sc.nextInt();

                System.out.print("Coragem: ");
                int coragem = sc.nextInt();

                System.out.print("Inteligência: ");
                int inteligencia = sc.nextInt();

                System.out.print("Ambição: ");
                int ambicao = sc.nextInt();

                System.out.print("Lealdade: ");
                int lealdade = sc.nextInt();

                System.out.print("Estratégia: ");
                int estrategia = sc.nextInt();

                System.out.print("Criatividade: ");
                int criatividade = sc.nextInt();

                Aluno aluno = new Aluno(
                        nome,
                        idade,
                        coragem,
                        inteligencia,
                        ambicao,
                        lealdade,
                        estrategia,
                        criatividade
                );

                aluno.calcularCasa();

                System.out.println("\n===== RESULTADO =====");
                aluno.exibirInformacoes();

            } else {
                System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }
}