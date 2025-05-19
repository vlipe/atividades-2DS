
import javax.swing.JOptionPane;

public class PrincipalConversor {
    
    public static void main(String[] args) {
        
        ConversorMedidas conversor = new ConversorMedidas();
        int op;
        
        do {
            
            op = Integer.parseInt(JOptionPane.showInputDialog("Informe: \n1: Centímetros para Metros " + "\n2: Metros para Quilômetros " + "\n3: Quilômetros para Milhas "
                    + "\n4: Milhas para Quilômetros" + "\n0: Sair"));

            switch (op) {
                
                case 1:
                    conversor.cmParaMetros();
                    break;
                    
                case 2:
                    conversor.metrosParaKm();
                    break;
                    
                case 3:
                    double valorKM = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor para a conversão: "));
                    double kmMilhas = conversor.kmParaMilhas(valorKM);
                    JOptionPane.showMessageDialog(null, "O resultado da conversão é: " + kmMilhas);
                    break;
                    
                case 4:
                    double valorMILHAS = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor para a conversão: "));
                    double milhasKM = conversor.milhasParaKm(valorMILHAS);
                    JOptionPane.showMessageDialog(null, "O resultado da conversão é: " + milhasKM);                    
                    break;
                    
                case 0:
                    JOptionPane.showMessageDialog(null, "Finalizando programa!");
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Informe o número corretamente.");
            }
        } while (op != 0);
        
    }
    
}
