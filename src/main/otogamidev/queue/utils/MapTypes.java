package main.otogamidev.queue.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe responsavel pelo mapeamento dos tipos de dados primitivos e de objetos do Java.
 *
 * Cada tipo de dados sera categorizado e tera seu tratamento especifico para converter seu conteudo para string,
 * conforme abaixo:
 *
 * 1 - Tipos primitivos
 * 2 - Tipos de objetos
 * 3 - Arrays de tipos primitivos
 * 4 - Arrays de tipos de objetos
 *
 * @author henriquematheusalvespereira
 */
public class MapTypes {

    /** Nome da Classe Queue */
    private static final String CLASS_NAME = "MapTypes";

    private final Logger logger = LogManager.getLogger(MapTypes.class);

    private static final Map<String, String> typeConverters = new HashMap<>();

    /** Tipo Primitivo: Integer */
    public static final String TYPE_PRIMITIVE_INTEGER   = "integer";
    /** Tipo Primitivo: Double */
    public static final String TYPE_PRIMITIVE_DOUBLE    = "double";
    /** Tipo Primitivo: Float */
    public static final String TYPE_PRIMITIVE_FLOAT     = "float";
    /** Tipo Primitivo: Long */
    public static final String TYPE_PRIMITIVE_LONG      = "long";
    /** Tipo Primitivo: Short */
    public static final String TYPE_PRIMITIVE_SHORT     = "short";
    /** Tipo Primitivo: Byte */
    public static final String TYPE_PRIMITIVE_BYTE      = "byte";
    /** Tipo Primitivo: Char */
    public static final String TYPE_PRIMITIVE_CHAR      = "char";
    /** Tipo Primitivo: Boolean */
    public static final String TYPE_PRIMITIVE_BOOLEAN   = "boolean";

    /** Tipo Objeto: Integer */
    public static final String TYPE_OBJECT_INTEGER      = "Integer";
    /** Tipo Objeto: Double */
    public static final String TYPE_OBJECT_DOUBLE       = "Double";
    /** Tipo Objeto: Float */
    public static final String TYPE_OBJECT_FLOAT        = "Float";
    /** Tipo Objeto: Long */
    public static final String TYPE_OBJECT_LONG         = "Long";
    /** Tipo Objeto: Short */
    public static final String TYPE_OBJECT_SHORT        = "Short";
    /** Tipo Objeto: Byte */
    public static final String TYPE_OBJECT_BYTE         = "Byte";
    /** Tipo Objeto: Char */
    public static final String TYPE_OBJECT_CHAR         = "Character";
    /** Tipo Objeto: Boolean */
    public static final String TYPE_OBJECT_BOOLEAN      = "Boolean";
    /** Tipo Objeto: String */
    public static final String TYPE_OBJECT_STRING       = "String";

    /** Tipo Array Primitivo: Integer */
    public static final String TYPE_PRIMITIVE_ARRAY_INTEGER     = "int[]";
    /** Tipo Array Primitivo: Double */
    public static final String TYPE_PRIMITIVE_ARRAY_DOUBLE      = "double[]";
    /** Tipo Array Primitivo: Float */
    public static final String TYPE_PRIMITIVE_ARRAY_FLOAT       = "float[]";
    /** Tipo Array Primitivo: Long */
    public static final String TYPE_PRIMITIVE_ARRAY_LONG        = "long[]";
    /** Tipo Array Primitivo: Short */
    public static final String TYPE_PRIMITIVE_ARRAY_SHORT       = "short[]";
    /** Tipo Array Primitivo: Byte */
    public static final String TYPE_PRIMITIVE_ARRAY_BYTE        = "byte[]";
    /** Tipo Array Primitivo: Char */
    public static final String TYPE_PRIMITIVE_ARRAY_CHAR        = "char[]";
    /** Tipo Array Primitivo: Boolean */
    public static final String TYPE_PRIMITIVE_ARRAY_BOOLEAN     = "boolean[]";

