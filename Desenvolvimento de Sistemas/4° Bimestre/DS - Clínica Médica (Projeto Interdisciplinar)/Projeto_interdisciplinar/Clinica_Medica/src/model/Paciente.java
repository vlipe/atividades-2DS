package Model;

public class Paciente {
    private int cod_paciente;
    private String nome;
    private String rg;
    private String email;
    private String senha;
    private String dt_nasc;

    public Paciente() {
    }

    public Paciente(int cod_paciente, String nome, String rg, String email, String senha, String dt_nasc) {
        this.cod_paciente = cod_paciente;
        this.nome = nome;
        this.rg = rg;
        this.email = email;
        this.senha = senha;
        this.dt_nasc = dt_nasc;
    }

    public int getCod_paciente() {
        return cod_paciente;
    }

    public void setCod_paciente(int cod_paciente) {
        this.cod_paciente = cod_paciente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
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

    public String getDt_nasc() {
        return dt_nasc;
    }

    public void setDt_nasc(String dt_nasc) {
        this.dt_nasc = dt_nasc;
    }
}