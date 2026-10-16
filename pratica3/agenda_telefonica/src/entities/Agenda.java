package entities;

import java.util.ArrayList;

public class Agenda {
    private ArrayList<Contato> contatos;
    private int quantidadeContatos;

    public Agenda() {
        this.contatos = new ArrayList<Contato>();
        this.quantidadeContatos = 0;
    }

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }

    public int getQuantidadeContatos() {
        return quantidadeContatos;
    }

    public void setQuantidadeContatos(int quantidadeContatos) {
        this.quantidadeContatos = quantidadeContatos;
    }

    public void adicionarContato(Contato contato){
        contatos.add(contato);
        quantidadeContatos += 1;
        System.out.println("Contato adicionado na agenda.");
    }

    public Boolean removerContatoPorId(String id){
        Contato contato = buscarContatoPorId(id);
        if (contato != null){
            contatos.remove(contato);
            return true;
        }
        return false;
    }

    public Boolean removerContatoPorNome(String nome){
        Contato contato = buscarContatoPorNome(nome);
        if (contato != null){
            contatos.remove(contato);
            return true;
        }
        return false;
    }

    public Boolean removerContatoPorEmail(String email){
        Contato contato = buscarContatoPorEmail(email);
        if (contato != null){
            contatos.remove(contato);
            return true;
        }
        return false;
    }

    public Boolean removerContatoPorTelefone(String telefone){
        Contato contato = buscarContatoPorTelefone(telefone);
        if (contato != null){
            contatos.remove(contato);
            return true;
        }
        return false;
    }

    public Contato buscarContatoPorId(String id){
        for (Contato contato : contatos){
            if (contato.getId().equals(id)){
                return contato;
            }
        }
        return null;
    }

    public Contato buscarContatoPorNome(String nome){
        for (Contato contato : contatos){
            if (contato.getNome().equals(nome)){
                return contato;
            }
        }
        return null;
    }

    public Contato buscarContatoPorEmail(String email){
        for (Contato contato : contatos){
            if (contato.getEmail().equals(email)){
                return contato;
            }
        }
        return null;
    }

    public Contato buscarContatoPorTelefone(String telefone){
        for (Contato contato : contatos){
            if (contato.getTelefone().equals(telefone)){
                return contato;
            }
        }
        return null;
    }

    

    
}
