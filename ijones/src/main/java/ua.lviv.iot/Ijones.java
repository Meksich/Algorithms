package ua.lviv.iot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ijones {
    public static Map<String, Integer> cache = new HashMap<>();
    private static Map<Integer, String> floor_ij = new HashMap<>();

    public static int corridor(int curCol, int curRow, char curValue){
        if (curCol == 0){
            return 1;
        }

        List<Integer> cols = new ArrayList<>();
        List<Integer> rows = new ArrayList<>();
        for (int i = 0; i < curCol; i++){
            String word = floor_ij.get(i);
            while (word.indexOf(curValue) > -1){
                if (i!=curCol-1 && word.indexOf(curValue)!=curRow) {
                    cols.add(i);
                    rows.add(word.indexOf(curValue));
                }
                word = word.replaceFirst(String.valueOf(curValue), " ");
            }
        }
        int result = 0;
        for (int i = 0; i < cols.size(); i++)
            result += corridorCache(cols.get(i), rows.get(i), curValue);
        result += corridorCache(curCol-1, curRow, floor_ij.get(curCol-1).charAt(curRow));
        return result;
    }

    public static int corridorCache(int curCol, int curRow, char curValue){
        String step = String.valueOf(curRow);
        step += String.valueOf(curCol);
        if (!cache.containsKey(step)){
            cache.put(step, corridor(curCol, curRow, curValue));
        }
        return cache.get(step);
    }

    public static int goAhead(Map<Integer, String> floor, int width){
        floor_ij = floor;
        return Ijones.corridorCache(floor.size(), 0, floor.get(floor.size()-1).charAt(0)) +
                Ijones.corridorCache(floor.size(), width-1, floor.get(floor.size()-1).charAt(width-1));
    }
}
