package entities;
import enums.Categoria;
import enums.StatusPedido;
import interfaces.Entregavel;

public class PedidoEletronico extends Pedido implements Entregavel {

    public PedidoEletronico(String id, String nomeCliente, double valor, StatusPedido status) {
        super(id, nomeCliente, valor, status, Categoria.ELETRONICO);
    }

    public double calcularValorFinal(){
        double valor = getValor();
        if(valor > 100){
            return valor * 0.9;
        }
        return valor;
    }

    public double calcularFrete(){ 
        return 20 + (getValor()*0.1);
    }
}
