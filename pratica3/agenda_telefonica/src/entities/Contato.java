package entities;

import java.util.UUID;

public class Contato{
    private String id;
    private String nome;
    private String email;
    private String telefone;

    public Contato(String nome, String email, String telefone) {
        this.id = UUID.randomUUID().toString(); 
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getId(){
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void exibirContato(){
        System.out.println("Nome: " + nome + " | Telefone: " + telefone + " | E-mail: " + email);
    }
    
}