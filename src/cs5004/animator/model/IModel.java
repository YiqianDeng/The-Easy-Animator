package cs5004.animator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cs5004.animator.model.animation.IAnimation;
import cs5004.animator.model.shape.IShape;
import cs5004.animator.model.shape.TypeOfShape;

/**
 * This interface represents the operations offered by the animation model.
 */
public interface IModel {
  /**
   * Construct and add a new shape to the shapeList of the model.
   *
   * @param name  name of the shape.
   * @param type  type of the shape (rectangle, oval).
   * @param positionX x-coordinate position of the shape object.
   * @param positionY y-coordinate position of the shape object.
   * @param width the width/radius_x of the shape.
   * @param height  the height/radius_y of the shape.
   * @param r the red value of the color of shape.
   * @param g the green value of the color of shape.
   * @param b the blue value of the color of shape.
   * @param appears the appears time for the shape.
   * @param disappears  the disappears time for the shape.
   * @throws IllegalArgumentException if the name of shape has been used,or the initial value of
   *                                  shape is illegal.
   */
  void addShape(String name, TypeOfShape type, double positionX, double positionY,
                     double width, double height, double r, double g, double b, int appears,
                     int disappears) throws IllegalArgumentException;

  /**
   * Delete a existing shape.
   *
   * @param name  the name of shape that will be delete.
   * @throws IllegalArgumentException if the shape is not exist.
   */
  void removeShape(String name) throws IllegalArgumentException;

  /**
   * Move a single shape from it current position to another given position. A move is valid only if
   * the shape, to position, from time and to time are valid. Specific implementation may place
   * additional constrains on the validity of a move.
   *
   * @param name the name of the shape that will be move.
   * @param toX the x-coordinate position of the shape is going to move.
   * @param toY the y-coordinate position of the shape is going to move.
   * @param fromTime  the time of the move will begin.
   * @param toTime  the time of the move will end.
   * @throws IllegalArgumentException if any of the input is invalid.
   * @throws IllegalStateException  if any of the move is invalid, such as already exist .etc.
   */
  void move(String name, double fromX, double fromY, double toX, double toY, int fromTime,
            int toTime)
          throws IllegalArgumentException, IllegalStateException;

  /**
   * Change a single shape object's color from its current RGB color to another given RGB color.
   * A change color is valid only if the shape, the to RGB color, from time, and to time are valid.
   * Specific implementation may place additional constrains on the validity of a change color.
   *
   * @param name  the name of the shape that will be change color.
   * @param toR the red value of new RGB.
   * @param toG the green value of new RGB.
   * @param toB the blue value of new RGB.
   * @param fromTime  the time of the animation will begin.
   * @param toTime  the time of the animation will end.
   * @throws IllegalArgumentException if any of the input is invalid.
   * @throws IllegalStateException if any of the change color is invalid,
   *                                such as the animation has already exist .etc.
   */
  void changeColor(String name, double fromR, double fromG, double fromB, double toR, double toG,
                   double toB, int fromTime, int toTime)
          throws IllegalArgumentException, IllegalStateException;

  /**
   * Scale a single shape object from it's current size to another given size.
   * A scale is valid only if the shape, the new size of shape, from time and to time are valid.
   * Specific implementation may place additional constrains on the validity of a scale.
   *
   * @param name  the name of the shape that will be scale.
   * @param toWidth the new width/radius_x of the shape.
   * @param toHeight  the new height/radius_y of the shape.
   * @param fromTime  the time of the animation will begin.
   * @param toTime  the time of the animation will end.
   * @throws IllegalArgumentException if any of the input is invalid.
   * @throws IllegalStateException  if any of the scale is invalid, such as the animation has
   *                                already exist .etc.
   */
  void scale(String name, double fromWidth, double fromHeight, double toWidth, double toHeight,
             int fromTime, int toTime) throws IllegalArgumentException, IllegalStateException;

  /**
   * Return a string that represents the current status of shapes and animations.
   *
   * @return the status of all shapes and animations.
   */
  String getStatus();

  /**
   * Return the shapeList of the model.
   * @return the shapeList of the model, the shapeList contain all shapes we created before.
   */
  Map getShapeList();

  /**
   * return the animationList of the model.
   * @return the animationList of the model, the animationList contain all animations.
   */
  ArrayList getAnimationList();


  /**
   * Get all shapes that will perform action at current frame.
   *
   * @param frame the current frame, which corresponding to tick.
   * @return  a list of shape objects that will perform action at current frame.
   */
  List<IShape> getAllShapesAtFrame(int frame);

  List<IShape> getAllShapes();

  /**
   * Get all animation that will perform action at current frame.
   *
   * @param frame the current frame, which corresponding to tick.
   * @return  a list of animation objects that will perform action at current frame.
   */
  List<IAnimation> getAllAnimationAtFrame(int frame);

  /**
   * Set width and height of Canvas.
   *
   * @param width width of the canvas.
   * @param height height of the canvas.
   */
  void setCanvas(int width, int height);

  /**
   * Get canvas width.
   *
   * @return  canvas width.
   */
  int getCanvasWidth();

  /**
   * Get canvas height.
   *
   * @return canvas height.
   */
  int getCanvasHeight();
}
