package src.Situacao;
import java.text.ParseException;

import src.Classes.Usuario;
import src.Util.*;

public class TomouPrimeiraDose extends Situacao {
    TomouPrimeiraDose(Usuario usuario) {
        super(usuario);
    }

    @Override
    public String habilitarSegundaDose(String dataPrimeiraDose, String dataVerificacao) {
        String retorno = "";
        if (Util.calcularQuantidadeDeDiasEntreDatas(dataPrimeiraDose, dataVerificacao) >= 20) {
            usuario.setSituacao(new HabilitadaSegundaDose(usuario));
            retorno = Util.HABILITADO_SEGUNDA_DOSE;
        } else {
            retorno = Util.NAO_HABILITADO_SEGUNDA_DOSE;
        }
        return retorno;
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
    public String tomarSegundaDose() {
        return Util.NAO_HABILITADO_SEGUNDA_DOSE;
    }
}
