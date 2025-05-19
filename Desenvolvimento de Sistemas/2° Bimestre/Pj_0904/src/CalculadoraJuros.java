
import javax.swing.JOptionPane;

public class CalculadoraJuros {

    private double capital;
    private double taxa;
    private int tempo;
    private double resultado;
    private double montante;

    public CalculadoraJuros() {
        this(0.0, 0.0, 0, 0.0, 0.0);
    }

    public CalculadoraJuros(double capital, double taxa, int tempo, double resultado, double montante) {
        this.capital = capital;
        this.taxa = taxa;
        this.tempo = tempo;
        this.resultado = resultado;
        this.montante = montante;
    }

    public double getCapital() {
        return capital;
    }

    public double getTaxa() {
        return taxa;
    }

    public int getTempo() {
        return tempo;
    }

    public double getResultado() {
        return resultado;
    }
    
    public double getMontante() {
        return montante;
    }
    
    public void setCapital(double capital) {
        this.capital = capital;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
    
    public void setMontante(double montante) {
        this.montante = montante;
    }

    public void calcularJurosSimples() {
        setCapital(Double.parseDouble(JOptionPane.showInputDialog("Informe o capital: ")));
        setTaxa(Double.parseDouble(JOptionPane.showInputDialog("Informe a taxa de juros (em decimal, ex: 0.05): ")));
        setTempo(Integer.parseInt(JOptionPane.showInputDialog("Informe o período de tempo (em anos): ")));
        setResultado(getCapital() * getTaxa() * getTempo());
        JOptionPane.showMessageDialog(null, "O total de Juros Simples é de: " + getResultado());
    }

    public void calcularJurosCompostos() {
        setCapital(Double.parseDouble(JOptionPane.showInputDialog("Informe o capital inicial (quanto você investiu): ")));
        setTaxa(Double.parseDouble(JOptionPane.showInputDialog("Informe a taxa de juros (em decimal, ex: 0.05): ")));
        setTempo(Integer.parseInt(JOptionPane.showInputDialog("Informe o período de tempo (em anos): ")));
        setMontante(getCapital() * Math.pow((1 + getTaxa()), getTempo()));
        setResultado(getMontante() - getCapital());
        JOptionPane.showMessageDialog(null, "O total de Juros Compostos é de: " + getResultado());
    }

    public void mostrarResultado() {
    JOptionPane.showMessageDialog(null, "Capital: " + getCapital() +
                                          "\nTaxa: " + getTaxa() +
                                          "\nTempo: " + getTempo() +
                                          "\nResultado: " + getResultado());
}


}
