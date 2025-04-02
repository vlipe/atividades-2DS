import javax.swing.JOptionPane;

public class Musica {
    private String nome;
    private String cantor;
    private String album;
    private double duracao;
    private String genero;

    
    public Musica() {
    }

    public String getNome() {
        return nome;
    }

    public String getCantor() {
        return cantor;
    }

    public String getAlbum() {
        return album;
    }

    public double getDuracao() {
        return duracao;
    }

    public String getGenero() {
        return genero;
    }

    public void DadosMusica() {
        this.nome = JOptionPane.showInputDialog("Por favor, informe o nome da música:");
        this.cantor = JOptionPane.showInputDialog("Por favor, informe o cantor:");
        this.album = JOptionPane.showInputDialog("Por favor, informe o álbum:");
        this.duracao = Double.parseDouble(JOptionPane.showInputDialog("Por favor, informe a duração (em minutos):"));
        this.genero = JOptionPane.showInputDialog("Por favor, informe o gênero da música:");
    }

    public void apresentarMusica() {
        String mensagem = "Música: " + getNome() +
                          "\nCantor: " + getCantor() +
                          "\nÁlbum: " + getAlbum() +
                          "\nDuração: " + getDuracao() + " min" +
                          "\nGênero: " + getGenero();
        JOptionPane.showMessageDialog(null, mensagem);
    }

    public void tocandoMusica() {
        JOptionPane.showMessageDialog(null, "Agora está tocando: " + getNome() + " - " + getCantor());
    }
}
