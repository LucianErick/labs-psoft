package src.Classes;

import java.util.Scanner;

import src.Controladores.ControleGeral;
import src.Controladores.ControleUsuario;
import src.Controladores.ControleVacinacao;
import src.Util.Util;

public class Menu {
    public static void main(String[] args) {
        exibirMenu();
    }

    public static void exibirMenu() {
        ControleGeral controleGeral = new ControleGeral();

        ControleUsuario controleUsuario = controleGeral.getControleUsuario();
        ControleVacinacao controleVacinacao = controleGeral.getControleVacinacao();

        Scanner input = new Scanner(System.in);
        String menuInterativo = "\n(C)adastrar usuário\n" + "(L)istar usuários\n" + "(E)xibir dados usuário\n"
                + "(A)lterar dados usuário\n" + "(R)egistrar parâmetros Vacinação\n"
                + "(M)odificar parâmetros Vacinação\n" + "(I)mprimir Lista de Vacinas\n" + "(S)air\n" + "Opção> ";

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

                System.out.print("\nDigite a data de nascimento: ");
                String dataNascimento = input.nextLine();

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

                controleUsuario.cadastroUsuario(nome, cpf, dataNascimento, endereco, numeroCartaoSus, email, telefone,
                        profissao, comorbidades);
                break;

            case "E": // exibir dados usuario
                System.out.print("Digite o cpf: ");
                String cpfUsuario = input.nextLine();
                System.out.println(controleUsuario.exibirDadosUsuario(cpfUsuario));
                break;

            case "A": // Alterar dados de cadastro
                
                System.out.println(controleUsuario.exibicaoMudancaDadosUsuario());

                System.out.print("\nDigite o cpf do usuário: ");
                String cpfUsuarioAlterar = input.nextLine();

                System.out.print("\nDigite o tipo de dado: ");
                String tipoDado = input.nextLine().toUpperCase();

                System.out.print("\nDigite o novo dado: ");
                String novoDado = input.nextLine();

                controleUsuario.alterarCadastroUsuario(cpfUsuarioAlterar, tipoDado, novoDado);
                break;

            case "L": // Listar Usuários
                System.out.print(controleUsuario.listarUsuarios());
                break;

            case "R": // Registrar vacinação
                System.out.print("|não obrigatório|\nDigite a idade mínima exigida: ");
                Integer idadeMinima = input.nextInt();
                input.nextLine();
                System.out.print("\n|não obrigatório|\nDigite as profissões exigidas |separadas por ','|: ");
                String profissoesExigidas = input.nextLine();
                System.out.print("\n|não obrigatório|\nDigite as comorbidades exigidas |separadas por ','|: ");
                String comorbidadesExigidas = input.nextLine();

                controleVacinacao.cadastrarVacina(idadeMinima, profissoesExigidas, comorbidadesExigidas);
                break;
            case "M": // modificar vacinação
                System.out.println("Digite o código da vacinação: ");    
                String codigoVacinacao = input.nextLine();

                System.out.println("não obrigatório\nDigite a idade mínima exigida: ");
                Integer idadeMinimaModificada = input.nextInt();
                input.next();
                
                System.out.println("não obrigatório\nDigite as profissões exigidas |separadas por ','|: ");
                String profissoesExigidasModificada = input.nextLine();
                
                System.out.println("não obrigatório\nDigite as comorbidades exigidas |separadas por ','|: ");
                String comorbidadesExigidasModificada = input.nextLine();

                controleVacinacao.alterarRequisitos(codigoVacinacao, idadeMinimaModificada, profissoesExigidasModificada, comorbidadesExigidasModificada);
                break;

            //FIXME: erro ao imprimir
            case "I":
                System.out.println(controleVacinacao.listarVacinas());
                break;
            
            case "S":
                System.out.println("Obrigado por utilizar o sistema.");    
                System.exit(200);

            default:
                System.out.println("Opção inválida.\n");
            }
        } while (!opcao.equals("O"));
        input.close();
    }
}
