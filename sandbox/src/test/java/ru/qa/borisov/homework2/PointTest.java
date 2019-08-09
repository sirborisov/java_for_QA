package ru.qa.borisov.homework2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

  @Test

  public void testDistance0() {
    Point p1 = new Point(1, 2);
    Point p2 = new Point(3, 4);
    Assert.assertEquals(p1.distance(p2), 2.8284271247461903);

  }

  @Test

  public void testDistance1() {
    Point p1 = new Point(1, 2);
    Point p2 = new Point(3, 4);
    Assert.assertTrue(p1.distance(p2) > 2.82);

  }

  @Test

  public void testDistance2() {
    Point p1 = new Point(1, 2);
    Point p2 = new Point(3, 4);
    Assert.assertNotEquals(p1.distance(p2), 2.82);
  }

  @Test

  public void testDistance3() {
    Point p1 = new Point(1, 2);
    Point p2 = new Point(3, 4);
    Assert.assertNotNull(p1.distance(p2));
  }

}
