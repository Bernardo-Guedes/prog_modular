import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in, "UTF-8");

        ArrayList<Salao> saloes = criarSaloes();
        ArrayList<Organizador> organizadores = criarOrganizadores();    
        ArrayList<Reserva> reservas = new ArrayList<>();
    
        int opcao;
        while (true){
            System.out.println("=== MENU DE OPÇÕES ===");
            System.out.println("1 - Cadastrar uma nova reserva");
            System.out.println("2 - Associar um organizador a um salão");
            System.out.println("3 - Atribuir reserva a um salão");
            System.out.println("4 - Exibir todas as reservas confirmadas em um salão específico");
            System.out.println("5 - Informar a quantidade total de reservas finalizadas para cada salão");
            System.out.println("6 - Buscar reservas por status");
            System.out.println("7 - Exibir detalhes de uma reserva");
            System.out.println("0 - Finalizar e sair");
            opcao = entrada.nextInt();
            
            if(opcao == 0){
                break;
            }


            if(opcao == 1){
                System.out.println("== Nova reserva ==");
                System.out.println("Informe o código da reserva:");
                String codigo = entrada.next();
                if(existeReserva(reservas, codigo)==null){
                    System.out.println("Informe seu nome:");
                    entrada.nextLine();
                    String nome = entrada.nextLine();
                    System.out.println("Informe a data (AAAA-MM-DD):");
                    LocalDate data = LocalDate.parse(entrada.next());
                    System.out.println("Informe um horário (M - Manhã, T - Tarde, N - Noite):");
                    char horario = entrada.next().charAt(0);
                    System.out.println("Informe a quantidade de convidados:");
                    int qtdConvidados = entrada.nextInt();
                    Reserva novaReserva = new Reserva(codigo, nome, data, horario, qtdConvidados);
                    reservas.add(novaReserva);
                    System.out.println("Reserva cadastrada no sistema.");
                } else {
                    System.out.println("Já existe uma reserva com esse código.");
                }
            }
            

            if(opcao == 2){
                System.out.println("== Associar um organizador a um salão ==");

                System.out.println("Informe o nome do organizador:");
                entrada.nextLine();
                String nomeOrganizador = entrada.nextLine();
                Organizador organizador = existeOrganizador(organizadores, nomeOrganizador);
                if(organizador!=null){

                    if(organizador.getSalao() != null){
                        System.out.println("Organizador já associado a um salão.");
                        continue;
                    }

                    System.out.println("Informe o número do salão:");
                    int numeroSalao = entrada.nextInt();
                    Salao salao = existeSalao(saloes, numeroSalao);
                    if (salao!=null){

                        if (salao.getOrganizador() != null){
                            System.out.println("Salão já associado a um organizador.");
                            continue;
                        }

                        // Confirmado as validações, seta as informações
                        organizador.setSalao(salao);
                        salao.setOrganizador(organizador);
                        System.out.println("Organizador associado ao salão.");

                    } else {
                        System.out.println("Salão inexistente no sistema.");
                    }
                } else {
                System.out.println("Organizador inexistente no sistema.");
                }
            }


            if(opcao == 3){
                System.out.println("== Atribuir reserva a um salão ==");
                System.out.println("Informe o código da reserva:");
                String codigo = entrada.next();
                Reserva reserva = existeReserva(reservas, codigo);
                if (reserva != null){
                    System.out.println("Informe o número do salão:");
                    int numeroSalao = entrada.nextInt();
                    Salao salao = existeSalao(saloes, numeroSalao);
                    if (salao != null){
                        salao.atribuirReserva(reserva);
                    } else {
                        System.out.println("Salão inexistente no sistema.");
                    }
                } else {
                    System.out.println("Reserva inexistente no sistema.");
                }
            }


            if(opcao == 4){
                System.out.println("== Exibir reservas de um salão específico ==");
                System.out.println("Informe o número do salão:");
                int numeroSalao = entrada.nextInt();
                Salao salao = existeSalao(saloes, numeroSalao);
                if (salao != null){
                    int quantidade = salao.exibirReservas();
                    System.out.println("Total de reservas do salão: " + quantidade);
                } else {
                    System.out.println("Salão inexistente no sistema");
                }
            }


            if(opcao == 5){
                System.out.println("== Quantidade de reservas finalizadas para cada salão ==");
                for (Salao s : saloes){
                    System.out.println(s);
                    System.out.println("Total de reservas finalizadas: " + s.qtdReservasFinalizadas());

                }
            }


            if(opcao == 6){
                System.out.println("== Buscar reservas por status ==");
                System.out.println("Informe o status procurado: (S - Solicitada, C - Confirmada, F - Finalizada):");
                char status = entrada.next().charAt(0);
                if(status != 'S' && status != 'C' && status != 'F'){
                    System.out.println("Status informado é inválido.");
                    continue;
                }
                System.out.println("Resultado da busca:");
                for(Reserva r : reservas){
                    if(r.getStatus() == status){
                        System.out.println(r);
                    }
                }
            }

            if(opcao == 7){
                System.out.println("== Exibir detalhes de uma reserva específica ==");
                System.out.println("Informe o código da reserva desejada:");
                String codigo = entrada.next();
                Reserva reserva = existeReserva(reservas, codigo);
                if (reserva == null){
                    System.out.println("Reserva inexistente no sistema.");
                    continue;
                }
                System.out.println("Informações da reserva:");
                System.out.println(reserva);
                
            }
        }  

        entrada.close();
    }

    public static ArrayList<Salao> criarSaloes(){
        ArrayList<Salao> saloes = new ArrayList<>();
        Salao s1 = new Salao(1, 10, "Betim", "Tipo A");
        Salao s2 = new Salao(2, 15, "BH", "Tipo B");
        Salao s3 = new Salao(3, 1, "Contagem", "Tipo C");
        saloes.add(s1);
        saloes.add(s2);
        saloes.add(s3);
        return saloes;
    }

    public static ArrayList<Organizador> criarOrganizadores(){
        ArrayList<Organizador> organizadores = new ArrayList<>();
        Organizador o1 = new Organizador("Joao", "12345678900", "319912345001", "Area1");
        Organizador o2 = new Organizador("Pedro", "12345678901", "319912345002", "Area2");
        Organizador o3 = new Organizador("Carlos", "12345678902", "319912345003", "Area3");
        organizadores.add(o1);
        organizadores.add(o2);
        organizadores.add(o3);
        return organizadores;
    }

    public static Reserva existeReserva(ArrayList<Reserva> reservas, String codigo){
        for (Reserva r : reservas){
            if(r.getCodigo().equals(codigo)){
                return r;
            }

        }
        return null;
    }

    public static Organizador existeOrganizador(ArrayList<Organizador> organizadores, String nome){
        for (Organizador o : organizadores){
            if(o.getNome().equalsIgnoreCase(nome)){
                return o;
            }
        }
        return null;
    }

    public static Salao existeSalao(ArrayList<Salao> saloes, int numero){
        for (Salao s : saloes){
            if(s.getNumero() == numero){
                return s;
            }
        }
        return null;
    }

    // Validando data formatada
    public static boolean validarData(String data) {
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate dataFormatada = LocalDate.parse(data, formater);
            LocalDate dataAtual = LocalDate.now();

            if (dataFormatada.isAfter(dataAtual)) {
                return false;
            }

            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    // Criando data: LocalDate natal = LocalDate.of(2025, 12, 25);
    // Informações da data: ano -> natal.getYear(); mês -> natal.getMonth();  dia -> natal.getDayOfMonth()
    // Adicionando datas: anoNovo = natal.plusDays(6); .minusDays(); plusMonths(); .plusYears(); .getDayOfWeek()
    // Comparando datas: .isBefore(); .isAfter(); .isEqual();
    // Verifica ano Bissexto: .isLeapYear();

    // ArrayList:
    // Métodos: add, clear, contains, get, indexOf, remove, size, trimToSize    

    // HashMap<String, String> mapa = new HashMap<>();
    // mapa.put("123", "João");
    // mapa.put("456", "Maria");
    // mapa.put("789", "Pedro");
    // mapa.remove("456");

    // Percorrendo pelas chaves
    // for (String chave : mapa.keySet()){
    //   Sysout(chave + " -> " + mapa.get(chave));
    // }

    // Com entrySet
    // for(var entrada: mapa.entrySet()) { 
    //   Sysout(entrada.getKey() + " -> " + entrada.getValue());
    // }
}
