package ua.lviv.iot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Ijones {
    public static Map<String, Integer> cache = new HashMap<>();
    private static Map<Integer, String> floor_ij = new HashMap<>();
    private static int width_ij;
    private static List<Integer> colsCounter = new ArrayList<>();

    public static int corridor(int curCol, int curRow, char curValue){
        if (curCol == 0){
            return 1;
        }

        List<Integer> cols = new ArrayList<>();
        List<Integer> rows = new ArrayList<>();
        for (int i = 0; i <= curCol; i++){
            String word = floor_ij.get(i);
            while (word.indexOf(curValue) > -1){
                int indexOfCurValue = word.indexOf(curValue);
                word = word.replaceFirst(String.valueOf(curValue), " ");
                if (i!=curCol-1 && indexOfCurValue!=curRow) {
                    if (i == curCol && (indexOfCurValue == 0 || indexOfCurValue == width_ij-1 || colsCounter.get(i)==1)) {
                        continue;
                    }
                    cols.add(i);
                    rows.add(indexOfCurValue);
                    if (i==curCol)
                        colsCounter.add(i, 1);
                }

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
        width_ij = width;
        int bound = floor.size();
        IntStream.range(0, bound).forEach(i -> colsCounter.add(0));
        return Ijones.corridorCache(floor.size()-1, 0, floor.get(floor.size()-1).charAt(0)) +
                Ijones.corridorCache(floor.size()-1, width-1, floor.get(floor.size()-1).charAt(width-1));
    }
}
