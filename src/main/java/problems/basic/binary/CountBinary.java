package problems.basic.binary;

import java.util.function.IntConsumer;

/*
https://www.hackerrank.com/challenges/30-binary-numbers
 */
public class CountBinary implements IntConsumer {

    int maxConsecutiveOnes = 0;
    int currentConsecutiveOnes = 0;

    public static void main(String[] args) {
        var n = 439;
        var binaryString = Integer.toBinaryString(n);

        var cb = new CountBinary();

        binaryString.chars().forEach(cb);

        System.out.println(cb.maxConsecutiveOnes);

    }

    @Override
    public void accept(int i) {
        if (i == '1') {
            currentConsecutiveOnes++;
        }

        if (i == '0') {
            // reset
            currentConsecutiveOnes = 0;
        }

        if (currentConsecutiveOnes > maxConsecutiveOnes) {
            maxConsecutiveOnes = currentConsecutiveOnes;
        }

    }
}
