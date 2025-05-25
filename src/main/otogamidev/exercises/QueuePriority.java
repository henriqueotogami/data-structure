package main.otogamidev.exercises;

import main.otogamidev.queue.QueueStatic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QueuePriority<T> extends QueueStatic<T> {

    /** Nome da Classe QueuePriority */
    private static final String CLASS_NAME = "QueuePriority";
    private static final Logger logger = LogManager.getLogger(QueuePriority.class);

    @Override
    public void enqueue(final T element) {
        final int newElementHasPriority = 1;
        final Comparable<T> newElement = (Comparable<T>) element;
        int index = 0;
        for(; this.size > index; index++) {
            final int compared = newElement.compareTo(this.elements[index]);
            if(compared != newElementHasPriority) {
//                logger.info("Novo elemento tem maior prioridade = " + compared);
                break;
            }
        }
        this.append(index, element);
    }

    public static class Patient<T> implements Comparable {

        private String name;
        private int priority;

        public static final int PRIORITY_NONE       = 0;
        public static final int PRIORITY_GREATER    = 1;
        public static final int PRIORITY_MINOR      = -1;

        public Patient(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        public Patient() { }

        public String getName() { return name; }

        public void setName(final String name) { this.name = name; }

        public int getPriority() { return priority; }

        public void setPriority(final int priority) { this.priority = priority; }

        public int compareTo(final Patient otherPatient) {
//            if(this.priority ==  otherPatient.getPriority()) return PRIORITY_NONE;
//            return (this.priority >  otherPatient.getPriority()) ? PRIORITY_GREATER : PRIORITY_MINOR;
//            logger.info("CompareTo() - " + otherPatient.getName());
            return Integer.compare(this.priority, otherPatient.getPriority());
        }

        @Override
        public int compareTo(final Object object) {
            return this.compareTo((Patient) object);
        }

    }


    public static void main(String[] args) {
        final QueuePriority<Integer> queuePriority = new QueuePriority<>();
        queuePriority.enqueue(1);
        queuePriority.enqueue(18);
        queuePriority.enqueue(3);
        queuePriority.enqueue(23);
        queuePriority.enqueue(9);
        queuePriority.enqueue(5);
        queuePriority.enqueue(15);
        queuePriority.enqueue(2);
        queuePriority.enqueue(78);
        queuePriority.enqueue(0);
        logger.info(queuePriority.toString());
//        [0, 1, 2, 3, 5, 9, 15, 18, 23, 78]
    }

}
