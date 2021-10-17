package ua.lviv.iot;

import java.util.Arrays;

public class Container {
    private int[] array_for_sort;
    private final String order;
    private static int swap_counter;
    private static int comparisons_counter;

    Container(String order, String string_array){
        this.order = order;
        String[] string = string_array.split(",");
        array_for_sort = new int[string.length];
        for (int i = 0; i < string.length; i++)
            array_for_sort[i] = Integer.parseInt(string[i]);
    }

    private void swap(int i, int j) {
        int temp = array_for_sort[i];
        array_for_sort[i] = array_for_sort[j];
        array_for_sort[j] = temp;
    }

    public void generate_report() {
        Container.swap_counter = 0;
        Container.comparisons_counter = 0;
        long exe_time = System.nanoTime();
        Container.quick_sort(array_for_sort, order, 0, array_for_sort.length-1);
        System.out.print("Quick Sort");
        if (order.equals("asc"))
            System.out.println("(Ascending):");
        else
            System.out.println("(Descending):");
        System.out.println("Execution time: " + (System.nanoTime()- exe_time) + "ns" + "\n" +
                           "Comparisons: " + comparisons_counter + '\n' +
                           "Swaps: " + swap_counter + '\n' +
                           "Sorted array: ");
        print_array();


    }

    public void print_array() {
        System.out.println(Arrays.toString(array_for_sort));
    }

    public static int[] quick_sort(int[] array_for_sort, String order, int left, int right) {
        if (array_for_sort.length == 0)
            return array_for_sort;

        if (left >= right)
            return array_for_sort;

        int middle = left + (right - left) / 2;
        int pivot = array_for_sort[middle];

        int i = left, j = right;
        while (i <= j) {
            if (order.equals("asc")) {
                while (array_for_sort[i] < pivot) {
                    i++;
                    comparisons_counter++;
                }
                while (array_for_sort[j] > pivot) {
                    j--;
                    comparisons_counter++;
                }
            }
            if (order.equals("desc")) {
                while (array_for_sort[i] > pivot) {
                    i++;
                    comparisons_counter++;
                }
                while (array_for_sort[j] < pivot) {
                    j--;
                    comparisons_counter++;
                }
            }
            comparisons_counter = comparisons_counter + 2;
            if (i <= j) {
                if (i!=j) {
                    swap_counter++;
                    int temp = array_for_sort[i];
                    array_for_sort[i] = array_for_sort[j];
                    array_for_sort[j] = temp;
                }
                i++;
                j--;
            }
        }

        if (left < j)
            quick_sort(array_for_sort, order, left, j);

        if (right > i)
            quick_sort(array_for_sort, order, i, right);
        return array_for_sort;
    }
}
