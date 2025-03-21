package test.otogamidev.list;

import main.otogamidev.list.LinkedList;
import main.otogamidev.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;

/**
 * Classe responsável pelos testes da classe LinkedList (Lista Encadeada), dos estudos de estruturas de dados.
 *
 * @author henriquematheusalvespereira
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LinkedListTest {

    /** Nome da Classe LinkedListTest */
    private static final String CLASS_NAME = "LinkedListTest";

    /** Intancia de Logs de Testes da Classe LinkedListTest */
    private final Logger logger = LogManager.getLogger(LinkedListTest.class);

//    =================================================================================================================
//    Variáveis dos Testes Unitarios - Inicio
//    =================================================================================================================

    private LinkedList<Integer> linkedList = new LinkedList<Integer>();

    private final String linkedListEmpty = "[]";
    private final String linkedListFull  = "[1,2,3,4,5]";
    private final String expectedLinkedListNoBegin = "[2,3,4,5]";
    private final String expectedLinkedListNoMiddle = "[1,2,4,5]";
    private final String expectedLinkedListNoEnd = "[1,2,3,4]";

    private final int linkedListEmptySize = 0;
    private final int linkedListFullSize  = 5;

    private final int[] arrayOutOfBounds = new int[] { -5, -1, 99 };

//    =================================================================================================================
//    Variáveis dos Testes Unitarios - Fim
//    =================================================================================================================

    /**
     * Construtor da classe de testes da LinkedList
     */
    public LinkedListTest() {

    }


