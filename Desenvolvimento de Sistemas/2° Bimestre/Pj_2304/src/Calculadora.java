import javax.swing.*;

public class Calculadora {
    private double n1;
    private double n2;
    private double r;
    
    public Calculadora(){
        this(0.0, 0.0, 0.0);
    }
    
    public Calculadora(double n1, double n2, double r) {
        this.n1 = n1;
        this.n2 = n2;
        this.r = r;
    }

    public double getN1() {
        return n1;
    }

    public double getN2() {
        return n2;
    }

    public double getR() {
        return r;
    }

    public void setN1(double n1) {
        this.n1 = n1;
    }

    public void setN2(double n2) {
        this.n2 = n2;
    }

    public void setR(double r) {
        this.r = r;
    }
    
    public double botao1(JTextField a, JTextField b){
        setN1(Double.parseDouble(a.getText()));
        setN2(Double.parseDouble(b.getText()));
        setR(getN1()+getN2());
        return getR();
    }
    
    public double botao2(JTextField a, JTextField b){
        setN1(Double.parseDouble(a.getText()));
        setN2(Double.parseDouble(b.getText()));
        setR(getN1()-getN2());
        return getR();
    }
    
    public double botao3(JTextField a, JTextField b){
        setN1(Double.parseDouble(a.getText()));
        setN2(Double.parseDouble(b.getText()));
        setR(getN1()*getN2());     
        return getR();
    }
    
    public double botao4(JTextField a, JTextField b){
        setN1(Double.parseDouble(a.getText()));
        setN2(Double.parseDouble(b.getText()));
        setR(getN1()/getN2());
        return getR();
    }
}
