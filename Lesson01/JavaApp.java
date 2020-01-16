package Lesson01;

public class JavaApp {
    public static void main (String [] args) {

    //список локальных переменных метода main

        int a = 2;
        int b = 11;
        int c = 24;
        int d = -6;
        int x = 1992;
        String name = "Евгений";

    // список поочерёдно вызываемых методов из метода main

        printTest(); // 01. метод напечатает проверочное сообщение в консоль
        printVariables(); // 02. Метод напечатает значения переменных пройденных типов
        System.out.println(calculate(a,b,c,d)); // 03. Метод выведет результат вычисления
        System.out.println (checkSum(c,d)); // 04. Метод принимает две целосисленные переменные, суммирует их и определяет, находится ли результат в диапозоне от 10 до 20
        System.out.println ("число "+a+" - "+checknum(a)); // 05. Метод выводит сообщение о том, какое число передали (положительное или отрицательное)
        System.out.println (isNegative(d)); // 06. Метод выводит true, если переданное число - отрицательное
        printName(name); // 07. Метод принимает текстовую строку с именем и выводит сообщение о приветствии
        System.out.println (x+" год - "+checkYear(x)); // 08. Метод принимает переменную и выводит сообщение о том, является ли год високосным
    }

    // список методов, вызываемых методом main

    public static void printTest() {
        System.out.println ("Тестовое сообщение");
    }

    public static void printVariables () {
        byte a = -10;
        short b = 15848;
        int c = 5;
        long d = 9835671;
        float e = 1.25f;
        double f = 1.256;
        char g = 98;
        boolean h = false;
        System.out.println ("a="+a+" b="+b+" c="+c+" d="+d+" e="+e+" f="+f+" g="+g+" h="+h);
    }

    public static int calculate(int a, int b, int c, int d) {
        int num;
        num = a * (b + (c / d));
        return num;
    }

    public static boolean checkSum(int x, int y) {
        boolean result;
        int num = x + y;
        if (num >= 10 && num <= 20) {
            result = true;
            return result;
        } else {
            result = false;
            return result;
        }
    }

    public static String checknum(int x) {
        String result;
        if (x >= 0) {
            result = "положительное";
        } else {
            result = "отрицательное";
        }
        return result;
    }

    public static boolean isNegative(int x) {
        boolean result;
        if (x >= 0) {
            result = false;
        } else {
            result = true;
        }
        return result;
    }

    public static void printName(String name) {
        System.out.println ("Привет, "+name+" !");
    }

    public static String checkYear (int x) {
        String result;
        if (x % 400 == 0 && x % 100 !=0 || x % 4 ==0) {
            result = "високосный";
        } else {
            result = "не високосный";
        }
        return result;
    }

}
