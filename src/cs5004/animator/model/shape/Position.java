package cs5004.animator.model.shape;

/**
 * This class represent a 2D position. This position is denoted in Cartesian coordinates as (x,y).
 */
public class Position {
  private double x;
  private double y;

  /**
   * Construct a 2d position with the given coordinates.
   *
   * @param x the x-coordinate of this point.
   * @param y the y-coordinate of this point.
   */
  public Position(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Return the x-coordinate of this position.
   *
   * @return x-coordinate of this position.
   */
  public double getX() {
    return x;
  }

  /**
   * Return the y-coordinate of this position.
   *
   * @return y-coordinate of this position.
   */
  public double getY() {
    return y;
  }

  /**
   * Set the x-coordinate of this position.
   *
   * @param x new x-coordinate of this position.
   */
  public void setX(double x) {
    this.x = x;
  }

  /**
   * Set the y-coordinate of this position.
   *
   * @param y new y-coordinate of this position.
   */
  public void setY(double y) {
    this.y = y;
  }
}
