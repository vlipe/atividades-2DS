package Model;

public class Medico {
    private int cod_medico;
    private String nome;
    private String crm;
    private String email;
    private String senha;

    public Medico() {
    }

    public Medico(int cod_medico, String nome, String crm, String email, String senha) {
        this.cod_medico = cod_medico;
        this.nome = nome;
        this.crm = crm;
        this.email = email;
        this.senha = senha;
    }

    public int getCod_medico() {
        return cod_medico;
    }

    public void setCod_medico(int cod_medico) {
        this.cod_medico = cod_medico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}