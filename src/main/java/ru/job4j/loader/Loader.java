package ru.job4j.loader;

public class Loader {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<Loader> loader = Loader.class;
        System.out.println("Класс переменной loader: " + loader);
        System.out.println("Загрузчик класса переменной loader:  " + loader.getClassLoader());

        Class<String> string = String.class;
        System.out.println("Класс переменной loader: " + string);
        System.out.println("Загрузчик класса переменной string:  " + string.getClassLoader());
    }
}
