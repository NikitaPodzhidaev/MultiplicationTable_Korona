package ru.shift.io;
import java.io.BufferedReader;
import java.io.IOException;

public class InputHandler {// обработка входного значения

    public static int getInput(BufferedReader bufferedReader) {
        int size;
        System.out.println("<--- Программа по выводу квадратной таблицы умножения --->");

        while (true) {
            String sizeInString;
            System.out.print("Введите размер таблицы умножения (от 1 до 32): ");

            try {
                sizeInString = bufferedReader.readLine();
            } catch (IOException ioe) {
                System.out.println("<--- ошибка ввода, ввели что-то неподходящее --->");
                askForInputAgain();
                continue;
            }
            if (sizeInString == null) {
                System.out.println("<--- ошибка ввода, попробуйте снова! --->");
                askForInputAgain();
                continue;
            }
            if (sizeInString.trim().isEmpty()) {
                System.out.println("<--- пустой ввод, попробуйте снова! --->");
                askForInputAgain();
                continue;
            }

            try {
                size = Integer.parseInt(sizeInString);
                if (size < 1 || size > 32) {
                    System.out.println("<--- ошибка ввода, размер может принимать значение от 1 до 32 --->");
                    continue;
                }
                break;
            } catch (NumberFormatException nfe) {
                System.out.println("<--- ошибка ввода, введённое не является числом --->");
            }

        }
        return size;
    }

    private static void askForInputAgain(){
        System.out.print("Попробуйте еще раз: ");
    }
}
