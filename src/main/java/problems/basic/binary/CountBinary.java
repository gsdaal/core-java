package problems.basic.binary;

public class CountBinary {

    int maxConsecutiveOnes = 0;
    int currentConsecutiveOnes = 0;

    public static void main(String[] args) {
        var n = 439;
        var binaryString = Integer.toBinaryString(n);

        CountBinary cb = new CountBinary();

        binaryString.chars().forEach(
                i -> {
                    if (i == '1') {
                        cb.currentConsecutiveOnes++;
                    }

                    if (i == '0') {
                        // reset
                        cb.currentConsecutiveOnes = 0;
                    }

                    if (cb.currentConsecutiveOnes > cb.maxConsecutiveOnes) {
                        cb.maxConsecutiveOnes = cb.currentConsecutiveOnes;
                    }
                }
        );

        System.out.println(cb.maxConsecutiveOnes);

    }
}
