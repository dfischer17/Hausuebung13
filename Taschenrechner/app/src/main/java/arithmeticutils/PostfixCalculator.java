package arithmeticutils;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
1) Operanden eingeben
2  Operatoren eingeben

Operanden werden beim Lesen auf den Stapel gelegt, ein Operator holt sich die Anzahl an Operanden
vom Stapel (Stack), die seiner Stelligkeit entspricht, und legt das Ergebnis der Operation wieder
auf dem Stapel ab. Am Ende liegt dann das Ergebnis des Terms oben auf dem Stapel

Bsp:
Weiteres Beispiel (in der Infixnotation): „(3+4)×5“. Bei der UPN können die Klammern entfallen, alle
Operationen (hier „+“ und „×“) arbeiten mit den beiden oberen Elementen des Stapels. Das Beispiel
heißt in UPN dann: „3 4 + 5 ×“ (zuerst wird der Klammerausdruck „3 4 +“ausgerechnet, danach die
hierbei entstandene Zahl 7 mit 5 multipliziert).
 */

public class PostfixCalculator {
    private List<String> expression = new ArrayList<>();
    private Deque<Double> stack = new ArrayDeque<>();

    public PostfixCalculator(List<String> expression) {
        this.expression = expression;
    }

    public BigDecimal getResult() {

        return null;
    }
}
