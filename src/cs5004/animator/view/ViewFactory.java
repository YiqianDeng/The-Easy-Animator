package cs5004.animator.view;

import cs5004.animator.model.IModel;

/**
 * This View factory include all type of view we have, and will define which view we are going to
 * use.
 */
public class ViewFactory {

  /**
   * Construct a makeView object which will decide which view we are going to use.
   *
   * @param model        The model of animator.
   * @param viewType     the type of view.
   * @param output       the output filename.
   * @param canvasWidth  the canvas width.
   * @param canvasHeight the canvas height.
   * @return the objecto of view.
   * @throws IllegalArgumentException if input are not valid.
   */
  public static IView makeView(IModel model, String viewType, String output, int canvasWidth,
                               int canvasHeight, int speed) throws IllegalArgumentException {

    if (viewType.equalsIgnoreCase("text")) {

      return new TextualView(model, speed, output);
    } else if (viewType.equalsIgnoreCase("visual")) {
      return new AnimationView(canvasWidth, canvasHeight, model, speed);
    } else {
      throw new IllegalArgumentException("Currently not support this kind of view");
    }
  }

}
