package src.Controladores;

import src.Classes.Vacinacao;
import src.Util.Util;

import java.text.ParseException;

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

    public String habilitarPrimeiraDose(String cpfUsuario, String codigoVacina) throws ParseException {
        if (!this.getControleUsuario().getUsuarios().containsKey(cpfUsuario) || !this.getControleVacinacao().getHistoricoVacinacao().containsKey(codigoVacina.toUpperCase())) {
            return "Usuário ou Processo de vacinação não encontrado.";
        }
        Vacinacao vacina = this.getControleVacinacao().getHistoricoVacinacao().get(codigoVacina);
        return this.controleUsuario.getUsuarios().get(cpfUsuario).habilitarPrimeiraDose(vacina.getIdadeMinima(), vacina.getProfissao().toString(), vacina.getComorbidade().toString());
    };
    public String tomarPrimeiraDose(String cpfUsuario, String dataDose) {
        if (!this.getControleUsuario().getUsuarios().containsKey(cpfUsuario)) {
            return Util.ERRO_USUARIO_NAO_ENCONTRADO;
        }
        return this.controleUsuario.getUsuarios().get(cpfUsuario).tomarPrimeiraDose(dataDose);
    }
    public String habilitarSegundaDose(String cpfUsuario, String dataVerificacao) {
        if (!this.getControleUsuario().getUsuarios().containsKey(cpfUsuario)) {
            return Util.ERRO_USUARIO_NAO_ENCONTRADO;
        }
        return this.controleUsuario.getUsuarios().get(cpfUsuario).habilitarSegundaDose(dataVerificacao);
    }
    public String tomarSegundaDose(String cpfUsuario) {
        if (!this.getControleUsuario().getUsuarios().containsKey(cpfUsuario)) {
            return Util.ERRO_USUARIO_NAO_ENCONTRADO;
        }
        return this.controleUsuario.getUsuarios().get(cpfUsuario).tomarSegundaDose();
    }
}
