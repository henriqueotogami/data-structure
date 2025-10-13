package test.otogamidev.exercises;

import main.otogamidev.exercises.BitMask;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;

/**
 * Classe de Testes para a classe BitMask
 * @author henriquematheusalvespereira
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BitMaskTest {

    private static final String CLASS_NAME = "BitMaskTest";
    private final Logger logger = LogManager.getLogger(BitMaskTest.class);

    @Test
    @Order(1)
    public void validateActivateSensors() {
        logger.debug("validateActivateSensors() - BEGIN");
        final int received              = 0x7F;
        final BitMask bitMask           = new BitMask();
        final String[] validatedSensors = bitMask.validateActivatedSensors(received);
        for(String sensor : validatedSensors) {
            logger.info(sensor);
        }
        Assertions.assertEquals(8, validatedSensors.length);
        logger.debug("validateActivateSensors() - END");
    }
}
