package main.otogamidev.list;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LinkedList {

    final String CLASS_NAME = "LinkedList";

    private final Logger logger = LogManager.getLogger(LinkedList.class);

    private Node head = null;
    private int size = 0;
    private Node pointer = null;

    public LinkedList() {
        this.head = null;
        this.size = 0;
        logger.info("LinkedList() - head = null | size = 0");
    }

    public LinkedList(final Node element) {
        this.head = element;
        this.size++;
        logger.info("LinkedList() - head = {} | size = {}", this.head, this.size);
    }

    public void append(final Object element) {
        this.head = new Node(element);
        this.size++;
        logger.info("append() - head = {} | size = {}", this.head, this.size);
    }

    public void append(final Node element) {
        this.head = element;
        this.size++;
        logger.info("append() - head = {} | size = {}", this.head, this.size);
    }

    public int getSize() { return this.size; }

    @Override
    public String toString() { return "LinkedList { head = " + this.head + " } "; }

    public String getClassName() { return this.CLASS_NAME; }
}
