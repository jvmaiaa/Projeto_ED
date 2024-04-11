package listaencadeada;

import java.util.StringJoiner;

public class Disciplina {

    private String disciplina;
    private double nota;

    public Disciplina(){
    }

    public Disciplina(String disciplina, double nota) {
        this.disciplina = disciplina;
        this.nota = nota;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Disciplina: " + disciplina + ", Nota: " + nota;
    }
}
