package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Book 1", 25);
        Book book2 = new Book("Book 2", 134);
        Book book3 = new Book("Book 3", 346);
        Book book4 = new Book("Clean code", 456);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        System.out.println("-".repeat(20));
        System.out.println("Первоначальный массив Книг");
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + ", " + book.getNumberPages());
        }
        System.out.println("-".repeat(20));
        System.out.println("Поменяли местами книги с индексом 0 и 3");
        Book temp = books[3];
        books[3] = books[0];
        books[0] = temp;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + ", " + book.getNumberPages());
        }
        System.out.println("-".repeat(20));
        System.out.println("Вывод книг с именем \"Clean code\"");
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + ", " + book.getNumberPages());
            }
        }
    }
}
