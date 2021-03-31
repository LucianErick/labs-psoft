package src;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        exibirMenu();    
    }
    
    public static void exibirMenu() {
        Scanner input = new Scanner(System.in);
        
        String menuInterativo = "\n(S)alvar local\n"
                + "(E)xibir locais salvos\n"
                + "(C)alcular rota\n"
                + "(M)udar meio de transporte\n"
                + "(O)ra, vamos fechar o programa!\n"
                + "Opção> ";

        String opcao;
        Usuario usuarioAplicacao = new Usuario("118100000", "Usuário Master do sistema", "(00)987654321");
        Navegacao navegacao = new Navegacao(null, null, "Pedestre");
        
        do {

            System.out.print(menuInterativo);
            opcao = input.nextLine().toUpperCase();
            System.out.println();
            switch (opcao) {

                case "S":
                System.out.print("Digite um nome para o local (Um nome fácil de lembrar): ");
                String nomeLocal = input.nextLine();

                System.out.print("Digite a coordenada de latitude (Use o formato 'xx.xxxxxx'): ");
                String coordenadaLat = input.nextLine();

                System.out.print("Digite a coordenada de longitude (Use o formato 'xx.xxxxxx'): ");
                String coordenadaLong = input.nextLine();

                usuarioAplicacao.salvarLocal(nomeLocal.toUpperCase(), coordenadaLat, coordenadaLong);
                break;
                
                case "E":
                    System.out.println(usuarioAplicacao.exibirLocaisSalvos());
                    break;

                case "C":
                System.out.print("Digite o nome do local de inicio: ");
                String nomeInicio = input.nextLine();

                System.out.print("Digite o nome do local de destino: ");
                String nomeDestino = input.nextLine();

                if (usuarioAplicacao.getLocaisSalvos().containsKey(nomeInicio.toUpperCase()) 
                && 
                usuarioAplicacao.getLocaisSalvos().containsKey(nomeDestino.toUpperCase())) {
                    
                    navegacao.setLocalizacaoInicial(usuarioAplicacao.getLocaisSalvos().get(nomeInicio.toUpperCase()));
                    navegacao.setLocalizacaoFinal(usuarioAplicacao.getLocaisSalvos().get(nomeDestino.toUpperCase()));
                    
                    System.out.print("\n");
                    navegacao.calcular();
                } else { 
                    System.out.println("\nNome de local não cadastrado.");
                }
                    break;

                case "M":
                    System.out.print("Digite o nome do meio de transporte (PEDESTRE, CARRO, METRO OU ONIBUS): ");
                    String meioTransporteEstrategia = input.nextLine();
                    if (navegacao != null) {
                        navegacao.mudarEstrategiaNavegacao(meioTransporteEstrategia);
                        System.out.println("\nMeio de transporte alterado para " + meioTransporteEstrategia.toUpperCase());
                    } else {
                        System.out.println("Calcule a rota antes!");
                    }
                    break;
                case "O":
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (!opcao.equals("O"));
        input.close();
    }
}
