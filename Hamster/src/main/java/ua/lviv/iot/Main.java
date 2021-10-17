package ua.lviv.iot;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer foodPackagesNumber;
        Integer hamstersNumber;
        Hamster[] hamsters;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/main/resources/input.txt"));
            foodPackagesNumber = Integer.parseInt(reader.readLine());
            hamstersNumber = Integer.parseInt(reader.readLine());
            hamsters = new Hamster[hamstersNumber];
            String line = reader.readLine();
            int i = 0;
            while (line != null) {
                String[] daily_and_avarice = line.split(" ");
                hamsters[i++] = new Hamster(Integer.parseInt(daily_and_avarice[0]),
                        Integer.parseInt(daily_and_avarice[1]));
                line = reader.readLine();
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/output.txt"));
            writer.write("We can buy " + buy_hamsters(hamsters, foodPackagesNumber) + " hamsters");

            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static int buy_hamsters(Hamster[] hamsters, Integer foodPackagesNumber) {
        Integer total_consumption;
        Integer buy = hamsters.length;
        while (buy >= 0) {
            total_consumption = 0;
            Arrays.sort(hamsters, new HamsterConsumptionComparator(buy-1));
            for (int i = 0; i < buy; i++)
                total_consumption += hamsters[i].count_hamster_consumption(buy - 1);
            if (total_consumption < foodPackagesNumber)
                break;
            buy--;
        }
        return buy;
    }
}
