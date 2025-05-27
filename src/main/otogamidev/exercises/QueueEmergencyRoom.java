package main.otogamidev.exercises;

import main.otogamidev.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
 * @author henriquematheusalvespereira
 */
public class QueueEmergencyRoom {

    /** Nome da Classe QueueEmergencyRoom */
    private static final String CLASS_NAME = "QueueEmergencyRoom";
    private static final Logger logger = LogManager.getLogger(QueueEmergencyRoom.class);

    /**
     * Classe responsavel pelo atendimento do Pronto Socorro.
     * @author henriquematheusalvespereira
     */
    public static class CaringEmergencyRoom implements Runnable {

        private final QueuePriority<QueuePriority.Patient> queuePriority;
        public static final int NUMBER_INITIAL_PEOPLE_CARING    = 6;
        public final int CARING_TIME                            = 5000;
        /* Variavel de controle para diminuir riscos de concorrência de threads*/
        public static boolean hasNewPatientsArriving            = false;

        /**
         * Construtor do atendimento do Pronto Socorro.
         * @param queuePriority Instancia da fila de atendimento do Pronto Socorro.
         */
        public CaringEmergencyRoom(final QueuePriority<QueuePriority.Patient> queuePriority) {
            super();
            this.queuePriority = queuePriority;
        }

        @Override
        public void run() {
            while(!queuePriority.isEmpty() || hasNewPatientsArriving) {
                try {
                    final QueuePriority.Patient dequeue = queuePriority.dequeue();
                    logger.info("===================================================");
                    logger.info("{} atendida com prioridade {}", dequeue.getName(), getPriorityName(dequeue.getPriority()));
                    logger.info("===================================================");
                    Thread.sleep(CARING_TIME);
                } catch (InterruptedException interruptedException) {
                    logger.info("Falha no atendimento dos pacientes");
                    interruptedException.printStackTrace();
                }
            }
            logger.info("Atendimento concluído");
        }

        /**
         * Metodo responsavel pela obtenção do nome do valor tipo de prioridade de atendimento informada.
         * @param priority valor do tipo de prioridade de atendimento.
         * @return Retorna o nome do tipo de prioridade de atencimento.
         */
        private static String getPriorityName(final int priority) {
            return switch (priority) {
                case -1     -> "Verde";
                case 0      -> "Amarelo";
                case 1      -> "Vermelho";
                default     -> "Desconhecida";
            };
        }
    }

    /**
     * Classe responsavel pela recepcao de novos pacientes do Pronto Socorro.
     * @author henriquematheusalvespereira
     */
    public static class NewPatientsEmergencyRoom implements Runnable {

        private final QueuePriority<QueuePriority.Patient> queuePriority;
        private final Random randomPriority     = new Random();
        private final int NEW_PATIENTS_ARRIVE   = 4000;
        private final int MAX_NEW_PATIENTS      = 8;

        /**
         * Construtor da classe da recepcao de novos pacientes do Pronto Socorro.
         * @param queuePriority Instancia da fila de atendimento do Pronto Socorro.
         */
        public NewPatientsEmergencyRoom(QueuePriority<QueuePriority.Patient> queuePriority) {
            this.queuePriority = queuePriority;
        }

        @Override
        public void run() {
            for(int index = 0, newPatient = 0; MAX_NEW_PATIENTS > index; index++, newPatient++) {
                CaringEmergencyRoom.hasNewPatientsArriving = true;
                try {
                    Thread.sleep(NEW_PATIENTS_ARRIVE);
                    final QueuePriority.Patient patient = new QueuePriority.Patient(("Pessoa " + newPatient), randomPriority.nextInt(3));
                    queuePriority.enqueue(patient);
                    logger.info("{} entrou na fila com prioridade {}", patient.getName(), CaringEmergencyRoom.getPriorityName(patient.getPriority()));
                } catch (InterruptedException interruptedException) {
                    logger.info("Falha no enfileiramento de novos pacientes.");
                    interruptedException.printStackTrace();
                }
            }
            logger.info("===================================================");
            CaringEmergencyRoom.hasNewPatientsArriving = false;
        }
    }

    public static void main(String[] args) {

        // Consideração:
        // Verde        = Patient.PRIORITY_MINOR
        // Amarelo      = Patient.PRIORITY_EQUALS
        // Vermelhor    = Patient.PRIORITY_GREATER
        final QueuePriority<QueuePriority.Patient> queuePriority = new QueuePriority<>();
        for(int index = 0; CaringEmergencyRoom.NUMBER_INITIAL_PEOPLE_CARING > queuePriority.getSize(); index++) {
            final int randomPriority = (Utils.getRandomIndex(2) - 1);
            queuePriority.enqueue(new QueuePriority.Patient(("Pessoa " + (index + 1)), randomPriority));
        }

        try {
            final CaringEmergencyRoom caringEmergencyRoom           = new CaringEmergencyRoom(queuePriority);
            final NewPatientsEmergencyRoom newPatientsEmergencyRoom = new NewPatientsEmergencyRoom(queuePriority);

            final Thread threadCaring       = new Thread(caringEmergencyRoom);
            final Thread threadNewPatients  = new Thread(newPatientsEmergencyRoom);

            threadCaring.start();
            threadNewPatients.start();
        } catch (Exception exception) {
            logger.info("Falha no sistema do pronto socorro.");
            exception.printStackTrace();
        }
    }
}
