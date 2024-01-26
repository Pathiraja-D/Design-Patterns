

interface Shape {
    void draw();
}

interface ShapeFactory {
    Shape getShape(String shapeType);
}

class Rectangle implements Shape{
    @Override
    public void draw(){
        System.out.println("Inside Rectangle::draw() method.");
    }
}

class Square implements Shape{
    @Override
    public void draw(){
        System.out.println("Inside Square::draw() method.");
    }
}

class Circle implements Shape{
    @Override
    public void draw(){
        System.out.println("Inside Circle::draw() method.");
    }
}

class CircleFactory implements ShapeFactory  {
    @Override
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        }
        return null;
    }
}

class RectangleFactory implements ShapeFactory  {
    @Override
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }
        return null;
    }
}

class SquareFactory implements ShapeFactory  {
    @Override
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}


public class FactoryPattern{
    public static void main(String[] args){
            SquareFactory squareFactory = new SquareFactory();
            Shape shape1 = squareFactory.getShape("SQUARE");
            shape1.draw();
            RectangleFactory rectangleFactory = new RectangleFactory();
            Shape shape2 = rectangleFactory.getShape("RECTANGLE");
            shape2.draw();
            CircleFactory circleFactory = new CircleFactory();
            Shape shape3 = circleFactory.getShape("CIRCLE");
            shape3.draw();
        
    }
}



