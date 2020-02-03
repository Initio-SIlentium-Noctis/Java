package Lesson06;

public class Bengal extends Cat {

    public Bengal (String name) {
        this.name = name;
    }

    public void run(double x) {
        if (x <= 300) {
            System.out.println(this.name+" пробежал/-а "+x+" метра/-ов");
        } else {
            System.out.println("Бенгальский кот не может пробежать больше 300 метров");
        }

    }

    public void jump(double x) {
        if (x <= 4) {
            System.out.println(this.name+" прыгнул/-а на "+x+" метра/-ов");
        } else {
            System.out.println("Бенгальский кот не может прыгнуть выше 4 метров");
        }

    }
}
