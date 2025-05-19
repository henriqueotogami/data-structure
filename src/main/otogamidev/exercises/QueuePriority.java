package main.otogamidev.exercises;

import main.otogamidev.queue.QueueStatic;

public class QueuePriority<T> extends QueueStatic<T> {

    public void addElement(final T element) {

    }

    public static class Patient {

        private String name;
        private int priority;

        public Patient(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        public Patient() { }

        public String getName() { return name; }

        public void setName(final String name) { this.name = name; }

        public int getPriority() { return priority; }

        public void setPriority(final int priority) { this.priority = priority; }
    }


    public static void main(String[] args) {
        final QueuePriority<Integer> queuePriority = new QueuePriority<>();
        queuePriority.addElement(1);
        queuePriority.addElement(3);
        queuePriority.addElement(2);
    }

}
