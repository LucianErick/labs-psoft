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
        return "Usuário já habilitado para primeira dose";
    }

    @Override
    public String tomarPrimeiraDose(String dataDose) {
        return "Usuário já tomou a primeira dose";
    }

    @Override
    public String habilitarSegundaDose(String dataPrimeiraDose, String dataSegundaDose) {
        return "Usuário já habilitado para segunda dose.";
    }

    @Override
    public String tomarSegundaDose() {
        usuario.setSituacao(new Finalizada(usuario));
        return "Usuário tomou a segunda dose da vacina.";
    }
    
}
