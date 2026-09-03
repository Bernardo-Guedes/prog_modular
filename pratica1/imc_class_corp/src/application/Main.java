import java.util.Scanner;
import entities.Pessoa;

public static void main(String[] args){
    Scanner entrada = new Scanner(System.in);
    String nome, sobrenome;
    int idade;
    double altura, peso;

    System.out.println("Informe seu nome: ");
    nome = entrada.next();
    System.out.println("Informe seu sobrenome: ");
    sobrenome = entrada.next();
    System.out.println("Informe sua idade: ");
    idade = entrada.nextInt();
    System.out.println("Informe sua altura: ");
    altura =  entrada.nextDouble();
    System.out.println("Informe seu peso: ");
    peso = entrada.nextDouble();
    Pessoa p1 = new Pessoa(nome, sobrenome, idade, altura, peso);
    p1.CalculaIMC();
    System.out.println("IMC Calculado - "+p1.getNome()+": "+p1.getImc());
    System.out.println("Faixa de massa corporal: "+p1.InformaObesidade());
}