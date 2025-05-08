package main.otogamidev.stack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Stack<T> extends StaticStructure<T> {

    /** Nome da Classe Stack */
    private static final String CLASS_NAME = "Stack";
    private static final Logger logger = LogManager.getLogger(Stack.class);

    public Stack(final int capable) {
        super.elements = (T[]) new Object[capable];
        super.size = 0;
    }

    public Stack() { this(10); }

    public void push(final T element) {
        super.append(element);
    }

    public T pull() {

        if(super.isEmpty()) return null;

        final T element = super.elements[--super.size];
        super.elements[super.size] = null;
        return element;
//        A solucao abaixo nao remove o elemento do vetor, ocasionando que o ultimo elemtno permaneca na posicao
//        que deveria ter sido removido
//        return super.elements[--super.size];
    }
}
 