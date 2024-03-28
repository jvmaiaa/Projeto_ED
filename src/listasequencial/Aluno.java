package listasequencial;

public class Aluno {

    private String rgm;

    public Aluno(){
    }

    public Aluno(String rgm) {
        this.rgm = rgm;
    }

    public String getRgm() {
        return rgm;
    }

    public void setRgm(String rgm) {
        this.rgm = rgm;
    }

    @Override
    public String toString() {
        return "listasequencial.Aluno com rgm:" + rgm;
    }
}
