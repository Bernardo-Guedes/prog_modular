package entities;

public class IngressoVIP extends Ingresso{
    private boolean acessoBackstage;
    private int numeroLounge;

    public IngressoVIP (int codigo, String nomeEvento, String setor, double valorBase, boolean acessoBackstage, int numeroLounge){
        super(codigo, nomeEvento, setor, valorBase);
        this.acessoBackstage = acessoBackstage;
        this.numeroLounge = numeroLounge;
    }

    public double calcularValorFinal(){
        return getValorBase()*1.8;
    }
    
    public String obterBeneficios(){
        if (acessoBackstage){
            return "Acesso VIP e backstage. "
                    + "Lounge número " + numeroLounge;
        }
        return "Acesso VIP. Lounge número "
                + numeroLounge;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Acesso ao backstage: " + (acessoBackstage ? "Sim" : "Não"));
        System.out.println("Número do lounge: " + numeroLounge);
    }
}
