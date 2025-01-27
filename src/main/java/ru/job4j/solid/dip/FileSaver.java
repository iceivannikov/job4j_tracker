package ru.job4j.solid.dip;

class FileSaver {
    public void saveToFile(String data) {
        System.out.println("Saving data to file: " + data);
    }
}

/*
В методе processData создается конкретный объект FileSaver. Это приводит к жесткой зависимости от
конкретной реализации, вместо того чтобы зависеть от абстракции.
 */

class DataProcessor {
    public void processData(String data) {
        FileSaver fileSaver = new FileSaver();
        fileSaver.saveToFile(data);
    }
}
