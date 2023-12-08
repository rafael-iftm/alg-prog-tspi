package trabalho_disciplina;

import java.util.ArrayList;

public class Consulta {
    private String data;
    private String paciente;
    private ArrayList<Remedio> remedios = new ArrayList<>();

    public Consulta(String data, String paciente) {
        this.data = data;
        this.paciente = paciente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public ArrayList<Remedio> getRemedios() {
        return remedios;
    }

    public void setRemedios(ArrayList<Remedio> remedios) {
        this.remedios = remedios;
    }
}
