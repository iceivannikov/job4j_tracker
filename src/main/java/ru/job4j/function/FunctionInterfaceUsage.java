package ru.job4j.function;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.*;

public class FunctionInterfaceUsage {
    public static void main(String[] args) {
        System.out.println("1. Supplier (поставщик)");
        Supplier<String> supplier = () -> "New String For Interface";
        System.out.println("2. Consumer и BiConsumer");
        Consumer<String> consumer = System.out::println;
        consumer.accept(supplier.get());
        BiConsumer<String, String> consumer1 = (first, second) -> System.out.println(first + second);
        consumer1.accept(supplier.get(), " and Second String");
        List<String> list = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> supplier1 = () -> new HashSet<>(list);
        Set<String> strings = supplier1.get();
        for (String string : strings) {
            System.out.println(string);
        }
        Supplier<Set<String>> supplier2 = () -> new HashSet<>(list);
        BiConsumer<Integer, String> consumer2 = (first, second) -> System.out.println(first + second);
        Set<String> strings2 = supplier2.get();
        int i = 1;
        for (String string : strings2) {
            consumer2.accept(i++, " is " + string);
        }
        System.out.println("3. Predicate (BiPredicate)");
        Predicate<String> predicate = String::isEmpty;
        System.out.println("Строка пустая: " + predicate.test(""));
        System.out.println("Строка пустая: " + predicate.test("test"));
        BiPredicate<String, Integer> condition = (string, number) -> string.contains(number.toString());
        System.out.println("Строка содержит подстроку: " + condition.test("Name123", 123));
        System.out.println("Строка содержит подстроку: " + condition.test("Name", 123));
        System.out.println("4. Function (BiFunction)");
        Function<String, Character> function = string -> string.charAt(2);
        System.out.println("Третий символ в строке: " + function.apply("first"));
        System.out.println("Третий символ в строке: " + function.apply("second"));
        BiFunction<String, Integer, String> biFunction = (string, number) -> string.concat(" ")
                .concat(number.toString());
        System.out.println("Результат работы бифункции: " + biFunction.apply("Name", 123));
        System.out.println("Результат работы бифункции: " + biFunction.apply("String number", 12345));
        System.out.println("5. UnaryOperator и BinaryOperator");
        UnaryOperator<StringBuilder> builder = StringBuilder::reverse;
        System.out.println("Строка после реверса: " + builder.apply(new StringBuilder("String for test")));
        System.out.println("Строка после реверса: " + builder.apply(new StringBuilder("tset rof gnirtS")));
        BinaryOperator<StringBuilder> builder1 = (first, second) -> first.append(" ").append(second);
        System.out.println(
                "Строка после объединения: " + builder1.apply(
                        new StringBuilder("First string"),
                        new StringBuilder("Second string")
                )
        );
    }
}
