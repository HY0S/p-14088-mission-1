package standard.util;

public class Calc {
    private static int index = 0;
    private static String expression;

    public static int run(String expr) {
        expression = expr.replaceAll("\\s+", "");
        index = 0;
        return parseExpression();
    }

    private static int parseExpression() {
        int result = parseTerm();

        while (index < expression.length()) {
            char op = expression.charAt(index);
            if (op == '+') {
                index++;
                result += parseTerm();
            } else if (op == '-') {
                index++;
                result -= parseTerm();
            } else {
                break;
            }
        }

        return result;
    }

    private static int parseTerm() {
        int result = parseFactor();

        while (index < expression.length()) {
            char op = expression.charAt(index);
            if (op == '*') {
                index++;
                result *= parseFactor();
            } else {
                break;
            }
        }

        return result;
    }

    private static int parseFactor() {
        if (index >= expression.length()) {
            return 0;
        }

        char ch = expression.charAt(index);

        if (ch == '-') {
            index++;
            return -parseFactor();
        }

        if (ch == '(') {
            index++;
            int result = parseExpression();
            if (index < expression.length() && expression.charAt(index) == ')') {
                index++;
            }
            return result;
        }

        if (Character.isDigit(ch)) {
            return parseNumber();
        }

        return 0;
    }

    private static int parseNumber() {
        int result = 0;

        while (index < expression.length() && Character.isDigit(expression.charAt(index))) {
            result = result * 10 + (expression.charAt(index) - '0');
            index++;
        }

        return result;
    }
}
