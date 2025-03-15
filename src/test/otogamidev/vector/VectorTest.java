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
        logger.info("createVectorTest()     - SUCCESS");
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

            final int capable = this.vector.getElements().length;
            Assertions.assertEquals(vectorFullSize, capable);
            logger.info("appendTest()           - SUCCESS");
            logger.debug("appendTest() - END");

        } catch (final IllegalArgumentException illegalArgumentException) {
            logger.info("appendTest() - IllegalArgumentException - FAILED");
            illegalArgumentException.getStackTrace();
        } catch (final Exception exception) {
            logger.info("appendTest() - Exception - FAILED");
            exception.getStackTrace();
        }
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

            final int capable = this.vector.getElements().length;
            final String vectorToString = this.vector.toString();
            Assertions.assertEquals(vectorFullSize, capable);
            Assertions.assertEquals(vectorFullToString, vectorToString);
            logger.info("toStringTest()         - SUCCESS");
            logger.debug("toStringTest() - END");

        } catch (final IllegalArgumentException illegalArgumentException) {
            logger.info("toStringTest() - IllegalArgumentException - FAILED");
            illegalArgumentException.getStackTrace();
        } catch (final Exception exception) {
            logger.info("toStringTest() - Exception - FAILED");
            exception.getStackTrace();
        }
    }

    /**
     * Teste 4 - Buscar um elemento pela posição informada no Vetor
     * Cenário: busca um elemento com posição válida
     */
    @Test
    @Order(4)
    public void searchByPositionTest() {
        logger.debug("searchByPositionTest() - BEGIN");
        this.vector = new Vector(vectorFullSize);
        String foundElement = "";
        try {
            for (String element : vectorFull) this.vector.append(element);
            final int randomIndex = Utils.getRandomIndex(this.vectorFullSize);
            foundElement = this.vector.searchByPosition(randomIndex);

            logger.info("searchByPositionTest() - SUCCESS");
            logger.debug("searchByPositionTest() - END");

        } catch (final IllegalArgumentException illegalArgumentException) {
            logger.info("searchByPositionTest() - IllegalArgumentException - FAILED");
            illegalArgumentException.getStackTrace();
        } catch (final NullPointerException nullPointerException) {
            logger.info("searchByPositionTest() - NullPointerException - FAILED");
            nullPointerException.getStackTrace();
        } catch (final Exception exception) {
            logger.info("searchByPositionTest() - Exception - FAILED");
            exception.getStackTrace();
        }
    }

    /**
     * Teste 5 - Buscar um elemento no Vetor
     * Cenário: busca um elemento que existe no Vetor, retornando o índice do elemento encontrado
     */
    @Test
    @Order(5)
    public void searchByElementTest(){
        logger.debug("searchByElementTest() - BEGIN");
        this.vector = new Vector(vectorFullSize);
        int foundElementIndex = 0;
        int randomIndex = 0;
        try {
            for (String element : vectorFull) this.vector.append(element);
            randomIndex = Utils.getRandomIndex(this.vectorFullSize);
            foundElementIndex = this.vector.searchByElement(this.vectorFull[randomIndex]);

            Assertions.assertEquals(randomIndex, foundElementIndex);
            logger.info("searchByElementTest()  - SUCCESS");
            logger.debug("searchByElementTest() - END");

        } catch (final IllegalArgumentException illegalArgumentException) {
            logger.info("searchByElementTest() - IllegalArgumentException - FAILED");
            illegalArgumentException.getStackTrace();
        } catch (final NullPointerException nullPointerException) {
            logger.info("searchByElementTest() - NullPointerException - FAILED");
            nullPointerException.getStackTrace();
        } catch (final Exception exception) {
            logger.info("searchByElementTest() - Exception - FAILED");
            exception.getStackTrace();
        }
    }

    /**
     * Teste 6 - Buscar um elemento no Vetor
     * Cenário: busca um elemento que existe no Vetor, retornando valor boolean
     */
    @Test
    @Order(6)
    public void isFoundElementTest(){
        logger.debug("isFoundElementTest() - BEGIN");
        this.vector = new Vector(vectorFullSize);
        boolean foundElementIndex = false;
        int randomIndex = 0;
        try {
            for (String element : vectorFull) this.vector.append(element);
            randomIndex = Utils.getRandomIndex(this.vectorFullSize);
            foundElementIndex = this.vector.isFoundElement(this.vectorFull[randomIndex]);

            Assertions.assertTrue(foundElementIndex);
            logger.info("isFoundElementTest()   - SUCCESS");
            logger.debug("isFoundElementTest() - END");

        } catch (final IllegalArgumentException illegalArgumentException) {
            logger.info("isFoundElementTest() - IllegalArgumentException - FAILED");
            illegalArgumentException.getStackTrace();
        } catch (final NullPointerException nullPointerException) {
            logger.info("isFoundElementTest() - NullPointerException - FAILED");
            nullPointerException.getStackTrace();
        } catch (final Exception exception) {
            logger.info("isFoundElementTest() - Exception - FAILED");
            exception.getStackTrace();
        }
    }

    /**
     * Teste 7 - Adicionar um elemento na posição informada no Vetor
     * Cenário: Intancia um Vetor com espaço disponível e depois adiciona elemento na posicão informada
     */
    @Test
    @Order(7)
    public void appendElementTest() {
        logger.debug("appendElementTest() - BEGIN");
        this.vector = new Vector(this.vectorFullSize);
        try {
            final int randomIndex = Utils.getRandomIndex(this.vectorFullSize);
            final int randomSize = this.vectorFull.length - 2;

            for(int index = 0; randomSize >= index; index++) this.vector.append(this.vectorFull[index]);
            logger.debug("appendElementTest() - Vector inicial = {}",this.vector.toString());

            final String elementModified = vectorFull[randomIndex].concat("MO");
            this.vector.append(randomIndex, elementModified);
            logger.debug("appendElementTest() - Vector modificado = {}",this.vector.toString());

            final int capable = this.vector.getElements().length;
            Assertions.assertEquals(vectorFullSize, capable);
            logger.info("appendElementTest()    - SUCCESS");
            logger.debug("appendElementTest() - END");

        } catch (final IllegalArgumentException illegalArgumentException) {
            logger.info("appendElementTest() - IllegalArgumentException - FAILED");
            illegalArgumentException.getStackTrace();
        } catch (final Exception exception) {
            logger.info("appendElementTest() - Exception - FAILED");
            exception.getStackTrace();
        }
    }

}
