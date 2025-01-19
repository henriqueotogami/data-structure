package main.otogamidev.list;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Classe responsavel pela implementacao de Lista Encadeada.
 *
 * @author henriquematheusalvespereira
 */
public class LinkedList {

    final String CLASS_NAME = "LinkedList";

    private final Logger logger = LogManager.getLogger(LinkedList.class);

    private Node head = null;
    private Node next = null;
    private int size = 0;

    public LinkedList() {
        this.head = null;
        this.size = 0;
        logger.info("LinkedList() - head = null | size = 0");
    }

    public LinkedList(final Node element) {
        this.head = element;
        this.size++;
        logger.info("LinkedList() - head = {} | size = {}", this.head, this.size);
    }

    /**
     * Metodo responsavel pela adicao do no inicial e dos proximos nos
     * @param element instancia de No a ser adicionado na lista
     */
    public void append(final Node element) {
        final Node node = element;
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
    public void append(final Object element) { this.append(new Node(element)); }

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
        for(Node actualNode = this.head; actualNode != null;) {
            final Node nextNode = actualNode.getNextElement();
            actualNode.setElement(null);
            actualNode.setNextElement(null);
            actualNode = nextNode;
        }
    }

    /**
     * Metodo responsavel pela conversão da lista em string
     * @return retorna conteudo formatado em string
     */
    @Override
    public String toString() {

        if(this.isEmpty()) return "[]";

        final StringBuilder stringBuilder = new StringBuilder("[");
        Node linkedNodes = this.head;

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
