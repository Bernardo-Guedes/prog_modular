import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        char[] gabarito = new char[8];
        int aprovados = 0;

        System.out.println("Digite o gabarito da prova:");
        for (int i = 0; i < 8; i++) {
            System.out.print("Questão " + (i + 1) + ": ");
            gabarito[i] = entrada.next().charAt(0);
        }

        for (int aluno = 0; aluno < 10; aluno++) {
            System.out.print("\nDigite o número do aluno: ");
            int numeroAluno = entrada.nextInt();
            int nota = 0;
            System.out.println("Digite as respostas do aluno:");
            for (int i = 0; i < 8; i++) {
                System.out.print("Questão " + (i + 1) + ": ");
                char resposta = entrada.next().charAt(0);
                if (resposta == gabarito[i]) {
                    nota++;
                }
            }

            System.out.println("Aluno: " + numeroAluno);
            System.out.println("Nota: " + nota);

            if (nota >= 6) {
                aprovados++;
            }
        }
        double porcentagem = aprovados * 100.0 / 10;
        System.out.println("\nPorcentagem de aprovação: " + porcentagem + "%");

        entrada.close();
    }
}