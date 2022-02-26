/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package factory.shape;

public class ShapeFactory {
    String TRIANGLE = "triangle";
    String SQUARE = "square";

    public ShapeFactory() {
    }

    public Shape getShape(String type) {
        switch (type) {
            case "triangle": return new Triangle(TRIANGLE);
            case "square": return new Square(SQUARE);
            default: return null;
        }
    }
}
