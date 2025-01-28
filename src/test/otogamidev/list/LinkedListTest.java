package test.otogamidev.list;

import main.otogamidev.list.LinkedList;
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

    private final Logger logger = LogManager.getLogger(LinkedListTest.class);
    private final LinkedList<Object> linkedList = new LinkedList();

//    ===========================
//    Testes Unitarios - Inicio
//    ===========================

    /**
     * @Test 1 - Criação de Lista Encadeada
     * @Scenario Instanciar a classe e possuir o tamanho zero.
     */
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

    /**
     * @Test 2 - Adicionar elementos na lista encadeada.
     * @Scenario Verificar se o tamanho da lista encadeada é o mesmo que a quantidade de elementos adicionados.
     */
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

    /**
     * @Test 3 - Limpeza de Lista Encadeada contendo elementos.
     * @Scenario Verificar se o tamanho final da lista é zero, após limpar toda a lista.
     */
    @Test
    @Order(3)
    void clearTest() {
        logger.debug("clearTest() - BEGIN");
        this.linkedList.append(1);
        this.linkedList.append(2);
        this.linkedList.append(3);
        final int initialSize = this.linkedList.getSize();
        logger.info("clearTest() - initial size = {}", initialSize);
        this.linkedList.clear();
        final int updateSize = this.linkedList.getSize();
        logger.info("clearTest() - update size = {}", updateSize);
        logger.debug("clearTest() - END");
//       Gambiarra pra printar linha inteira vazia
        System.out.println("");
        Assertions.assertTrue(this.linkedList.isEmpty());
    }

    /**
     * @Test 4 - Busca por tipo de elemento
     * @Scenario Verificar se o indice do elemento encontrado eh o mesmo do valor esperado
     */
    @Test
    @Order(4)
    void searchElementTest() {
        logger.debug("searchElementTest() - BEGIN");
        this.linkedList.append(1);
        this.linkedList.append(2);
        this.linkedList.append(3);

        final Object element = this.linkedList.searchElement(1);
        logger.info("searchElementTest() - element = {}", element);
        logger.debug("searchElementTest() - END");
//       Gambiarra pra printar linha inteira vazia
        System.out.println("");
        Assertions.assertEquals(0, element);
    }
//    ===========================
//    Testes Unitarios - Fim
//    ===========================
}
