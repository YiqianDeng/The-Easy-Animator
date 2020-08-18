import org.junit.Before;
import org.junit.Test;

import cs5004.animator.model.IModel;
import cs5004.animator.model.ModelImpl;
import cs5004.animator.model.shape.TypeOfShape;

import static org.junit.Assert.assertEquals;

/**
 * This is the test for ModelImpl class which implement IModel interface.
 */
public class ModelImplTest {
  private IModel model;

  @Before
  public void setUp() throws Exception {
    model = new ModelImpl();
  }

  // test add shape
  @Test
  public void testAddShape1() {
    model.addShape("R", TypeOfShape.rectangle, 200, 200, 50,
            100, 1, 0, 0, 1, 100);
    assertEquals("Shapes:\n" +
            "Name: R\n" +
            "Type: rectangle\n" +
            "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: " +
            "(1.0,0.0,0.0)Appears at t=1, Disappears at t=100\n" +
            "\n", model.getStatus());

    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 0, 1, 6, 100);
    assertEquals("Shapes:\n" +
            "Name: R\n" +
            "Type: rectangle\n" +
            "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: " +
            "(1.0,0.0,0.0)Appears at t=1, Disappears at t=100\n" +
            "\n" +
            "Name: C\n" +
            "Type: oval\n" +
            "Center: (500.0,100.0), X radius: 60.0, Y radius: 30.0, Color: " +
            "(0.0,0.0,1.0)Appears at t=6, Disappears at t=100\n" +
            "\n", model.getStatus());
  }

  @Test//(expected = IllegalArgumentException.class)
  public void testAddShape2() {
    // a name already been use.
    model.addShape("R", TypeOfShape.rectangle, 200, 200, 50,
            100, 1, 0, 0, 1, 100);
    model.addShape("R", TypeOfShape.oval, 200, 200, 50,
            100, 1, 0, 0, 1, 100);
  }

  @Test//(expected = IllegalArgumentException.class)
  public void testAddShape3() {
    // a shape already exist.
    model.addShape("R", TypeOfShape.rectangle, 200, 200, 50,
            100, 1, 0, 0, 1, 100);
    model.addShape("R", TypeOfShape.rectangle, 200, 200, 50,
            100, 1, 0, 0, 1, 100);
  }

  @Test//(expected = IllegalArgumentException.class)
  public void testAddShape4() {
    // bad width input
    model.addShape("R", TypeOfShape.rectangle, 200, 200, 0,
            100, 1, 0, 0, 1, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddShape5() {
    // bad height input
    model.addShape("R", TypeOfShape.rectangle, 200, 200, 50,
            -5, 1, 0, 0, 1, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddShape6() {
    // bad r
    model.addShape("R", TypeOfShape.rectangle, 200, 200, 50,
            100, 270, 0, 0, 1, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddShape7() {
    // bad r
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            -8, 0, 1, 6, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddShape8() {
    // bad g
    model.addShape("R", TypeOfShape.rectangle, 200, 200, 50,
            100, 1, -9, 0, 1, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddShape9() {
    // bad g
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 900, 1, 6, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddShape10() {
    // bad b
    model.addShape("R", TypeOfShape.rectangle, 200, 200, 50,
            100, 1, 0, 800, 1, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddShape11() {
    // bad b
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 0, -5, 6, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddShape12() {
    // bad appears
    model.addShape("R", TypeOfShape.rectangle, 200, 200, 50,
            100, 1, 0, 0, -6, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddShape13() {
    // bad disappears
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 0, 1, 6, -80);
  }

  // test move
  @Test
  public void testMove() {
    // add shape
    model.addShape("R", TypeOfShape.rectangle, 200, 200, 50,
            100, 1, 0, 0, 1, 100);
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 0, 1, 6, 100);

    // test move
    model.move("R", 200, 200, 300, 300, 10, 50);
    assertEquals("Shapes:\n" +
                    "Name: R\n" +
                    "Type: rectangle\n" +
                    "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: " +
                    "(1.0,0.0,0.0)Appears at t=1, Disappears at t=100\n" +
                    "\n" +
                    "Name: C\n" +
                    "Type: oval\n" +
                    "Center: (500.0,100.0), X radius: 60.0, Y radius: 30.0, Color: " +
                    "(0.0,0.0,1.0)Appears at t=6, Disappears at t=100\n" +
                    "\n" +
                    "Shape R moves from (200.0,200.0) to (300.0,300.0), from time t=10 to t=50",
            model.getStatus());

    model.move("C", 500, 100, 20, 20, 30, 50);
    assertEquals("Shapes:\n" +
                    "Name: R\n" +
                    "Type: rectangle\n" +
                    "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: " +
                    "(1.0,0.0,0.0)Appears at t=1, Disappears at t=100\n" +
                    "\n" +
                    "Name: C\n" +
                    "Type: oval\n" +
                    "Center: (500.0,100.0), X radius: 60.0, Y radius: 30.0, Color: " +
                    "(0.0,0.0,1.0)Appears at t=6, Disappears at t=100\n" +
                    "\n" +
                    "Shape R moves from (200.0,200.0) to (300.0,300.0), from time t=10 to " +
                    "t=50Shape C moves from (500.0,100.0) to (20.0,20.0), from time t=30 to t=50",
            model.getStatus());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMove1() {
    // move with not exist shape
    model.move("A", 30, 30, 20, 20, 30, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMove2() {
    // add shape
    model.addShape("R", TypeOfShape.rectangle, 200, 200, 50,
            100, 1, 0, 0, 1, 100);

    // move with bad from time input
    model.move("R", 200, 200, 20, 20, -5, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMove3() {
    // add shape
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 0, 1, 6, 100);

    // move with bad to time input
    model.move("C", 500, 100, 20, 20, 10, -5);
  }

  @Test//(expected = IllegalStateException.class)
  public void testMove5() {
    // add shape
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 0, 1, 6, 100);

    // move to overlapped time 10 - 50 and 25 - 70.
    model.move("C", 500, 100, 300, 300, 10, 50);
    model.move("C", 300, 300, 200, 200, 25, 70);
  }

  @Test//(expected = IllegalStateException.class)
  public void testMove6() {
    // add shape
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 0, 1, 6, 100);

    // move to overlapped time 10 - 50 and 10 - 50.
    model.move("C", 500, 100, 300, 300, 10, 50);
    model.move("C",300, 300, 200, 200, 10, 50);
  }

  @Test//(expected = IllegalStateException.class)
  public void testMove7() {
    // add shape
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 0, 1, 6, 100);

    // move to overlapped time 10 - 50 and 5 - 15.
    model.move("C",500, 100, 300, 300, 10, 50);
    model.move("C",300, 300, 200, 200, 5, 15);
  }

  @Test//(expected = IllegalStateException.class)
  public void testMove8() {
    // add shape
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 0, 1, 6, 100);

    // move to overlapped time 10 - 50 and 15 - 20.
    model.move("C",500, 100, 300, 300, 10, 50);
    model.move("C", 300, 300, 200, 200, 15, 20);
  }

  @Test//(expected = IllegalStateException.class)
  public void testMove9() {
    // add shape
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 0, 1, 6, 100);

    // move to overlapped time 10 - 50 and 5 - 60.
    model.move("C", 500, 100, 300, 300, 10, 50);
    model.move("C",300, 300, 200, 200, 5, 60);
  }

  @Test//(expected = IllegalStateException.class)
  public void testMove10() {
    // add shape
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 0, 1, 6, 100);

    // move exactly same perform twice.
    model.move("C",500, 100, 300, 300, 10, 50);
    model.move("C", 300, 300, 300, 300, 10, 50);
  }


  // test changeColor
  @Test
  public void testChangeColor() {
    // add shape
    model.addShape("R", TypeOfShape.rectangle, 200, 200, 50,
            100, 1, 0, 0, 1, 100);
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 0, 1, 6, 100);

    // test change color
    model.changeColor("R", 1, 0, 0,15, 30, 50,
            50, 100);
    assertEquals("Shapes:\n" +
                    "Name: R\n" +
                    "Type: rectangle\n" +
                    "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: " +
                    "(1.0,0.0,0.0)Appears at t=1, Disappears at t=100\n" +
                    "\n" +
                    "Name: C\n" +
                    "Type: oval\n" +
                    "Center: (500.0,100.0), X radius: 60.0, Y radius: 30.0, Color: " +
                    "(0.0,0.0,1.0)Appears at t=6, Disappears at t=100\n" +
                    "\n" +
                    "Shape R changes color from (1.0,0.0,0.0) to (15.0,30.0,50.0), " +
                    "from time t=50 to t=100",
            model.getStatus());

    model.changeColor("C", 0, 0, 1, 20, 20, 30,
            50, 100);
    assertEquals("Shapes:\n" +
                    "Name: R\n" +
                    "Type: rectangle\n" +
                    "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: " +
                    "(1.0,0.0,0.0)Appears at t=1, Disappears at t=100\n" +
                    "\n" +
                    "Name: C\n" +
                    "Type: oval\n" +
                    "Center: (500.0,100.0), X radius: 60.0, Y radius: 30.0, Color: " +
                    "(0.0,0.0,1.0)Appears at t=6, Disappears at t=100\n" +
                    "\n" +
                    "Shape R changes color from (1.0,0.0,0.0) to (15.0,30.0,50.0), " +
                    "from time t=50 to t=100Shape C changes color from (0.0,0.0,1.0) to " +
                    "(20.0,20.0,30.0), from time t=50 to t=100",
            model.getStatus());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testChangeColor1() {
    // changeColor with not exist shape
    model.changeColor("A", 0, 1, 1, 20, 20, 30,
            50, 80);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testChangeColor2() {
    // add shape
    model.addShape("R", TypeOfShape.rectangle, 200, 200, 50,
            100, 1, 0, 0, 1, 100);

    // changeColor with bad from time input
    model.changeColor("R", 1, 0, 0, 20, 20, 20,
            -5, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testChangeColor3() {
    // add shape
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 0, 1, 6, 100);

    // changeColor with bad to time input
    model.changeColor("C", 0, 0, 1, 20, 20, 10,
            30, -10);
  }

  @Test//(expected = IllegalStateException.class)
  public void testChangeColor5() {
    // add shape
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 0, 1, 6, 100);

    // changeColor with overlapped time 10 - 50 and 25 - 70.
    model.changeColor("C", 0, 0, 1, 1, 2, 3,
            10, 50);
    model.changeColor("C", 1, 2, 3, 1, 2, 5,
            25, 70);
  }

  @Test//(expected = IllegalStateException.class)
  public void testChangeColor6() {
    // add shape
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 0, 1, 6, 100);

    // changeColor with overlapped time 10 - 50 and 10 - 50.
    model.changeColor("C", 0, 0, 1, 1, 2, 3,
            10, 50);
    model.changeColor("C", 1, 2, 3, 1, 2, 5,
            10, 50);
  }

  @Test//(expected = IllegalStateException.class)
  public void testChangeColor7() {
    // add shape
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 0, 1, 6, 100);

    // changeColor with overlapped time 10 - 50 and 5 - 15.
    model.changeColor("C", 0, 0, 1, 1, 2, 3,
            10, 50);
    model.changeColor("C", 1, 2, 3, 1, 2, 5,
            5, 15);
  }

  @Test//(expected = IllegalStateException.class)
  public void testChangeColor8() {
    // add shape
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 0, 1, 6, 100);

    // changeColor with overlapped time 10 - 50 and 15 - 20.
    model.changeColor("C", 0, 0, 1, 1, 2, 3,
            10, 50);
    model.changeColor("C", 1, 2, 3, 1, 2, 5,
            15, 20);
  }

  @Test//(expected = IllegalStateException.class)
  public void testChangeColor9() {
    // add shape
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 0, 1, 6, 100);

    // changeColor with overlapped time 10 - 50 and 5 - 60.
    model.changeColor("C", 0, 0, 1, 1, 2, 3,
            10, 50);
    model.changeColor("C", 1, 2, 3, 1, 2, 5,
            5, 60);
  }

  @Test//(expected = IllegalStateException.class)
  public void testChangeColor10() {
    // add shape
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 0, 1, 6, 100);

    // changeColor exactly same perform twice.
    model.changeColor("C", 0, 0, 1, 1, 2, 3,
            10, 50);
    model.changeColor("C", 0, 0, 1, 1, 2, 3,
            10, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testChangeColor11() {
    // add shape
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 0, 1, 6, 100);

    // changeColor with bad r
    model.changeColor("C", 0, 0, 1, 500, 2, 3,
            10, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testChangeColor12() {
    // add shape
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 0, 1, 6, 100);

    // changeColor with bad g
    model.changeColor("C", 0, 0, 1, 1, -6, 3,
            10, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testChangeColor13() {
    // add shape
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 0, 1, 6, 100);

    // changeColor with bad b
    model.changeColor("C", 0, 0, 1, 1, 2, 799,
            10, 50);
  }

  // test scale
  @Test
  public void testScale() {
    // add shape
    model.addShape("R", TypeOfShape.rectangle, 200, 200, 50,
            100, 1, 0, 0, 1, 100);
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 0, 1, 6, 100);

    // test scale
    model.scale("R", 60, 30, 15, 30,
            50, 100);
    assertEquals("Shapes:\n" +
                    "Name: R\n" +
                    "Type: rectangle\n" +
                    "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: " +
                    "(1.0,0.0,0.0)Appears at t=1, Disappears at t=100\n" +
                    "\n" +
                    "Name: C\n" +
                    "Type: oval\n" +
                    "Center: (500.0,100.0), X radius: 60.0, Y radius: 30.0, Color: " +
                    "(0.0,0.0,1.0)Appears at t=6, Disappears at t=100\n" +
                    "\n" +
                    "Shape R scales from Width: 60.0, Height: 30.0 to Width: 15.0, " +
                    "Height: 30.0, from time t=50 to t=100",
            model.getStatus());

    model.scale("C", 60, 30, 20, 20,
            30, 50);
    assertEquals("Shapes:\n" +
            "Name: R\n" +
            "Type: rectangle\n" +
            "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: " +
            "(1.0,0.0,0.0)Appears at t=1, Disappears at t=100\n" +
            "\n" +
            "Name: C\n" +
            "Type: oval\n" +
            "Center: (500.0,100.0), X radius: 60.0, Y radius: 30.0, Color: " +
            "(0.0,0.0,1.0)Appears at t=6, Disappears at t=100\n" +
            "\n" +
            "Shape C scales from Width: 60.0, Height: 30.0 to Width: 20.0, " +
            "Height: 20.0, from time t=30 to t=50Shape R scales from Width: 60.0, " +
            "Height: 30.0 to Width: 15.0, Height: 30.0, from time t=50 to t=100",
            model.getStatus());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testScale1() {
    // scale with not exist shape
    model.scale("A", 20, 10, 20, 20,
            30, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testScale2() {
    // add shape
    model.addShape("R", TypeOfShape.rectangle, 200, 200, 50,
            100, 1, 0, 0, 1, 100);

    // changeColor with bad from time input
    model.scale("R", 50, 100, 20, 20,
            -5, 20);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testScale3() {
    // add shape
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 0, 1, 6, 100);

    // changeColor with bad to time input
    // to time < from time
    model.scale("C", 60, 30, 20, 20,
            10, 3);
  }

  @Test//(expected = IllegalStateException.class)
  public void testScale5() {
    // add shape
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 0, 1, 6, 100);

    // scale with overlapped time 10 - 50 and 25 - 70.
    model.scale("C", 60, 30, 1, 2,
            10, 50);
    model.scale("C", 1, 2, 1, 3, 25, 70);
  }

  @Test//(expected = IllegalStateException.class)
  public void testScale6() {
    // add shape
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 0, 1, 6, 100);

    // scale with overlapped time 10 - 50 and 10 - 50.
    model.scale("C", 60, 30, 1, 2,
            10, 50);
    model.scale("C", 1, 2, 1, 3, 10, 50);
  }

  @Test//(expected = IllegalStateException.class)
  public void testScale7() {
    // add shape
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 0, 1, 6, 100);

    // scale with overlapped time 10 - 50 and 5 - 15.
    model.scale("C", 60, 30, 1, 2,
            10, 50);
    model.scale("C", 1, 2, 1, 3, 5, 15);
  }

  @Test//(expected = IllegalStateException.class)
  public void testScale8() {
    // add shape
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 0, 1, 6, 100);

    // scale with overlapped time 10 - 50 and 15 - 20.
    model.scale("C", 60, 30, 1, 2,
            10, 50);
    model.scale("C",1, 2, 1, 3, 15, 20);
  }

  @Test//(expected = IllegalStateException.class)
  public void testScale9() {
    // add shape
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 0, 1, 6, 100);

    // scale with overlapped time 10 - 50 and 5 - 60.
    model.scale("C", 60, 30, 1, 2,
            10, 50);
    model.scale("C", 1, 2, 1, 3, 5, 60);
  }

  @Test//(expected = IllegalStateException.class)
  public void testScale10() {
    // add shape
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 0, 1, 6, 100);

    // scale exactly same perform twice.
    model.scale("C", 60, 30, 1, 2,
            10, 50);
    model.scale("C",1 ,2, 1, 2, 10, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testScale11() {
    // add shape
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 0, 1, 6, 100);

    // scale with bad width
    model.scale("C", 60, 30, -2, 3,
            10, 50);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testScale12() {
    // add shape
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 0, 1, 6, 100);

    // scale with bad height
    model.scale("C", 60, 30, 2, -6,
            10, 50);
  }

  @Test//(expected = IllegalStateException.class)
  public void testScale13() {
    // add shape
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 0, 1, 6, 100);

    // perform exactly animation twice
    model.scale("C", 60, 30, 2, 3,
            10, 50);
    model.scale("C", 60, 30, 2, 3,
            10, 50);
  }

  // test getStatus
  @Test
  public void testGetStatus() {
    // add shape
    model.addShape("R", TypeOfShape.rectangle, 200, 200, 50,
            100, 1, 0, 0, 1, 100);
    model.addShape("C", TypeOfShape.oval, 500, 100, 60, 30,
            0, 0, 1, 6, 100);

    // add animations with unordered
    model.move("R", 300, 300, 200, 200, 70, 100);
    model.changeColor("C", 0, 0, 1, 0, 1, 0,
            50, 80);
    model.move("C", 500, 100, 500, 400, 20, 70);
    model.scale("R", 50, 100, 25, 100,
            51, 70);
    model.move("R", 200, 200, 300, 300, 10, 50);

    assertEquals("Shapes:\n" +
                    "Name: R\n" +
                    "Type: rectangle\n" +
                    "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: " +
                    "(1.0,0.0,0.0)Appears at t=1, Disappears at t=100\n" +
                    "\n" +
                    "Name: C\n" +
                    "Type: oval\n" +
                    "Center: (500.0,100.0), X radius: 60.0, Y radius: 30.0, Color: " +
                    "(0.0,0.0,1.0)Appears at t=6, Disappears at t=100\n" +
                    "\n" +
                    "Shape R moves from (200.0,200.0) to (300.0,300.0), from time " +
                    "t=10 to t=50Shape C moves from (500.0,100.0) to (500.0,400.0), " +
                    "from time t=20 to t=70Shape C changes color from (0.0,0.0,1.0) to " +
                    "(0.0,1.0,0.0), from time t=50 to t=80Shape R scales from Width: 50.0, " +
                    "Height: 100.0 to Width: 25.0, Height: 100.0, from time t=51 to t=70Shape " +
                    "R moves from (300.0,300.0) to (200.0,200.0), from time t=70 to t=100",
            model.getStatus());
  }
}
