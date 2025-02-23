package main.otogamidev.list;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Classe responsavel pela implementacao de Lista Encadeada.
 *
 * Implementação baseada no curso da Loiane Groner, porém com alterações minhas.
 *
 * @author henriquematheusalvespereira
 */
public class LinkedList<T> {

    /** Nome da Classe LinkedList */
    final String CLASS_NAME = "LinkedList";

    /** Instancia da classe de logs Log4J */
    private final Logger logger = LogManager.getLogger(LinkedList.class);

    private Node<T> head = null;
    private Node<T> next = null;
    private int size = 0;

    /** Constante indica objeto não encontrado */
    private final int NOT_FOUND_INDEX = -1;

    /** Constante indica posição inválida */
    final String INVALID_POSITION = "Posição inválida.";

    /** Constante indica lista vazia */
    final String EMPTY_LIST = "Posição inválida.";

    /**
     * Metodo construtor da classe de Lista Encadeada.
     */
    public LinkedList() {
        this.head = null;
        this.size = 0;
        logger.info("LinkedList() - head = null | size = 0\n");
    }

    /**
     * Metodo construtor da classe de Lista Encadeada.
     * @param element Elemento inicial da lista
     */
    public LinkedList(final Node<T> element) {
        this.head = element;
        this.size++;
        logger.info("LinkedList() - head = {} | size = {}\n", this.head, this.size);
    }

    /**
     * Metodo responsavel pela adicao do no inicial e dos proximos nos
     * @param element instancia de No a ser adicionado na lista
     */
    public void append(final Node<T> element) {
        final Node<T> node = element;
        if(this.isEmpty()) {
            this.head = node;
        } else {
            this.next.setNextElement(node);
        }
        this.next = node;
        this.size++;
        logger.info("append() - head = {} ", this.head);
        logger.info("append() - size = {} | next = {}\n", this.size, this.next);
    }

    /**
     * Metodo responsavel pela adicao do no inicial e dos proximos nos
     * @param element instancia de objeto a ser adicionado na lista
     */
    public void append(final T element) { this.append(new Node<T>(element)); }

    /**
     * Metodo responsavel pela adicao de um nó dentro de uma lista encadeada.
     * @param position posição do nó a ser adicionado
     * @param element elemento a ser adicionado
     * @throws IllegalArgumentException Lanca exceção se a posição informada for menor que zero ou maior que o tamanho da lista
     */
    public void append(final int position, final T element) throws IllegalArgumentException {

        if(this.isInvalidPosition(position)) throw new IllegalArgumentException(this.INVALID_POSITION);

        if(position == 0) {
            this.appendBegin(element);
        } else if(position == this.size) {
            this.append(element);
        } else {
            this.appendMiddle(position, element);
        }
    }

    /**
     * Metodo responsável pela adição de um nó no início de uma lista encadeada.
     * @param element elemento a ser adicionado
     */
    private void appendBegin(final T element) {
        if(this.isEmpty()) {
            final Node<T> newNode = new Node<>(element);
            this.head = newNode;
            this.next = newNode;
        } else {
            final Node<T> newNode = new Node<>(element, this.head);
            this.head = newNode;
        }
        this.size++;
    }

    /**
     * Metodo responsável pela adição de um nó no meio de uma lista encadeada.
     * @param position posição do alvo do nó a ser adicionado
     * @param element elemento a ser adicionado
     */
    private void appendMiddle(final int position, final T element) {
        final int realPosition = position - 1;
//          Imagine a lista encadeada: | 1 | 2 | 4 | 5
//          Para inserir o elemento 3, primeiramente vamos pegar o Nó 2
        final Node<T> previousNode = this.searchNode(realPosition);
//          Depois, vamos pegar a referência do 4 e 5
        final Node<T> nextNode = previousNode.getNextElement();
//          Depois, vamos definir o link do 3, 4 e 5
        final Node<T> middleNode = new Node<>(element, nextNode);
//          Agora vamos adicionar a nova sequência no Nó 2
        previousNode.setNextElement(middleNode);
        this.size++;
    }

    /**
     * Metodo responsavel pela obtencao do tamanho da lista encadeada
     * @return retorna numero inteiro indicando o tamanho da lista
     */
    public int getSize() { return this.size; }

    /**
     * Metodo responsável pelo retorno do último índice da lista.
     * @return retorna valor inteiro indicando o último índicee.
     */
    public int getLastIndex() { return this.size - 1; }

    /**
     * Metodo responsavel pela verificacao de tamanho da lista
     * @return retorna valor true indicando que esta vazia e false indicando que esta cheia
     */
    public boolean isEmpty() { return (this.size == 0); }

    /**
     * Metodo responsável pela invalidacão da posição, ou seja, utilizando a lógica invertida.
     * Se a posição for menor que zero ou se a posição for maior que o tamanho, será inválida.
     * @param position posição informada
     * @return retorna valor true indicando posição inválida e false para posição válida.
     */
    private boolean isInvalidPosition(final int position) { return ((position < 0) || (this.size < position)); }

    /**
     * Metodo responsavel pela limpeza das variaveis, utilizando recurso similar ao garbage collector.
     */
    public void clear() {
        for(Node<T> actualNode = this.head; actualNode != null;) {
            final Node nextNode = actualNode.getNextElement();
            actualNode.setElement(null);
            actualNode.setNextElement(null);
            actualNode = nextNode;
        }
        this.size = 0;
    }

