package src.Classes;

import src.Situacao.Inabilitado;
import src.Situacao.Situacao;
import src.Util.Util;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Usuario {

    private String nome; 
    private String cpf;
    private String dataNascimento;
    private String endereco;
    private String numeroCartaoSus;
    private String email;
    private String telefone;
    private String profissao;
    private List<String> comorbidades;
    private Situacao situacao;
    
    public Usuario(String nome, String cpf, String dataNascimento, String endereco, String numeroCartaoSus, String email, String telefone,
            String profissao, String comorbidades) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.numeroCartaoSus = numeroCartaoSus;
        this.email = email;
        this.telefone = telefone;
        this.profissao = profissao;
        this.comorbidades = mapComorbidades(comorbidades);
        this.situacao = new Inabilitado(this);
    }

    public Integer getIdadeUsuario() throws ParseException {
        Date data = Util.mapStringParaDate(this.dataNascimento);
        return Util.calcularIdade(data);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumeroCartaoSus() {
        return numeroCartaoSus;
    }

    public void setNumeroCartaoSus(String numeroCartaoSus) {
        this.numeroCartaoSus = numeroCartaoSus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public List<String> mapComorbidades(String comorbidades) {
        List<String> listaComorbidades = new ArrayList<String>();
        for (String comorbidade : comorbidades.replaceAll(" ", "").split(",")) {
            listaComorbidades.add(comorbidade);
        }
        return listaComorbidades;
    }
    
    public String getComorbidades() {
        String saida = "";
        for (String string : this.comorbidades) {
            saida += string + " ";
        }
        return saida;
    }
    
    public void setComorbidades(List<String> comorbidades) {
        this.comorbidades = comorbidades;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void alterarDado(String dado, String novoDado) {
        switch(dado) {
            case "A":
                this.setNome(novoDado);
                break;
            case "B":
                this.setEmail(novoDado);
                break;
            case "C":
                this.setEndereco(novoDado);
                break;
            case "D":
                this.setNumeroCartaoSus(novoDado);
                break;
            case "E":
                this.setProfissao(novoDado);
                break;
            case "F":
                this.setTelefone(novoDado);
                break;
            case "G":
                this.setComorbidades(this.mapComorbidades(novoDado));
                break;
            case "H":
                this.setDataNascimento(novoDado);
            default:
                System.out.println("Opção inválida.");
        }
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
        return String.format("Nome: %s - CPF: %s - Telefone: %s - Endereço: %s - Email: %s - Número do Cartão do SUS: %s - Profissão: %s - Comorbidades: [%s]", this.nome, this.cpf, this.telefone, this.endereco, this.email, this.numeroCartaoSus, this.profissao, this.getComorbidades());
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }
}
