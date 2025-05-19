import javax.swing.JOptionPane;

public class PrincipalJuros {

    public static void main(String[] args) {

        CalculadoraJuros juros = new CalculadoraJuros();
        int op;

        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(
                    "Informe um número para calcular: \n1: Juros Simples" + "\n2: Juros Compostos" + "\n3: Consultar último resultado"
                            + "\n0:  Sair"));

            switch (op) {
                case 1:
                    juros.calcularJurosSimples();
                    break;

                case 2:
                    juros.calcularJurosCompostos();
                    break;

                case 3:
                    juros.mostrarResultado();
                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "Finalizando Programa!");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Informe o número corretamente.");
            }

        } while (op != 0);
    }
}
