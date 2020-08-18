package cs5004.animator.model.shape;

/**
 * This class represent a size of shape. This position is denoted in Cartesian size as (width,
 * height).
 */
public class Size {
  private double width;
  private double height;

  /**
   * Construct a size with the given width and height.
   *
   * @param width  the width of this point.
   * @param height the height of this point.
   */
  public Size(double width, double height) {
    this.width = width;
    this.height = height;
  }

  /**
   * Return the width of shape.
   *
   * @return the width of shape.
   */
  public double getWidth() {
    return width;
  }

  /**
   * Return the height of shape.
   *
   * @return the height of shape.
   */
  public double getHeight() {
    return height;
  }

  /**
   * Set the width of this shape.
   *
   * @param width new width of this shape.
   */
  public void setWidth(double width) {
    this.width = width;
  }

  /**
   * Set the height of this shape.
   *
   * @param height new height of this shape.
   */
  public void setHeight(double height) {
    this.height = height;
  }
}
