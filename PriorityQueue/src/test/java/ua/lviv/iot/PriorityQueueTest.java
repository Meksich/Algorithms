package ua.lviv.iot;
import org.junit.Assert;
import org.junit.Test;

public class PriorityQueueTest {
    Element[] expectedResult = new Element[4];
    PriorityQueue pq = new PriorityQueue();

    public void fillArrays(){
        for (int i = 1; i < 4; i++) {
            pq.add(i, i);
            expectedResult[i - 1] = new Element(i, i);
        }
    }

    @Test
    public void testAdd(){
        fillArrays();
        String[] expected = new String[4];
        String[] actualResult = new String[4];
        for (int i = 0; i < 3; i++){
            expected[i] = expectedResult[i].toString();
            actualResult[i] = pq.getHeap()[i].toString();
        }
        Assert.assertArrayEquals(expected, actualResult);
    }

    @Test
    public void testPoll(){
        fillArrays();
        Assert.assertEquals(expectedResult[0].toString(), pq.poll().toString());
    }

    @Test
    public void testPeek(){
        fillArrays();
        Assert.assertEquals(expectedResult[0].toString(), pq.peek().toString());
    }
}
