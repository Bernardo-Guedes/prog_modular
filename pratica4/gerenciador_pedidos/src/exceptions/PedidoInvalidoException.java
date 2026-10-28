package exceptions;

import enums.StatusPedido;

public class PedidoInvalidoException extends IllegalStateException {
    
    private StatusPedido status;

    public PedidoInvalidoException(StatusPedido status){
        super("Status atual do pedido: " + status + ". Status inválido para a operção solicitada");
        this.status = status;
    }

    public StatusPedido getStatus(){
        return status;
    }
    
}
