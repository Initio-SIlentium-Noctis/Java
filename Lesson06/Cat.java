package Lesson06;

public class Cat extends Animal {

    public Cat () {
    }

    public Cat(String name) {
        this.name = name;
    }

    public void run(double x) {
        if (x <= 150) {
            System.out.println(this.name+" пробежал/-а "+x+" метра/-ов");
        } else {
            System.out.println("Симский кот не может пробежать больше 150 метров");
        }

    }

    public void jump(double x) {
        if (x <= 2) {
            System.out.println(this.name+" прыгнул/-а на "+x+" метра/-ов");
        } else {
            System.out.println("Симский кот не может прыгнуть выше 2 метров");
        }

    }

    public void swim(double x) {
            System.out.println("Коты плавать не умеют !");

    }

}
