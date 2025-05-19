
import javax.swing.JOptionPane;

public class ConversorMedidas {
    
    private double valor;
    private double resultado;
    
    public ConversorMedidas() {
        this(0.0, 0.0);
    }
    
    public ConversorMedidas(double valor, double resultado) {
        this.valor = valor;
        this.resultado = resultado;
    }

    public double getValor() {
        return valor;
    }

    public double getResultado() {
        return resultado;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
    
    public void cmParaMetros() {
        setValor(Double.parseDouble(JOptionPane.showInputDialog("Informe o valor para a conversão: ")));
        setResultado(getValor() / 100);
        JOptionPane.showMessageDialog(null, "O resultado da conversão de CM para M é: " + getResultado());
    }
    
    public void metrosParaKm() {
        setValor(Double.parseDouble(JOptionPane.showInputDialog("Informe o valor para a conversão: ")));
        setResultado(getValor() / 1000);
        JOptionPane.showMessageDialog(null, "O resultado da conversão de M para KM é: " + getResultado());
    }
    
    public double kmParaMilhas(double num) {
        setResultado(num / 1.609);
        return(getResultado());
        
    }
    
    public double milhasParaKm(double num) {
        setResultado(num * 1.609);
        return(getResultado());
    }
    
}
