package entities;

import java.util.ArrayList;

public class Bilheteria {
    private ArrayList<Ingresso> ingressos;

    public Bilheteria() {
        this.ingressos = new ArrayList<Ingresso>();
    }

    public boolean adicionarIngresso(Ingresso ingresso){

        if((ingresso==null) || (buscarIngresso(ingresso.getCodigo()) != null)){
            return false;
        }
        return ingressos.add(ingresso);
    }

    public boolean removerIngresso(int codigo){
        Ingresso ingresso = buscarIngresso(codigo);
        if (ingresso == null){
            return false;
        }
        return ingressos.remove(ingresso);

    }

    public Ingresso buscarIngresso(int codigo){
        for (Ingresso ingresso : ingressos){
            if (ingresso.getCodigo() == codigo){
                return ingresso;
            }
        } 
        return null;
    }

    public void listarIngressos(){
        for(Ingresso ingresso : ingressos){
            System.out.println("Tipo: " + ingresso.getClass().getSimpleName());
            ingresso.exibirInformacoes();
            System.out.println("--------------------------------------------------------------------------------------------");
        }
    }

    public double calcularArrecadacaoTotal(){
        double total = 0;
        for(Ingresso ingresso : ingressos){
            total += ingresso.calcularValorFinal();
        }
        return total;
    }

    public void listarBeneficios(){
        for(Ingresso ingresso : ingressos){
            System.out.println(ingresso.obterBeneficios());
            System.out.println("---------------------------------------------");
        }
    }

    
}
