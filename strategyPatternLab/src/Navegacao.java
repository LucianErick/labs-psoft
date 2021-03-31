package src;
import src.strategy.EstrategiaNavegacao;
import src.strategy.NavegacaoCarro;
import src.strategy.NavegacaoMetro;
import src.strategy.NavegacaoOnibus;
import src.strategy.NavegacaoPedestre;

public class Navegacao {
    
    private String cpfUsuario;
    private EstrategiaNavegacao navegacao;
    private Localizacao localizacaoInicial;
    private Localizacao localizacaoFinal;
    
    public Navegacao(String cpfUsuario, Localizacao localizacaoInicial,
            Localizacao localizacaoFinal) {
        this.cpfUsuario = cpfUsuario;
        this.navegacao = new NavegacaoPedestre();
        this.localizacaoInicial = localizacaoInicial;
        this.localizacaoFinal = localizacaoFinal;
    }

    public void mudarEstrategiaNavegacao(String estrategiaNavegacaoString) {
        switch (estrategiaNavegacaoString.toUpperCase()) {
            case "PEDESTRE":
                this.navegacao = new NavegacaoPedestre();
                break;
            case "ONIBUS":
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

    public String getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
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
