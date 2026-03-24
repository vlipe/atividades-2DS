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

public class FrmManutencaoPaciente extends JInternalFrame {

    private Conexao con_db;

    private JTextField txtCodigo, txtNome, txtRg, txtEmail, txtDataNasc;
    private JTable tblPacientes;
    private JScrollPane scp_tabela;

    private JButton bPrim, bAnt, bProx, bUlt;
    private JButton bNovo, bGravar, bAlterar, bExcluir;

    private String perfilUsuario;
    private String emailUsuario;
    private boolean isAcessoRestrito;

    private final Color COR_FUNDO_CLARO = new Color(240, 255, 240);
    private final Color COR_PRINCIPAL_VERDE = new Color(100, 180, 100);
    private final Color COR_TITULO_VERDE = new Color(60, 120, 60);

    public FrmManutencaoPaciente(String titulo, String perfil, String email) {
        super(titulo, true, true, true, true);
        con_db = new Conexao();
        this.perfilUsuario = perfil;
        this.emailUsuario = email;
        this.isAcessoRestrito = perfil.equals("Paciente");

        setSize(850, 600);
        setLayout(new BorderLayout());
        getContentPane().setBackground(COR_FUNDO_CLARO);

        txtCodigo = new JTextField(5);
        txtCodigo.setEnabled(false);
        txtNome = new JTextField(20);
        txtRg = new JTextField(14);
        txtDataNasc = new JTextField(10);
        txtEmail = new JTextField(30);

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

        JPanel painelCampos = new JPanel(new GridLayout(3, 4, 10, 5));
        painelCampos.setBackground(COR_FUNDO_CLARO);

        TitledBorder borda = BorderFactory.createTitledBorder("Dados do Paciente");
        borda.setTitleColor(COR_TITULO_VERDE);
        painelCampos.setBorder(borda);

        painelCampos.add(new JLabel("Código:"));
        painelCampos.add(txtCodigo);
        painelCampos.add(new JLabel("RG:"));
        painelCampos.add(txtRg);
        painelCampos.add(new JLabel("Nome:"));
        painelCampos.add(txtNome);
        painelCampos.add(new JLabel("Data Nasc.:"));
        painelCampos.add(txtDataNasc);
        painelCampos.add(new JLabel("Email:"));
        painelCampos.add(txtEmail);
        painelCampos.add(new JLabel(""));
        painelCampos.add(new JLabel(""));

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

        String[] colunas = {"Código", "Nome", "RG", "Data Nasc.", "Email"};
        tblPacientes = new JTable(new DefaultTableModel(colunas, 0));
        scp_tabela = new JScrollPane(tblPacientes);
        add(scp_tabela, BorderLayout.CENTER);

        aplicarRestricoes();

        inicializarDados();
        adicionarListeners();
    }

    private void aplicarRestricoes() {
        if (isAcessoRestrito) {
            bPrim.setVisible(false);
            bAnt.setVisible(false);
            bProx.setVisible(false);
            bUlt.setVisible(false);
            bNovo.setVisible(false);
            bGravar.setVisible(false);

            scp_tabela.setVisible(false);
            txtEmail.setEnabled(false);
        }
    }

    private void configurarBotao(JButton botao) {
        botao.setBackground(COR_PRINCIPAL_VERDE);
        botao.setForeground(Color.BLACK);
        botao.setFocusPainted(false);
    }

