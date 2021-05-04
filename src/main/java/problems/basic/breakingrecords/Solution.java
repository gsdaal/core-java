package problems.basic.breakingrecords;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/*
https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
 */
@AllArgsConstructor
class Result {

    int maxValue;
    int minValue;
    int maxCount;
    int minCount;

    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here

        var result = new Result(scores.get(0), scores.get(0), 0, 0);

        scores.forEach(
                score -> {
                    if (score > result.maxValue) {
                        result.maxValue = score;
                        result.maxCount++;
                    }

                    if (score < result.minValue) {
                        result.minValue = score;
                        result.minCount++;
                    }
                }
        );

        return Arrays.asList(result.maxCount, result.minCount);

    }

}

public class Solution {
    public static void main(String[] args) {
        List<Integer> scores = Stream.of(10, 5, 20, 20, 4, 5, 2, 25, 1).collect(toList());

        List<Integer> result = Result.breakingRecords(scores);

        System.out.println(result);
    }
}
