// classe que mostra resultado do "Jogo" e "Música".

public class JOGOeMUSICA {
    public static void main(String[] args) {

        Jogo jogo1 = new Jogo();
        jogo1.DadosJogo();
        jogo1.apresentarJogo();


        Musica musica1 = new Musica();
        musica1.DadosMusica();
        musica1.apresentarMusica();
        musica1.tocandoMusica();
    }
}

