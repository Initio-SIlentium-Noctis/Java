package Lesson06;

public class Siam extends Cat {

    public Siam (String name) {
        this.name = name;
    }

    public void run(double x) {
        if (x <= 200) {
            System.out.println(this.name+" пробежал/-а "+x+" метра/-ов");
        } else {
            System.out.println("Бенгальский кот не может пробежать больше 200 метров");
        }

    }

    public void jump(double x) {
        if (x <= 3) {
            System.out.println(this.name+" прыгнул/-а на "+x+" метра/-ов");
        } else {
            System.out.println("Бенгальский кот не может прыгнуть выше 3 метров");
        }

    }
}
