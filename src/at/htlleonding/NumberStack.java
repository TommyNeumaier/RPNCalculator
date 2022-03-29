package at.htlleonding;

import java.util.EmptyStackException;

public class NumberStack {
    private NumberNode head;

    public boolean isEmpty() {
        return this.head == null;
    }

    public double peek() {
        if(this.head != null) {
            return head.getNumber();
        }
        throw new EmptyStackException();
    }

    public double pop() {
        if (this.head != null) {
            NumberNode temp = this.head;
            this.head = this.head.getNext();
            return temp.getNumber();
        }
        throw new EmptyStackException();
    }

    public void push(double num) {
        NumberNode newNode = new NumberNode(num);
        newNode.setNext(head);
        head = newNode;
    }
}
