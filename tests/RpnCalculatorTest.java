import at.htlleonding.RpnCalculator;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class RpnCalculatorTest {
    @Test
    void testValidNumberValidation() {
        assertEquals(true, RpnCalculator.isValidNumber("1.0"));
        assertEquals(true, RpnCalculator.isValidNumber("1.5"));
        assertEquals(true, RpnCalculator.isValidNumber("0.05"));
        assertEquals(true, RpnCalculator.isValidNumber("0.123"));
        assertEquals(true, RpnCalculator.isValidNumber("321.9999007"));
        assertEquals(true, RpnCalculator.isValidNumber("7"));
        assertEquals(true, RpnCalculator.isValidNumber("0123"));
        assertEquals(true, RpnCalculator.isValidNumber("0"));
    }

    @Test
    void testInvalidNumberValidation() {
        assertEquals(false, RpnCalculator.isValidNumber("1,0"));
        assertEquals(false, RpnCalculator.isValidNumber("1/5"));
        assertEquals(false, RpnCalculator.isValidNumber("-0.05"));
        assertEquals(false, RpnCalculator.isValidNumber("0..05"));
        assertEquals(false, RpnCalculator.isValidNumber("321.999.9007"));
        assertEquals(false, RpnCalculator.isValidNumber("g9"));
        assertEquals(false, RpnCalculator.isValidNumber("vier"));
        assertEquals(false, RpnCalculator.isValidNumber("19.v97"));
        assertEquals(false, RpnCalculator.isValidNumber("."));
        assertEquals(false, RpnCalculator.isValidNumber(".45"));
    }

    @Test
    void testEvaluateVeryShortExpression() {
        double result = RpnCalculator.evaluateExpression("5");
        assertEquals(5.0, result, 0.001);
    }

    @Test
    void testEvaluateSimpleAddition() {
        double result = RpnCalculator.evaluateExpression("5 7.0 +");
        assertEquals(12.0, result, 0.001);
    }

    @Test
    void testEvaluateSimpleSubtraction() {
        double result = RpnCalculator.evaluateExpression("0.39 0.32 -");
        assertEquals(0.07, result, 0.001);
    }

    @Test
    void testEvaluateSimpleMultiplication() {
        double result = RpnCalculator.evaluateExpression("8.5 5 *");
        assertEquals(42.5, result, 0.001);
    }

    @Test
    void testEvaluateSimpleDivision() {
        double result = RpnCalculator.evaluateExpression("40 2.5 /");
        assertEquals(16.0, result, 0.001);
    }

    @Test
    void testEvaluateLongerExpressions() {
        double result = RpnCalculator.evaluateExpression("1 2 + 3 4 + +");
        assertEquals(10.0, result, 0.001);

        result = RpnCalculator.evaluateExpression("6 5 2 3 + 8 * + 3 + *"); // (((2+3) + 8) * 5)
        assertEquals(288.0, result, 0.001);

        result = RpnCalculator.evaluateExpression("14 3.5 / 4 + 17.3 9.3 - * 2.5 /");
        assertEquals(25.6, result, 0.001);

        result = RpnCalculator.evaluateExpression("10 9 12 / * 2.25 + 0.55 - 4.5 4 * + 1111 11 / *");
        assertEquals(2747.2, result, 0.001);
    }

    @Test
    void testEvaluateInvalidExpressions() {
        assertThrows(IllegalArgumentException.class, () -> {
            double result = RpnCalculator.evaluateExpression("1.0 2.5 + 3,0 4 * +");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            double result = RpnCalculator.evaluateExpression("1.0 2.5 ++ 3.0 4 * +");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            double result = RpnCalculator.evaluateExpression("1.0 2.5 + 3.0 haxi * +");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            double result = RpnCalculator.evaluateExpression("1.0 2.5 + 3.0 4 x +");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            double result = RpnCalculator.evaluateExpression("1.0 2.5 + 3.0 4 x +");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            double result = RpnCalculator.evaluateExpression("1.0 2.5 + 3.0 . * +");
        });
    }

    @Test
    void testEvaluateOperationsOnEmptyStacks() {
        assertThrows(EmptyStackException.class, () -> {
            double result = RpnCalculator.evaluateExpression("*");
        });

        assertThrows(EmptyStackException.class, () -> {
            double result = RpnCalculator.evaluateExpression("1 +");
        });

        assertThrows(EmptyStackException.class, () -> {
            double result = RpnCalculator.evaluateExpression("1 2 + -");
        });

        assertThrows(EmptyStackException.class, () -> {
            double result = RpnCalculator.evaluateExpression("1 2 + 3 - *");
        });
    }
}