package src.strategy;

public class NavegacaoOnibus implements EstrategiaNavegacao{
    @Override
    public void calcularRota(String coordenadasInicio, String coordenadasDestino) {
        String saida = String.format("Calculando a rota de Ônibus entre %s e %s...", coordenadasInicio, coordenadasDestino);
        System.out.println(saida);
    }
}
