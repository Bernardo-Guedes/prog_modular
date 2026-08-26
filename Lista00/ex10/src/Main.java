import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        double[][] vendas = new double[12][4];

        String[] meses = {"janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", "agosto", "setembro", "outubro", "novembro", "dezembro"};

        for (int i = 0; i < 12; i++) {
            System.out.println("\n" + meses[i]);
            for (int j = 0; j < 4; j++) {
                System.out.print("Digite o valor vendido na semana " + (j + 1) + ": ");
                vendas[i][j] = entrada.nextDouble();
            }
        }

        System.out.println("\nTOTAL VENDIDO POR MÊS:");
        double totalAno = 0;
        for (int i = 0; i < 12; i++) {
            double totalMes = 0;
            for (int j = 0; j < 4; j++) {
                totalMes += vendas[i][j];
            }
            System.out.println(meses[i] + ": R$ " + totalMes);
            totalAno += totalMes;
        }

        System.out.println("\nTOTAL VENDIDO POR SEMANA:");
        for (int j = 0; j < 4; j++) {
            double totalSemana = 0;
            for (int i = 0; i < 12; i++) {
                totalSemana += vendas[i][j];
            }
            System.out.println("Semana " + (j + 1) + ": R$ " + totalSemana);
        }

        System.out.println("\nTOTAL VENDIDO NO ANO: R$ " + totalAno);

        entrada.close();
    }
}