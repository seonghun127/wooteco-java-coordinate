package coordinate.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ShapeGenerator {
    private static final int SIZE_OF_POINTS_FOR_LINE = 2;
    private static final int SIZE_OF_POINTS_FOR_TRIANGLE = 3;
    private static final int SIZE_OF_POINTS_FOR_RECTANGLE = 4;

    private static final Map<Integer, Function<List<Point>, Shape>> shapeMapper;

    static {
        shapeMapper = new HashMap<>();
        shapeMapper.put(SIZE_OF_POINTS_FOR_LINE, Line::new);
        shapeMapper.put(SIZE_OF_POINTS_FOR_TRIANGLE, Triangle::new);
        shapeMapper.put(SIZE_OF_POINTS_FOR_RECTANGLE, Rectangle::new);
    }

    public static Shape create(List<Point> points) {
        return shapeMapper.get(points.size()).apply(points);
    }
}
