package Lesson07;

public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }

    public boolean checkFood (int n) {
        if (this.food >= n) { // проверяем, хватает ли еды для кота + защита от отрицательного значения еды в тарелке
            return true;
        }
        else
            System.out.println("Внимание ! В тарелке не хватает еды для следующего кота");
        return false;
    }

    public void decreaseFood(int n) {
        this.food -= n;
    }

    public void increaseFood(int n) { // метод позволяет добавить еду в тарелку
        this.food += n;
    }

    public void info() {
        if (this.food == 0) {
            System.out.println("Тарелка пуста !");
        } else
        System.out.println("В тарелке еды : " + food);
    }
}

