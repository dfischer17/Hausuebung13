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

        // Ausdruck von infix in postfix Notation konvertieren
        convertExpression();
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
                // stack nicht leer || stack spitze ist operator || Präzedenz von Token IST-KLEINER-GLEICH Präzedenz von Stack-Spitze
                while (!stack.isEmpty() && operators.contains(stack.peek()) && (getPrecedence(curChar) <= getPrecedence(stack.peek()))) {
                    // Stackspitze zu Ausgabe hinzugfügen
                    postfix.add(stack.pop()); // peek
                }
                inputToStack(curChar);
            }

            // Wenn Zeichen ist öffnende Klammer
            if (curChar.equals('(')) {
                inputToStack(curChar);
            }

            // Wenn Zeichen ist schliessende Klammer
            if (curChar.equals(')')) {

                // solange bis Stack Spite ist öffnenede Klammer
                while (!stack.peek().equals('(')) {
                    // Fehler: schließenden Klammer geht keine öffnende voraus
                    // Stackspitze zu Ausgabe
                    postfix.add(stack.pop());
                }

                // Stackspitze (oeffnende Klammer) entfernen
                stack.remove(stack.peek());
            }
        }

        while (!stack.isEmpty()) {
            postfix.add(stack.pop());
        }
    }

    private void inputToStack(char input) {
        stack.push(input);
    }

    private int getPrecedence(char op) {
        switch(op) {
            case '+':
                return 1;

            case '-':
                return 1;

            case '*':
                return 2;

            case '/':
                return 2;

            case '(':
                return 3;

            case ')':
                return 3;

            default:
                System.err.println("Ungültiges Zeichen fuer getPrecendence!");
        }
        return -1;
    }

    private void clearStack() {
        stack.clear();
    }

    public String getPostfixExpression() {
        return postfix.toString();
    }

    public List<Character> getPostfixAsList() {
        return postfix;
    }
}
