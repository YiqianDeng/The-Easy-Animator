package cs5004.animator.model.shape;

/**
 * This interface represents the operation offered by IShape object.
 */
public interface IShape {

  /**
   * Get position(x, y) of a shape object.
   *
   * @return a Position object.
   */
  Position getPosition();

  /**
   * Get color(r,g,b) of a shape object.
   *
   * @return the color of a shape object in (rgb) format.
   */
  Color getColor();

  /**
   * Get the size(width, height) of this Ishape object.
   *
   * @return the
   */
  Size getSize();

  /**
   * Get the name of the Shape object.
   *
   * @return the name of the shape object.
   */
  String getName();

  /**
   * Get the type of the shape object.
   *
   * @return the type of the shape object.
   */
  TypeOfShape getTypeOfShape();

  /**
   * Get the appears time of the shape.
   *
   * @return the appears time of the shape.
   */
  int getAppears();

  /**
   * Get the disappears time of the shape.
   *
   * @return the disappears time of the shape.
   */
  int getDisappears();

  /**
   * Set the position to (x, y).
   *
   * @param x the x coordinate of new position.
   * @param y the y coordinate of new position.
   */
  void setPosition(double x, double y);

  /**
   * Set the color to (r, g, b).
   *
   * @param r the new red value.
   * @param g the new green value.
   * @param b the new blue value.
   */
  void setColor(double r, double g, double b);

  /**
   * Set the size to (width, height).
   *
   * @param width  the new width of the shape object.
   * @param height the new height of shape object.
   */
  void setSize(double width, double height);

  /**
   * Change the name of a shape object.
   *
   * @param name the new name of the shape object.
   */
  void setName(String name);

  /**
   * Change the type of shape.
   *
   * @param type the new type of shape.
   */
  void setTypeOfShape(TypeOfShape type);

  /**
   * change the appear time of the shape object.
   *
   * @param appears new appear time of the shape object.
   */
  void setAppears(int appears);

  /**
   * change the disappears time of the shape object.
   *
   * @param disappears the new diappears time of the shape object.
   */
  void setDisappears(int disappears);

  /**
   * return a string representation of a shape object.
   *
   * @return a string representation of a shape object.
   */
  String toString();

  /**
   * Set the origin position.
   *
   * @param x origin x.
   * @param y origin y.
   */
  void setOriginPos(double x, double y);

  /**
   * Set the origin color.
   *
   * @param r origin r.
   * @param g origin g.
   * @param b origin b.
   */
  void setOriginColor(double r, double g, double b);

  /**
   * Set the origin size.
   * @param w origin width.
   * @param h origin height.
   */
  void setOriginSize(double w, double h);

  /**
   * reset current status to original.
   */
  void resetToOriginal();
}
