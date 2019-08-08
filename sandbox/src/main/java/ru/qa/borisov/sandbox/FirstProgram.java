package ru.qa.borisov.sandbox;

public class FirstProgram {
  public static void main(String[] args) {
    hello("world");
    hello("space");
    hello("Human");

    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " равна " + s.area());

    Rectangle r = new Rectangle(10, 20);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " равна " + r.area());

  }

  public static void hello(String one) {
    System.out.println("Hello, " + one + "!");
  }

}
