package src.Situacao;


import java.text.ParseException;

import src.Classes.Usuario;
import src.Util.Util;


public class Inabilitado extends Situacao {

    Inabilitado(Usuario usuario) {
        super(usuario);
    }

    @Override
    public String habilitarPrimeiraDose(Integer idadeMinima, String profissao, String comorbidade) throws ParseException {
        boolean idadeCorreta = false;
        boolean profissaoCorreta = false;
        boolean comorbidadeCorreta = false;
        if ((usuario.getIdadeUsuario() != null && idadeMinima == null) || ((usuario.getIdadeUsuario() != null && idadeMinima != null) && (usuario.getIdadeUsuario() >= idadeMinima))) { idadeCorreta = true; }
        if ((usuario.getProfissao() != null && profissao == null) || ((usuario.getProfissao() != null && profissao != null) && (Util.mapStringParaLista(profissao)).contains(usuario.getProfissao()))) { profissaoCorreta = true;}
        if ((usuario.getComorbidades() != null && comorbidade == null) || ((usuario.getComorbidades() != null && comorbidade != null) && (Util.mapStringParaLista(comorbidade)).contains(usuario.getComorbidades()))) { comorbidadeCorreta = true; }

        if (idadeCorreta && profissaoCorreta && comorbidadeCorreta) {
            usuario.setSituacao(new HabilitadaPrimeiraDose(usuario));
            return usuario.getSituacao().toString();
        } else {
            return this.toString();
        }
    }

    public String toString() {
        return "O usuário se encontra INABILITADO para receber a vacina.";
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
