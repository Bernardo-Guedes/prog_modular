package entities;
import enums.Categoria;
import enums.StatusPedido;

public class PedidoAlimento extends Pedido{

    public PedidoAlimento(String id, String nomeCliente, double valor, StatusPedido status) {
        super(id, nomeCliente, valor, status, Categoria.ALIMENTO);
    }

    public double calcularValorFinal(){
        return getValor();
    }
}
