
import javax.swing.*;

public class DadosPessoais {

    private String nome;
    private int idade;
    private String sexo;
    private String interesses;
    private String civil;
    private String resultados;

    public DadosPessoais() {
        this("", 0, "", "", "", "");
    }

    public DadosPessoais(String nome, int idade, String sexo, String interesses, String civil, String resultados) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.interesses = interesses;
        this.civil = civil;
        this.resultados = resultados;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setInteresses(String interesses) {
        this.interesses = interesses;
    }

    public void setCivil(String civil) {
        this.civil = civil;
    }

    public void setResultados(String resultados) {
        this.resultados = resultados;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getSexo() {
        return sexo;
    }

    public String getInteresses() {
        return interesses;
    }

    public String getCivil() {
        return civil;
    }

    public String getResultados() {
        return resultados;
    }

    public double botao1(JTextField nome, JTextField idade, ) {
        setNome(Double.parseDouble(nome.getText()));
        setIdade(Integer.parseInt(idade.getText()));
        setR(getN1() + getN2());
        return getNome();
    }
}
