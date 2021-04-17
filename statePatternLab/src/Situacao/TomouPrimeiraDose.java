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
            retorno = "Usuário HABILITADO para tomar a segunda dose.";
        } else {
            retorno = "Usuário INABILITADO para tomar a segunda dose.";
        }
        return retorno;
    }
    
    
    @Override
    public String habilitarPrimeiraDose(Integer idadeMinima, String profissao, String comorbidade)
    throws ParseException {
        return "Usuário já habilitado para primeira dose.";
    }
    
    @Override
    public String tomarPrimeiraDose(String dataDose) {
        return "Usuário já tomou a primeira dose.";
    }

    @Override
    public String tomarSegundaDose() {
        return "Usuário inabilitado para segunda dose";
    }
    
    @Override
    public String toString() {
        return "O usuário foi VACINADO com a PRIMEIRA DOSE.";
    }

}
