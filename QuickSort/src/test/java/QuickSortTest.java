import org.junit.Assert;
import org.junit.Test;
import ua.lviv.iot.Container;

public class QuickSortTest {
    int[] result;

    @Test
    public void testQuickSort_Reg(){
        int[] input = {1, 2, 56, 45, -9, 78, 11};
        int[] result = {-9, 1, 2, 11, 45, 56, 78};
        Assert.assertArrayEquals(result, Container.quick_sort(input, "asc", 0, input.length-1));
    }

    @Test
    public void testQuickSort_AscToAsc(){
        int[] input = {-9, 1, 2, 11, 45, 56, 78};
        int[] result = {-9, 1, 2, 11, 45, 56, 78};
        Assert.assertArrayEquals(result, Container.quick_sort(input, "asc", 0, input.length-1));
    }

    @Test
    public void testQuickSort_AscToDesc(){
        int[] input = {-9, 1, 2, 11, 45, 56, 78};
        int[] result = {78, 56, 45, 11, 2, 1, -9};
        Assert.assertArrayEquals(result, Container.quick_sort(input, "desc", 0, input.length-1));
    }

    @Test
    public void testQuickSort_DescToAsc(){
        int[] input = {78, 56, 45, 11, 2, 1, -9};
        int[] result = {-9, 1, 2, 11, 45, 56, 78};
        Assert.assertArrayEquals(result, Container.quick_sort(input, "asc", 0, input.length-1));
    }
    @Test
    public void testQuickSort_DescToDesc(){
        int[] input = {78, 56, 45, 11, 2, 1, -9};
        int[] result = {78, 56, 45, 11, 2, 1, -9};
        Assert.assertArrayEquals(result, Container.quick_sort(input, "desc", 0, input.length-1));
    }
}
