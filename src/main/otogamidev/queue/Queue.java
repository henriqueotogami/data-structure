package main.otogamidev.queue;

import main.otogamidev.queue.utils.MapTypes;

/**
 * Classe responsavel por uma implementacao de Fila.
 *
 * @author henriquematheusalvespereira
 */
public class Queue {

    final String CLASS_NAME = "Queue";

    /**
     * Armazena os elementos da lista.
     */
    private Object[] elements = new Object[0];

    public static final int NOT_FOUND = -1;

    private final String NONE = "NONE";

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
            System.out.println(CLASS_NAME + " - setAllElements(): elements[" + index + "] = " + this.getObjectType(elements[index]));
        }
        this.elements = elements;
    }

    /**
     * Metodo responsavel pela adicao de um novo elemento no final da lista de elementos.
     * @param element elemento que sera adicionado.
     */
    public void addElement(final Object element) {
        System.out.println("\n" + CLASS_NAME + " - addElement(): BEGIN");
        System.out.println(CLASS_NAME + " - addElement(): element = " + getObjectType(element));
        final int actualSize = getSize();
        final int sizeNewElements = this.isEmpty() ? 1 : actualSize + 1;
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
        System.out.println(CLASS_NAME.concat(" - addElement(): END"));
        System.out.println(CLASS_NAME.concat(" ===================="));
    }

    /**
     * Metodo responsavel pela busca de um elemento em um array.
     * @param array Array de elementos
     * @param element Elemento a ser procurado
     * @return Retorna o indice do elemento encontrado no array. Se nao encontrar, retorna o valor -1.
     */
    public int searchElement(final Object[] array, final Object element) {
        System.out.println("\n" + CLASS_NAME + " - searchElement(): BEGIN");

        final int arrayLength = array.length;
        if(arrayLength == 0) throw new ArrayIndexOutOfBoundsException(arrayLength);

        int foundElementIndex = NOT_FOUND;
        for (int index = 0; arrayLength > index; index++) {
            if(array[index] == element) {
                foundElementIndex = index;
                break;
            }
        }

        if(foundElementIndex == NOT_FOUND) System.out.println(CLASS_NAME.concat(" - searchElement(): Element not found."));

        System.out.println(CLASS_NAME + " - searchElement(): " + foundElementIndex);
        System.out.println(CLASS_NAME.concat(" - searchElement(): END"));
        System.out.println(CLASS_NAME.concat(" ===================="));
        return foundElementIndex;
    }

    /**
     * Metodo responsavel pela busca de um elemento em um array.
     * @param element Elemento a ser procurado
     * @return Retorna o indice do elemento encontrado no array. Se nao encontrar, retorna o valor -1.
     */
    public int searchElement(final Object element) {
        return this.searchElement(this.getAllElements(), element);
    }

    /**
     * Metodo responsavel para pegar um elemento a partir do indice informado.
     * @param indexElement indice do elemento no Array
     * @return Retorna o elemento do indice informado.
     */
    public Object getElement(final int indexElement) {
        System.out.println("\n" + CLASS_NAME + " - getElement(): BEGIN");
        final Object element = this.getAllElements()[indexElement];
        System.out.println(CLASS_NAME + " - getElement(): " + this.getObjectType(element));
        System.out.println(CLASS_NAME.concat(" - getElement(): END"));
        System.out.println(CLASS_NAME.concat(" ===================="));
        return element;
    }

    /**
     * Metodo responsavel por remover um elemento a partir do indice informado.
     * @param indexElement indice do elemento no array
     * @return Retorna true indicando que foi removido ou falso indicando que nao foi removido.
     */
    public boolean removeElement(final int indexElement) {
        System.out.println("\n" + CLASS_NAME + " - removeElement(): BEGIN");

        if (this.isEmpty()) {
            System.out.println(CLASS_NAME.concat(" - removeElement(): Array is empty"));
            return false;
        } else if((indexElement + 1) > this.getSize()) throw new ArrayIndexOutOfBoundsException(indexElement);

        Object element = this.getAllElements()[indexElement];
        final int sizeNewElements = (this.getSize() - 2);
        Object[] newElements = new Object[sizeNewElements];

        for(int oldIndex = 0, newIndex = 0; (this.getSize()-1) > oldIndex; oldIndex++) {
            if (oldIndex != indexElement) {
                newElements[newIndex] = this.getAllElements()[oldIndex];
                newIndex++;
            }
        }

        System.out.println(CLASS_NAME + " - removeElement(): " + element);
        this.setAllElements(newElements);

        System.out.println(CLASS_NAME.concat(" - removeElement(): END"));
        System.out.println(CLASS_NAME.concat(" ===================="));
        return true;
    }

    /**
     * Metodo responsavel para apagar o array.
     * @return Retorna true indicando que o array foi apagado ou false se já estava vazio.
     */
    public boolean eraseAllElements() {
        System.out.println("\n" + CLASS_NAME + " - removeElement(): BEGIN");
        if(this.isEmpty()){
            System.out.println(CLASS_NAME.concat(" - removeElement(): the array is already empty"));
            return false;
        }

        this.setAllElements(new Object[0]);
        System.out.println(CLASS_NAME.concat(" - removeElement(): END"));
        System.out.println(CLASS_NAME.concat(" ===================="));
        return true;
    }

    /**
     * Metodo responsavel para verificar se a fila contem o elemento informado.
     * @param element elemento a ser procurado na fila.
     * @return Retorna true indicado se contem o elemento ou false para nao.
     */
    public boolean contains(final Object element) {
        System.out.println("\n" + CLASS_NAME + " - contains(): BEGIN");
        return ( this.searchElement(element) != NOT_FOUND );
    }

    /**
     * Metodo responsavel pela conversao de um tipo de dados em string.
     * @param element elemento que sera convertido em string
     * @return Retorna o nome do objeto e conteudo formatados em string.
     */
    public String toString(final Object element) {
        System.out.println("\n" + CLASS_NAME + " - toString(): BEGIN");

        if (element == null) return "null";

        String elementToString = NONE;
        final String elementType = this.getObjectType(element);
        final String elementGroup = MapTypes.getGroup(elementType);
        System.out.println(CLASS_NAME + " - toString(): elementType = " + elementType);
        System.out.println(CLASS_NAME + " - toString(): elementGroup = " + elementGroup);

        switch (elementGroup) {
            case MapTypes.GROUP_PRIMITIVE -> {
                System.out.println(CLASS_NAME.concat(" - toString(): Group Primitive"));
                elementToString = MapTypes.getPrimitiveToString(element, elementType);
            }

            case MapTypes.GROUP_OBJECT -> {
                System.out.println(CLASS_NAME.concat(" - toString(): Group Object"));
                elementToString = MapTypes.getObjectToString(element, elementType);
            }

            case MapTypes.GROUP_PRIMITIVE_ARRAY -> {
                System.out.println(CLASS_NAME.concat(" - toString(): Group Primitive Array"));
                elementToString = MapTypes.getPrimitiveArrayToString(element, elementType);
            }

            case MapTypes.GROUP_OBJECT_ARRAY -> {
                System.out.println(CLASS_NAME.concat(" - toString(): Group Object Array"));
                elementToString = MapTypes.getObjectArrayToString(element, elementType);
            }
        }
        System.out.println(CLASS_NAME + " - toString(): elementToString = " + elementToString);
        System.out.println(CLASS_NAME.concat(" - toString(): END"));
        return elementToString;
    }

    /**
     * Metodo responsável por identificar a instancia do elemento.
     * @param object elemento a ser identificado
     * @return Retorna o nome do tipo do elemento, se for encontrado. Se não, retorna NONE
     */
    public String getObjectType(final Object object) {
        System.out.println("\n" + CLASS_NAME + " - getObjectType(): BEGIN");

        String objectType = object.getClass().getSimpleName();
        if(objectType.equals(NONE)) System.out.println(CLASS_NAME.concat(" - getObjectType(): Object type does not found"));

        System.out.println(CLASS_NAME.concat(" - getObjectType(): END"));
        System.out.println(CLASS_NAME.concat(" ===================="));
        return objectType;
    }

}
