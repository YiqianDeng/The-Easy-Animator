import org.junit.Before;
import org.junit.Test;

import cs5004.animator.model.shape.IShape;
import cs5004.animator.model.shape.Oval;
import cs5004.animator.model.shape.Rectangle;
import cs5004.animator.model.shape.TypeOfShape;

import static org.junit.Assert.assertEquals;

/**
 * This is the test for IShape Interface.
 */
public class IShapeTest {
  private IShape rectangle;
  private IShape oval;

  @Before
  public void setUp() {
    rectangle = new Rectangle("R", TypeOfShape.rectangle, 200.0, 200.0,
            50.0, 100.0, 1.0, 0.0, 0.0, 1, 100);

    oval = new Oval("C", TypeOfShape.oval, 500.0, 100.0, 60.0,
            30.0, 0.0, 0.0, 1.0, 6, 100);
  }

  // test constructors
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor1() {
    // bad width of shape
    rectangle = new Rectangle("R", TypeOfShape.rectangle, 200.0, 200.0,
            0, 100.0, 1.0, 0.0, 0.0, 1, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor2() {
    // bad width of shape
    oval = new Oval("C", TypeOfShape.oval, 500.0, 100.0, -5,
            30.0, 0.0, 0.0, 1.0, 6, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor3() {
    // bad height of shape
    rectangle = new Rectangle("R", TypeOfShape.rectangle, 200.0, 200.0,
            50.0, -5, 1.0, 0.0, 0.0, 1, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor4() {
    // bad height of shape
    oval = new Oval("C", TypeOfShape.oval, 500.0, 100.0, 60.0,
            0, 0.0, 0.0, 1.0, 6, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor5() {
    // bad r of color
    rectangle = new Rectangle("R", TypeOfShape.rectangle, 200.0, 200.0,
            50.0, 100.0, -3, 0.0, 0.0, 1, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor6() {
    // bad r of color
    oval = new Oval("C", TypeOfShape.oval, 500.0, 100.0, 60.0,
            30.0, 256, 0.0, 1.0, 6, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor7() {
    // bad g of color
    rectangle = new Rectangle("R", TypeOfShape.rectangle, 200.0, 200.0,
            50.0, 100.0, 1.0, 256, 0.0, 1, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor8() {
    // bad g of color
    oval = new Oval("C", TypeOfShape.oval, 500.0, 100.0, 60.0,
            30.0, 0.0, -7, 1.0, 6, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor9() {
    // bad b of color
    rectangle = new Rectangle("R", TypeOfShape.rectangle, 200.0, 200.0,
            50.0, 100.0, 1.0, 0.0, -5, 1, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor10() {
    // bad b of color
    oval = new Oval("C", TypeOfShape.oval, 500.0, 100.0, 60.0,
            30.0, 0.0, 0.0, 257, 6, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor11() {
    // bad appears of shape
    rectangle = new Rectangle("R", TypeOfShape.rectangle, 200.0, 200.0,
            50.0, 100.0, 1.0, 0.0, 0.0, -5, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor12() {
    // bad disappears of shape
    oval = new Oval("C", TypeOfShape.oval, 500.0, 100.0, 60.0,
            30.0, 0.0, 0.0, 1.0, 6, -10);
  }

  // test toString
  @Test
  public void testToString() {
    assertEquals("Name: R\n" +
            "Type: rectangle\n" +
            "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: (1.0,0.0,0.0)\n" +
            "Appears at t=1\n" +
            "Disappears at t=100\n", rectangle.toString());

    assertEquals("Name: C\n" +
            "Type: oval\n" +
            "Center: (500.0,100.0), X radius: 60.0, Y radius: 30.0, Color: (0.0,0.0,1.0)\n" +
            "Appears at t=6\n" +
            "Disappears at t=100\n", oval.toString());
  }

  // test getter
  @Test
  public void testGetter() {
    assertEquals(200.0, rectangle.getPosition().getX(), 0.001);
    assertEquals(200.0, rectangle.getPosition().getY(), 0.001);
    assertEquals(50.0, rectangle.getSize().getWidth(), 0.001);
    assertEquals(100.0, rectangle.getSize().getHeight(), 0.001);
    assertEquals(1.0, rectangle.getColor().getR(), 0.001);
    assertEquals(0.0, rectangle.getColor().getG(), 0.001);
    assertEquals(0.0, rectangle.getColor().getB(), 0.001);
    assertEquals("R", rectangle.getName());
    assertEquals(TypeOfShape.rectangle, rectangle.getTypeOfShape());
    assertEquals(1, rectangle.getAppears());
    assertEquals(100, rectangle.getDisappears());

    assertEquals(500.0, oval.getPosition().getX(), 0.001);
    assertEquals(100.0, oval.getPosition().getY(), 0.001);
    assertEquals(60.0, oval.getSize().getWidth(), 0.001);
    assertEquals(30.0, oval.getSize().getHeight(), 0.001);
    assertEquals(0.0, oval.getColor().getR(), 0.001);
    assertEquals(0.0, oval.getColor().getG(), 0.001);
    assertEquals(1.0, oval.getColor().getB(), 0.001);
    assertEquals("C", oval.getName());
    assertEquals(TypeOfShape.oval, oval.getTypeOfShape());
    assertEquals(6, oval.getAppears());
    assertEquals(100, oval.getDisappears());
  }

  // test setter
  @Test
  public void testSetter() {
    rectangle.setPosition(0, 35);
    rectangle.setColor(3, 150, 255);
    rectangle.setSize(15, 30);
    rectangle.setName("A");
    rectangle.setTypeOfShape(TypeOfShape.oval);
    rectangle.setAppears(10);
    rectangle.setDisappears(30);

    assertEquals(0.0, rectangle.getPosition().getX(), 0.001);
    assertEquals(35.0, rectangle.getPosition().getY(), 0.001);
    assertEquals(15.0, rectangle.getSize().getWidth(), 0.001);
    assertEquals(30.0, rectangle.getSize().getHeight(), 0.001);
    assertEquals(3.0, rectangle.getColor().getR(), 0.001);
    assertEquals(150.0, rectangle.getColor().getG(), 0.001);
    assertEquals(255.0, rectangle.getColor().getB(), 0.001);
    assertEquals("A", rectangle.getName());
    assertEquals(TypeOfShape.oval, rectangle.getTypeOfShape());
    assertEquals(10, rectangle.getAppears());
    assertEquals(30, rectangle.getDisappears());
  }
}