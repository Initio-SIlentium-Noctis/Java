package Lesson06;

public class JavaApp {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Барсик");
        Cat cat2 = new Bengal("Мурзик");
        Cat cat3 = new Siam("Рыжик");
        Dog dog1 = new Dog("Дружок");
        Dog dog2 = new Spaniel ("Джим");
        Dog dog3 = new Foxhound ("Бутч");
        cat1.run(200);
        cat1.jump(3);
        cat1.swim(1);
        cat2.run(300);
        cat2.jump(5);
        cat3.run(150);
        cat3.jump(2.1);
        cat3.swim(1);
        dog1.run(200);
        dog1.jump(0.5);
        dog1.swim(9);
        dog2.jump(0.4);
        dog3.run (1500);
    }
}
