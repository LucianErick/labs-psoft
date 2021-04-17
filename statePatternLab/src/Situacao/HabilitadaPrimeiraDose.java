package src.Situacao;

import java.text.ParseException;

import src.Classes.Usuario;
import src.Util.Util;

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
    public String habilitarPrimeiraDose(Integer idadeMinima, String profissao, String comorbidade)
    throws ParseException {
        return Util.JA_HABILITADO_PRIMEIRA_DOSE;
    }
    
    @Override
    public String habilitarSegundaDose(String dataPrimeiraDose, String dataSegundaDose) {
        return Util.NAO_HABILITADO_SEGUNDA_DOSE;
    }
    
    @Override
    public String tomarSegundaDose() {
        return Util.NAO_HABILITADO_SEGUNDA_DOSE;
    }

    @Override
    public String toString() {
        return "Usuário encontra-se HABILITADO para PRIMEIRA DOSE.";
    }
}
