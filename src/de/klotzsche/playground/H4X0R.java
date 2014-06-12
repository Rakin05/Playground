package de.klotzsche.playground;

/**
 * Created by Felix Klotzsche on 12.06.2014.
 */
public class H4X0R {

    public static void main(String[] args) {
        for(int i = 42; i <= 999; i++)
            if(checkPasscode(i)) System.out.println(i);


    }

    public static boolean checkPasscode(int H4X0R) {
        boolean result = false;
        for (int E1337 = 42; E1337 <= (52 ^ (0x6c)); E1337 += (3 << (14 % 6))) {
            if (result = ((++E1337 | E1337 + (2 >>> 1)) ^ (1 + H4X0R)) == 0) break;
        }
        return result;
    }
}
