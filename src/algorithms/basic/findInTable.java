package algorithms.basic;

import java.util.Arrays;

/**
 * Created by Maciej Procyk on 14.05.2018.
 */
public class findInTable {
    /**
     *
     * @param table in which we are going to find a value
     * @param value to be found in table
     * @return position of value in table or -1 when the value is not in table
     */

    public static int positionInTable(int[] table, int value){
        int[] copiedTable = Arrays.copyOf(table, table.length+1);
        copiedTable[table.length] = value;

        int i = 0;
        while (copiedTable[i] != copiedTable[table.length]){
            i++;
        }

        if(i != table.length){
            return i;
        }
        else{
            return -1;
        }
    }
}
