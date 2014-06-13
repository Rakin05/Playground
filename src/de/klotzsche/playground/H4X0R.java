package de.klotzsche.playground;

import java.util.stream.IntStream;

/**
 * Created by Felix Klotzsche on 12.06.2014.
 */
public class H4X0R {

    public static void main(String[] args) {
        IntStream.range(42, 100).filter(i -> checkPasscode(i)).forEach(System.out::println);
    }

    public static boolean checkPasscode(int H4X0R) {
        boolean result = false;
        for (int E1337 = 42; E1337 <= (52 ^ (0x6c)); E1337 += (3 << (14 % 6))) {
            if (result = ((++E1337 | E1337 + (2 >>> 1)) ^ (1 + H4X0R)) == 0) break;
        }
        return result;
    }
}
