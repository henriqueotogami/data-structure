package main.otogamidev.stack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.EmptyStackException;

public class StaticStructure<T> {

    /** Nome da Classe StaticStructure */
    private static final String CLASS_NAME = "StaticStructure";
    private static final Logger logger = LogManager.getLogger(StaticStructure.class);

    protected T[] elements;
    protected int size;

    private final int NOT_FOUND = -1;

    /**
     * Metodo construtor que instancia a pilha com a capacidade informada.
     * @param capable capacidade da pilha
     */
    public StaticStructure(final int capable) {
        this.elements = (T[]) new Object[capable];
        this.size = 0;
    }

    /**
     * Metodo construtor instanciando a capacidade padrao de dez elementos.
     */
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

    /**
     * Metodo responsavel pela verificacao de tamanho da pilha
     * @return retorna valor true indicando que esta vazia e false indicando que esta cheia
     */
    public boolean isEmpty() { return (this.size == 0); }

    /**
     * Metodo responsavel pela remoção de um elemento pela posição.
     * @param position posição informada do elemento que será removido
     * @throws ArrayIndexOutOfBoundsException Lança uma exception se a posicão for inválida.
     */
    public void remove(final int position) throws ArrayIndexOutOfBoundsException{
        if( 0 > position && position > this.size) throw new ArrayIndexOutOfBoundsException("Posicão inválida");
//        this.size--;
        for(int index = position; this.size-1 > index; index++) this.elements[index] = this.elements[index+1];
        this.size--;
    }

    public void remove(final T element) {
        final int position = this.searchByElement(element);
        if(position > this.NOT_FOUND) this.remove(position);
    }

    /**
     * Metodo responsável pela busca de um elemento no Vetor.
     * @param element elemento a ser buscado no Vetor
     * @return Retorna o índice do elemento encontrado.
     * <br> Se não encontrar o elemento, retorna o valor "-1".
     */
    public int searchByElement(final T element) {
        for(int index = 0; this.size > index; index++) {
            if(this.elements[index].equals(element)) return index;
        }
        return NOT_FOUND;
    }

    /**
     * Metodo responsavel para pegar um elemento a partir do indice informado.
     * @param index indice do elemento no Array
     * @return Retorna o elemento do indice informado.
     * @throws EmptyStackException Lança uma exception se a lista estiver vazia
     * @throws ArrayIndexOutOfBoundsException Lança uma exception se a posicão for inválida.
     */
    public T getElement(final int index) {

        if(this.isEmpty()) throw new EmptyStackException();

        if( 0 > index && index > this.size) throw new ArrayIndexOutOfBoundsException("Posicão inválida");

        return this.elements[index];
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
