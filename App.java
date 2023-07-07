package HW_Java2;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class App {
    static Scanner scanner = new Scanner(System.in);
         public static void main(String[] args) throws Exception
    {
        System.out.println("Укажите номер задачи");
        System.out.println("1 - Задача 1");
        System.out.println("2 - Задача 2");
        System.out.println("4 - Задача 4");
        System.out.println("0 - Завершение работы");       

    int num = Integer.parseInt(scanner.nextLine());

        switch(num)
        {
            case 1:
                task1();
                break;
            case 2:
                task2();
                break;
            case 4:
                task4();
                break;
            case 0:
                System.out.print("Завершение работы приложения");
                break;
            default:
                System.out.printf("Неккоректный номер задачи,\n повторите попытку ввода.");
                break;
        }
    }

    public static void task1() {
        String input = "\"name\":\"Ivan\",\"country\":\"Russia\",\"city\":\"Moscow\",\"age\":\"14\"";
        System.out.println(input);
        Task1.parseString(input);
    }

    public static void task4() throws SecurityException, IOException {
        Logger logger = Logger.getLogger(App.class.getName());
        FileHandler fh = new FileHandler("Task4og.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormatter = new SimpleFormatter();
        fh.setFormatter(sFormatter);
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите первое число");
        int num1 = Integer.parseInt(iScanner.nextLine());
        logger.log(Level.INFO, "Пользователь ввел число " + num1);
        System.out.println("Введите арифметическую операцию +,-,*,/");
        String action = iScanner.nextLine();
        logger.log(Level.INFO, "Пользователь ввел операцию " + action);
        System.out.println("Введите второе число");
        int num2 = Integer.parseInt(iScanner.nextLine());
        logger.log(Level.INFO, "Пользователь ввел число " + num2);
        int result = Task4.calculator(num1, num2, action);
        System.out.println("Результат " + result);
        logger.log(Level.INFO, "Резуьтат операции " + result);
        System.out.println();
        iScanner.close();

    }

    public static void task2() throws SecurityException, IOException {
        int[] array = { 9, 8, 7, 6, 5 };
        System.out.println("\nИсходный массив");
        Task2.showArray(array);
        System.out.println("\nСортировка выполнена! Все итерации записаны в Task2Log.txt");
        Task2.bubbleSort(array);
        Task2.showArray(array);
    }

}
