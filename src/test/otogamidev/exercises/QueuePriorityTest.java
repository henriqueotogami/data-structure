package test.otogamidev.exercises;

import main.otogamidev.exercises.QueuePriority;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class QueuePriorityTest {

    /** Nome da Classe QueuePriorityTest */
    private static final String CLASS_NAME = "QueuePriorityTest";
    private final Logger logger = LogManager.getLogger(QueuePriorityTest.class);

    private final int queueEmptySize = 0;
    private final int queueFullSize = 10;
    /**
     * Teste 1 - Criação de Fila.
     * Cenário: Verificar se a fila é criada corretamente e está vazia.
     */
    @Test
    @Order(1)
    public void createQueuePriorityTest() {
        logger.debug("createQueuePriorityTest() - BEGIN");
        final String expectedQueue = "[0, 1, 2, 3, 5, 9, 15, 18, 23, 78]";
        final QueuePriority<Integer> queuePriority = new QueuePriority<>();
        final int initialSize = queuePriority.getSize();
        queuePriority.addElement(1);
        queuePriority.addElement(18);
        queuePriority.addElement(3);
        queuePriority.addElement(23);
        queuePriority.addElement(9);
        queuePriority.addElement(5);
        queuePriority.addElement(15);
        queuePriority.addElement(2);
        queuePriority.addElement(78);
        queuePriority.addElement(0);
        final int updateSize = queuePriority.getSize();
        Assertions.assertEquals(initialSize, queueEmptySize);
        Assertions.assertEquals(updateSize, queueFullSize);
        Assertions.assertEquals(expectedQueue, queuePriority.toString());
        logger.info("createQueuePriorityTest()       - SUCCESS");
        logger.debug("createQueuePriorityTest() - END");
    }
}
