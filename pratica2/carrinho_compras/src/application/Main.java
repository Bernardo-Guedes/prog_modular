import entities.Fatura;
import entities.Produto;
import entities.Item;

import java.util.Scanner;

public static void main(String[] args){
    Scanner entrada = new Scanner(System.in);
    ArrayList<Produto> produtos = new ArrayList<>();
    produtos.add(new Produto("Arroz", "ABC001", 18.90));
    produtos.add(new Produto("Feijão", "DEF002", 15.60));
    produtos.add(new Produto("Macarrão", "GHI003", 5.75));
    produtos.add(new Produto("Farinha", "JKL004", 2.68));
    produtos.add(new Produto("Leite", "MNO005", 4.96));
    Fatura fatura = new Fatura();

    int opcao;
    while(true){
        System.out.println("========== MENU DE OPÇÕES ==========");
        System.out.println("1 - Comprar");
        System.out.println("2 - Ver fatura");
        System.out.println("3 - Excluir item");
        System.out.println("4 - Alterar item");
        System.out.println("5 - Finalizar compra");
        opcao = entrada.nextInt();

        if(opcao == 1){
            System.out.println("=== Produtos cadastrados ===");
            for (int i = 0; i<produtos.size(); i++){
                System.out.println(produtos.get(i));
            }
            System.out.println("1 - Informar o código do produto desejado:");
            System.out.println("Qualquer número - Voltar para o menu");
            opcao = entrada.nextInt();
            if(opcao == 1){
                System.out.println("Informe o código do produto:");
                String codigo = entrada.next();
                Produto produtoEscolhido = getProduto(codigo, produtos);
                if(produtoEscolhido == null){
                    System.out.println("Produto não cadastrado no estoque!");
                    continue;
                }
                System.out.println("Produto escolhido:\n" + produtoEscolhido + "\nInforme a quantidade desejada:");
                int qtd = entrada.nextInt();

                if (fatura.verificarItem(produtoEscolhido) != null){
                    fatura.verificarItem(produtoEscolhido).adicionarQtd(qtd);
                } else {
                    fatura.adicionarItem(produtoEscolhido, qtd);
                }
                System.out.println("");
            } else {
                continue;
            }
        }

        if (opcao == 2){
            System.out.println("=== Fatura Atual ===");
            fatura.exibirFatura();
            System.out.println("");
        }

        if (opcao == 3){
            System.out.println("=== Exclusão de item ===");
            System.out.println("1 - Informar o código do produto a ser excluido da fatura:");
            System.out.println("Qualquer número - Voltar para o menu");
            opcao = entrada.nextInt();

            if (opcao == 1){
                System.out.println("Informe o código do produto:");
                String codigo = entrada.next();
                Produto produtoRemover = getProduto(codigo, produtos);
                Item itemRemover  = fatura.verificarItem(produtoRemover);
                if (itemRemover != null){
                    fatura.excluirItem(itemRemover);
                } else {
                    System.out.println("Produto não existe na fatura!");
                    continue;
                }
                System.out.println("");
            } else {
                continue;
            }

        }

        if (opcao == 4){
            System.out.println("=== Alteração de quantidade de item ===");
            System.out.println("1 - Informar o código do produto a ser alterado na fatura:");
            System.out.println("Qualquer número - Voltar para o menu");
            opcao = entrada.nextInt();
            if(opcao == 1){
                System.out.println("Informe o código do produto:");
                String codigo = entrada.next();
                Produto produtoAlterar = getProduto(codigo, produtos);
                Item itemAlterar  = fatura.verificarItem(produtoAlterar);
                if (itemAlterar != null){
                    System.out.println("Informe a operação: Adicionar (A) ou Remover (R):");
                    char operacao = entrada.next().charAt(0);
                    if (operacao == 'A'){
                        System.out.println("Informe a quantidade a ser adicionada:");
                        int quantidade = entrada.nextInt();
                        itemAlterar.adicionarQtd(quantidade);
                    } else if (operacao == 'R'){
                        System.out.println("Informe a quantidade a ser removida:");
                        int quantidade = entrada.nextInt();
                        itemAlterar.removerQtd(quantidade);
                    } else {
                        System.out.println("Operação inválida!");
                        continue;
                    }

                } else {
                    System.out.println("Produto não existe na fatura!");
                    continue;
                }
                System.out.println("");
            } else {
                continue;
            }
        }

        if (opcao == 5){
            System.out.println("=== Finalização da compra");
            fatura.exibirFatura();
            break;
        }


    }

}

public static Produto getProduto(String codigo, ArrayList<Produto> produtos){
    for (int i=0; i<produtos.size(); i++){
        if(produtos.get(i).getCodigo().equals(codigo)){
            return produtos.get(i);
        }
    }
    return null;
}