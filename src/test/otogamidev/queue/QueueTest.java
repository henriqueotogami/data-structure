package test.otogamidev.queue;

import main.otogamidev.queue.utils.DefaultValues;
import main.otogamidev.queue.Queue;
import org.junit.jupiter.api.*;

/**
 * Classe responsavel pelos testes da classe Queue (Fila), dos estudos de estruturas de dados.
 *
 * @author henriquematheusalvespereira
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class QueueTest {

    final String CLASS_NAME = this.getClass().getName();

    private final Queue queue = new Queue();
    private final int QUEUE_MAX_SIZE = 34;

    private int getRandomIndexQueueSize() {
        final int size = queue.getSize();
        final int randomIndex = (int) (Math.random() * size);
        return randomIndex;
    }

    /**
     * Teste 1 - Criação de Fila.
     * Cenário = Verificar se a fila é criada corretamente e está vazia.
     */
    @Test
    @Order(1)
    void createQueueTest() {
        System.out.println(CLASS_NAME.concat(" - createQueueTest(): BEGIN"));
        final Queue queue1 = new Queue();
        final boolean isEmpty = queue1.isEmpty();
        System.out.println(CLASS_NAME + " - createQueueTest(): isEmtpy = " + isEmpty);
        System.out.println(CLASS_NAME.concat(" - createQueueTest(): END"));
        Assertions.assertTrue(isEmpty);
    }

    /**
     * Teste 2 - Testar a operação de enfileiramento.
     * Cenário: Adicionar elementos à fila.
     */
    @Test
    @Order(2)
    void addElementTest() {
        System.out.println(CLASS_NAME.concat(" - addElementTest(): BEGIN"));

        int size = queue.getSize();
        System.out.println(CLASS_NAME + " - addElementTest(): Initialing - Queue size = " + size);

        queue.addElement(DefaultValues.PRIMITIVE_INTEGER);
        queue.addElement(DefaultValues.PRIMITIVE_DOUBLE);
        queue.addElement(DefaultValues.PRIMITIVE_FLOAT);
        queue.addElement(DefaultValues.PRIMITIVE_LONG);
        queue.addElement(DefaultValues.PRIMITIVE_SHORT);
        queue.addElement(DefaultValues.PRIMITIVE_BYTE);
        queue.addElement(DefaultValues.PRIMITIVE_CHAR);
        queue.addElement(DefaultValues.PRIMITIVE_BOOLEAN);

        queue.addElement(DefaultValues.OBJECT_INTEGER);
        queue.addElement(DefaultValues.OBJECT_DOUBLE);
        queue.addElement(DefaultValues.OBJECT_FLOAT);
        queue.addElement(DefaultValues.OBJECT_LONG);
        queue.addElement(DefaultValues.OBJECT_SHORT);
        queue.addElement(DefaultValues.OBJECT_BYTE);
        queue.addElement(DefaultValues.OBJECT_CHAR);
        queue.addElement(DefaultValues.OBJECT_BOOLEAN);
        queue.addElement(DefaultValues.OBJECT_STRING);

        queue.addElement(DefaultValues.PRIMITIVE_ARRAY_INTEGER);
        queue.addElement(DefaultValues.PRIMITIVE_ARRAY_DOUBLE);
        queue.addElement(DefaultValues.PRIMITIVE_ARRAY_FLOAT);
        queue.addElement(DefaultValues.PRIMITIVE_ARRAY_LONG);
        queue.addElement(DefaultValues.PRIMITIVE_ARRAY_SHORT);
        queue.addElement(DefaultValues.PRIMITIVE_ARRAY_BYTE);
        queue.addElement(DefaultValues.PRIMITIVE_ARRAY_CHAR);
        queue.addElement(DefaultValues.PRIMITIVE_ARRAY_BOOLEAN);

        queue.addElement(DefaultValues.OBJECT_ARRAY_INTEGER);
        queue.addElement(DefaultValues.OBJECT_ARRAY_DOUBLE);
        queue.addElement(DefaultValues.OBJECT_ARRAY_FLOAT);
        queue.addElement(DefaultValues.OBJECT_ARRAY_LONG);
        queue.addElement(DefaultValues.OBJECT_ARRAY_SHORT);
        queue.addElement(DefaultValues.OBJECT_ARRAY_BYTE);
        queue.addElement(DefaultValues.OBJECT_ARRAY_CHAR);
        queue.addElement(DefaultValues.OBJECT_ARRAY_BOOLEAN);
        queue.addElement(DefaultValues.OBJECT_ARRAY_STRING);

        size = queue.getSize();
        System.out.println(CLASS_NAME + " - addElementTest(): After adding elements - Queue size = " + size);
        System.out.println(CLASS_NAME.concat(" - addElementTest(): END"));
        Assertions.assertEquals(QUEUE_MAX_SIZE, size);
    }

    /**
     * Teste 3 - Testar a operação de desenfileiramento.
     * Cenário: Remover elementos da fila.
     */
    @Test
    @Order(3)
    void removeElementTest() {
        System.out.println(CLASS_NAME.concat(" - removeElementTest(): BEGIN"));

//      Parece que o Junit reinicia a instancia depois de terminar os metodos.
//      Por isso, chamei aqui o metodo addElementTest.
        this.addElementTest();

        final int randomIndex = getRandomIndexQueueSize();
        System.out.println(CLASS_NAME + " - removeElementTest(): randomIndex = " + randomIndex);
        final Object element = queue.getElement(randomIndex);

        System.out.println(CLASS_NAME + " - removeElementTest(): element = " + element);
        final boolean wasRemoved = queue.removeElement(randomIndex);

        System.out.println(CLASS_NAME + " - removeElementTest(): wasRemoved = " + wasRemoved);
        final int indexRemoved = queue.searchElement(element);

        System.out.println(CLASS_NAME.concat(" - removeElementTest(): END"));
        Assertions.assertEquals(Queue.NOT_FOUND, indexRemoved);
    }

    /**
     * Teste 4 - Consultar o elemento
     * Cenário: Consultar o elemento da fila sem remover.
     */
    @Test
    @Order(4)
    void searchElementTest() {
        System.out.println(CLASS_NAME.concat(" - searchElementTest(): BEGIN"));
//      Parece que o Junit reinicia a instancia depois de terminar os metodos.
//      Por isso, chamei aqui o metodo addElementTest.
        this.addElementTest();
        final int randomIndex = getRandomIndexQueueSize();
        final Object element = queue.getElement(randomIndex);
        final boolean isFoundElement = ( queue.searchElement(element) != Queue.NOT_FOUND );
        System.out.println(CLASS_NAME + " - searchElementTest(): isFoundElement = " + isFoundElement);
        System.out.println(CLASS_NAME.concat(" - searchElementTest(): END"));
        Assertions.assertTrue(isFoundElement);
    }

    /**
     * Teste 5 - Testar o estado da fila.
     * Cenário: Métodos auxiliares como isEmpty() e tamanho da fila.
     */
    @Test
    @Order(5)
    void isEmptyTest() {
        System.out.println(CLASS_NAME.concat(" - isEmptyTest(): BEGIN"));

        final boolean isZeroInitialQueueSize = queue.isEmpty();
        System.out.println(CLASS_NAME + " - isEmptyTest(): isZeroInitialQueueSize = " + isZeroInitialQueueSize);

        this.addElementTest();
        final boolean isFullQueueSize = ( queue.isEmpty() == false );
        System.out.println(CLASS_NAME + " - isEmptyTest(): isFullQueueSize = " + isFullQueueSize);

        queue.eraseAllElements();
        final boolean isErasedQueue = queue.isEmpty();
        System.out.println(CLASS_NAME + " - isEmptyTest(): isErasedQueue = " + isErasedQueue);

        System.out.println(CLASS_NAME.concat(" - isEmptyTest(): END"));
        Assertions.assertTrue((isZeroInitialQueueSize && isFullQueueSize && isErasedQueue));
    }

    /**
     * Teste 6 - Testar se a fila contem o elemento.
     * Cenário: Verifica se um elemento especifico está presente na fila.
     */
    @Test
    @Order(6)
    void containsTest() {
        System.out.println(CLASS_NAME.concat(" - containsTest(): BEGIN"));
        this.addElementTest();
        final int randomIndex = getRandomIndexQueueSize();
        final Object randomElement = queue.getElement(randomIndex);
        System.out.println(CLASS_NAME + " - containsTest(): randomElement.getType = " + queue.getObjectType(randomElement));
        final boolean isFoundElement = queue.contains(randomElement);
        System.out.println(CLASS_NAME + " - containsTest(): isFoundElement = " + isFoundElement);
        System.out.println(CLASS_NAME + " - containsTest(): END");
        Assertions.assertTrue(isFoundElement);
    }

    @Test
    @Order(7)
    void toStringTest() {
        System.out.println(CLASS_NAME.concat(" - toStringTest(): BEGIN"));
        this.addElementTest();
        for(Object element : queue.getAllElements()) System.out.println(CLASS_NAME + " - toStringTest(): " + queue.toString(element));
    }


}