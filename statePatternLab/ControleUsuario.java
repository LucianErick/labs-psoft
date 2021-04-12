import java.util.HashMap;
import java.util.Map;

public class ControleUsuario {
    private Map<String, Usuario> usuarios;

    public ControleUsuario() {
        this.usuarios = new HashMap<String, Usuario>();
    }

    public Map<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public void cadastroUsuario(String nome, String cpf, String endereco, String numeroCartaoSus, String email,
            String telefone, String profissao, String comorbidades) {
        if (cpf == null || cpf.length() != 11 || cpf.trim().isEmpty()) {
            System.out.println("Cadastro não realizado. Alguma informação está inválida.");
        } else {
            Usuario novoUsuario = new Usuario(nome, cpf, endereco, numeroCartaoSus, email, telefone, profissao,
                    comorbidades);
            this.getUsuarios().put(cpf, novoUsuario);
            System.out.println("Usuário cadastrado com sucesso.");
        }
    }

    public String exibicaoMudancaDadosUsuario() {
        return "Nome - A, E-mail - B, Endereço - C, Nº Cartão SUS - D, Profissão - E, F - Telefone, H - Comorbidades";
    }

    public void alterarCadastroUsuario(String cpfUsuario, String nomeDado, String novoDado) {
        if (this.getUsuarios().containsKey(cpfUsuario)) {
            Usuario usuario = this.getUsuarios().get(cpfUsuario);
            usuario.alterarDado(nomeDado, novoDado);
            System.out.println("Dado alterado com sucesso.");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public String exibirDadosUsuario(String cpf) {
        if (!this.getUsuarios().containsKey(cpf)) {
            return "Usuário não encontrado.";
        } else {
            return this.getUsuarios().get(cpf).toString();
        }
    }
}