package src.Controladores;

import java.util.HashMap;
import java.util.Map;

import src.Classes.Vacinacao;

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

    public Map<String, Vacinacao> getHistoricoVacinacao() {
        return historicoVacinacao;
    }
}
