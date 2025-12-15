package com.example.task04;

import java.util.List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class Task04Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, "UTF-8"))) {

            String regex = "[\\s,\\.!?;:\\-()$${}'\"“”]+";
            Map<String, Long> freqMap = reader.lines()
                    .flatMap(line -> Arrays.stream(line.split(regex)))
                    .filter(s -> !s.isEmpty())
                    .map(String::toLowerCase)
                    .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

            List<String> result = freqMap.entrySet().stream()
                    .sorted(Comparator
                            .comparing((Map.Entry<String, Long> e) -> e.getValue(), Comparator.reverseOrder())
                            .thenComparing(Map.Entry::getKey))
                    .limit(10)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());

            result.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
