package String.Easy;

import java.util.Arrays;

public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        ExcelSheetColumnTitle o = new ExcelSheetColumnTitle();

        System.out.println(
                Arrays.toString(
                        new String[]{
                                o.convertToTitle(1),
                                o.convertToTitle(28),
                                o.convertToTitle(701),
                                o.convertToTitle(2147483647)
                        }
                )
        );

        // [A, AB, ZY, FXSHRXW]
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;
            int val = columnNumber % 26;
            result.append((char) (val + 'A'));
            columnNumber /= 26;
        }

        return result.reverse().toString();
    }
}

// https://leetcode.com/problems/excel-sheet-column-title/
