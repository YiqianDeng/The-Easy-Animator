package cs5004.animator.model.animation;

import cs5004.animator.model.shape.IShape;
import cs5004.animator.model.shape.Position;

/**
 * This class represent the move animation.
 */
public class MoveAnimation extends AbstractAnimation {
  private Position fromPosition;
  private Position toPosition;

  /**
   * Construct a move animation with following input.
   *
   * @param shape    the shape object will perform this animation.
   * @param fromTime the start time of this animation.
   * @param toTime   the end time of this animation.
   * @param fromX    the x-coordinate position before move.
   * @param fromY    the y-coordinate position before move.
   * @param toX      the x-coordinate position after move.
   * @param toY      the y-coordinate position after move.
   */
  public MoveAnimation(IShape shape, int fromTime, int toTime, double fromX,
                       double fromY, double toX, double toY) {
    super(shape, TypeOfAnimation.move, fromTime, toTime);

    this.fromPosition = new Position(fromX, fromY);
    this.toPosition = new Position(toX, toY);
  }

  /**
   * The method which actually perform the move animation.
   */
  @Override
  public void performAction() {
    shape.setPosition(toPosition.getX(), toPosition.getY());
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
    double xChanges = (this.toPosition.getX() - this.fromPosition.getX()) / steps;
    double yChanges = (this.toPosition.getY() - this.fromPosition.getY()) / steps;

    // perform one step.
    this.shape.setPosition(shape.getPosition().getX() + xChanges,
            shape.getPosition().getY() + yChanges);
  }

  /**
   * The string representation of a move animation.
   *
   * @return the string representation of a move animation.
   */
  @Override
  public String toString() {
    return "Shape " + this.shape.getName() + " moves from (" + Double.toString(fromPosition.getX())
            + "," + Double.toString(fromPosition.getY()) + ") to ("
            + Double.toString(toPosition.getX()) + "," + Double.toString(toPosition.getY())
            + ")";
  }
}
