package concurrency;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.concurrent.CompletableFuture.supplyAsync;

public class UsingCompletableFuture {
    /*
    1. create a stream of numbers
    2. n^2 each item
    3. sqrt(n) each item
    4. Sum all values
    5. Print that number
    */
    public static void main(String[] args) {
        final int streamLength = 3;

        Stream<CompletableFuture<Double>> completableFutureStream = IntStream.range(1, streamLength)
                .mapToObj(x -> {
                    return supplyAsync(() -> x);
                })
                .map(c -> c.thenApply(UsingCompletableFuture::square))
                .map(d -> d.thenApply(UsingCompletableFuture::sqRoot));

        Optional<CompletableFuture<Double>> reduce = completableFutureStream
                .reduce((d1, d2) -> d1.thenCombine(d2, Double::sum));

        reduce.map(c -> c.thenAccept(System.out::println));

    }

    private static Integer square(Integer i) {
        return i * i;
    }

    private static Double sqRoot(Integer i) {
        return Math.sqrt(i.doubleValue());
    }
}
