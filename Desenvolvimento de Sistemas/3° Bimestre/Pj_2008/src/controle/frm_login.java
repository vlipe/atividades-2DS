package controle;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

import conexao.Conexao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm_login extends JFrame {

    Conexao con_cliente;

    JPasswordField tsen;
    JLabel rusu, rsen;
    JTextField tusu;
    JButton blogar, sair;
    int tentativa = 3;

    public frm_login() {
        con_cliente = new Conexao();
        con_cliente.conecta();

        ImageIcon iconeJanela = new ImageIcon("imagens/icone.png");
        setIconImage(iconeJanela.getImage());

        setTitle("Login de Acesso");
        setLayout(null);
        setResizable(false);

        Color corFundo = new Color(250, 250, 245);
        Color corCampos = new Color(255, 255, 255);
        Color corTexto = new Color(70, 70, 70);
        Color corLabel = new Color(100, 100, 100);

        Font fontePadrao = new Font("Poppins", Font.PLAIN, 14);
        Font fonteLabel = new Font("Poppins", Font.BOLD, 13);

        getContentPane().setBackground(corFundo);

        rusu = new JLabel("Usuário:");
        rusu.setBounds(50, 50, 100, 25);
        rusu.setFont(fonteLabel);
        rusu.setForeground(corLabel);

        tusu = new JTextField();
        tusu.setBounds(150, 50, 200, 25);
        tusu.setBackground(corCampos);
        tusu.setForeground(corTexto);
        tusu.setFont(fontePadrao);
        tusu.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));

        rsen = new JLabel("Senha:");
        rsen.setBounds(50, 100, 100, 25);
        rsen.setFont(fonteLabel);
        rsen.setForeground(corLabel);

        tsen = new JPasswordField();
        tsen.setBounds(150, 100, 200, 25);
        tsen.setBackground(corCampos);
        tsen.setForeground(corTexto);
        tsen.setFont(fontePadrao);
        tsen.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));

        blogar = new JButton("Login");
        blogar.setBounds(50, 150, 100, 30);
        blogar.setFont(fontePadrao);
        blogar.setBackground(Color.WHITE);
        blogar.setForeground(corTexto);
        
        sair = new JButton("Sair");
        sair.setBounds(250, 150, 100, 30);
        sair.setFont(fontePadrao);
        sair.setBackground(Color.WHITE);
        sair.setForeground(corTexto);
  
        blogar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    String pesquisa = "select * from tblusuario where usuario like '" + tusu.getText() + "' && senha = " +tsen.getText() + "";
                    con_cliente.executaSQL(pesquisa);
                    
                    if (con_cliente.resultset.first()){
                        Formulario mostra = new Formulario();
                        mostra.setVisible(true);
                        dispose();
                    }
                    else {
                        tentativa--; 
                        if(tentativa > 0){
                            JOptionPane.showMessageDialog(null, "\n Usuário não cadastrado.","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);

                        } else {
                            JOptionPane.showMessageDialog(null, "Tentativas excedidas.");
                            System.exit(0);
                    }
                } 
            } catch(SQLException errosql) {
                    JOptionPane.showMessageDialog(null, "\n Os Dados digitados não foram localizadas. :\n " +errosql,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    
            }}});
        
        sair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); 
            }
        });

        add(rusu);
        add(tusu);
        add(rsen);
        add(tsen);
        add(blogar);
        add(sair);

        setSize(420, 260);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        frm_login app = new frm_login();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
