package main.otogamidev.utils;

import main.otogamidev.list.LinkedList;

public class Utils {

    /**
     * Metodo para gerar numero aleatorio de tamanho de lista
     * @return Retorna um índice "aleatorio" para que os metodos dos testes abaixos utilizem tipos de objetos diferentes.
     */
    public static int getRandomIndex(final int size) { return (int) (Math.random() * size); }

    public static String getListWithoutSpecificIndex(final LinkedList<Object> list, final int ignorePosition) {
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
}
