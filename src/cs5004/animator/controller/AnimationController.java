package cs5004.animator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.Timer;

import cs5004.animator.model.IModel;
import cs5004.animator.model.animation.IAnimation;
import cs5004.animator.model.shape.IShape;
import cs5004.animator.view.IView;


/**
 * This class represents the operations offered by the IController. One object of the model
 * represents the animation controller of the whole animator.
 */
public class AnimationController implements IController {

  private final Timer timer;
  int currentFrame;
  int maxFrame;
  IModel model;


  /**
   * Construct a animation controller with given model, animationView, and speed.
   *
   * @param model         The implementation class of IController.
   * @param animationView The implementation class of IView.
   * @param speed         The speed that user input in.
   */
  public AnimationController(IModel model, IView animationView, int speed) {
    currentFrame = 0;
    maxFrame = 0;

    this.model = model;

    // get maxFrame
    for (Object shape : model.getShapeList().values()) {
      IShape shape1 = (IShape) shape;
      if (maxFrame < shape1.getDisappears()) {
        maxFrame = ((IShape) shape).getDisappears();
      }
    }


    this.timer = new Timer(1000 / speed, new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        List<IShape> shapes = new ArrayList<>();
        List<IAnimation> animations = new ArrayList<>();

        //consider tick  ,  shape is visible, getAllShapesAtFrame from model, we do
        // renderlist to draw
        //all times in model are ticks, timer complete, ticks++, 2 ticks/second,
        //step 1: find all animation needed to be performed
        // model.getPerformable animation(frame)
        currentFrame += 1;
        animations = model.getAllAnimationAtFrame(currentFrame);


        //step 2: run  animation
        // animation.performByStep
        for (IAnimation animation : animations) {
          animation.performActionByStep(speed);
        }

        // 2. get all shapes from model at current frame
        // getAllShapesAtFrame
        shapes = model.getAllShapesAtFrame(currentFrame);


        // render shapes
        animationView.renderList(shapes);
        //currentFrame++; //tick ++

        animationView.refresh();


        // stop timer
        if (currentFrame >= maxFrame) {
          timer.stop();
        }
      }
    });

  }

  /**
   * Perform an animation using the provided model.
   */
  @Override
  public void animate() {
        timer.start();
  }

  @Override
  public void pause() {
    timer.stop();
  }

  @Override
  public void reset() {
    timer.stop();

    // reset timer, tick to 0
    this.currentFrame = 0;

    // reset shape to original status (position, color, size)
    Map<String, IShape> shapes = this.model.getShapeList();
    for (IShape shape : shapes.values()) {
      shape.resetToOriginal();
    }

    timer.start();

  }
}
