package main.otogamidev.queue;

import main.otogamidev.stack.StaticStructure;

/**
 * Classe responsavel por uma implementacao de Fila implementada utilizando a estrutura da classe StaticStructure.
 *
 * @author henriquematheusalvespereira
 */
public class QueueStatic<T> extends StaticStructure<T> {

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
    public void add(final T element) { super.append(element); }
}

