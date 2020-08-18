package cs5004.animator;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cs5004.animator.controller.AnimationController;
import cs5004.animator.controller.TextController;
import cs5004.animator.controller.IController;
import cs5004.animator.model.IModel;
import cs5004.animator.model.ModelImpl;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.util.MyAnimationBuilder;
import cs5004.animator.view.IView;
import cs5004.animator.view.ViewFactory;


/**
 * Create an animation MVC.
 */
public final class EasyAnimator {


  /**
   * This is the main function, will take inputs as command-line arguments.
   * The inputs contains: -in(mandatory), -out(default: System.out), -view(mandatory),
   * -speed(1 tick per second).
   * @param args the inputs
   */
  public static void main(String[] args) throws FileNotFoundException {
    //JFrame mainFrame = new JFrame();
    IModel model = new ModelImpl();
    AnimationReader reader = new AnimationReader();

    //default
    String fileName = "";
    String viewType = "";
    String speed = "1";
    String out = "" ;

    //args
    int i;
    for (i = 0; i < args.length; i ++) {
      if (args[i].equalsIgnoreCase("-in")) {
        fileName = args[i + 1];
      }
      else if (args[i].equalsIgnoreCase("-view")) {
        viewType = args[i + 1];
      }
      else if (args[i].equalsIgnoreCase("-out")) {
        out = args[i + 1];
      }
      else if (args[i].equalsIgnoreCase("-speed")) {
        speed = args[i + 1];
      }

      AnimationBuilder<IModel> myAnimationBuilder = new MyAnimationBuilder(model);
      //model setup
      try {
        model = AnimationReader.parseFile(new FileReader(fileName), myAnimationBuilder);
      } catch (IOException e) {
        // throw new IllegalArgumentException("Cannot process the file");
        JOptionPane.showMessageDialog(null, "Cannot process the file");
        System.exit(0);
      }
    }


    IView view;
    //make view depends of types                 type
    view = ViewFactory.makeView(model, viewType, out, model.getCanvasWidth(),
            model.getCanvasHeight(), Integer.parseInt(speed));


    IController controller;
    if (view.getViewType().equalsIgnoreCase("animation")) {
      controller = new AnimationController(model, view, Integer.parseInt(speed));
      view.getPanel().registerController((AnimationController) controller);
    } else {
      controller = new TextController(view, model, Integer.parseInt(speed));
    }
    //controller.animate();

  }
}
