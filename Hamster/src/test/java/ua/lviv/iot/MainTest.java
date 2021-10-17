package ua.lviv.iot;
import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    public Hamster[] hamsters;


    public void fillArrays(){
        hamsters = new Hamster[5];
        for (int i = 1; i < 6; i++){
            hamsters[i-1] = new Hamster(i, i);
        }
    }

    @Test
    public void testBuyHamsters(){
        fillArrays();
        Assert.assertEquals(4, Main.buy_hamsters(this.hamsters, 50));
    }

    @Test
    public void testBackupBuyHamsters(){
        fillArrays();
        Assert.assertEquals(4, BackupMain.buy_hamsters(this.hamsters, 50));
    }

}
