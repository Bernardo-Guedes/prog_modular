package entities;

import enums.Categoria;
import enums.StatusPedido;
import exceptions.PedidoInvalidoException;
import exceptions.ValorInvalidoException;
import interfaces.Processavel;

public abstract class Pedido implements Processavel {
    private String id;
    private String nomeCliente;
    private double valor;
    private StatusPedido status;
    private Categoria categoria;

    public Pedido(String id, String nomeCliente, double valor, StatusPedido status, Categoria categoria) {
        this.id = id;
        this.nomeCliente = nomeCliente;

        if (valor <= 0){
            throw new ValorInvalidoException(valor);
        }

        this.valor = valor;
        this.status = status;
        this.categoria = categoria;
    }   

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        if(status == StatusPedido.CANCELADO || status == StatusPedido.ENTREGUE){
            throw new PedidoInvalidoException(status);
        }
        
        this.status = status;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void processarPedido(){
        if(status != StatusPedido.PENDENTE){
            throw new PedidoInvalidoException(status);
        }
        setStatus(StatusPedido.PROCESSANDO);
    }

    public abstract double calcularValorFinal();

    public void exibirInformacoes(){
        System.out.println("Pedido: " + getId() + " | Cliente: " + nomeCliente + " | Status: " + getStatus()
                            + " | Categoria: " + getCategoria() + " | Valor final: R$" + calcularValorFinal());
        System.out.println("-------------------------------------------------------------------------------");
    }

}
