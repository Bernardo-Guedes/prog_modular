import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import entities.Pedido;
import entities.PedidoAlimento;
import entities.PedidoEletronico;
import entities.PedidoRoupa;
import enums.Categoria;
import enums.StatusPedido;
import exceptions.PedidoInvalidoException;
import exceptions.ValorInvalidoException;
import interfaces.Entregavel;

public class App {

    public static final Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        while(true){
            int opcao = menu();
            switch(opcao){
                case 1: { 

                    Pedido novoPedido = op1(); if (novoPedido != null) {
                        pedidos.add(novoPedido);
                        System.out.println("Pedido cadastrado com sucesso!");
                    }
                    break; 
                }

                case 2: { op2(pedidos); break; }
                case 3: { op3(pedidos); break; }
                case 4: { op4(pedidos); break; }
                case 5: { op5(pedidos); break; }
                case 6: { op6(pedidos); break; }
                case 7: { return; }
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static int menu(){
        int opcao;
        System.out.println("=== MENU DE OPÇÕES ===");
        System.out.println("1 - Cadastrar pedido");
        System.out.println("2 - Alterar status de um pedido"); 
        System.out.println("3 - Processar pedido");
        System.out.println("4 - Remover cancelados");
        System.out.println("5 - Exibir lista de pedidos");
        System.out.println("6 - Exibir pedidos entregáveis");
        System.out.println("7 - Encerrar");
        opcao = entrada.nextInt();
        entrada.nextLine();
        return opcao;
    }

    public static Pedido op1(){

        System.out.println("== Cadastrar pedido ==");

        System.out.println("Informe o nome do cliente: ");
        String nome = entrada.nextLine();

        System.out.println("Informe o ID do pedido");
        String id = entrada.nextLine();

        System.out.print("Informe o valor do pedido: ");
        double valor = entrada.nextDouble();
        entrada.nextLine();

        Categoria[] categorias = Categoria.values();
        System.out.println("Informe a categoria do pedido:");

        for (int i = 1; i < categorias.length; i++){
            System.out.println(i + " " + categorias[i-1]);
        }

        System.out.println("Categoria: ");
        int tipo = entrada.nextInt();
        entrada.nextLine();

        if (tipo < 1 || tipo > categorias.length) {
            System.out.println("Categoria inválida!");
            return null;
        }

        Categoria categoriaEscolhida = categorias[tipo - 1];

        try {
            Pedido novoPedido;
        
            switch (categoriaEscolhida) {
                case ALIMENTO:
                    novoPedido = new PedidoAlimento(id, nome, valor, StatusPedido.PENDENTE);
                    break;
                case ELETRONICO:
                    novoPedido = new PedidoEletronico(id, nome, valor, StatusPedido.PENDENTE);
                    break;
                case ROUPA:
                    novoPedido = new PedidoRoupa(id, nome, valor, StatusPedido.PENDENTE);
                    break;
                default:
                    System.out.println("Opção inválida");
                    return null;
            }

            return novoPedido;

        } catch (ValorInvalidoException e) {
            System.out.println("Erro ao cadastrar pedido: " + e.getMessage());
            return null;
        }

    }

    public static void op2(ArrayList<Pedido> pedidos){
        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos cadastrados!");
            return;
        }

        System.out.print("Informe o ID do pedido: ");
        String id = entrada.nextLine();

        Pedido pedidoInformado = null;

        for (Pedido p : pedidos) {
            if (p.getId() == id) {
                pedidoInformado = p;
                break;
            }
        }

        if (pedidoInformado == null) {
            System.out.println("Pedido não encontrado!");
            return;
        }

        StatusPedido[] statusExistentes = StatusPedido.values();

        System.out.println("Selecione o novo status:");

        for (int i = 1; i < statusExistentes.length; i++) {
            System.out.println(i + " - " + statusExistentes[i-1]);
        }

        System.out.print("Status: ");
        int status = entrada.nextInt();
        entrada.nextLine();

        if (status < 1 || status > statusExistentes.length) {
            System.out.println("Opção inválida!");
            return;
        }

        StatusPedido novoStatus = statusExistentes[status - 1];

        try {
            pedidoInformado.setStatus(novoStatus);
            System.out.println("Status alterado com sucesso!");
        } catch (PedidoInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void op3(ArrayList<Pedido> pedidos){
        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos cadastrados!");
            return;
        }

        Iterator<Pedido> it = pedidos.iterator();
        while (it.hasNext()){
            Pedido pedido = it.next();
            try{
                pedido.processarPedido();

                System.out.println(
                    "Processando pedido: " + pedido.getId()
                    + " | Status atual: "  + pedido.getStatus()
                );

            } catch (PedidoInvalidoException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void op4(ArrayList<Pedido> pedidos){
        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos cadastrados!");
            return;
        }
        Iterator<Pedido> it = pedidos.iterator();
        int removidos = 0;
        while (it.hasNext()) {
            Pedido pedido = it.next();

            if (pedido.getStatus() == StatusPedido.CANCELADO) {
                it.remove();
                removidos++;
            }
        }
        System.out.println(
            removidos + " pedido(s) cancelado(s) removido(s)."
        );
        
    }

    public static void op5(ArrayList<Pedido> pedidos){
        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos cadastrados!");
            return;
        }
        boolean encontrouPedido = false;
        for (Pedido pedido : pedidos) {
            if (pedido.getStatus() != StatusPedido.CANCELADO) {
                pedido.exibirInformacoes();
                encontrouPedido = true;
            }
        }

        if (!encontrouPedido) {
            System.out.println("Não há pedidos não cancelados para exibir.");
        }
        
    }

    public static void op6(ArrayList<Pedido> pedidos){

        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos cadastrados!");
            return;
        }
        boolean encontrouPedido = false;
        for (Pedido pedido : pedidos) {
            if (pedido instanceof Entregavel) {
                pedido.exibirInformacoes();
                encontrouPedido = true;
            }
        }

        if (!encontrouPedido) {
            System.out.println("Não há pedidos não cancelados para exibir.");
        }
    }
}
