package cs5004.animator.view;

import java.io.FileNotFoundException;
import java.util.List;
import cs5004.animator.model.shape.IShape;

/**
 * The interface represent the operation offered by the TextualView and AnimationView. One object of
 * IVew represents one view of animator.
 */
public interface IView {

  /**
   * This method will take a input file and render everything in it.
   *
   * @throws FileNotFoundException if the file is not exist.
   */
  void render() throws FileNotFoundException;

  /**
   * The getter of current view type.
   *
   * @return The String represent the type of current view.
   */
  String getViewType();

  /**
   * This method pass the a list of shapes we are going to draw to the actual draw method.
   *
   * @param shape the arraylist of shapes object we are going to draw on canvas.
   */
  void renderList(List<IShape> shape);

  /**
   * Refresh the canvas.
   */
  void refresh();

  /**
   * This method generate the text output that will be render to screen.
   *
   * @return  the output of textualView.
   */
  String textToRender();

  /**
   * Get the panel of AnimationView.
   *
   * @return an animationView.
   */
  IDrawingPanel getPanel();
}
