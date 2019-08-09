package ru.qa.borisov.homework2;

public class Point {

  public double x;
  public double z;

  public Point (double x, double z) {
    this.x = x;
    this.z = z;

  }

  public double distance (Point p2) {
    return Math.sqrt(((p2.x - this.x) * (p2.x - this.x)) + ((p2.z - this.z) * (p2.z - this.z)));
  }

}
