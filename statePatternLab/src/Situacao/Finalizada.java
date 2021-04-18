package src.Situacao;

import java.text.ParseException;

import src.Classes.Usuario;

public class Finalizada extends Situacao {

    Finalizada(Usuario usuario) {
        super(usuario);
    }

    @Override
    public String habilitarPrimeiraDose(Integer idadeMinima, String profissao, String comorbidade)
            throws ParseException {
        return this.toString();
    }

    @Override
    public String tomarPrimeiraDose(String dataDose) {
        return this.toString();
    }

    @Override
    public String habilitarSegundaDose(String dataSegundaDose) {
        return this.toString();
    }

    @Override
    public String tomarSegundaDose() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "Usuário finalizou o processo de vacinação.";
    }
}
