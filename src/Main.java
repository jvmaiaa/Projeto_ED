public class Main {

    public static void main(String[] args) {

        ListaSequencial lista = new ListaSequencial(5);

        Aluno aluno1 = new Aluno("2342");
        lista.adiciona(aluno1);
        Aluno aluno2 = new Aluno("644523");
        lista.adiciona(aluno2);
        System.out.println(aluno1);
        System.out.println(aluno2);
        System.out.println(lista);

    }
}
