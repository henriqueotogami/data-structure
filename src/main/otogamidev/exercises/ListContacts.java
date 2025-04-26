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

    private static int getMenu(final Scanner scan) {
        logger.info("Digite a opção desejada:");
        logger.info("01 - Adiciona contato no final do vetor");
        logger.info("02 - Adiciona contato em uma posicão específica do vetor");
        logger.info("03 - Obtém contato de uma posição específica do vetor");
        logger.info("04 - Consulta a existência do contato no vetor");
        logger.info("05 - Consulta o último índice do contato no vetor");
        logger.info("06 - Verifica a existência do contato no vetor");
        logger.info("07 - Remove o contato por posição específica no vetor");
        logger.info("08 - Exclui contato do vetor");
    }
}
