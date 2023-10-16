/*
Вариант 4
1. Дано натуральное число (более четырех знаков):
– найти количество нечетных цифр числа;
– верно ли, что цифра 5 встречается в числе более двух раз?

2. Найти все четырехзначные числа из промежутка [1000; 9990], у
которых сумма крайних цифр равна сумме средних цифр, а само число делится на 6 и 27.

3. Найти все натуральные числа из промежутка от 1 до 200, у которых сумма делителей равна S (S вводить с клавиатуры).

4. Вычислить значение функции F(x, y) для значений аргументов
x и y, выданных случайным образом в диапазоне (–15 до 25):

*/

import java.util.Scanner;

public class Main {

    static int cin(int min, int max) {
        Scanner sc = new Scanner(System.in);
        int number;

        while (true) {
            System.out.print("Введите целое число от " + min + " до " + max + ": ");
            if(sc.hasNextInt()) {
                number = sc.nextInt();
                if(number >= min && number <= max) {
                    sc.nextLine();
                    sc.close();
                    return number;
                }
                else {
                    System.out.println("Введенное число вне диапазона");
                    sc.nextLine();
                }
            }
            else {
                System.out.println("Вы ввели не целое число");
                sc.nextLine();
            }
        }
    }

    static void task1() {
        int number = cin(1, 9999);
        int uneven = 0;
        int five_count = 0;

        while (number != 0) {
            if (number % 10 % 2 == 0) {
                if (number % 10 == 5) {
                    ++five_count;
                }
                System.out.println("цифра " + number % 10 + " четная");
            } else {
                System.out.println("цифра " + number % 10 + " нечетная");
                ++uneven;
            }
            number /= 10;
        }

        System.out.println("Кол-во нечет чисел = " + uneven);
        if (five_count >= 2) {
            System.out.println("Цифра 5 встретилась более 2ух раз: " + five_count);
        }
        else {
            System.out.println("Цифра 5 встретилась менее 2ух раз: " + five_count);
        }
    }

    static void task2() {
        for (int num = 1000; num <= 9999; num++) {
            if (num % 6 == 0 && num % 27 == 0) {
                int n4 = num % 10;
                int n3 = num / 10 % 10;
                int n2 = num / 100 % 10;
                int n1 = num / 1000;
                if (n1 + n4 == n2 + n3) {
                    System.out.println(num + ": " + n1 + "-" + n2 + "-" + n3 + "-" + n4);
                }
            }
        }
    }

    static void task3() {
        int sum_del = cin(1, 200);
        int cur_sum;
        for (int num = 1; num <= 200; num++) {
            cur_sum = 0;
            for (int i = 1; i <= num / 2; i++) {
                if (num % i == 0) {
                    cur_sum += i;
                }
            }
            if (cur_sum == sum_del) {
                System.out.println("У числа " + num + " сумма делителей = " + sum_del);
            }
        }
    }

    public static void main(String[] args) {
        task3();

    }
}