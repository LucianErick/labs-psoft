import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        exibirMenu();
    }


    public static void exibirMenu() {
        ControleUsuario controleUsuario = new ControleUsuario();

        Scanner input = new Scanner(System.in);
        String menuInterativo = "\n(C)adastrar usuário\n"
                + "(E)xibir dados usuário\n"
                + "(A)lterar dados usuário\n"
                + "(S)air\n"
                + "Opção> ";

        String opcao;
        do {

            System.out.print(menuInterativo);
            opcao = input.nextLine().toUpperCase();
            System.out.println();
            switch (opcao) {

                case "C": // Cadastrar dados usuário
                    System.out.print("\nDigite o nome: ");
                    String nome = input.nextLine();

                    System.out.print("\nDigite o cpf: ");
                    String cpf = input.nextLine();

                    System.out.print("\nDigite o telefone: ");
                    String telefone = input.nextLine();

                    System.out.print("\nDigite o endereço: ");
                    String endereco = input.nextLine();

                    System.out.print("\nDigite o email: ");
                    String email = input.nextLine();

                    System.out.print("\nDigite o numero do cartão do SUS: ");
                    String numeroCartaoSus = input.nextLine();

                    System.out.print("\nDigite a profissão: ");
                    String profissao = input.nextLine();

                    System.out.print("\nDigite as comorbidades (separadas por vírgula): ");
                    String comorbidades = input.nextLine();

                    controleUsuario.cadastroUsuario(nome, cpf, endereco, numeroCartaoSus, email, telefone, profissao, comorbidades);
                    break;

                case "E": // exibir dados usuario
                    System.out.print("Digite o cpf: ");
                    String cpfUsuario = input.nextLine();
                    System.out.println(controleUsuario.exibirDadosUsuario(cpfUsuario));
                    break;

                case "A": // Alterar dados de cadastro
                    controleUsuario.exibicaoMudancaDadosUsuario();
                    
                    System.out.print("\nDigite o cpf do usuário: ");
                    String cpfUsuarioAlterar = input.nextLine();

                    System.out.print("\nDigite o tipo de dado: ");
                    String tipoDado = input.nextLine().toUpperCase();

                    System.out.print("\nDigite o novo dado: ");
                    String novoDado = input.nextLine();

                    controleUsuario.alterarCadastroUsuario(cpfUsuarioAlterar, tipoDado, novoDado);
                    break;

                case "L": //Listar possíveis situações

                case "S":
                default:
                    System.out.println("Opção inválida.");

            }
        } while (!opcao.equals("O"));
        input.close();
    }
}
