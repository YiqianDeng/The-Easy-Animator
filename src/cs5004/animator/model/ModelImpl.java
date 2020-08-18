package cs5004.animator.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cs5004.animator.model.animation.IAnimation;
import cs5004.animator.model.animation.ChangeColorAnimation;
import cs5004.animator.model.animation.MoveAnimation;
import cs5004.animator.model.animation.ScaleAnimation;
import cs5004.animator.model.shape.IShape;
import cs5004.animator.model.shape.Oval;
import cs5004.animator.model.shape.Rectangle;
import cs5004.animator.model.shape.TypeOfShape;

/**
 * This class represent a animation model, which represents the operations offered by the IModel
 * interface. This class has one shape list one animation list, the canvas width, and the canvas
 * height.
 */
public class ModelImpl implements IModel {
  // this HushMap store all created shapes.
  // where key is the name of shape and value is the IShape object.
  Map<String, IShape> shapeList;
  // This arrayList store all animations. And it is sorted by from time.
  ArrayList<IAnimation> animationList;
  // width and height of canvas.
  int canvasWidth;
  int canvasHeight;

  /**
   * Construct a modelImpl object by default.
   */
  public ModelImpl() {
    shapeList = new LinkedHashMap<String, IShape>();
    animationList = new ArrayList<>();
  }

  /**
   * Construct and add a new shape to the shapeList of the model.
   *
   * @param name       name of the shape.
   * @param type       type of the shape (rectangle, oval).
   * @param positionX  x-coordinate position of the shape object.
   * @param positionY  y-coordinate position of the shape object.
   * @param width      the width/radius_x of the shape.
   * @param height     the height/radius_y of the shape.
   * @param r          the red value of the color of shape.
   * @param g          the green value of the color of shape.
   * @param b          the blue value of the color of shape.
   * @param appears    the appears time for the shape.
   * @param disappears the disappears time for the shape.
   * @throws IllegalArgumentException if the name of shape has been used,or the initial value of
   *                                  shape is illegal.
   */
  @Override
  public void addShape(String name, TypeOfShape type, double positionX, double positionY,
                       double width, double height, double r, double g, double b, int appears,
                       int disappears) throws IllegalArgumentException {
    // check the name is already exist
    if (this.shapeList.containsKey(name)) {
      //throw new IllegalArgumentException("The name is exist");
      return;
    }

    // create shape
    if (type == TypeOfShape.rectangle) {
      IShape shape = new Rectangle(name, type, positionX, positionY, width, height, r, g, b,
              appears, disappears);
      // add to shapeList
      shapeList.put(shape.getName(), shape);
    } else if (type == TypeOfShape.oval) {
      IShape shape = new Oval(name, type, positionX, positionY, width, height, r, g, b, appears,
              disappears);
      // add to shapeList
      shapeList.put(shape.getName(), shape);
    } else {
      // invalid type
      throw new IllegalArgumentException("Invalid input type");
    }
  }

  /**
   * Delete a existing shape.
   *
   * @param name the name of shape that will be delete.
   * @throws IllegalArgumentException if the shape is not exist.
   */
  @Override
  public void removeShape(String name) throws IllegalArgumentException {
    // may be useful in the future
    // not going to implement now.
    if (!this.shapeList.containsKey(name)) {
      throw new IllegalArgumentException("shape not exist");
    }

    this.shapeList.remove(name);
  }


  /**
   * This private method simply add each animation to animationList in order by from time. Which
   * means this animationList is sorted by from time.
   *
   * @param newAnimation is the new animation which will be add to animation list.
   * @param fromTime     is the time this animation will start.
   */
  private void addToList(IAnimation newAnimation, int fromTime) {
    // if animationList is empty, add animation directly.
    if (this.animationList.size() == 0) {
      this.animationList.add(newAnimation);
      return;
    }

    // if animationList is not empty, loop and add by index.
    int index = 0;
    boolean added = false;
    for (IAnimation currAni : animationList) {
      if (fromTime < currAni.getFromTime()) {
        this.animationList.add(index, newAnimation);
        added = true;
        break;
      }
      index++;
    }

    // if animationList is not empty, and the new animation has latest from time, add to the end.
    if (!added) {
      this.animationList.add(newAnimation);
    }
  }


