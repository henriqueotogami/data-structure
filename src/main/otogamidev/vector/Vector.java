package main.otogamidev.vector;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
     * Metodo responsável pela adicão de elemento no Vetor.
     * @param element Elemento a ser adicionado
     * @throws IllegalArgumentException Lança exceção se:
     * 1 - Vetor está vazio, se não foi instanciado com valor maior que zero;
     * 2 - Vetor está cheio, após ter adicionado todos os elementos de capacidade máxima
     */
    public void append(final String element) throws IllegalArgumentException {

        if(this.elements.length == 0) throw new IllegalArgumentException("Vector is empty");

        if(this.elements.length == this.size) throw new IllegalArgumentException("Vector is full");

        this.elements[this.size] = element;
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
        if(foundElement == "null") throw new NullPointerException("Não existe elemento nessa posição");

        return foundElement;
    }

    public int searchByElement(final String element) {
        for(int index = 0; this.size > index; index++) {
            if(this.elements[index].equals(element)) {
                return index;
            }
        }
        return NOT_FOUND;
    }


    public boolean isFoundElement(final String element) {
        return (this.searchByElement(element) != NOT_FOUND);
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
