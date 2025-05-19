// exemplo da aula de 09/04/2025.

import javax.swing.JOptionPane;

public class Principal {
   
    public static void main(String[] args) {
       
        Caixa cx1 = new Caixa();
        int op;
        do {
            
            op = Integer.parseInt(JOptionPane.showInputDialog("Digite: \n1 - Entrada "  + "\n2 - Retirada " + "\n3 - Consultar Saldo" + "\n0 - Sair "));
            
            switch(op) {
                
                case 1:
                    cx1.entrar();
                    break;
                    
                case 2:
                    cx1.retirar();
                    break;
                    
                case 3:
                    JOptionPane.showMessageDialog(null, "Saldo atual: " + cx1.getSaldo());
                    break;
                    
                case 0:
                    JOptionPane.showMessageDialog(null, "Finalizando Programa!");
                    break;
                  
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida.");
            }
            
        } while (op != 0);
    }
    
}
