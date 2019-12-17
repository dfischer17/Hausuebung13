package arithmeticutils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class PostFixConverter {
    private String infix; // Eingabe zum umwandeln
    private Deque<Character> stack = new ArrayDeque<>(); // Zwischenspeichern der Operatoren
    private List<Character> postfix = new ArrayList<>(); // war String!!!
    private List<Character> operators = Arrays.asList('+', '-', '*', '/');

    public PostFixConverter(String infix) {
        this.infix = infix;
    }

    private void convertExpression() {
        // Zeichen der Eingabe durchlaufen
        for (Character curChar : infix.toCharArray()) {

            // Wenn Zeichen ist Zahl
            if (Character.isDigit(curChar)) {
                postfix.add(curChar);
            }

            // Wenn Zeichen ist Operator
            if (operators.contains(curChar)) {
                // stack nicht leer || stack spitze ist operator || Token ist linksassoziativ || Präzedenz von Token IST-KLEINER-GLEICH Präzedenz von Stack-Spitze
                while (!stack.isEmpty() && operators.contains(stack.peek()) &&  && (getPrecedence(curChar) < getPrecedence(stack.peek()))) {

                }
            }

        }
    }

    private void inputToStack(char input) {
        stack.push(input);
    }

    // TODO
    private int getPrecedence(char op) {
        switch(op) {
            case '+':
                return
        }
    }

    private void clearStack() {
        stack.clear();
    }

    // TODO
    public String getPostfixExpression() {
        return null;
    }

    public List<Character> getPostfixAsList() {
        return postfix;
    }
}
