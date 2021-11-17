package ua.lviv.iot;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<Integer, String> floor = new HashMap<>();
    private static int height, width;

    public static void main(String[] args) {
        readFromFile("input.in");

        writeToFile(12);
    }

    public static void writeToFile(int result) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/output.out"));
            writer.write("Indiana can go " + Ijones.goAhead(floor, width) + " different ways");

            writer.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void readFromFile(String file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/" + file));
            String line = reader.readLine();
            width = Integer.parseInt(line.split(" ")[0]);
            width = Integer.parseInt(line.split(" ")[1]);
            line = reader.readLine();
            int i = 0;
            while (line != null) {
                floor.put(i++, line);
                line = reader.readLine();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
