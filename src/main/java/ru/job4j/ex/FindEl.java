package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i] == null) {
                throw new ElementNotFoundException("Element is null");
            }
            if (key.equals(value[i])) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strings = {"Viktor", "Olga", null, "Ivan", "Oleg"};
        int index;
        try {
            index = indexOf(strings, "Ivan");
        } catch (ElementNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(index);
    }
}