  /**
   * This method is use to check is there any overlap by animation run time.
   *
   * @param name         the name of shape which will perform this animation.
   * @param newAnimation the animation will be perform.
   * @return boolean value indicate the check pass or not.
   */
  private boolean passOverlapCheck(String name, IAnimation newAnimation) {
    // if animationList is empty

    if (animationList.size() == 0) {
      // no overlap for sure, pass the check.
      return false;
    }
    // animationList is not empty, loop through and check one by one.
    for (IAnimation currAni : animationList) {
      // this shape already has same type of action.
      if (currAni.getShape().getName().equals(name)
              && currAni.getType() == newAnimation.getType()) {

        if (newAnimation.getFromTime() < currAni.getToTime()
                && newAnimation.getToTime() > currAni.getFromTime()) {
          return true;
        }
      }
    }

    // finish loop and didn't return false mean there is no overlap.
    // pass the check.
    return false;
  }

  /**
   * This method is simply check the validation of the shape that will be perform actions and the
   * time the action will perform. This private method is use to prevent code duplication.
   *
   * @param name     the name of shape which will perform this animation.
   * @param fromTime the start time of the animation.
   * @param toTime   the end time of the animation.
   * @throws IllegalArgumentException when shape is null or input time invalid.
   */
  private void checkInput(String name, int fromTime, int toTime) throws IllegalArgumentException {

    // check the shape exist or not.
    if (shapeList.get(name) == null) {
      throw new IllegalArgumentException("the shape you are trying to move does not exist");
    }

    // check input time
    if (fromTime < 0 || toTime < 0 || fromTime > toTime) {
      throw new IllegalArgumentException("Illegal input time");
    }
  }

  /**
   * Move a single shape from it current position to another given position. A move is valid only if
   * the shape, to position, from time and to time are valid. Specific implementation may place
   * additional constrains on the validity of a move.
   *
   * @param name     the name of the shape that will be move.
   * @param toX      the x-coordinate position of the shape is going to move.
   * @param toY      the y-coordinate position of the shape is going to move.
   * @param fromTime the time of the move will begin.
   * @param toTime   the time of the move will end.
   * @throws IllegalArgumentException if any of the input is invalid.
   * @throws IllegalStateException    if any of the move is invalid, such as already exist .etc.
   */
  @Override
  public void move(String name, double fromX, double fromY, double toX, double toY, int fromTime,
                   int toTime) throws IllegalArgumentException, IllegalStateException {
    // checkInput, may throw IllegalArgumentException
    checkInput(name, fromTime, toTime);

    // extract shape
    IShape shape = shapeList.get(name);

    // generate newAnimation, may throw IllegalArgumentException
    IAnimation newAnimation = new MoveAnimation(shape, fromTime, toTime, fromX, fromY, toX, toY);

    // check overlap and animation is already exist.
    if (passOverlapCheck(name, newAnimation)) {
      // not pass overlap and same animation check, throw exception.
      //throw new IllegalStateException("Illegal animation");
      return;
    }

    // animation pass the check, add animation to sorted arrayList.
    addToList(newAnimation, fromTime);
  }

  /**
   * Change a single shape object's color from its current RGB color to another given RGB color. A
   * change color is valid only if the shape, the to RGB color, from time, and to time are valid.
   * Specific implementation may place additional constrains on the validity of a change color.
   *
   * @param name     the name of the shape that will be change color.
   * @param toR      the red value of new RGB.
   * @param toG      the green value of new RGB.
   * @param toB      the blue value of new RGB.
   * @param fromTime the time of the animation will begin.
   * @param toTime   the time of the animation will end.
   * @throws IllegalArgumentException if any of the input is invalid.
   * @throws IllegalStateException    if any of the change color is invalid, such as the animation
   *                                  has already exist .etc.
   */
  @Override
  public void changeColor(String name, double fromR, double fromG, double fromB, double toR,
                          double toG, double toB, int fromTime, int toTime)
          throws IllegalArgumentException, IllegalStateException {
    // checkInput, may throw IllegalArgumentException
    checkInput(name, fromTime, toTime);

    // extract shape
    IShape shape = shapeList.get(name);

    // generate newAnimation, may throw IllegalArgumentException
    IAnimation newAnimation = new ChangeColorAnimation(shape, fromTime, toTime,
            fromR, fromG, fromB, toR, toG, toB);

    // check overlap and animation is already exist.
    if (passOverlapCheck(name, newAnimation)) {
      // not pass overlap and same animation check, throw exception.
      //throw new IllegalStateException("Illegal animation");
      return;
    }

    // animation pass the check, add animation to sorted arrayList.
    addToList(newAnimation, fromTime);
  }

