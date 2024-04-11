package listasequencial;

import listaencadeada.Disciplina;
import listaencadeada.ListaEncadeada;

public class Aluno {

    private String rgm;
    private ListaEncadeada<Disciplina> disciplinas;

    public Aluno(){
    }

    public Aluno(String rgm, ListaEncadeada<Disciplina> disciplinas) {
        this.rgm = rgm;
        this.disciplinas = disciplinas;
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

    public ListaEncadeada<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ListaEncadeada<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

//    public void adicionaDisciplina(Disciplina disciplina){
//        this.disciplinas.adicionaNoInicioOuNoFim(disciplina);;
//    }

    @Override
    public String toString() {
        return "Aluno com rgm: " + rgm;
    }
}
