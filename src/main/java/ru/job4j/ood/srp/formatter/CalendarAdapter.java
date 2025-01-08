package ru.job4j.ood.srp.formatter;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.util.Calendar;

public class CalendarAdapter extends XmlAdapter<String, Calendar> {
    private DateTimeParser<Calendar> parser;

    public CalendarAdapter() {
    }

    public CalendarAdapter(DateTimeParser<Calendar> parser) {
        this.parser = parser;
    }

    @Override
    public Calendar unmarshal(String s) {
        throw new RuntimeException("Parsing string to Calendar is not supported.");
    }

    @Override
    public String marshal(Calendar calendar) {
        if (calendar == null) {
            return null;
        }
        return parser.parse(calendar);
    }
}
