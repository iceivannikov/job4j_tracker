package ru.job4j.solid.isp;

public interface Animal {
    void eat();

    void fly();

    void swim();
}

/*
Класс Dog вынужден реализовывать метод fly(), который ему не нужен.
Это создаёт ненужные зависимости и делает код менее читаемым.
 */

class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("Dog is eating");
    }

    @Override
    public void fly() {
        // Пустая реализация
    }

    @Override
    public void swim() {
        System.out.println("Dog is swimming");
    }
}
