package src.strategy;

public class NavegacaoCarro implements EstrategiaNavegacao {
    @Override
    public void calcularRota(String coordenadasInicio, String coordenadasDestino) {
        String saida = String.format("Calculando a rota de Carro entre %s e %s...", coordenadasInicio, coordenadasDestino);
        System.out.println(saida);
    }
}
