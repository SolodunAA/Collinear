import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {


    private final Point[] points;

    public BruteCollinearPoints(Point[] points) {

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
        ArrayList<LineSegment> segm = new ArrayList<LineSegment>();
        Point[] points4 = new Point[4];
        for (int i1 = 0; i1 < points.length; i1++) {
            for (int i2 = i1 + 1; i2 < points.length; i2++) {
                for (int i3 = i2 + 1; i3 < points.length; i3++) {
                    for (int i4 = i3 + 1; i4 < points.length; i4++) {
                        if (points[i1].slopeTo(points[i2]) ==
                                points[i1].slopeTo(points[i3]) &&
                                points[i1].slopeTo(points[i2]) ==
                                        points[i1].slopeTo(points[i4])) {
                            points4[0] = points[i1];
                            points4[1] = points[i2];
                            points4[2] = points[i3];
                            points4[3] = points[i4];
                            Arrays.sort(points4);
                            segm.add(new LineSegment(points4[0], points4[3]));

                        }
                    }
                }
            }
        }


        LineSegment[] answer = new LineSegment[segm.size()];
        for (int i = 0; i < segm.size(); i++) {
            answer[i] = segm.get(i);
        }
        return answer;
    }

}
