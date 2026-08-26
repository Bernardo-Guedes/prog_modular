import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o número de alunos: ");
        int n = entrada.nextInt();

        int[] programacaoModular = new int[n];
        int[] calculo = new int[n];

        System.out.println("\nMatrículas de Programação Modular:");

        for (int i = 0; i < n; i++) {
            System.out.print("Digite a matrícula " + (i + 1) + ": ");
            programacaoModular[i] = entrada.nextInt();
        }

        System.out.println("\nMatrículas de Cálculo:");

        for (int i = 0; i < n; i++) {
            System.out.print("Digite a matrícula " + (i + 1) + ": ");
            calculo[i] = entrada.nextInt();
        }

        System.out.println("\nAlunos matriculados nas duas disciplinas:");

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (programacaoModular[i] == calculo[j]) {
                    System.out.println(programacaoModular[i]);
                }
            }
        }

        entrada.close();


    }
}