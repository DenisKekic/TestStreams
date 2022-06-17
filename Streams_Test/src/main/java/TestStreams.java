import java.awt.*;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleConsumer;
import java.util.stream.Stream;

public class TestStreams {
    public static void main(String[] args) {

        final List<Point> points = Arrays.asList(
                new Point(-4,-8),
                new Point(-2, 9),
                new Point(-1,-8),
                new Point( 0,-7),
                new Point( 1, 1),
                new Point( 2, 3),
                new Point( 2, 3),
                new Point( 2,-2),
                new Point( 4,-1) );

        double result = points.stream().mapToDouble(point -> point.getX())
                .peek(x -> System.out.println(x + " "))
                .reduce(0,(x1, x2) -> x1 + x2);

        System.out.println(result);

        double sumY = points.stream().mapToDouble(point -> point.getY())
                .reduce(0,(y1, y2) -> y1 + y2);

        System.out.println("Summe" + sumY);

        //Ausgabe: Alle positiven x - Werte

        points.stream().filter(point -> point.getX() > 0)
                .forEach(point -> System.out.println(point + " "));

        Stream<Point> resultStream = Stream.concat(points.stream(),
                points.stream()
                        .filter(point -> point.getX() == 2)
                        .map(point -> new Point(point.x * 100, point.y * 10))
        );

    }
}
