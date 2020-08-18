package cs5004.animator.model.animation;

import cs5004.animator.model.shape.Color;
import cs5004.animator.model.shape.IShape;

/**
 * This class represent the changes color animation.
 */
public class ChangeColorAnimation extends AbstractAnimation {
  private Color fromColor;
  private Color toColor;

  /**
   * Construct a change color animation.
   *
   * @param shape    the shape object which will perform the animation.
   * @param fromTime the start time of this animation.
   * @param toTime   the end time of this animation.
   * @param fromR    the red value of RGB before change color.
   * @param fromG    thee green value of RGB before change color.
   * @param fromB    the blue value of RGB before change color.
   * @param toR      the blue value of RGB after change color.
   * @param toG      the green value of RGB after change color.
   * @param toB      the blue value of RGB after change color.
   * @throws IllegalArgumentException when input rgb value are invalid.
   */
  public ChangeColorAnimation(IShape shape, int fromTime, int toTime, double fromR, double fromG,
                              double fromB, double toR, double toG, double toB)
          throws IllegalArgumentException {
    super(shape, TypeOfAnimation.changeColor, fromTime, toTime);

    // check input
    if (toR < 0 || toR > 255 || toG < 0 || toG > 255 || toB < 0 || toB > 255) {
      throw new IllegalArgumentException("Illegal input color value");
    }

    this.fromColor = new Color(fromR, fromG, fromB);
    this.toColor = new Color(toR, toG, toB);
  }

  /**
   * The method which actually perform the change color animation.
   */
  @Override
  public void performAction() {
    this.shape.setColor(toColor.getR(), toColor.getG(), toColor.getB());
  }

  /**
   * Perform the animation action by 1 step. Where 1 step means full value / speed .
   *
   * @param speed the speed of animations.
   */
  @Override
  public void performActionByStep(int speed) {
    // calculate how many step in total
    int steps = Math.abs(this.toTime - this.fromTime);
    if (steps == 0) {
      return;
    }

    // calculate each step value changes
    double rChanges = (this.toColor.getR() - this.fromColor.getR()) / steps;
    double gChanges = (this.toColor.getG() - this.fromColor.getG()) / steps;
    double bChanges = (this.toColor.getB() - this.fromColor.getB()) / steps;

    // perform one step.
    this.shape.setColor(shape.getColor().getR() + rChanges, shape.getColor().getG() + gChanges,
            shape.getColor().getB() + bChanges);
  }

  /**
   * The string representation of a color animation.
   *
   * @return the string representation of a color animation.
   */
  @Override
  public String toString() {
    return "Shape " + this.shape.getName() + " changes color from ("
            + Double.toString(fromColor.getR()) + "," + Double.toString(fromColor.getG()) + ","
            + Double.toString(fromColor.getB()) + ") to (" + Double.toString(toColor.getR()) + ","
            + Double.toString(toColor.getG()) + "," + Double.toString(toColor.getB()) + ")";
  }
}
