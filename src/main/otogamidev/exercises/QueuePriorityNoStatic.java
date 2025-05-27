package main.otogamidev.exercises;

import main.otogamidev.queue.QueueStatic;

/**
 * Classe responsavel pela Lista de Prioridade Nao Estatica
 * @param <T> tipo generico nao especificado
 * @author henriquematheusalvespereira
 */
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

    /**
     * Classe responsavel pelo Paciente
     * @param <T> tipo generico nao especificado
     */
    public static class Patient {

        private String name;
        private int priority;

        private static final int PRIORITY_EQUALS    = 0;
        private static final int PRIORITY_GREATER   = 1;
        private static final int PRIORITY_MINOR     = -1;

        /**
         * Construtor do Paciente
         * @param name nome do paciente
         * @param priority prioridade do atendimento do paciente
         */
        public Patient(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        /**
         * Construtor do paciente
         */
        public Patient() {
            this("Paciente desconhecido", 0);
        }

        /**
         * Metodo responsavel pelo nome do paciente
         * @return Retorna o nome do paciente
         */
        public String getName() { return name; }

        /**
         * Metodo responsavel pelo tipo de prioridade de atendimento do paciente
         * @return Retorna o tipo de prioridade de atendimento do paciente
         */
        public int getPriority() { return priority; }

        /**
         * Metodo responsavel pela comparacao de prioridade de atendimento entre dois pacientes
         * @param patient outro paciente
         * @return Retorna os seguintes valores:
         * <br> Valor 0: indicando prioridades de atendimento iguais
         * <br> Valor 1: indicando que o atual paciente tem prioridade de atendimento sobre o paciente informado
         * <br> Valor -1: indicando que o atual paciente tem menos prioridade de atendimento em relacao ao paciente informado
         */
        public int compareTo(final Patient patient) {
            final int patientPriority = patient.getPriority();

            if(this.priority == patientPriority) return PRIORITY_EQUALS;

            return (this.priority > patientPriority) ? PRIORITY_GREATER : PRIORITY_MINOR;
        }
    }
}
