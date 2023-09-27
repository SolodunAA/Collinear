import java.awt.*;
import java.util.Arrays;

public class Main2 {

    public static void main(String[] args) {
        Point p1 = new Point(19000, 10000);
        Point p2 = new Point(18000, 10000);
        Point p3 = new Point(32000, 10000);
        Point p4 = new Point(21000, 10000);
        Point p5 = new Point(1234, 5678);
        Point p6 = new Point(14000, 10000);
        System.out.println("p1 = " + p1.toString() + " p2 = " + p2.toString() + " p1 ? p2 = " + p1.compareTo(p2));
        System.out.println("p1 = " + p1.toString() + " p2 = " + p2.toString() + " angle = " + p1.slopeTo(p2));
        Point[] points = new Point[6];

        points[0] = p1;
        points[1] = p2;
        points[2] = p3;
        points[3] = p4;
        points[4] = p5;
        points[5] = p6;
        System.out.println();

        for(int i = 0; i < points.length; i++) {
            System.out.println("p[" + i + "] = " + points[i] + " slope = " + p1.slopeTo(points[i]));
        }
        System.out.println();
        Arrays.sort(points, p1.slopeOrder());
        //Arrays.sort(points);
        for(int i = 0; i < points.length; i++) {
            System.out.println("p[" + i + "] = " + points[i].toString() + " slope = " + p1.slopeTo(points[i]));
        }

    }
}
