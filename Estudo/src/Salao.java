import java.util.ArrayList;

public class Salao {
    private int numero;
    private int capacaidadeMax;
    private String localizacao;
    private String tipo;    
    private ArrayList<Reserva> reservas;
    private Organizador organizador;

    public Salao(int numero, int capacaidadeMax, String localizacao, String tipo) {
        this.numero = numero;
        this.capacaidadeMax = capacaidadeMax;
        this.localizacao = localizacao;
        this.tipo = tipo;
        reservas = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public int getCapacaidadeMax() {
        return capacaidadeMax;
    }
    public void setCapacaidadeMax(int capacaidadeMax) {
        this.capacaidadeMax = capacaidadeMax;
    }
    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public ArrayList<Reserva> getReservas() {
        return reservas;
    }
    public Organizador getOrganizador(){
        return organizador;
    }
    public void setOrganizador(Organizador organizador){
        this.organizador = organizador;
    }

    public Boolean temDisponibilidadeReserva(Reserva reserva){
        for (Reserva r : reservas){
            if (r.equalsDateTime(reserva)){
                return false;
            }
        }
        return true;
    }

    public int exibirReservas(){
        int quantidade = 0;
        for (Reserva r : reservas){
            quantidade += 1;
            System.out.println(r);
        }
        return quantidade;
    }

    public int qtdReservasFinalizadas(){
        int quantidade = 0;
        for (Reserva r : reservas){
            if(r.getStatus() == 'F'){
                quantidade+=1;
            }
        }
        return quantidade;
    }

    public void atribuirReserva(Reserva reserva){
        if (temDisponibilidadeReserva(reserva)){
            reservas.add(reserva);
            reserva.setStatus('C');
            System.out.println("Reserva atribuida ao salão");
        } else {
            System.out.println("Não há disponibilidade de novas reservas para esta data e horário no salão informado.");
        }
    }

    @Override
    public String toString(){
        return "Salão: " + numero + " | Localização: " + localizacao;
    }
}
