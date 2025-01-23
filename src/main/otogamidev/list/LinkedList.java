package main.otogamidev.list;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Classe responsavel pela implementacao de Lista Encadeada.
 *
 * @author henriquematheusalvespereira
 */
public class LinkedList<T> {

    final String CLASS_NAME = "LinkedList";

    private final Logger logger = LogManager.getLogger(LinkedList.class);

    private Node<T> head = null;
    private Node<T> next = null;
    private int size = 0;

    private final int NOT_FOUND = -1;

    public LinkedList() {
        this.head = null;
        this.size = 0;
        logger.info("LinkedList() - head = null | size = 0");
    }

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
    }

    private Node<T> searchPosition(final int position) {
        final boolean isValidSize = (position >= 0) && (this.size >= position);
        if(!isValidSize) throw new IllegalArgumentException("Position is not exist");

        Node<T> actualNode = this.head;
        for(int index = 0; position > index; index++) actualNode = actualNode.getNextElement();

        return null;
    }

    public T searchNode(final int position) {
        return this.searchPosition(position).getElement();
    }

    public int searchElement(final Node<T> element) {
        Node<T> actualNode = this.head;
        int position = 0;

        while(actualNode != null) {

            if(actualNode.getElement().equals(element)) return position;

            position++;
            actualNode = actualNode.getNextElement();
        }
        return NOT_FOUND;
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
