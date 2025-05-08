package test.otogamidev.stack;

import main.otogamidev.stack.Stack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;

import java.util.Arrays;

/**
 * Classe responsável pelos testes da classe Stack.
 *
 * @author henriquematheusalvespereira
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StackTest {

//    =================================================================================================================
//    Variáveis dos Testes Unitarios - Inicio
//    =================================================================================================================

    /** Nome da Classe StackTest */
    private static final String CLASS_NAME = "StackTest";
    private final Logger logger = LogManager.getLogger(StackTest.class);

//    =================================================================================================================
//    Variáveis dos Testes Unitarios - Fim
//    =================================================================================================================

    /**
     * Teste 1 - Instancia de uma Pilha
     * Cenário: Verificar se a pilha é criada com a capacidade padrao de 10 elementos null e está vazia.
     */
    @Test
    @Order(1)
    public void initEmptyStackTest() {
        final Stack<Integer> stack = new Stack<Integer>();
        final String emptyStack = "[null, null, null, null, null, null, null, null, null, null]";
        Assertions.assertEquals(emptyStack, stack.toString());
        Assertions.assertEquals(0, stack.getSize());
        logger.info("initEmptyStackTest() - SUCESS");
    }

    /**
     * Teste 2 - Empilhar elementos
     * Cenário: Adicionar elementos no fim da Pilha (LIFO - Last In First Out)
     * <br>
     * <br>     [3] - | valor 4 | -> Empilhando elemento
     * <br>
     * <br>     [2] - | valor 3 |
     * <br>     [1] - | valor 2 |
     * <br>     [0] - | valor 1 |
     */
    @Test
    @Order(2)
    public void pushTest(){
        final int[] array = new int[10];
        final Stack<Integer> stack = new Stack<Integer>();

        for(int index = 0; array.length > index; index++) {
            final int value = index + 1;
            array[index] = value;
            stack.push(value);
        }

        Assertions.assertEquals(Arrays.toString(array), stack.toString());
        Assertions.assertEquals(array.length, stack.getSize());
        logger.info("pushTest() - SUCESS");
    }

    /**
     * Teste 3 - Pilha vazia
     * Cenário: Criar uma pilha e verificar se o metodo isEmpty retorna true.
     *          Adicionar elementos, e verificar se o metodo isEmpty retorna false.
     */
    @Test
    @Order(3)
    public void isEmptyTest() {
        final Stack<Integer> stack = new Stack<Integer>();
        Assertions.assertTrue(stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assertions.assertFalse(stack.isEmpty());
        logger.info("isEmptyTest() - SUCESS");
    }

    @Test
    @Order(4)
    public void pullTest() {
        final String initStack      = "[1, 2, 3, null, null, null, null, null, null, null]";
        final String alteredStack   = "[1, 2, null, null, null, null, null, null, null, null]";
        final int initialSize = 3;
        final Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assertions.assertEquals(initStack, stack.toString());
        Assertions.assertEquals(initialSize, stack.getSize());
        final int element = stack.pull();
        logger.info("pullTest() - element = {}", element);

        logger.info("pullTest() - this.size = {}", stack.getSize());
        Assertions.assertEquals(alteredStack, stack.toString());
        Assertions.assertEquals(initialSize-1, stack.getSize());
        logger.info("pullTest() - SUCESS");
    }
}
