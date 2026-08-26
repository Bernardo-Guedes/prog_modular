import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o tamanho do vetor X: ");
        int n = entrada.nextInt();
        int[] X = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("X["+i+"]: ");
            X[i] = entrada.nextInt();
        }

        System.out.print("Digite o tamanho do vetor Y: ");
        int m = entrada.nextInt();
        int[] Y = new int[m];

        for (int i = 0; i < m; i++) {
            System.out.print("Y["+i+"]: ");
            Y[i] = entrada.nextInt();
        }

        int[] Z = new int[n + m];
        for (int i = 0; i < n; i++) {
            Z[i] = X[i];
        }
        int tamanhoZ = n;

        for (int i = 0; i < m; i++) {
            boolean existe = false;
            for (int j = 0; j < tamanhoZ; j++) {
                if (Y[i] == Z[j]) {
                    existe = true;
                }
            }
            if (!existe) {
                Z[tamanhoZ] = Y[i];
                tamanhoZ++;
            }
        }

        System.out.println("Vetor união:");
        for (int i = 0; i < tamanhoZ; i++) {
            System.out.print(Z[i] + " ");
        }

        entrada.close();
    }
}
