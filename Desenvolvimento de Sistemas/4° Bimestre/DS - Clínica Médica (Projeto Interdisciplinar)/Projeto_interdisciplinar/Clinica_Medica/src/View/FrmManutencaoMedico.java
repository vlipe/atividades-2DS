package View;

import Database.Conexao;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;

public class FrmManutencaoMedico extends JInternalFrame {

    private Conexao con_db;

    private JTextField txtCodigo, txtNome, txtCrm, txtEmail;
    private JPasswordField txtSenha;
    private JComboBox<String> cmbEspecialidade;
    private HashMap<String, Integer> mapaEspecialidades;
    
    private JTable tblMedicos;
    private JScrollPane scp_tabela;

    private JButton bPrim, bAnt, bProx, bUlt;
    private JButton bNovo, bGravar, bAlterar, bExcluir;

    private final Color COR_FUNDO_CLARO = new Color(240, 255, 240);
    private final Color COR_PRINCIPAL_VERDE = new Color(100, 180, 100);
    private final Color COR_TITULO_VERDE = new Color(60, 120, 60);

    public FrmManutencaoMedico(String titulo) {
        super(titulo, true, true, true, true);
        con_db = new Conexao();
        mapaEspecialidades = new HashMap<>();

        setSize(850, 600);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(COR_FUNDO_CLARO);

        inicializarComponentes();
        configurarLayout();
        carregarEspecialidades();
        inicializarDados();
        adicionarListeners();
    }

    private void inicializarComponentes() {
        txtCodigo = new JTextField(5);
        txtCodigo.setEnabled(false);
        txtNome = new JTextField(30); 
        txtCrm = new JTextField(15);
        txtEmail = new JTextField(30);
        txtSenha = new JPasswordField(15);
        cmbEspecialidade = new JComboBox<>();
        
        cmbEspecialidade.setForeground(Color.BLACK);
        
        bPrim = new JButton("<< Primeiro");
        bAnt = new JButton("< Anterior");
        bProx = new JButton("Próximo >");
        bUlt = new JButton("Último >>");
        bNovo = new JButton("Novo Registro");
        bGravar = new JButton("Gravar");
        bAlterar = new JButton("Alterar");
        bExcluir = new JButton("Excluir");

        configurarBotaoNavegacao(bPrim); 
        configurarBotaoNavegacao(bAnt);
        configurarBotaoNavegacao(bProx); 
        configurarBotaoNavegacao(bUlt);
        
        configurarBotaoAcao(bNovo); 
        configurarBotaoAcao(bGravar);
        configurarBotaoAcao(bAlterar); 
        configurarBotaoAcao(bExcluir);
    }
    
