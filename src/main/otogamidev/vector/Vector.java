package main.otogamidev.vector;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.EmptyStackException;

/**
 * Classe responsável pela implementação de Vetor, inspirada no curso da Loiane Groner no Youtube.
 *
 * @author henriquematheusalvespereira
 */
public class Vector {

    /** Nome da Classe Vector */
    private static final String CLASS_NAME = "Vector";
    private static final Logger logger = LogManager.getLogger(Vector.class);

    private String[] elements;
    private int size = 0;

    private final int NOT_FOUND = -1;

    /**
     * Metodo responsável pela construção da classe Vector.
     * @param capable capacidade do Vetor
     */
    public Vector(final int capable) {
        this.elements = new String[capable];
        this.size = 0;
    }

    /**
     * Metodo responsável pelo tamanho do Vetor.
     * @return Retorna o tamanho do Vetor.
     */
    public int getSize() { return this.size; }

    /**
     * Metodo responsável pelos elementos armazenados nesse Vetor.
     * @return Retorna os elementos desse Vetor.
     */
    public String[] getElements() { return this.elements; }

    /**
     * Metodo responsável pela adicão de elemento na última posicão do Vetor.
     * @param element Elemento a ser adicionado
     * @throws IllegalArgumentException Lança exceção se:
     * <br> 1 - Vetor está vazio, se não foi instanciado com valor maior que zero;
     * <br> 2 - Vetor está cheio, após ter adicionado todos os elementos de capacidade máxima
     */
    public void append(final String element) throws IllegalArgumentException {

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
    public void append(final int position, final String element) throws IllegalArgumentException {

        if(!(position >= 0) && (this.size > position)) throw new IllegalArgumentException("Posição inválida");

        this.increaseCapacity();
        for(int index = (this.size-1); index >= position; index--) this.elements[(index+1)] = this.elements[index];

        this.elements[position] = element;
        this.size++;
    }

    /**
     * Metodo responsável pela busca no Vetor de um elemento pela posiçãp informada.
     * @param position posição informada do elemento no Vetor
     * @return Retorna o elemento encontrado
     * @throws ArrayIndexOutOfBoundsException Lança uma exception indicando posição inválida
     * @throws NullPointerException Lança uma exception indicando elemento que não existe
     */
    public String searchByPosition(final int position) throws ArrayIndexOutOfBoundsException, NullPointerException {

        if( 0 > position && position > this.size) throw new ArrayIndexOutOfBoundsException("Posicão inválida");

        final String foundElement = this.elements[position];
        if(foundElement.equals("null")) throw new NullPointerException("Não existe elemento nessa posição");

        return foundElement;
    }

    /**
     * Metodo responsável pela busca de um elemento no Vetor.
     * @param element elemento a ser buscado no Vetor
     * @return Retorna o índice do elemento encontrado.
     * <br> Se não encontrar o elemento, retorna o valor "-1".
     */
    public int searchByElement(final String element) {
        for(int index = 0; this.size > index; index++) {
            if(this.elements[index].equals(element)) return index;
        }
        return NOT_FOUND;
    }

    /**
     * Metodo responsável pela verificação da existência de um elemento no Vetor.
     * @param element elemento a ser buscado no Vetor
     * @return Retorna valor boolean indicando se o elemento está ou não no Vetor.
     */
    public boolean isFoundElement(final String element) {
        return (this.searchByElement(element) != NOT_FOUND);
    }

    /**
     * Metodo responsavel pela obtencão de todos os índices vazios (com o valor null) do Vetor.
     * @return Retorna um array com os índices vazios do Vetor.
     */
    public int[] getEmptyIndexes(){
        int[] emptyIndexes = new int[0];

        for(int index = 0; this.elements.length > index; index++){
            if(this.elements[index] == null) {
                final int[] temporaryIndexes = new int[emptyIndexes.length];
                System.arraycopy(emptyIndexes, 0, temporaryIndexes, 0, emptyIndexes.length);

                emptyIndexes = new int[emptyIndexes.length + 1];
                System.arraycopy(temporaryIndexes, 0, emptyIndexes, 0, temporaryIndexes.length);

                emptyIndexes[emptyIndexes.length - 1] = index;
            }
        }
        return emptyIndexes;
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
            final String[] newElements = new String[length * 2];
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
