import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int[] numeros = new int[6];
        for (int i = 0; i < 6; i++) {
            System.out.print("Digite o número " + (i + 1) + ": ");
            numeros[i] = entrada.nextInt();
        }

        int somaPares = 0;
        int quantidadeImpares = 0;

        System.out.println("\nRELATÓRIO");
        System.out.println("Os números pares são:");
        for (int i = 0; i < 6; i++) {
            if (numeros[i] % 2 == 0) {
                System.out.println("número " + numeros[i] + " na posição " + (i + 1));
                somaPares += numeros[i];
            }
        }
        System.out.println("Soma dos pares = " + somaPares);

        System.out.println("\nOs números ímpares são:");
        for (int i = 0; i < 6; i++) {
            if (numeros[i] % 2 != 0) {
                System.out.println("número " + numeros[i] + " na posição " + (i + 1));
                quantidadeImpares++;
            }
        }
        System.out.println("Quantidade de ímpares = " + quantidadeImpares);

        entrada.close();
    }
}