public class Main {

    public static void main(String[] args) {

        ListaSequencial<Aluno> lista = new ListaSequencial(4);

        Aluno aluno1 = new Aluno ("92643");
        lista.adicionaNoFim(aluno1);
        Aluno aluno2 = new Aluno ("86346");
        lista.adicionaNoFim(aluno2);
        Aluno aluno3 = new Aluno ("53938");

        System.out.println(lista.contem(aluno1));
        System.out.println(lista.contem(aluno2));
        System.out.println(lista.contem(aluno3));

        System.out.println(lista);
    }
}
