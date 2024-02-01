package FactoryPattern;

class Shape {
    void draw(){
        System.out.println("Inside Shape::draw() method.");
    }
}

class Rectangle extends Shape{
    @Override
    public void draw(){
        System.out.println("Inside Rectangle::draw() method.");
    }
}

class Square extends Shape{
    @Override
    public void draw(){
        System.out.println("Inside Square::draw() method.");
    }
}

class Circle extends Shape{
    @Override
    public void draw(){
        System.out.println("Inside Circle::draw() method.");
    }
}

class ShapeFactory{
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}



public class AbstractFactoryPattern {
    public static void main(String[] args){
            ShapeFactory shapeFactory = new ShapeFactory();
            Shape shape1 = shapeFactory.getShape("CIRCLE");
            shape1.draw();
        
    }
}
