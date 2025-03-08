package test.otogamidev.vector;

import main.otogamidev.utils.Utils;
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
    private final String[] vectorFull  = new String[] { "elemento 1", "elemento 2", "elemento 3", "elemento 4", "elemento 5" };
    private final String vectorFullToString = "[elemento 1, elemento 2, elemento 3, elemento 4, elemento 5]";

    private final int vectorEmptySize = 0;
    private final int vectorFullSize = 5;

    private Vector vector = null;

//    =================================================================================================================
//    Variáveis dos Testes Unitarios - Fim
//    =================================================================================================================

    /**
     * Teste 1 - Criação de Fila.
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
     * Teste 2 - Adicionar elementos no Vetor
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

    /**
     * Teste 3 - Converter o conteúdo do Vetor em uma String
     * Cenário: O formato de string final será como um array [elemento 1, elemento 2]
     * possuindo os colchetes no início e fim, e os elementos separados por vírgula seguida de espaço
     */
    @Test
    @Order(3)
    public void toStringTest() {
        logger.debug("toStringTest() - BEGIN");
        this.vector = new Vector(vectorFullSize);
        try {
            for (String element : vectorFull) this.vector.append(element);
        } catch (final IllegalArgumentException illegalArgumentException) {
            logger.debug("toStringTest() - IllegalArgumentException");
            logger.info("toStringTest() - FAILED");
            illegalArgumentException.getStackTrace();
        } catch (final Exception exception) {
            logger.debug("toStringTest() - Exception");
            logger.info("toStringTest() - FAILED");
            exception.getStackTrace();
        }
        final int capable = this.vector.getElements().length;
        final String vectorToString = this.vector.toString();
        Assertions.assertEquals(vectorFullSize, capable);
        Assertions.assertEquals(vectorFullToString, vectorToString);
        logger.info("toStringTest() - SUCCESS");
        logger.debug("toStringTest() - END");
    }

    /**
     * Teste 4 - Buscar um elemento pela posição informada no Vetor
     * Cenário:
     */
    @Test
    @Order(4)
    public void searchTest() {
        logger.debug("searchElement() - BEGIN");
        this.vector = new Vector(vectorFullSize);
        String foundElement = "";
        try {
            for (String element : vectorFull) this.vector.append(element);

            final int randomIndex = Utils.getRandomIndex(this.vectorFullSize);
            foundElement = this.vector.search(randomIndex);
        } catch (final IllegalArgumentException illegalArgumentException) {
            logger.debug("searchElement() - IllegalArgumentException");
            logger.info("searchElement() - FAILED");
            illegalArgumentException.getStackTrace();
        } catch (final NullPointerException nullPointerException) {
            logger.debug("searchElement() - Exception");
            logger.info("searchElement() - FAILED");
            nullPointerException.getStackTrace();
        } catch (final Exception exception) {
            logger.debug("searchElement() - Exception");
            logger.info("searchElement() - FAILED");
            exception.getStackTrace();
        }
        logger.info("searchElement() - SUCCESS");
        logger.debug("searchElement() - END");
    }

}