    public void preencherTabela(ResultSet rs) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) tblPacientes.getModel();
        modelo.setNumRows(0);
        rs.beforeFirst();

        while (rs.next()) {
            modelo.addRow(new Object[]{
                rs.getInt("cod_paciente"),
                rs.getString("nome"),
                rs.getString("rg"),
                rs.getString("data_nasc"),
                rs.getString("email")
            });
        }
    }

    public void mostrar_Dados() throws SQLException {
        ResultSet rs = con_db.resultset;
        txtCodigo.setText(String.valueOf(rs.getInt("cod_paciente")));
        txtNome.setText(rs.getString("nome"));
        txtRg.setText(rs.getString("rg"));
        txtDataNasc.setText(rs.getString("data_nasc"));
        txtEmail.setText(rs.getString("email"));
    }

    private void limpar_Dados() {
        txtCodigo.setText("");
        txtNome.setText("");
        txtRg.setText("");
        txtDataNasc.setText("");
        txtEmail.setText("");
        txtNome.requestFocus();
    }

    private void inicializarDados() {
        String sql;

        if (isAcessoRestrito) {
            sql = "SELECT cod_paciente, nome, rg, data_nasc, email FROM paciente WHERE email = '" + emailUsuario + "'";
        } else {
            sql = "SELECT cod_paciente, nome, rg, data_nasc, email FROM paciente ORDER BY cod_paciente";
        }

        try {
            con_db.executaSQL(sql);

            if (!isAcessoRestrito) {
                preencherTabela(con_db.resultset);
            }

            if (con_db.resultset.first()) {
                mostrar_Dados();
            } else {
                limpar_Dados();
                if (isAcessoRestrito) {
                    JOptionPane.showMessageDialog(this, "Seu registro não foi encontrado.", "Erro de Acesso", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados: " + e.getMessage(), "Erro SQL", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void adicionarListeners() {
        bPrim.addActionListener(e -> {
            try {
                if (con_db.resultset.first()) {
                    mostrar_Dados();
                }
            } catch (SQLException erro) {
                /* ignore */ }
        });
        bAnt.addActionListener(e -> {
            try {
                if (con_db.resultset.previous()) {
                    mostrar_Dados();
                }
            } catch (SQLException erro) {
                /* ignore */ }
        });
        bProx.addActionListener(e -> {
            try {
                if (con_db.resultset.next()) {
                    mostrar_Dados();
                }
            } catch (SQLException erro) {
                /* ignore */ }
        });
        bUlt.addActionListener(e -> {
            try {
                if (con_db.resultset.last()) {
                    mostrar_Dados();
                }
            } catch (SQLException erro) {
                /* ignore */ }
        });

        bNovo.addActionListener(e -> limpar_Dados());
        bGravar.addActionListener(e -> gravar_Dados());
        bAlterar.addActionListener(e -> alterar_Dados());
        bExcluir.addActionListener(e -> excluir_Dados());
    }

    private void gravar_Dados() {
        if (isAcessoRestrito) {
            JOptionPane.showMessageDialog(this, "Acesso negado para criação de novos registros.", "Acesso Negado", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nome = txtNome.getText().trim();
        String rg = txtRg.getText().trim();
        String dataNasc = txtDataNasc.getText().trim();
        String email = txtEmail.getText().trim();
        String senha = "123";

        if (nome.isEmpty() || rg.isEmpty() || dataNasc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nome, RG e Data de Nasc. são obrigatórios.", "Erro de Validação", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String insert_sql = "INSERT INTO paciente (nome, rg, data_nasc, email, senha) VALUES ('" + nome + "', '" + rg + "', '" + dataNasc + "', '" + email + "', '" + senha + "')";

        try {
            con_db.executaUpdate(insert_sql);
            JOptionPane.showMessageDialog(this, "Gravação realizada com sucesso!");
            inicializarDados();
            con_db.resultset.last();
            mostrar_Dados();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(this, "Erro ao tentar gravar dados: " + erro.getMessage(), "Erro de SQL", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void alterar_Dados() {
        if (txtCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum registro selecionado/carregado para alterar.");
            return;
        }

        String codigo = txtCodigo.getText();
        String nome = txtNome.getText().trim();
        String rg = txtRg.getText().trim();
        String dataNasc = txtDataNasc.getText().trim();
        String email = isAcessoRestrito ? emailUsuario : txtEmail.getText().trim();

        String update_sql = "UPDATE paciente SET nome = '" + nome + "', rg = '" + rg + "', data_nasc = '" + dataNasc + "' WHERE cod_paciente = " + codigo;

        try {
            con_db.executaUpdate(update_sql);
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

        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir " + (isAcessoRestrito ? "sua conta" : "este registro") + "? Esta ação é irreversível.", "Confirmação de Exclusão", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            String codigo = txtCodigo.getText();
            String delete_sql = "DELETE FROM paciente WHERE cod_paciente = " + codigo;

            try {
                con_db.executaUpdate(delete_sql);
                JOptionPane.showMessageDialog(this, "Exclusão realizada com sucesso!");

                if (isAcessoRestrito) {
                    JFrame menuFrame = (JFrame) SwingUtilities.getWindowAncestor(FrmManutencaoPaciente.this.getParent());
                    if (menuFrame != null && menuFrame instanceof FrmMenu) {
                        menuFrame.dispose();
                    }
                    new FrmLogin().setVisible(true);
                } else {
                    inicializarDados();
                }

            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(this, "Erro ao tentar excluir dados: " + erro.getMessage(), "Erro de SQL", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
