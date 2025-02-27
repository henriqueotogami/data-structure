package main.otogamidev.utils;

import main.otogamidev.list.LinkedList;
import main.otogamidev.list.Node;

public class Utils<T> {

    /**
     * Metodo para gerar numero aleatorio de tamanho de lista
     * @return Retorna um índice "aleatorio" para que os metodos dos testes abaixos utilizem tipos de objetos diferentes.
     */
    public static int getRandomIndex(final int size) { return (int) (Math.random() * size); }

    /**
     * Metodo responsável pela comversão de uma lista encadeada em string, ignorando determinado elemento.
     * @param list lista encadeada que será convertida em string
     * @param ignorePosition posição do elemento na lista que será ignorado na coneversão
     * @return retorna a lista sem o elemento infroamdo em string
     */
    public static String getListWithoutSpecificIndex(final LinkedList<Integer> list, final int ignorePosition) {
        if(list.isEmpty()) return "[]";
        final StringBuilder stringBuilder = new StringBuilder("[");
        final int lastIndex = list.getLastIndex();
        for(int index = 0; lastIndex >= index; index++) {
            if(index == ignorePosition) continue;

            final Object element = list.searchElementByPosition(index);
            stringBuilder.append(element).append(",");
        }
//      Estou adicionando uma vírgula para todos os objetos da lista e depois removo o último aqui
        stringBuilder.replace(stringBuilder.length()-1, stringBuilder.length(),"");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    /**
     * Metodo responsavel pela geração de array de Nós utilizando um tamanho esperado.
     * @param size tamano esperado.
     * @return retorna um array de nós
     */
    public static Node<Integer>[] generateArrayNodes(final int size) {
        final Node<Integer>[] nodes = new Node[size];
        for (int index = 0, number = 1; size > index; index++, number++) nodes[index] = new Node<Integer>(number);
        return nodes;
    }
}
