package View;

import javax.swing.*;
import java.awt.*;

public class FrmDesenvolvedor extends JInternalFrame {

    public FrmDesenvolvedor(String titulo) {
        super(titulo, true, true, true, true);
        
        setSize(500, 300);
        setLayout(new BorderLayout());
        
        JTextArea textArea = new JTextArea();
        textArea.setText("Sistema de Gerenciamento de Clínica Médica - Vitalis\n\n"
                       + "Desenvolvido por: \n Antonio Sena \n Felipe Vivêncio \n João Pedro \n\n"
                       + "Tecnologias:\n"
                       + "  - Linguagem: Java (Swing)\n"
                       + "  - Banco de Dados: MySQL\n\n"
                       + "Requisitos:\n"
                       + "  - Implementação de CRUD (Paciente, Médico, Consulta).\n"
                       + "  - Validação de Login com Perfis (Paciente, Medico/Admin).\n"
                       + "  - Manutenção de Paciente restrita ao próprio usuário.\n\n"
                       + "Versão: 1.0");
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textArea.setEditable(false);
        textArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }
}