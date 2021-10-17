package ua.lviv.iot;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    static List<Integer> graph = new ArrayList<>();
    static List<List<Integer>> neighbours = new ArrayList<>();

    public static void main(String[] args){
        readFromFile("input.in");

        writeToFile(bfs());
    }

    public static void writeToFile(int result) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/output.in"));
            writer.write("The farthest vertex is " + bfs() + " steps away");

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

    public static int bfs(){

        //initializing auxiliary arrays
        boolean[] visited = new boolean[neighbours.size()];
        int[] distances = new int[neighbours.size()];
        List<Integer> queueToVisit = new ArrayList<>();

        queueToVisit.add(graph.get(0));

        while (!queueToVisit.isEmpty()){
            int idCurrent = graph.indexOf(queueToVisit.remove(0));

            for(int j = 0; j<neighbours.get(idCurrent).size(); j++){
                int idCurrentNeighbour = graph.indexOf(neighbours.get(idCurrent).get(j));

                if (visited[idCurrentNeighbour])
                    continue;

                distances[idCurrentNeighbour] = distances[idCurrent]+1;
                visited[idCurrentNeighbour] = true;
                queueToVisit.add(neighbours.get(idCurrent).get(j));
            }
        }
        return max(distances);
    }

    public static int max(int[] array){
        int max = array[0];
        for (int i: array){
            if (i>max)
                max = i;
        }
        return max;
    }
}
