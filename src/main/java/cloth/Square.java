package cloth;

public interface Square {
    default int getNumberOfSides() {
        return 4;
    }

    default double getPerimeter() {
        return getNumberOfSides() * getSide();
    }

    default double getArea() {
        return getSide()*getSide();
    }

    abstract double getSide();
}
