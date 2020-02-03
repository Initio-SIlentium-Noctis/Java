package Lesson06;

public class Foxhound extends Dog {

    public Foxhound (String name) {
        this.name = name;
    }

    public void run(double x) {
        if (x <= 1500) {
            System.out.println(this.name+" пробежал/-а "+x+" метра/-ов");
        } else {
            System.out.println("Английская гончая не может пробежать больше 1500 метров");
        }

    }
}
