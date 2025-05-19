// exercício 1, calculadora de operações básicas (soma, subtração, multiplicação e divisão).

import javax.swing.JOptionPane;

public class PrincipalCalculadora {

    public static void main(String[] args) {

        Calculadora calculadora = new Calculadora();
        int op;

        do {

            op = Integer.parseInt(JOptionPane.showInputDialog("Informe: \n1: Soma " + "\n2: Subtração " + "\n3: Multiplicação "
                    + "\n4: Divisão" + "\n0: Sair"));

            switch (op) {

                case 1:
                    calculadora.somar();
                    break;

                case 2:
                    double n1 = Double.parseDouble(JOptionPane.showInputDialog("Informe o primeiro número: "));
                    double n2 = Double.parseDouble(JOptionPane.showInputDialog("Informe o segundo número: "));
                    // perguntar para a prof depois sobre a linha abaixo.
                    calculadora.subtrair(n1, n2);
                    break;

                case 3:
                    double multiplicacao = calculadora.multiplicar();
                    JOptionPane.showMessageDialog(null, "O resultado da multiplicação é: " + multiplicacao);
                    break;

                case 4:
                    double num1 = Double.parseDouble(JOptionPane.showInputDialog("Informe o primeiro número: "));
                    double num2 = Double.parseDouble(JOptionPane.showInputDialog("Informe o segundo número: "));
                    double divisao = calculadora.dividir(num1, num2);
                    JOptionPane.showMessageDialog(null, "O resultado da divisão é: " + divisao);
                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "Finalizando programa!");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida. Informe o número corretamente. ");
            }
        } while (op != 0);

    }
}
