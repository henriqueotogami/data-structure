package main.otogamidev.queue;

import main.otogamidev.stack.StaticStructure;

/**
 * Classe responsavel por uma implementacao de Fila implementada utilizando a estrutura da classe StaticStructure.
 *
 * @author henriquematheusalvespereira
 */
public class QueueStatic<T> extends StaticStructure<T> {

    private final int FIRST_ELEMENT = 0;

    /**
     * Metodo construtor sem parametros da classe de Fila.
     */
    public QueueStatic() { super(); }

    /**
     * Metodo construtor com parametro da classe de Fila.
     * @param capable capacidade inicial da fila
     */
    public QueueStatic(final int capable){ super(capable); }

    /**
     * Metodo responsavel por enfileirar os elementos ao final da fila. FIFO
     * @param element elemento a ser adicionado
     */
    public void enqueue(final T element) { super.append(element); }

    /**
     * Metodo responsavel para espiar o topo da fila, sem remover o elemento.
     * @return Retorna o elemento do topo da lista, ou seja, o primeiro elemento.
     * @throws NullPointerException Lança uma exception se a fila estiver vazia.
     */
    public T peek() throws NullPointerException{
        if(super.isEmpty()) throw new NullPointerException("Empty queue");
        return super.elements[FIRST_ELEMENT];
    }

    /**
     * Metodo responsavel pela remocao do elemento do topo da fila, ou seja, o primeiro elemento.
     * @return Retorna o elemento removido da fila.
     * @throws NullPointerException Lança uma exception se a fila estiver vazia.
     */
    public T dequeue() throws NullPointerException {
        if(super.isEmpty()) throw new NullPointerException("Empty queue");
        final T removedElement = super.elements[FIRST_ELEMENT];
        super.remove(FIRST_ELEMENT);
        return removedElement;
    }
}

