package entities;

public class Pessoa {
    private String nome;
    private String sobrenome;
    private int idade;
    private double altura;
    private double peso;
    private double imc;

    public Pessoa(String nome, String sobrenome, int idade, double altura, double peso) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
    }
    public String getNome() {
        return nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public int getIdade() {
        return idade;
    }
    public double getAltura() {
        return altura;
    }
    public double getPeso() {
        return peso;
    }
    public double getImc() {
        return imc;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public void setImc(double imc) {
        this.imc = imc;
    }

    public double CalculaIMC(){
        this.imc = this.peso/Math.pow(this.altura, 2);
        return this.imc;
    }

    public String InformaObesidade(){ // Poderia ser void que printa direto ou usando índices inteiros
        if(this.imc>40) {
            return "Obesidade grau 3";
        } else if(this.imc >= 35){
            return "Obesidade grau 2";
        } else if(this.imc >= 30){
            return "Obesidade grau 1";
        } else if(this.imc >= 25){
            return "Sobrepeso";
        } else if(this.imc >= 18.5){
            return "Peso normal";
        } else {
            return "Abaixo do peso";
        }
    }

}
