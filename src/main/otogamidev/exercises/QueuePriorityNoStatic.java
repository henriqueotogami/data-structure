package main.otogamidev.exercises;

import main.otogamidev.queue.QueueStatic;

public class QueuePriorityNoStatic<T> extends QueueStatic<T> {

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

    public static class Patient {

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
    }
}
