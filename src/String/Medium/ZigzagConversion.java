package String.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigzagConversion {
    public static void main(String[] args) {
        ZigzagConversion o = new ZigzagConversion();

        System.out.println(
                Arrays.toString(
                        new String[]{
                                o.convert("PAYPALISHIRING", 3),
                                o.convert("PAYPALISHIRING", 4),
                                o.convert("THEQUICKBROWNFOXJUMPSOVERTHELAZYDOG", 6)
                        }
                )
        );
        // [PAHNAPLSIIGYIR, PINALSIGYAHRPI, TOSZHRWPOAYEBNMVLDQKFUEEOUCOJRHGIXT]
    }

    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        List<StringBuilder> rows = new ArrayList<>();
        int currentRow = 0;
        boolean descending = false;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        for (char x : s.toCharArray()) {
            rows.get(currentRow).append(x);

            if (currentRow == 0 || currentRow == numRows - 1)
                descending = !descending;

            currentRow += descending ? 1 : -1;
        }

        for (StringBuilder row : rows)
            result.append(row);

        return result.toString();
    }
}

// https://leetcode.com/problems/zigzag-conversion/
