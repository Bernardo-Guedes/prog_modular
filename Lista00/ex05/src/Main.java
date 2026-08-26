import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int idade;
        int maior = 0;
        int menor = 0;
        int qtd = 0;

        System.out.print("Digite a idade (-1 para encerrar): ");
        idade = entrada.nextInt();

        while (idade != -1) {

            System.out.print("Digite o sexo (M/F): ");
            char sexo = entrada.next().charAt(0);

            System.out.print("Digite a cor dos olhos (azul, verde ou castanho): ");
            String olhos = entrada.next();

            System.out.print("Digite a cor dos cabelos (louro, castanho ou preto): ");
            String cabelos = entrada.next();

            // Maior idade
            if (idade > maior) {
                maior = idade;
            }

            // Menor idade
            if (menor == 0 || idade < menor) {
                menor = idade;
            }

            // Mulheres entre 18 e 35 anos, olhos verdes e cabelos louros
            if (sexo == 'F' &&
                    idade >= 18 && idade <= 35 &&
                    olhos.equalsIgnoreCase("verde") &&
                    cabelos.equalsIgnoreCase("louro")) {

                qtd++;
            }

            System.out.print("\nDigite a idade (-1 para encerrar): ");
            idade = entrada.nextInt();
        }

        System.out.println("\nMaior idade: " + maior);
        System.out.println("Menor idade: " + menor);
        System.out.println("Quantidade de mulheres: " + qtd);

        entrada.close();
    }
}