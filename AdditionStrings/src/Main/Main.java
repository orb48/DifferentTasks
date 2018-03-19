package Main;

import AdditionStrings.AdditionString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите два положительных числа");
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.nextLine();
        System.out.println(first + " + " + second + " = " + AdditionString.addStings(first, second));
    }
}

