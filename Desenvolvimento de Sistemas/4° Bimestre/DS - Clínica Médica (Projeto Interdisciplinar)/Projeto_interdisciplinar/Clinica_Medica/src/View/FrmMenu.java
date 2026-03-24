package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;

public class FrmMenu extends JFrame {
    
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuCadastro = new JMenu("Cadastros");
    private JMenu menuAjuda = new JMenu("Ajuda");
    
    private JMenuItem itemPaciente = new JMenuItem("Pacientes (Manutenção)");
    private JMenuItem itemMedico = new JMenuItem("Médicos (CRUD)");
    private JMenuItem itemConsulta = new JMenuItem("Consultas (CRUD)");
    private JMenuItem itemDesenvolvedor = new JMenuItem("Sobre o(s) Desenvolvedor(es)");
    private JMenuItem itemSair = new JMenuItem("Sair");
    
    private JDesktopPane desktop = new JDesktopPane();
    private String perfilUsuario;
    private String emailUsuario;
    
    private final Color COR_FUNDO_CLARO = new Color(240, 255, 240); 

    public FrmMenu(String perfil, String email) {
        super("Vitalis - Clínica Médica DS - Menu Principal (" + perfil + ")");
        this.perfilUsuario = perfil;
        this.emailUsuario = email;
        
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        desktop.setBackground(COR_FUNDO_CLARO);
        
        menuCadastro.add(itemPaciente);
        menuCadastro.add(itemMedico);
        menuCadastro.add(itemConsulta);
        menuCadastro.addSeparator();
        menuCadastro.add(itemSair);
        
        menuAjuda.add(itemDesenvolvedor);
        
        menuBar.add(menuCadastro);
        menuBar.add(menuAjuda);
        setJMenuBar(menuBar);
        
        setContentPane(desktop); 
        
        aplicarPermissoes();
        adicionarListeners();
        
        setVisible(true);
    }
    
    private void aplicarPermissoes() {
        if (perfilUsuario.equals("Paciente")) {
            itemMedico.setVisible(false);
            
        } else if (perfilUsuario.equals("Medico")) {
        }
    }
    
    private void adicionarListeners() {
        itemPaciente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirFormularioManutencao("Paciente");
            }
        });
        
        itemMedico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirFormularioManutencao("Medico");
            }
        });
        
        itemConsulta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirFormularioManutencao("Consulta");
            }
        });
        
        itemDesenvolvedor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirFrmDesenvolvedor();
            }
        });
        
        itemSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int resposta = JOptionPane.showConfirmDialog(FrmMenu.this, "Deseja realmente sair do sistema?", "Confirmação de Saída", JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    System.exit(0); 
                }
            }
        });
    }

    private void abrirFrmDesenvolvedor() {
        String titulo = "Vitalis - Sobre o(s) Desenvolvedor(es)";
        JInternalFrame frm = new FrmDesenvolvedor(titulo);
        desktop.add(frm);
        centralizarEMaximizar(frm);
        frm.setVisible(true);
    }
    
    private void abrirFormularioManutencao(String tipo) {
        JInternalFrame frm = null;
        String titulo = "Vitalis - Manutenção de " + tipo + "s";
        
        for (JInternalFrame frame : desktop.getAllFrames()) {
            if (frame.getTitle().equals(titulo)) {
                frame.toFront();
                try { frame.setSelected(true); } catch (java.beans.PropertyVetoException ignored) {}
                return;
            }
        }
        
        if (tipo.equals("Paciente")) {
             frm = new FrmManutencaoPaciente(titulo, perfilUsuario, emailUsuario); 
        } else if (tipo.equals("Medico")) {
             frm = new FrmManutencaoMedico(titulo);
        } else if (tipo.equals("Consulta")) {
             frm = new FrmManutencaoConsulta(titulo, perfilUsuario, emailUsuario);
        } else {
             return;
        }

        desktop.add(frm);
        centralizarEMaximizar(frm);
        frm.setVisible(true);
    }
    
    private void centralizarEMaximizar(JInternalFrame frm) {
        Dimension desktopSize = desktop.getSize();
        Dimension frameSize = frm.getSize();
        frm.setLocation((desktopSize.width - frameSize.width) / 2, (desktopSize.height - frameSize.height) / 2);

        try {
             frm.setMaximum(true);
             frm.setSelected(true);
        } catch (java.beans.PropertyVetoException ignored) {}
    }
}