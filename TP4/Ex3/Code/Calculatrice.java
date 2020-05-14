import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculatrice {
    private String VALID_OPERATORS = "+-*/";
    private String VALID_DIGITS = "0123456789";

    private String operation;

    public Calculatrice() {
        operation = "";
    }

    public void addChar(String c) {
        if (operation.length() == 0 || VALID_OPERATORS.contains(operation.substring(operation.length() - 1))) {
            if (VALID_OPERATORS.contains(c)) return;
            if (VALID_DIGITS.contains(c)) operation += c;
        } else {
            if (VALID_DIGITS.contains(c) || VALID_OPERATORS.contains(c)) operation += c;
        }
    }

    public double evaluateOperation() {
        if (VALID_OPERATORS.contains(operation.substring(operation.length() - 1)))
            return evaluateOperation(operation.substring(0, operation.length() - 1));
        return evaluateOperation(operation);
    }

    private static double evaluateOperation(String operation) {
        if (!operation.matches(".*[+\\-*/].*")) return Double.parseDouble(operation);

        Pattern pattern;
        if (operation.matches(".*[+\\-].*")) pattern = Pattern.compile("[+\\-]");
        else pattern = Pattern.compile("[*/]");
        Matcher matcher = pattern.matcher(operation);
        matcher.find();
        double left = evaluateOperation(operation.substring(0, matcher.start()));
        double right = evaluateOperation(operation.substring(matcher.end()));
        String operator = operation.substring(matcher.start(), matcher.end());

        switch (operator) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                return left / right;
            default:
                return 0;
        }
    }

    public String getOperation() {
        return operation;
    }

    public void resetOperation() {
        operation = "";
    }
}
