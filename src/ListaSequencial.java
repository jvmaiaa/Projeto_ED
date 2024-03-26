import java.util.Arrays;

public class ListaSequencial<T> {

    private T[] alunos;
    private int tamanho;

    public ListaSequencial(int capacidade){
        this.alunos = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }

    public boolean adicionaNoFim(T aluno){
       if (this.tamanho < this.alunos.length){
           this.alunos[tamanho] = aluno;
           this.tamanho++;
           return true;
       }
       return false;
    }

    public T buscaPorIndice(int posicao){
        if(!(posicao >= 0 && posicao < this.tamanho)){
            throw new IllegalArgumentException("Posição inválida");
        }
        return this.alunos[posicao];
    }

    public int buscaPorElemento(Object aluno){
        for(int i = 0; i < this.tamanho; i++){
            if(this.alunos[i].equals(aluno)){
                return i;
            }
        }
        return -1;
    }

    public boolean inserirEmQualquerPosicao(int posicao, T aluno){
        if(!(posicao >= 0 && posicao < this.tamanho)){
            throw new IllegalArgumentException("Posição inválida");
        }
        if (this.tamanho < this.alunos.length){
            for (int i = this.tamanho - 1; i >= posicao; i--){
                this.alunos[i + 1] = this.alunos[i];
            }
            this.alunos[posicao] = aluno;
            this.tamanho++;
            return true;
        }
        return false;
    }

    // A B C D -> posicao removida é 1 (B)
    // 0 1 2 3 -> tamanho 4
    // vetor[1] = vetor[2]
    // vetor[2] = vetor[3]
    // a substituição ocorrerá até o penúltimo elemento que receberá o último por isso
    // a condição ( i < tamanho - 1 )
    public boolean removeElementoPorIndice(int posicao){
        if (!(posicao >= 0 && posicao < this.tamanho)){
            throw new IllegalArgumentException("Posição inválida");
        }
        for (int i = posicao; i < tamanho - 1; i++){
            this.alunos[i] = this.alunos[i + 1];
        }
        tamanho--;
        return true;
    }
    public boolean contem(T aluno){
        for (int i = 0; i < this.tamanho; i++){
            if (this.alunos[i].equals(aluno)){
                return true;
            }
        }
        return false;
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

        // iteração até tamanho real -1 para fechar o ]
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
