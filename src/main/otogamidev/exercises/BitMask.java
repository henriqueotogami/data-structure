package main.otogamidev.exercises;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

/**
 * Classe responsavel pela implementação de exercícios de manipulação de bits.
 * @author henriquematheusalvespereira
 */
public class BitMask {

    private static final Logger logger = LogManager.getLogger(BitMask.class);

    /**
     * Metodo para validar o bitmask recebido.
     * @param received Bitmask recebido.
     */
    public String[] validateActivatedSensors(final int received) {

        final HashMap<Integer, String> sensors = this.getSensors();
        final String ENABLED  = "ENABLED";
        final String DISABLED = "DISABLED";

        String[] statusSensors = new String[8];
        String message = "";
        boolean isEnabled = false;
        for(int index = 0; 8 > index; index++) {
            final int mask = 1 << index;
            isEnabled = (received & mask) != 0;
            message = sensors.get(index) + " - " + (isEnabled ? ENABLED : DISABLED);
            statusSensors[index] = message;
//            logger.info(message);
        }

        return statusSensors;
    }

    /**
     * Metodo para obter os tipos de sensores.
     * @return Retorna um HashMap com os sensores.
     */
    private HashMap<Integer, String> getSensors() {

        final String[] sensors = {
                "Sensor de Temperatura",
                "Sensor de Umidade",
                "Sensor de Luminosidade",
                "Sensor de Presença",
                "Sensor de Fumaça",
                "Sensor de Pressão",
                "Acelerômetro",
                "Giroscópio"
        };

        HashMap<Integer, String> hashMap = new HashMap<>();

        for(int index = 0; sensors.length > index; index++) {
            hashMap.put(index, sensors[index]);
        }

        return hashMap;
    }
}
