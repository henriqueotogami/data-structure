package main.otogamidev.queue.utils;

/**
 * Classe responsavel pela declaração das variáveis de tipos primitivos e de objetos.
 *
 * @author henriquematheusalvespereira
 */
public class DefaultValues {

// Tipos primitivos - BEGIN

    /** Exemplo de primitivo inteiro: numero 42*/
    public static final int     PRIMITIVE_INTEGER   = 42;

    /** Exemplo de primitivo double: numero 3.14159d */
    public static final double  PRIMITIVE_DOUBLE    = 3.14159d;

    /** Exemplo de primitivo float: numero 2.718f*/
    public static final float   PRIMITIVE_FLOAT     = 2.718f;

    /** Exemplo de primitivo long: numero 123456789L*/
    public static final long    PRIMITIVE_LONG      = 123456789L;

    /** Exemplo de primitivo short: numero 120*/
    public static final short   PRIMITIVE_SHORT     = 120;

    /** Exemplo de primitivo byte: numero 100*/
    public static final byte    PRIMITIVE_BYTE      = 100;

    /** Exemplo de primitivo char: letra A*/
    public static final char    PRIMITIVE_CHAR      = 'A';

    /** Exemplo de primitivo boolean: false*/
    public static final boolean PRIMITIVE_BOOLEAN   = false;

// Tipos primitivos - END

// =====================================================================================================================

// Tipos de objetos - BEGIN

    /** Exemplo de objeto Inteiro: valor máximo 2147483647 */
    public static final Integer     OBJECT_INTEGER   = Integer.MAX_VALUE;   // Qualquer número inteiro.

    /** Exemplo de objeto Double: valor máximo 1.7976931348623157E308*/
    public static final Double      OBJECT_DOUBLE    = Double.MAX_VALUE;    // Número de ponto flutuante com dupla precisão.

    /** Exemplo de objeto Float: valor máximo 3.4028235E38f*/
    public static final Float       OBJECT_FLOAT     = Float.MAX_VALUE;     // Número de ponto flutuante com precisão simples.

    /** Exemplo de objeto Long: valor máximo 9223372036854775807L*/
    public static final Long        OBJECT_LONG      = Long.MAX_VALUE;      // Número inteiro longo.

    /** Exemplo de objeto Short: valor máximo 32767*/
    public static final Short       OBJECT_SHORT     = Short.MAX_VALUE;     // Valores dentro do intervalo de -32.768 a 32.767.

    /** Exemplo de objeto Byte: valor máximo 127*/
    public static final Byte        OBJECT_BYTE      = Byte.MAX_VALUE;      // Valores entre -128 e 127.

    /** Exemplo de objeto Character: valor máximo '\uFFFF'*/
    public static final Character   OBJECT_CHAR      = Character.MAX_VALUE; // Qualquer caractere Unicode.

    /** Exemplo de objeto Boolean: FALSE*/
    public static final Boolean     OBJECT_BOOLEAN   = Boolean.FALSE;       // Pode ser apenas `true` ou `false`.

    /** Exemplo de objeto String: valor MAXXXXX*/
    public static final String      OBJECT_STRING    = "MAXXXXX";

// Tipos de objetos - END

// =====================================================================================================================

// Array de tipos primitivos - BEGIN

    /**
     * 15 valores da sequência de Fibonacci
     */
    public static final int[] PRIMITIVE_ARRAY_INTEGER = new int[] { 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610 };

    /**
     * 15 valores de distorcao harmônica.
     */
    public static final double[] PRIMITIVE_ARRAY_DOUBLE = {
            1.000000d, 1.500000d, 1.833333d, 2.083333d, 2.283333d,
            2.450000d, 2.592857d, 2.717857d, 2.828968d, 2.928968d,
            3.019877d, 3.103211d, 3.180134d, 3.251562d, 3.318229d
    };

    /**
     * 15 Valores de Meia-vida de uma substância radioativa.
     */
    public static final float[] PRIMITIVE_ARRAY_FLOAT = {
            100.0f, 87.06f, 75.79f, 65.98f, 57.43f,
            50.0f, 43.53f, 37.89f, 32.99f, 28.72f,
            25.0f, 21.76f, 18.95f, 16.49f, 14.36f
    };

