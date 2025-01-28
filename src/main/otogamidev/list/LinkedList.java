package main.otogamidev.list;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Classe responsavel pela implementacao de Lista Encadeada.
 *
 * @author henriquematheusalvespereira
 */
public class LinkedList<T> {

    /** Nome da Classe LinkedList */
    final String CLASS_NAME = "LinkedList";

    private final Logger logger = LogManager.getLogger(LinkedList.class);

    private Node<T> head = null;
    private Node<T> next = null;
    private int size = 0;

    /** Constante indica objeto nao encontrado */
    private final int NOT_FOUND = -1;

    /**
     * Metodo construtor da classe de Lista Encadeada.
     */
    public LinkedList() {
        this.head = null;
        this.size = 0;
        logger.info("LinkedList() - head = null | size = 0");
    }

    /**
     * Metodo construtor da classe de Lista Encadeada.
     * @param element Elemento inicial da lista
     */
    public LinkedList(final Node<T> element) {
        this.head = element;
        this.size++;
        logger.info("LinkedList() - head = {} | size = {}", this.head, this.size);
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
     * Metodo responsavel pela obtencao do tamanho da lista encadeada
     * @return retorna numero inteiro indicando o tamanho da lista
     */
    public int getSize() { return this.size; }

    /**
     * Metodo responsavel pela verificacao de tamanho da lista
     * @return retorna valor true indicando que esta vazia e false indicando que esta cheia
     */
    public boolean isEmpty() { return (this.size == 0); }

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
     * Metodo responsavel pela busca de um No na lista encadeada pela posicao, sem remove-lo da lista.
     * @param position posicao do elemento a ser procurado
     * @return Retorna o No da posicao informada
     */
    private Node<T> searchNode(final int position) throws IllegalArgumentException {
        final boolean isValidSize = (position >= 0) && (this.size >= position);
        if(!isValidSize) throw new IllegalArgumentException("Position is not exist");

        Node<T> actualNode = this.head;
        for(int index = 0; position > index; index++) actualNode = actualNode.getNextElement();

        return actualNode;
    }

    /**
     * Metodo responsavel pela busca de um elemento pela posicao, sem remove-lo da lista.
     * @param position posicao do elemento a ser procurado
     * @return
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
        return this.NOT_FOUND;
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

        for(int index = 0; (this.size - 1) > index; index++) {
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
