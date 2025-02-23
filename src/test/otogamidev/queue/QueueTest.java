package test.otogamidev.queue;

import main.otogamidev.queue.utils.DefaultValues;
import main.otogamidev.queue.Queue;
import main.otogamidev.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;


/**
 * Classe responsavel pelos testes da classe Queue (Fila), dos estudos de estruturas de dados.
 *
 * @author henriquematheusalvespereira
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class QueueTest {

    /** Nome da Classe QueueTest */
    private static final String CLASS_NAME = "QueueTest";

    private final Logger logger = LogManager.getLogger(QueueTest.class);
    private final Queue queue = new Queue();

    private final int QUEUE_MAX_SIZE = 34;

    /**
     * @Test 1 - Criação de Fila.
     * @Scenario Verificar se a fila é criada corretamente e está vazia.
     */
    @Test
    @Order(1)
    void createQueueTest() {
        logger.debug(CLASS_NAME.concat(" - createQueueTest(): BEGIN"));
        final Queue queue1 = new Queue();
        final boolean isEmpty = queue1.isEmpty();
        logger.info(CLASS_NAME + " - createQueueTest(): isEmtpy = " + isEmpty);
        logger.debug(CLASS_NAME.concat(" - createQueueTest(): END"));
        Assertions.assertTrue(isEmpty);
    }

    /**
     * @Test 2 - Testar a operação de enfileiramento.
     * @Scenario Adicionar elementos à fila.
     */
    @Test
    @Order(2)
    void addElementTest() {
        logger.debug(CLASS_NAME.concat(" - addElementTest(): BEGIN"));

        int size = queue.getSize();
        logger.info(CLASS_NAME + " - addElementTest(): Initialing - Queue size = {}", size);

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
        logger.info(CLASS_NAME + " - addElementTest(): After adding elements - Queue size = {}", size);
        logger.debug(CLASS_NAME.concat(" - addElementTest(): END"));
        Assertions.assertEquals(QUEUE_MAX_SIZE, size);
    }

    /**
     * @Test 3 - Testar a operação de desenfileiramento.
     * @Scenario Remover elementos da fila.
     */
    @Test
    @Order(3)
    void removeElementTest() {
        logger.debug(CLASS_NAME.concat(" - removeElementTest(): BEGIN"));

//      Parece que o Junit reinicia a instancia depois de terminar os metodos.
//      Por isso, chamei aqui o metodo addElementTest.
        this.addElementTest();

        final int randomIndex = Utils.getRandomIndex(this.queue.getSize());
        logger.debug(CLASS_NAME + " - removeElementTest(): randomIndex = {}", randomIndex);
        final Object element = queue.getElement(randomIndex);

        logger.debug(CLASS_NAME + " - removeElementTest(): element = {}", element);
        final boolean wasRemoved = queue.removeElement(randomIndex);

        logger.info(CLASS_NAME + " - removeElementTest(): wasRemoved = {}", wasRemoved);
        final int indexRemoved = queue.searchElement(element);

        logger.debug(CLASS_NAME.concat(" - removeElementTest(): END"));
        Assertions.assertEquals(Queue.NOT_FOUND, indexRemoved);
    }

    /**
     * @Test 4 - Consultar o elemento
     * @Scenario Consultar o elemento da fila sem remover.
     */
    @Test
    @Order(4)
    void searchElementTest() {
        logger.debug(CLASS_NAME.concat(" - searchElementTest(): BEGIN"));
//      Parece que o Junit reinicia a instancia depois de terminar os metodos.
//      Por isso, chamei aqui o metodo addElementTest.
        this.addElementTest();
        final int randomIndex = Utils.getRandomIndex(this.queue.getSize());
        final Object element = queue.getElement(randomIndex);
        final boolean isFoundElement = ( queue.searchElement(element) != Queue.NOT_FOUND );
        logger.info(CLASS_NAME + " - searchElementTest(): isFoundElement = {}", isFoundElement);
        logger.debug(CLASS_NAME.concat(" - searchElementTest(): END"));
        Assertions.assertTrue(isFoundElement);
    }

    /**
     * @Test 5 - Testar o estado da fila.
     * @Scenario Métodos auxiliares como isEmpty() e tamanho da fila.
     */
    @Test
    @Order(5)
    void isEmptyTest() {
        logger.debug(CLASS_NAME.concat(" - isEmptyTest(): BEGIN"));

        final boolean isZeroInitialQueueSize = queue.isEmpty();
        logger.info(CLASS_NAME + " - isEmptyTest(): isZeroInitialQueueSize = {}", isZeroInitialQueueSize);

        this.addElementTest();
        final boolean isFullQueueSize = ( queue.isEmpty() == false );
        logger.info(CLASS_NAME + " - isEmptyTest(): isFullQueueSize = {}", isFullQueueSize);

        final boolean isErased = queue.eraseAllElements();
        final boolean isErasedQueue = queue.isEmpty();
        logger.info(CLASS_NAME + " - isEmptyTest(): isErasedQueue = {}", isErasedQueue);

        logger.debug(CLASS_NAME.concat(" - isEmptyTest(): END"));
        Assertions.assertTrue((isZeroInitialQueueSize && isFullQueueSize && isErasedQueue));
    }

    /**
     * @Test 6 - Testar se a fila contem o elemento.
     * @Scenario Verifica se um elemento especifico está presente na fila.
     */
    @Test
    @Order(6)
    void containsTest() {
        logger.debug(CLASS_NAME.concat(" - containsTest(): BEGIN"));
        this.addElementTest();
        final int randomIndex = Utils.getRandomIndex(this.queue.getSize());
        final Object randomElement = queue.getElement(randomIndex);
        logger.info(CLASS_NAME + " - containsTest(): randomElement.getType = {}", queue.getObjectType(randomElement));
        final boolean isFoundElement = queue.contains(randomElement);
        logger.info(CLASS_NAME + " - containsTest(): isFoundElement = {}", isFoundElement);
        logger.debug(CLASS_NAME + " - containsTest(): END");
        Assertions.assertTrue(isFoundElement);
    }

    /**
     * @Test 7 - Testar a conversão do valor(es) de um(ns) objeto(s) em string.
     * @Scenario Tipos primitivos serão convertidos em string, enquanto arrays de objetos terão seus
     * valores armazenados convertidos e formatados em string.
     */
    @Test
    @Order(7)
    void toStringTest() {
        logger.debug(CLASS_NAME.concat(" - toStringTest(): BEGIN"));
        this.addElementTest();
        for(Object element : queue.getAllElements()) logger.info(CLASS_NAME + " - toStringTest(): Element = {} : Value = {}", queue.getObjectType(element), queue.toString(element));
        logger.debug(CLASS_NAME.concat(" - toStringTest(): END"));
    }


}