    /**
     * Metodo responsável pela remoção do primeiro elemento da lista encadeada.
     * @return Retorna o primeiro elemento da lista encadeada, que foi removido
     * @throws RuntimeException Lança uma exceção se a lista estiver vazia
     */
    public T removeFirstElement() throws RuntimeException {

        if(this.isEmpty()) throw new RuntimeException(this.EMPTY_LIST);

        final T firstElement = this.head.getElement();
        this.head = this.head.getNextElement();
        this.size--;
//      Verificação após ser tamanho decrementado
        if(isEmpty()) this.next = null;
        return firstElement;
    }

    /**
     * Metodo responsável pela remoção do ultimo elemento da lista encadeada.
     * @return Retorna o ultimo elemento da lista encadeada, que foi removido
     * @throws RuntimeException Lança uma exceção se a lista estiver vazia
     */
    public T removeLastElement() throws RuntimeException {

        if(this.isEmpty()) throw new RuntimeException(this.EMPTY_LIST);

        if(this.size == 1) return this.removeFirstElement();

//      Aqui considerando que o Java inicia o index em zero, subtraimos 1 do tamanho pra obter o real index.
//      Para obter o antepenultimo, subtraimos 1 novamente. Por isso subtraimos 2.
        final int penultimateIndex = this.size - 2;
        final Node<T> penultimateNode = this.searchNode(penultimateIndex);
        final T lastElement = penultimateNode.getNextElement().getElement();

        penultimateNode.setNextElement(null);
        this.next = penultimateNode;
        this.size--;

        return lastElement;
    }

    /**
     * Metodo responsável pela remoção de um elemento na lista, através da posição.
     * @param position posição do elemento na lista
     * @return retorna o elemento da lista encadeada, que foi removido
     * @throws IllegalArgumentException Lança uma exceção se a lista estiver vazia
     */
    public T removeElement(final int position) throws IllegalArgumentException{

        if(this.isInvalidPosition(position)) throw new IllegalArgumentException(this.INVALID_POSITION);

        if(position == 0) return this.removeFirstElement();

        if(position == getLastIndex()) return this.removeLastElement();

//      A partir daqui, é a tratativa de elemento no meio da lista
        final int middlePosition = position - 1;
        final Node<T> previousNode = this.searchNode(middlePosition);
        final Node<T> actualNode = previousNode.getNextElement();
        final Node<T> nextnode = actualNode.getNextElement();

        previousNode.setNextElement(nextnode);
        actualNode.setNextElement(null);
        this.size--;

        return actualNode.getElement();
    }

    /**
     * Metodo responsavel pela busca de um No na lista encadeada pela posicao, sem remove-lo da lista.
     * @param position posicao do elemento a ser procurado
     * @return Retorna o No da posicao informada
     * @throws IllegalArgumentException Lanca exceção se a posição informada for menor que zero ou maior que o tamanho da lista
     */
    private Node<T> searchNode(final int position) throws IllegalArgumentException {

        if(this.isInvalidPosition(position)) throw new IllegalArgumentException(this.INVALID_POSITION);

        Node<T> actualNode = this.head;
        for(int index = 0; position > index; index++) actualNode = actualNode.getNextElement();

        return actualNode;
    }

    /**
     * Metodo responsavel pela busca de um elemento pela posicao, sem remove-lo da lista.
     * @param position posicao do elemento a ser procurado
     * @return Retorna o elemento da posição informada
     * @throws IllegalArgumentException Lanca exceção se a posição informada for menor que zero ou maior que o tamanho da lista
     */
    public T searchElementByPosition(final int position) throws IllegalArgumentException {
        return this.searchNode(position).getElement();
    }

    /**
     * Metodo responsavel pela busca de um elemento na lista encadeada, sem remove-lo da lista.
     * @param element elemento a ser procurado
     * @return Retorna o indice do elemento encontrado. Se nao for encontrado, retorna o valor -1.
     */
    public int searchElement(final T element) {
        Node<T> actualNode = this.head;
        int position = 0;

        while(actualNode != null) {

            if(actualNode.getElement().equals(element)) return position;

            position++;
            actualNode = actualNode.getNextElement();
        }
        return this.NOT_FOUND_INDEX;
    }

    /**
     * Metodo responsavel pela conversão da lista em string
     * @return retorna conteudo formatado em string
     */
    @Override
    public String toString() {

        if(this.isEmpty()) return "[]";

        final StringBuilder stringBuilder = new StringBuilder("[");
        Node<T> linkedNodes = this.head;
        final int lastIndex = getLastIndex();

        for(int index = 0; lastIndex > index; index++) {
            final Object contents = linkedNodes.getElement();
            stringBuilder.append(contents).append(",");
            linkedNodes = linkedNodes.getNextElement();
        }
        stringBuilder.append(linkedNodes.getElement()).append("]");
        return stringBuilder.toString();
    }

    /**
     * Metodo responsavel pela obtencao do nome da classe
     * @return retorna o nome da classe em string
     */
    public String getClassName() { return this.CLASS_NAME; }
}
