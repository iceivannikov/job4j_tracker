package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String massage;

    public Error() {
    }

    public Error(boolean active, int status, String massage) {
        this.active = active;
        this.status = status;
        this.massage = massage;
    }

    public void printInfo() {
        System.out.println(this.active);
        System.out.println(this.status);
        System.out.println(this.massage);
        System.out.println("-".repeat(10));
    }

    public static void main(String[] args) {
        Error eDefault = new Error();
        eDefault.printInfo();
        Error eParam = new Error(true, 10, "message");
        eParam.printInfo();
    }
}
