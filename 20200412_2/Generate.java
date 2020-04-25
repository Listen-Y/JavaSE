/**
 * 杨辉三角
 */

import java.util.ArrayList;
import java.util.List;

public class Generate {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows <= 0) {
            return result;
        }
        List<Integer> firstLin = new ArrayList<>();
        firstLin.add(1);
        result.add(firstLin);
        if(numRows == 1) {
            return result;
        }
        List<Integer> secondLin = new ArrayList<>();
        secondLin.add(1);
        secondLin.add(1);
        result.add(secondLin);
        if(numRows == 2) {
            return result;
        }
        for(int row = 3; row <= numRows; row ++) {
            List<Integer> lin = new ArrayList<>();
            lin.add(1);
            for(int col = 1; col < row - 1; col ++) {
                List<Integer> prevLin = result.get(row - 1 - 1);
                lin.add(prevLin.get(col - 1) + prevLin.get(col));
            }
            lin.add(1);
            result.add(lin);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = generate(5);
        System.out.println(result);
    }
}