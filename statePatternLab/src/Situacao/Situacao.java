package src.Situacao;

import java.text.ParseException;

import src.Classes.Usuario;

public abstract class Situacao {
    Usuario usuario;

    Situacao(Usuario usuario) {
        this.usuario = usuario;
    }

    public abstract String habilitarPrimeiraDose(Integer idadeMinima, String profissao, String comorbidade) throws ParseException;
    public abstract String tomarPrimeiraDose(String dataDose);
    public abstract String habilitarSegundaDose(String dataSegundaDose);
    public abstract String tomarSegundaDose();
}
