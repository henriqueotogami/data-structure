package main.otogamidev.queue;

import main.otogamidev.queue.utils.MapTypes;
import main.otogamidev.stack.StaticStructure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Classe responsavel por uma implementacao de Fila.
 *
 * @author henriquematheusalvespereira
 */
public class Queue<T> extends StaticStructure<T> {

    /** Nome da Classe Queue */
    final String CLASS_NAME = "Queue";

    private final Logger logger = LogManager.getLogger(Queue.class);

    /**
     * Armazena os elementos da lista.
     */
    private Object[] elements = new Object[0];

    /** Constante indica objeto nao encontrado */
    public static final int NOT_FOUND = -1;

    /** Constante indica valor de lista vazia */
    private final int EMPTY = 0;

    /** Constante indica tipo de objeto nao encontrado */
    private final String NONE = "NONE";

    /**
     * Metodo construtor da classe de Fila.
     */
    public Queue() { super(); }

    public Queue(final int capable){ super(capable); }

    /**
     * Metodo responsavel pelo tamanho da lista
     * @return Retorna o tamanho da lista.
     */
    public int getSize() { return elements.length; }

    /**
     * Metodo responsavel pela indicacao de lista vazia
     * @return Retorna true se a lista está vazia.
     */
    public boolean isEmpty() { return (elements.length == EMPTY); }

    /**
     * Metodo responsavel pela obtencao de todos os elementos da lista
     * @return Retorna todos os elementos da lista.
     */
    public Object[] getAllElements() { return elements; }

    /**
     * Adiciona todos os elementos da lista.
     * @param elements Elementos para serem adicionados na lista.
     */
    public void setAllElements(final Object[] elements) {
        final StringBuilder stringBuilder = new StringBuilder();
        for(int index = 0; elements.length > index; index++) {
            stringBuilder.append("\nsetAllElements(): elements[").append(index).append("] = ");
            stringBuilder.append(this.getObjectType(elements[index]));
        }
        logger.info("{}\n", stringBuilder.toString());
        this.elements = elements;
    }

    /**
     * Metodo responsavel pela adicao de um novo elemento no final da lista de elementos.
     * @param element elemento que sera adicionado.
     */
    public void addElement(final Object element) {
        logger.debug(CLASS_NAME + " - addElement(): BEGIN");
        logger.info(CLASS_NAME + " - addElement(): element = {}", getObjectType(element));
        final int actualSize = getSize();
        final int sizeNewElements = this.isEmpty() ? 1 : actualSize + 1;
        Object[] newElements = new Object[sizeNewElements];

        if(actualSize > 0) {
            System.arraycopy(elements, 0, newElements, 0, actualSize);
            newElements[actualSize] = element;
        } else {
            newElements = new Object[] { element };
        }

        setAllElements(newElements);
        logger.debug(CLASS_NAME.concat(" - addElement(): END"));
        logger.debug(CLASS_NAME.concat(" ===================="));
    }

    /**
     * Metodo responsavel pela busca de um elemento em um array.
     * @param array Array de elementos
     * @param element Elemento a ser procurado
     * @return Retorna o indice do elemento encontrado no array. Se nao encontrar, retorna o valor -1.
     */
    public int searchElement(final Object[] array, final Object element) {
        logger.debug(CLASS_NAME + " - searchElement(): BEGIN");

        final int arrayLength = array.length;
        if(arrayLength == 0) throw new ArrayIndexOutOfBoundsException(arrayLength);

        int foundElementIndex = NOT_FOUND;
        for (int index = 0; arrayLength > index; index++) {
            if(array[index] == element) {
                foundElementIndex = index;
                break;
            }
        }

        if(foundElementIndex == NOT_FOUND) logger.info(CLASS_NAME.concat(" - searchElement(): Element not found."));

        logger.info(CLASS_NAME + " - searchElement(): {}", foundElementIndex);
        logger.debug(CLASS_NAME.concat(" - searchElement(): END"));
        logger.debug(CLASS_NAME.concat(" ===================="));
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
        logger.debug(CLASS_NAME + " - getElement(): BEGIN");
        final Object element = this.getAllElements()[indexElement];
        logger.info(CLASS_NAME + " - getElement(): {}", this.getObjectType(element));
        logger.debug(CLASS_NAME.concat(" - getElement(): END"));
        logger.debug(CLASS_NAME.concat(" ===================="));
        return element;
    }

