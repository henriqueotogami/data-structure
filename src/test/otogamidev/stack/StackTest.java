package test.otogamidev.stack;

import main.otogamidev.stack.Stack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

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

    public static void main(String[] args) {

        final Stack<Integer> stack = new Stack<Integer>();
        System.out.println(stack);
        System.out.println(stack.getSize());
    }
}
