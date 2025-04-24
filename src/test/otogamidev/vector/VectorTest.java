package test.otogamidev.vector;

import main.otogamidev.utils.Utils;
import main.otogamidev.vector.Vector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.EmptyStackException;

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
        logger.info("createVectorTest()       - SUCCESS");
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
            logger.info("appendTest()             - SUCCESS");
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
            logger.info("toStringTest()           - SUCCESS");
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
            foundElement = (String) this.vector.searchByPosition(randomIndex);

            logger.info("searchByPositionTest()   - SUCCESS");
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
            logger.info("searchByElementTest()    - SUCCESS");
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
            logger.info("isFoundElementTest()     - SUCCESS");
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
            logger.info("appendElementTest()      - SUCCESS");
            logger.debug("appendElementTest() - END");

        } catch (final IllegalArgumentException illegalArgumentException) {
            logger.info("appendElementTest() - IllegalArgumentException - FAILED");
            illegalArgumentException.getStackTrace();
        } catch (final Exception exception) {
            logger.info("appendElementTest() - Exception - FAILED");
            exception.getStackTrace();
        }
    }

    /**
     * Teste 8 - Obtenção de todos os índices vazios do Vetor.
     * Cenário: Localizar todos os índices do Vetor com valor null.
     */
    @Test
    @Order(8)
    public void getEmptyIndexesTest() {
        logger.debug("getEmptyIndexesTest() - BEGIN");
        this.vector = new Vector(5);
        this.vector.append(1, "A");
        this.vector.append(3, "B");
        final int[] emptyIndexes = this.vector.getEmptyIndexes();
        logger.debug("getEmptyIndexesTest() - emptyIndexes = {}", Arrays.toString(emptyIndexes));
        logger.debug("getEmptyIndexesTest() - vector = {}", this.vector.toString());
        logger.info("getEmptyIndexesTest()    - SUCCESS");
    }

    /**
     * Teste 9 - Incremento do tamanho do Vetor instanciado.
     * Cenário: Dobrar a capacidade do tamanho do Vetor informado na inicialização.
     */
    @Test
    @Order(9)
    public void increaseCapacityTest() {
        try {
            logger.debug("increaseCapacityTest() - BEGIN");
            this.vector = new Vector(vectorFullSize);
            for (String element : vectorFull) this.vector.append(element);
            this.vector.append("Element 11");
            this.vector.append("Element 12");
            this.vector.append("Element 13");
            this.vector.append("Element 14");
            final int incrementedVectorFullSize = vectorFullSize * 2;
            Assertions.assertEquals(incrementedVectorFullSize, this.vector.getElements().length);
            logger.info("increaseCapacityTest()   - SUCCESS");
        } catch (EmptyStackException emptyStackException) {
            logger.info("increaseCapacityTest()   - FAIL");
            emptyStackException.printStackTrace();
        } finally {
            logger.debug("increaseCapacityTest() - END");
        }
    }

    /**
     * Teste 10 - Remove elemento da posição do Vetor informada.
     * Cenário: Ao remover um elemento, realoca os demais elementos.
     */
    @Test
    @Order(10)
    public void removeElementByPositionTest() {
        try {
            logger.debug("removeTest() - BEGIN");
            this.vector = new Vector(vectorFullSize);
            for (String element : vectorFull) this.vector.append(element);
            logger.debug("Vector inicial = {}",vector.toString());
            final int randomIndex = Utils.getRandomIndex(vectorFullSize);
            this.vector.remove(randomIndex);
            logger.debug("Posição removida = {}",randomIndex);
            logger.debug("Vector final = {}",vector.toString());
            Assertions.assertEquals(vectorFullSize-1, this.vector.getSize());
            logger.info("removeTest()             - SUCCESS");
        } catch (EmptyStackException emptyStackException) {
            logger.info("removeTest()   - FAIL");
            emptyStackException.printStackTrace();
        } finally {
            logger.debug("removeTest() - END");
        }
    }

    /**
     * Teste 11 - Verifica a existencia de um elemento no Vetor.
     * Cenário: Busca o elemento desejado no Vetor.
     */
    @Test
    @Order(11)
    public void containsByElementTest() {
        try {
            logger.debug("containsByElementTest() - BEGIN");
            this.vector = new Vector(vectorFullSize);
            for (String element : vectorFull) this.vector.append(element);
            logger.debug("Vector inicial = {}",vector.toString());
            final int randomIndex = Utils.getRandomIndex(vectorFullSize);
            final String randomElement = this.vectorFull[randomIndex];
            final boolean containsElement = this.vector.contains(randomElement);
            Assertions.assertTrue(containsElement);
            logger.info("containsByElementTest()    - SUCCESS");
        } catch (EmptyStackException emptyStackException) {
            logger.info("containsByElementTest()   - FAIL");
            emptyStackException.printStackTrace();
        } finally {
            logger.debug("containsByElementTest() - END");
        }
    }

    /**
     * Teste 12 - Verifica a existencia de um elemento no Vetor.
     * Cenário: Busca a posição do elemento desejado no Vetor.
     */
    @Test
    @Order(12)
    public void containsByPositionTest() {
        try {
            logger.debug("containsByPositionTest() - BEGIN");
            this.vector = new Vector(vectorFullSize);
            for (String element : vectorFull) this.vector.append(element);
            logger.debug("Vector inicial = {}",vector.toString());
            final int randomIndex = Utils.getRandomIndex(vectorFullSize);
            final boolean containsElement = this.vector.contains(randomIndex);
            Assertions.assertTrue(containsElement);
            logger.info("containsByPositionTest() - SUCCESS");
        } catch (EmptyStackException emptyStackException) {
            logger.info("containsByPositionTest()   - FAIL");
            emptyStackException.printStackTrace();
        } finally {
            logger.debug("containsByPositionTest() - END");
        }
    }

    /**
     * Teste 13 - Verifica a última ocorrência de um elemento no Vetor.
     * Cenário: Busca o elemento desejado no Vetor do fim para o comeco.
     */
    @Test
    @Order(13)
    public void lastIndexOfElementTest() {
        try {
            logger.debug("lastIndexOfElementTest() - BEGIN");
            this.vector = new Vector(vectorFullSize);
            this.vector.append("A");
            this.vector.append("B");
            this.vector.append("C");
            this.vector.append("A");
            this.vector.append("D");
            final int foundLastIndex = this.vector.getLastIndexOfElement("A");
            Assertions.assertEquals(3, foundLastIndex);
            logger.info("lastIndexOfElementTest() - SUCCESS");
        } catch (Exception exception) {
            logger.info("lastIndexOfElementTest()   - FAIL");
            exception.printStackTrace();
        } finally {
            logger.debug("lastIndexOfElementTest() - END");
        }
    }

    @Test
    @Order(14)
    public void removeByElement() {
        try {
            logger.debug("removeByElement() - BEGIN");
            this.vector = new Vector(vectorFullSize);
            for (String element : vectorFull) this.vector.append(element);
            logger.debug("Vector inicial = {}",vector.toString());
            final int randomIndex = Utils.getRandomIndex(vectorFullSize);
            final boolean containsElement = this.vector.contains(randomIndex);
            Assertions.assertTrue(containsElement);

            final Object randomElement = this.vector.searchByPosition(randomIndex);
            this.vector.remove(randomElement);
            final boolean wasRemovedElement = !this.vector.contains(randomElement);
            Assertions.assertTrue(wasRemovedElement);
            logger.info("removeByElement() - SUCCESS");
        } catch (Exception exception) {
            logger.info("removeByElement()   - FAIL");
            exception.printStackTrace();
        } finally {
            logger.debug("removeByElement() - END");
        }
    }

}
