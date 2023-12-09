package trabalho_disciplina;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Programa {
    private static ArrayList<Pessoa> pessoas = new ArrayList<>();
    private static HashMap<String, Pessoa> mapaPessoas = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        geraMenu();
    }

    public static void geraMenu() {
        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar nova pessoa");
            System.out.println("2. Editar dados da pessoa");
            System.out.println("3. Apagar pessoa");
            System.out.println("4. Consultar pessoa");
            System.out.println("5. Listar todas as pessoas");
            System.out.println("6. Criar novo tipo de endereço");
            System.out.println("7. Listar tipos de endereço");
            System.out.println("8. Consultar endereço de uma pessoa");
            System.out.println("9. Listar todas as pessoas com seus endereços");
            System.out.println("10. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarPessoa();
                    break;
                case 2:
                    editarPessoa();
                    break;
                case 3:
                    apagarPessoa();
                    break;
                case 4:
                    consultarPessoa();
                    break;
                case 5:
                    listarPessoas();
                    break;
                case 6:
                    criarTipoEndereco();
                    break;
                case 7:
                    listarTiposEndereco();
                    break;
                case 8:
                    consultarEnderecoPessoa();
                    break;
                case 9:
                    listarPessoasComEnderecos();
                    break;
                case 10:
                    System.out.println("Saindo do programa. Até mais!");
                    fecharScanner();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 10);
    }

    public static void cadastrarPessoa() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Cadastrar Nova Pessoa:");
    
        // Solicitar informações da pessoa
        System.out.print("Nome: ");
        String nome = scanner.nextLine().trim(); // Remover espaços em branco extras
        while (nome.isEmpty()) {
            System.out.print("Nome não pode ser vazio. Digite novamente: ");
            nome = scanner.nextLine().trim();
        }
    
        System.out.print("Idade: ");
        int idade = -1;
        while (idade <= 0) {
            try {
                idade = Integer.parseInt(scanner.nextLine());
                if (idade <= 0) {
                    System.out.print("Idade deve ser um número positivo. Digite novamente: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Idade inválida. Digite novamente: ");
            }
        }
    
        // Solicitar informações do endereço
        System.out.print("Rua: ");
        String rua = scanner.nextLine();
    
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
    
        System.out.print("Estado: ");
        String estado = scanner.nextLine();
    
        // Criar objeto Endereco com as informações fornecidas
        Endereco endereco = new Endereco(rua, cidade, estado);
    
        // Criar objeto Pessoa com as informações fornecidas
        Pessoa novaPessoa = new Pessoa(nome, idade, endereco);
    
        // Adicionar pessoa à lista e ao mapa
        pessoas.add(novaPessoa);
        mapaPessoas.put(nome, novaPessoa);
    
        System.out.println("Pessoa cadastrada com sucesso!\n");
    }    
    
    public static void editarPessoa() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Editar Dados da Pessoa:");
    
        // Solicitar o nome da pessoa a ser editada
        System.out.print("Digite o nome da pessoa a ser editada: ");
        String nomeEditar = scanner.nextLine().trim();
    
        // Verificar se a pessoa existe no mapa
        if (mapaPessoas.containsKey(nomeEditar)) {
            // Obter a pessoa a ser editada
            Pessoa pessoaEditar = mapaPessoas.get(nomeEditar);
    
            // Solicitar novas informações
            System.out.print("Novo nome: ");
            String novoNome = scanner.nextLine().trim();
            while (novoNome.isEmpty()) {
                System.out.print("Nome não pode ser vazio. Digite novamente: ");
                novoNome = scanner.nextLine().trim();
            }
            pessoaEditar.setNome(novoNome);
    
            System.out.print("Nova idade: ");
            int novaIdade = -1;
            while (novaIdade <= 0) {
                try {
                    novaIdade = Integer.parseInt(scanner.nextLine());
                    if (novaIdade <= 0) {
                        System.out.print("Idade deve ser um número positivo. Digite novamente: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Idade inválida. Digite novamente: ");
                }
            }
            pessoaEditar.setIdade(novaIdade);
    
            System.out.println("Dados da pessoa editados com sucesso!\n");
        } else {
            System.out.println("Pessoa não encontrada.\n");
        }
    }    
    
    public static void apagarPessoa() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Apagar Pessoa:");
    
        // Solicitar o nome da pessoa a ser apagada
        System.out.print("Digite o nome da pessoa a ser apagada: ");
        String nomeApagar = scanner.nextLine().trim();
    
        // Verificar se o nome é válido
        while (nomeApagar.isEmpty()) {
            System.out.print("Nome não pode ser vazio. Digite novamente: ");
            nomeApagar = scanner.nextLine().trim();
        }
    
        // Verificar se a pessoa existe no mapa
        if (mapaPessoas.containsKey(nomeApagar)) {
            // Remover pessoa da lista e do mapa
            Pessoa pessoaApagar = mapaPessoas.get(nomeApagar);
            pessoas.remove(pessoaApagar);
            mapaPessoas.remove(nomeApagar);
    
            System.out.println("Pessoa apagada com sucesso!\n");
        } else {
            System.out.println("Pessoa não encontrada.\n");
        }
    }
     
    public static void consultarPessoa() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Consultar Pessoa:");
    
        // Solicitar o nome da pessoa a ser consultada
        System.out.print("Digite o nome da pessoa a ser consultada: ");
        String nomeConsultar = scanner.nextLine().trim();
    
        // Verificar se o nome é válido
        while (nomeConsultar.isEmpty()) {
            System.out.print("Nome não pode ser vazio. Digite novamente: ");
            nomeConsultar = scanner.nextLine().trim();
        }
    
        // Verificar se a pessoa existe no mapa
        if (mapaPessoas.containsKey(nomeConsultar)) {
            // Obter e exibir informações da pessoa
            Pessoa pessoaConsultar = mapaPessoas.get(nomeConsultar);
            System.out.println("Nome: " + pessoaConsultar.getNome());
            System.out.println("Idade: " + pessoaConsultar.getIdade());
            System.out.println("Endereço: " + pessoaConsultar.getEndereco().getRua() + ", " +
                    pessoaConsultar.getEndereco().getCidade() + ", " +
                    pessoaConsultar.getEndereco().getEstado() + "\n");
        } else {
            System.out.println("Pessoa não encontrada.\n");
        }
    }
    
    public static void listarPessoas() {
        System.out.println("Listar Todas as Pessoas:");
    
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.\n");
        } else {
            for (Pessoa pessoa : pessoas) {
                System.out.println("Nome: " + pessoa.getNome());
                System.out.println("Idade: " + pessoa.getIdade());
                
                // Verificar se o endereço é nulo antes de acessar seus atributos
                if (pessoa.getEndereco() != null) {
                    System.out.println("Endereço: " + pessoa.getEndereco().getRua() + ", " +
                            pessoa.getEndereco().getCidade() + ", " +
                            pessoa.getEndereco().getEstado() + "\n");
                } else {
                    System.out.println("Endereço não disponível.\n");
                }
            }
        }
    }    

    public static void criarTipoEndereco() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Criar Novo Tipo de Endereço:");
    
        // Solicitar informações do novo tipo de endereço
        System.out.print("Nome do novo tipo de endereço: ");
        String novoTipoEndereco = scanner.nextLine().trim();
    
        // Verificar se o nome do tipo de endereço é válido
        while (novoTipoEndereco.isEmpty()) {
            System.out.print("Nome do tipo de endereço não pode ser vazio. Digite novamente: ");
            novoTipoEndereco = scanner.nextLine().trim();
        }
    
        // Adicionar o novo tipo de endereço ao HashMap
        EnderecoTipo.adicionarTipoEndereco(novoTipoEndereco);
    
        System.out.println("Novo tipo de endereço criado com sucesso!\n");
    }    
    
    public static void listarTiposEndereco() {
        System.out.println("Listar Tipos de Endereço:");
    
        ArrayList<String> tiposEndereco = EnderecoTipo.getTiposEndereco();
    
        if (tiposEndereco.isEmpty()) {
            System.out.println("Nenhum tipo de endereço cadastrado.\n");
        } else {
            for (String tipo : tiposEndereco) {
                System.out.println(tipo);
            }
            System.out.println();
        }
    }
    
    public static void consultarEnderecoPessoa() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Consultar Endereço de uma Pessoa:");

        // Solicitar o nome da pessoa para consultar o endereço
        System.out.print("Digite o nome da pessoa: ");
        String nomeConsultar = scanner.nextLine().trim();

        // Verificar se o nome é válido
        while (nomeConsultar.isEmpty()) {
            System.out.print("Nome não pode ser vazio. Digite novamente: ");
            nomeConsultar = scanner.nextLine().trim();
        }

        // Verificar se a pessoa existe no mapa
        if (mapaPessoas.containsKey(nomeConsultar)) {
            // Obter e exibir informações do endereço da pessoa
            Pessoa pessoaConsultar = mapaPessoas.get(nomeConsultar);
            if (pessoaConsultar.getEndereco() != null) {
                System.out.println("Endereço de " + pessoaConsultar.getNome() + ":");
                System.out.println("Rua: " + pessoaConsultar.getEndereco().getRua());
                System.out.println("Cidade: " + pessoaConsultar.getEndereco().getCidade());
                System.out.println("Estado: " + pessoaConsultar.getEndereco().getEstado() + "\n");
            } else {
                System.out.println("Endereço não disponível.\n");
            }
        } else {
            System.out.println("Pessoa não encontrada.\n");
        }
    }

    public static void listarPessoasComEnderecos() {
        System.out.println("Listar Todas as Pessoas com Seus Endereços:");
    
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.\n");
        } else {
            for (Pessoa pessoa : pessoas) {
                System.out.println("Nome: " + pessoa.getNome());
                System.out.println("Idade: " + pessoa.getIdade());
                
                // Verificar se o endereço é nulo antes de acessar seus atributos
                if (pessoa.getEndereco() != null) {
                    System.out.println("Endereço: ");
                    System.out.println("  Rua: " + pessoa.getEndereco().getRua());
                    System.out.println("  Cidade: " + pessoa.getEndereco().getCidade());
                    System.out.println("  Estado: " + pessoa.getEndereco().getEstado() + "\n");
                } else {
                    System.out.println("Endereço não disponível.\n");
                }
            }
        }
    }

    public static void fecharScanner() {
        scanner.close();
    }
}
