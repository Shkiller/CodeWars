import com.sun.source.tree.Tree;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class ClosestPairOfPointsInLinearithmicTime {
    public static void main(String[] args) {

        TreeSet<Point> tree = new TreeSet<>(Comparator.comparing(p -> Math.sqrt(p.x*p.x+p.y*p.y)));



        List<Point> points = Arrays.asList(
                 //A
                new Point(2, 8), //B
                new Point(5, 5), //C
                 //D
                new Point(6, 7),
                new Point(2, 2),//E
                new Point(7, 4),
                new Point(6, 3),//F
                new Point(7, 9)  //G
        );

        tree.addAll(points);

        points.sort(Comparator.comparing(point -> point.x));





//        tree.forEach(System.out::println);
        System.out.println(101 %4);
    }
}
