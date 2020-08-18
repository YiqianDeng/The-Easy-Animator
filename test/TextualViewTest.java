
import org.junit.Before;
import org.junit.Test;

import cs5004.animator.model.IModel;
import cs5004.animator.model.ModelImpl;
import cs5004.animator.model.shape.TypeOfShape;
import cs5004.animator.view.IView;
import cs5004.animator.view.TextualView;

import static org.junit.Assert.assertEquals;

/**
 * This is the test class for TextualView.
 */
public class TextualViewTest {
  private IView textualView;
  private IModel model;

  @Before
  public void setUp() {
    // set model
    model = new ModelImpl();

    String filename = "";
    int speed = 10;

    // set view
    textualView = new TextualView(model, speed, filename);
  }

  @Test
  public void testGetOutPut() {
    // test shape output accuracy
    model.addShape("R", TypeOfShape.rectangle, 200, 200, 10,
            30, 0 ,0 ,255, 1, 100);

    assertEquals("Shapes: \n" +
            "Name: R\n" +
            "Type: rectangle\n" +
            "Min corner: (200.0,200.0), Width: 10.0, Height: 30.0, Color: (0.0,0.0,255.0)Appears" +
            " at t=0, Disappears at t=10\n" +
            "\n", textualView.textToRender());
  }

  @Test
  public void testGetOutPut2() {
    // test all shape and animation output accuracy.
    model.addShape("R", TypeOfShape.rectangle, 200, 200, 10,
            30, 0 ,0 ,255, 1, 100);
    model.addShape("C", TypeOfShape.oval, 300, 300, 20, 10,
            255, 0, 0, 3, 10);
    model.move("R", 200, 200, 300, 300, 3, 30);
    model.changeColor("R", 0, 0, 255, 30, 30, 50,
            1, 30);
    model.scale("C", 20, 10, 30, 5,
            1, 30);

    assertEquals("Shapes: \n" +
            "Name: R\n" +
            "Type: rectangle\n" +
            "Min corner: (200.0,200.0), Width: 10.0, Height: 30.0, Color: (0.0,0.0,255.0)Appears " +
            "at t=0, Disappears at t=10\n" +
            "\n" +
            "Name: C\n" +
            "Type: oval\n" +
            "Center: (300.0,300.0), X radius: 20.0, Y radius: 10.0, Color: (255.0,0.0,0.0)" +
            "Appears at t=0, Disappears at t=1\n" +
            "\n" +
            "Shape R changes color from (0.0,0.0,255.0) to (30.0,30.0,50.0), from time " +
            "t=0 to t=3\n" +
            "Shape C scales from Width: 20.0, Height: 10.0 to Width: 30.0, Height: 5.0, " +
            "from time t=0 to t=3\n" +
            "Shape R moves from (200.0,200.0) to (300.0,300.0), from time t=0 to " +
            "t=3\n", textualView.textToRender());
  }


  @Test
  public void testGetOutPut3() {
    // test oval shape and animation accuracy
    model.addShape("C", TypeOfShape.oval, 300, 300, 20, 10,
            255, 0, 0, 3, 10);
    model.move("C", 300, 300, 100, 100, 10, 30);
    model.changeColor("C", 255, 0, 0, 0, 200, 100,
            10, 30);
    model.scale("C", 20, 10, 30, 30,
            50, 70);

    assertEquals("Shapes: \n" +
            "Name: C\n" +
            "Type: oval\n" +
            "Center: (300.0,300.0), X radius: 20.0, Y radius: 10.0, Color: (255.0,0.0,0.0)" +
            "Appears at t=0, Disappears at t=1\n" +
            "\n" +
            "Shape C moves from (300.0,300.0) to (100.0,100.0), from time t=1 to t=3\n" +
            "Shape C changes color from (255.0,0.0,0.0) to (0.0,200.0,100.0), from time " +
            "t=1 to t=3\n" +
            "Shape C scales from Width: 20.0, Height: 10.0 to Width: 30.0, Height: 30.0, " +
            "from time t=5 to t=7\n", textualView.textToRender());
  }


  @Test
  public void getViewType() {
    // test view type accuracy.
    assertEquals("text", textualView.getViewType());
  }
}