package main.otogamidev.stack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SecondStack<T> extends StaticStructure<T> {

    /** Nome da Classe SecondStack */
    private static final String CLASS_NAME = "SecondStack";
    private static final Logger logger = LogManager.getLogger(SecondStack.class);


    public SecondStack(final int capable) {
        super(capable);
    }

    public SecondStack() {
        super();
    }

    @Override
    protected void append(final T element) throws IllegalArgumentException {
        super.append(element);
    }

    @Override
    protected void append(final int position, final T element) throws IllegalArgumentException {
        super.append(position, element);
    }


}