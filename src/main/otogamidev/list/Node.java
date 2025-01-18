package main.otogamidev.list;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Classe responsavel pela implementacao do No de Lista Encadeada
 *
 * @author henriquematheusalvespereira
 */
public class Node extends Object {

    final String CLASS_NAME = "Node";

    private final Logger logger = LogManager.getLogger(Node.class);

    private Object element = null;
    private Node nextElement = null;

    public Node(final Object object) { this.element = object; }

    /**
     * Metodo responsavel pela obtencao do elemento armazenado no No
     * @return retorna um elemento do tipo objeto
     */
    public Object getElement() { return element; }

    /**
     * Metodo responsavel pelo armazenamento do elemento
     * @param element elemento do tipo objeto
     */
    public void setElement(final Object element) { this.element = element; }

    /**
     * Metodo responsavel pela obtencao do proximo No da Lista Encadeada
     * @return retorna o proximo No da Lista Encadeada
     */
    public Node getNextElement() { return nextElement; }

    /**
     * Metodo responsavel pelo armazenamento do proximo No da Lista Encadeada
     * @param nextObject elemento do tipo No
     */
    public void setNextElement(final Node nextObject) { this.nextElement = nextObject; }

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
