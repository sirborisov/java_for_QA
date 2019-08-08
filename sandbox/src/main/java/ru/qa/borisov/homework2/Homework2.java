package ru.qa.borisov.homework2;

// вычисление расстояния между двумя точками на плоскости

public class Homework2 {

  public static void main(String[] args) {

    Point p = new Point(1, 2, 3, 4);
    System.out.println("Расстояние между точками с координатами " + p.x1 + "," + p.z1 + " и " + p.x2 + "," + p.z2 + " равняется " + p.distance());

  }
}
