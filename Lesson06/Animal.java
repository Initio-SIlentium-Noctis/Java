package Lesson06;

public class Animal {
    String name;

    public Animal () {
    }

    public Animal(String name) {
        this.name = name;
    }

    public void animalInfo() {
        System.out.println("Животное: " + name);
    }

    public void run(double x) {
        System.out.println("Животное пробежало "+x+" метров");
    }

    public void jump(double x) {
        System.out.println("Животное прыгнуло на "+x+" метров");
    }

    public void swim(double x) {
        System.out.println("Животное проплыло "+x+" метров");
    }
}


