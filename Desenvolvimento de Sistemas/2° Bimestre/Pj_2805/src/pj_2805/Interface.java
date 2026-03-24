package pj_2805;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Interface extends JFrame {

    JLabel rotulo1, rotulo2, rotulo3, rotulo4, rotulo5;
    JTextField texto1, texto2;
    JRadioButton etim, mtec, tec, primeira, segunda, terceira;
    JButton botao1, botao2, botao3;
    JTextArea restricao;
    ButtonGroup grupo, grupo2;
    JComboBox turno;
    JPanel painel;
    String horario[] = {"Diurno", "Vespertino", "Noturno"};

    public Interface() {
        super("Dados do Aluno");
        ImageIcon icone = new ImageIcon("imagens/estudante.png");
        setIconImage(icone.getImage());
        Container tela = getContentPane();
        setLayout(null);
        tela.setBackground(new Color(38, 38, 59));

        rotulo1 = new JLabel("Dados Cadastrais do Aluno");
        rotulo2 = new JLabel("Nome:");
        rotulo3 = new JLabel("Matrícula:");
        rotulo4 = new JLabel("Informe os dados do seu curso:");
        rotulo5 = new JLabel("Restrições Médicas:");

        texto1 = new JTextField();
        texto2 = new JTextField(6);

        etim = new JRadioButton("Etim");
        mtec = new JRadioButton("Mtec");
        tec = new JRadioButton("Técnico");
        primeira = new JRadioButton("1ª Série");
        segunda = new JRadioButton("2ª Série");
        terceira = new JRadioButton("3ª Série");

        grupo = new ButtonGroup();
        grupo.add(etim);
        grupo.add(mtec);
        grupo.add(tec);
        grupo2 = new ButtonGroup();
        grupo2.add(primeira);
        grupo2.add(segunda);
        grupo2.add(terceira);

        turno = new JComboBox(horario);
        turno.setMaximumRowCount(2);

        restricao = new JTextArea(0, 20);
        JScrollPane painelRolagem = new JScrollPane(restricao);
        painelRolagem.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        botao1 = new JButton("Apresentar Infos");
        botao2 = new JButton("Limpar");
        botao3 = new JButton("Sair");

        Font fonte = new Font("Poppins", Font.PLAIN, 12);
        Font titulo = new Font("Poppins", Font.BOLD, 22);

        rotulo1.setFont(titulo);
        rotulo2.setFont(fonte);
        rotulo3.setFont(fonte);
        rotulo4.setFont(fonte);
        rotulo5.setFont(fonte);

        rotulo1.setForeground(Color.white);
        rotulo2.setForeground(Color.white);
        rotulo3.setForeground(Color.white);
        rotulo4.setForeground(Color.white);
        rotulo5.setForeground(Color.white);
        etim.setForeground(Color.white);
        mtec.setForeground(Color.white);
        tec.setForeground(Color.white);
        primeira.setForeground(Color.white);
        segunda.setForeground(Color.white);
        terceira.setForeground(Color.white);

        texto1.setFont(fonte);
        texto2.setFont(fonte);
        primeira.setFont(fonte);
        segunda.setFont(fonte);
        terceira.setFont(fonte);
        etim.setFont(fonte);
        mtec.setFont(fonte);
        tec.setFont(fonte);
        turno.setFont(fonte);
        botao1.setFont(fonte);
        botao2.setFont(fonte);
        botao3.setFont(fonte);

        texto1.setBackground(new Color(105, 112, 128));
        texto2.setBackground(new Color(105, 112, 128));
        texto1.setBorder(null);
        texto2.setBorder(null);

        botao1.setBackground(new Color(81, 137, 250));
        botao1.setForeground(Color.white);
        botao1.setBorderPainted(false);

        botao2.setBackground(new Color(81, 137, 250));
        botao2.setForeground(Color.white);
        botao2.setBorderPainted(false);

        botao3.setBackground(new Color(81, 137, 250));
        botao3.setForeground(Color.white);
        botao3.setBorderPainted(false);

        primeira.setOpaque(false);
        segunda.setOpaque(false);
        terceira.setOpaque(false);
        etim.setOpaque(false);
        mtec.setOpaque(false);
        tec.setOpaque(false);

        rotulo1.setBounds(250, 10, 400, 40);
        rotulo2.setBounds(50, 60, 100, 20);
        texto1.setBounds(150, 60, 250, 20);
        rotulo3.setBounds(50, 100, 100, 20);
        texto2.setBounds(150, 100, 100, 20);
        rotulo4.setBounds(50, 140, 250, 20);

        etim.setBounds(150, 170, 100, 20);
        mtec.setBounds(260, 170, 100, 20);
        tec.setBounds(370, 170, 100, 20);

        primeira.setBounds(150, 200, 100, 20);
        segunda.setBounds(260, 200, 100, 20);
        terceira.setBounds(370, 200, 100, 20);

        rotulo5.setBounds(50, 240, 150, 20);
        painelRolagem.setBounds(200, 240, 150, 60);

        turno.setBounds(400, 240, 150, 20);

        botao1.setBounds(150, 330, 150, 30);
        botao2.setBounds(320, 330, 150, 30);
        botao3.setBounds(490, 330, 150, 30);

        tela.add(rotulo1);
        tela.add(rotulo2);
        tela.add(texto1);
        tela.add(rotulo3);
        tela.add(texto2);
        tela.add(rotulo4);
        tela.add(etim);
        tela.add(mtec);
        tela.add(tec);
        tela.add(primeira);
        tela.add(segunda);
        tela.add(terceira);
        tela.add(rotulo5);
        tela.add(painelRolagem);
        tela.add(turno);
        tela.add(botao1);
        tela.add(botao2);
        tela.add(botao3);

        setSize(800, 450);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        botao1.setMnemonic(KeyEvent.VK_A);
        botao2.setMnemonic(KeyEvent.VK_L);
        botao3.setMnemonic(KeyEvent.VK_S);

        botao1.addActionListener(e -> {
            String nomee = texto1.getText();
            String matrice = texto2.getText();
            String restre = restricao.getText();
            String perioe = turno.getSelectedItem().toString();
            
            String cursoe = "";
            if (etim.isSelected()) {
                cursoe = "Etim";
            } else if (mtec.isSelected()) {
                cursoe = "Mtec";
            } else if (tec.isSelected()) {
                cursoe = "Técnico";
            }

            String seriee = "";
            if (primeira.isSelected()) {
                seriee = "1ª Série";
            } else if (segunda.isSelected()) {
                seriee = "2ª Série";
            } else if (terceira.isSelected()) {
                seriee = "3ª Série";
            }

            if(nomee.isEmpty() || matrice.isEmpty() || 
                    (!etim.isSelected() && !mtec.isSelected() && !tec.isSelected()) ||
                    (!primeira.isSelected() && !segunda.isSelected() && !terceira.isSelected())
                    || restre.isEmpty()){
                JOptionPane.showMessageDialog(null, "PREENCHA TODOS OS CAMPOS!!");
            }
            else{
                new Resultados(nomee, matrice, cursoe, seriee, perioe, restre);
                dispose();
            }
        });
        
        botao2.addActionListener(e -> {
            texto1.setText("");
            texto2.setText("");
            grupo.clearSelection();
            grupo2.clearSelection();
            restricao.setText("");
            turno.setSelectedIndex(0);
        });
        
        botao3.addActionListener(e -> {
            dispose();
        });

    }

    public static void main(String args[]) {
        Interface app = new Interface();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
