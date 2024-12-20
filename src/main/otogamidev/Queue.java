package main.otogamidev;

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

    public static final int NOT_FOUND = -1;

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
            System.out.println(CLASS_NAME.concat(" - setAllElements(): elements[" + index + "] = " + getObjectType(elements[index])));
        }
        this.elements = elements;
    }

    /**
     * Metodo responsavel pela adicao de um novo elemento no final da lista de elementos.
     * @param element elemento que sera adicionado.
     */
    public void addElement(final Object element) {
        System.out.println("\n".concat(CLASS_NAME).concat(" - addElement(): BEGIN"));
        System.out.println(CLASS_NAME.concat(" - addElement(): element = " + getObjectType(element)));
        final int actualSize = getSize();
        final int sizeNewElements = isEmpty() ? 1 : actualSize + 1;
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
        System.out.println("\n".concat(CLASS_NAME).concat(" - searchElement(): BEGIN"));

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

        System.out.println(CLASS_NAME.concat(" - searchElement(): " + foundElementIndex));
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
        return searchElement(this.getAllElements(), element);
    }

    /**
     * Metodo responsavel para pegar um elemento a partir do indice informado.
     * @param indexElement indice do elemento no Array
     * @return Retorna o elemento do indice informado.
     */
    public Object getElement(final int indexElement) {
        System.out.println("\n".concat(CLASS_NAME).concat(" - getElement(): BEGIN"));
        final Object element = this.getAllElements()[indexElement];
        System.out.println(CLASS_NAME.concat(" - getElement(): " + getObjectType(element)));
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
        System.out.println("\n".concat(CLASS_NAME).concat(" - removeElement(): BEGIN"));

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

        System.out.println(CLASS_NAME.concat(" - removeElement(): " + element));
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
        System.out.println("\n".concat(CLASS_NAME).concat(" - removeElement(): BEGIN"));
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
        System.out.println("\n".concat(CLASS_NAME).concat(" - contains(): BEGIN"));
        return ( searchElement(element) != NOT_FOUND );
    }


    /**
     * Metodo responsável por identificar a instancia do elemento.
     * @param object elemento a ser identificado
     * @return Retorna o nome do tipo do elemento
     */
    public String getObjectType(final Object object) {
        System.out.println("\n".concat(CLASS_NAME).concat(" - getObjectType(): BEGIN"));
        String objectType = "";
        if(object instanceof Integer){
            objectType = "Integer";
        } else if (object instanceof Double) {
            objectType = "Double";
        } else if (object instanceof Float) {
            objectType = "Float";
        } else if (object instanceof Long) {
            objectType = "Long";
        } else if (object instanceof Short) {
            objectType = "Short";
        } else if (object instanceof Byte) {
            objectType = "Byte";
        } else if (object instanceof Character) {
            objectType = "Character";
        } else if (object instanceof Boolean) {
            objectType = "Boolean";
        } else if (object instanceof String) {
            objectType = "String";
        } else if(object instanceof Integer[]){
            objectType = "Integer[]";
        } else if (object instanceof Double[]) {
            objectType = "Double[]";
        } else if (object instanceof Float[]) {
            objectType = "Float[]";
        } else if (object instanceof Long[]) {
            objectType = "Long[]";
        } else if (object instanceof Short[]) {
            objectType = "Short[]";
        } else if (object instanceof Byte[]) {
            objectType = "Byte[]";
        } else if (object instanceof Character[]) {
            objectType = "Character[]";
        } else if (object instanceof Boolean[]) {
            objectType = "Boolean[]";
        } else if (object instanceof String[]) {
            objectType = "String[]";
        } else if(object instanceof int[]){
            objectType = "integer[]";
        } else if (object instanceof double[]) {
            objectType = "double[]";
        } else if (object instanceof float[]) {
            objectType = "float[]";
        } else if (object instanceof long[]) {
            objectType = "long[]";
        } else if (object instanceof short[]) {
            objectType = "short[]";
        } else if (object instanceof byte[]) {
            objectType = "byte[]";
        } else if (object instanceof char[]) {
            objectType = "char[]";
        } else if (object instanceof boolean[]) {
            objectType = "boolean[]";
        } else {
            objectType = "NONE";
            System.out.println(CLASS_NAME.concat(" - getObjectType(): Object type does not found"));
        }
        System.out.println(CLASS_NAME.concat(" - getObjectType(): END"));
        System.out.println(CLASS_NAME.concat(" ===================="));
        return objectType;
    }

}