    private void configurarLayout() {
        JPanel painelCampos = new JPanel(new GridLayout(3, 4, 15, 10)); 
        painelCampos.setBackground(COR_FUNDO_CLARO);

        TitledBorder borda = BorderFactory.createTitledBorder("Dados do Médico");
        borda.setTitleColor(COR_TITULO_VERDE);
        painelCampos.setBorder(BorderFactory.createCompoundBorder(borda, BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        painelCampos.add(new JLabel("Código:"));
        painelCampos.add(txtCodigo);
        painelCampos.add(new JLabel("CRM:"));
        painelCampos.add(txtCrm);

        painelCampos.add(new JLabel("Nome:"));
        painelCampos.add(txtNome);
        painelCampos.add(new JLabel("Email:"));
        painelCampos.add(txtEmail);

        painelCampos.add(new JLabel("Senha:"));
        painelCampos.add(txtSenha);
        painelCampos.add(new JLabel("Especialidade:"));
        painelCampos.add(cmbEspecialidade);
        
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        painelBotoes.setBackground(COR_FUNDO_CLARO);
        painelBotoes.add(bPrim); painelBotoes.add(bAnt); painelBotoes.add(bProx); painelBotoes.add(bUlt);
        
        JSeparator separador = new JSeparator(JSeparator.VERTICAL);
        separador.setPreferredSize(new Dimension(5, 25)); 
        painelBotoes.add(separador);

        painelBotoes.add(bNovo); painelBotoes.add(bGravar); painelBotoes.add(bAlterar); painelBotoes.add(bExcluir);

        JPanel painelSuperior = new JPanel(new BorderLayout());
        painelSuperior.add(painelCampos, BorderLayout.NORTH);
        painelSuperior.add(painelBotoes, BorderLayout.CENTER);

        add(painelSuperior, BorderLayout.NORTH);

        String[] colunas = {"Código", "Nome", "CRM", "Email", "Especialidade"};
        tblMedicos = new JTable(new DefaultTableModel(colunas, 0));
        scp_tabela = new JScrollPane(tblMedicos);
        add(scp_tabela, BorderLayout.CENTER);
    }
    
    private void carregarEspecialidades() {
        String sql = "SELECT cod_espe, descricao FROM especializacao ORDER BY descricao";
        try {
            con_db.executaSQL(sql);
            ResultSet rs = con_db.resultset;
            
            cmbEspecialidade.removeAllItems();
            mapaEspecialidades.clear();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                int cod_espe = rs.getInt("cod_espe");
                
                mapaEspecialidades.put(descricao, cod_espe);
                cmbEspecialidade.addItem(descricao);
            }
            if (cmbEspecialidade.getItemCount() > 0) {
                cmbEspecialidade.setSelectedIndex(0);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar especialidades: " + e.getMessage(), "Erro SQL", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void configurarBotaoNavegacao(JButton botao) {
        botao.setBackground(COR_TITULO_VERDE); 
        botao.setForeground(Color.BLACK);
        botao.setFocusPainted(false);
    }
    
    private void configurarBotaoAcao(JButton botao) {
        botao.setBackground(COR_PRINCIPAL_VERDE);
        botao.setForeground(Color.BLACK);
        botao.setFocusPainted(false);
    }

    public void preencherTabela(ResultSet rs) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) tblMedicos.getModel();
        modelo.setNumRows(0);
        rs.beforeFirst();

        while (rs.next()) {
            modelo.addRow(new Object[]{
                rs.getInt("cod_medico"),
                rs.getString("nome"),
                rs.getString("crm"),
                rs.getString("email"),
                rs.getString("especialidade_nome")
            });
        }
    }

    public void mostrar_Dados() throws SQLException {
        ResultSet rs = con_db.resultset;
        txtCodigo.setText(String.valueOf(rs.getInt("cod_medico")));
        txtNome.setText(rs.getString("nome"));
        txtCrm.setText(rs.getString("crm"));
        txtEmail.setText(rs.getString("email"));
        txtSenha.setText("");
        
        String especialidade = rs.getString("especialidade_nome");
        if (especialidade != null && cmbEspecialidade.getItemCount() > 0) {
            cmbEspecialidade.setSelectedItem(especialidade);
        } else if (cmbEspecialidade.getItemCount() > 0) {
            cmbEspecialidade.setSelectedIndex(0);
        }
    }

    private void limpar_Dados() {
        txtCodigo.setText("");
        txtNome.setText("");
        txtCrm.setText("");
        txtEmail.setText("");
        txtSenha.setText("");
        if (cmbEspecialidade.getItemCount() > 0) {
            cmbEspecialidade.setSelectedIndex(0);
        }
        txtNome.requestFocus();
    }

    private void inicializarDados() {
        String sql = "SELECT m.cod_medico, m.nome, m.crm, m.email, MAX(es.descricao) AS especialidade_nome "
                   + "FROM medico m "
                   + "LEFT JOIN esp_medico em ON m.cod_medico = em.cod_medico "
                   + "LEFT JOIN especializacao es ON em.cod_espe = es.cod_espe "
                   + "GROUP BY m.cod_medico, m.nome, m.crm, m.email "
                   + "ORDER BY m.cod_medico";

        try {
            con_db.executaSQL(sql);

            preencherTabela(con_db.resultset);

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

    private int getCodEspecialidadeSelecionada() {
        String descricao = (String) cmbEspecialidade.getSelectedItem();
        if (descricao != null && mapaEspecialidades.containsKey(descricao)) {
            return mapaEspecialidades.get(descricao);
        }
        return -1;
    }
    
    private void gravar_Dados() {
        String nome = txtNome.getText().trim();
        String crm = txtCrm.getText().trim();
        String email = txtEmail.getText().trim();
        String senha = new String(txtSenha.getPassword()); 
        int cod_espe = getCodEspecialidadeSelecionada();
        
        if (senha.isEmpty()) {
             senha = "456"; 
        }

        if (nome.isEmpty() || crm.isEmpty() || email.isEmpty() || cod_espe == -1) {
            JOptionPane.showMessageDialog(this, "Nome, CRM, Email e Especialidade são obrigatórios.", "Erro de Validação", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String insert_medico_sql = "INSERT INTO medico (nome, crm, email, senha) VALUES ('" 
                + nome + "', '" + crm + "', '" + email + "', '" + senha + "')";
        
        try {
            con_db.executaUpdate(insert_medico_sql);
            
            String select_last_id_sql = "SELECT cod_medico FROM medico ORDER BY cod_medico DESC LIMIT 1";
            con_db.executaSQL(select_last_id_sql);
            int novo_cod_medico = -1;
            if (con_db.resultset.first()) {
                novo_cod_medico = con_db.resultset.getInt("cod_medico");
            }
            
            if (novo_cod_medico != -1) {
                String insert_esp_medico_sql = "INSERT INTO esp_medico (cod_medico, cod_espe) VALUES (" 
                        + novo_cod_medico + ", " + cod_espe + ")";
                con_db.executaUpdate(insert_esp_medico_sql);
            
                JOptionPane.showMessageDialog(this, "Registro de Médico realizado com sucesso! Senha inicial: " + senha);
                
                inicializarDados();
            } else {
                 JOptionPane.showMessageDialog(this, "Erro ao recuperar o ID do novo médico.", "Erro de SQL", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(this, "Erro ao tentar gravar dados: " + erro.getMessage() + ". Verifique se o CRM ou Email já existe.", "Erro de SQL", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void alterar_Dados() {
        if (txtCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum registro selecionado/carregado para alterar.");
            return;
        }

        String codigo = txtCodigo.getText();
        String nome = txtNome.getText().trim();
        String crm = txtCrm.getText().trim();
        String email = txtEmail.getText().trim();
        String senha = new String(txtSenha.getPassword());
        int cod_espe = getCodEspecialidadeSelecionada();
        
        if (cod_espe == -1) {
             JOptionPane.showMessageDialog(this, "Especialidade é obrigatória.", "Erro de Validação", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String update_medico_sql;
        
        if (!senha.isEmpty()) {
            update_medico_sql = "UPDATE medico SET nome = '" + nome + "', crm = '" + crm + "', email = '" + email + "', senha = '" + senha + "' WHERE cod_medico = " + codigo;
        } else {
            update_medico_sql = "UPDATE medico SET nome = '" + nome + "', crm = '" + crm + "', email = '" + email + "' WHERE cod_medico = " + codigo;
        }


        try {
            con_db.executaUpdate(update_medico_sql);
            
            String delete_esp_medico_sql = "DELETE FROM esp_medico WHERE cod_medico = " + codigo;
            con_db.executaUpdate(delete_esp_medico_sql);
            
            String insert_esp_medico_sql = "INSERT INTO esp_medico (cod_medico, cod_espe) VALUES (" 
                    + codigo + ", " + cod_espe + ")";
            con_db.executaUpdate(insert_esp_medico_sql);
            
            JOptionPane.showMessageDialog(this, "Alteração realizada com sucesso!");
            inicializarDados();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(this, "Erro ao tentar alterar dados: " + erro.getMessage(), "Erro de SQL", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void excluir_Dados() {
        if (txtCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum registro selecionado/carregado para excluir.");
            return;
        }

        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir este Médico? Esta ação é irreversível.", "Confirmação de Exclusão", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            String codigo = txtCodigo.getText();
            
            String delete_esp_medico_sql = "DELETE FROM esp_medico WHERE cod_medico = " + codigo;
            String delete_agenda_sql = "DELETE FROM agenda WHERE cod_medico = " + codigo;
            String delete_medico_sql = "DELETE FROM medico WHERE cod_medico = " + codigo;
            
            try {
                con_db.executaUpdate(delete_esp_medico_sql);
                con_db.executaUpdate(delete_agenda_sql);
                con_db.executaUpdate(delete_medico_sql);
                
                JOptionPane.showMessageDialog(this, "Exclusão realizada com sucesso!");
                inicializarDados();

            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(this, "Erro ao tentar excluir dados. Remova todas as consultas relacionadas antes de excluir o médico: " + erro.getMessage(), "Erro de SQL", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}