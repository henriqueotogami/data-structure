package main.otogamidev.list;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LinkedList {

    final String CLASS_NAME = "LinkedList";

    private final Logger logger = LogManager.getLogger(LinkedList.class);

    private Node head = null;
    private Node next = null;
    private int size = 0;

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

    public void append(final Node element) {
        final Node node = element;
        if(this.size == 0) {
            this.head = node;
        } else {
            this.next.setNextElement(node);
        }
        this.next = node;
        this.size++;
        logger.info("append() - head = {} ", this.head);
        logger.info("append() - size = {} | next = {}\n", this.size, this.next);
    }

    public void append(final Object element) { this.append(new Node(element)); }

    public int getSize() { return this.size; }

    @Override
    public String toString() { return "LinkedList { head = " + this.head + " } "; }

    public String getClassName() { return this.CLASS_NAME; }
}
