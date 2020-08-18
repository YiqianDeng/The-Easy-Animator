package cs5004.animator.controller;

import java.io.FileNotFoundException;

import cs5004.animator.model.IModel;
import cs5004.animator.view.IView;
import jdk.jshell.spi.ExecutionControl;

/**
 * This class represents the operations offered by the IController. One object of the model
 * represents the text controller of the whole animator.
 */
public class TextController implements IController {
  private final IView view;


  /**
   * Construct a textController object.
   *
   * @param view  the view of animator.
   * @param model the model of animator.
   * @param speed the speed of animator that user input from argument.
   */
  public TextController(IView view, IModel model, int speed) {
    this.view = view;
  }


  /**
   * Perform an animation using the provided model.
   */
  @Override
  public void animate() throws FileNotFoundException {
    if (view.getViewType().equals("text")) {
      this.view.render();
    }
  }

  @Override
  public void pause() throws ExecutionControl.NotImplementedException {
    throw new ExecutionControl.NotImplementedException("Should not call this function.");
  }

  @Override
  public void reset() throws ExecutionControl.NotImplementedException {
    throw new ExecutionControl.NotImplementedException("Should not call this function.");
  }

}