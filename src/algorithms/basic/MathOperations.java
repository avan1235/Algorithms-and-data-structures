package algorithms.basic;

import java.util.Arrays;

/**
 * Created by Maciej Procyk on 14.05.2018.
 */
public class MathOperations {
    public static boolean isOdd(int number){
        if(number%2 == 1){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * having power we see it as the binary number
     * so 6^13 = 6^8 + 6^4 + 6^1 because
     * 13_10 == 1101_2 so 6^13 = 1*6^8 + 1*6^4 + 0*6^2 + 1*6^1 where 0 is usually missed
     * @param value
     * @param power
     * @return value to the power of {@power} when {@power} is greater than -1 and -1 when power is negative number
     */
    public static int power(int value, int power){
        if(power >= 0){
            int result  = 1;
            int actMuliplayer = value;
            int workingPower = power;
            while (workingPower != 0){
                if (MathOperations.isOdd(workingPower)){
                    result *= actMuliplayer;
                }
                workingPower /= 2;
                actMuliplayer = actMuliplayer*actMuliplayer;
            }

            return result;
        }
        else{
            return -1;
        }
    }

    private static int NWDActive(int bigger, int smaller){
        int rest = bigger % smaller;
        while (rest != 0){
            bigger = smaller;
            smaller = rest;
            rest = bigger % smaller;
        }
        return smaller;
    }

    public static int NWD(int a, int b){
        if (a > b){
            return MathOperations.NWDActive(a,b);
        }
        else {
            return MathOperations.NWDActive(b,a);
        }
    }

    private static void mergeNWD(int[] values, int l, int r){
        int actNWD = NWD(values[l], values[(l+r)/2 + 1]);
        for(int i = l; i <= r; i++){
            values[i] = actNWD;
        }
    }

    private static void manyNWDActive(int[] values, int l, int r){
        if(r > l){
            manyNWDActive(values, l, (l+r)/2);
            manyNWDActive(values, (l+r)/2 + 1, r);
            mergeNWD(values, l, r);
        }
    }

    public static int manyNWD(int... values){
        manyNWDActive(values, 0, values.length-1);
        return values[0];
    }
}
