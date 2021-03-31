package src;

import java.util.HashMap;
import java.util.Map;

public class Usuario {
    private String cpf;
    private String nome;
    private String telefone;
    private Map<String, Localizacao> locaisSalvos;

    public Usuario(String cpf, String nome, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.locaisSalvos = new HashMap<String, Localizacao>();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Map<String, Localizacao> getLocaisSalvos() {
        return locaisSalvos;
    }

    public void setLocaisSalvos(Map<String, Localizacao> locaisSalvos) {
        this.locaisSalvos = locaisSalvos;
    }

    public String salvarLocal(String nome, String coordenadaLat, String coordenadaLong) {
        if (!this.getLocaisSalvos().containsKey(nome.toUpperCase())) {
            this.locaisSalvos.put(nome.toUpperCase(), new Localizacao(nome, coordenadaLat, coordenadaLong));
            return "Local cadastrado com sucesso!";
        }
        return "Nome de local já existente. Não foi possível cadastrar.";
    }

    public String exibirLocaisSalvos() {
        String saida = "";
        if (this.getLocaisSalvos().size() != 0) {
            for (Localizacao localizacao : this.getLocaisSalvos().values()) {
                saida += localizacao.toString() + "\n";
            }
        } else {
            saida = "Sem locais salvos.";
        }
    return saida;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
        Usuario other = (Usuario) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Usuario [cpf=" + cpf + ", nome=" + nome + ", telefone=" + telefone
                + "]";
    }
}