package main.otogamidev.exercises;

import main.otogamidev.queue.QueueStatic;

public class QueuePriority<T> extends QueueStatic<T> {

    public void addElement(final T element) {
        final Comparable<T> key = (Comparable<T>) element;
        int index = 0;
        for(index = 0;this.size > index; index++) {
            if(Patient.PRIORITY_EQUALS > key.compareTo(this.elements[index])) {
                break;
            }
        }

        this.append(index, element);
    }

    public static class Patient implements Comparable {

        private String name;
        private int priority;

        private static final int PRIORITY_EQUALS    = 0;
        private static final int PRIORITY_GREATER   = 1;
        private static final int PRIORITY_MINOR     = -1;

        public Patient(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        public Patient() { }

        public String getName() { return name; }

        public void setName(final String name) { this.name = name; }

        public int getPriority() { return priority; }

        public void setPriority(final int priority) { this.priority = priority; }

        public int compareTo(final Patient patient) {
            final int patientPriority = patient.getPriority();

            if(this.priority == patientPriority) return PRIORITY_EQUALS;

            return (this.priority > patientPriority) ? PRIORITY_GREATER : PRIORITY_MINOR;
        }

        @Override
        public int compareTo(final Object object) {
            return this.compareTo((Patient) object);
        }
    }


    public static void main(String[] args) {
        final QueuePriority<Integer> queuePriority = new QueuePriority<>();
        queuePriority.addElement(1);
        queuePriority.addElement(18);
        queuePriority.addElement(3);
        queuePriority.addElement(23);
        queuePriority.addElement(9);
        queuePriority.addElement(5);
        queuePriority.addElement(15);
        queuePriority.addElement(2);
        queuePriority.addElement(78);
        queuePriority.addElement(0);
        System.out.println(queuePriority.toString());
//        [0, 1, 2, 3, 5, 9, 15, 18, 23, 78]
    }

}
