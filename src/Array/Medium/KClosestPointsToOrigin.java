package Array.Medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        KClosestPointsToOrigin o = new KClosestPointsToOrigin();

        int[][] points1 = new int[][]{
                new int[]{1, 3},
                new int[]{-2, 2}
        }, points2 = new int[][]{
                new int[]{3, 3},
                new int[]{5, -1},
                new int[]{-2, 4}
        };

        System.out.println(
                Arrays.deepToString(
                        new int[][][]{
                                o.kClosest(points1, 1),
                                o.kClosest(points2, 2)
                        }
                )
        );
        /*
            [
                [[-2, 2]],
                [[3, 3], [-2, 4]]
            ]
        */
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> queue = new PriorityQueue<>(new PointComparator());
        int[][] closestPoints = new int[k][2];

        for (int[] point : points)
            queue.add(new Point(point));

        for (int i = 0; i < k; i++)
            closestPoints[i] = queue.poll().points;

        return closestPoints;
    }

    public static class Point {
        private final double distanceFromOrigin;
        private final int[] points;

        public Point(int[] points) {
            this.points = points;
            this.distanceFromOrigin = euclidean(points, new int[]{0, 0});
        }

        private double euclidean(int[] points1, int[] points2) {
            return Math.sqrt(Math.pow(points2[0] - points1[0], 2) + Math.pow(points2[1] - points1[1], 2));
        }

        @Override
        public String toString() {
            return "Point{" +
                    "distanceFromOrigin=" + distanceFromOrigin +
                    ", points=" + Arrays.toString(points) +
                    '}';
        }
    }

    public static class PointComparator implements Comparator<Point> {
        @Override
        public int compare(Point o1, Point o2) {
            return Double.compare(o1.distanceFromOrigin, o2.distanceFromOrigin);
        }
    }
}

//  https://leetcode.com/problems/k-closest-points-to-origin
