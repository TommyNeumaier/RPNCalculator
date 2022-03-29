package at.htlleonding;

public class NumberNode {
    private double number;
    private NumberNode next;

    public NumberNode(double num) {
        this.setNumber(num);
    }

    public double getNumber() {
        return this.number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public void setNext(NumberNode next) {
        this.next = next;
    }

    public NumberNode getNext() {
        return next;
    }
}