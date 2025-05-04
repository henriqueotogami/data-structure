package main.otogamidev.stack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Stack<T> extends StaticStructure<T> {

    /** Nome da Classe Stack */
    private static final String CLASS_NAME = "Stack";
    private static final Logger logger = LogManager.getLogger(Stack.class);

    private T[] elements;
    private int size;

    public Stack(final int capable) {
        this.elements = (T[]) new Object[capable];
        this.size = 0;
    }

    public Stack() { this(10); }

}
