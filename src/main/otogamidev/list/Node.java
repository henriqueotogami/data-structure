package main.otogamidev.list;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Node extends Object {

    final String CLASS_NAME = "Node";

    private final Logger logger = LogManager.getLogger(Node.class);

    private Object element = null;
    private Node nextElement = null;

    public Node(final Object object) { this.element = object; }

    public Object getElement() { return element; }

    public void setElement(final Object element) { this.element = element; }

    public Node getNextElement() { return nextElement; }

    public void setNextElement(final Node nextObject) { this.nextElement = nextObject; }

    public String getClassName() { return this.CLASS_NAME; }

    @Override
    public String toString() { return "Node { nextElement = " + nextElement + ", element = " + element + " } "; }
}
