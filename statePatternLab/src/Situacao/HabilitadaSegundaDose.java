package src.Situacao;

import java.text.ParseException;

import src.Classes.Usuario;
import src.Util.Util;

public class HabilitadaSegundaDose extends Situacao{

    HabilitadaSegundaDose(Usuario usuario) {
        super(usuario);
    }

    @Override
    public String habilitarPrimeiraDose(Integer idadeMinima, String profissao, String comorbidade)
            throws ParseException {
        return Util.JA_HABILITADO_PRIMEIRA_DOSE;
    }

    @Override
    public String tomarPrimeiraDose(String dataDose) {
        return Util.JA_TOMOU_PRIMEIRA_DOSE;
    }

    @Override
    public String habilitarSegundaDose(String dataSegundaDose) {
        return Util.JA_HABILITADO_SEGUNDA_DOSE;
    }

    @Override
    public String tomarSegundaDose() {
        usuario.setSituacao(new Finalizada(usuario));
        return "Usuário tomou a segunda dose da vacina.";
    }

    @Override
    public String toString() {
        return "Usuário encontra-se HABILITADO para SEGUNDA DOSE.";
    }
    
}
