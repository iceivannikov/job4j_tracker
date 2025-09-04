package ru.job4j.algorithms;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        List<Integer> prevRow = new ArrayList<>();
        prevRow.add(1);
        result.add(prevRow);
        for (int i = 1; i < numRows; i++) {
            List<Integer> currRow = new ArrayList<>();
            prevRow = result.get(i - 1);
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    currRow.add(1);
                } else if (j == i) {
                    currRow.add(1);
                } else {
                    currRow.add(prevRow.get(j - 1) + prevRow.get(j));
                }
            }
            result.add(currRow);
        }
        return result;
    }
}
