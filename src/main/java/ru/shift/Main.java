package ru.shift;

import ru.shift.app.App;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            App.run(bufferedReader);
        } catch (Exception e) {
            System.err.println("ошибка!: " + e.getMessage());
        }
    }
}