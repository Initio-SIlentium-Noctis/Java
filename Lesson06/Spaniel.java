package Lesson06;

public class Spaniel extends Dog {

    public Spaniel (String name) {
        this.name = name;
    }

    public void jump(double x) {
        if (x <= 0.3) {
            System.out.println(this.name+" прыгнул/-а на "+x+" метра/-ов");
        } else {
            System.out.println("Спаниэль не может прыгнуть выше 0.3 метра");
        }

    }
}
