import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
    private final Point[] points;

    public FastCollinearPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException();
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) throw new IllegalArgumentException();
        }

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i != j && points[i].compareTo(points[j]) == 0) {
                    throw new IllegalArgumentException();
                }
            }
        }
        this.points = points;
    }

    public int numberOfSegments() {
        return segments().length;
    }

    public LineSegment[] segments() {
        LineSegment[] answ;
        ArrayList<LineSegment> seg = new ArrayList<LineSegment>();
        Point[] workingPoints = new Point[points.length];

        Arrays.sort(points);

        for (int i = 0; i < points.length; i++) {

            for (int m = 0; m < points.length; m++) {
                workingPoints[m] = points[m];
            }

            Arrays.sort(workingPoints, points[i].slopeOrder());
            int k = 0;
            for (int j = 1; j < workingPoints.length - 1; j++) {
                if (points[i].compareTo(workingPoints[j]) < 0 &&
                        points[i].compareTo(workingPoints[j + 1]) < 0
                        && points[i].slopeTo(workingPoints[j]) == points[i].slopeTo(workingPoints[j + 1])) {
                    k = k + 1;
                } else {
                    if (k >= 2&& j + k / 2 - 1 < workingPoints.length) {
                        seg.add(new LineSegment(points[i], workingPoints[j + k / 2 - 1]));
                    }

                    k = 0;
                }

            }
            if (k >= 2) {
                seg.add(new LineSegment(points[i], workingPoints[workingPoints.length - 1]));
            }
        }
        answ = new LineSegment[seg.size()];
        for (int m = 0; m < seg.size(); m++) {
            answ[m] = seg.get(m);
        }
        return answ;
    }

}
