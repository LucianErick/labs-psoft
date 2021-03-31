package src;
import src.strategy.EstrategiaNavegacao;
import src.strategy.NavegacaoCarro;
import src.strategy.NavegacaoMetro;
import src.strategy.NavegacaoOnibus;
import src.strategy.NavegacaoPedestre;

public class Navegacao {
    
    private EstrategiaNavegacao navegacao;
    private Localizacao localizacaoInicial;
    private Localizacao localizacaoFinal;
    
    public Navegacao(Localizacao localizacaoInicial,
            Localizacao localizacaoFinal, String estrategiaNavegacao) {
        mudarEstrategiaNavegacao(estrategiaNavegacao);
        this.localizacaoInicial = localizacaoInicial;
        this.localizacaoFinal = localizacaoFinal;
    }

    public Navegacao(Localizacao localizacaoInicial, Localizacao localizacaoFinal) {
        this.localizacaoInicial = localizacaoInicial;
        this.localizacaoFinal = localizacaoFinal;
    }    

    public void mudarEstrategiaNavegacao(String estrategiaNavegacaoString) {
        switch (estrategiaNavegacaoString.toUpperCase()) {
            case "PEDESTRE":
                this.navegacao = new NavegacaoPedestre();
                break;
            case ("ONIBUS"):
                this.navegacao = new NavegacaoOnibus();
                break;
            case "CARRO":
                this.navegacao = new NavegacaoCarro();
                break;
            case "METRO":
                this.navegacao = new NavegacaoMetro();
                break;
        }
    }

    public void calcular() {
        this.navegacao.calcularRota(this.getLocalizacaoInicial().toString(), this.getLocalizacaoFinal().toString());
    }

    public EstrategiaNavegacao getNavegacao() {
        return navegacao;
    }

    public void setNavegacao(EstrategiaNavegacao navegacao) {
        this.navegacao = navegacao;
    }

    public Localizacao getLocalizacaoInicial() {
        return localizacaoInicial;
    }

    public void setLocalizacaoInicial(Localizacao localizacaoInicial) {
        this.localizacaoInicial = localizacaoInicial;
    }

    public Localizacao getLocalizacaoFinal() {
        return localizacaoFinal;
    }

    public void setLocalizacaoFinal(Localizacao localizacaoFinal) {
        this.localizacaoFinal = localizacaoFinal;
    }
}
