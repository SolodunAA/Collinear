import edu.princeton.cs.algs4.StdDraw;

import java.util.Comparator;

public class Point implements Comparable<Point> {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw() {
        StdDraw.point(x, y);
    }

    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public int compareTo(Point that) {
        if (this == that || (this.y == that.y && this.x == that.x)) return 0;
        if (this.y < that.y) {
            return -1;
        }
        if (this.y == that.y && this.x < that.x) {
            return -1;
        }
        return 1;
    }

    public double slopeTo(Point that) {
        if (compareTo(that) == 0) return Double.NEGATIVE_INFINITY;
        if (this.y == that.y) return +0.0;
        if (this.x == that.x) return Double.POSITIVE_INFINITY;
        return (double) (that.y - this.y) / (that.x - this.x);
    }

    private class CompareSlopeOrder implements Comparator<Point> {
        public int compare(Point a, Point b) {

            double slopeA = slopeTo(a);
            double slopeB = slopeTo(b);

            if (slopeA > slopeB) return 1;
            if (slopeA < slopeB) return -1;
            return 0;
        }

    }

    public Comparator<Point> slopeOrder() {
        return new CompareSlopeOrder();
    }
}
