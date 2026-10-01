import java.time.LocalDate;

public class Reserva {
    private String codigo;
    private String nomeCliente;
    private LocalDate data;
    private char horario;
    private int qtdConvidados;
    private char status;
    private double valorTotal;
    private Salao salao;

    public Reserva(String codigo, String nomeCliente, LocalDate data, char horario, int qtdConvidados) {
        this.codigo = codigo;
        this.nomeCliente = nomeCliente;
        this.data = data;
        this.horario = horario;
        this.qtdConvidados = qtdConvidados;
        this.status = 'S';
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public char getHorario() {
        return horario;
    }
    public void setHorario(char horario) {
        this.horario = horario;
    }
    public int getQtdConvidados() {
        return qtdConvidados;
    }
    public void setQtdConvidados(int qtdConvidados) {
        this.qtdConvidados = qtdConvidados;
    }
    public char getStatus() {
        return status;
    }
    public void setStatus(char status) {
        this.status = status;
    }
    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public Salao getSalao(){
        return salao;
    }
    public void setSalao(Salao salao){
        this.salao = salao;
    }

    public Boolean equalsDateTime(Reserva reserva){
        if ((this.data.equals(reserva.getData())) && (this.horario == reserva.getHorario())){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Reserva: " + codigo + " | Cliente: " + nomeCliente + " | Data: " + data + " | Horário: " + horario;
    }
}
