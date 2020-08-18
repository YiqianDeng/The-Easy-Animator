package cs5004.animator.model.animation;

import cs5004.animator.model.shape.IShape;

/**
 * This is the Abstract class which implement the IAnimation Interface.
 */
public abstract class AbstractAnimation implements IAnimation {
  protected int fromTime;
  protected int toTime;
  protected TypeOfAnimation type;
  protected IShape shape;

  /**
   * Construct a animation.
   *
   * @param shape    the shape object which will perform the animation.
   * @param type     the type of animation.
   * @param fromTime the start time of this animation.
   * @param toTime   the end time of this animation.
   * @throws IllegalArgumentException when input time is Illegal.
   */
  public AbstractAnimation(IShape shape, TypeOfAnimation type, int fromTime,
                           int toTime) throws IllegalArgumentException {
    if (fromTime < 0 || toTime < 0 || toTime <= fromTime) {
      throw new IllegalArgumentException("constructor input time is invalid.");
    }

    this.shape = shape;
    this.type = type;
    this.fromTime = fromTime;
    this.toTime = toTime;
  }

  /**
   * Get the start time of the animation.
   *
   * @return the start time of the animation.
   */
  @Override
  public int getFromTime() {
    return fromTime;
  }

  /**
   * Get the end time of the animation.
   *
   * @return the end time of the animation.
   */
  @Override
  public int getToTime() {
    return toTime;
  }

  /**
   * Get the type of the animation.
   *
   * @return type of animation.
   */
  @Override
  public TypeOfAnimation getType() {
    return type;
  }

  /**
   * Get the shape object which will pereform the animation.
   *
   * @return the shape object.
   */
  @Override
  public IShape getShape() {
    return this.shape;
  }
}
