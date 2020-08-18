package cs5004.animator.controller;

import java.io.FileNotFoundException;

import jdk.jshell.spi.ExecutionControl;

/**
 * This is a controller interface, the purpose is to mediate the interactions between the view and
 * the model. It includes a play methods to run an animation model.
 */
public interface IController {


  /**
   * Perform an animation using the provided model.
   * @throws FileNotFoundException when the file is not found.
   */
  void animate() throws FileNotFoundException;


  /**
   * Pause an animation using the provided model.
   * @throws ExecutionControl.NotImplementedException when someone call this function from textual
   *                                                  view.
   */
  void pause() throws ExecutionControl.NotImplementedException;


  /**
   * Reset an animation using the provided model.
   * @throws ExecutionControl.NotImplementedException when someone call this function from textual
   *                                                  view.
   */
  void reset() throws ExecutionControl.NotImplementedException;
}

