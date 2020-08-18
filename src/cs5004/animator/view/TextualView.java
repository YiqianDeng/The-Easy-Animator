package cs5004.animator.view;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import cs5004.animator.model.IModel;
import cs5004.animator.model.animation.IAnimation;
import cs5004.animator.model.shape.IShape;

/**
 * This textual view class implement the IVew interface. This class has a textToRender and a render
 * method that make the view object generate the text output and render then to console or a text
 * file.
 */
public class TextualView implements IView {
  private final String outfile;
  private final String viewType;
  private final IModel model;
  private final int speed;

  /**
   * Construct a textrualView object.
   *
   * @param model the model of animator.
   * @param speed the speed of animation that user input from argument.
   * @param out the output filename.
   */
  public TextualView(IModel model, int speed, String out) {
    this.outfile = out;
    this.viewType = "text";
    this.model = model;
    this.speed = speed;
  }

  /**
   * This method will take a input file and render everything in it.
   *
   * @throws FileNotFoundException if the file is not exist.
   */
  @Override
  public void render() throws FileNotFoundException {

    if (outfile.equals("")) {
      System.out.println(this.textToRender());
    } else {
      try {
        FileOutputStream outputStream = new FileOutputStream(this.outfile);
        byte[] strToBytes = this.textToRender().getBytes();
        outputStream.write(strToBytes);
        outputStream.close();
      } catch (IOException e) {
        throw new FileNotFoundException("Cannot find the files");
      }
    }
  }

  /**
   * This method generate the text output for view.
   *
   * @return the output for view as string.
   */
  public String textToRender() {
    StringBuilder output = new StringBuilder();
    output.append("Shapes: \n");
    for (Object shape : this.model.getShapeList().values()) {
      IShape eachShape = (IShape) shape;
      output.append(eachShape.toString()).append("Appears at t=")
              .append(eachShape.getAppears() / this.speed).append(", Disappears at t=")
              .append(eachShape.getDisappears() / this.speed).append("\n\n");
    }

    for (Object animation : model.getAnimationList()) {
      IAnimation eachAnimation = (IAnimation) animation;
      output.append(eachAnimation.toString()).append(", from time t=")
              .append(eachAnimation.getFromTime() / this.speed).append(" to t=")
              .append(eachAnimation.getToTime() / this.speed).append("\n");
    }


    return String.valueOf(output);
  }

  /**
   * Get the panel of AnimationView.
   *
   * @return an animationView.
   */
  @Override
  public IDrawingPanel getPanel() {
    // ignore
    return null;
  }

  /**
   * The getter of current view type.
   *
   * @return The String represent the type of current view.
   */
  @Override
  public String getViewType() {
    return this.viewType;
  }

  /**
   * This method pass the a list of shapes we are going to draw to the actual draw method.
   *
   * @param shape the arraylist of shapes object we are going to draw on canvas.
   */
  @Override
  public void renderList(List<IShape> shape) {
    return;
  }

  /**
   * Refresh the canvas.
   */
  @Override
  public void refresh() {
    // ignore here.AnimationReader
  }


}
