import org.junit.Assert;
import org.junit.Test;
import ua.lviv.iot.Main;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class MainTest {

    @Test
    public void testBFS() throws IOException {
        File file2 = new File("src/main/resources/output.in");
        File file1 = new File("src/main/resources/output_expected.in");
        Main.main(new String[]{});
        assertTrue("The files differ!", FileUtils.contentEquals(file1, file2));
    }

}
