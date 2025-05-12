package main.otogamidev.exercises;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;
import java.util.Stack;

/**
 * <br> Exercicio 01 de Pilhas do curso da Loiane Groner.
 * <br> Aula 26
 * <br> Escreva um programa que leia 10 numeros. Para cada numero lido, verifique e codifique conforme as regras:
 * <br> 01 - Se o numero for par, empilhe na Pilha;
 * <br> 02 - Se o numero for impar, desempilhe da Pilha. Mostre uma mensagem se a pilha estiver vazia.
 * <br> 03 - Se a pilha estiver cheia no final do programa, desempilhe os elementos, imprimindo na tela.
 *
 * @author henriquematheusalvespereira
 */
public class PushAndPullNumbers {

    public static void main(String[] args) {
        final Stack<Integer> stack = new Stack<Integer>();
        final Scanner scanner = new Scanner(System.in);
        final Logger logger = LogManager.getLogger(PushAndPullNumbers.class);
        final int MAX_STACK_SIZE = 10;
        final int MAX_RETRIES = 20;
        int countRetries = 0;
        logger.info("PushAndPullNumbers - BEGIN");
        while(MAX_STACK_SIZE > stack.size()){
            logger.info("Insira um número: ");
            final String input = scanner.next();

            if(!input.matches("[0-9]+")) {
                logger.info("Entrada inválida. Tente novamente.");
                countRetries++;
                if(countRetries == MAX_RETRIES) {
                    logger.info("Limite de retentativas excedidas. O software sera fechado.");
                    break;
                }
//              Controle de loop do while: se falhar a validacao de entrada numerica, utilizo o "continue" para pular
//              para o próximo ciclo, ate o usuario digitar corretamente
                continue;
            }

            final int inputNumber = Integer.parseInt(input);
            logger.info("Número digitado = {}", inputNumber);

            final boolean isEvenNumber = ((inputNumber % 2) == 0);
            logger.info("O número é par = {}", isEvenNumber);
            if(isEvenNumber) {
                stack.push(inputNumber);
                logger.info("O número foi adicionado.");
//              Controle de loop do while: se o numero eh par, vai ser adicionado na pilha e utilizo o "continue" para pular
//              para o próximo ciclo, ate a pilha atingir o tamanho maximo de 10 digitos
                continue;
            }

            if(!stack.isEmpty()) {
                final int removed = stack.pop();
                logger.info("O número foi removido = {}", removed);
//              Aqui nao precisou utilizar o "continue" para controle de loop do while, porque so vai chegar ate aqui se
//              o numero for impar e so preciso verificar se a pilha estara vazia antes de remover um elemento
            }
        }

        scanner.close();

        if(!stack.isEmpty()) {
            logger.info("Pilha completa = {}", stack.toString());
            while(!stack.isEmpty()){
                final int removed = stack.pop();
                logger.info("Elemento removido = {} | Tamanho da Pilha = {}", removed, stack.size());
            }
        }
        logger.info("PushAndPullNumbers - END");
    }
}
