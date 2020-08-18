package cs5004.animator.view;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import cs5004.animator.controller.AnimationController;
import cs5004.animator.model.shape.IShape;

/**
 * This class represents the operations offered by IDrawingPanel. Each object will represent a panel
 * and every in panel.
 */
public class DrawingPanel extends JPanel implements IDrawingPanel {
  private List<IShape> shapes;   //[Rectangle(), Ellipse(), ....]  //shapeList

  // controller help react with button action
  private AnimationController controller;

  /**
   * Construct a DrawingPanel Object with input width and height which will set the size of canvas.
   *
   * @param width  the width of canvas/panel.
   * @param height the height of canvas/panel.
   */
  public DrawingPanel(int width, int height) {
    super();

    setBackground(Color.WHITE);
    setPreferredSize(new Dimension(width, height)); //bound model width height

    setButton();
  }

  private void setButton() {
    // set button
    // buttons
    JButton playButton = new JButton("Play");
    playButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        controller.animate();
      }
    });

    JButton stopButton = new JButton("Stop");
    stopButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        controller.pause();
      }
    });

    JButton sfbButton = new JButton("StartFromBeginning");
    sfbButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        controller.reset();
      }
    });

    add(playButton);
    add(stopButton);
    add(sfbButton);
    setVisible(true);
  }

  public void registerController(AnimationController controller){
    this.controller = controller;
  }
  /**
   * This method will draw all objects on panel.
   *
   * @param shape a array list which contain all shapes have to be draw on canvas.
   */
  @Override
  public void drawShapes(List<IShape> shape) {
    this.shapes = shape;
  }

  /**
   * preps our shapes to be painted a specific color.
   *
   * @param g the graphic we are going to be rendering.
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (this.shapes != null) {
      for (IShape shape : this.shapes) {
        Color newColor = new Color((int) shape.getColor().getR(), (int) shape.getColor().getG(),
                (int) shape.getColor().getB());
        switch (shape.getTypeOfShape().toString()) {
          case "rectangle":
            g.setColor(newColor);
            g.fillRect((int) shape.getPosition().getX(), (int) shape.getPosition().getY(),
                    (int) shape.getSize().getWidth(), (int) shape.getSize().getHeight());
            break;
          case "oval":
            g.setColor(newColor);
            g.fillOval((int) shape.getPosition().getX(), (int) shape.getPosition().getY(),
                    (int) shape.getSize().getWidth(), (int) shape.getSize().getHeight());
            break;
          default:
            throw new IllegalArgumentException("Doesn't support this kind of shape right now");
        }

      }
    }
  }


}


