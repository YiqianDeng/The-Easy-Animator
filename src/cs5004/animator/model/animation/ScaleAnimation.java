package cs5004.animator.model.animation;

import cs5004.animator.model.shape.IShape;
import cs5004.animator.model.shape.Size;

/**
 * This class represent a animation.scale of shape with RBG value.
 */
public class ScaleAnimation extends AbstractAnimation {
  private Size fromSize;
  private Size toSize;

  /**
   * Construct a scale animation with certain input.
   *
   * @param shape      the shape object will perform this animation.
   * @param fromTime   the start time of this animation.
   * @param toTime     the end time of this animation.
   * @param fromWidth  the width before scale.
   * @param fromHeight the height before scale.
   * @param toWidth    the width after scale.
   * @param toHeight   the height after scale.
   * @throws IllegalArgumentException when input width/height are invalid.
   */
  public ScaleAnimation(IShape shape, int fromTime, int toTime, double fromWidth,
                        double fromHeight, double toWidth, double toHeight)
          throws IllegalArgumentException {
    super(shape, TypeOfAnimation.scale, fromTime, toTime);

    // check input
    if (toWidth <= 0 || toHeight <= 0) {
      throw new IllegalArgumentException("Illegal input width or height");
    }

    this.fromSize = new Size(fromWidth, fromHeight);
    this.toSize = new Size(toWidth, toHeight);
  }

  /**
   * The method which actually perform the move animation.
   */
  @Override
  public void performAction() {
    this.shape.setSize(toSize.getWidth(), toSize.getHeight());
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
    double weightChanges = (this.toSize.getWidth() - this.fromSize.getWidth()) / steps;
    double heightChanges = (this.toSize.getHeight() - this.fromSize.getHeight()) / steps;

    // perform one step.
    this.shape.setSize(shape.getSize().getWidth() + weightChanges,
            shape.getSize().getHeight() + heightChanges);
  }

  /**
   * The string representation of a move animation.
   *
   * @return the string representation of a move animation.
   */
  @Override
  public String toString() {
    return "Shape " + this.shape.getName() + " scales from Width: "
            + Double.toString(fromSize.getWidth()) + ", Height: "
            + Double.toString(fromSize.getHeight()) + " to Width: "
            + Double.toString(toSize.getWidth()) + ", Height: "
            + Double.toString(toSize.getHeight());
  }
}
