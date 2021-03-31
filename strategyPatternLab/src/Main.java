package src;

public class Main {
    public static void main(String args[]) {
            Localizacao inicio = new Localizacao("114001N", "435674E");
            Localizacao fim = new Localizacao("112366S", "298387E");
            Usuario novoUsuario = new Usuario("118110400", "Luciano Figueiredo", new Localizacao("675873S", "234323E") , "(83)994116317");
            Navegacao navegacao = new Navegacao(novoUsuario.getCpf(), inicio, fim);
            navegacao.calcular();

            navegacao.mudarEstrategiaNavegacao("Carro");
            navegacao.calcular();
    }
}
