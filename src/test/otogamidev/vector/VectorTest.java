package test.otogamidev.vector;

import main.otogamidev.vector.Vector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;

/**
 * Classe responsável pelos testes da classe Vector.
 *
 * @author henriquematheusalvespereira
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VectorTest {

//    =================================================================================================================
//    Variáveis dos Testes Unitarios - Inicio
//    =================================================================================================================

    /** Nome da Classe VectorTest */
    private static final String CLASS_NAME = "VectorTest";
    private final Logger logger = LogManager.getLogger(VectorTest.class);

    private final String linkedListEmpty = "[]";
    private final String linkedListFull  = "[1,2,3,4,5]";

    private final int linkedListEmptySize = 0;
    private final int linkedListFullSize  = 5;

    private Vector vector = null;

//    =================================================================================================================
//    Variáveis dos Testes Unitarios - Fim
//    =================================================================================================================

    /**
     * Test 1 - Criação de Fila.
     * Cenário: Verificar se a fila é criada corretamente e está vazia.
     */
    @Test
    @Order(1)
    public void createVectorTest() {
        logger.debug("createVectorTest() - BEGIN");
        this.vector = new Vector(0);
        final int initialSize = this.vector.getSize();
        this.vector = new Vector(5);
        final int updateSize = this.vector.getSize();
        Assertions.assertEquals(initialSize, linkedListEmptySize);
        Assertions.assertEquals(updateSize, linkedListFullSize);
        logger.info("createVectorTest() - SUCCESS");
        logger.debug("createVectorTest() - END");
    }

}
