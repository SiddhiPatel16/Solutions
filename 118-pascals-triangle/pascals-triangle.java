import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                // first or last element
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // sum of two numbers from previous row
                    int val = triangle.get(i - 1).get(j - 1) + 
                              triangle.get(i - 1).get(j);
                    row.add(val);
                }
            }

            triangle.add(row);
        }

        return triangle;
    }
}