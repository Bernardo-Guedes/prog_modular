package entities;

import java.time.LocalDate;

public class Aluno {
    private String nome;
    private LocalDate data_nascimento;
    private String codigoMatricula;
    private int coragem;
    private int inteligencia;
    private int ambicao;
    private int lealdade;
    private int estrategia;
    private int criatividade;
    private String casa;

    public Aluno(String nome, LocalDate data_nascimento, String codigoMatricula, int coragem, int inteligencia,
                 int ambicao, int lealdade, int estrategia, int criatividade) {
        this.nome = nome;
        this.coragem = coragem;
        this.inteligencia = inteligencia;
        this.ambicao = ambicao;
        this.lealdade = lealdade;
        this.estrategia = estrategia;
        this.criatividade = criatividade;
    }

    public String getNome() {return nome;}
    public String getCodigoMatricula() {return codigoMatricula;}
    public LocalDate getData_Nascimento() {return data_nascimento;}
    public int getCoragem() {return coragem;}
    public int getInteligencia() {return inteligencia;}
    public int getAmbicao() {return ambicao;}
    public int getLealdade() {return lealdade;}
    public int getEstrategia() {return estrategia;}
    public int getCriatividade() {return criatividade;}
    public String getCasa() {return casa;}

    public void setNome(String nome) {this.nome = nome;}
    public void setCodigoMatricula(String codigoMatricula) {this.codigoMatricula = codigoMatricula;}
    public void setData_Nascimento(LocalDate data_nascimento) {this.data_nascimento = data_nascimento;}
    public void setCoragem(int coragem) {this.coragem = coragem;}
    public void setInteligencia(int inteligencia) {this.inteligencia = inteligencia;}
    public void setAmbicao(int ambicao) {this.ambicao = ambicao;}
    public void setLealdade(int lealdade) {this.lealdade = lealdade;}
    public void setEstrategia(int estrategia) {this.estrategia = estrategia;}
    public void setCriatividade(int criatividade) {this.criatividade = criatividade;}
    public void setCasa(String casa) {this.casa = casa;}

    public void exibirInformacoes() {

        System.out.println("Nome: " + nome);
        System.out.println("Data de nascimento: " + data_nascimento);
        System.out.println("Código de matrícula: " + codigoMatricula);
        System.out.println("Coragem: " + coragem);
        System.out.println("Inteligência: " + inteligencia);
        System.out.println("Ambição: " + ambicao);
        System.out.println("Lealdade: " + lealdade);
        System.out.println("Estratégia: " + estrategia);
        System.out.println("Criatividade: " + criatividade);
        System.out.println("Casa: " + casa);
    }

    public int calcularIdade(){
        LocalDate hoje = LocalDate.now();
        int idade = hoje.getYear() - data_nascimento.getYear();
        if (hoje.getMonthValue() < data_nascimento.getMonthValue() || (hoje.getMonthValue() == data_nascimento.getMonthValue() && hoje.getDayOfMonth() < data_nascimento.getDayOfMonth())) {
            idade = idade - 1;
        }
        return idade;
    }

    public boolean maioridadeMagica(){
        if (this.calcularIdade() >= 17){
            return true;
        }
        return false;
    }

    public String gerarNomeUsuario(){
        String login = this.nome.charAt(0) + 
        return login;
    }

    public String calcularCasa() {

        int grifinoria = (2 * coragem) + lealdade;
        int sonserina = (2 * ambicao) + estrategia;
        int corvinal = (2 * inteligencia) + criatividade;
        double lufaLufa = ((2 * lealdade) + coragem) / 3.0;

        String[] casas = {
                "Grifinória",
                "Sonserina",
                "Corvinal",
                "Lufa-Lufa"
        };

        double[] pontuacoes = {
                grifinoria,
                sonserina,
                corvinal,
                lufaLufa
        };

        int maior = 0;

        for (int i = 1; i < 4; i++) {

            if (pontuacoes[i] > pontuacoes[maior]) {
                maior = i;
            }
        }

        this.casa = casas[maior];

        return this.casa;
    }
}