    /** Tipo Array de Objetos: Integer */
    public static final String TYPE_OBJECT_ARRAY_INTEGER    = "Integer[]";
    /** Tipo Array de Objetos: Doubke */
    public static final String TYPE_OBJECT_ARRAY_DOUBLE     = "Double[]";
    /** Tipo Array de Objetos: Float */
    public static final String TYPE_OBJECT_ARRAY_FLOAT      = "Float[]";
    /** Tipo Array de Objetos: Long */
    public static final String TYPE_OBJECT_ARRAY_LONG       = "Long[]";
    /** Tipo Array de Objetos: Short */
    public static final String TYPE_OBJECT_ARRAY_SHORT      = "Short[]";
    /** Tipo Array de Objetos: Byte */
    public static final String TYPE_OBJECT_ARRAY_BYTE       = "Byte[]";
    /** Tipo Array de Objetos: Character */
    public static final String TYPE_OBJECT_ARRAY_CHAR       = "Character[]";
    /** Tipo Array de Objetos: Boolean */
    public static final String TYPE_OBJECT_ARRAY_BOOLEAN    = "Boolean[]";
    /** Tipo Array de Objetos: String */
    public static final String TYPE_OBJECT_ARRAY_STRING     = "String[]";

    /** Categoria: Grupo de tipos primitivos */
    public static final String GROUP_PRIMITIVE          = "Primitive";
    /** Categoria: Grupo de tipos de objetos */
    public static final String GROUP_OBJECT             = "Object";
    /** Categoria: Grupo de tipos de arrays primitivos */
    public static final String GROUP_PRIMITIVE_ARRAY    = "Primitive Array";
    /** Categoria: Grupo de tipos de arrays de objetos */
    public static final String GROUP_OBJECT_ARRAY       = "Object Array";

    static {
        // Inicializando os conversores para tipos primitivos
        typeConverters.put(TYPE_PRIMITIVE_INTEGER,  GROUP_PRIMITIVE);
        typeConverters.put(TYPE_PRIMITIVE_DOUBLE,   GROUP_PRIMITIVE);
        typeConverters.put(TYPE_PRIMITIVE_FLOAT,    GROUP_PRIMITIVE);
        typeConverters.put(TYPE_PRIMITIVE_LONG,     GROUP_PRIMITIVE);
        typeConverters.put(TYPE_PRIMITIVE_SHORT,    GROUP_PRIMITIVE);
        typeConverters.put(TYPE_PRIMITIVE_BYTE,     GROUP_PRIMITIVE);
        typeConverters.put(TYPE_PRIMITIVE_CHAR,     GROUP_PRIMITIVE);
        typeConverters.put(TYPE_PRIMITIVE_BOOLEAN,  GROUP_PRIMITIVE);

        // Inicializando os conversores para tipos de objetos
        typeConverters.put(TYPE_OBJECT_INTEGER,     GROUP_OBJECT);
        typeConverters.put(TYPE_OBJECT_DOUBLE,      GROUP_OBJECT);
        typeConverters.put(TYPE_OBJECT_FLOAT,       GROUP_OBJECT);
        typeConverters.put(TYPE_OBJECT_LONG,        GROUP_OBJECT);
        typeConverters.put(TYPE_OBJECT_SHORT,       GROUP_OBJECT);
        typeConverters.put(TYPE_OBJECT_BYTE,        GROUP_OBJECT);
        typeConverters.put(TYPE_OBJECT_CHAR,        GROUP_OBJECT);
        typeConverters.put(TYPE_OBJECT_BOOLEAN,     GROUP_OBJECT);
        typeConverters.put(TYPE_OBJECT_STRING,      GROUP_OBJECT);

        // Inicializando os conversores para arrays de tipos primitivos
        typeConverters.put(TYPE_PRIMITIVE_ARRAY_INTEGER,    GROUP_PRIMITIVE_ARRAY);
        typeConverters.put(TYPE_PRIMITIVE_ARRAY_DOUBLE,     GROUP_PRIMITIVE_ARRAY);
        typeConverters.put(TYPE_PRIMITIVE_ARRAY_FLOAT,      GROUP_PRIMITIVE_ARRAY);
        typeConverters.put(TYPE_PRIMITIVE_ARRAY_LONG,       GROUP_PRIMITIVE_ARRAY);
        typeConverters.put(TYPE_PRIMITIVE_ARRAY_SHORT,      GROUP_PRIMITIVE_ARRAY);
        typeConverters.put(TYPE_PRIMITIVE_ARRAY_BYTE,       GROUP_PRIMITIVE_ARRAY);
        typeConverters.put(TYPE_PRIMITIVE_ARRAY_CHAR,       GROUP_PRIMITIVE_ARRAY);
        typeConverters.put(TYPE_PRIMITIVE_ARRAY_BOOLEAN,    GROUP_PRIMITIVE_ARRAY);

        // Inicializando os conversores para arrays de objetos
        typeConverters.put(TYPE_OBJECT_ARRAY_INTEGER,   GROUP_OBJECT_ARRAY);
        typeConverters.put(TYPE_OBJECT_ARRAY_DOUBLE,    GROUP_OBJECT_ARRAY);
        typeConverters.put(TYPE_OBJECT_ARRAY_FLOAT,     GROUP_OBJECT_ARRAY);
        typeConverters.put(TYPE_OBJECT_ARRAY_LONG,      GROUP_OBJECT_ARRAY);
        typeConverters.put(TYPE_OBJECT_ARRAY_SHORT,     GROUP_OBJECT_ARRAY);
        typeConverters.put(TYPE_OBJECT_ARRAY_BYTE,      GROUP_OBJECT_ARRAY);
        typeConverters.put(TYPE_OBJECT_ARRAY_CHAR,      GROUP_OBJECT_ARRAY);
        typeConverters.put(TYPE_OBJECT_ARRAY_BOOLEAN,   GROUP_OBJECT_ARRAY);
        typeConverters.put(TYPE_OBJECT_ARRAY_STRING,    GROUP_OBJECT_ARRAY);
    }

