package ua.lviv.iot;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;

public class MainTest {

    @Test
    public void testBFS() throws IOException {
        String expected = "[1, 3, 5, 14]";
        String actual = Main.find("yb","rybybyb aboba yb").toString();
        Assert.assertArrayEquals(expected.toCharArray(), actual.toCharArray());
    }

}