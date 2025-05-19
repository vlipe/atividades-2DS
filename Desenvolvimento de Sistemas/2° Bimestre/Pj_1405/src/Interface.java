
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interface extends JFrame {

    JLabel rotulo1, rotulo2, rotulo3, rotulo4, rotulo5, rotulo6;
    JTextField texto1, texto2;
    JRadioButton primeira, segunda;
    JCheckBox auto, barcos, avioes;
    JButton botao1, botao2;
    ButtonGroup grupo;
    JComboBox<String> estado;
    String civil[] = {"Solteiro(a)", "Casado(a)", "Separado(a)", "Divorciado(a)", "Viúvo(a)"};

    public Interface() {
        super("Informações Pessoais");
        ImageIcon icone = new ImageIcon("imagens/icone.png");
        setIconImage(icone.getImage());
        setSize(800, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container tela = getContentPane();
        setLayout(null);
        tela.setBackground(new Color(38, 38, 59));

        // Rótulos
        rotulo1 = new JLabel("Nome:");
        rotulo2 = new JLabel("Idade:");
        rotulo3 = new JLabel("Sexo:");
        rotulo4 = new JLabel("Interesses:");
        rotulo5 = new JLabel("Estado civil:");
        rotulo6 = new JLabel("Desenvolvido por Felipe Vivêncio.");

        // Campos de texto
        texto1 = new JTextField();
        texto2 = new JTextField(3);

        // RadioButton
        primeira = new JRadioButton("Masculino");
        segunda = new JRadioButton("Feminino");
        grupo = new ButtonGroup();
        grupo.add(primeira);
        grupo.add(segunda);

        // CheckBox
        auto = new JCheckBox("Automóveis");
        barcos = new JCheckBox("Barcos");
        avioes = new JCheckBox("Aviões");

        // ComboBox
        estado = new JComboBox<>(civil);
        estado.setMaximumRowCount(5);

        // Botões
        botao1 = new JButton("Enviar");
        botao2 = new JButton("Limpar");

        // Mnemonics
        botao1.setMnemonic(KeyEvent.VK_E);
        botao2.setMnemonic(KeyEvent.VK_L);

        // Fonte
        rotulo1.setFont(new Font("Poppins", Font.PLAIN, 12));
        rotulo2.setFont(new Font("Poppins", Font.PLAIN, 12));
        rotulo3.setFont(new Font("Poppins", Font.PLAIN, 12));
        rotulo4.setFont(new Font("Poppins", Font.PLAIN, 12));
        rotulo5.setFont(new Font("Poppins", Font.PLAIN, 12));
        rotulo6.setFont(new Font("Poppins", Font.BOLD, 12));
        texto1.setFont(new Font("Poppins", Font.PLAIN, 12));
        texto2.setFont(new Font("Poppins", Font.PLAIN, 12));
        primeira.setFont(new Font("Poppins", Font.PLAIN, 12));
        segunda.setFont(new Font("Poppins", Font.PLAIN, 12));
        auto.setFont(new Font("Poppins", Font.PLAIN, 12));
        barcos.setFont(new Font("Poppins", Font.PLAIN, 12));
        avioes.setFont(new Font("Poppins", Font.PLAIN, 12));
        botao1.setFont(new Font("Poppins", Font.PLAIN, 12));
        botao2.setFont(new Font("Poppins", Font.PLAIN, 12));
        estado.setFont(new Font("Poppins", Font.PLAIN, 12));

        botao1.setForeground(Color.white);
        botao2.setForeground(Color.white);
        rotulo1.setForeground(Color.white);
        texto1.setBackground(new Color(105, 112, 128));
        texto2.setBackground(new Color(105, 112, 128));
        texto1.setBorder(null);
        texto2.setBorder(null);
        rotulo2.setForeground(Color.white);
        rotulo3.setForeground(Color.white);
        rotulo4.setForeground(Color.white);
        rotulo5.setForeground(Color.white);
        rotulo5.setForeground(Color.white);
        botao1.setForeground(Color.white);
        botao1.setBackground(new Color(81, 137, 250));
        botao1.setBorderPainted(false);
        texto1.setToolTipText("Digite o seu nome.");
        texto2.setToolTipText("Digite o sua idade.");
        primeira.setToolTipText("Selecione seu gênero.");
        segunda.setToolTipText("Selecione seu gênero.");
        auto.setToolTipText("Selecione uma ou mais opção.");
        barcos.setToolTipText("Selecione uma ou mais opção.");
        avioes.setToolTipText("Selecione uma ou mais opção.");
        botao1.setToolTipText("Alt + E.");
        botao2.setToolTipText("Alt + L.");
        botao2.setForeground(Color.white);
        botao2.setBackground(new Color(81, 137, 250));
        botao2.setBorderPainted(false);
        primeira.setForeground(Color.white);
        segunda.setForeground(Color.white);
        primeira.setFocusPainted(false);
        segunda.setFocusPainted(false);
        auto.setFocusPainted(false);
        barcos.setFocusPainted(false);
        avioes.setFocusPainted(false);
        primeira.setOpaque(false);
        segunda.setOpaque(false);
        auto.setOpaque(false);
        barcos.setOpaque(false);
        avioes.setOpaque(false);
        auto.setForeground(Color.white);
        barcos.setForeground(Color.white);
        avioes.setForeground(Color.white);
        estado.setOpaque(false);
        estado.setBorder(null);
        estado.setBackground(Color.white);

        // Posição
        rotulo1.setBounds(50, 40, 100, 20);
        texto1.setBounds(150, 40, 200, 20);

        rotulo2.setBounds(50, 80, 100, 20);
        texto2.setBounds(150, 80, 50, 20);

        rotulo3.setBounds(50, 120, 100, 20);
        primeira.setBounds(150, 120, 100, 20);
        segunda.setBounds(250, 120, 100, 20);

        rotulo4.setBounds(50, 160, 100, 20);
        auto.setBounds(150, 160, 100, 20);
        barcos.setBounds(150, 190, 100, 20);
        avioes.setBounds(150, 220, 100, 20);

        rotulo5.setBounds(50, 260, 100, 20);
        estado.setBounds(150, 260, 150, 20);

        botao1.setBounds(150, 300, 150, 25);
        botao2.setBounds(320, 300, 150, 25);

        rotulo6.setBounds(290, 400, 300, 20);
        rotulo6.setForeground(Color.GRAY);

        // Adiciona à tela
        tela.add(rotulo1);
        tela.add(texto1);
        tela.add(rotulo2);
        tela.add(texto2);
        tela.add(rotulo3);
        tela.add(primeira);
        tela.add(segunda);
        tela.add(rotulo4);
        tela.add(auto);
        tela.add(barcos);
        tela.add(avioes);
        tela.add(rotulo5);
        tela.add(estado);
        tela.add(botao1);
        tela.add(botao2);
        tela.add(rotulo6);

        // Função do botão "Limpar os dados"
        botao2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                texto1.setText("");
                texto2.setText("");
                grupo.clearSelection();
                auto.setSelected(false);
                barcos.setSelected(false);
                avioes.setSelected(false);
                estado.setSelectedIndex(0);
            }
        });

        // Função do botão "Enviar os dados"
        botao1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = texto1.getText();
                String idade = texto2.getText();
                String sexo = primeira.isSelected() ? "Masculino" : segunda.isSelected() ? "Feminino" : "Não informado";
                String interesses = "";
                if (auto.isSelected()) {
                    interesses += "Automóveis ";
                }
                if (barcos.isSelected()) {
                    interesses += "Barcos ";
                }
                if (avioes.isSelected()) {
                    interesses += "Aviões ";
                }
                String est = estado.getSelectedItem().toString();

                JOptionPane.showMessageDialog(null, "Nome: " + nome + "\nIdade: " + idade + "\nSexo: " + sexo + "\nInteresses: " + interesses + "\nEstado Civil: " + est);
            }
        });

        setVisible(true);
    }

    public static void main(String args[]) {
        Interface app = new Interface();
    }
}
