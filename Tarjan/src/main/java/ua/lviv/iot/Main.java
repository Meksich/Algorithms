package ua.lviv.iot;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static Map<Integer, List<Integer>> graph = new HashMap<>();

    public static void main(String[] args){
        readFromFile("input.in");

        writeToFile(Tarjan.findSCC(graph));
    }



    public static void writeToFile(int[] result) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/output.in"));
            Map<Integer, List<Integer>> scc = new HashMap<>();
            for (int i = 0; i < result.length; i++){
                if (!scc.containsKey(result[i])){
                    scc.put(result[i], new ArrayList<>());
                }
                scc.get(result[i]).add(i);
            }
            writer.write("Number of strongly connected components is " + scc.size());
            for (Integer comp: scc.keySet()){
                writer.write("\nStrongly connected components line: " + scc.get(comp));
            }

            writer.close();
        } catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    public static void readFromFile(String file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/" + file));
            String line = reader.readLine();
            graph.put(Integer.parseInt(line.split(" ")[1]), new ArrayList<>());

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
        if (!graph.containsKey(splitInt[0]))
            graph.put(splitInt[0], new ArrayList<>());

        if (!graph.containsKey(splitInt[1]))
            graph.put(splitInt[1], new ArrayList<>());

        graph.get(splitInt[0]).add(splitInt[1]);
    }
}
