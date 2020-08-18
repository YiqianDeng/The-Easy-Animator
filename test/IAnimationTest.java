import org.junit.Before;
import org.junit.Test;

import cs5004.animator.model.animation.IAnimation;
import cs5004.animator.model.animation.TypeOfAnimation;
import cs5004.animator.model.animation.ChangeColorAnimation;
import cs5004.animator.model.animation.MoveAnimation;
import cs5004.animator.model.animation.ScaleAnimation;
import cs5004.animator.model.shape.IShape;
import cs5004.animator.model.shape.Oval;
import cs5004.animator.model.shape.Rectangle;
import cs5004.animator.model.shape.TypeOfShape;

import static org.junit.Assert.assertEquals;

/**
 * This is test for IAnimation Interface.
 */
public class IAnimationTest {
  private IShape rectangle;
  private IShape oval;
  private IAnimation move;
  private IAnimation scale;
  private IAnimation changeColor;

  @Before
  public void setUp() throws Exception {
    rectangle = new Rectangle("R", TypeOfShape.rectangle, 200.0, 200.0,
            50.0, 100.0, 1.0, 0.0, 0.0, 1, 100);

    oval = new Oval("C", TypeOfShape.oval,500.0, 100.0, 60.0,
            30.0, 0.0, 0.0, 1.0, 6, 100);
  }

  // test constructors
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor1() {
    // move bad from time
    move = new MoveAnimation(rectangle, -1, 50, 200.0, 200.0,
            300.0, 300.0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor2() {
    // move bad to time
    move = new MoveAnimation(rectangle, 10, -5, 200.0, 200.0,
            300.0, 300.0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor3() {
    // change color bad to R
    move = new ChangeColorAnimation(oval, 50, 80, 0.0, 0.0,
            1.0, 256, 1.0, 0.0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor4() {
    // change color bad to G
    move = new ChangeColorAnimation(oval, 50, 80, 0.0, 0.0,
            1.0, 0.0, -6, 0.0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor5() {
    // change color bad to B
    move = new ChangeColorAnimation(oval, 50, 80, 0.0, 0.0,
            1.0, 0.0, 1.0, 300);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor6() {
    // scale bad to width
    move = new ScaleAnimation(rectangle, 51, 70, 50.0, 100.0,
            -5, 100.0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor7() {
    // scale bad to height
    move = new ScaleAnimation(oval, 51, 70, 50.0, 100.0,
            25.0, -9);
  }

  // test getter
  @Test
  public void testGetter() {
    move = new MoveAnimation(rectangle, 10, 50, 200.0, 200.0,
            300.0, 300.0);

    changeColor = new ChangeColorAnimation(oval, 50, 80, 0, 0,
            1, 0, 1, 0);

    scale = new ScaleAnimation(rectangle, 51, 70, 50, 100,
            25, 100);

    assertEquals(10, move.getFromTime());
    assertEquals(50, move.getToTime());
    assertEquals(TypeOfAnimation.move, move.getType());
    assertEquals(rectangle, move.getShape());

    assertEquals(50, changeColor.getFromTime());
    assertEquals(80, changeColor.getToTime());
    assertEquals(TypeOfAnimation.changeColor, changeColor.getType());
    assertEquals(oval, changeColor.getShape());

    assertEquals(51, scale.getFromTime());
    assertEquals(70, scale.getToTime());
    assertEquals(TypeOfAnimation.scale, scale.getType());
    assertEquals(rectangle, scale.getShape());
  }

  // test performAction
  @Test
  public void testPerformAction() {
    move = new MoveAnimation(rectangle, 10, 50, 200.0, 200.0,
            300.0, 300.0);

    changeColor = new ChangeColorAnimation(oval, 50, 80, 0, 0,
            1, 0, 1, 0);

    scale = new ScaleAnimation(rectangle, 51, 70, 50, 100,
            25, 100);

    move.performAction();
    changeColor.performAction();
    scale.performAction();

    assertEquals(300.0, rectangle.getPosition().getX(), 0.001);
    assertEquals(300.0, rectangle.getPosition().getY(), 0.001);

    assertEquals(0, oval.getColor().getR(), 0.001);
    assertEquals(1, oval.getColor().getG(), 0.001);
    assertEquals(0, oval.getColor().getB(), 0.001);

    assertEquals(25, rectangle.getSize().getWidth(), 0.001);
    assertEquals(100, rectangle.getSize().getHeight(), 0.001);
  }

  // test toString
  @Test
  public void testToString() {
    move = new MoveAnimation(rectangle, 10, 50, 200.0, 200.0,
            300.0, 300.0);

    changeColor = new ChangeColorAnimation(oval, 50, 80, 0, 0,
            1, 0, 1, 0);

    scale = new ScaleAnimation(rectangle, 51, 70, 50, 100,
            25, 100);

    assertEquals("Shape R moves from (200.0,200.0) to (300.0,300.0) from t=10 to t=50\n",
            move.toString());
    assertEquals("Shape C changes color from (0.0,0.0,1.0) to (0.0,1.0,0.0) from t=50 " +
            "to t=80\n", changeColor.toString());
    assertEquals("Shape R scales from Width: 50.0, Height: 100.0 to Width: 25.0, " +
            "Height: 100.0 from t=51 to t=70\n", scale.toString());
  }
}