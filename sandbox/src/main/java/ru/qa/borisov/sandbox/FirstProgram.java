package ru.qa.borisov.sandbox;

public class FirstProgram {
  public static void main(String[] args) {
    hello("world");
    hello("space");
    hello("Human");

    double len = 5;
    System.out.println("Площадь квадрата со стороной " + len + " равна " + area1(len));

    double a = 10;
    double b = 20;
    System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " равна " + area2(a,b));

  }

  public static void hello(String one) {
    System.out.println("Hello, " + one + "!");
  }

  public static double area1(double l) {
    return l*l;
  }

  public static double area2(double a, double b) {
    return a*b;
  }

}
