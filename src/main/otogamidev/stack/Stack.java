package main.otogamidev.stack;

import java.util.EmptyStackException;

public class Stack<T> {

    private T[] elements;
    private int size;

    public Stack(final int capable) {
        this.elements = (T[]) new Object[capable];
        this.size = 0;
    }

    public Stack() { this(10); }

    public int getSize() { return this.size; }

    @Override
    public String toString() {
        StringBuilder arrayElements = new StringBuilder().append("[");
        final int length = this.elements.length;
        for(int index = 0; length > index; index++) {
            if((length - 1) > index) {
                final String elementWithComma = this.elements[index] + ", ";
                arrayElements.append(elementWithComma);
            }
        }
        final String lastElement = this.elements[length - 1] + "]";
        arrayElements.append(lastElement);
        return arrayElements.toString();
    }

    /**
     * Metodo responsável pela adicão de elemento na última posicão do Vetor.
     * @param element Elemento a ser adicionado
     * @throws IllegalArgumentException Lança exceção se:
     * <br> 1 - Vetor está vazio, se não foi instanciado com valor maior que zero;
     * <br> 2 - Vetor está cheio, após ter adicionado todos os elementos de capacidade máxima
     */
    public void append(final T element) throws IllegalArgumentException {

        if(this.elements.length == 0) throw new IllegalArgumentException("Vector is empty");

        this.increaseCapacity();
//        if(this.elements.length == this.size) throw new IllegalArgumentException("Vector is full");

        this.elements[this.size] = element;
        this.size++;
    }

    /**
     * Metodo responsável pela adição de um elemento em qualquer posição do Vetor.
     * @param position posição do Vetor
     * @param element elemento que será adicionado
     * @throws IllegalArgumentException Lança uma exception indicando se a posição é inválida
     */
    public void append(final int position, final T element) throws IllegalArgumentException {

        if(!(position >= 0) && (this.size > position)) throw new IllegalArgumentException("Posição inválida");

        this.increaseCapacity();
        for(int index = (this.size-1); index >= position; index--) this.elements[(index+1)] = this.elements[index];

        this.elements[position] = element;
        this.size++;
    }

    /**
     * Metodo responsável pelo aumento da capacidade do Vetor.
     * O aumento da capacidade será o dobro do tamanho atual do Vetor.
     * @throws EmptyStackException Lança uma exception indicando que o Vetor está vazio.
     */
    private void increaseCapacity() {
        final int length = this.elements.length;

        if(length == 0) throw new EmptyStackException();

        if(this.size == length){
            final T[] newElements = (T[]) new Object[length * 2];
            for(int index = 0; length > index; index++) newElements[index] = this.elements[index];
            this.elements = newElements;
        }
    }
}
