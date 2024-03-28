import listaencadeada.Disciplina;
import listaencadeada.ListaEncadeada;
import listasequencial.Aluno;
import listasequencial.ListaSequencial;

public class Main {

    public static void main(String[] args) {

        ListaEncadeada lista = new ListaEncadeada<Disciplina>();
        Disciplina disciplina = new Disciplina("Matemática", 0);

        lista.adicionaNoInicio(disciplina);
        System.out.println(lista);
        System.out.println("Tamanho = " + lista.tamanho());
    }
}
