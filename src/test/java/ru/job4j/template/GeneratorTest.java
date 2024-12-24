package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@Disabled
class GeneratorTest {
    @Test
    void whenTemplateMatchesKeysThenReturnCorrectString() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = Map.of(
                "name", "Petr Arsentev",
                "subject", "you"
        );
        Generator generator = new TemplateGenerator();
        String result = generator.produce(template, map);
        assertThat(result).isEqualTo("I am a Petr Arsentev, Who are you?");
    }

    @Test
    void whenMapHasExtraKeysThenThrowException() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = Map.of(
                "name", "Petr Arsentev",
                "subject", "you",
                "year", "1965"
        );
        Generator generator = new TemplateGenerator();
        assertThatThrownBy(() -> generator.produce(template, map))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("there are extra keys in the map");
    }

    @Test
    void whenKeyIsMissingInMapThenThrowException() {
        String template = "I am a ${name}.";
        Map<String, String> map = Map.of(
                "subject", "you"
        );
        Generator generator = new TemplateGenerator();
        assertThatThrownBy(() -> generator.produce(template, map))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Missing key");
    }

    @Test
    void whenTemplateIsEmptyThenReturnEmptyString() {
        String template = "";
        Map<String, String> map = Map.of(
                "name", "Petr Arsentev",
                "subject", "you"
        );
        Generator generator = new TemplateGenerator();
        String result = generator.produce(template, map);
        assertThat(result).isEmpty();
    }

    @Test
    void whenMapIsEmptyThenThrowException() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = Map.of();
        Generator generator = new TemplateGenerator();
        assertThatThrownBy(() -> generator.produce(template, map))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Map is empty");
    }

    @Test
    void whenTemplateHasEmptyKeysThenThrowException() {
        String template = "I am a ${}, Who are ${}?";
        Map<String, String> map = Map.of(
                "name", "Petr Arsentev",
                "subject", "you"
        );
        Generator generator = new TemplateGenerator();
        assertThatThrownBy(() -> generator.produce(template, map))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("The template contains invalid keys");
    }

    @Test
    void whenTemplateHasNoKeysThenReturnUnchangedTemplate() {
        String template = "I am a Petr Arsentev, Who are you?";
        Map<String, String> map = Map.of(
                "name", "Petr Arsentev",
                "subject", "you"
        );
        Generator generator = new TemplateGenerator();
        String result = generator.produce(template, map);
        assertThat(result).isEqualTo("I am a Petr Arsentev, Who are you?");
    }
}