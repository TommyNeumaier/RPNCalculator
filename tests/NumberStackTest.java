import at.htlleonding.NumberStack;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class NumberStackTest {
    @Test
    void testEmptyStackIsEmpty() {
        NumberStack stack = new NumberStack();

        assertEquals(true, stack.isEmpty());
    }

    @Test
    void testEmptyStackPeekThrowsException() {
        NumberStack stack = new NumberStack();

        assertThrows(EmptyStackException.class, () -> {
            stack.peek();
        });
    }

    @Test
    void testEmptyStackPopThrowsException() {
        NumberStack stack = new NumberStack();

        assertThrows(EmptyStackException.class, () -> {
            double number = stack.pop();
        });
    }

    @Test
    void testPushPopOneNumber() {
        NumberStack stack = new NumberStack();

        assertEquals(true, stack.isEmpty());

        stack.push(19.74);

        assertEquals(false, stack.isEmpty());

        double number = stack.pop();

        assertEquals(19.74, number, 0.001);

        assertEquals(true, stack.isEmpty());
    }

    @Test
    void testPushPeekOneNumber() {
        NumberStack stack = new NumberStack();

        assertEquals(true, stack.isEmpty());

        stack.push(19.74);

        assertEquals(false, stack.isEmpty());

        double number = stack.peek();

        assertEquals(19.74, number, 0.001);

        assertEquals(false, stack.isEmpty());
    }

    @Test
    void testPushPopPushPop() {
        NumberStack stack = new NumberStack();

        assertEquals(true, stack.isEmpty());

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(false, stack.isEmpty());

        assertEquals(3, stack.pop());

        stack.push(4);

        assertEquals(4, stack.pop());
        assertEquals(2, stack.pop());

        stack.push(5);

        assertEquals(5, stack.pop());

        stack.push(6);

        assertEquals(false, stack.isEmpty());

        assertEquals(6, stack.pop());
        assertEquals(1, stack.pop());

        assertEquals(true, stack.isEmpty());

        stack.push(7);

        assertEquals(false, stack.isEmpty());

        assertEquals(7, stack.pop());

        assertEquals(true, stack.isEmpty());
    }

    @Test
    void testPushPopManyNumbers() {
        NumberStack stack = new NumberStack();

        assertEquals(true, stack.isEmpty());

        stack.push(2.6);
        stack.push(1.3);
        stack.push(26.0);
        stack.push(3.6);
        stack.push(2.0);
        stack.push(6.0);

        assertEquals(false, stack.isEmpty());

        double number = stack.pop();
        assertEquals(6.0, number, 0.001);

        assertEquals(false, stack.isEmpty());

        number = stack.pop();
        assertEquals(2.0, number, 0.001);

        assertEquals(false, stack.isEmpty());

        number = stack.pop();
        assertEquals(3.6, number, 0.001);

        assertEquals(false, stack.isEmpty());

        number = stack.pop();
        assertEquals(26.0, number, 0.001);

        assertEquals(false, stack.isEmpty());

        number = stack.pop();
        assertEquals(1.3, number, 0.001);

        assertEquals(false, stack.isEmpty());

        number = stack.pop();
        assertEquals(2.6, number, 0.001);

        assertEquals(true, stack.isEmpty());
    }

    @Test
    void testPushPeekPopManyNumbers() {
        NumberStack stack = new NumberStack();

        stack.push(2.6);
        stack.push(1.3);
        stack.push(26.0);
        stack.push(3.6);
        stack.push(2.0);
        stack.push(6.0);

        double number = stack.peek();
        assertEquals(6.0, number, 0.001);
        number = stack.peek();
        assertEquals(6.0, number, 0.001);
        number = stack.pop();
        assertEquals(6.0, number, 0.001);

        number = stack.pop();
        assertEquals(2.0, number, 0.001);

        number = stack.peek();
        assertEquals(3.6, number, 0.001);
        stack.pop();
        assertEquals(3.6, number, 0.001);

        number = stack.peek();
        assertEquals(26.0, number, 0.001);
        stack.peek();
        assertEquals(26.0, number, 0.001);
        stack.peek();
        assertEquals(26.0, number, 0.001);
        stack.pop();
        assertEquals(26.0, number, 0.001);

        number = stack.pop();
        assertEquals(1.3, number, 0.001);

        number = stack.peek();
        assertEquals(2.6, number, 0.001);
        stack.peek();
        assertEquals(2.6, number, 0.001);

        assertEquals(false, stack.isEmpty());
    }

    @Test
    void testPopTooManyThrowsException() {
        NumberStack stack = new NumberStack();

        stack.push(5.7);
        stack.push(1.8);
        stack.push(4.5);
        stack.push(4.7);
        stack.push(5);
        stack.push(7);

        double number = stack.pop();
        assertEquals(7, number, 0.001);
        number = stack.pop();
        assertEquals(5, number, 0.001);
        number = stack.pop();
        assertEquals(4.7, number, 0.001);
        number = stack.pop();
        assertEquals(4.5, number, 0.001);
        number = stack.pop();
        assertEquals(1.8, number, 0.001);
        number = stack.pop();
        assertEquals(5.7, number, 0.001);

        assertEquals(true, stack.isEmpty());

        assertThrows(EmptyStackException.class, () -> {
            stack.pop();
        });
    }

    @Test
    void testPeekTooManyThrowsException() {
        NumberStack stack = new NumberStack();

        stack.push(5.7);
        stack.push(1.8);
        stack.push(4.5);
        stack.push(4.7);
        stack.push(5);
        stack.push(7);

        double number = stack.pop();
        assertEquals(7, number, 0.001);
        number = stack.pop();
        assertEquals(5, number, 0.001);
        number = stack.pop();
        assertEquals(4.7, number, 0.001);
        number = stack.pop();
        assertEquals(4.5, number, 0.001);
        number = stack.pop();
        assertEquals(1.8, number, 0.001);
        number = stack.pop();
        assertEquals(5.7, number, 0.001);

        assertEquals(true, stack.isEmpty());

        assertThrows(EmptyStackException.class, () -> {
            stack.peek();
        });
    }
}