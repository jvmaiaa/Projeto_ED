package listaencadeada;

public class ListaEncadeada<T> {

    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho;

    private final int NAO_ENCONTRADO = -1;

    public void adicionaNoInicioOuNoFim(T elemento){
        No<T> celula = new No<T>(elemento);
        // verifica se a lista está vazia
        if (this.tamanho == 0){
            // caso esteja adiciona o nó no inicio da lista
            this.inicio = celula;
        }
        else {
            // caso não, faz o antigo ultimo apontar para o novo ultimo
            this.ultimo.setProximo(celula);
        }
        // faz o ultimo receber o valor do ultimo elemento
        this.ultimo = celula;
        this.tamanho++;
    }

    public void limpaLista(){
        if (this.tamanho == 0){
            return;
        }
        No<T> atual = this.inicio;
        while (atual != null) {
            No<T> proximo = atual.getProximo();
            atual.setElemento(null);
            atual.setProximo(null);
            atual = proximo;
        }
        this.inicio = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public No<T> buscaPorNo(int posicao) {
        if (!(posicao >= 0 && posicao < this.tamanho)){
            throw new IllegalArgumentException("Posição não existe.");
        }

        No<T> atual = this.inicio;
        for (int i = 0; i < posicao; i++){
            atual = atual.getProximo();
        }

        return atual;
    }

    public T buscaPorIndice(int posicao) {
        return this.buscaPorNo(posicao).getElemento();
    }

    public int buscaPorElemento(T elemento){
        No<T> atual = this.inicio;
        int posicao = 0;

        while (atual != null){
            if (atual.getElemento().equals(elemento)){
                return posicao;
            }
            posicao++;
            atual = atual.getProximo();
        }
        return NAO_ENCONTRADO;
    }


    public int tamanho(){
        return this.tamanho;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("[");
        if (this.tamanho == 0){
            return "[]";
        }

        No<T> atual = this.inicio;
        for (int i = 0; i < this.tamanho - 1; i++){
            builder.append(atual.getElemento() + ", ");
            atual.getProximo();
        }
        builder.append(atual).append("]");
        return builder.toString();
    }
}
