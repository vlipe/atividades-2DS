package View;

import Database.Conexao;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.sql.ResultSet;

public class FrmLogin extends JFrame {

    private Conexao con_db; 

    private JLabel lblUsuario = new JLabel("Usuário (E-mail):"); 
    private JTextField txtUsuario = new JTextField(15);
    private JLabel lblSenha = new JLabel("Senha:");
    private JPasswordField txtSenha = new JPasswordField(15);
    private JButton btnLogar = new JButton("Logar");

    public FrmLogin() {
        super("Vitalis - Acesso ao Sistema");
        con_db = new Conexao(); 

        getContentPane().setBackground(new Color(240, 255, 240)); 

        setLayout(null);
        setSize(320, 260); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblUsuario.setBounds(30, 10, 250, 25);
        txtUsuario.setBounds(30, 35, 250, 25);
        lblSenha.setBounds(30, 70, 80, 25);
        txtSenha.setBounds(30, 95, 250, 25);
        btnLogar.setBounds(110, 140, 100, 30);

        btnLogar.setBackground(new Color(100, 180, 100)); 
        btnLogar.setForeground(Color.BLACK); 
        btnLogar.setFont(new Font("Arial", Font.BOLD, 12));

        add(lblUsuario);
        add(txtUsuario);
        add(lblSenha);
        add(txtSenha);
        add(btnLogar);

        btnLogar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validarLogin();
            }
        });

        setVisible(true);
    }
    
    private void validarLogin() {
        String email = txtUsuario.getText().trim();
        String senhaPura = new String(txtSenha.getPassword()); 
        String perfil = null;
        boolean autenticado = false;

        String sqlPaciente = "SELECT * FROM paciente WHERE email = '" + email + "' AND senha = '" + senhaPura + "'";

        try {
            con_db.executaSQL(sqlPaciente);
            if (con_db.resultset.next()) {
                perfil = "Paciente";
                autenticado = true;
            }
        } catch (SQLException erro) {
             JOptionPane.showMessageDialog(this, "Erro ao buscar Paciente (SQL): " + erro.getMessage(), "Erro de Banco de Dados", JOptionPane.ERROR_MESSAGE);
             return;
        }

        if (!autenticado) {
            String sqlMedico = "SELECT * FROM medico WHERE email = '" + email + "' AND senha = '" + senhaPura + "'";
            try {
                con_db.executaSQL(sqlMedico);
                if (con_db.resultset.next()) {
                    perfil = "Medico";
                    autenticado = true;
                }
            } catch (SQLException erro) {
                 JOptionPane.showMessageDialog(this, "Erro ao buscar Médico (SQL): " + erro.getMessage(), "Erro de Banco de Dados", JOptionPane.ERROR_MESSAGE);
                 return;
            }
        }
        
        if (autenticado) {
            JOptionPane.showMessageDialog(this, "Login efetuado com sucesso como " + perfil + "!", "Acesso Permitido", JOptionPane.INFORMATION_MESSAGE);
            FrmMenu menu = new FrmMenu(perfil, email);
            menu.setVisible(true);
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(this, 
                "E-mail ou Senha inválidos.", 
                "Acesso Negado", JOptionPane.ERROR_MESSAGE);
            txtSenha.setText("");
            txtUsuario.requestFocus();
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        new FrmLogin();
    }
}