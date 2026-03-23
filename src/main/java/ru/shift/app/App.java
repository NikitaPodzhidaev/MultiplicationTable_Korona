package ru.shift.app;

import ru.shift.core.MultiplyTable;
import ru.shift.io.InputHandler;
import ru.shift.io.TablePrinter;

import java.io.BufferedReader;

public class App {

    private App(){}

    public static void run(BufferedReader bufferedReader){
        int size = InputHandler.getInput(bufferedReader); // обработка ввода числа(размер)
        TablePrinter.printTable(MultiplyTable.getTableOfNumbers(size));
    }
}
