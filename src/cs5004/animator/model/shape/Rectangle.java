package cs5004.animator.model.shape;

/**
 * This class represent a Rectangle shape object.
 */
public class Rectangle extends AbstractShape {

  /**
   * Construct a rectangle shape object with following parameters.
   *
   * @param name       the name of the shape.
   * @param positionX  the x-coordinate position of this shape.
   * @param positionY  the y-coordinate position of this shape.
   * @param width      the width/radius_x of this shape.
   * @param height     the height/radius_y of this shape.
   * @param r          the red color value of the shape.
   * @param g          the green color value of the shape.
   * @param b          the blue color value of the shape.
   * @param appears    the appears time of this shape.
   * @param disappears the disappears time of this shape.
   */
  public Rectangle(String name, TypeOfShape type, double positionX, double positionY,
                   double width, double height, double r, double g, double b, int appears,
                   int disappears) {
    super(name, positionX, positionY, width, height, r, g, b, appears,
            disappears);

    this.type = TypeOfShape.rectangle;
  }

  /**
   * return a string representation of the rectangle object.
   *
   * @return a string representation of the rectangle object.
   */
  @Override
  public String toString() {
    return "Name: " + name + "\nType: " + type + "\nMin corner: ("
            + Double.toString(position.getX()) + "," + Double.toString(position.getY()) + "), "
            + "Width: " + Double.toString(size.getWidth()) + ", Height: "
            + Double.toString(size.getHeight()) + ", Color: (" + Double.toString(color.getR())
            + "," + Double.toString(color.getG()) + "," + Double.toString(color.getB()) + ")";
  }
}
