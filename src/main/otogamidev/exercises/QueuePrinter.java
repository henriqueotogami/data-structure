package main.otogamidev.exercises;

import main.otogamidev.queue.QueueStatic;

public class QueuePrinter {

    public static class Document {

        private String name = "Document";
        private int numberOfPages = 0;

        public Document(final String name, final int numberOfPages) {
            this.name = name;
            this.numberOfPages = numberOfPages;
        }

        public String getName() { return name; }

        public int getNumberOfPages() { return numberOfPages; }
    }

    public static void main(String[] args) {

        final QueueStatic<Document> queuePrinter = new QueuePriority<>();
        queuePrinter.enqueue(new Document("Document-01.pdf", 1));
        queuePrinter.enqueue(new Document("Document-02.pdf", 9));
        queuePrinter.enqueue(new Document("Document-03.pdf", 12));
        queuePrinter.enqueue(new Document("Document-04.pdf", 5));
        queuePrinter.enqueue(new Document("Document-05.pdf", 7));
        queuePrinter.enqueue(new Document("Document-06.pdf", 2));
        queuePrinter.enqueue(new Document("Document-07.pdf", 10));
        queuePrinter.enqueue(new Document("Document-08.pdf", 8));
        queuePrinter.enqueue(new Document("Document-09.pdf", 15));
        queuePrinter.enqueue(new Document("Document-10.pdf", 11));

        while(!queuePrinter.isEmpty()) {
            final Document document = queuePrinter.dequeue();
            System.out.println("document = " + document.getName());
            try {
                Thread.sleep(500 * document.getNumberOfPages());
            } catch (final InterruptedException interruptedException) {
                interruptedException.getStackTrace();
            }
        }
        System.out.println("Todos os documentos foram impressos.");
    }

}
