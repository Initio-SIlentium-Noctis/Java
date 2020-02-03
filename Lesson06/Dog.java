package Lesson06;

public class Dog extends Animal {

    public Dog () {
    }

    public Dog(String name) {
        this.name = name;
    }

    public void run(double x) {
        if (x <= 500) {
            System.out.println(this.name+" пробежал/-а "+x+" метра/-ов");
        } else {
            System.out.println("Собака не может пробежать больше 500 метров");
        }

    }

    public void jump(double x) {
        if (x <= 0.5) {
            System.out.println(this.name+" прыгнул/-а на "+x+" метра/-ов");
        } else {
            System.out.println("Собака не может прыгнуть выше полуметра");
        }

    }

    public void swim(double x) {
        if (x <= 10) {
            System.out.println(this.name + " проплыл/-а на " + x + " метра/-ов");
        } else {
            System.out.println("Собака не может проплыть более 10 метров");
        }
    }
}
