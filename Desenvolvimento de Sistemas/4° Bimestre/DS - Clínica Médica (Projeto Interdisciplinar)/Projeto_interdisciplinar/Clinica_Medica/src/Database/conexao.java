package Database;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexao {

    final private String DRIVER = "com.mysql.cj.jdbc.Driver";
    final private String URL = "jdbc:mysql://localhost/clinica_db";
    final private String USUARIO = "root";
    final private String SENHA = "";

    public Connection conexao;
    public Statement statement;
    public ResultSet resultset;

    public Conexao() {
        conecta();
    }

    public void conecta() {
        try {
            Class.forName(DRIVER);

            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

            statement = conexao.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            );

            System.out.println("Conexão estabelecida com sucesso.");

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver MySQL não encontrado: " + e.getMessage(),
                    "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na conexão SQL (Verifique o servidor/credenciais): " + e.getMessage(),
                    "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void executaSQL(String sql) {
        try {
            resultset = statement.executeQuery(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na execução de consulta SQL: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int executaUpdate(String sql) throws SQLException {
        return statement.executeUpdate(sql);
    }

    public void fechaConexao() {
        try {
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
