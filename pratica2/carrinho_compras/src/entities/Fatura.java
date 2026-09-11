package entities;

import java.util.ArrayList;

public class Fatura {
    private ArrayList<Item> itens;
    private double valor_total;

    public Fatura(){
        this.itens = new ArrayList<>();
        this.valor_total = 0;
    }

    public ArrayList<Item> getItens() {return itens;}
    public void setItens(ArrayList<Item> itens) {this.itens = itens;}
    public double getValor_total() {return valor_total;}
    public void setValor_total(double valor_total) {this.valor_total = valor_total;}

    private void calcularTotalFatura(){
        double soma = 0;
        for (int i=0; i<itens.size(); i++){
            soma = soma + itens.get(i).calcularTotalItem();
        }
        valor_total = soma;
    }

    public void exibirFatura(){
        calcularTotalFatura();
        for (Item item : itens){
            System.out.println(item + "\n");
        }
        System.out.printf("Valor total da fatura: R$ %.2f", valor_total);
        System.out.println("");
    }

    public Item verificarItem(Produto produto){
        for (Item item : itens){
            if(item.getProduto() == produto){
                return item;
            }
        }
        return null;
    }

    public void adicionarItem(Produto produto, int quantidade){
        Item item = new Item(produto, quantidade);
        itens.add(item);
    }

    public void excluirItem(Item item){
        itens.remove(item);
    }

}
