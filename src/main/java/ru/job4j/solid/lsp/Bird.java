package ru.job4j.solid.lsp;

/*
Программа ожидает, что любой объект класса Bird будет иметь возможность летать (fly()), но Penguin бросает исключение,
что нарушает контракт поведения базового класса.
 */
class Bird {
    public void fly() {
        System.out.println("The bird is flying");
    }
}

class Penguin extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins cannot fly");
    }
}

class Example1 {
    public static void main(String[] args) {
        Bird bird = new Penguin();
        bird.fly();
    }
}
