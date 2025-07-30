package test.otogamidev.utils;

import main.otogamidev.utils.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;

import java.nio.charset.StandardCharsets;

/**
 * Classe responsável pelos testes da classe StringUtils.
 *
 * @author henriquematheusalvespereira
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StringUtilsTest {

//    =================================================================================================================
//    Variáveis dos Testes Unitarios - Inicio
//    =================================================================================================================

    private static final String CLASS_NAME = StringUtilsTest.class.getName();
    private final Logger logger = LogManager.getLogger(StringUtilsTest.class);

    private final String name = "Henrique Otogami";
    private final StringUtils stringUtils = new StringUtils();
//    =================================================================================================================
//    Variáveis dos Testes Unitarios - Fim
//    =================================================================================================================

    /**
     * Teste 1 - Criação de Fila.
     * Cenário: Verificar se a fila é criada corretamente e está vazia.
     */
    @Test
    @Order(1)
    public void recoverString() {
        logger.debug("recoverString() - BEGIN");
        final String recovered = stringUtils.recoverString(name.getBytes(), StandardCharsets.UTF_8);
        Assertions.assertEquals(name, recovered);
        logger.info("recoverString() - SUCCESS");
        logger.debug("recoverString() - END");
    }
}
