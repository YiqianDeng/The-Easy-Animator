package cs5004.animator.model.shape;

/**
 * This class represent a Oval shape class.
 */
public class Oval extends AbstractShape {

  /**
   * Construct a Oval shape object with following parameters.
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
  public Oval(String name, TypeOfShape type, double positionX, double positionY,
              double width, double height, double r, double g, double b, int appears,
              int disappears) {
    super(name, positionX, positionY, width, height, r, g, b, appears, disappears);

    this.type = TypeOfShape.oval;
  }

  /**
   * return a string representation of the oval object.
   *
   * @return a string representation of the oval object.
   */
  @Override
  public String toString() {
    return "Name: " + name + "\nType: " + type + "\nCenter: (" + Double.toString(position.getX())
            + "," + Double.toString(position.getY()) + "), " + "X radius: "
            + Double.toString(size.getWidth()) + ", Y radius: " + Double.toString(size.getHeight())
            + ", Color: (" + Double.toString(color.getR()) + "," + Double.toString(color.getG())
            + "," + Double.toString(color.getB()) + ")";
  }
}