    /**
     * Metodo responsavel por remover um elemento a partir do indice informado.
     * @param indexElement indice do elemento no array
     * @return Retorna true indicando que foi removido ou falso indicando que nao foi removido.
     */
    public boolean removeElement(final int indexElement) {
        logger.debug(CLASS_NAME + " - removeElement(): BEGIN");

        if (this.isEmpty()) {
            logger.info(CLASS_NAME.concat(" - removeElement(): Array is empty"));
            return false;
        } else if((indexElement + 1) > this.getSize()) throw new ArrayIndexOutOfBoundsException(indexElement);

        Object element = this.getElement(indexElement);
        final int sizeNewElements = (this.getSize() - 2);
        Object[] newElements = new Object[sizeNewElements];

        for(int oldIndex = 0, newIndex = 0; (this.getSize()-1) > oldIndex; oldIndex++) {
            if (oldIndex != indexElement) {
                newElements[newIndex] = this.getAllElements()[oldIndex];
                newIndex++;
            }
        }

        logger.info(CLASS_NAME + " - removeElement(): {}", element);
        this.setAllElements(newElements);

        logger.debug(CLASS_NAME.concat(" - removeElement(): END"));
        logger.debug(CLASS_NAME.concat(" ===================="));
        return true;
    }

    /**
     * Metodo responsavel para apagar o array.
     * @return Retorna true indicando que o array foi apagado ou false se já estava vazio.
     */
    public boolean eraseAllElements() {
        logger.debug("\n" + CLASS_NAME + " - removeElement(): BEGIN");
        if(this.isEmpty()){
            logger.info(CLASS_NAME.concat(" - removeElement(): the array is already empty"));
            return false;
        }

        this.setAllElements(new Object[0]);
        logger.debug(CLASS_NAME.concat(" - removeElement(): END"));
        logger.debug(CLASS_NAME.concat(" ===================="));
        return true;
    }

    /**
     * Metodo responsavel para verificar se a fila contem o elemento informado.
     * @param element elemento a ser procurado na fila.
     * @return Retorna true indicado se contem o elemento ou false para nao.
     */
    public boolean contains(final Object element) {
        logger.debug(CLASS_NAME + " - contains(): BEGIN");
        return ( this.searchElement(element) != NOT_FOUND );
    }

    /**
     * Metodo responsavel pela conversao de um tipo de dados em string.
     * @param element elemento que sera convertido em string
     * @return Retorna o nome do objeto e conteudo formatados em string.
     */
    public String toString(final Object element) {
        logger.debug(CLASS_NAME + " - toString(): BEGIN");

        if (element == null) return "null";

        String elementToString = NONE;
        final String elementType = this.getObjectType(element);
        final String elementGroup = MapTypes.getGroup(elementType);
        logger.debug(CLASS_NAME + " - toString(): elementType = {}", elementType);
        logger.debug(CLASS_NAME + " - toString(): elementGroup = {}", elementGroup);

        switch (elementGroup) {
            case MapTypes.GROUP_PRIMITIVE -> {
                logger.debug(CLASS_NAME.concat(" - toString(): Group Primitive"));
                elementToString = MapTypes.getPrimitiveToString(element, elementType);
            }

            case MapTypes.GROUP_OBJECT -> {
                logger.debug(CLASS_NAME.concat(" - toString(): Group Object"));
                elementToString = MapTypes.getObjectToString(element, elementType);
            }

            case MapTypes.GROUP_PRIMITIVE_ARRAY -> {
                logger.debug(CLASS_NAME.concat(" - toString(): Group Primitive Array"));
                elementToString = MapTypes.getPrimitiveArrayToString(element, elementType);
            }

            case MapTypes.GROUP_OBJECT_ARRAY -> {
                logger.debug(CLASS_NAME.concat(" - toString(): Group Object Array"));
                elementToString = MapTypes.getObjectArrayToString(element, elementType);
            }
        }
//        logger.info(CLASS_NAME + " - toString(): elementToString = {}", elementToString);
        logger.debug(CLASS_NAME.concat(" - toString(): END"));
        return elementToString;
    }

    /**
     * Metodo responsável por identificar a instancia do elemento.
     * @param object elemento a ser identificado
     * @return Retorna o nome do tipo do elemento, se for encontrado. Se não, retorna NONE
     */
    public String getObjectType(final Object object) {
        logger.debug(CLASS_NAME + " - getObjectType(): BEGIN");

        String objectType = object.getClass().getSimpleName();
        if(objectType.equals(NONE)) logger.debug(CLASS_NAME.concat(" - getObjectType(): Object type does not found"));

        logger.debug(CLASS_NAME.concat(" - getObjectType(): END"));
        logger.debug(CLASS_NAME.concat(" ===================="));
        return objectType;
    }

}
