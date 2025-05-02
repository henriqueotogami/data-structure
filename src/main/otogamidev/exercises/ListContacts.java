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
            logger.info("Contact was created | name = {} | phone = {} | email = {}\r\n", name, phone, email);
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

        @Override
        public String toString() {
            return "Contact{" + "name='" + this.name + '\'' + ", phone='" + this.phone + '\'' + ", email='" + this.email + '\'' + '}';
        }
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
        logger.info("createContacts() - END\r\n");
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

    private static String validateReadName() {
        boolean isValidRead = false;
        String readString = "";
        while(!isValidRead){
            readString = readInfoString("Insira o nome: ");
//           Regex:
//           - [a-zà-ÿ]: letras minúsculas
//           - \\s: espaços
//           - '-: hifens e apóstrofos (nomes como "Ana-Clara", "D'Ávila")
//           - +: uma ou mais repetições.
            if(readString.toLowerCase().matches("[a-zà-ÿ\\\\s'-]+")) {
                isValidRead = true;
            } else {
                logger.info("Formato inválido. Digite novamente.");
            }
        }
        return readString;
    }

    private static String validateReadPhone() {
        boolean isValidRead = false;
        String readString = "";
        while(!isValidRead){
            readString = readInfoString("Insira o telefone: ");
            if(readString.matches("[0-9]{9}")) {
                isValidRead = true;
            } else {
                logger.info("Formato inválido. Digite novamente.");
            }
        }
        return readString;
    }

    private static String validateReadEmail() {
        boolean isValidRead = false;
        String readString = "";
        while(!isValidRead){
            readString = readInfoString("Insira o email: ");
//          Regex para formato de email: Henriqu3.map@outlook.com.br
//          - ^[\\w._%+-]+      → parte antes do @: letras, números, . _ % + -.
//          - @                 → separador obrigatório.
//          - [\\w.-]+          → domínio (ex: outlook, gmail, etc.).
//          - \\.[a-zA-Z]{2,}   → TLD (ex: .com, .br, .org, etc.), com pelo menos 2 letras.
            if(readString.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                isValidRead = true;
            } else {
                logger.info("Formato inválido. Digite novamente.");
            }
        }
        return readString;
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

    private static void addContact(final boolean isAddByPosition) {
        logger.info("addContact() - BEGIN");
        final String name   = validateReadName();
        final String phone  = validateReadPhone();
        final String email  = validateReadEmail();
        final Contact contact = new Contact(name, phone, email);

        if(isAddByPosition) {
            final int position = readInfoInt("Insira a posição do vetor para adicionar o contato");
            listContacts.append(position, contact);
        } else {
            listContacts.append(contact);
        }

        logger.info("Contato adicionado com sucesso.\r\n");
        logger.info(contact.toString());
    }

    private static String readInfoString(final String message) {
        logger.info("readInfoString - Message = {}", message);
        return scanner.nextLine();
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

    private static Contact getContactByPosition() {
        final int position = readInfoInt("Insira a posição do contato desejado:");
        try {
            final Contact contact = listContacts.searchByPosition(position);
            logger.info("Posição: {}", position);
            logger.info("Contato: {}\r\n", contact.toString());
            return contact;
        } catch (final Exception exception) {
            logger.info("Entrada inválida. Tente novamente.");
            logger.debug(exception.getStackTrace());
            return null;
        }
    }

    private static int getPositionByContact() {
        try {
            final Contact contact = getContactByPosition();
            if(contact == null) throw new NullPointerException("Contato não existe");
            logger.info("Contato: {}\r\n", contact);
            return listContacts.searchByElement(contact);
        } catch (Exception e) {
            logger.info("Tente novamente");
            return DEFAULT_VALUE;
        }
    }

    private static int getLastIndexOfContacts() {
        try {
            final int lastIndex = listContacts.getSize()-1;
            final Contact contact = listContacts.searchByPosition(lastIndex);
            if(contact == null) throw new NullPointerException("Contato não existe");
            logger.info("Último contato na posição: {}\r\n", lastIndex);
            return lastIndex;
        } catch (Exception e) {
            logger.info("Tente novamente");
            return DEFAULT_VALUE;
        }
    }

    private static boolean hasFoundContact(Vector<Contact> listContacts) {
//        Pelo que entendi, pelo fato de estar usando o contexto estático, quando tento acessar a variável global,
//        o acesso estava disponível apenas para o metodo main e aqui era null.
        try {
            final String contactToSearch = readInfoString("Insira o nome do contato: ");
            Contact foundContact = null;
            final Contact[] allContacts = ListContacts.listContacts.getElements();
            for(Contact oneContact : allContacts) {
                final boolean hasFound = oneContact.getName().equals(contactToSearch);
                if(hasFound) {
                    foundContact = oneContact;
                    break;
                }
            }

            if(foundContact == null) throw new NullPointerException("Contato não existe");

            logger.info("Contato encontrado: {}\r\n", foundContact);
            return true;
        } catch (Exception e) {
            logger.info("Tente novamente");
            return false;
        }
    }

    private static void removeByPosition(Vector<Contact> listContacts){
        try {
            final int position = readInfoInt("Insira a posição do contato a ser removido");

            final int oldSize = listContacts.getSize();
            final String oldList = listContacts.toString();

            listContacts.remove(position);

            final int newSize = listContacts.getSize();
            final String newList = listContacts.toString();

            if(oldSize > newSize) logger.info("Contato foi removido\r\n");

//            logger.info("Size: {} | Lista anterior: {}", oldSize, oldList);
//            logger.info("Size: {} | Lista atual: {}", newSize, newList);
        } catch (Exception e) {
            logger.info("Tente novamente");
        }
    }

    private static void removeByContact(Vector<Contact> listContacts){
        try {
            final int position = readInfoInt("Insira a posição do contato a ser removido");

            final int oldSize = listContacts.getSize();
            final String oldList = listContacts.toString();

            final Contact targetContact = listContacts.searchByPosition(position);
            listContacts.remove(targetContact);

            final int newSize = listContacts.getSize();
            final String newList = listContacts.toString();

            if(oldSize > newSize) logger.info("Contato foi removido\r\n");

//            logger.info("Size: {} | Lista anterior: {}", oldSize, oldList);
//            logger.info("Size: {} | Lista atual: {}", newSize, newList);
        } catch (Exception e) {
            logger.info("Tente novamente");
        }
    }

    private static void getSizeContacts(){
        logger.info("Tamanho total de contatos: {}\r\n", listContacts.getSize());
    }

    private static void removeAllContacts() {
        listContacts.clear();
        getSizeContacts();
    }

    private static void printListContacts(){
        logger.info("Lista de contatos: {}\r\n", listContacts.toString());
    }

    public static void main(String[] args) {
        logger.info("Programa iniciado");

        createContacts(20, listContacts);
        int option = 1;

        while(option != 0) {
            option = getMenu();
            switch(option){
                case 1:
                    addContact(false);
                    break;
                case 2:
                    addContact(true);
                    break;
                case 3:
                    getContactByPosition();
                    break;
                case 4:
                    getPositionByContact();
                    break;
                case 5:
                    getLastIndexOfContacts();
                    break;
                case 6:
                    hasFoundContact(listContacts);
                    break;
                case 7:
                    removeByPosition(listContacts);
                    break;
                case 8:
                    removeByContact(listContacts);
                    break;
                case 9:
                    getSizeContacts();
                    break;
                case 10:
                    removeAllContacts();
                    break;
                case 11:
                    printListContacts();
                    break;
                default:
                    logger.info("Opção inexistente. Tente novamente.\r\n");
                    break;
            }
        }

        logger.info("Programa terminado");
    }
}
