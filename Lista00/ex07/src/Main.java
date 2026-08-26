import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        double[] temperaturas = new double[12];

        String[] meses = {"janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", "agosto", "setembro", "outubro", "novembro", "dezembro"};

        for (int i = 0; i < 12; i++) {
            System.out.print("Digite a temperatura média de " + meses[i] + ": ");
            temperaturas[i] = entrada.nextDouble();
        }

        double maior = temperaturas[0];
        double menor = temperaturas[0];
        int mesMaior = 0;
        int mesMenor = 0;

        for (int i = 1; i < 12; i++) {
            if (temperaturas[i] > maior) {
                maior = temperaturas[i];
                mesMaior = i;
            }
            if (temperaturas[i] < menor) {
                menor = temperaturas[i];
                mesMenor = i;
            }
        }

        System.out.println("\nMaior temperatura: " + maior + "°C");
        System.out.println("Mês: " + meses[mesMaior]);

        System.out.println("\nMenor temperatura: " + menor + "°C");
        System.out.println("Mês: " + meses[mesMenor]);

        entrada.close();
    }
}