import listaencadeada.Disciplina;
import listaencadeada.ListaEncadeada;
import listasequencial.Aluno;
import listasequencial.ListaSequencial;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        ListaEncadeada lista = new ListaEncadeada<Disciplina>();
        Disciplina disciplina = new Disciplina("Matemática", 0);
        Disciplina disciplina2 = new Disciplina("História", 1);

        lista.adicionaNoInicioOuNoFim(disciplina);
        lista.adicionaNoInicioOuNoFim(disciplina2);
        System.out.println(lista);
        System.out.println("Tamanho = " + lista.tamanho());
    }
}
