package ua.lviv.iot;
import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    public void fillStatic(){
        Main.readFromFile("input_second.in");
    }

    @Test
    public void testBFS(){
        fillStatic();
        Assert.assertEquals(4, Main.bfs());
    }
}
