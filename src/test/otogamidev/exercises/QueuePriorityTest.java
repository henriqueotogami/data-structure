package test.otogamidev.exercises;

import main.otogamidev.exercises.QueuePriority;
import main.otogamidev.exercises.QueuePriorityNoStatic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;

import java.util.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class QueuePriorityTest {

    /** Nome da Classe QueuePriorityTest */
    private static final String CLASS_NAME = "QueuePriorityTest";
    private final Logger logger = LogManager.getLogger(QueuePriorityTest.class);

    private final int queueEmptySize = 0;
    private final int queueFullSize = 10;

    /**
     * <br>Teste 1 - Criação de Fila com Prioridade.
     * <br>Cenário: Verificar se uma lista que recebe pacientes com prioridade desordenada conseguirá
     * ordenar os pacientes por nível de prioridade.
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

    /**
     * <br>Teste 2 - Implementação de classe anônima de Comparator para Lista com Prioridade
     * <br>Cenário: Verificar se uma lista que recebe pacientes com prioridade desordenada conseguirá
     * ordenar os pacientes por nível de prioridade.
     */
    @Test
    @Order(2)
    public void createQueuePriorityAnonymousTest() {
        logger.debug("createQueuePriorityAnonymousTest() - BEGIN");
        final String expectedQueue = "[0, 1, 2, 3, 5, 9, 15, 18, 23, 78]";
        final Queue<QueuePriorityNoStatic.Patient> queuePriority = new PriorityQueue<>(
                new Comparator<QueuePriorityNoStatic.Patient>() {
                    @Override
                    public int compare(final QueuePriorityNoStatic.Patient patient1, final QueuePriorityNoStatic.Patient patient2) {
                        return Integer.valueOf(patient1.getPriority()).compareTo(patient2.getPriority());
                    }
                }
        );

        final int initialSize = queuePriority.size();
        queuePriority.add(new QueuePriorityNoStatic.Patient("A", 1));
        queuePriority.add(new QueuePriorityNoStatic.Patient("F", 18));
        queuePriority.add(new QueuePriorityNoStatic.Patient("D", 3));
        queuePriority.add(new QueuePriorityNoStatic.Patient("J", 23));
        queuePriority.add(new QueuePriorityNoStatic.Patient("W", 9));
        queuePriority.add(new QueuePriorityNoStatic.Patient("K", 5));
        queuePriority.add(new QueuePriorityNoStatic.Patient("G", 15));
        queuePriority.add(new QueuePriorityNoStatic.Patient("B", 2));
        queuePriority.add(new QueuePriorityNoStatic.Patient("C", 78));
        queuePriority.add(new QueuePriorityNoStatic.Patient("M", 0));

        final int updateSize = queuePriority.size();
        Assertions.assertEquals(initialSize, queueEmptySize);
        Assertions.assertEquals(updateSize, queueFullSize);

        final StringBuilder stringBuilder = new StringBuilder("[");
        while(!queuePriority.isEmpty()) {
            stringBuilder.append(queuePriority.poll().getPriority());
            if(!queuePriority.isEmpty()) stringBuilder.append(", ");
        }

        stringBuilder.append("]");
        Assertions.assertEquals(expectedQueue, stringBuilder.toString());
        logger.info("createQueuePriorityAnonymousTest()       - SUCCESS");
        logger.debug("createQueuePriorityAnonymousTest() - END");
    }
}
