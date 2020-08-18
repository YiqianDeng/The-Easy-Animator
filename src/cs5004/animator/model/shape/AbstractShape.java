package cs5004.animator.model.shape;

/**
 * This abstract class implement IShape interface, where represents the operation offered by a shape
 * object.
 */
public class AbstractShape implements IShape {
  protected Position position;
  protected Color color;
  protected Size size;
  protected String name;
  protected TypeOfShape type;
  protected int appears;
  protected int disappears;
  protected Position originalPosition;
  protected Color originalColor;
  protected Size originalSize;

  /**
   * Construct a shape object with following parameters.
   *
   * @param name       the name of shape object.
   * @param positionX  the x-coordinate of the shape's position.
   * @param positionY  the y-coordinate of the shape's position.
   * @param width      the width/radius_x of the shape.
   * @param height     the height/radius_y of the shape.
   * @param r          the red value of the color.
   * @param g          the green value of the color.
   * @param b          the blue value of the color.
   * @param appears    appears time of the object.
   * @param disappears the disappears time of the object.
   * @throws IllegalArgumentException when input position, color value, appears or disappear time is
   *                                  invalid.
   */
  public AbstractShape(String name, double positionX, double positionY,
                       double width, double height, double r, double g, double b, int appears,
                       int disappears) throws IllegalArgumentException {
    if (width < 0 || height < 0 || r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255
            || appears < 0 || disappears < 0) {
      throw new IllegalArgumentException("Invalid shape constructor input");
    }

    this.name = name;
    this.position = new Position(positionX, positionY);
    this.size = new Size(width, height);
    this.color = new Color(r, g, b);
    this.appears = appears;
    this.disappears = disappears;

    this.originalPosition = new Position(positionX, positionY);
    this.originalColor = new Color(r, g, b);
    this.originalSize = new Size(width, height);
  }

  /**
   * Get position(x, y) of a shape object.
   *
   * @return a Position object.
   */
  @Override
  public Position getPosition() {
    return this.position;
  }

  /**
   * Get color(r,g,b) of a shape object.
   *
   * @return the color of a shape object in (rgb) format.
   */
  @Override
  public Color getColor() {
    return this.color;
  }

  /**
   * Get the size(width, height) of this Ishape object.
   *
   * @return the
   */
  @Override
  public Size getSize() {
    return this.size;
  }

  /**
   * Get the name of the Shape object.
   *
   * @return the name of the shape object.
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * Get the type of the shape object.
   *
   * @return the type of the shape object.
   */
  @Override
  public TypeOfShape getTypeOfShape() {
    return this.type;
  }

  /**
   * Get the appears time of the shape.
   *
   * @return the appears time of the shape.
   */
  @Override
  public int getAppears() {
    return this.appears;
  }

  /**
   * Get the disappears time of the shape.
   *
   * @return the disappears time of the shape.
   */
  @Override
  public int getDisappears() {
    return this.disappears;
  }

  /**
   * Set the position to (x, y).
   *
   * @param x the x coordinate of new position.
   * @param y the y coordinate of new position.
   */
  @Override
  public void setPosition(double x, double y) {
    this.position.setX(x);
    this.position.setY(y);
  }

  @Override
  public void setOriginPos(double x, double y) {
    this.originalPosition.setX(x);
    this.originalPosition.setY(y);
  }

  /**
   * Set the color to (r, g, b).
   *
   * @param r the new red value.
   * @param g the new green value.
   * @param b the new blue value.
   */
  @Override
  public void setColor(double r, double g, double b) {
    this.color.setR(r);
    this.color.setG(g);
    this.color.setB(b);
  }

  @Override
  public void setOriginColor(double r, double g, double b) {
    this.originalColor.setR(r);
    this.originalColor.setG(g);
    this.originalColor.setB(b);
  }

  /**
   * Set the size to (width, height).
   *
   * @param width  the new width of the shape object.
   * @param height the new height of shape object.
   */
  @Override
  public void setSize(double width, double height) {
    this.size.setWidth(width);
    this.size.setHeight(height);
  }

  @Override
  public void setOriginSize(double width, double height) {
    this.originalSize.setWidth(width);
    this.originalSize.setHeight(height);
  }
  /**
   * Change the name of a shape object.
   *
   * @param name the new name of the shape object.
   */
  @Override
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Change the type of shape.
   *
   * @param type the new type of shape.
   */
  @Override
  public void setTypeOfShape(TypeOfShape type) {
    this.type = type;
  }


  /**
   * change the appear time of the shape object.
   *
   * @param appears new appear time of the shape object.
   */
  @Override
  public void setAppears(int appears) {
    this.appears = appears;
  }

  /**
   * change the disappears time of the shape object.
   *
   * @param disappears the new diappears time of the shape object.
   */
  @Override
  public void setDisappears(int disappears) {
    this.disappears = disappears;
  }

  /**
   * reset current status to original.
   */
  @Override
  public void resetToOriginal() {
    this.setSize(this.originalSize.getWidth(), this.originalSize.getHeight());
    this.setColor(this.originalColor.getR(), this.originalColor.getG(), this.originalColor.getB());
    this.setPosition(this.originalPosition.getX(), this.originalPosition.getY());
  }
}
