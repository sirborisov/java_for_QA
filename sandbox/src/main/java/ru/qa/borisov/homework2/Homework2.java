package ru.qa.borisov.homework2;

// вычисление расстояния между двумя точками на плоскости

public class Homework2 {

  public static void main(String[] args) {

    Point p1 = new Point(1, 2);
    Point p2 = new Point(3, 4);
    System.out.println("Расстояние между точками с координатами " + p1.x + "," + p1.z + " и " + p2.x + "," + p2.z + " равняется " + p1.distance(p2));

  }
}
