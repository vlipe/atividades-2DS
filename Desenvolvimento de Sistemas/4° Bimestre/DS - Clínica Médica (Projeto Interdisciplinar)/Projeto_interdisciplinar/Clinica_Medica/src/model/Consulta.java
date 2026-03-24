package Model;

public class Consulta {
    private int cod_consulta;
    private int cod_paciente;
    private int cod_agenda;
    private String descricao;
    private String status; 
    private String horario; 

    public Consulta() {
    }

    public Consulta(int cod_consulta, int cod_paciente, int cod_agenda, String descricao, String status, String horario) {
        this.cod_consulta = cod_consulta;
        this.cod_paciente = cod_paciente;
        this.cod_agenda = cod_agenda;
        this.descricao = descricao;
        this.status = status;
        this.horario = horario;
    }

    public int getCod_consulta() {
        return cod_consulta;
    }

    public void setCod_consulta(int cod_consulta) {
        this.cod_consulta = cod_consulta;
    }

    public int getCod_paciente() {
        return cod_paciente;
    }

    public void setCod_paciente(int cod_paciente) {
        this.cod_paciente = cod_paciente;
    }

    public int getCod_agenda() {
        return cod_agenda;
    }

    public void setCod_agenda(int cod_agenda) {
        this.cod_agenda = cod_agenda;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}