package at.htlleonding;

public class RpnCalculator {
    private static final String DOUBLE_PATTERN = "^[+]?(([0-9]\\d*)|0)(\\.\\d+)?";

    public static boolean isValidNumber(String number) {
        return number.matches(DOUBLE_PATTERN);
    }

    public static double evaluateExpression(String exp) {
        NumberStack stack = new NumberStack();
        String[] fields = exp.split(" ");

        for (int i = 0; i < fields.length; i++) {
            if(isValidNumber(fields[i])) {
                stack.push(Double.parseDouble(fields[i]));
            } else {
                double temp = stack.pop();

                switch (fields[i]) {
                    case "+":
                        stack.push(stack.pop() + temp);
                        break;
                    case "-":
                        stack.push(stack.pop() - temp);
                        break;
                    case "*":
                        stack.push(stack.pop() * temp);
                        break;
                    case "/":
                        stack.push(stack.pop() / temp);
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            }
        }
        return stack.peek();
    }
}