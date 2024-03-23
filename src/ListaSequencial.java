import java.util.Arrays;

public class ListaSequencial {

    private Aluno[] alunos;
    private int tamanho;

    public ListaSequencial(int capacidade){
        this.alunos = new Aluno[capacidade];
        this.tamanho = 0;
    }

    public boolean adiciona(Aluno aluno){
       if (this.tamanho < this.alunos.length){
           this.alunos[tamanho] = aluno;
           this.tamanho++;
           return true;
       }
       return false;
    }

    public Aluno buscaPorIndice(int posicao){
        if(!(posicao >= 0 && posicao < this.tamanho)){
            throw new IllegalArgumentException("Posição inválida");
        }
        return this.alunos[posicao];
    }

    public int buscaPorElemento(Aluno aluno){
        for(int i = 0; i < this.tamanho; i++){
            if(this.alunos[i].equals(aluno)){
                return i;
            }
        }
        return -1;
    }

    public int tamanho(){
        return this.tamanho;
    }

    public boolean estaVazia(){
        return this.tamanho == 0;
    }

    public boolean estaCheia(){
        return this.tamanho == this.alunos.length;
    }

    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();

        s.append("[");

        // iteração até length -1 para fechar o ]
        // o i vai até o penúltimo elemento da lista
        for (int i = 0; i < this.tamanho-1; i++){
            s.append(this.alunos[i]);
            s.append(", ");
        }

        // verifica se há elemento na lista
        // depois adiciona à lista o último elemento sem a vírgula
        if (this.tamanho>0){
            s.append(this.alunos[this.tamanho-1]);
        }

        s.append("]");
        return s.toString();
    }
}