    /**
     * 15 valores de Distância percorrida por um objeto em movimento uniformemente acelerado.
     */
    public static final long[] PRIMITIVE_ARRAY_LONG = {
            0L, 11L, 24L, 39L, 56L, 75L, 96L, 119L,
            144L, 171L, 200L, 231L, 264L, 299L, 336L
    };

    /**
     * 15 valores de Força Gravitacional.
     */
    public static final short[] PRIMITIVE_ARRAY_SHORT = { 98, 108, 118, 127, 137, 147, 157, 167, 176, 186, 196, 206, 216, 225, 235 };

    /**
     * 15 valores de temperaturas decrescendo em passos de −5C
     */
    public static final byte[] PRIMITIVE_ARRAY_BYTE = { 20, 15, 10, 5, 0, -5, -10, -15, -20, -25, -30, -35, -40, -45, -50};

    /**
     * 15 caracteres das unidades de medida do sistema internacional de unidades
     */
    public static final char[] PRIMITIVE_ARRAY_CHAR = {'m', 's', 'k', 'A', 'K', 'm', 'c', 'N', 'P', 'J', 'W', 'C', 'V', 'Ω', 'H'};

    /**
     * 15 valores booleanos aleatórios
     */
    public static final boolean[] PRIMITIVE_ARRAY_BOOLEAN = { true, false, true, true, false, false, true, true, false, true, false, false, true, true, false };

// Array de tipos primitivos - END

// =====================================================================================================================

// Array de tipos de objetos - BEGIN

    /** Exemplo de Array de Objetos: Array de Inteiros */
    public static final Integer[]     OBJECT_ARRAY_INTEGER   = new Integer[] { Integer.MIN_VALUE, Integer.MAX_VALUE };

    /** Exemplo de Array de Objetos: Array de Double */
    public static final Double[]      OBJECT_ARRAY_DOUBLE    = new Double[] { Double.MIN_VALUE, Double.MAX_VALUE };

    /** Exemplo de Array de Objetos: Array de Float */
    public static final Float[]       OBJECT_ARRAY_FLOAT     = new Float[] { Float.MIN_VALUE, Float.MAX_VALUE };

    /** Exemplo de Array de Objetos: Array de Long */
    public static final Long[]        OBJECT_ARRAY_LONG      = new Long[] { Long.MIN_VALUE, Long.MAX_VALUE };

    /** Exemplo de Array de Objetos: Array de Short */
    public static final Short[]       OBJECT_ARRAY_SHORT     = new Short[] { Short.MIN_VALUE, Short.MAX_VALUE };

    /** Exemplo de Array de Objetos: Array de Byte */
    public static final Byte[]        OBJECT_ARRAY_BYTE      = new Byte[] { Byte.MIN_VALUE, Byte.MAX_VALUE };

    /** Exemplo de Array de Objetos: Array de Character */
    public static final Character[]   OBJECT_ARRAY_CHAR      = new Character[] { 'B', 'C'};

    /** Exemplo de Array de Objetos: Array de Boolean */
    public static final Boolean[]     OBJECT_ARRAY_BOOLEAN   = new Boolean[] { Boolean.FALSE, Boolean.TRUE };

    /** 15 valores de grandezas físicas do sistema internacional de unidades */
    public static final String[] OBJECT_ARRAY_STRING = {
            "Newton (N)     - Unidade de força",
            "Joule (J)      - Unidade de energia",
            "Watt (W)       - Unidade de potência",
            "Coulomb (C)    - Unidade de carga elétrica",
            "Volt (V)       - Unidade de potencial elétrico",
            "Ohm (Ω)        - Unidade de resistência elétrica",
            "Tesla (T)      - Unidade de indução magnética",
            "Hertz (Hz)     - Unidade de frequência",
            "Pascal (Pa)    - Unidade de pressão",
            "Ampere (A)     - Unidade de corrente elétrica",
            "Kelvin (K)     - Unidade de temperatura termodinâmica",
            "Candela (cd)   - Unidade de intensidade luminosa",
            "Lumen (lm)     - Unidade de fluxo luminoso",
            "Lux (lx)       - Unidade de iluminamento",
            "Gray (Gy)      - Unidade de dose absorvida de radiação"
    };

// Array de tipos de objetos - END


    /**
     * Valores padronizados para os testes unitários.
     */
    public DefaultValues() {
    }
}
