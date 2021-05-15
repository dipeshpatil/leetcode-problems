package Array.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {
    public static void main(String[] args) {
        KidsWithTheGreatestNumberOfCandies o = new KidsWithTheGreatestNumberOfCandies();
        System.out.println(
                Arrays.toString(
                        o.kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3).toArray(new Boolean[0])
                )
        );
        // [true, true, true, false, true]
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int max = kidWithGreatestCandies(candies);
        for (int candie : candies)
            list.add(candie + extraCandies >= max);

        return list;
    }

    private int kidWithGreatestCandies(int[] candies) {
        int max = Integer.MIN_VALUE;
        for (int candie : candies)
            max = Math.max(max, candie);

        return max;
    }
}

/*
    https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
*/
