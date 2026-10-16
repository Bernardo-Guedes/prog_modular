import java.util.Scanner;

import entities.Bilheteria;
import entities.Ingresso;
import entities.IngressoComum;
import entities.IngressoEstudante;
import entities.IngressoVIP;

public class App {

    private static final Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        Bilheteria b = new Bilheteria();

        while(true){
            int opc = menu();
            switch(opc){
                case 0: entrada.close(); return;
                case 1: opc1(b); break;
                case 2: opc2(b); break;
                case 3: opc3(b); break;
                case 4: opc4(b); break;
                case 5: opc5(b); break;
                case 6: opc6(b); break;
                default: System.out.println("Opção inválida");
            }
        }
    }

    public static int menu(){
        System.out.println("=== MENU DE OPÇÕES ===");
        System.out.println("0 - Finalizar e sair");
        System.out.println("1 - Cadastrar ingresso");
        System.out.println("2 - Remover ingresso");
        System.out.println("3 - Buscar ingresso por código");
        System.out.println("4 - Listar todos os ingressos");
        System.out.println("5 - Calcular arrecadação total");
        System.out.println("6 - Listar benefícios dos ingressos");
        int opcao = entrada.nextInt();
        entrada.nextLine();
        return opcao;
    }

    public static void opc1(Bilheteria b){
        System.out.println();
        System.out.println("== Cadastrar ingresso ==");
        System.out.println("Qual tipo do ingresso");
        System.out.println("C - Comum, E - Estudante, V - VIP");
        char tipo = entrada.next().charAt(0);
        entrada.nextLine();

        if (tipo != 'C' && tipo != 'E' && tipo != 'v'){
            System.out.println("Digite  um tipo válido!");
            return;
        }

        System.out.println("Digite o código do ingresso: ");
        int codigo = entrada.nextInt();
        entrada.nextLine();

        if (b.buscarIngresso(codigo) != null) {
            System.out.println("Já existe um ingresso cadastrado com o código " + codigo + "!");
            return;
        }

        System.out.println("Digite o nome do evento: ");
        String nomeEvento = entrada.nextLine();

        System.out.println("Digite o setor: ");
        String setor = entrada.nextLine();

        System.out.println("Digite o valor base (R$): ");
        double valorBase = entrada.nextDouble();
        entrada.nextLine();

        if (valorBase <= 0) {
            System.out.println("Valor base deve ser maior que zero!");
            return;
        }

        Ingresso ingresso;
        if (tipo == 'C') {
            ingresso = new IngressoComum(codigo, nomeEvento, setor, valorBase);
        } else if (tipo == 'E') {
            System.out.println("Digite a instituição de ensino: ");
            String instituicao = entrada.nextLine();
            ingresso = new IngressoEstudante(codigo, nomeEvento, setor, valorBase, instituicao);
        } else {
            System.out.println("Possui acesso ao backstage? (s/n): ");
            boolean backstage = entrada.next().toLowerCase().charAt(0) == 's';
            entrada.nextLine();

            System.out.println("Digite o número da lounge: ");
            int lounge = entrada.nextInt();
            entrada.nextLine();

            ingresso = new IngressoVIP(codigo, nomeEvento, setor, valorBase, backstage, lounge);
        }

        if (b.adicionarIngresso(ingresso)) {
            System.out.println("Ingresso cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar o ingresso!");
        }
    }

    public static void opc2(Bilheteria b){
        System.out.println();
        System.out.println("== Remover ingresso ==");
        System.out.println("Digite o código do ingresso que você deseja remover: ");
        int codigo = entrada.nextInt();
        entrada.nextLine();

        if (b.removerIngresso(codigo)) {
            System.out.println("Exclusão bem sucedida!");
        } else {
            System.out.println("Ingresso com código " + codigo + " não encontrado!");
        }
    }

    public static void opc3(Bilheteria b){
        System.out.println();
        System.out.println("== Buscar ingresso por código ==");
        System.out.println("Digite o código do ingresso: ");
        int codigo = entrada.nextInt();
        entrada.nextLine();

        Ingresso ingresso = b.buscarIngresso(codigo);

        if (ingresso != null) {
            ingresso.exibirInformacoes();
            System.out.println("Tipo: " + ingresso.getClass().getSimpleName());
        } else {
            System.out.println("Ingresso com código " + codigo + " não encontrado!");
        }
        
    }

    public static void opc4(Bilheteria b){
        System.out.println();
        System.out.println("== Listar ingressos ==");
        b.listarIngressos();
    }

    public static void opc5(Bilheteria b){
        System.out.println();
        System.out.println("== Calcular arrecadação total ==");
        System.out.println("Arrecadação total: R$" + String.format("%.2f", b.calcularArrecadacaoTotal()));
    }

    public static void opc6(Bilheteria b){
        System.out.println();
        System.out.println("== Listar benefícios dos ingressos ==");
        b.listarBeneficios();
    }
}