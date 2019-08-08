package ru.qa.borisov.homework2;

// вычисление расстояния между двумя точками на плоскости

public class Homework2 {

  public static void main(String[] args) {

    Point p1 = new Point(1, 2);
    Point p2 = new Point(3, 4);
    System.out.println("Расстояние между точками с координатами " + p1.x + "," + p1.z + " и " + p2.x + "," + p2.z + " равняется " + distance(p1, p2));

  }

  public static double distance(Point p1, Point p2) {
    return Math.sqrt(((p2.x - p1.x) * (p2.x - p1.x)) + ((p2.z - p1.z) * (p2.z - p1.z)));
  }
}
