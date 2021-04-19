package src.Classes;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import src.Controladores.ControleGeral;
import src.Controladores.ControleUsuario;
import src.Controladores.ControleVacinacao;
import src.Util.Util;

public class Menu {
    public static void main(String[] args) throws ParseException {
        exibirMenu();
    }

    public static void exibirMenu() throws ParseException {
        ControleGeral controleGeral = new ControleGeral();

        ControleUsuario controleUsuario = controleGeral.getControleUsuario();
        ControleVacinacao controleVacinacao = controleGeral.getControleVacinacao();

        Scanner input = new Scanner(System.in);
        String menuInterativo = "\n===========DIGITE A OPÇÃO==============\n"+ "(C)adastrar usuário\n" + "(L)istar usuários\n" + "(E)xibir dados usuário\n"
                + "(A)lterar dados usuário\n" + "=======================================\n" + "(R)egistrar parâmetros Vacinação\n"
                + "(I)mprimir Lista de Vacinas\n" + "=======================================\n"  + "(H)abilitar Primeira Dose da vacina para usuário\n" + "(M)inistrar Primeira Dose para usuário\n" + "(HA)bilitar Segunda dose para usuário\n" + "(MI)nistrar Segunda Dose para usuário\n" + "=======================================\n" + "(S)air\n" + "Opção> ";

        String opcao;
        do {
            System.out.print(menuInterativo);
            opcao = input.nextLine().toUpperCase();
            System.out.println();
            switch (opcao) {
                case "H":
                    System.out.print("\nDigite o cpf do usuário: ");
                    String usuarioCpf = input.nextLine();

                    System.out.print("\nDigite o código da vacina: ");
                    String vacinaCodigo = input.nextLine();
                    vacinaCodigo = vacinaCodigo.toUpperCase();

                    if (controleUsuario.getUsuarios().containsKey(usuarioCpf) && controleVacinacao.getHistoricoVacinacao().containsKey(vacinaCodigo)) {
                        Vacinacao vacinacao = controleVacinacao.getHistoricoVacinacao().get(vacinaCodigo);
                        System.out.println(controleUsuario.getUsuarios().get(usuarioCpf).habilitarPrimeiraDose(vacinacao.getIdadeMinima(), vacinacao.mapProfissoesParaString(), vacinacao.mapComorbidadesParaString()));
                    } else {
                        System.out.println("Informações inválidas.");
                    }

                    break;

                case "HA":
                    System.out.print("\nDigite o cpf do usuário: ");
                    String usuarioCpfSegundaDose = input.nextLine();

                    System.out.print("\nDigite a data: ");
                    String dataVerificacao = input.nextLine();
                    System.out.println(controleGeral.habilitarSegundaDose(usuarioCpfSegundaDose, dataVerificacao));
                    break;

                case "M":
                    System.out.print("\nDigite o cpf do usuário: ");
                    String usuarioCpfPrimeiraDose = input.nextLine();

                    System.out.print("\nDigite a data da aplicação: ");
                    String dataAplicacao = input.nextLine();

                    System.out.println(controleGeral.tomarPrimeiraDose(usuarioCpfPrimeiraDose, dataAplicacao));
                    break;

                case "MI":
                    System.out.print("\nDigite o cpf do usuário: ");
                    String usuarioCpfTomarSegundaDose = input.nextLine();
                    System.out.println(controleGeral.tomarSegundaDose(usuarioCpfTomarSegundaDose));
                    break;

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

                    System.out.print("\n|Caso não haja, digite 'nenhuma'|\nDigite a profissão: ");
                    String profissao = input.nextLine();

                    System.out.print("\n|Caso não haja, digite 'nenhuma'|\nDigite as comorbidades (separadas por vírgula): ");
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
                    System.out.print("|Caso não haja, digite 'nenhuma'|\nDigite a idade mínima exigida: ");
                    Integer idadeMinima = input.nextInt();
                    input.nextLine();
                    System.out.print("\n|Caso não haja, digite 'nenhuma'|\nDigite as profissões exigidas |separadas por ','|: ");
                    String profissoesExigidas = input.nextLine();
                    System.out.print("\n|Caso não haja, digite 'nenhuma'|\nDigite as comorbidades exigidas |separadas por ','|: ");
                    String comorbidadesExigidas = input.nextLine();

                    controleVacinacao.cadastrarVacina(idadeMinima, profissoesExigidas, comorbidadesExigidas);
                    break;

                case "I":
                    System.out.println(controleVacinacao.listarVacinas());
                    break;

                case "S":
                    System.out.println("Obrigado por utilizar o sistema.");
                    System.exit(200);
                default:
                    System.out.println("Opção inválida.");
            }
        } while (!opcao.equals("S"));
        input.close();
    }
}