//    =================================================================================================================
//    Testes Unitarios - Inicio
//    =================================================================================================================

    /**
     * Test 1 - Criação de Lista Encadeada vazia
     * Scenario: Instanciar a classe e verificar se possui o tamanho zero.
     */
    @Test
    @Order(1)
    public void createEmptyListTest() {
        logger.debug("createEmptyListTest() - BEGIN");
        final int initialSize = this.linkedList.getSize();

        final String expectedLinkedList = this.linkedListEmpty;
        final String resultLinkedList = this.linkedList.toString();

        logger.info("createFullListTest() - result list = {} | initial size = {}", resultLinkedList, initialSize);
        logger.debug("createEmptyListTest() - END\n");

        Assertions.assertEquals(this.linkedListEmptySize, initialSize);
        Assertions.assertEquals(expectedLinkedList, resultLinkedList);
    }

    /**
     * Test 2 - Criação de Lista Encadeada cheia
     * Scenario: Instanciar a classe e verificar se possui o tamanho cinco.
     */
    @Test
    @Order(2)
    public void createFullListTest() {
        logger.debug("createFullListTest() - BEGIN");
        this.linkedList = new LinkedList(Utils.generateArrayNodes(linkedListFullSize));
        final int resultSize = this.linkedList.getSize();

        final String expectedLinkedList = this.linkedListFull;
        final String resultLinkedList = this.linkedList.toString();

        logger.info("createFullListTest() - result list = {} | result size = {}", resultLinkedList, resultSize);
        logger.debug("createFullListTest() - END\n");

        Assertions.assertEquals(this.linkedListFullSize, resultSize);
        Assertions.assertEquals(expectedLinkedList, resultLinkedList);
    }

    /**
     * Test 3 - Adicionar elementos na lista encadeada.
     * Scenario: Verificar se o tamanho da lista encadeada é o mesmo que a quantidade de elementos adicionados.
     */
    @Test
    @Order(3)
    public void appendTest() {
        logger.debug("appendTest() - BEGIN");
        final int initialSize = this.linkedList.getSize();
        logger.info("appendTest() - initialSize = {}", initialSize);

        this.linkedList.append(1);
        this.linkedList.append(2);
        this.linkedList.append(3);
        this.linkedList.append(4);
        this.linkedList.append(5);

        final int resultSize = this.linkedList.getSize();
        final String expectedLinkedList = this.linkedListFull;
        final String resultLinkedList = this.linkedList.toString();

        logger.info("appendTest() - result list = {} | result size = {}", resultLinkedList, resultSize);
        logger.debug("appendTest() - END\n");

        Assertions.assertEquals(this.linkedListFullSize, resultSize);
        Assertions.assertEquals(expectedLinkedList, resultLinkedList);
    }

    /**
     * Test 4 - Limpeza de Lista Encadeada contendo elementos.
     * Scenario: Verificar se o tamanho final da lista é zero, após limpar toda a lista.
     */
    @Test
    @Order(4)
    public void clearTest() {
        logger.debug("clearTest() - BEGIN");
        final int initialSize = this.linkedList.getSize();
        logger.info("clearTest() - initial size = {}", initialSize);

        this.linkedList.append(1);
        this.linkedList.append(2);
        this.linkedList.append(3);
        this.linkedList.append(4);
        this.linkedList.append(5);

        final int updateSize = this.linkedList.getSize();
        logger.info("clearTest() - update size = {}", updateSize);
        this.linkedList.clear();

        final int resultSize = this.linkedList.getSize();
        final String expectedLinkedList = this.linkedListEmpty;
        final String resultLinkedList = this.linkedList.toString();

        logger.info("clearTest() - result list = {} | result size = {}", resultLinkedList, resultSize);
        logger.debug("clearTest() - END\n");

        Assertions.assertEquals(this.linkedListFullSize, updateSize);
        Assertions.assertTrue(this.linkedList.isEmpty());
        Assertions.assertEquals(expectedLinkedList, resultLinkedList);
    }

    /**
     * Test 5 - Limpeza de Lista Encadeada vazia
     * Scenario: Verificar se o tamanho final da lista é zero
     */
    @Test
    @Order(5)
    public void clearEmptyListTest() {
        logger.debug("clearEmptyListTest() - BEGIN");
        final int initialSize = this.linkedList.getSize();
        logger.info("clearEmptyListTest() - initial size = {}", initialSize);

        this.linkedList.clear();

        final int resultSize = this.linkedList.getSize();
        final String expectedLinkedList = this.linkedListEmpty;
        final String resultLinkedList = this.linkedList.toString();

        logger.info("clearEmptyListTest() - result list = {} | result size = {}", resultLinkedList, resultSize);
        logger.debug("clearEmptyListTest() - END\n");

        Assertions.assertTrue(this.linkedList.isEmpty());
        Assertions.assertEquals(expectedLinkedList, resultLinkedList);
    }

    /**
     * Test 6 - Busca pelo elemento que existe na lista encadeada
     * Scenario: Verificar se o indice do elemento encontrado eh o mesmo do valor esperado
     */
    @Test
    @Order(6)
    public void searchElementTest() {
        logger.debug("searchElementTest() - BEGIN");

        this.linkedList.append(1);
        this.linkedList.append(2);
        this.linkedList.append(3);
        this.linkedList.append(4);
        this.linkedList.append(5);

        final int randomIndex = Utils.getRandomIndex(linkedListFullSize);
        final int elementIndex = this.linkedList.searchElement(randomIndex);
        final int changeIndexToPosition = elementIndex + 1;

        logger.info("searchElementTest() - randomIndex = {} | elementIndex = {}", randomIndex, elementIndex);
        logger.debug("searchElementTest() - END\n");
        Assertions.assertEquals(randomIndex, changeIndexToPosition);
    }

    /**
     * Test 7 - Busca pelo elemento não existente na lista encadeada
     * Scenario: Verificar se o indice do elemento encontrado eh o mesmo do valor esperado
     */
    @Test
    @Order(7)
    public void searchElementNonExistentTest() {
        logger.debug("searchElementNonExistentTest() - BEGIN");

        this.linkedList.append(1);
        this.linkedList.append(2);
        this.linkedList.append(3);
        this.linkedList.append(4);
        this.linkedList.append(5);

        for(int indexOutOfBounds : arrayOutOfBounds) {
            final int elementIndex = this.linkedList.searchElement(indexOutOfBounds);

            logger.info("searchElementNonExistentTest() - indexOutOfBounds = {} | elementIndex = {}", indexOutOfBounds, elementIndex);
            logger.debug("searchElementNonExistentTest() - END\n");
            Assertions.assertEquals(LinkedList.NOT_FOUND_INDEX, elementIndex);
        }
    }

    /**
     * Test 8 - Adicionar elemento no início da lista encadeada.
     * Scenario: Verificar se o elemento será adicionado na primeira posição e se irá preservar a conexão inteira de nós
     */
    @Test
    @Order(8)
    public void appendBeginTest() {
        logger.debug("appendPositionBegin() - BEGIN");

        this.linkedList.append(2);
        this.linkedList.append(3);
        this.linkedList.append(4);
        this.linkedList.append(5);
        final String resultLinkedListNoBegin = this.linkedList.toString();

        this.linkedList.append(0, 1);
        final String resultLinkedListFull = this.linkedList.toString();

        final String expectedLinkedList = this.linkedListFull;
        final String resultLinkedList = this.linkedList.toString();

        logger.debug("appendPositionBegin() - Expected Linked List = {}", expectedLinkedList);
        logger.info("appendPositionBegin() - Result Linked List = {}", resultLinkedList);
        logger.debug("appendPositionBegin() - END\n");

        Assertions.assertEquals(linkedListFull, resultLinkedListFull);
        Assertions.assertEquals(expectedLinkedListNoBegin, resultLinkedListNoBegin);
        Assertions.assertEquals(expectedLinkedList, resultLinkedList);
    }

    /**
     * Test 9 - Adicionar elemento no meio da lista encadeada
     * Scenario: Verificar se o elemento será adicionado na posição informada e se irá preservar a conexão inteira de nós
     */
    @Test
    @Order(9)
    public void appendMiddleTest() {
        logger.debug("appendMiddleTest() - BEGIN");

        this.linkedList.append(1);
        this.linkedList.append(2);
        this.linkedList.append(4);
        this.linkedList.append(5);
        final String resultLinkedListNoMiddle = this.linkedList.toString();

        this.linkedList.append(2, 3);
        final String resultLinkedListFull = this.linkedList.toString();

        final String expectedLinkedList = this.linkedListFull;
        final String resultLinkedList = this.linkedList.toString();

        logger.debug("appendMiddleTest() - Expected Linked List = {}", expectedLinkedList);
        logger.info("appendMiddleTest() - Result Linked List = {}", resultLinkedList);
        logger.debug("appendMiddleTest() - END\n");

        Assertions.assertEquals(linkedListFull, resultLinkedListFull);
        Assertions.assertEquals(expectedLinkedListNoMiddle, resultLinkedListNoMiddle);
        Assertions.assertEquals(expectedLinkedList, resultLinkedList);
    }

    /**
     * Test 10 - Adicionar elemento no fim da lista encadeada
     * Scenario: Verificar se o elemento será adicionado na posição final e se irá preservar a conexão inteira de nós
     */
    @Test
    @Order(10)
    public void appendEndTest() {
        logger.debug("appendEndTest() - BEGIN");

        this.linkedList.append(1);
        this.linkedList.append(2);
        this.linkedList.append(3);
        this.linkedList.append(4);
        final String resultLinkedListNoEnd = this.linkedList.toString();

        this.linkedList.append(4, 5);
        final String resultLinkedListFull = this.linkedList.toString();

        final String expectedLinkedList = this.linkedListFull;
        final String resultLinkedList = this.linkedList.toString();

        logger.debug("appendEndTest() - Expected Linked List = {}", expectedLinkedList);
        logger.info("appendEndTest() - Result Linked List = {}", resultLinkedList);
        logger.debug("appendEndTest() - END\n");

        Assertions.assertEquals(linkedListFull, resultLinkedListFull);
        Assertions.assertEquals(expectedLinkedListNoEnd, resultLinkedListNoEnd);
        Assertions.assertEquals(expectedLinkedList, resultLinkedList);
    }

    /**
     * Test 11 - Adicionar elemento em posições inválidas
     * Scenario: Verificar se o metodo append irá lançar a excecão IllegalArgumentException
     */
    @Test
    @Order(11)
    public void appendOutOfBoundsTest() {
        logger.debug("appendOutOfBoundsTest() - BEGIN");

        this.linkedList.append(1);
        this.linkedList.append(2);
        this.linkedList.append(3);
        this.linkedList.append(4);
        this.linkedList.append(5);

        for(final int indexOutOfBounds : arrayOutOfBounds) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> this.linkedList.append(indexOutOfBounds, 99));
        }
        logger.debug("appendOutOfBoundsTest() - END");
    }

    /**
     * Test 12 - Remover o primeiro elemento da lista encadeada
     * Scenario: Verificar se apenas o elemento será removido e permcanece a conexão inteira da lista
     */
    @Test
    @Order(12)
    public void removeFirstElementTest() {
        logger.debug("removeFirstElementTest() - BEGIN");

        this.linkedList.append(1);
        this.linkedList.append(2);
        this.linkedList.append(3);
        this.linkedList.append(4);
        this.linkedList.append(5);

        final String expectedLinkedList = Utils.getListWithoutSpecificIndex(this.linkedList, 0);
        final Object elementRemoved = this.linkedList.removeFirstElement();
        final String resultLinkedList = this.linkedList.toString();

        logger.debug("removeFirstElementTest() - Expected Linked List = {}", expectedLinkedList);
        logger.info("removeFirstElementTest() - Result Linked List = {}", resultLinkedList);
        logger.debug("removeFirstElementTest() - END\n");

        Assertions.assertEquals(expectedLinkedList, resultLinkedList);
    }

    /**
     * Test 13 - Remover o ultimo elemento da lista encadeada
     * Scenario: Verificar se apenas o elemento será removido e permcanece a conexão inteira da lista
     */
    @Test
    @Order(13)
    public void removeLastElementTest() {
        logger.debug("removeLastElementTest() - BEGIN");

        this.linkedList.append(1);
        this.linkedList.append(2);
        this.linkedList.append(3);
        this.linkedList.append(4);
        this.linkedList.append(5);

        final String expectedLinkedList = Utils.getListWithoutSpecificIndex(this.linkedList, this.linkedList.getLastIndex());
        final Object elementRemoved = this.linkedList.removeLastElement();
        final String resultLinkedList = this.linkedList.toString();

        logger.debug("removeLastElementTest() - Expected Linked List = {}", expectedLinkedList);
        logger.info("removeLastElementTest() - Result Linked List = {}", resultLinkedList);
        logger.debug("removeLastElementTest() - END\n");

        Assertions.assertEquals(expectedLinkedList, resultLinkedList);
    }

    /**
     * Test 14 - Remover um elemento da lista encadeada
     * Scenario: Verificar se apenas o elemento será removido e permcanece a conexão inteira da lista
     */
    @Test
    @Order(14)
    public void removeElementTest() {
        logger.debug("removeElementTest() - BEGIN");

        this.linkedList.append(1);
        this.linkedList.append(2);
        this.linkedList.append(3);
        this.linkedList.append(4);
        this.linkedList.append(5);
        final int expectedLinkedListSize = this.linkedList.getSize()-1;

        final int randomIndex = Utils.getRandomIndex(this.linkedList.getSize());
        final String expectedLinkedList = Utils.getListWithoutSpecificIndex(this.linkedList, randomIndex);

        final Object elementRemoved = this.linkedList.removeElement(randomIndex);
        final String resultLinkedList = this.linkedList.toString();

        logger.debug("removeElementTest() - Expected Linked List = {}", expectedLinkedList);
        logger.info("removeElementTest() - Result Linked List = {}", resultLinkedList);
        logger.debug("removeElementTest() - END\n");

        Assertions.assertEquals(expectedLinkedListSize, this.linkedList.getSize());
        Assertions.assertEquals(expectedLinkedList, resultLinkedList);
    }

    /**
     * Test 15 - Remover um elemento da lista encadeada de posição inválida
     * Scenario: Verificar se o metodo remove irá lançar a excecão RuntimeException
     */
    @Test
    @Order(15)
    public void removeElementOutOfBoundsTest() {
        logger.debug("removeElementOutOfBoundsTest() - BEGIN");
        this.linkedList = new LinkedList(Utils.generateArrayNodes(linkedListFullSize));

        final int resultSize = this.linkedList.getSize();
        final String resultLinkedList = this.linkedList.toString();

        for(final int indexOutOfBounds : arrayOutOfBounds) {
            Assertions.assertThrows(RuntimeException.class, () -> this.linkedList.removeElement(indexOutOfBounds));
        }

        logger.debug("removeElementOutOfBoundsTest() - result list = {} | result size = {}", resultLinkedList, resultSize);
        logger.debug("removeElementOutOfBoundsTest() - END\n");
    }

    /**
     * Test 16 - Remover um elemento do inicio da lista encadeada
     * Scenario: Verificar se o metodo remove irá lançar a excecão RuntimeException
     */
    @Test
    @Order(16)
    public void removeFirstElementEmptyListTest() {
        logger.debug("removeFirstElementEmptyListTest() - BEGIN");
        this.linkedList = new LinkedList(Utils.generateArrayNodes(linkedListFullSize));
        this.linkedList.clear();
        final int resultSize = this.linkedList.getSize();
        final String resultLinkedList = this.linkedList.toString();

        Assertions.assertThrows(RuntimeException.class, () -> this.linkedList.removeFirstElement());
        logger.debug("removeFirstElementEmptyListTest() - result list = {} | result size = {}", resultLinkedList, resultSize);
        logger.debug("removeFirstElementEmptyListTest() - END\n");
    }

    /**
     * Test 17 - Remover um elemento do fim da lista encadeada
     * Scenario: Verificar se o metodo remove irá lançar a excecão RuntimeException
     */
    @Test
    @Order(17)
    public void removeEndElementEmptyListTest() {
        logger.debug("removeEndElementEmptyListTest() - BEGIN");
        this.linkedList = new LinkedList(Utils.generateArrayNodes(linkedListFullSize));
        this.linkedList.clear();
        final int resultSize = this.linkedList.getSize();
        final String resultLinkedList = this.linkedList.toString();

        Assertions.assertThrows(RuntimeException.class, () -> this.linkedList.removeLastElement());

        logger.debug("removeEndElementEmptyListTest() - result list = {} | result size = {}", resultLinkedList, resultSize);
        logger.debug("removeEndElementEmptyListTest() - END\n");
    }

//    =================================================================================================================
//    Testes Unitarios - Fim
//    =================================================================================================================
}
