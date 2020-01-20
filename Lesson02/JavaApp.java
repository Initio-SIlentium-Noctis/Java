package Lesson02;

public class JavaApp {
    public static void main (String [] args) {

        int [] arr = {2, 2, 2, 1, 2, 2, 10, 1};

        invertArray(); // 01. Метод заменяет 0 на 1 (и 1 на 0) в массиве
        fillArray(); // 02. Метод создаёт массив и заполняет его с помощью цикла
        changeArray(); // 03. Метод уножает на 2 все элементы в массиве, значения которых меньше 6
        fillDiagonal(); // 04. Метод заменяет значения диагональных элементов (обе диагонали) массива на "1"
        minMax(); // 05. Метод выводит в консоль минимальное и максимальное значение элементов в массиве
    }

    public static void invertArray() {
        int[] arr = { 1, 0, 1, 0, 0, 1 };
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" "); // выведет в консоль значения массива для проверки
        }
        System.out.println(); // для удобства просмотра, чтобы каждый массив из нового метода - на новой строке
    }

    public static void fillArray() {
        int[] arr = new int [8];
        for (int i = 0, j = 0; j < arr.length; i = i + 3, j++) {
            arr[j] = i;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" "); // аналогично с методом #1
        }
        System.out.println(); // аналогично с методом #1
    }

    public static void changeArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " "); // аналогично с методом #1
        }
        System.out.println(); // аналогично с методом #1
    }

    public static void fillDiagonal() {
        int[][] arr = new int[5][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j || i + j == arr.length -1) {
                    arr[i][j] = 1;
                }
            }
        }
        // следующий блок этого метода нужен только при необходимости вывода значений массива в консоль для проверки
        for (int i = 0; i < 5; i++) {
            System.out.println();
            for (int j = 0; j < 5; j++) {
                System.out.print(arr[i][j]+" ");
            }
        }
        System.out.println(); // аналогично с методом #1
        System.out.println(); // повторный переход на новую строку, чтобы отделить двумерный массив от следующего
    }

    public static void minMax() {
        int [] arr = {8, 3, 24, -2, 11, 0, 2, -3, 4, 7, 5, 1};
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Минимальное значение в массиве "+min);
        System.out.println("Максимальное значение в массиве "+max);
    }


}