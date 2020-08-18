package cs5004.animator.view;

import java.util.List;
import javax.swing.Timer;

import cs5004.animator.controller.AnimationController;
import cs5004.animator.model.shape.IShape;

/**
 * This IDrawing Panel interface represent a panel and will manipulate this panel / canvas.
 */
public interface IDrawingPanel {

  /**
   * This method will draw all objects on panel.
   *
   * @param shape a array list which contain all shapes have to be draw on canvas.
   */
  void drawShapes(List<IShape> shape);

  void registerController(AnimationController controller);


}
