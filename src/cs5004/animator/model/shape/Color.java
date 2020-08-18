package cs5004.animator.model.shape;

/**
 * This class represent a color of shape with RBG value.
 */
public class Color {
  private double r;
  private double g;
  private double b;

  /**
   * Construct a color with given rbg.
   *
   * @param r value for red.
   * @param g value for green.
   * @param b value for blue.
   */
  public Color(double r, double g, double b) {
    this.r = r;
    this.g = g;
    this.b = b;
  }

  /**
   * Return the value of red of the color.
   *
   * @return the value of red of the color.
   */
  public double getR() {
    return this.r;
  }

  /**
   * Return the value of green of the color.
   *
   * @return the value of green of the color.
   */
  public double getG() {
    return this.g;
  }

  /**
   * Return the value of blue of the color.
   *
   * @return the value of blue of the color.
   */
  public double getB() {
    return this.b;
  }

  /**
   * Set the red value of the color.
   *
   * @param r new value of r.
   */
  public void setR(double r) {
    this.r = r;
  }

  /**
   * Set the green value of the color.
   *
   * @param g new value of g.
   */
  public void setG(double g) {
    this.g = g;
  }

  /**
   * Set the blue value of the color.
   *
   * @param b new value of b.
   */
  public void setB(double b) {
    this.b = b;
  }
}
