package coordinate.domain.shape;

import coordinate.domain.point.Point;
import coordinate.domain.point.PointsGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShapeGeneratorTest {

    @Test
    public void 두개의_포인트가_입력됐을때_라인이_만들어지는지_테스트() {
        List<Point> points = Arrays.asList(
                new Point(10, 10),
                new Point(14, 15)
        );

        assertThat(ShapeGenerator.create(PointsGenerator.generatePoints("(10,10)-(14,15)")).area())
                .isEqualTo(new Line(points).area());
    }

    @Test
    public void 세개의_포인트가_입력됐을때_삼각형이_만들어지는지_테스트() {
        List<Point> points = new ArrayList<>(Arrays.asList(
                new Point(10, 10),
                new Point(14, 15),
                new Point(20, 8)
        ));

        assertThat(ShapeGenerator.create(PointsGenerator.generatePoints("(10,10)-(14,15)-(20,8)")).area())
                .isEqualTo(new Triangle(points).area());
    }

    @Test
    public void 네개의_포인트가_입력됐을때_직사각형이_만들어지는지_테스트() {
        List<Point> points = new ArrayList<>(Arrays.asList(
                new Point(10, 10),
                new Point(22, 10),
                new Point(22, 18),
                new Point(10, 18)
        ));

        assertThat(ShapeGenerator.create(PointsGenerator.generatePoints("(10,10)-(22,10)-(22,18)-(10,18)")).area())
                .isEqualTo(new Rectangle(points).area());
    }
}
