package src.Classes;
import java.util.List;

import src.Util.*;

public class Vacinacao {
    private String codigoVacinacao;
    private Integer idadeMinima;
    private List<String> profissao;
    private List<String> comorbidade;
    
    public Vacinacao(int codigo, Integer idade, String profissao, String comorbidade) {
        this.codigoVacinacao = String.format("VAC-%d", codigo);
        this.idadeMinima = idade;
        this.profissao = Util.mapStringParaLista(profissao);
        this.comorbidade = Util.mapStringParaLista(comorbidade);
    }

    public String getCodigoVacinacao() {
        return codigoVacinacao;
    }

    public void setCodigoVacinacao(String codigoVacinacao) {
        this.codigoVacinacao = codigoVacinacao;
    }

    public Integer getIdadeMinima() {
        return idadeMinima;
    }

    public void setIdadeMinima(Integer idadeMinima) {
        this.idadeMinima = idadeMinima;
    }

    public List<String> getProfissao() {
        return profissao;
    }

    public void setProfissao(List<String> profissao) {
        this.profissao = profissao;
    }

    public List<String> getComorbidade() {
        return comorbidade;
    }

    public void setComorbidade(List<String> comorbidade) {
        this.comorbidade = comorbidade;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigoVacinacao == null) ? 0 : codigoVacinacao.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vacinacao other = (Vacinacao) obj;
        if (codigoVacinacao == null) {
            if (other.codigoVacinacao != null)
                return false;
        } else if (!codigoVacinacao.equals(other.codigoVacinacao))
            return false;
        return true;
    }    
}