    /**
     * Classe de mapeamento dos tipos de objetos e tipos primitivos do Java,
     */
    public MapTypes() {
    }

    /**
     * Metodo responsavel pela tratativa de conversao do conteudo de um array de objetos em string
     * @param element array de objetos denominado como um elemento
     * @param elementType tipo do array de objetos
     * @return Retorna o conteudo do array de objetos em string
     */
    public static String getObjectArrayToString(Object element, String elementType) {
        String elementToString = "";
        switch (elementType) {
            case MapTypes.TYPE_OBJECT_ARRAY_INTEGER     -> elementToString = getElementContentsToString((Integer[]) element);
            case MapTypes.TYPE_OBJECT_ARRAY_DOUBLE      -> elementToString = getElementContentsToString((Double[]) element);
            case MapTypes.TYPE_OBJECT_ARRAY_FLOAT       -> elementToString = getElementContentsToString((Float[]) element);
            case MapTypes.TYPE_OBJECT_ARRAY_LONG        -> elementToString = getElementContentsToString((Long[]) element);
            case MapTypes.TYPE_OBJECT_ARRAY_SHORT       -> elementToString = getElementContentsToString((Short[]) element);
            case MapTypes.TYPE_OBJECT_ARRAY_BYTE        -> elementToString = getElementContentsToString((Byte[]) element);
            case MapTypes.TYPE_OBJECT_ARRAY_CHAR        -> elementToString = getElementContentsToString((Character[]) element);
            case MapTypes.TYPE_OBJECT_ARRAY_BOOLEAN     -> elementToString = getElementContentsToString((Boolean[]) element);
            case MapTypes.TYPE_OBJECT_ARRAY_STRING      -> elementToString = getElementContentsToString((String[]) element);
            default -> elementToString = "NONE";
        }
        return elementToString;
    }

    /**
     * Metodo responsavel pela tratativa de conversao do conteudo de um array de tipos primitivos em string
     * @param element array de tipos primitibos denominado como um elemento
     * @param elementType tipo do array de tipos primitivos
     * @return Retorna o conteudo do objeto em string
     */
    public static String getPrimitiveArrayToString(Object element, String elementType) {
        String elementToString = switch (elementType) {
            case MapTypes.TYPE_PRIMITIVE_ARRAY_INTEGER,
                 MapTypes.TYPE_PRIMITIVE_ARRAY_DOUBLE,
                 MapTypes.TYPE_PRIMITIVE_ARRAY_FLOAT,
                 MapTypes.TYPE_PRIMITIVE_ARRAY_LONG,
                 MapTypes.TYPE_PRIMITIVE_ARRAY_SHORT,
                 MapTypes.TYPE_PRIMITIVE_ARRAY_BYTE,
                 MapTypes.TYPE_PRIMITIVE_ARRAY_CHAR,
                 MapTypes.TYPE_PRIMITIVE_ARRAY_BOOLEAN -> getElementContentsToString(element);
            default -> "NONE";
        };
        return elementToString;
    }


