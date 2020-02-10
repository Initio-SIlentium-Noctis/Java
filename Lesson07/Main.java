package Lesson07;

public class Main {

    static Cat[] cats = new Cat[5]; // создаём массив из 5 котов
    static Plate plate = new Plate(100); // создаём общую тарелку
    static int days = 2; // кол-во дней, в течение которых коты питаются

    public static void main(String[] args) {

        cats[0] = new Cat("Барсик", 20);
        cats[1] = new Cat("Мурзик", 15);
        cats[2] = new Cat("Апельсин", 45);
        cats[3] = new Cat("Фестр", 25);
        cats[4] = new Cat("Рыжик", 20);
        plate.info();
        dailyFeeding(); // запуск ежедневного цикла приёма пищи
    }

    public static void dailyFeeding() {
        for (int i = 0; i < days; i++) {
            System.out.println("== Идёт " + (i + 1) + " день кормёжки ==");
            for (int x = 0; x < cats.length; x++) {
                cats[x].eat(plate);
                cats[x].getFullness();
                plate.info();
                System.out.println(" ");
            }
            plate.increaseFood(80); // добавляем еду в тарелку после каждого дня
        }
            System.out.println(" ");
        results(); // вывод общих результатов в консоль
    } // конец метода dailyFeeding


    public static void results() {
        System.out.println("== ОБЩИЕ РЕЗУЛЬТАТЫ ===");
        System.out.println("Коты питались в течение "+days+" дней / дня");
        for (int x = 0; x < cats.length; x++) {
            cats[x].getFullness();
        }
    }
}
