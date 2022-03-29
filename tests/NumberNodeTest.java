import at.htlleonding.NumberNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberNodeTest {
    @Test
    void testConstructorGettersAndSetters() {
        NumberNode node = new NumberNode(12.3);

        assertEquals(12.3, node.getNumber());
        assertEquals(null, node.getNext());

        NumberNode otherNode = new NumberNode(7);

        assertEquals(7, otherNode.getNumber());
        assertEquals(null, otherNode.getNext());

        node.setNext(otherNode);

        assertEquals(12.3, node.getNumber());
        assertEquals(otherNode, node.getNext());

        assertEquals(7, otherNode.getNumber());
        assertEquals(null, otherNode.getNext());
    }
}