package controle;

import java.awt.*;
import java.text.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import conexao.Conexao;
import javax.swing.JOptionPane;

import java.sql.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Formulario extends JFrame {

    Conexao con_cliente;

    JLabel rCodigo, rNome, rData, rTelefone, rEmail, rPesquisa;
    JTextField tcodigo, tnome, temail, tpesquisa;
    JFormattedTextField tdata, ttelefone;
    MaskFormatter mData, mTelefone;
    JTable tblClientes;
    JScrollPane scp_tabela;
    JButton primeiro, anterior, proximo, ultimo, novo, gravar, alterar, excluir, pesquisar;

    public Formulario() {
        con_cliente = new Conexao();
        con_cliente.conecta();

        ImageIcon iconeJanela = new ImageIcon("imagens/icone.png");
        setIconImage(iconeJanela.getImage());
        setTitle("Formulário de Informações Pessoais");
        setResizable(false);
        setLayout(null);

        Color corFundo = new Color(250, 250, 245);
        Color corCampos = new Color(255, 255, 255);
        Color corTexto = new Color(70, 70, 70);
        Color corLabel = new Color(100, 100, 100);
        Color corBordaTabela = new Color(200, 200, 200);

        Font fontePadrao = new Font("Poppins", Font.PLAIN, 14);
        Font fonteLabel = new Font("Poppins", Font.BOLD, 13);

        getContentPane().setBackground(corFundo);

        rCodigo = new JLabel("Código:");
        rNome = new JLabel("Nome:");
        rData = new JLabel("Data:");
        rTelefone = new JLabel("Telefone:");
        rEmail = new JLabel("Email:");

        tcodigo = new JTextField();
        tnome = new JTextField();
        temail = new JTextField();

        primeiro = new JButton("Primeiro");
        anterior = new JButton("Anterior");
        proximo = new JButton("Próximo");
        ultimo = new JButton("Último");
        gravar = new JButton("Gravar");
        novo = new JButton("Novo Registro");
        gravar = new JButton("Gravar");
        alterar = new JButton("Alterar");
        excluir = new JButton("Excluir");
        pesquisar = new JButton("Pesquisar");

        try {
            mData = new MaskFormatter("##/##/####");
            mTelefone = new MaskFormatter("(##) ####-####");
            tdata = new JFormattedTextField(mData);
            ttelefone = new JFormattedTextField(mTelefone);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        rCodigo.setBounds(50, 40, 100, 25);
        tcodigo.setBounds(120, 40, 80, 25);

        rNome.setBounds(50, 80, 100, 25);
        tnome.setBounds(120, 80, 250, 25);

        rData.setBounds(50, 120, 100, 25);
        tdata.setBounds(120, 120, 100, 25);

        rTelefone.setBounds(50, 160, 100, 25);
        ttelefone.setBounds(120, 160, 120, 25);

        rEmail.setBounds(280, 120, 100, 25);
        temail.setBounds(330, 120, 220, 25);

        primeiro.setBounds(50, 420, 130, 30);
        anterior.setBounds(190, 420, 130, 30);
        proximo.setBounds(330, 420, 130, 30);
        ultimo.setBounds(470, 420, 130, 30);
        novo.setBounds(50, 460, 130, 30);
        gravar.setBounds(190, 460, 130, 30);
        alterar.setBounds(330, 460, 130, 30);
        excluir.setBounds(470, 460, 130, 30);

        rPesquisa = new JLabel("Pesquisar por nome:");
        rPesquisa.setBounds(50, 500, 150, 25);
        rPesquisa.setFont(fonteLabel);
        rPesquisa.setForeground(corLabel);

        tpesquisa = new JTextField();
        tpesquisa.setBounds(190, 500, 250, 25);
        tpesquisa.setFont(fontePadrao);
        tpesquisa.setBackground(corCampos);
        tpesquisa.setForeground(corTexto);
        tpesquisa.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));

        pesquisar.setBounds(450, 500, 150, 25);

        add(rPesquisa);
        add(tpesquisa);
        add(pesquisar);

        primeiro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                primeiro();
            }
        });

        anterior.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                anterior();
            }
        });

        proximo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                proximo();
            }
        });

        ultimo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ultimo();
            }
        });

        novo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                novo();
            }
        });

        gravar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gravar();
            }
        });

        alterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                alterar();
            }
        });

        excluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                excluir();
            }
        });

        pesquisar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pesquisar();
            }
        });

        JLabel[] rotulos = {rCodigo, rNome, rData, rTelefone, rEmail};
        for (JLabel rotulo : rotulos) {
            rotulo.setFont(fonteLabel);
            rotulo.setForeground(corLabel);
        }

        JTextField[] campos = {tcodigo, tnome, temail, tdata, ttelefone};
        for (JTextField campo : campos) {
            campo.setBackground(corCampos);
            campo.setForeground(corTexto);
            campo.setFont(fontePadrao);
            campo.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));
        }

        add(rCodigo);
        add(tcodigo);
        add(rNome);
        add(tnome);
        add(rData);
        add(tdata);
        add(rTelefone);
        add(ttelefone);
        add(rEmail);
        add(temail);
        add(primeiro);
        add(anterior);
        add(proximo);
        add(ultimo);
        add(novo);
        add(gravar);
        add(alterar);
        add(excluir);

        tblClientes = new JTable();
        scp_tabela = new JScrollPane();

        tblClientes.setBounds(50, 200, 900, 200);
        scp_tabela.setBounds(50, 200, 700, 200);

        add(scp_tabela);

        tblClientes.setBorder(BorderFactory.createLineBorder(corBordaTabela));
        tblClientes.setFont(fontePadrao);
        tblClientes.setRowHeight(24);
        tblClientes.setBackground(Color.WHITE);
        tblClientes.setForeground(corTexto);
        tblClientes.setSelectionBackground(new Color(220, 235, 250));
        tblClientes.setSelectionForeground(Color.BLACK);
        tblClientes.setGridColor(corBordaTabela);

        tblClientes.getTableHeader().setFont(new Font("Poppins", Font.BOLD, 13));
        tblClientes.getTableHeader().setBackground(new Color(240, 240, 240));
        tblClientes.getTableHeader().setForeground(new Color(80, 80, 80));

        primeiro.setBackground(Color.white);
        anterior.setBackground(Color.white);
        proximo.setBackground(Color.white);
        ultimo.setBackground(Color.white);
        novo.setBackground(Color.white);
        gravar.setBackground(Color.white);
        alterar.setBackground(Color.white);
        excluir.setBackground(Color.white);
        pesquisar.setBackground(Color.white);

        tblClientes.setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null}
                },
                new String[]{
                    "Código", "Nome", "Data Nascimento", "Telefone", "Email"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        scp_tabela.setViewportView(tblClientes);
        tblClientes.setAutoCreateRowSorter(true);

        tblClientes.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });

        setSize(1100, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        con_cliente.executaSQL("select * from tbclientes order by cod");
        preencherTabela();
        posicionarRegistro();
    }

    public void tblClientesMouseClicked(MouseEvent evt) {
        if (tblClientes.getSelectedRow() != -1) {
            try {
                int linha = tblClientes.getSelectedRow();
                String cod = tblClientes.getValueAt(linha, 0).toString();
                String nome = tblClientes.getValueAt(linha, 1).toString();
                String dt_nasc = tblClientes.getValueAt(linha, 2).toString();
                String telefone = tblClientes.getValueAt(linha, 3).toString();
                String email = tblClientes.getValueAt(linha, 4).toString();

                tcodigo.setText(cod);
                tnome.setText(nome);
                tdata.setText(dt_nasc);
                ttelefone.setText(telefone);
                temail.setText(email);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao selecionar registro: " + e, "Mensagem do Programa", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void preencherTabela() {
        tblClientes.getColumnModel().getColumn(0).setPreferredWidth(4);
        tblClientes.getColumnModel().getColumn(1).setPreferredWidth(140);
        tblClientes.getColumnModel().getColumn(2).setPreferredWidth(80);
        tblClientes.getColumnModel().getColumn(3).setPreferredWidth(80);
        tblClientes.getColumnModel().getColumn(4).setPreferredWidth(170);

        DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
        modelo.setNumRows(0);

        try {
            con_cliente.resultset.beforeFirst();
            while (con_cliente.resultset.next()) {
                modelo.addRow(new Object[]{
                    con_cliente.resultset.getString("cod"),
                    con_cliente.resultset.getString("nome"),
                    con_cliente.resultset.getString("dt_nasc"),
                    con_cliente.resultset.getString("telefone"),
                    con_cliente.resultset.getString("email")
                });
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "\n Erro ao listar dados da tabela!! :\n " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void posicionarRegistro() {
        try {
            con_cliente.resultset.first();
            mostrar_Dados();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível posicionar no primeiro registro:" + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void mostrar_Dados() {
        try {
            tcodigo.setText(con_cliente.resultset.getString("cod"));
            tnome.setText(con_cliente.resultset.getString("nome"));
            tdata.setText(con_cliente.resultset.getString("dt_nasc"));
            ttelefone.setText(con_cliente.resultset.getString("telefone"));
            temail.setText(con_cliente.resultset.getString("email"));
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não localizou dados: " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void primeiro() {
        try {
            con_cliente.resultset.first();
            mostrar_Dados();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível acessar o primeiro registro.");
        }
    }

    public void anterior() {
        try {
            con_cliente.resultset.previous();
            mostrar_Dados();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível acessar o registro anterior.");
        }
    }

    public void proximo() {
        try {
            con_cliente.resultset.next();
            mostrar_Dados();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível acessar o próximo registro.");
        }
    }

    public void ultimo() {
        try {
            con_cliente.resultset.last();
            mostrar_Dados();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível acessar o último registro.");
        }
    }

    public void novo() {
        tcodigo.setText("");
        tnome.setText("");
        temail.setText("");
        tdata.setText("");
        ttelefone.setText("");
        tcodigo.requestFocus();
    }

    public void gravar() {
        String nome = tnome.getText();
        String data_nasc = tdata.getText();
        String telefone = ttelefone.getText();
        String email = temail.getText();

        try {
            String insert_sql = "insert into tbclientes (nome,telefone, email, dt_nasc) values ('" + nome + "','" + telefone + "','" + email + "','" + data_nasc + "')";
            con_cliente.statement.executeUpdate(insert_sql);
            JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

            con_cliente.executaSQL("select * from tbclientes order by cod");
            preencherTabela();
        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void alterar() {
        String nome = tnome.getText();
        String data_nasc = tdata.getText();
        String telefone = ttelefone.getText();
        String email = temail.getText();
        String sql;

        try {
            if (tcodigo.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecione um registro para alterar.");
            } else {
                sql = "update tbclientes set nome='" + nome + "',telefone='" + telefone + "', email='" + email + "', dt_nasc='" + data_nasc + "' where cod = " + tcodigo.getText();
                con_cliente.statement.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

                con_cliente.executaSQL("select * from tbclientes order by cod");
                preencherTabela();
            }

        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "\n Erro na alteração :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void excluir() {
        String sql = "";
        try {
            int resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja excluir o registro: ", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION, 3);
            if (resposta == 0) {
                sql = "delete from tbclientes where cod = " + tcodigo.getText();
                int excluir = con_cliente.statement.executeUpdate(sql);

                if (excluir == 1) {
                    JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    con_cliente.executaSQL("select * from tbclientes order by cod");
                    con_cliente.resultset.first();
                    preencherTabela();
                    posicionarRegistro();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException excecao) {
            JOptionPane.showMessageDialog(null, "Erro na exclusão: " + excecao, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void pesquisar() {
        String pesquisa = "select * from tbclientes where nome like '" + tpesquisa.getText() + "%'";
        try {
            con_cliente.executaSQL(pesquisa);
            if (con_cliente.resultset.first()) {
                preencherTabela();
            } else {
                JOptionPane.showMessageDialog(null, "\n Não existe dados com este parâmetro!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "\n Os dados digitados não foram localizados!! :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Formulario();
    }
}