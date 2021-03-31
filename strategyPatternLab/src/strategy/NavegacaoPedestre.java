package src.strategy;

public class NavegacaoPedestre implements EstrategiaNavegacao {
    @Override
    public void calcularRota(String coordenadasInicio, String coordenadasDestino) {
        String saida = String.format("Calculando a rota de Pedestre entre %s e %s...", coordenadasInicio, coordenadasDestino);
        System.out.println(saida);
    }
}
