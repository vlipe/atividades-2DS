
import javax.swing.JOptionPane;

public class Caixa {

    // atributo.
    private double saldo;

    // construtores.
    // inicializando o atributo zerado.
    public Caixa() {
        this(0);
    }
    
    // inicializando o atributo com parâmetro.
    public Caixa(double saldo) {
        this.saldo = saldo;
    }

    // definindo os "getters" e "setters".
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    // metódos da classe, para a realização da entrada e retirada de valores na caixa.
    public void entrar() {
        
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da entrada: "));
        
        // soma o conteúdo do atributo saldo com a variável valor e passa o resultado por parâmetro para o método setSaldo().
        this.setSaldo(this.saldo + valor);

    }
    
    public void retirar() {
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da retirada: "));
        
        // subtrai o conteúdo do atributo saldo com a variável valor e passa o resultado por parâmetro para o método setSaldo().
        this.setSaldo(this.saldo - valor);
    }

}
