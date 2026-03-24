import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interface extends JFrame {

    private Container tela;
    private JMenuBar barra;
    private JMenu operacoes, sobre, sair;
    private JMenuItem somar, subtrair, multiplicar, dividir, sobreItem, sairItem;
    private JToolBar ferramentas;
    private JLabel ola, explicacao;
    private JButton botao1, botao2, botao3, botao4, botao5;
    private JPopupMenu popup;
    private JMenuItem popupSobre, popupSair;

    public Interface() {
        super("Calculadora com Menu");
        ImageIcon iconeJanela = new ImageIcon("imagens/calculadora.png");
        setIconImage(iconeJanela.getImage());
        tela = getContentPane();
        setLayout(null);
        tela.setBackground(new Color(143, 227, 255));

        String[] icones = {
                "imagens/Soma.jpeg",
                "imagens/Subtrair.jpeg",
                "imagens/Multiplicacao.jpeg",
                "imagens/Divisao.jpeg",
                "imagens/sair.jpeg"
        };

        ImageIcon[] imagens = new ImageIcon[icones.length];
        for (int i = 0; i < icones.length; i++) {
            imagens[i] = new ImageIcon(new ImageIcon(icones[i]).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        }

        botao1 = criarBotao(imagens[0], "Somar");
        botao2 = criarBotao(imagens[1], "Subtrair");
        botao3 = criarBotao(imagens[2], "Multiplicar");
        botao4 = criarBotao(imagens[3], "Dividir");
        botao5 = new JButton(imagens[4]);
        botao5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sair();
            }
        });

        barra = new JMenuBar();
        setJMenuBar(barra);

        operacoes = new JMenu("Operações");
        sobre = new JMenu("Sobre");
        sair = new JMenu("Sair");

        somar = new JMenuItem("Somar");
        subtrair = new JMenuItem("Subtrair");
        multiplicar = new JMenuItem("Multiplicar");
        dividir = new JMenuItem("Dividir");
        sobreItem = new JMenuItem("Sobre");
        sairItem = new JMenuItem("Sair");

        definirMnemonicos();

        operacoes.add(somar);
        operacoes.add(subtrair);
        operacoes.add(multiplicar);
        operacoes.add(dividir);
        sobre.add(sobreItem);
        sair.add(sairItem);

        barra.add(operacoes);
        barra.add(sobre);
        barra.add(sair);

        ferramentas = new JToolBar();
        adicionarBotoesToolbar();

        fonteEComponentes();

        popup = new JPopupMenu();
        popupSobre = new JMenuItem("Sobre");
        popupSair = new JMenuItem("Sair");
        popup.add(popupSobre);
        popup.addSeparator();
        popup.add(popupSair);

        tela.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popup.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        ActionListener operacoesListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                janelaOperacao(e.getActionCommand());
            }
        };

        somar.addActionListener(operacoesListener);
        subtrair.addActionListener(operacoesListener);
        multiplicar.addActionListener(operacoesListener);
        dividir.addActionListener(operacoesListener);
        botao1.addActionListener(operacoesListener);
        botao2.addActionListener(operacoesListener);
        botao3.addActionListener(operacoesListener);
        botao4.addActionListener(operacoesListener);

        sobreItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sobre();
            }
        });

        popupSobre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sobre();
            }
        });

        ActionListener sairListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sair();
            }
        };

        sairItem.addActionListener(sairListener);
        popupSair.addActionListener(sairListener);
        botao5.addActionListener(sairListener);

        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JButton criarBotao(ImageIcon icon, String acao) {
        JButton botao = new JButton(icon);
        botao.setActionCommand(acao);
        return botao;
    }

    private void definirMnemonicos() {
        operacoes.setMnemonic(KeyEvent.VK_O);
        sobre.setMnemonic(KeyEvent.VK_B);
        sair.setMnemonic(KeyEvent.VK_S);
        somar.setMnemonic(KeyEvent.VK_A);
        subtrair.setMnemonic(KeyEvent.VK_U);
        multiplicar.setMnemonic(KeyEvent.VK_M);
        dividir.setMnemonic(KeyEvent.VK_D);
        sobreItem.setMnemonic(KeyEvent.VK_E);
        sairItem.setMnemonic(KeyEvent.VK_I);
        botao1.setMnemonic(KeyEvent.VK_S);
        botao2.setMnemonic(KeyEvent.VK_U);
        botao3.setMnemonic(KeyEvent.VK_M);
        botao4.setMnemonic(KeyEvent.VK_D);
        botao5.setMnemonic(KeyEvent.VK_A);
    }

    private void adicionarBotoesToolbar() {
        ferramentas.add(botao1);
        ferramentas.add(botao2);
        ferramentas.add(botao3);
        ferramentas.add(botao4);
        ferramentas.addSeparator();
        ferramentas.add(botao5);
        ferramentas.setBounds(5, 5, 400, 30);
        tela.add(ferramentas);
    }

    private void fonteEComponentes() {
        Font fonte = new Font("Poppins", Font.PLAIN, 12);
        Font fontee = new Font("Poppins", Font.BOLD, 24);
        Color cor = new Color(154, 218, 249);

        ola = new JLabel("Olá, Edna!");
        ola.setFont(fontee);
        ola.setForeground(Color.white);
        ola.setBounds(315, 50, 200, 100);
        tela.add(ola);

        explicacao = new JLabel("Utilize o menu ou a barra de ferramentas para usar a calculadora.");
        explicacao.setFont(fonte);
        explicacao.setForeground(Color.white);
        explicacao.setBounds(180, 100, 600, 50);
        tela.add(explicacao);

        ImageIcon crazyFrogIcon = new ImageIcon("imagens/Crazy_Frog.png");
        Image redimen = crazyFrogIcon.getImage().getScaledInstance(130, 90, Image.SCALE_SMOOTH);
        JLabel crazyFrogLabel = new JLabel(new ImageIcon(redimen));
        crazyFrogLabel.setBounds(245, 200, 250, 80);
        tela.add(crazyFrogLabel);

        operacoes.setFont(fonte);
        sobre.setFont(fonte);
        sair.setFont(fonte);
        somar.setFont(fonte);
        subtrair.setFont(fonte);
        multiplicar.setFont(fonte);
        dividir.setFont(fonte);
        sobreItem.setFont(fonte);
        sairItem.setFont(fonte);

        JButton[] botoes = {botao1, botao2, botao3, botao4, botao5};
        for (JButton botao : botoes) {
            botao.setBackground(cor);
            botao.setForeground(Color.white);
            botao.setFont(fonte);
        }
    }

    private void janelaOperacao(String operacao) {
        JDialog janela = new JDialog(this, operacao, true);
        janela.setLayout(null);
        janela.setBackground(Color.white);

        JLabel rotulo1 = new JLabel("1º Número:");
        JTextField campo1 = new JTextField();
        JLabel rotulo2 = new JLabel("2º Número:");
        JTextField campo2 = new JTextField();
        JLabel resultado = new JLabel("Resultado: ");
        JButton calcular = new JButton("Calcular");
        JButton limpar = new JButton("Limpar");

        rotulo1.setBounds(30, 30, 100, 20);
        campo1.setBounds(130, 30, 100, 20);
        rotulo2.setBounds(30, 70, 100, 20);
        campo2.setBounds(130, 70, 100, 20);
        calcular.setBounds(30, 110, 100, 25);
        limpar.setBounds(140, 110, 100, 25);
        resultado.setBounds(30, 150, 250, 25);

        Font fonte = new Font("Poppins", Font.PLAIN, 12);
        Font fontee = new Font("Poppins", Font.BOLD, 12);

        rotulo1.setFont(fonte);
        campo1.setFont(fonte);
        rotulo2.setFont(fonte);
        campo2.setFont(fonte);
        resultado.setFont(fontee);
        calcular.setFont(fonte);
        limpar.setFont(fonte);

        calcular.setBackground(Color.white);
        limpar.setBackground(Color.RED);
        limpar.setForeground(Color.white);
        limpar.setBorderPainted(false);

        janela.add(rotulo1);
        janela.add(campo1);
        janela.add(rotulo2);
        janela.add(campo2);
        janela.add(calcular);
        janela.add(limpar);
        janela.add(resultado);

        calcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double n1 = Double.parseDouble(campo1.getText().trim());
                    double n2 = Double.parseDouble(campo2.getText().trim());
                    double res = 0;
                    switch (operacao) {
                        case "Somar":
                            res = n1 + n2;
                            break;
                        case "Subtrair":
                            res = n1 - n2;
                            break;
                        case "Multiplicar":
                            res = n1 * n2;
                            break;
                        case "Dividir":
                            if (n2 == 0) {
                                JOptionPane.showMessageDialog(janela, "Não existe divisão por zero.");
                                return;
                            }
                            res = n1 / n2;
                    }
                    resultado.setText("Resultado: " + res);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(janela, "Digite números válidos.");
                }
            }
        });

        calcular.setMnemonic(KeyEvent.VK_ENTER);

        limpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                campo1.setText("");
                campo2.setText("");
                resultado.setText("Resultado: ");
                campo1.requestFocus();
            }
        });

        limpar.setMnemonic(KeyEvent.VK_L);

        janela.setSize(300, 250);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
    }

    private void sobre() {
        JDialog sobre = new JDialog(this, "Sobre", true);
        sobre.setLayout(new GridLayout(3, 1));

        JLabel rotulo1 = new JLabel("Nome: Felipe Vivêncio");
        JLabel rotulo2 = new JLabel("Turma: 2º Desenvolvimento de Sistemas (AMS)");
        JLabel rotulo3 = new JLabel("Data de Entrega: 26/06/2025");

        Font fonte = new Font("Poppins", Font.PLAIN, 12);
        rotulo1.setFont(fonte);
        rotulo2.setFont(fonte);
        rotulo3.setFont(fonte);

        sobre.add(rotulo1);
        sobre.add(rotulo2);
        sobre.add(rotulo3);

        sobre.setSize(300, 150);
        sobre.setLocationRelativeTo(null);
        sobre.setVisible(true);
    }

    private void sair() {
        int resp = JOptionPane.showConfirmDialog(null, "Quer mesmo sair?", "Sair", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        Interface app = new Interface();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}