package main.otogamidev.exercises;

import main.otogamidev.queue.QueueStatic;
import main.otogamidev.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QueuePrinter {

    /** Nome da Classe QueuePrinter */
    private static final String CLASS_NAME = "QueuePrinter";
    private static final Logger logger = LogManager.getLogger(QueuePrinter.class);
    
    public static class Document implements Comparable {

        private String name = "Document";
        private int numberOfPages = 0;

        public Document(final String name, final int numberOfPages) {
            this.name = name;
            this.numberOfPages = numberOfPages;
        }

        public String getName() { return name; }

        public int getNumberOfPages() { return numberOfPages; }

        @Override
        public int compareTo(Object o) {
            // Implementei a classe Comparable na Document, porque o metodo enqueue precisa do CompareTo
            return 0;
        }
    }

    public static void main(String[] args) {

        final QueueStatic<Document> queuePrinter = new QueuePriority<>();
        for(int index = 0; 10 > index; index++) {
            final int randomNumberOfPages = Utils.getRandomIndex(30);
            queuePrinter.enqueue(new Document(("Document-" + (index+1) + ".pdf"), randomNumberOfPages));
        }

        while(!queuePrinter.isEmpty()) {
            final Document document = queuePrinter.dequeue();
            logger.info("Imprimindo: {} | Número de páginas = {}", document.getName(), document.getNumberOfPages());
            try {
                Thread.sleep(500 * document.getNumberOfPages());
            } catch (final InterruptedException interruptedException) {
                interruptedException.getStackTrace();
            }
        }
        logger.info("Todos os documentos foram impressos.");
    }

}
