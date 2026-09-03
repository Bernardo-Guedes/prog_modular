package entities;

public class Aluno {
    private String nome;
    private int idade;
    private int coragem;
    private int inteligencia;
    private int ambicao;
    private int lealdade;
    private int estrategia;
    private int criatividade;
    private String casa;

    public Aluno(String nome, int idade, int coragem, int inteligencia,
                 int ambicao, int lealdade, int estrategia, int criatividade) {
        this.nome = nome;
        this.idade = idade;
        this.coragem = coragem;
        this.inteligencia = inteligencia;
        this.ambicao = ambicao;
        this.lealdade = lealdade;
        this.estrategia = estrategia;
        this.criatividade = criatividade;
    }

    public String getNome() {
        return nome;
    }
    public int getIdade() {
        return idade;
    }
    public int getCoragem() {
        return coragem;
    }
    public int getInteligencia() {
        return inteligencia;
    }
    public int getAmbicao() {
        return ambicao;
    }
    public int getLealdade() {
        return lealdade;
    }
    public int getEstrategia() {
        return estrategia;
    }
    public int getCriatividade() {
        return criatividade;
    }
    public String getCasa() {
        return casa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public void setCoragem(int coragem) {
        this.coragem = coragem;
    }
    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }
    public void setAmbicao(int ambicao) {
        this.ambicao = ambicao;
    }
    public void setLealdade(int lealdade) {
        this.lealdade = lealdade;
    }
    public void setEstrategia(int estrategia) {
        this.estrategia = estrategia;
    }
    public void setCriatividade(int criatividade) {
        this.criatividade = criatividade;
    }
    public void setCasa(String casa) {
        this.casa = casa;
    }

    public void exibirInformacoes() {

        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Coragem: " + coragem);
        System.out.println("Inteligência: " + inteligencia);
        System.out.println("Ambição: " + ambicao);
        System.out.println("Lealdade: " + lealdade);
        System.out.println("Estratégia: " + estrategia);
        System.out.println("Criatividade: " + criatividade);
        System.out.println("Casa: " + casa);
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
