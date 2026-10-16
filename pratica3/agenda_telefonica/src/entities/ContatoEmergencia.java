package entities;

public class ContatoEmergencia extends Contato {
    private int grauPrioridade;
    private String observacao;

    public ContatoEmergencia(String nome, String email, String telefone, int grauPrioridade, String observacao) {
        super(nome, email, telefone); 

        if (grauPrioridade < 1 || grauPrioridade > 5) {
            throw new IllegalArgumentException("O grau de prioridade deve estar entre 1 e 5.");
        }
        
        this.grauPrioridade = grauPrioridade;
        this.observacao = observacao;
    }

    public int getGrauPrioridade() {
        return grauPrioridade;
    }

    public void setGrauPrioridade(int grauPrioridade) {
        this.grauPrioridade = grauPrioridade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override 
    public void exibirContato(){
        super.exibirContato();
        System.out.println("Grau de prioridade: " + grauPrioridade + " | Observação: " + observacao);
    }
}
