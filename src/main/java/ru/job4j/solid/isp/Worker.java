package ru.job4j.solid.isp;

public interface Worker {
    void work();

    void cookFood();
}
/*
Интерфейс содержит метод cookFood(), который не имеет отношения к основной
задаче разработчика, но класс обязан его реализовать.
 */

class Developer implements Worker {
    @Override
    public void work() {
        System.out.println("Developer is coding");
    }

    @Override
    public void cookFood() {
    }
}