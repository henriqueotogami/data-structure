package main.otogamidev.exercises;

import java.util.Random;

/**
 * <br>Enunciado
 * <br>Utilize a classe Fila para simular um sistema de senhas de um Pronto Socorro.
 * <br>Critérios:
 * <br>01. Existem três níveis de prioridade: Vermelho, Amarelo e Verde.
 * <br>02. Iniciar a Fila com 6 pessoas para atendimento;
 * <br>03. Pessoas com prioridade vermelha devem ser atendidas primeiro;
 * <br>04. O tempo de cada consulta dura cerca de 5 segundos;
 * <br>05. A cada 4 segundos, uma nova pessoa chega no pronto socorro com prioridade aleatória.
 */
public class QueueEmergencyRoom {

    public static class CaringEmergencyRoom implements Runnable {

        private final QueuePriority<QueuePriority.Patient> queuePriority;

        public static final int NUMBER_INITIAL_PEOPLE_CARING = 6;

        public CaringEmergencyRoom(final QueuePriority<QueuePriority.Patient> queuePriority) {
            super();
            this.queuePriority = queuePriority;
        }

        @Override
        public void run() {

            while(!queuePriority.isEmpty()) {
                try {
                    final QueuePriority.Patient dequeue = queuePriority.dequeue();
                    System.out.println(dequeue.getName() + " atendida com prioridade " + dequeue.getPriority());
                    Thread.sleep(5000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
            System.out.println("Atendimento concluído");
        }
    }

    public static class NewPatientsEmergencyRoom implements Runnable {

        private final QueuePriority<QueuePriority.Patient> queuePriority;
        private final Random randomPriority = new Random();
        private int cont = 7;

        public NewPatientsEmergencyRoom(QueuePriority<QueuePriority.Patient> queuePriority) {
            this.queuePriority = queuePriority;
        }

        @Override
        public void run() {
            for(int index = 0; 8 > index; index++) {
                try {
                    Thread.sleep(8000);
                    final QueuePriority.Patient patient = new QueuePriority.Patient(("Pessoa " + cont), randomPriority.nextInt(3));
                    queuePriority.enqueue(patient);
                    cont++;
                    System.out.println(patient.getName() + " entrou na fila com prioridade " + patient.getPriority());
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        // Consideração:
        // Verde        = Patient.PRIORITY_MINOR
        // Amarelo      = Patient.PRIORITY_EQUALS
        // Vermelhor    = Patient.PRIORITY_GREATER
        final QueuePriority<QueuePriority.Patient> queuePriority = new QueuePriority<>();
//        for(int index = 0; CaringEmergencyRoom.NUMBER_INITIAL_PEOPLE_CARING > queuePriority.getSize(); index++) queuePriority.enqueue(new QueuePriority.Patient(("Pessoa " + index+1), QueuePriority.Patient.PRIORITY_EQUALS));
//
//        try {
//            final CaringEmergencyRoom caringEmergencyRoom           = new CaringEmergencyRoom(queuePriority);
//            final NewPatientsEmergencyRoom newPatientsEmergencyRoom = new NewPatientsEmergencyRoom(queuePriority);
//
//            final Thread threadCaring       = new Thread(caringEmergencyRoom);
//            final Thread threadNewPatients  = new Thread(newPatientsEmergencyRoom);
//
//            threadCaring.start();
//            threadNewPatients.start();
//
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }

        queuePriority.enqueue(new QueuePriority.Patient("Vermelho", 2));
        queuePriority.enqueue(new QueuePriority.Patient("Verde", 0));
        queuePriority.enqueue(new QueuePriority.Patient("Amarelo", 1));

        while(!queuePriority.isEmpty()) {
            System.out.println(queuePriority.dequeue().getName());
        }

    }
}
