package ru.job4j.solid.ocp;

/*
При добавлении нового формата сериализации (например, YAML) потребуется модификация метода serialize.
Это нарушает принцип OCP.
 */
public class DataSerializer {
    public String serialize(Object data, String format) {
        if ("JSON".equals(format)) {
            return serializeToJson(data);
        } else if ("XML".equals(format)) {
            return serializeToXml(data);
        } else {
            throw new IllegalArgumentException("Unknown format");
        }
    }

    private String serializeToJson(Object data) {
        return "JSON representation";
    }

    private String serializeToXml(Object data) {
        return "XML representation";
    }
}
