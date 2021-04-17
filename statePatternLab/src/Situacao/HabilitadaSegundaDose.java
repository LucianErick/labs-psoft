package src.Situacao;

import java.text.ParseException;

import src.Classes.Usuario;

public class HabilitadaSegundaDose extends Situacao{

    HabilitadaSegundaDose(Usuario usuario) {
        super(usuario);
    }

    @Override
    public String habilitarPrimeiraDose(Integer idadeMinima, String profissao, String comorbidade)
            throws ParseException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String tomarPrimeiraDose(String dataDose) {
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