  /**
   * Scale a single shape object from it's current size to another given size. A scale is valid only
   * if the shape, the new size of shape, from time and to time are valid. Specific implementation
   * may place additional constrains on the validity of a scale.
   *
   * @param name     the name of the shape that will be scale.
   * @param toWidth  the new width/radius_x of the shape.
   * @param toHeight the new height/radius_y of the shape.
   * @param fromTime the time of the animation will begin.
   * @param toTime   the time of the animation will end.
   * @throws IllegalArgumentException if any of the input is invalid.
   * @throws IllegalStateException    if any of the scale is invalid, such as the animation has
   *                                  already exist .etc.
   */
  @Override
  public void scale(String name, double fromWidth, double fromHeight, double toWidth,
                    double toHeight, int fromTime, int toTime) throws IllegalArgumentException,
          IllegalStateException {
    // checkInput, may throw IllegalArgumentException
    checkInput(name, fromTime, toTime);

    // extract shape
    IShape shape = shapeList.get(name);

    // generate newAnimation, may throw IllegalArgumentException
    IAnimation newAnimation = new ScaleAnimation(shape, fromTime, toTime, fromWidth, fromHeight,
            toWidth, toHeight);

    // check overlap and animation is already exist.
    if (passOverlapCheck(name, newAnimation)) {
      // not pass overlap and same animation check, throw exception.
      //throw new IllegalStateException("Illegal animation");
      return;
    }

    // animation pass the check, add animation to sorted arrayList.
    addToList(newAnimation, fromTime);
  }

  /**
   * Return a string that represents the current status of shapes and animations.
   *
   * @return the status of all shapes and animations.
   */
  @Override
  public String getStatus() {
    // initial line output
    StringBuilder output = new StringBuilder("Shapes:\n");

    // add all shape output
    for (Map.Entry shape : shapeList.entrySet()) {
      Object value = shape.getValue();
      IShape eachShape = (IShape) value;
      output.append(shape.getValue().toString()).append("Appears at t=")
              .append(eachShape.getAppears()).append(", Disappears at t=")
              .append(eachShape.getDisappears()).append("\n\n");
    }

    // add all animation output
    for (IAnimation currAni : animationList) {
      output.append(currAni.toString()).append(", from time t=").append(currAni.getFromTime())
              .append(" to t=").append(currAni.getToTime());
    }

    return output.toString();
  }

  /**
   * Return the shapeList of the model.
   *
   * @return the shapeList of the model, the shapeList contain all shapes we created before.
   */
  @Override
  public Map getShapeList() {
    return this.shapeList;
  }

  /**
   * return the animationList of the model.
   *
   * @return the animationList of the model, the animationList contain all animations.
   */
  @Override
  public ArrayList getAnimationList() {
    return this.animationList;
  }

  /**
   * Get all shapes that will perform action at current frame.
   *
   * @param frame the current frame, which corresponding to tick.
   * @return a list of shape objects that will perform action at current frame.
   */
  @Override
  public List<IShape> getAllShapesAtFrame(int frame) {
    // loop through the map shapeList and check if frame >= appear and frame <= disappear.

    // create the list will return later
    ArrayList<IShape> shapesInCurrFrame = new ArrayList<>();

    // loop through the ShapeList
    for (IShape shape : shapeList.values()) {
      if (frame <= shape.getDisappears() && frame >= shape.getAppears()) {
        shapesInCurrFrame.add(shape);
      }
    }

    return shapesInCurrFrame;
  }

  @Override
  public List<IShape> getAllShapes() {
    ArrayList<IShape> allShapes = new ArrayList<>();

    // loop through the ShapeList
    for (IShape shape : shapeList.values()) {
        allShapes.add(shape);
    }

    return allShapes;
  }

  /**
   * Get all animation that will perform action at current frame.
   *
   * @param frame the current frame, which corresponding to tick.
   * @return a list of animation objects that will perform action at current frame.
   */
  @Override
  public List<IAnimation> getAllAnimationAtFrame(int frame) {
    ArrayList<IAnimation> animationsInCurrentFrame = new ArrayList<>();

    for (IAnimation animation : animationList) {
      if (animation.getFromTime() <= frame && animation.getToTime() > frame) {
        animationsInCurrentFrame.add(animation);
      }
    }

    return animationsInCurrentFrame;
  }

  /**
   * Set width and height of Canvas.
   *
   * @param width  width of the canvas.
   * @param height height of the canvas.
   */
  @Override
  public void setCanvas(int width, int height) {
    this.canvasWidth = width;
    this.canvasHeight = height;
  }

  /**
   * Get canvas width.
   *
   * @return canvas width.
   */
  @Override
  public int getCanvasWidth() {
    return this.canvasWidth;
  }

  /**
   * Get canvas height.
   *
   * @return canvas height.
   */
  @Override
  public int getCanvasHeight() {
    return this.canvasHeight;
  }
}
