package listaencadeada;

public class ListaEncadeada<T> {

    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho;

    private final int ELEMENTO_NAO_ENCONTRADO = -1;
    private final String POSICAO_NAO_EXISTE = "Posição não existe.";
    private final String LISTA_VAZIA = "Lista está vazia.";

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
            throw new RuntimeException();
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
            throw new IllegalArgumentException(POSICAO_NAO_EXISTE);
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
        return ELEMENTO_NAO_ENCONTRADO;
    }

    private boolean posicaoNaoExiste(int posicao){
        return !(posicao >= 0 && posicao <= this.tamanho);
    }

    public T removeInicio(){
        if (this.tamanho == 0){
            throw new RuntimeException(LISTA_VAZIA);
        }
        T removido = this.inicio.getElemento();
        this.inicio = this.inicio.getProximo();
        this.tamanho--;

        if(this.tamanho == 0){
            this.inicio = null;
            this.ultimo = null;
        }
        return removido;
    }

    public T removeFinal(){
        if (this.tamanho == 0){
            throw new RuntimeException(LISTA_VAZIA);
        }
        if (this.tamanho == 1){
            return removeInicio();
        }

        No<T> penultimoNo = this.buscaPorNo(this.tamanho - 2);
        T removido = penultimoNo.getProximo().getElemento();
        penultimoNo.setProximo(null);
        this.ultimo = penultimoNo;
        this.tamanho--;
        return removido;
    }

    public T removeMeio(int posicao) {
        if (posicaoNaoExiste(posicao)) {
            throw new IllegalArgumentException(POSICAO_NAO_EXISTE);
        }

        if (posicao == 0) {
            return removeInicio();
        }
        if (posicao == tamanho - 1) {
            return removeFinal();
        }
        No<T> noAnterior = this.buscaPorNo(posicao - 1);
        No<T> noAtual = noAnterior.getProximo();
        No<T> proximo = noAtual.getProximo();
        noAnterior.setProximo(proximo);
        noAtual.setProximo(null);
        this.tamanho--;
        return noAtual.getElemento();
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
