
interface Shape {
    void draw();
}


class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Ve hinh tron");
    }
}


class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Ve hinh vuong");
    }
}


abstract class ShapeFactory {
    
    public abstract Shape createShape();
}


class CircleFactory extends ShapeFactory {
    @Override
    public Shape createShape() {
        return new Circle();
    }
}


class SquareFactory extends ShapeFactory {
    @Override
    public Shape createShape() {
        return new Square();
    }
}


public class Main {
    public static void main(String[] args) {
        
        ShapeFactory circleFactory = new CircleFactory();
        Shape circle = circleFactory.createShape();
        circle.draw();

        
        ShapeFactory squareFactory = new SquareFactory();
        Shape square = squareFactory.createShape();
        square.draw();
    }
}
