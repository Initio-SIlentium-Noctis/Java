package Lesson04;
import java.util.Scanner;
import java.util.Random;

public class JavaApp {

    /*
     объявление локальных пермеменных и создание экземпляров необходимых объектов
    */

    public static char[][] map;
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main (String [] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }


    /*
     инициализация двумерного массива и заполнение каждого элемента
     символом пустого поля '•'
    */

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    /*
     печать двумерного массива в консоль
    */

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /*
     ход человека : считывание из консоли координат и проверка является ли поле пустым
    */

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); //лог. оператор '!' нужен, чтобы если вернулось true - цикл наоборот прекращался, а не продолжался
        map[y][x] = DOT_X;
    }

    /*
     ход AI : случайное число в пределах SIZE и проверка является ли поле пустым
    */

    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y)); //лог. оператор '!' нужен, чтобы если вернулось true - цикл наоборот прекращался, а не продолжался
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    /*
     проверка наличия символов по указанным коориднатам (X,O - вернуть false; '•' - вернуть true)
    */

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    /*
    Проверка заполненности массивов
    */

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    /*
    Метод для поля 5x5 и 4 фишек
    */

    public static boolean checkWin(char dot) {
        int count = 1;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j <= (SIZE - DOTS_TO_WIN) + 1; j++) {
                if (map[i][j] == map[i][j + 1] && map[i][j] == dot) {
                    count++;
                    if (count == DOTS_TO_WIN) {
                        return true;
                    }
                    if (j == (SIZE - DOTS_TO_WIN) + 1) {
                        if (map[i][j] == map[i][j + 1] && map[i][j] == map[i][j + 2] && map[i][j] == dot) {
                            count++;
                            if (count == DOTS_TO_WIN) {
                                return true;
                            }
                        }
                    }
                }
                if (count == DOTS_TO_WIN) {
                    return true;
                }
            }
        } // конец проверки в строчку

        count = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j <= (SIZE - DOTS_TO_WIN) + 1; j++) {
                if (map[j][i] == map[j + 1][i] && map[j][i] == dot) {
                    count++;
                    if (count == DOTS_TO_WIN) {
                        return true;
                    }
                    if (j == (SIZE - DOTS_TO_WIN) + 1) {
                        if (map[j][i] == map[j + 1][i] && map[j][i] == map[j + 2][i] && map[j][i] == dot) {
                            count++;
                            if (count == DOTS_TO_WIN) {
                                return true;
                            }
                        }
                    }
                }
                if (count == DOTS_TO_WIN) {
                    return true;
                }
            }
        } // конец проверки в столбик

        count = 0;
        for (int i = 1, j = 0; i <= (SIZE - DOTS_TO_WIN); i++) {
            if (map[i][j] == map[i + 1][j + 1] && map[i][j] == map[i + 2][j + 2] && map[i][j] == map[i + 3][j + 3] && map[i][j] == dot) {
                count++;
                if (count == DOTS_TO_WIN) {
                    return true;
                    }
                }
            } // конец проверки по диагонали 1

            count = 0;
            for (int i = 0, j = 1; i <= (SIZE - DOTS_TO_WIN); i++) {
                if (map[i][j] == map[i + 1][j + 1] && map[i][j] == map[i + 2][j + 2] && map[i][j] == map[i + 3][j + 3] && map[i][j] == dot) {
                    count++;
                    if (count == DOTS_TO_WIN) {
                        return true;
                    }
                }
            } // конец проверки по диагонали 2

        count = 0;
        for (int i = 0, j = 0; i <= (SIZE - DOTS_TO_WIN); i++, j++) {
            if (map[i][j] == map[i + 1][j + 1] && map[i][j] == dot) {
                count++;
                if (count == DOTS_TO_WIN) {
                    return true;
                }
            }
        } // конец проверки по диагонали 3

        count = 0;
        for (int i = 0, j = 3; i < (SIZE - DOTS_TO_WIN); i++) {
            if (map[i][j] == map[i + 1][j - 1] && map[i][j] == map[i + 2][j - 2] && map[i][j] == map[i + 3][j - 3] && map[i][j] == dot) {
                count++;
                if (count == DOTS_TO_WIN) {
                    return true;
                }
            }
        } // конец проверки по диагонали 4

        count = 0;
        for (int i = 1, j = 4; i <= (SIZE - DOTS_TO_WIN); i++) {
            if (map[i][j] == map[i + 1][j - 1] && map[i][j] == map[i + 2][j - 2] && map[i][j] == map[i + 3][j - 3] && map[i][j] == dot) {
                count++;
                if (count == DOTS_TO_WIN) {
                    return true;
                }
            }
        } // конец проверки по диагонали 5

        count = 0;
        for (int i = 0, j = 4; i <= (SIZE - DOTS_TO_WIN); i++, j--) {
            if (map[i][j] == map[i + 1][j - 1] && map[i][j] == dot) {
                count++;
                if (count == DOTS_TO_WIN) {
                    return true;
                }
            }
        } // конец проверки по диагонали 6

        return false;
    } // конец метода

} // конец класса
