package main.otogamidev.stack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.EmptyStackException;

public class StaticStructure<T> {

    /** Nome da Classe StaticStructure */
    private static final String CLASS_NAME = "StaticStructure";
    private static final Logger logger = LogManager.getLogger(StaticStructure.class);

    private T[] elements;
    private int size;

    public StaticStructure(final int capable) {
        this.elements = (T[]) new Object[capable];
        this.size = 0;
    }

    public StaticStructure() { this(10); }

    /**
     * Metodo responsável pelo tamanho do Vetor.
     * @return Retorna o tamanho do Vetor.
     */
    public int getSize() { return this.size; }


    /**
     * Metodo responsável pela adicão de elemento na última posicão do Vetor.
     * @param element Elemento a ser adicionado
     * @throws IllegalArgumentException Lança exceção se:
     * <br> 1 - Vetor está vazio, se não foi instanciado com valor maior que zero;
     * <br> 2 - Vetor está cheio, após ter adicionado todos os elementos de capacidade máxima
     */
    protected void append(final T element) throws IllegalArgumentException {

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
    protected void append(final int position, final T element) throws IllegalArgumentException {

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

}
