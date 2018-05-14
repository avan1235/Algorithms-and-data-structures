/**
 * Created by Maciej Procyk on 14.05.2018.
 */

import algorithms.basic.*;

import java.util.Arrays;


public class Tester {
    public static void main(String... args){
        int[] testingTable = new int[10];
        for(int i = 0; i < testingTable.length; i++){
            testingTable[i] = (int) (Math.random()*testingTable.length) + 1;
        }

        int findValue  = (int) (Math.random()*testingTable.length);

        System.out.println(findValue);
        System.out.println(Arrays.toString(testingTable));

        System.out.println(findInTable.firstPosition(testingTable, findValue));

        int[] poweredTable = new int[testingTable.length];
        for(int i = 0; i < poweredTable.length; i++){
            poweredTable[i] = MathOperations.power(testingTable[i], findValue);
        }

        System.out.println(Arrays.toString(poweredTable));

        System.out.println("NWD of " + Arrays.toString(testingTable) + " = " + MathOperations.manyNWD(testingTable));
    }
}
