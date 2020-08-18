package cs5004.animator.model.animation;

import cs5004.animator.model.shape.IShape;


/**
 * This interface represents the operation offered by animation object.
 */
public interface IAnimation {
  /**
   * Get the from time of this animation.
   *
   * @return the from time of this animation.
   */
  public int getFromTime();

  /**
   * Get the to time of this animation.
   *
   * @return the to time of this animation.
   */
  public int getToTime();

  /**
   * Get the type of the animation.
   *
   * @return the type of the animation.
   */
  public TypeOfAnimation getType();

  /**
   * Get the IShape object of the animation.
   *
   * @return the IShape object.
   */
  public IShape getShape();

  /**
   * Perform the animation action (move, scale, or change color).
   */
  public void performAction();

  /**
   * Perform the animation action by 1 step. Where 1 step means full value / speed .
   *
   * @param speed the speed of animations.
   */
  public void performActionByStep(int speed);

  /**
   * Return the string representation of the animation.
   *
   * @return the string representation of the animation.
   */
  public String toString();
}
