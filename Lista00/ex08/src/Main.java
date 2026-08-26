import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        double[] precos = new double[10];
        int[] quantidades = new int[10];

        double totalVendas = 0;
        int maiorQuantidade = 0;
        int posicaoMaisVendido = 0;

        System.out.println("Digite o preço de cada objeto:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Preço do objeto " + (i + 1) + ": ");
            precos[i] = entrada.nextDouble();
        }

        System.out.println("\nDigite a quantidade vendida de cada objeto:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Quantidade do objeto " + (i + 1) + ": ");
            quantidades[i] = entrada.nextInt();
        }

        System.out.println("\nRELATÓRIO");
        for (int i = 0; i < 10; i++) {
            double totalObjeto = precos[i] * quantidades[i];
            System.out.println("Objeto " + (i + 1) + " | Quantidade: " + quantidades[i] + " | Valor unitário: R$ " + precos[i] + " | Valor total: R$ " + totalObjeto);
            totalVendas += totalObjeto;

            if (quantidades[i] > maiorQuantidade) {
                maiorQuantidade = quantidades[i];
                posicaoMaisVendido = i;
            }
        }

        double comissao = totalVendas * 0.05;

        System.out.println("\nValor geral das vendas: R$ " + totalVendas);
        System.out.println("Comissão do vendedor: R$ " + comissao);
        System.out.println("Objeto mais vendido: objeto " + (posicaoMaisVendido + 1));
        System.out.println("Valor unitário do objeto mais vendido: R$ " + precos[posicaoMaisVendido]);
        System.out.println("Posição no vetor: " + posicaoMaisVendido);

        entrada.close();
    }
}