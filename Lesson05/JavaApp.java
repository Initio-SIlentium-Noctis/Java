package Lesson05;

public class JavaApp {

    static Employee[] arr = new Employee[5]; // создание массива из объектов "Employee"

    public static void main(String[] args) {

     /*
     Заполнение каждого элемента массива конкретными данными
    */
        arr[0] = new Employee("Обоев", "Рулон", "Олегович", "уборщик", "Rulon123@gmail.com", "+79151231843", 3000, 21);
        arr[1] = new Employee("Иванов", "Иван", "Иванович", "помощник директора", "Ja.Pomoshnik@gmail.com", "+79168963401", 125000, 41);
        arr[2] = new Employee("Кастоев", "Роман", "Сергеевич", "бухгалтер", "I.like.money999@gmail.com", "+79265157365", 25500, 34);
        arr[3] = new Employee("Совин", "Дмитрий", "Анатольевич", "менеджер", "Sovin1994@gmail.com", "+79150316381", 30000, 26);
        arr[4] = new Employee("Толстосумов", "Руслан", "Валерьевич", "главный директор", "T.Sumov@gmail.com", "+79267861234", 250000, 55);

        System.out.println ("Сотрудники фирмы старше 40 : ");

     /*
     Цикл проверки каждого элемента массива на значение переменной "age"
    */

        for (int i = 0; i < arr.length ; i++) {
          if (arr[i].age > 40) {
               arr[i].getInfo();
           }  else {
              continue; }
        } // конец цикла for
    } // конец метода main
} // конец класса JavaApp

class Employee {

    /*
     Переменные класса "Employee"
    */

    String surname;
    String name;
    String patronymic;
    String position;
    String email;
    String phoneNumber;
    int salary;
    int age;

    /*
     Конструктор класса "Employee"
    */

    public Employee(String surname, String name, String patronymic, String position, String email, String phoneNumber, int salary, int age) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    /*
     Вывод в консоль полной информации о сотруднике
    */

    public void getInfo () {
        System.out.println(this.surname+" "+this.name+" "+this.patronymic+" "+this.position+" "+this.email+" "+this.phoneNumber+" "+this.salary+" руб. "+"Возраст : "+this.age);
    }
}
