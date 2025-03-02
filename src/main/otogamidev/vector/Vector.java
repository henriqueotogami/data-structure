package main.otogamidev.vector;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Classe responsável pela implementação de Vetor, inspirada no curso da Loiane Groner no Youtube.
 *
 * @author henriquematheusalvespereira
 */
public class Vector {

    /** Nome da Classe Vector */
    private static final String CLASS_NAME = "Vector";
    private static final Logger logger = LogManager.getLogger(Vector.class);

    private String[] elements;
    private int size = 0;

    /**
     * Metodo responsável pela construção da classe Vector.
     * @param size tamanho do Vetor
     */
    public Vector(final int size) {
        this.elements = new String[size];
        this.size = size;
    }

    /**
     * Metodo responsável pelo tamanho do Vetor.
     * @return Retorna o tamanho do Vetor.
     */
    public int getSize() { return this.size; }

    /**
     * Metodo responsável pelos elementos armazenados nesse Vetor.
     * @return Retorna os elementos desse Vetor.
     */
    public String[] getElements() { return this.elements; }


}
