package Model;

public class Especializacao {

    private int cod_espe;
    private String descricao;

    public Especializacao() {
    }

    public Especializacao(int cod_espe, String descricao) {
        this.cod_espe = cod_espe;
        this.descricao = descricao;
    }

    public int getCod_espe() {
        return cod_espe;
    }

    public void setCod_espe(int cod_espe) {
        this.cod_espe = cod_espe;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
