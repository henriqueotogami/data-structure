package test.otogamidev;

import main.otogamidev.Queue;
import org.junit.jupiter.api.*;

/**
 * Classe responsavel pelos testes da classe Queue (Fila), dos estudos de estruturas de dados.
 *
 * @author henriquematheusalvespereira
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class QueueTest {

    final String CLASS_NAME = this.getClass().getName();

    /**
     * 15 valores da sequência de Fibonacci
     */
    final int[] fibonacciFirstFifteen = new int[] { 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610 };

    /**
     * 15 valores de distorcao harmônica.
     */
    final double[] sequenceHarmonica = {
            1.000000d, 1.500000d, 1.833333d, 2.083333d, 2.283333d,
            2.450000d, 2.592857d, 2.717857d, 2.828968d, 2.928968d,
            3.019877d, 3.103211d, 3.180134d, 3.251562d, 3.318229d
    };

    /**
     * 15 Valores de Meia-vida de uma substância radioativa.
     */
    final float[] halfLifeRadioactiveSubstance = {
            100.0f, 87.06f, 75.79f, 65.98f, 57.43f,
            50.0f, 43.53f, 37.89f, 32.99f, 28.72f,
            25.0f, 21.76f, 18.95f, 16.49f, 14.36f
    };

    /**
     * 15 valores de Distância percorrida por um objeto em movimento uniformemente acelerado.
     */
    final long[] distanceUniformlyAccelerated = {
            0L, 11L, 24L, 39L, 56L, 75L, 96L, 119L,
            144L, 171L, 200L, 231L, 264L, 299L, 336L
    };

    /**
     * 15 valores de Força Gravitacional.
     */
    final short[] gravitationForce = { 98, 108, 118, 127, 137, 147, 157, 167, 176, 186, 196, 206, 216, 225, 235 };

    /**
     * 15 valores de temperaturas decrescendo em passos de −5C
     */
    final byte[] temperatureDecreasing = { 20, 15, 10, 5, 0, -5, -10, -15, -20, -25, -30, -35, -40, -45, -50};

    /**
     * 15 caracteres das unidades de medida do sistema internacional de unidades
     */
    final char[] physicalUnits = {'m', 's', 'k', 'A', 'K', 'm', 'c', 'N', 'P', 'J', 'W', 'C', 'V', 'Ω', 'H'};

    /**
     * 15 valores booleanos aleatórios
     */
    final boolean[] randomBoolean = { true,false,true,true,false,false,true,true,false,true,false,false,true,true,false };

    /**
     * 15 valores de grandezas físicas do sistema internacional de unidades
     */
    final String[] internationalSystemUnits = {
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

    private final Queue queue = new Queue();

    private int getRandomIndexQueueSize() {
        final int size = queue.getSize();
        final int randomIndex = (int) (Math.random() * size);
        return randomIndex;
    }

    /**
     * Teste 1 - Criação de Fila.
     * Cenário = Verificar se a fila é criada corretamente e está vazia.
     */
    @Test
    @Order(1)
    void createQueueTest() {
        System.out.println(CLASS_NAME.concat(" - createQueueTest(): BEGIN"));
        final Queue queue1 = new Queue();
        final boolean isEmpty = queue1.isEmpty();
        System.out.println(CLASS_NAME.concat(" - createQueueTest(): isEmtpy = " + isEmpty));
        System.out.println(CLASS_NAME.concat(" - createQueueTest(): END"));
        Assertions.assertEquals(true, isEmpty);
    }

    /**
     * Teste 2 - Testar a operação de enfileiramento.
     * Cenário: Adicionar elementos à fila.
     */
    @Test
    @Order(2)
    void addElementTest() {
        System.out.println(CLASS_NAME.concat(" - addElementTest(): BEGIN"));

        int size = queue.getSize();
        System.out.println(CLASS_NAME.concat(" - addElementTest(): Initialing - Queue size = " + size));

        queue.addElement(fibonacciFirstFifteen);
        queue.addElement(sequenceHarmonica);
        queue.addElement(halfLifeRadioactiveSubstance);
        queue.addElement(distanceUniformlyAccelerated);
        queue.addElement(gravitationForce);
        queue.addElement(temperatureDecreasing);
        queue.addElement(physicalUnits);
        queue.addElement(randomBoolean);
        queue.addElement(internationalSystemUnits);

        size = queue.getSize();
        System.out.println(CLASS_NAME.concat(" - addElementTest(): After adding elements - Queue size = " + size));
        System.out.println(CLASS_NAME.concat(" - addElementTest(): END"));
        Assertions.assertEquals(9, size);
    }

    /**
     * Teste 3 - Testar a operação de desenfileiramento.
     * Cenário: Remover elementos da fila.
     */
    @Test
    @Order(3)
    void removeElementTest() {
        System.out.println(CLASS_NAME.concat(" - removeElementTest(): BEGIN"));

//      Parece que o Junit reinicia a instancia depois de terminar os metodos.
//      Por isso, chamei aqui o metodo addElementTest.
        this.addElementTest();

        final int randomIndex = getRandomIndexQueueSize();
        System.out.println(CLASS_NAME.concat(" - removeElementTest(): randomIndex = " + randomIndex));
        final Object element = queue.getElement(randomIndex);

        System.out.println(CLASS_NAME.concat(" - removeElementTest(): element = " + element));
        final boolean wasRemoved = queue.removeElement(randomIndex);

        System.out.println(CLASS_NAME.concat(" - removeElementTest(): wasRemoved = " + wasRemoved));
        final int indexRemoved = queue.searchElement(element);

        System.out.println(CLASS_NAME.concat(" - removeElementTest(): END"));
        Assertions.assertEquals(Queue.NOT_FOUND, indexRemoved);
    }

    /**
     * Teste 4 - Consultar o elemento
     * Cenário: Consultar o elemento da fila sem remover.
     */
    @Test
    @Order(4)
    void searchElementTest() {
        System.out.println(CLASS_NAME.concat(" - searchElementTest(): BEGIN"));
//      Parece que o Junit reinicia a instancia depois de terminar os metodos.
//      Por isso, chamei aqui o metodo addElementTest.
        this.addElementTest();
        final int randomIndex = getRandomIndexQueueSize();
        final Object element = queue.getElement(randomIndex);
        final boolean isFoundElement = ( queue.searchElement(element) != Queue.NOT_FOUND );
        System.out.println(CLASS_NAME.concat(" - searchElementTest(): isFoundElement = " + isFoundElement));
        System.out.println(CLASS_NAME.concat(" - searchElementTest(): END"));
        Assertions.assertEquals(true, isFoundElement);
    }

    /**
     * Teste 5 - Testar o estado da fila.
     * Cenário: Métodos auxiliares como isEmpty() e tamanho da fila.
     */
    @Test
    @Order(5)
    void isEmptyTest() {
        System.out.println(CLASS_NAME.concat(" - isEmptyTest(): BEGIN"));

        final boolean isZeroInitialQueueSize = queue.isEmpty();
        System.out.println(CLASS_NAME.concat(" - isEmptyTest(): isZeroInitialQueueSize = " + isZeroInitialQueueSize));

        this.addElementTest();
        final boolean isFullQueueSize = ( queue.isEmpty() == false );
        System.out.println(CLASS_NAME.concat(" - isEmptyTest(): isFullQueueSize = " + isFullQueueSize));

        queue.eraseAllElements();
        final boolean isErasedQueue = queue.isEmpty();
        System.out.println(CLASS_NAME.concat(" - isEmptyTest(): isErasedQueue = " + isErasedQueue));

        System.out.println(CLASS_NAME.concat(" - isEmptyTest(): END"));
        Assertions.assertEquals(true, (isZeroInitialQueueSize && isFullQueueSize && isErasedQueue));
    }

    /**
     * Teste 6 - Testar se a fila contem o elemento.
     * Cenário: Verifica se um elemento especifico está presente na fila.
     */
    @Test
    @Order(6)
    void containsTest() {
        System.out.println(CLASS_NAME.concat(" - containsTest(): BEGIN"));
        this.addElementTest();
        final int randomIndex = getRandomIndexQueueSize();
        final Object randomElement = queue.getElement(randomIndex);
        System.out.println(CLASS_NAME.concat(" - containsTest(): randomElement.getType = " + queue.getObjectType(randomElement)));
        final boolean isFoundElement = queue.contains(randomElement);
        System.out.println(CLASS_NAME.concat(" - containsTest(): isFoundElement = " + isFoundElement));
        System.out.println(CLASS_NAME.concat(" - containsTest(): END"));
        Assertions.assertEquals(true, isFoundElement);
    }

}