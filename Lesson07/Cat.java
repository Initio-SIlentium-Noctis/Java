package Lesson07;

public class Cat {
    private String name;
    private int appetite;
    private boolean fullness;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = false; //по умолчанию у каждого кота сытость = false
    }

    public void eat(Plate p) {
        if (p.checkFood(appetite)){ // проверяем хватает ли еды в тарелке
            p.decreaseFood(appetite); // если хватает еды - убираем еду из тарелки
            this.fullness = true; // устанавливаем сытость кота = true
        } else this.fullness = false; // если еды не хватает - устанавливаем сытость кота = false
    }

    public void getFullness() {
        if (this.fullness == true) {
            System.out.println ("Кот "+this.name+" - сытый");
        } else System.out.println ("Кот "+this.name+" НЕ доедает !");
    }
}
