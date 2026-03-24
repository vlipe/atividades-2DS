package Model;

public class EspMedico {

    private int cod_medico;
    private int cod_espe;

    public EspMedico() {
    }

    public EspMedico(int cod_medico, int cod_espe) {
        this.cod_medico = cod_medico;
        this.cod_espe = cod_espe;
    }

    public int getCod_medico() {
        return cod_medico;
    }

    public void setCod_medico(int cod_medico) {
        this.cod_medico = cod_medico;
    }

    public int getCod_espe() {
        return cod_espe;
    }

    public void setCod_espe(int cod_espe) {
        this.cod_espe = cod_espe;
    }
}
