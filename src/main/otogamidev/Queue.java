package otogamidev;

/**
 * Classe responsavel por uma implementacao de Fila.
 *
 * @author henriquematheusalvespereira
 */
public class Queue {

    final String CLASS_NAME = this.getClass().getName();

    public Queue() {
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
}
