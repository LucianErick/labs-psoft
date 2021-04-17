package src.Situacao;

import java.text.ParseException;

import src.Classes.Usuario;

public class HabilitadaPrimeiraDose extends Situacao{
    HabilitadaPrimeiraDose(Usuario usuario) {
        super(usuario);
    }

    @Override
    public String tomarPrimeiraDose(String dataDose) {
        usuario.setSituacao(new TomouPrimeiraDose(usuario));
        return String.format("Foi aplicada a primeira dose de Vacina no dia %s", dataDose);
    }

    @Override
    public String toString() {
        return "Usuário encontra-se HABILITADO para PRIMEIRA DOSE.";
    }

    @Override
    public String habilitarPrimeiraDose(Integer idadeMinima, String profissao, String comorbidade)
            throws ParseException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String habilitarSegundaDose(String dataPrimeiraDose, String dataSegundaDose) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String tomarSegundaDose() {
        // TODO Auto-generated method stub
        return null;
    }
}
