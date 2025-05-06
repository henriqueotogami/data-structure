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

    @Test
    @Order(1)
    public void initEmptyStackTest() {
        final Stack<Integer> stack = new Stack<Integer>();
        final String emptyStack = "[null, null, null, null, null, null, null, null, null, null]";
        Assertions.assertEquals(emptyStack, stack.toString());
        Assertions.assertEquals(0, stack.getSize());
        logger.info("initEmptyStackTest() - SUCESS");
    }

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
}
