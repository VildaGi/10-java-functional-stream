package com.example.task03;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Task03Main {

    public static void main(String[] args) {

        findMinMax(
                Stream.of(2, 9, 5, 4, 8, 1, 3),
                Integer::compareTo,
                (min, max) ->
                        System.out.println("min: " + min + " / max: " + max)
        );

    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        class MinMax {
            T min = null;
            T max = null;
            boolean isEmpty = true;
        }

        MinMax holder = stream.collect(
                MinMax::new,
                (h, t) -> {
                    if (h.isEmpty) {
                        h.min = t;
                        h.max = t;
                        h.isEmpty = false;
                    } else {
                        if (order.compare(t, h.min) < 0) {
                            h.min = t;
                        }
                        if (order.compare(t, h.max) > 0) {
                            h.max = t;
                        }
                    }
                },
                (h1, h2) -> {
                    if (h1.isEmpty) {
                        h1.min = h2.min;
                        h1.max = h2.max;
                        h1.isEmpty = h2.isEmpty;
                    } else if (!h2.isEmpty) {
                        if (order.compare(h2.min, h1.min) < 0) {
                            h1.min = h2.min;
                        }
                        if (order.compare(h2.max, h1.max) > 0) {
                            h1.max = h2.max;
                        }
                    }
                }
        );

        if (holder.isEmpty)
            minMaxConsumer.accept(null, null);
        else
            minMaxConsumer.accept(holder.min, holder.max);
    }
}
