
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.text.*;

public class Interface extends JFrame {

    JLabel rotulo1, rotulo2, rotulo3, rotulo4, rotulo5;
    JTextField texto1, texto2;
    JButton botao1, botao2, botao3, botao4, botao5, botao6, botao7, botao8, botao9, botao10;

    public Interface() {
        super("Calculadora Básica");
        ImageIcon icone = new ImageIcon("imagens/calculadora.png");
        setIconImage(icone.getImage());
        setSize(800, 500);
        setVisible(true);
        Container tela = getContentPane();
        setLayout(null);
        tela.setBackground(new Color(255, 249, 246));
        rotulo1 = new JLabel("Informe o primeiro número:");
        rotulo2 = new JLabel("Informe o segundo número:");
        rotulo3 = new JLabel("Desenvolvido por Felipe Vivêncio.");
        rotulo4 = new JLabel("O resultado da operação é:");
        rotulo5 = new JLabel("");
        texto1 = new JTextField(21);
        texto2 = new JTextField(21);
        botao1 = new JButton("+");
        botao2 = new JButton("-");
        botao3 = new JButton("×");
        botao4 = new JButton("÷");
        botao5 = new JButton("Limpar");
        botao6 = new JButton("Habilitar");
        botao7 = new JButton("Desabilitar");
        botao8 = new JButton("Ocultar");
        botao9 = new JButton("Exibir");
        botao10 = new JButton("Sair");
        botao1.setBackground(new Color(255, 170, 128));
        botao2.setBackground(new Color(255, 170, 128));
        botao3.setBackground(new Color(255, 170, 128));
        botao4.setBackground(new Color(255, 170, 128));
        botao5.setBackground(new Color(255, 170, 128));
        botao6.setBackground(new Color(255, 170, 128));
        botao7.setBackground(new Color(255, 170, 128));
        botao8.setBackground(new Color(255, 170, 128));
        botao9.setBackground(new Color(255, 170, 128));
        botao10.setBackground(new Color(255, 170, 128));
        botao1.setForeground(Color.white);
        botao2.setForeground(Color.white);
        botao3.setForeground(Color.white);
        botao4.setForeground(Color.white);
        botao5.setForeground(Color.white);
        botao6.setForeground(Color.white);
        botao7.setForeground(Color.white);
        botao8.setForeground(Color.white);
        botao9.setForeground(Color.white);
        botao10.setForeground(Color.white);
        botao1.setBorderPainted(false);
        botao2.setBorderPainted(false);
        botao3.setBorderPainted(false);
        botao4.setBorderPainted(false);
        botao5.setBorderPainted(false);
        botao6.setBorderPainted(false);
        botao7.setBorderPainted(false);
        botao8.setBorderPainted(false);
        botao9.setBorderPainted(false);
        botao10.setBorderPainted(false);
        rotulo1.setBounds(50, 40, 250, 20);
        rotulo2.setBounds(50, 80, 250, 20);
        rotulo3.setBounds(280, 320, 250, 20);
        rotulo4.setBounds(50, 120, 250, 20);
        rotulo5.setBounds(250, 120, 250, 20);
        texto1.setBounds(250, 40, 80, 20);
        texto2.setBounds(250, 80, 80, 20);
        botao1.setBounds(190, 200, 80, 20);
        botao2.setBounds(290, 200, 80, 20);
        botao3.setBounds(390, 200, 80, 20);
        botao4.setBounds(490, 200, 80, 20);
        botao5.setBounds(50, 240, 80, 20);
        botao6.setBounds(160, 240, 90, 20);
        botao7.setBounds(280, 240, 105, 20);
        botao8.setBounds(410, 240, 80, 20);
        botao9.setBounds(520, 240, 80, 20);
        botao10.setBounds(630, 240, 80, 20);
        rotulo1.setFont(new Font("Poppins", Font.BOLD, 12));
        rotulo2.setFont(new Font("Poppins", Font.BOLD, 12));
        rotulo3.setFont(new Font("Poppins", Font.PLAIN, 12));
        rotulo4.setFont(new Font("Poppins", Font.PLAIN, 12));
        rotulo5.setFont(new Font("Poppins", Font.BOLD, 12));
        texto1.setFont(new Font("Poppins", Font.PLAIN, 12));
        texto2.setFont(new Font("Poppins", Font.PLAIN, 12));
        botao1.setFont(new Font("Poppins", Font.BOLD, 12));
        botao2.setFont(new Font("Poppins", Font.BOLD, 12));
        botao3.setFont(new Font("Poppins", Font.BOLD, 12));
        botao4.setFont(new Font("Poppins", Font.BOLD, 12));
        botao5.setFont(new Font("Poppins", Font.PLAIN, 12));
        botao6.setFont(new Font("Poppins", Font.PLAIN, 12));
        botao7.setFont(new Font("Poppins", Font.PLAIN, 12));
        botao8.setFont(new Font("Poppins", Font.PLAIN, 12));
        botao9.setFont(new Font("Poppins", Font.PLAIN, 12));
        botao10.setFont(new Font("Poppins", Font.PLAIN, 12));
        rotulo4.setForeground(Color.RED);
        rotulo5.setForeground(Color.RED);
        botao5.setMnemonic(KeyEvent.VK_L);
        botao6.setMnemonic(KeyEvent.VK_H);
        botao7.setMnemonic(KeyEvent.VK_D);
        botao8.setMnemonic(KeyEvent.VK_O);
        botao9.setMnemonic(KeyEvent.VK_E);
        botao10.setMnemonic(KeyEvent.VK_S);
        getRootPane().setDefaultButton(botao10);
        tela.add(rotulo1);
        tela.add(rotulo2);
        tela.add(rotulo3);
        tela.add(rotulo4);
        tela.add(rotulo5);
        tela.add(texto1);
        tela.add(texto2);
        tela.add(botao1);
        tela.add(botao2);
        tela.add(botao3);
        tela.add(botao4);
        tela.add(botao5);
        tela.add(botao6);
        tela.add(botao7);
        tela.add(botao8);
        tela.add(botao9);
        tela.add(botao10);
        setLocationRelativeTo(null);

        botao1.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operacao('+');
            }
        }
        );

        botao2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operacao('-');
            }
        });

        botao3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operacao('*');
            }
        });

        botao4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operacao('/');
            }
        });

        botao5.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                texto1.setText(null);
                texto2.setText(null);
                texto1.requestFocus();
            }
        }
        );

        botao6.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rotulo1.setEnabled(false);
                rotulo2.setEnabled(false);
            }
        }
        );

        botao7.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rotulo1.setEnabled(true);
                rotulo2.setEnabled(true);
            }
        }
        );

        botao8.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rotulo1.setVisible(false);
                rotulo2.setVisible(false);
            }
        }
        );
        botao9.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rotulo1.setVisible(true);
                rotulo2.setVisible(true);
            }
        }
        );

        botao10.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }
     );   
  }
    
    private void operacao(char op) {
        Calculadora calc = new Calculadora();

        switch (op) {

            case '+':
                double soma = calc.botao1(texto1, texto2);
                rotulo5.setText(String.valueOf(soma));
                break;

            case '-':
                double subtracao = calc.botao2(texto1, texto2);
                rotulo5.setText(String.valueOf(subtracao));
                break;

            case '*':
                double multiplicacao = calc.botao3(texto1, texto2);
                rotulo5.setText(String.valueOf(multiplicacao));
                break;

            case '/':
                if (texto2.getText().equals("0")) {
                    rotulo5.setText("Não existe divisão por zero.");
                    break;

                } else {
                    double divisao = calc.botao4(texto1, texto2);
                    rotulo5.setText(String.valueOf(divisao));
                    break;
                }

            default:
                rotulo5.setText("Erro. Tente novamente.");
                break;
        }
    }

    public static void main(String args[]) {
        Interface app = new Interface();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
