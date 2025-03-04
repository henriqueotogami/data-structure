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

    private final String vectorEmpty = "[]";
    private final String vectorFull[]  = new String[] { "elemento 1", "elemento 2", "elemento 3", "elemento 4", "elemento 5" };

    private final int vectorEmptySize = 0;
    private final int vectorFullSize = 5;

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
        this.vector = new Vector(vectorEmptySize);
        final int initialCapable = this.vector.getElements().length;
        this.vector = new Vector(vectorFullSize);
        final int updateCapable = this.vector.getElements().length;
        Assertions.assertEquals(initialCapable, vectorEmptySize);
        Assertions.assertEquals(updateCapable, vectorFullSize);
        logger.info("createVectorTest() - SUCCESS");
        logger.debug("createVectorTest() - END");
    }

    /**
     * Test 2 - Adicionar elementos no Vetor
     * Cenário: Instanciar o Vetor com capacidade de 5 elementos, depois adicionar os elementos e
     * verificar se o tamanho é incrementado
     */
    @Test
    @Order(2)
    public void appendTest() {
        logger.debug("appendTest() - BEGIN");
        this.vector = new Vector(vectorFullSize);
        try {
            for (String element : vectorFull) this.vector.append(element);
        } catch (final IllegalArgumentException illegalArgumentException) {
            logger.debug("appendTest() - IllegalArgumentException");
            logger.info("appendTest() - FAILED");
            illegalArgumentException.getStackTrace();
        } catch (final Exception exception) {
            logger.debug("appendTest() - Exception");
            logger.info("appendTest() - FAILED");
            exception.getStackTrace();
        }
        final int capable = this.vector.getElements().length;
        Assertions.assertEquals(vectorFullSize, capable);
        logger.info("appendTest() - SUCCESS");
        logger.debug("appendTest() - END");
    }

}
