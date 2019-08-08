package ru.qa.borisov.homework2;

public class Point {

  public double x1;
  public double z1;
  public double x2;
  public double z2;

  public Point (double x1, double z1, double x2, double z2) {
    this.x1 = x1;
    this.z1 = z1;
    this.x2 = x2;
    this.z2 = z2;
  }

  public double distance () {
    return Math.sqrt(((this.x2 - this.x1) * (this.x2 - this.x1)) + ((this.z2 - this.z1) * (this.z2 - this.z1)));
  }

}
