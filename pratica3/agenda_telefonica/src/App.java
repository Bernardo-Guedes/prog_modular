import java.util.Scanner;

import entities.Agenda;
import entities.Contato;
import entities.ContatoEmergencia;
import entities.ContatoPessoal;
import entities.ContatoProfissional;

public class App {
    public static void main(String[] args) throws Exception {
        Agenda agenda = new Agenda();
        Scanner entrada = new Scanner(System.in);
        int opcao;
        do{
            System.out.println("=== Menu de Opções ===");
            System.out.println("0 - Finalizar e sair");
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Remover contato");
            System.out.println("3 - Buscar contato por nome");
            System.out.println("4 - Buscar contato por email");
            System.out.println("5 - Buscar contato por telefone");
            System.out.println("6 - Consultar tamanho da agenda");
            opcao = entrada.nextInt();
            entrada.nextLine();

            if (opcao == 0){
                break;
            }

            if (opcao == 1){
                System.out.println();
                System.out.println("== Adicionar contato ==");
                System.out.println("Informe o tipo de contato (PE - Pessoal, PR - Profissional, EM - Emergência, NE - Nenhum)");
                String tipo = entrada.nextLine();

                System.out.println("Informe o nome do contato:");
                String nome = entrada.nextLine();
                System.out.println("Informe o email do contato:");
                String email = entrada.nextLine();
                System.out.println("Informe o telefone do contato");
                String telefone = entrada.nextLine();
                Contato novoContato;
                
                if(tipo.equalsIgnoreCase("pe")){
                    System.out.println("Informe a data de aniversário do contato (DD/MM/AAA):");
                    String aniversario = entrada.nextLine();
                    System.out.println("Informe o parentesco do contato:");
                    String parentesto = entrada.nextLine();
                    novoContato = new ContatoPessoal(nome, email, telefone, aniversario, parentesto);

                } else if(tipo.equalsIgnoreCase("pr")){
                    System.out.println("Informe a empresa do contato:");
                    String empresa = entrada.nextLine();
                    System.out.println("Informe o cargo do contato:");
                    String cargo = entrada.nextLine();
                    novoContato = new ContatoProfissional(nome, email, telefone, empresa, cargo);
                    
                } else if(tipo.equalsIgnoreCase("em")){
                    System.out.println("Informe grau de prioridade do contato:");
                    int grauPrioridade = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("Informe a observação do contato:");
                    String observacao = entrada.nextLine();
                    novoContato = new ContatoEmergencia(nome, email, telefone, grauPrioridade, observacao);
                    
                } else {
                    novoContato = new Contato(nome, email, telefone);
                }

                agenda.adicionarContato(novoContato);
            }

            if (opcao == 2){
                System.out.println();
                System.out.println("== Remover contato ==");
                System.out.println("Informe o ID, Nome, Email ou Telefone do contato:");
                String aux = entrada.nextLine();
                if(agenda.removerContatoPorId(aux) || agenda.removerContatoPorNome(aux) || agenda.removerContatoPorEmail(aux) || agenda.removerContatoPorTelefone(aux)){
                    System.out.println("Contato removido da agenda.");
                } else {
                    System.out.println("Contato não encontrado para o dado informado.");
                }
            }

            if (opcao == 3){
                System.out.println();
                System.out.println("== Buscar contato por nome  ==");
                System.out.println("Informe o nome do contato:");
                String nome = entrada.nextLine();
                Contato contato = agenda.buscarContatoPorNome(nome);
                if (contato != null){
                    contato.exibirContato();
                } else {
                    System.out.println("Contato inexistente na agenda.");
                }
            }

            if (opcao == 4){
                System.out.println();
                System.out.println("== Buscar contato por email  ==");
                System.out.println("Informe o email do contato:");
                String email = entrada.nextLine();
                Contato contato = agenda.buscarContatoPorNome(email);
                if (contato != null){
                    contato.exibirContato();
                } else {
                    System.out.println("Contato inexistente na agenda.");
                }
            }

            if (opcao == 5){
                System.out.println();
                System.out.println("== Buscar contato por telefone  ==");
                System.out.println("Informe o telefone do contato:");
                String telefone = entrada.nextLine();
                Contato contato = agenda.buscarContatoPorTelefone(telefone);
                if (contato != null){
                    contato.exibirContato();
                } else {
                    System.out.println("Contato inexistente na agenda.");
                }
            }

            if (opcao == 6){
                System.out.println();
                System.out.println("== Consultar tamanho da agenda ==");
                System.out.println("Quantidade de contatos: " + agenda.getQuantidadeContatos());
            }

        } while (opcao != 0);

        entrada.close();
    }
}
