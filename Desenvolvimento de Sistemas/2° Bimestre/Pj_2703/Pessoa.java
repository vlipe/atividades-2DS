
import javax.swing.JOptionPane;

public class Pessoa {
    
    private String nome;
    private String endereco;
    private double salario;
    private String telefone;
    private String email;

    public Pessoa() {
    }

    public Pessoa(String nome, String endereco, double salario, String telefone, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public double getSalario() {
        return salario;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void inserirDadosPessoa() {
        this.nome = JOptionPane.showInputDialog("Por favor, informe o seu nome:");
        this.endereco = JOptionPane.showInputDialog("Por favor, informe o seu endereço:");
        this.salario = Double.parseDouble(JOptionPane.showInputDialog("Por favor, informe o seu salário:"));
        this.telefone = JOptionPane.showInputDialog("Por favor, informe o seu telefone:");
        this.email = JOptionPane.showInputDialog("Por favor, informe o seu email:");
    }

    public void apresentarPessoa() {
        String mensagem = "Nome: " + getNome() + 
                          "\nEndereço: " + getEndereco() + 
                          "\nSalário: " + getSalario() + 
                          "\nTelefone: " + getTelefone() + 
                          "\nEmail: " + getEmail();
        JOptionPane.showMessageDialog(null, mensagem);
    }
}
