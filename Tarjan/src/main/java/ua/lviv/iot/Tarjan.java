package ua.lviv.iot;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Tarjan {

    private static final Integer UNVISITED = -1;
    private static Integer id, SCCCount;
    private static int[] ids, low;
    private static boolean[] onStack;
    private static Stack<Integer> stack;
    private static Map<Integer, List<Integer>> graph;

    public static int[] findSCC(Map<Integer, List<Integer>> gr){
        id = 0;
        SCCCount = 0;
        graph = gr;
        int GRAPH_SIZE = graph.size();
        ids = new int[GRAPH_SIZE];
        low = new int[GRAPH_SIZE];
        onStack = new boolean[GRAPH_SIZE];
        stack = new Stack<>();
        for (int i = 0; i < GRAPH_SIZE; i++){
            ids[i] = UNVISITED;
        }
        for (int i = 0; i < GRAPH_SIZE; i++){
            if (ids[i] == UNVISITED){
                dfs(i);
            }
        }
        return low;
    }

    public static void dfs(int i){
        stack.push(i);
        onStack[i] = true;
        ids[i] = id;
        low[i] = id++;

        for (Integer dest: graph.get(i)){
            if(ids[dest] == UNVISITED)
                dfs(dest);
            if (onStack[dest])
                low[i] = Math.min(low[i], low[dest]);
        }

        if (ids[i] == low[i]){
            for (Integer ver = stack.pop(); ; ver = stack.pop()){
                onStack[ver] = false;
                low[ver] = ids[i];
                if (ver == i)
                    break;
            }
            SCCCount++;
        }
    }
}

