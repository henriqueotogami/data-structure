package main.otogamidev.stack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Stack<T> extends StaticStructure<T> {

    /** Nome da Classe Stack */
    private static final String CLASS_NAME = "Stack";
    private static final Logger logger = LogManager.getLogger(Stack.class);

    /**
     * Metodo construtor que instancia a pilha com a capacidade informada.
     * @param capable capacidade da pilha
     */
    public Stack(final int capable) {
        super.elements = (T[]) new Object[capable];
        super.size = 0;
    }

    /**
     * Metodo construtor instanciando a capacidade padrao de dez elementos.
     */
    public Stack() { this(10); }

    /**
     * Metodo responsavel para empilhar o elemento na pilha.
     * @param element elemento que sera empilhado.
     */
    public void push(final T element) { super.append(element); }

    /**
     * Metodo responsavel pela obtencao do valor do topo da pilha sem remove-lo.
     * @return Retorna o elemento do topo da Pilha.
     * @throws NullPointerException lanca uma exception se a pilha estiver vazia
     */
    public T peek(){
        if(super.isEmpty()) throw new NullPointerException("A pilha está vazia");

        return super.elements[super.size-1];
    }

    public T pull() {

        if(super.isEmpty()) return null;

        final T element = super.elements[--super.size];
        super.elements[super.size] = null;
        return element;
//        A solucao abaixo nao remove o elemento do vetor, ocasionando que o ultimo elemtno permaneca na posicao
//        que deveria ter sido removido
//        return super.elements[--super.size];
    }
}
 