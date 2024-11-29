package main.otogamidev;

import java.util.Arrays;

/**
 * Classe responsavel por uma implementacao de Fila.
 *
 * @author henriquematheusalvespereira
 */
public class Queue {

    final String CLASS_NAME = this.getClass().getName();

    /**
     * Armazena os elementos da lista.
     */
    private Object[] elements = new Object[0];

    public Queue() {
    }

    /**
     * @return Retorna o tamanho da lista.
     */
    public int getSize() { return elements.length; }

    /**
     * @return Retorna true se a lista está vazia.
     */
    public boolean isEmpty() { return (elements.length == 0); }

    /**
     * @return Retorna todos os elementos da lista.
     */
    public Object[] getAllElements() { return elements; }

    /**
     * Adiciona todos os elementos da lista.
     * @param elements Elementos para serem adicionados na lista.
     */
    public void setAllElements(final Object[] elements) {
        for(int index = 0; elements.length > index; index++) {
            System.out.println(CLASS_NAME.concat("setAllElements(): elements = " + String.valueOf(elements[index])));
        }
        this.elements = elements;
    }

    /**
     * Metodo responsavel pela adicao de um novo elemento na lista de elementos.
     * @param element elemento que sera adicionado.
     */
    public void addElement(final Object element) {
        System.out.println(CLASS_NAME.concat("addElement(): BEGIN"));
        System.out.println(CLASS_NAME.concat("addElement(): element = " + String.valueOf(element)));
        final int actualSize = getSize();
        final int sizeNewElements = isEmpty() ? 0 : actualSize + 1;
        Object[] newElements = new Object[sizeNewElements];

        if(actualSize > 0) {
            for (int index = 0; actualSize > index; index++) {
                newElements[index] = elements[index];
            }
            newElements[actualSize] = element;
        } else {
            newElements = new Object[] { element };
        }

        setAllElements(newElements);
        System.out.println(CLASS_NAME.concat("addElement(): END"));
    }

    /**
     * Metodo responsavel pela busca de um elemento em um array.
     * @param array Array de elementos
     * @param element Elemento a ser procurado
     * @return Retorna o indice do elemento encontrado no array. Se nao encontrar, retorna o valor -1.
     */
    public int searchElement(final Object[] array, final Object element) {
        System.out.println(CLASS_NAME.concat("searchElement(): BEGIN"));

        final int arrayLength = array.length;
        if(arrayLength == 0) throw new ArrayIndexOutOfBoundsException(arrayLength);

        final int NOT_FOUND = -1;
        int foundElementIndex = NOT_FOUND;
        for (int index = 0; arrayLength > index; index++) {
            if(array[index] == element) {
                foundElementIndex = index;
                break;
            }
        }

        if(foundElementIndex == NOT_FOUND) System.out.println(CLASS_NAME.concat("searchElement(): Element not found."));

        System.out.println(CLASS_NAME.concat("searchElement(): " + foundElementIndex));
        System.out.println(CLASS_NAME.concat("searchElement(): END"));
        return foundElementIndex;
    }

    public static void main(String[] args) {

    }
}
