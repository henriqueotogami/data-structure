package test.otogamidev.list;

import main.otogamidev.list.LinkedList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LinkedListTest {

    private static final String CLASS_NAME = "LinkedListTest";

    private final Logger logger = LogManager.getLogger(LinkedListTest.class);
    private final LinkedList linkedList = new LinkedList();
//    ===========================
//    Testes Unitarios - Inicio
//    ===========================
    @Test
    @Order(1)
    void createLinkedListTest() {
        logger.debug("createLinkedListTest() - BEGIN");
        final int initialSize = this.linkedList.getSize();
        logger.info("createLinkedListTest() - initialSize = {}", initialSize);
        logger.debug("createLinkedListTest() - END");
//       Gambiarra pra printar linha inteira vazia
        System.out.println("");
        Assertions.assertEquals(0, initialSize);
    }

    @Test
    @Order(2)
    void appendTest() {
        logger.debug("appendTest() - BEGIN");
        this.linkedList.append(1);
        this.linkedList.append(2);
        this.linkedList.append(3);
        final int initialSize = this.linkedList.getSize();
        logger.info("appendTest() - initialSize = {}", initialSize);
        logger.debug("appendTest() - END");
//       Gambiarra pra printar linha inteira vazia
        System.out.println("");
        Assertions.assertEquals(3, initialSize);
    }

//    ===========================
//    Testes Unitarios - Fim
//    ===========================
}
