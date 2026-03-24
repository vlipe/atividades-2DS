package View;

import Database.Conexao;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class FrmManutencaoConsulta extends JInternalFrame {

    private Conexao con_db;

    private JTextField txtCodigo, txtCodPaciente, txtHorario, txtStatus;
    private JComboBox<String> cmbAgenda;
    private JTextArea txtDescricao;
    private JTable tblConsultas;
    private JScrollPane scp_tabela;

    private JButton bPrim, bAnt, bProx, bUlt;
    private JButton bNovo, bGravar, bAlterar, bExcluir;

    private String perfilUsuario;
    private String emailUsuario;
    private boolean isAcessoPaciente;
    private boolean isAcessoMedico;
    private int codPacienteLogado = -1;
    private int codMedicoLogado = -1;

    private Map<String, Integer> mapAgenda = new HashMap<>();

    private final Color COR_FUNDO_CLARO = new Color(240, 255, 240);
    private final Color COR_PRINCIPAL_VERDE = new Color(100, 180, 100);
    private final Color COR_TITULO_VERDE = new Color(60, 120, 60);
    private final String STATUS_PADRAO_PACIENTE = "Não Concluída";
    private final String STATUS_PADRAO_MEDICO = "Pendente";

    public FrmManutencaoConsulta(String titulo, String perfil, String email) {
        super(titulo, true, true, true, true);
        con_db = new Conexao();

        this.perfilUsuario = perfil;
        this.emailUsuario = email;
        this.isAcessoPaciente = perfil.equals("Paciente");
        this.isAcessoMedico = perfil.equals("Medico");

        setSize(900, 650);
        setLayout(new BorderLayout());
        getContentPane().setBackground(COR_FUNDO_CLARO);

        inicializarComponentes();
        configurarLayout();
        aplicarRestricoes();
        preencherComboAgenda();
        inicializarDados();
        adicionarListeners();
    }

    private void inicializarComponentes() {
        txtCodigo = new JTextField(5);
        txtCodigo.setEnabled(false);
        txtCodPaciente = new JTextField(5);
        cmbAgenda = new JComboBox<>();
        txtHorario = new JTextField(15);
        txtStatus = new JTextField(15);
        txtDescricao = new JTextArea(3, 20);

        bPrim = new JButton("<< Primeiro");
        bAnt = new JButton("< Anterior");
        bProx = new JButton("Próximo >");
        bUlt = new JButton("Último >>");
        bNovo = new JButton("Novo Registro");
        bGravar = new JButton("Gravar");
        bAlterar = new JButton("Alterar");
        bExcluir = new JButton("Excluir");

        configurarBotao(bPrim);
        configurarBotao(bAnt);
        configurarBotao(bProx);
        configurarBotao(bUlt);
        configurarBotao(bNovo);
        configurarBotao(bGravar);
        configurarBotao(bAlterar);
        configurarBotao(bExcluir);
    }

    private void configurarLayout() {
        JPanel painelCampos = new JPanel(new GridBagLayout());
        painelCampos.setBackground(COR_FUNDO_CLARO);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        TitledBorder borda = BorderFactory.createTitledBorder("Dados da Consulta");
        borda.setTitleColor(COR_TITULO_VERDE);
        painelCampos.setBorder(borda);

        gbc.gridx = 0;
        gbc.gridy = 0;
        painelCampos.add(new JLabel("Código:"), gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        painelCampos.add(new JLabel("Cód. Paciente:"), gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        painelCampos.add(new JLabel("Médico/Agenda:"), gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        painelCampos.add(new JLabel("Horário (AAAA-MM-DD HH:MM):"), gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        painelCampos.add(new JLabel("Status:"), gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        painelCampos.add(new JLabel("Descrição:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        painelCampos.add(txtCodigo, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        painelCampos.add(txtCodPaciente, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        painelCampos.add(cmbAgenda, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        painelCampos.add(txtHorario, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        painelCampos.add(txtStatus, gbc);

        JScrollPane scpDescricao = new JScrollPane(txtDescricao);
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.weighty = 0.5;
        gbc.ipady = 50;
        painelCampos.add(scpDescricao, gbc);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        painelBotoes.setBackground(COR_FUNDO_CLARO);
        painelBotoes.add(bPrim);
        painelBotoes.add(bAnt);
        painelBotoes.add(bProx);
        painelBotoes.add(bUlt);
        painelBotoes.add(new JSeparator(JSeparator.VERTICAL));
        painelBotoes.add(bNovo);
        painelBotoes.add(bGravar);
        painelBotoes.add(bAlterar);
        painelBotoes.add(bExcluir);

        JPanel painelSuperior = new JPanel(new BorderLayout());
        painelSuperior.add(painelCampos, BorderLayout.NORTH);
        painelSuperior.add(painelBotoes, BorderLayout.CENTER);

        add(painelSuperior, BorderLayout.NORTH);

        String[] colunas = {"Código", "Paciente", "Agenda", "Horário", "Status", "Descrição"};
        tblConsultas = new JTable(new DefaultTableModel(colunas, 0));
        scp_tabela = new JScrollPane(tblConsultas);
        add(scp_tabela, BorderLayout.CENTER);
    }

    private int buscarCodPaciente(String email) {
        String sql = "SELECT cod_paciente FROM paciente WHERE email = '" + email + "'";
        try {
            con_db.executaSQL(sql);
            if (con_db.resultset.first()) {
                return con_db.resultset.getInt("cod_paciente");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar Cód. Paciente: " + e.getMessage(), "Erro SQL", JOptionPane.ERROR_MESSAGE);
        }
        return -1;
    }

    private int buscarCodMedico(String email) {
        String sql = "SELECT cod_medico FROM medico WHERE email = '" + email + "'";
        try {
            con_db.executaSQL(sql);
            if (con_db.resultset.first()) {
                return con_db.resultset.getInt("cod_medico");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar Cód. Médico: " + e.getMessage(), "Erro SQL", JOptionPane.ERROR_MESSAGE);
        }
        return -1;
    }

    private void preencherComboAgenda() {
        String sql = "SELECT a.cod_agenda, m.nome, m.crm FROM agenda a INNER JOIN medico m ON a.cod_medico = m.cod_medico ORDER BY m.nome";

        cmbAgenda.removeAllItems();
        mapAgenda.clear();

        try {
            con_db.executaSQL(sql);
            ResultSet rs = con_db.resultset;
            while (rs.next()) {
                int codAgenda = rs.getInt("cod_agenda");
                String nomeMedico = rs.getString("nome");
                String itemCombo = nomeMedico + " (Cód. Agenda: " + codAgenda + ")";

                cmbAgenda.addItem(itemCombo);
                mapAgenda.put(itemCombo, codAgenda);
            }
            if (cmbAgenda.getItemCount() == 0) {
                cmbAgenda.addItem("Nenhuma Agenda Encontrada");
                cmbAgenda.setEnabled(false);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar Agendas: " + e.getMessage(), "Erro SQL", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void aplicarRestricoes() {
        if (isAcessoPaciente) {
            codPacienteLogado = buscarCodPaciente(emailUsuario);

            txtCodPaciente.setText(String.valueOf(codPacienteLogado));
            txtCodPaciente.setEnabled(false);

            txtCodigo.setVisible(false);

            txtStatus.setEnabled(false);

            bPrim.setVisible(false);
            bAnt.setVisible(false);
            bProx.setVisible(false);
            bUlt.setVisible(false);
            scp_tabela.setVisible(false);

        } else if (isAcessoMedico) {
            codMedicoLogado = buscarCodMedico(emailUsuario);

            txtCodPaciente.setEnabled(false);
            cmbAgenda.setEnabled(false);

            txtStatus.setEnabled(true);

            bNovo.setVisible(false);
            bGravar.setVisible(false);
            bExcluir.setVisible(false);
        } else {
            txtStatus.setEnabled(true);
            txtCodPaciente.setEnabled(true);
        }
    }

    private void configurarBotao(JButton botao) {
        botao.setBackground(COR_PRINCIPAL_VERDE);
        botao.setForeground(Color.BLACK);
        botao.setFocusPainted(false);
    }

    public void preencherTabela(ResultSet rs) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) tblConsultas.getModel();
        modelo.setNumRows(0);
        rs.beforeFirst();

        while (rs.next()) {
            modelo.addRow(new Object[]{
                rs.getInt("cod_consulta"),
                rs.getInt("cod_paciente"),
                rs.getInt("cod_agenda"),
                rs.getString("horario"),
                rs.getString("statusC"),
                rs.getString("descricao")
            });
        }
    }

    public void mostrar_Dados() throws SQLException {
        ResultSet rs = con_db.resultset;
        txtCodigo.setText(String.valueOf(rs.getInt("cod_consulta")));
        txtCodPaciente.setText(String.valueOf(rs.getInt("cod_paciente")));
        txtHorario.setText(rs.getString("horario"));
        txtStatus.setText(rs.getString("statusC"));
        txtDescricao.setText(rs.getString("descricao"));

        int codAgenda = rs.getInt("cod_agenda");
        for (Map.Entry<String, Integer> entry : mapAgenda.entrySet()) {
            if (entry.getValue().equals(codAgenda)) {
                cmbAgenda.setSelectedItem(entry.getKey());
                break;
            }
        }

        if (isAcessoPaciente) {
            txtStatus.setEnabled(false);
        } else if (isAcessoMedico) {
            txtCodPaciente.setEnabled(false);
            cmbAgenda.setEnabled(false);
        }
    }

    private void limpar_Dados() {
        txtCodigo.setText("");
        cmbAgenda.setSelectedIndex(0);
        txtHorario.setText("");
        txtDescricao.setText("");

        if (isAcessoPaciente) {
            txtCodPaciente.setText(String.valueOf(codPacienteLogado));
            txtCodPaciente.setEnabled(false);
            txtStatus.setText(STATUS_PADRAO_PACIENTE);
            txtStatus.setEnabled(false);
        } else if (isAcessoMedico) {
            txtCodPaciente.setText("");
            txtCodPaciente.setEnabled(false);
            txtStatus.setText(STATUS_PADRAO_MEDICO);
            txtStatus.setEnabled(true);
        } else {
            txtCodPaciente.setText("");
            txtCodPaciente.setEnabled(true);
            txtStatus.setText(STATUS_PADRAO_MEDICO);
            txtStatus.setEnabled(true);
        }

        txtHorario.requestFocus();
    }

    private void inicializarDados() {
        if (codPacienteLogado == -1 && isAcessoPaciente) {
            codPacienteLogado = buscarCodPaciente(emailUsuario);
        }
        if (codMedicoLogado == -1 && isAcessoMedico) {
            codMedicoLogado = buscarCodMedico(emailUsuario);
        }

        String sql;
        if (isAcessoPaciente && codPacienteLogado > 0) {
            sql = "SELECT * FROM consulta WHERE cod_paciente = " + codPacienteLogado + " ORDER BY cod_consulta";
        } else if (isAcessoMedico && codMedicoLogado > 0) {
            sql = "SELECT c.* FROM consulta c "
                    + "INNER JOIN agenda a ON c.cod_agenda = a.cod_agenda "
                    + "WHERE a.cod_medico = " + codMedicoLogado + " ORDER BY c.horario DESC";
        } else {
            sql = "SELECT * FROM consulta ORDER BY cod_consulta";
        }

        try {
            con_db.executaSQL(sql);

            if (!isAcessoPaciente) {
                preencherTabela(con_db.resultset);
            }

            if (con_db.resultset.first()) {
                mostrar_Dados();
            } else {
                limpar_Dados();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados: " + e.getMessage(), "Erro SQL", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void adicionarListeners() {
        bPrim.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (con_db.resultset.first()) {
                        mostrar_Dados();
                    }
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "Não foi possível acessar o primeiro registro.");
                }
            }
        });
        bAnt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (con_db.resultset.previous()) {
                        mostrar_Dados();
                    }
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "Não foi possível acessar o registro anterior.");
                }
            }
        });
        bProx.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (con_db.resultset.next()) {
                        mostrar_Dados();
                    }
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "Não foi possível acessar o próximo registro.");
                }
            }
        });
        bUlt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (con_db.resultset.last()) {
                        mostrar_Dados();
                    }
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "Não foi possível acessar o último registro.");
                }
            }
        });

        bNovo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpar_Dados();
            }
        });
        bGravar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gravar_Dados();
            }
        });
        bAlterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                alterar_Dados();
            }
        });
        bExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                excluir_Dados();
            }
        });
    }

    private void gravar_Dados() {
        String codPaciente = txtCodPaciente.getText().trim();
        String horario = txtHorario.getText().trim();
        String descricao = txtDescricao.getText().trim();
        String itemSelecionado = (String) cmbAgenda.getSelectedItem();

        if (codPaciente.isEmpty() || itemSelecionado == null || horario.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Paciente, Médico/Agenda e Horário são obrigatórios.", "Erro de Validação", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Integer codAgenda = mapAgenda.get(itemSelecionado);
        if (codAgenda == null) {
            JOptionPane.showMessageDialog(this, "Nenhuma Agenda válida selecionada.", "Erro de Validação", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String status = isAcessoPaciente ? STATUS_PADRAO_PACIENTE : STATUS_PADRAO_MEDICO;

        String insert_sql = "INSERT INTO consulta (cod_paciente, cod_agenda, descricao, statusC, horario) VALUES ("
                + codPaciente + ", " + codAgenda + ", '" + descricao + "', '" + status + "', '" + horario + "')";

        try {
            con_db.executaUpdate(insert_sql);
            JOptionPane.showMessageDialog(this, "Agendamento de Consulta realizado com sucesso! Status: " + status);
            inicializarDados();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(this, "Erro ao tentar agendar a consulta: " + erro.getMessage() + ". Verifique o formato do Horário (AAAA-MM-DD HH:MM).", "Erro de SQL", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void alterar_Dados() {
        if (txtCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum registro selecionado/carregado para alterar.");
            return;
        }

        String codigo = txtCodigo.getText();
        String codPaciente = txtCodPaciente.getText().trim();
        String horario = txtHorario.getText().trim();
        String descricao = txtDescricao.getText().trim();
        String itemSelecionado = (String) cmbAgenda.getSelectedItem();

        Integer codAgenda = mapAgenda.get(itemSelecionado);
        if (codAgenda == null) {
            JOptionPane.showMessageDialog(this, "Nenhuma Agenda válida selecionada.", "Erro de Validação", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (isAcessoPaciente) {
            if (!codPaciente.equals(String.valueOf(codPacienteLogado))) {
                JOptionPane.showMessageDialog(this, "Você só pode alterar suas próprias consultas.", "Acesso Negado", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else if (isAcessoMedico) {
            String sqlAgendaConsulta = "SELECT a.cod_medico FROM consulta c INNER JOIN agenda a ON c.cod_agenda = a.cod_agenda WHERE c.cod_consulta = " + codigo;
            try {
                con_db.executaSQL(sqlAgendaConsulta);
                if (con_db.resultset.first()) {
                    int codMedicoConsulta = con_db.resultset.getInt("cod_medico");
                    if (codMedicoConsulta != codMedicoLogado) {
                        JOptionPane.showMessageDialog(this, "Você só pode alterar consultas em sua agenda.", "Acesso Negado", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Erro ao verificar agenda do médico: " + e.getMessage(), "Erro SQL", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        String status = txtStatus.getText().trim();

        String update_sql = "UPDATE consulta SET cod_paciente = " + codPaciente + ", cod_agenda = " + codAgenda
                + ", descricao = '" + descricao + "', statusC = '" + status + "', horario = '" + horario + "' WHERE cod_consulta = " + codigo;

        try {
            con_db.executaUpdate(update_sql);
            JOptionPane.showMessageDialog(this, "Alteração realizada com sucesso!");
            inicializarDados();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(this, "Erro ao tentar alterar dados: " + erro.getMessage() + ". Verifique o formato do Horário (AAAA-MM-DD HH:MM).", "Erro de SQL", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void excluir_Dados() {
        if (txtCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum registro selecionado/carregado para excluir.");
            return;
        }

        if (isAcessoPaciente) {
            String codPacienteRegistro = txtCodPaciente.getText().trim();
            if (!codPacienteRegistro.equals(String.valueOf(codPacienteLogado))) {
                JOptionPane.showMessageDialog(this, "Você só pode excluir suas próprias consultas.", "Acesso Negado", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else if (isAcessoMedico) {
            JOptionPane.showMessageDialog(this, "Médicos não podem excluir consultas diretamente. Por favor, altere o status para 'Cancelada'.", "Acesso Negado", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente cancelar/excluir esta Consulta?", "Confirmação de Exclusão", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            String codigo = txtCodigo.getText();
            String delete_sql = "DELETE FROM consulta WHERE cod_consulta = " + codigo;

            try {
                con_db.executaUpdate(delete_sql);
                JOptionPane.showMessageDialog(this, "Consulta excluída/cancelada com sucesso!");
                inicializarDados();

            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(this, "Erro ao tentar excluir dados: " + erro.getMessage(), "Erro de SQL", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
