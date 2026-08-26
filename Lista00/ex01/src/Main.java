import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int valor;
        int fatorial = 1;
        System.out.println("Informe um valor maior ou igual a 0:");
        valor = entrada.nextInt();
        while (valor < 0){
            System.out.println("O valor deve ser maior ou igual a 0:");
            valor = entrada.nextInt();
        }
        if (valor == 0) {
            fatorial = 1;
        } else {
            for (int i = 1; i <= valor; i++){
                fatorial = fatorial * i;
            }
        }
        System.out.println("Fatorial: " + fatorial);
        entrada.close();
    }
}