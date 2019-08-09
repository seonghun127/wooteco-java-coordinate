package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShapeGeneratorTest {

    @Test
    public void 두개의_포인트가_입력됐을때_라인이_만들어지는지_테스트() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(new Coordinate(10), new Coordinate(10)));
        points.add(new Point(new Coordinate(14), new Coordinate(15)));

        assertThat(new ShapeGenerator().create(PointsGenerator.generatePoints("(10,10)-(14,15)"))).isEqualTo(new Line(points));
    }

    @Test
    public void 세개의_포인트가_입력됐을때_삼각형이_만들어지는지_테스트() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(new Coordinate(10), new Coordinate(10)));
        points.add(new Point(new Coordinate(14), new Coordinate(15)));
        points.add(new Point(new Coordinate(20), new Coordinate(8)));

        assertThat(new ShapeGenerator().create(PointsGenerator.generatePoints("(10,10)-(14,15)-(20,8)"))).isEqualTo(new Triangle(points));
    }

    @Test
    public void 네개의_포인트가_입력됐을때_직사각형이_만들어지는지_테스트() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(new Coordinate(10), new Coordinate(10)));
        points.add(new Point(new Coordinate(22), new Coordinate(10)));
        points.add(new Point(new Coordinate(22), new Coordinate(18)));
        points.add(new Point(new Coordinate(10), new Coordinate(18)));

        assertThat(new ShapeGenerator().create(PointsGenerator.generatePoints("(10,10)-(22,10)-(22,18)-(10,18)"))).isEqualTo(new Rectangle(points));
    }
}
