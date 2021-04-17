package src.Controladores;

import java.util.HashMap;
import java.util.Map;

import src.Classes.Vacinacao;
import src.Util.Util;

public class ControleVacinacao {
    private Map<String,Vacinacao> historicoVacinacao;

    public ControleVacinacao() {
        this.historicoVacinacao = new HashMap<String,Vacinacao>();
    }

    public void cadastrarVacina(Integer idade, String profissoes, String comorbidades) {
        if (idade.intValue() < 0 || comorbidades.length() == 0 || profissoes.length() == 0) {
            System.out.println("Uma ou mais informações está errada.");
        } else {
            int codigo = this.getHistoricoVacinacao().size() + 1;
            Vacinacao novaVacinacao = new Vacinacao(codigo, idade, profissoes, comorbidades);
            this.getHistoricoVacinacao().put(novaVacinacao.getCodigoVacinacao(), novaVacinacao);
        }
    }

    public void alterarRequisitos(String codigo, Integer idade, String profissoes, String comorbidades) {
        if (this.getHistoricoVacinacao().containsKey(codigo.toUpperCase())) {
            if (idade != null) {
                this.getHistoricoVacinacao().get(codigo.toUpperCase()).setIdadeMinima(idade);
            }
            if (!Util.anularEntradaVazia(profissoes)) {
                this.getHistoricoVacinacao().get(codigo.toUpperCase()).setProfissao(Util.mapStringParaLista(profissoes));
            }
            if (!Util.anularEntradaVazia(comorbidades)) {
                this.getHistoricoVacinacao().get(codigo.toUpperCase()).setComorbidade(Util.mapStringParaLista(comorbidades));
            }
        }
    }

    public Map<String, Vacinacao> getHistoricoVacinacao() {
        return historicoVacinacao;
    }

    public String listarVacinas() {
        String saida = "";
        for (Vacinacao vacinacao : this.getHistoricoVacinacao().values()) {
            saida += vacinacao.toString();
        }
        return saida;
    }
}
