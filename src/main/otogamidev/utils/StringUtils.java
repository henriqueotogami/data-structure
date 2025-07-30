package main.otogamidev.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.charset.Charset;

/**
 * Classe responsavel pelos metodos utilitarios de String.
 *
 * @author henriquematheusalvespereira
 */
public class StringUtils {

    private static final String CLASS_NAME = StringUtils.class.getName();
    private static final Logger logger = LogManager.getLogger(StringUtils.class);

    public StringUtils() {
        logger.info("StringUtils() - STARTING");
    }

    /**
     * Metodo responsavel pela reconstrucao de uma string a partir de um array de bytes recebido.
     * @param message array de bytes em hexadecimal
     * @param charset formato de string
     * @return Retorna a String reconstruida
     * @throws ArrayIndexOutOfBoundsException Lanca uma exception se a mensagem estiver vazia
     * @throws NullPointerException Lanca uma exception se o formato de String estiver vazio
     */
    public String recoverString(final byte[] message, final Charset charset) {
        if(message.length == 0) throw new ArrayIndexOutOfBoundsException("Array vazio");
        if(charset == null)     throw new NullPointerException("Charset esta null");
        final String recovered = new String(message, charset);
        logger.info("recoverString() - message = {}", toHexString(message));
        logger.info("recoverString() - recovered = {}", recovered);
        return recovered;
    }

    /**
     * Metodo responsavel pela transformacao de um array de bytes em uma string desse array em hexadecimal
     * @param message array de bytes em hexadecimal
     * @return Retorna um array de bytes em hexadecimal formatado em String
     */
    public String toHexString(final byte[] message) {
        final StringBuilder stringBuilder = new StringBuilder();
        for(int index = 0; message.length > index; index++) {
            stringBuilder.append(" ");
            stringBuilder.append(Integer.toHexString(message[index]).toUpperCase());
        }
        final String converted = stringBuilder.toString();
        logger.info("toHexString() - converted = {}", converted);
        return converted;
    }

}
