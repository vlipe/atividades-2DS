import javax.swing.JOptionPane;

public class Jogo {
    private String nome;
    private String plataforma;
    private double preco;
    private String genero;

    public void DadosJogo() {
        this.nome = JOptionPane.showInputDialog("Por favor, informe o nome do jogo:");
        this.plataforma = JOptionPane.showInputDialog("Por favor, informe a plataforma do jogo:");
        this.preco = Double.parseDouble(JOptionPane.showInputDialog("Por favor, informe o preço do jogo:"));
        this.genero = JOptionPane.showInputDialog("Por favor, informe o gênero do jogo:");
    }

    public void apresentarJogo() {
        
        String mensagem = "Jogo: " + nome +
                          "\nPlataforma: " + plataforma +
                          "\nPreço: R$ " + preco +
                          "\nGênero: " + genero;
        JOptionPane.showMessageDialog(null, mensagem);
    }
}
