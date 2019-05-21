package coordinate.domain;

import java.util.Objects;

public class Point {
    private Coordinate xCoordinate;
    private Coordinate yCoordinate;

    public Point(Coordinate xCoordinate, Coordinate yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getDistanceX(Point pointB) {
        return pointB.getSubtractionX(this.xCoordinate);
    }

    private int getSubtractionX(Coordinate xCoordinate) {
        return this.xCoordinate.getDistance(xCoordinate);
    }

    public int getDistanceY(Point pointB) {
        return pointB.getSubtractionY(this.yCoordinate);
    }

    private int getSubtractionY(Coordinate yCoordinate) {
        return this.yCoordinate.getDistance(yCoordinate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(xCoordinate, point.xCoordinate) &&
                Objects.equals(yCoordinate, point.yCoordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate);
    }
}