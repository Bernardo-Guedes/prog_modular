package entities;

public class Item {
    private Produto produto;
    private int qtd;
    private double valor_total;

    public Item(Produto produto, int qtd) {
        this.produto = produto;
        this.qtd = qtd;
        this.valor_total = calcularTotalItem();
    }
    public Item(){}

    public Produto getProduto() {return produto;}
    public void setProduto(Produto produto) {this.produto = produto;}
    public int getQtd() {return qtd;}
    public void setQtd(int qtd) {this.qtd = qtd;}
    public double getValor_total() {return valor_total;}
    public void setValor_total(float valor_total) {this.valor_total = valor_total;}

    public double calcularTotalItem(){
        valor_total = produto.getPreco()*qtd;
        return valor_total;
    }

    public void adicionarQtd(int qtdAdd){
        setQtd(getQtd()+qtdAdd);
        calcularTotalItem();
    }

    public void removerQtd(int qtdRemove){
        setQtd((getQtd()-qtdRemove));
        calcularTotalItem();
    }

    public String toString(){
        return String.format("Item: %s\nQuantidade: %d   | Valor total do item: R$ %.2f",
                produto,
                qtd,
                valor_total
        );

    }

}
