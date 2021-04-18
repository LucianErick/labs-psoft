package src.Situacao;


import java.text.ParseException;

import src.Classes.Usuario;
import src.Util.Util;


public class Inabilitado extends Situacao {

    public Inabilitado(Usuario usuario) {
        super(usuario);
    }

    @Override
    public String habilitarPrimeiraDose(Integer idadeMinima, String profissao, String comorbidade) throws ParseException {
        boolean idadeCorreta = false;
        boolean profissaoCorreta = false;
        boolean comorbidadeCorreta = false;
        if ((usuario.getIdadeUsuario() != null && idadeMinima == null) || ((usuario.getIdadeUsuario() != null && idadeMinima != null) && (usuario.getIdadeUsuario() >= idadeMinima))) { idadeCorreta = true; }
        if ((usuario.getProfissao() != null && profissao == null) || ((usuario.getProfissao() != null && profissao != null) && (Util.mapStringParaLista(profissao)).contains(usuario.getProfissao()))) { profissaoCorreta = true;}
        if ((usuario.getComorbidade() != null && comorbidade == null) || ((usuario.getComorbidade() != null && comorbidade != null) && (Util.mapStringParaLista(comorbidade)).contains(usuario.getComorbidade()))) { comorbidadeCorreta = true; }

        if (idadeCorreta && profissaoCorreta && comorbidadeCorreta) {
            usuario.setSituacao(new HabilitadaPrimeiraDose(usuario));
            return usuario.getSituacao().toString();
        } else {
            return this.toString();
        }
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

    public String toString() {
        return "O usuário se encontra INABILITADO para receber a vacina.";
    }

}
