package HW5;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

//Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
//        Добавить функции 1) Добавление номера
//        2) Вывод всего
//        Пример:
//        Я ввожу: 1
//        К: Введите фамилию
//        Я: Иванов
//        К: Введите номер
//        Я: 1242353
//        К: Введите 1) Добавление номера
//        2) Вывод всего
//        Я ввожу: 1
//        К: Введите фамилию
//        Я: Иванов
//        К: Введите номер
//        Я: 547568
//        К: Введите 1) Добавление номера
//        2) Вывод всего
//        Я: 2
//        Иванов: 1242353, 547568
public class Task1 {
    public static void main(String[] args) {

        phoneBook.put("Иванов", "12345");
        phoneBook.put("Петров", "67890");
//        phoneBook.put(12675, "Сидоров");
//        phoneBook.put(12665, "Смирнов");
//        phoneBook.put(88905, "Иванов");
//        phoneBook.put(14325, "Егоров");
//        phoneBook.put(34345, "Григорьев");
//        phoneBook.put(64535, "Кудряшов");
//        phoneBook.put(75345, "Петров");
//        phoneBook.put(56345, "Смирнов");
//        phoneBook.put(89345, "Смирнов");
        isOn();
//        addNumber();
    }

    public static HashMap<String, String> phoneBook = new HashMap<>();
    public static boolean powerOn = true;

    public static void isOn() {
        while (powerOn) {
            mainMenu();
        }
    }

    public static void mainMenu() {

        System.out.println("\nВас приветствует телефонный справочник!\n\n Выберите действие: \n 1.Добавить номер\n " +
                "2.Найти абонента\n 3.Посмотреть весь справочник\n 4.Выход ");
        int button = button();
        if (button == 1) {
            addNumber();
        }
        if (button == 2) {
            searchSubscriber(phoneBook);
        }
        if (button == 3) {
            printBook();
        }
        if (button == 4) {
            Exit();
        }
    }

    public static int button() {
        Scanner sc = new Scanner(System.in);
        int button = sc.nextInt();
        return button;
    }

    public static void Exit() {
        System.out.println("Спасибо, что воспользовались нашим приложением!");
        powerOn = false;
    }

    public static void addNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите фамилию абонента: ");
        String lastName = sc.nextLine();
        System.out.print("Введите номер: ");
        String number = sc.nextLine();
        if (!phoneBook.containsKey(lastName)) {
            phoneBook.put(lastName, number);
            System.out.println(String.format("\nДобавлен Абонент: %s номер %s\n", lastName, number));
        } else {
            phoneBook.put(lastName, phoneBook.get(lastName) + " " + number);
            System.out.println(String.format("\nАбоненту: %s добавлен номер: %s", lastName, number));
        }
    }

    public static void searchSubscriber(HashMap<String, String> phoneBook) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите фамилию абонента ");
        String subscriber = sc.nextLine();
        if (phoneBook.containsKey(subscriber)) {
            System.out.println(String.format("\nАбонент: %s номер(а): %s ", subscriber, phoneBook.get(subscriber)));
        } else {
            System.out.println(String.format("\nАбонент %s не найден ", subscriber));
        }
    }

    public static void printBook() {
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.putAll(phoneBook);
        treeMap.forEach((key,value)-> System.out.println(String.format("Абонент: %s номер(а): %s ", key, value)));
    }
}
