package ua.lviv.iot;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Main {
    static List<Integer> graph = new ArrayList<>();
    static List<List<Integer>> neighbours = new ArrayList<>();
    static Map<Integer, List<Integer>> graphe = new HashMap<>();

    public static void main(String[] args){
        readFromFile("input_second.in");

        writeToFile(bfs());
    }



    public static void writeToFile(int result) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/output.in"));
            writer.write("The farthest vertex is " + result + " steps away");

            writer.close();
        } catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    public static void readFromFile(String file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/" + file));
            String line = reader.readLine();

            graph.add(Integer.parseInt(line.split(" ")[1]));
            neighbours.add(new ArrayList<>());

            line = reader.readLine();
            while (line != null) {
                manageEdges(line);
                line = reader.readLine();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void manageEdges(String line) {
        int [] splitInt = Stream.of(line.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        if (!graph.contains(splitInt[0])){
            graph.add(splitInt[0]);
            neighbours.add(new ArrayList<>());
        }
        if (!graph.contains(splitInt[1])){
            graph.add(splitInt[1]);
            neighbours.add(new ArrayList<>());
        }
        neighbours.get(graph.indexOf(splitInt[0]))
                .add(splitInt[1]);
    }

    private static int bfs() {
        return 0;
    }
}
