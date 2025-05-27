package main.otogamidev.exercises;

import main.otogamidev.queue.QueueStatic;
import main.otogamidev.utils.Utils;

/**
 * <br>Exercício de Fila com prioridade de um hospital.
 * <hr>
 * <br>Enunciado: Escreva um programa que simule a distribuição de senhas de atendimento a um grupo de pessoas.
 * <br>           Cada pessoa pode receber uma senha prioritária ou normal.
 * <br>
 * <br>Critérios:
 * <br>01. Existe apenas um atendente;
 * <br>02. Para 3 pessoas de senha prioritária atendidas, 1 pessoa de senha normal deve ser atendida;
 * <br>03. Se não houverem pessoas de senhas prioritárias, as pessoas de senhas normais devem ser atendidas.
 * @author henriquematheusalvespereira
 */
public class QueueHospital extends QueuePriority<QueuePriority.Patient>{

    private static final int MAX_PRIORITY               = 3;
    private static final int MAX_PEOPLE                 = 20;
    private static final int QUANTITY_PRIORITY_TYPES    = 2;
    private static final int QUEUE_TOP                  = 0;
    private static final long ONE_SECOND                = 1000L;
    private static final long ONE_MINUTE                = 60L;
    private static final long INITIAL_SERVICE_TIME      = 500L;

    public static void main(String[] args) {

        final QueueStatic<QueuePriority.Patient> queueGeneralLowPriority    = new QueueStatic<>();
        final QueueStatic<QueuePriority.Patient> queueGeneralHighPriority   = new QueueStatic<>();

        int countTotalPeopleMaxPriority = 0;
        int countPeopleByPriority       = 0;

        generatePublicQueue(queueGeneralLowPriority, queueGeneralHighPriority);

        countTotalPeopleMaxPriority = getTotalPeopleMaxPriority(queueGeneralHighPriority, countTotalPeopleMaxPriority);

        startCaringPeopleSystem(queueGeneralLowPriority, queueGeneralHighPriority, countPeopleByPriority, countTotalPeopleMaxPriority);
    }

    /**
     * Meotodo responsavel pelo sistema de atendimento de pacientes do Hospital.
     * @param queueGeneralLowPriority Fila de pessoas com baixa prioridade de atendimento
     * @param queueGeneralHighPriority Fila de pessoas com alta prioridade de atendimento
     * @param countPeopleByPriority Contador de pessoas com alta prioridade de atendimento
     * @param countTotalPeopleMaxPriority contador de pessoas com alta prioridade que foram atendidas
     */
    private static void startCaringPeopleSystem(QueueStatic<Patient> queueGeneralLowPriority, QueueStatic<Patient> queueGeneralHighPriority, int countPeopleByPriority, int countTotalPeopleMaxPriority) {
        System.out.println("Iniciando sistema de atencimento do Hospital");
        System.out.println("============================================\r\n");
        while(!queueGeneralLowPriority.isEmpty() || !queueGeneralHighPriority.isEmpty()) {
            try {
                if ((MAX_PRIORITY > countPeopleByPriority)  && (countTotalPeopleMaxPriority > 0)) {
                    caringPatients(queueGeneralHighPriority, Patient.PRIORITY_GREATER);
                    countPeopleByPriority++;
                    countTotalPeopleMaxPriority--;
                } else {
                    caringPatients(queueGeneralLowPriority, Patient.PRIORITY_NONE);
                    countPeopleByPriority = 0;
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            System.out.println("Restam pacientes sem atendimento - Prioridade Baixa: " + queueGeneralLowPriority.getSize() + " | Prioridade Alta: " + queueGeneralHighPriority.getSize());
            System.out.println("============================================\r\n");
        }
    }

    /**
     * Metodo responsavel pela contagem de pessoas com alta prioridade de atendimento
     * @param queueGeneralHighPriority lista de pessoas com alta prioridade de atendimento
     * @param countTotalPeopleMaxPriority contagem total do numero de pessoas com alta prioridade
     * @return Retorna o numero de pessoas com alta prioridade
     */
    private static int getTotalPeopleMaxPriority(QueueStatic<Patient> queueGeneralHighPriority, int countTotalPeopleMaxPriority) {
        for(int index = 0; queueGeneralHighPriority.getSize() > index; index++) {
            if(queueGeneralHighPriority.getElement(index).getPriority() == Patient.PRIORITY_GREATER) countTotalPeopleMaxPriority++;
        }
        return countTotalPeopleMaxPriority;
    }

    /**
     * Metodo responsavel pela geracao aleatoria de pessoas com niveis alto e baixo de prioridade de atendimento
     * @param queueGeneralLowPriority lista de pessoas com baixa prioridade de atendimento
     * @param queueGeneralHighPriority lista de pessoas com alta prioridade de atendimento
     */
    private static void generatePublicQueue(QueueStatic<Patient> queueGeneralLowPriority, QueueStatic<Patient> queueGeneralHighPriority) {
        int randomIndex;
        for(int indexL = 0, indexH = 0; (MAX_PEOPLE > indexL) || (MAX_PEOPLE > indexH); indexL++, indexH++) {
            randomIndex = Utils.getRandomIndex(QUANTITY_PRIORITY_TYPES);
            if(randomIndex == Patient.PRIORITY_NONE) queueGeneralLowPriority.enqueue(new Patient("Pessoa " + indexL, randomIndex));
            else if (randomIndex == Patient.PRIORITY_GREATER) queueGeneralHighPriority.enqueue(new Patient("Pessoa " + indexH, randomIndex));
        }
    }

    /**
     * Metodo responsavel pelo atendimento de pacientes do Hospital.
     * @param queueGeneralPublic lista de pacientes
     * @param typePriority valor do tipo de prioridade de atendimento
     * @throws InterruptedException Lanca uma exception se falhar o tempo de servico de atendimento
     */
    private static void caringPatients(QueueStatic<Patient> queueGeneralPublic, final int typePriority) throws InterruptedException {
        final Patient patient = queueGeneralPublic.getElement(QUEUE_TOP);
        if(patient.getPriority() == typePriority) {
            final String typePriorityName = (typePriority == Patient.PRIORITY_NONE) ? "Baixa" : "Alta";
            System.out.println("Paciente que sera atendido: " + patient.getName() + " | Prioridade: " + typePriorityName);
            final long serviceTime = INITIAL_SERVICE_TIME * ((long) queueGeneralPublic.getSize());
            final long serviceTimeSeconds = (serviceTime / ONE_SECOND) > 1 ? (serviceTime / ONE_SECOND) : 1L;
            final long serviceTimeMinutes = serviceTimeSeconds / ONE_MINUTE;
            final String realServiceTime = ((serviceTimeMinutes > 0) ? ("" + serviceTimeMinutes).concat(" minutos") : ("" + serviceTimeSeconds).concat(" segundos"));
            System.out.println("Tempo de atendimento: " + realServiceTime);
            Thread.sleep(serviceTime);
            queueGeneralPublic.remove(patient);
            System.out.println("Paciente atendido: " + patient.getName());
            System.out.println("Pacientes na fila: " + queueGeneralPublic.getSize() + "\r\n");;
        }
    }
}