    /**
     * Metodo responsavel pela tratativa de conversao do conteudo de um objeto em string
     * @param element objetos denominado como um elemento
     * @param elementType tipo do objeto
     * @return Retorna o conteudo do objeto em string
     */
    public static String getObjectToString(Object element, String elementType) {
        String elementToString = "";
        switch (elementType) {
            case MapTypes.TYPE_OBJECT_INTEGER   -> elementToString = String.valueOf(((Integer) element).intValue());
            case MapTypes.TYPE_OBJECT_DOUBLE    -> elementToString = String.valueOf(((Double) element).doubleValue());
            case MapTypes.TYPE_OBJECT_FLOAT     -> elementToString = String.valueOf(((Float) element).floatValue());
            case MapTypes.TYPE_OBJECT_LONG      -> elementToString = String.valueOf(((Long) element).longValue());
            case MapTypes.TYPE_OBJECT_SHORT     -> elementToString = String.valueOf(((Short) element).shortValue());
            case MapTypes.TYPE_OBJECT_BYTE      -> elementToString = String.valueOf(((Byte) element).byteValue());
            case MapTypes.TYPE_OBJECT_CHAR      -> elementToString = String.valueOf(((Character) element).charValue());
            case MapTypes.TYPE_OBJECT_BOOLEAN   -> elementToString = String.valueOf(((Boolean) element).booleanValue());
            case MapTypes.TYPE_OBJECT_STRING    -> elementToString = ((String) element);
            default -> elementToString = "NONE";
        }
        return elementToString;
    }

    /**
     * Metodo responsavel pela tratativa de conversao do conteudo de um tipo primitivo em string
     * @param element tipo primitivo denominado como um elemento
     * @param elementType tipo do primitivo
     * @return Retorna o conteudo do tipo primitivo em string
     */
    public static String getPrimitiveToString(Object element, String elementType) {
        String elementToString = "";
        switch (elementType) {
            case MapTypes.TYPE_PRIMITIVE_INTEGER    -> elementToString = String.valueOf((int) element);
            case MapTypes.TYPE_PRIMITIVE_DOUBLE     -> elementToString = String.valueOf((double) element);
            case MapTypes.TYPE_PRIMITIVE_FLOAT      -> elementToString = String.valueOf((float) element);
            case MapTypes.TYPE_PRIMITIVE_LONG       -> elementToString = String.valueOf((long) element);
            case MapTypes.TYPE_PRIMITIVE_SHORT      -> elementToString = String.valueOf((short) element);
            case MapTypes.TYPE_PRIMITIVE_BYTE       -> elementToString = String.valueOf((byte) element);
            case MapTypes.TYPE_PRIMITIVE_CHAR       -> elementToString = String.valueOf((char) element);
            case MapTypes.TYPE_PRIMITIVE_BOOLEAN    -> elementToString = String.valueOf((boolean) element);
            default -> elementToString = "NONE";
        }
        return elementToString;
    }

    /**
     * Metodo responsavel pela conversao do conteudo de um array de objetos em string.
     * @param objectArray Array de objetos que sera tratado
     * @return Retorna uma string com o conteudo do array informado
     */
    private static String getElementContentsToString(final Object[] objectArray) {
        String stringElement = "[";
        for (int index = 0; objectArray.length > index; index++) {
            final String valueToString = String.valueOf(objectArray[index]);
            stringElement = stringElement.concat(valueToString);

            if ((objectArray.length - 1) != index) stringElement = stringElement.concat(",");
        }
        stringElement = stringElement.concat("]");
        return stringElement;
    }


    /**
     * Metodo responsavel pela conversão do conteúdo de um array de tipos primitivos em string.
     * @param element Elemento de tipo primitivo.
     * @return Retorna o conteudo formatado em string
     */
    private static String getElementContentsToString(Object element) {
        String elementToString = "[";
        final int arrayLength = Array.getLength(element);
        for (int index = 0; arrayLength > index; index++) {
            final String valueToString = String.valueOf(Array.get(element, index));
            elementToString = elementToString.concat(valueToString);

            if ((arrayLength - 1) != index) elementToString = elementToString.concat(",");
        }
        elementToString = elementToString.concat("]");
        return elementToString;
    }

    /**
     * Metodo responsavel pela obtencao do grupo de tipo de dados
     * @param typeElement tipo de objeto esperado no map
     * @return Retorna o grupo categorizado desse objeto
     */
    public static String getGroup(final String typeElement) {
        return typeConverters.get(typeElement);
    }

    /**
     * Metodo responsavel pela obtencao do tipo de objeto
     * @param element tipo de dado primitivo ou objeto
     * @return Retorna o nome do tipo de dado ou objeto
     */
    public static String getObjectType(final Object element) {
        return element.getClass().getSimpleName();
    }
}
