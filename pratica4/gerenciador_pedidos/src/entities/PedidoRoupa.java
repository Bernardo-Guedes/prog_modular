package entities;
import enums.Categoria;
import enums.StatusPedido;
import interfaces.Entregavel;

public class PedidoRoupa extends Pedido implements Entregavel {

    public PedidoRoupa(String id, String nomeCliente, double valor, StatusPedido status) {
        super(id, nomeCliente, valor, status, Categoria.ROUPA);
    }

    public double calcularValorFinal(){
        double valor = getValor();
        if(valor > 200){
            return valor * 0.8;
        }
        return valor;
    }

    public double calcularFrete(){ 
        return 10 + (getValor()*0.05);
    }
}
