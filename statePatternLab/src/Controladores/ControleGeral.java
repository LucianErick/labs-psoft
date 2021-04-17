package src.Controladores;

public class ControleGeral {
    private ControleUsuario controleUsuario;
    private ControleVacinacao controleVacinacao;

    public ControleGeral() {
        this.controleUsuario = new ControleUsuario();
        this.controleVacinacao = new ControleVacinacao();
    }

    public ControleUsuario getControleUsuario() {
        return controleUsuario;
    }

    public ControleVacinacao getControleVacinacao() {
        return controleVacinacao;
    }
}
