package Lesson03;
import java.util.Scanner;
import java.util.Random;


public class JavaApp {
    public static Scanner sc = new Scanner (System.in);
    public static Random rand = new Random();
    public static void main (String [] args) {
        gameStart();
    }

    public static void gameStart () {
        int x = rand.nextInt(10);
        int count = 1;
        int left = 3;
        for (int i = 1; i < 4; i++) {
            int d = gameCheck("Введите число в пределах от 0 до 9", 0, 9);
            if (d == x) {
                gameResult (count);
            } else {
                left--;
                System.out.println("Осталось попыток : "+left);
                count++;
            }
        }
        System.out.println("У вас закончились попытки !");
        gameEndTask ();
    }

    public static int gameCheck (String message, int min, int max) {
        int x;
        do {
            System.out.println(message);
            x = sc.nextInt();
        } while (x < min || x > max);
        return x;
    }

    public static void gameResult (int x) {
        System.out.println("Вы угадали ! Число попыток : "+x);
        gameEndTask ();
    }


    public static void gameEndTask () {
        int d = gameEndTaskCheck ("Повторить игру еще раз? 1 – да / 0 – нет", 1, 0);
        if (d == 1) {
            gameStart();
        } else {
            System.exit(0);
        }
    }

    public static int gameEndTaskCheck (String message, int yes, int no) {
        int x;
        do {
            System.out.println(message);
            x = sc.nextInt();
        } while (x != yes && x != no);
        return x;
    }
} // конец класса
