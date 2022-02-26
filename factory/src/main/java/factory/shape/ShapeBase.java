
package factory.shape;

public class ShapeBase implements Shape{
    String type;

    public ShapeBase(String type) {
        this.type = type;
        desc();
    }

    @Override public void desc() {
        System.out.println("I AM A " + type);
    }
}
