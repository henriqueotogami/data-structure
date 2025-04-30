package main.otogamidev.exercises;

import main.otogamidev.vector.Vector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class ListContacts {

    /** Nome da Classe Vector */
    private static final String CLASS_NAME = "ListContacts";
    private static final Logger logger = LogManager.getLogger(ListContacts.class);

    private static final Scanner scanner = new Scanner(System.in);
    private static final Vector<Contact> listContacts = new Vector<Contact>(20);
    private static final int DEFAULT_VALUE = -1;

    public static class Contact {

        String name = "";
        String phone = "";
        String email = "";

        public Contact(final String name, final String phone, final String email){
            this.name   = name;
            this.phone  = phone;
            this.email  = email;
            logger.info("Contact was created | name = {} | phone = {} | email = {}", name, phone, email);
        }

        public Contact() {
            new Contact("Henrique Otogami", "119123456789", "otogami.dev@contato.com.br");
        }

        public String getName() { return this.name; }

        public void setName(final String name) { this.name = name; }

        public String getPhone() { return this.phone; }

        public void setPhone(final String phone) { this.phone = phone; }

        public String getEmail() { return this.email; }

        public void setEmail(final String email) { this.email = email; }
    }

    private static void createContacts(final int quantity, final Vector<Contact> list) {
        logger.info("createContacts() - BEGIN");
        String contactName = "";
        String contactPhone = "";
        String contactEmail = "";

        for(int index = 1; quantity > index; index++) {
            contactName = "contact number[" + index + "]";
            contactPhone = "1191234500" + index;
            contactEmail = "contact.n" + index + "@contato.com.br";
            final Contact contact = new Contact(contactName, contactPhone, contactEmail);
            list.append(contact);
        }
        logger.info("createContacts() - END");
    }

    private static int getMenu() {
        boolean isValidInput = false;
        int option = DEFAULT_VALUE;

        while(!isValidInput) {
            printMenu();
            option = validateReadValue();
            isValidInput = (option > DEFAULT_VALUE && option < 12);
        }
        return option;
    }

    private static int validateReadValue() {
        String input;
        boolean hasOnlyNumbers;
        int validValue = DEFAULT_VALUE;
        try {
            input = scanner.nextLine();
            hasOnlyNumbers = input.matches("[0-9]");

            if(!hasOnlyNumbers) throw new IllegalArgumentException("Utilize apenas números.");
            validValue = Integer.parseInt(input);

        } catch (final Exception exception) {
            logger.info("Entrada inválida. Tente novamente.");
            logger.debug(exception.getStackTrace());
        } finally {
            logger.info("Entrada informada = {}\r\n", validValue);
        }
        return validValue;
    }

    private static void printMenu() {
        logger.info("Digite a opção desejada:");
        logger.info("00 - Sair");
        logger.info("01 - Adiciona contato no final do vetor");
        logger.info("02 - Adiciona contato em uma posicão específica do vetor");
        logger.info("03 - Obtém contato de uma posição específica do vetor");
        logger.info("04 - Consulta a existência do contato no vetor");
        logger.info("05 - Consulta o último índice do contato no vetor");
        logger.info("06 - Verifica a existência do contato no vetor");
        logger.info("07 - Remove o contato por posição específica no vetor");
        logger.info("08 - Excluir contato do vetor");
        logger.info("09 - Verificar o tamanho do vetor");
        logger.info("10 - Excluir todos os contatos do vetor");
        logger.info("11 - Imprime o vetor\r\n");
    }

    private static void addContact(final Vector<Contact> list, final boolean isAddByPosition) {
        logger.info("addContact() - BEGIN");
        final String name   = readInfoString("Insira o nome");
        final String phone  = readInfoString("Insira o telefone");
        final String email  = readInfoString("Insira o email");
        final Contact contact = new Contact(name, phone, email);

        if(isAddByPosition) {
            final int position = readInfoInt("Insira a posição do vetor para adicionar o contato");
            list.append(position, contact);
        } else {
            list.append(contact);
        }

        logger.info("Contato adicionado com sucesso.");
        logger.info(contact.toString());
    }

    private static String readInfoString(final String message) {
        logger.info("readInfoString - Message = {}", message);
        final String input = scanner.nextLine();
        return input;
    }

    private static int readInfoInt(final String message) {
        logger.info("readInfoInt - Message = {}", message);

        boolean isValidInput = false;
        int readValue = DEFAULT_VALUE;

        while (!isValidInput) {
            readValue = validateReadValue();
            isValidInput = (readValue > DEFAULT_VALUE);
        }
        return readValue;
    }

    public static Contact getContactByPosition() {
        final int position = readInfoInt("Insira a posição do contato desejado:");
        try {
            final Contact contact = listContacts.searchByPosition(position);
            logger.info("Contato encontrado : {}", contact.toString());
            return contact;
        } catch (final Exception exception) {
            logger.info("Entrada inválida. Tente novamente.");
            logger.debug(exception.getStackTrace());
            return null;
        }
    }

    public static void main(String[] args) {
        logger.info("Programa iniciado");

        int option = 1;

        while(option != 0) {
            option = getMenu();
            switch(option){
                case 1:
                    addContact(listContacts, false);
                    break;
                case 2:
                    addContact(listContacts, true);
                    break;
                case 3:
                    getContactByPosition();
                    break;
                default:
                    break;
            }
        }

        logger.info("Programa terminado");
    }
}
