package main.otogamidev.list;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Classe responsavel pela implementacao do No de Lista Encadeada
 *
 * @author henriquematheusalvespereira
 */
public class Node <T> {

    final String CLASS_NAME = "Node";

    private final Logger logger = LogManager.getLogger(Node.class);

    private T element = null;
    private Node nextElement = null;

    public Node(final T element) {
        this.element = element;
        this.nextElement = null;
    }

    public Node(final T element, final Node<T> nextElement) {
        this.element = element;
        this.nextElement = nextElement;
    }

    /**
     * Metodo responsavel pela obtencao do elemento armazenado no No
     * @return retorna um elemento do tipo objeto
     */
    public T getElement() { return element; }

    /**
     * Metodo responsavel pelo armazenamento do elemento
     * @param element elemento do tipo objeto
     */
    public void setElement(final T element) { this.element = element; }

    /**
     * Metodo responsavel pela obtencao do proximo No da Lista Encadeada
     * @return retorna o proximo No da Lista Encadeada
     */
    public Node<T> getNextElement() { return nextElement; }

    /**
     * Metodo responsavel pelo armazenamento do proximo No da Lista Encadeada
     * @param nextObject elemento do tipo No
     */
    public void setNextElement(final Node<T> nextObject) { this.nextElement = nextObject; }

    /**
     * Metodo responsavel pela conversão da lista em string
     * @return retorna conteudo formatado em string
     */
    @Override
    public String toString() { return "Node { nextElement = " + nextElement + ", element = " + element + " } "; }

    /**
     * Metodo responsavel pela obtencao do nome da classe
     * @return retorna o nome da classe em string
     */
    public String getClassName() { return this.CLASS_NAME; }
}
