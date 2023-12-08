package trabalho_disciplina;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Programa {
    private static Consulta consulta = new Consulta("01/01/2023", "Paciente X");
    private static ArrayList<Remedio> remediosCadastrados = new ArrayList<>();
    private static HashMap<String, String> tiposUnidade = new HashMap<>();
    private static final String ARQUIVO_CONSULTA = "consulta.txt";
    private static final String ARQUIVO_REMEDIOS = "remedios.txt";
    private static final String ARQUIVO_TIPOS_UNIDADE = "tiposUnidade.txt";

    public static void main(String[] args) {
        carregarDadosDosArquivos(); // Carregar dados ao iniciar o programa
        geraMenu();
        salvarDadosEmArquivos(); // Salvar dados ao sair do programa
    }

    public static void geraMenu() {
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar nova consulta");
            System.out.println("2. Editar dados da consulta");
            System.out.println("3. Apagar consulta atual");
            System.out.println("4. Inserir Remédio na consulta");
            System.out.println("5. Apresentar os dados da Consulta");
            System.out.println("6. Listar os dados dos remédios presentes nessa consulta");
            System.out.println("7. Cadastrar um novo Remédio");
            System.out.println("8. Editar um Remédio");
            System.out.println("9. Listar os remédios cadastrados");
            System.out.println("10. Criar um novo tipo de unidade");
            System.out.println("11. Listar os tipos de unidades já cadastradas");
            System.out.println("12. Apagar os dados");
            System.out.println("13. Carregar os dados dos arquivos");
            System.out.println("14. Sair");

            try {
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                
                // Limpa o buffer do scanner
                scanner.nextLine();
        
                if (opcao >= 1 && opcao <= 14) {
                    switch (opcao) {
                        case 1:
                            cadastrarNovaConsulta();
                            break;
                        case 2:
                            editarDadosConsulta();
                            break;
                        case 3:
                            apagarConsultaAtual();
                            break;
                        case 4:
                            inserirRemedioNaConsulta();
                            break;
                        case 5:
                            apresentarDadosConsulta();
                            break;
                        case 6:
                            listarRemediosNaConsulta();
                            break;
                        case 7:
                            cadastrarNovoRemedio();
                            break;
                        case 8:
                            editarRemedio();
                            break;
                        case 9:
                            listarRemediosCadastrados();
                            break;
                        case 10:
                            criarNovoTipoUnidade();
                            break;
                        case 11:
                            listarTiposUnidadesCadastradas();
                            break;
                        case 12:
                            apagarDados();
                            break;
                        case 13:
                            carregarDadosDosArquivos();
                            break;
                        case 14:
                            System.out.println("Saindo do programa. Até logo!");
                            break;
                    }
                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida. Insira um número.");
                // Limpa o buffer do scanner em caso de erro
                scanner.nextLine();
                opcao = -1; // Define uma opção inválida para continuar o loop
            } catch (Exception e) { 
                System.out.println("Ocorreu um erro inesperado. Saindo do programa.");
                opcao = 14; // Sair do loop em caso de erro inesperado
            }
        } while (opcao != 14);

        // Fechar o scanner
        scanner.close();
    }

    public static void cadastrarNovaConsulta() {
        Scanner scanner = new Scanner(System.in);
    
        do {
            System.out.println("Cadastrar Nova Consulta:");
    
            // Solicita informações ao usuário
            System.out.print("Data da consulta (DD/MM/AAAA): ");
            String dataConsulta = scanner.next();
    
            // Valida a data
            if (validarFormatoData(dataConsulta)) {
                // Continua o restante do código
                consulta.setData(dataConsulta);
    
                System.out.print("Nome do paciente: ");
                String nomePaciente = scanner.next();
                consulta.setPaciente(nomePaciente);
    
                System.out.println("Consulta cadastrada com sucesso!");
            } else {
                System.out.println("Formato de data inválido. Tente novamente.");
            }
    
            // Pergunta se o usuário deseja cadastrar outra consulta
            System.out.print("Deseja cadastrar outra consulta? (S/N): ");
        } while (scanner.next().equalsIgnoreCase("S"));
    
        scanner.close();
    }

    public static void editarDadosConsulta() {
        Scanner scanner = new Scanner(System.in);

        // Solicita as informações atualizadas ao usuário
        System.out.print("Nova data da consulta (DD/MM/AAAA): ");
        String novaDataConsulta = scanner.next();
        if (validarFormatoData(novaDataConsulta)) {
            consulta.setData(novaDataConsulta);
        } else {
            System.out.println("Formato de data inválido. Os dados não foram modificados.");
        }

        System.out.print("Novo nome do paciente: ");
        String novoNomePaciente = scanner.next();
        consulta.setPaciente(novoNomePaciente);

        System.out.println("Consulta editada com sucesso!");
        scanner.close();
    }

    public static void apagarConsultaAtual() {
        // Implemente a lógica para apagar a consulta atual
        // Por exemplo, você pode reinicializar a consulta com dados padrão
        consulta = new Consulta("01/01/2023", "Paciente X");
        
        System.out.println("Consulta apagada com sucesso!");
    }

    public static void inserirRemedioNaConsulta() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Inserir Remédio na Consulta:");
        
        // Mostra os dados atuais da consulta
        apresentarDadosConsulta();
        
        // Solicita informações sobre o remédio ao usuário
        System.out.print("Nome do remédio: ");
        String nomeRemedio = scanner.next();
        
        System.out.print("Tipo do remédio: ");
        String tipoRemedio = scanner.next();
        
        // Cria um novo remédio e insere na consulta
        Remedio novoRemedio = new Remedio(nomeRemedio, tipoRemedio);
        consulta.getRemedios().add(novoRemedio);
        
        System.out.println("Remédio inserido na consulta com sucesso!");

        scanner.close();
    }
    
    public static void apresentarDadosConsulta() {
        System.out.println("Apresentar os dados da Consulta:");
        
        // Mostra os dados atuais da consulta
        System.out.println("Data: " + consulta.getData());
        System.out.println("Paciente: " + consulta.getPaciente());
    }
    
    public static void listarRemediosNaConsulta() {
        System.out.println("Listar os dados dos remédios presentes nessa consulta:");
        
        // Mostra os remédios presentes na consulta
        for (Remedio remedio : consulta.getRemedios()) {
            System.out.println("Nome: " + remedio.getNome() + ", Tipo: " + remedio.getTipo());
        }
    }
    
    public static void cadastrarNovoRemedio() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Cadastrar Novo Remédio:");
        
        // Solicita informações ao usuário
        System.out.print("Nome do remédio: ");
        String nomeRemedio = scanner.next();
        
        System.out.print("Tipo do remédio: ");
        String tipoRemedio = scanner.next();
        
        // Cria um novo remédio e adiciona à lista de remédios cadastrados
        Remedio novoRemedio = new Remedio(nomeRemedio, tipoRemedio);
        remediosCadastrados.add(novoRemedio);
        
        System.out.println("Remédio cadastrado com sucesso!");
        scanner.close();
    }
    
    public static void editarRemedio() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Editar um Remédio:");
        
        // Mostra os remédios cadastrados
        System.out.println("Remédios cadastrados:");
        for (Remedio remedio : remediosCadastrados) {
            System.out.println("Nome: " + remedio.getNome() + ", Tipo: " + remedio.getTipo());
        }
        
        // Solicita o nome do remédio a ser editado
        System.out.print("Digite o nome do remédio a ser editado: ");
        String nomeRemedio = scanner.next();
        
        // Busca o remédio pelo nome na lista de remédios cadastrados
        Remedio remedioParaEditar = null;
        for (Remedio remedio : remediosCadastrados) {
            if (remedio.getNome().equals(nomeRemedio)) {
                remedioParaEditar = remedio;
                break;
            }
        }
        
        if (remedioParaEditar != null) {
            // Solicita as informações atualizadas ao usuário
            System.out.print("Novo nome do remédio: ");
            String novoNomeRemedio = scanner.next();
            remedioParaEditar.setNome(novoNomeRemedio);
        
            System.out.print("Novo tipo do remédio: ");
            String novoTipoRemedio = scanner.next();
            remedioParaEditar.setTipo(novoTipoRemedio);
        
            System.out.println("Remédio editado com sucesso!");
        } else {
            System.out.println("Remédio não encontrado. Tente novamente.");
        }

        scanner.close();
    }
    
    public static void listarRemediosCadastrados() {
        System.out.println("Listar os remédios cadastrados:");
        
        // Mostra os remédios cadastrados
        for (Remedio remedio : remediosCadastrados) {
            System.out.println("Nome: " + remedio.getNome() + ", Tipo: " + remedio.getTipo());
        }
    }

    public static void criarNovoTipoUnidade() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Criar um novo tipo de unidade:");
        
        // Solicita informações ao usuário
        System.out.print("Chave do novo tipo de unidade: ");
        String chave = scanner.next();
        
        System.out.print("Valor do novo tipo de unidade: ");
        String valor = scanner.next();
        
        // Adiciona ao HashMap de tipos de unidade
        tiposUnidade.put(chave, valor);
        
        System.out.println("Novo tipo de unidade criado com sucesso!");

        scanner.close();
    }

    public static void listarTiposUnidadesCadastradas() {
        System.out.println("Tipos de unidades cadastradas:");
        for (String chave : tiposUnidade.keySet()) {
            System.out.println("Chave: " + chave + ", Valor: " + tiposUnidade.get(chave));
        }
    }

    public static void apagarDados() {
        consulta = new Consulta("01/01/2023", "Paciente X");
        remediosCadastrados.clear();
        tiposUnidade.clear();
        System.out.println("Dados apagados com sucesso!");
    }

    public static void carregarDadosDosArquivos() {
        carregarDadosArquivoConsulta();
        carregarDadosArquivoRemedios();
        carregarDadosArquivoTiposUnidade();
    }
    
    public static void salvarDadosEmArquivos() {
        salvarDadosArquivoConsulta();
        salvarDadosArquivoRemedios();
        salvarDadosArquivoTiposUnidade();
    }

    private static void carregarDadosArquivoConsulta() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_CONSULTA))) {
            String data = reader.readLine();
            String paciente = reader.readLine();
            consulta = new Consulta(data, paciente);
        } catch (IOException e) {
            System.out.println("Erro ao carregar dados da consulta do arquivo.");
        }
    }

    private static void salvarDadosArquivoConsulta() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_CONSULTA))) {
            writer.write(consulta.getData());
            writer.newLine();
            writer.write(consulta.getPaciente());
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados da consulta no arquivo.");
        }
    }

    private static void carregarDadosArquivoRemedios() {
        remediosCadastrados.clear(); // Limpa a lista antes de carregar
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_REMEDIOS))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                Remedio remedio = new Remedio(partes[0], partes[1]);
                remediosCadastrados.add(remedio);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar dados dos remédios do arquivo.");
        }
    }

    private static void salvarDadosArquivoRemedios() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_REMEDIOS))) {
            for (Remedio remedio : remediosCadastrados) {
                writer.write(remedio.getNome() + "," + remedio.getTipo());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados dos remédios no arquivo.");
        }
    }

    private static void carregarDadosArquivoTiposUnidade() {
        tiposUnidade.clear(); // Limpa o HashMap antes de carregar
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_TIPOS_UNIDADE))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                tiposUnidade.put(partes[0], partes[1]);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar dados dos tipos de unidade do arquivo.");
        }
    }

    private static void salvarDadosArquivoTiposUnidade() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_TIPOS_UNIDADE))) {
            for (String chave : tiposUnidade.keySet()) {
                writer.write(chave + "," + tiposUnidade.get(chave));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados dos tipos de unidade no arquivo.");
        }
    }

    private static boolean validarFormatoData(String data) {
        if (data == null || data.isEmpty()) {
            System.out.println("Data não pode ser nula ou vazia.");
            return false;
        }

        // Padrão de data desejado (DD/MM/AAAA)
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        try {
            // Tenta fazer o parsing da data
            dateFormat.parse(data);
            return true;
        } catch (ParseException e) {
            System.out.println("Formato de data inválido. Use o formato DD/MM/AAAA.");
            return false;
        }
    }
}
