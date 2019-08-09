package coordinate;

import coordinate.domain.graph.Graph;
import coordinate.domain.point.Point;
import coordinate.domain.point.PointsGenerator;
import coordinate.domain.shape.Shape;
import coordinate.domain.shape.ShapeGenerator;
import coordinate.view.InputView;
import coordinate.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CoordinateCalculator {

    public static void main(String[] args) {
        List<Point> points = createPoints();
        Shape shape = createShape(points);
        Graph graph = new Graph();
        graph.drawPoints(points);
        OutputView.printGraph(graph);
        OutputView.printArea(shape);
    }

    private static List<Point> createPoints() {
        try {
            return PointsGenerator.generatePoints(InputView.inputCoordinate());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createPoints();
        }
    }

    private static Shape createShape(List<Point> points) {
        try {
            return ShapeGenerator.create(points);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            points = createPoints();
            return createShape(points);
        }
    }
}
