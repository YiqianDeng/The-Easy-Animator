package cs5004.animator.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.swing.*;

import cs5004.animator.model.IModel;
import cs5004.animator.model.animation.IAnimation;
import cs5004.animator.model.shape.IShape;

/**
 * This animation view class implement the IVew interface. This class has a Drawing panel, a scroll
 * pane, and a view type.
 */
public class AnimationView extends JFrame implements IView {

  private final DrawingPanel panel;
  private final String viewType;

  private final IModel model;
  private final int speed;
  // file menu bar
  //private JMenuBar menuBar;
  //private JMenu fileMenu;
  //private JMenuItem saveItem;


  /**
   * Construct a animation view object with given input.
   *
   * @param w the width of canvas and window.
   * @param h the height of canvas and window.
   */
  public AnimationView(int w, int h, IModel model, int speed) {
    super();
    this.viewType = "animation";
    this.model = model;
    this.speed = speed;

    panel = new DrawingPanel(w, h);  //canvas

    add(panel);
    setMenuBar();
    //current window size
    setSize(1000, 1000);
    setDefaultCloseOperation(EXIT_ON_CLOSE);


    //Decorator Pattern
    JScrollPane scrollPane = new JScrollPane(panel);
    //scrollPane.add(panel);
    scrollPane.setVisible(true);
    //scrollPane.setSize(w,h);
    add(scrollPane);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
  }

  private void setMenuBar() {
    // set menu
    var menuBar = new JMenuBar();

    var fileMenu = new JMenu("File");
    menuBar.add(fileMenu);

    var saveItem = new JMenuItem("Save");
    fileMenu.add(saveItem);

    saveItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          render();
          JOptionPane.showMessageDialog(null,
                  "File save successful, please check the 'animationOutput.txt' file");
          System.exit(0);
        } catch (FileNotFoundException fileNotFoundException) {
          System.out.println("file not found, save fail");
          fileNotFoundException.printStackTrace();
        }
      }
    });

    var deleteShapes = new JMenu("Delete-Shapes");
    menuBar.add(deleteShapes);

    // add menu items for all shapes.
    List<IShape> shapes = model.getAllShapes();
    for (IShape shape : shapes){
      var shapeItem = new JMenuItem(shape.getName());
      shapeItem.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          // when click shape name
          // 1. remove the shape from shape map.
          // 2. remove the menu item from deleteShape menu.
            model.removeShape(shape.getName());
            deleteShapes.remove(shapeItem);
        }
      });
      deleteShapes.add(shapeItem);
    }

    setJMenuBar(menuBar);
  }


  /**
   * Get the panel of AnimationView.
   *
   * @return an animationView.
   */
  @Override
  public IDrawingPanel getPanel() {
    return this.panel;
  };

  /**
   * This method will take String input and render everything.
   *
   * @throws IllegalArgumentException if the input string is invalid.
   */
  @Override
  public void render() throws FileNotFoundException {
    try {
      FileOutputStream outputStream = new FileOutputStream("animationOutput.txt");
      byte[] strToBytes = this.textToRender().getBytes();
      outputStream.write(strToBytes);
      outputStream.close();
    } catch (IOException e) {
      throw new FileNotFoundException("Cannot find the files");
    }

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
    // for loop each shape, draw.
    panel.drawShapes(shape);
  }

  /**
   * Refresh the canvas.
   */
  @Override
  public void refresh() {
    panel.repaint();
  }

  /**
   * This method generate the text output that will be render to screen.
   *
   * @return the output of textualView.
   */
  @Override
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

}
