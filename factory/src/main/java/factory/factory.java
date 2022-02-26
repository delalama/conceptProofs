package factory;

import factory.shape.ShapeFactory;

public class factory {
    public static void main(String[] args) {
        System.out.println("hola");

        String triangle = "triangle";
        String square = "square";

        ShapeFactory sf = new ShapeFactory();

        sf.getShape(triangle);
        sf.getShape(square);
    }
}
