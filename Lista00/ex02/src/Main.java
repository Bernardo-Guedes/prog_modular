import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int[] numeros = new int[3];

        System.out.print("Digite o valor de x: ");
        int x = entrada.nextInt();

        System.out.print("Digite o valor de y: ");
        int y = entrada.nextInt();

        System.out.print("Digite o valor de z: ");
        int z = entrada.nextInt();

        numeros[0] = x;
        numeros[1] = y;
        numeros[2] = z;

        int maior = numeros[0];
        for (int i = 1; i < numeros.length; i++){
            if (numeros[i] > maior){
                maior = numeros[i];
            }
        }
        System.out.println("Maior número: "+maior);

        int menor = numeros[0];
        for (int i = 1; i < numeros.length; i++){
            if (numeros[i] < menor){
                menor = numeros[i];
            }
        }
        System.out.println("Menor número: "+menor);

        if (x >= y && x <= z) {
            System.out.println("x está dentro do intervalo [y, z].");
        } else {
            System.out.println("x está fora do intervalo [y, z].");
        }

        if (x % y == 0 && x % z == 0) {
            System.out.println("x é divisível por y e por z.");
        } else {
            System.out.println("x não é divisível por y e por z.");
        }

        entrada.close();


    }
}