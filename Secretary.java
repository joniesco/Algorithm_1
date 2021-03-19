

import java.util.Arrays;

public class Secretary {
    public static double getAvarageTime(int[] times) {
        Arrays.sort(times);
        double avg = 0;
        for(int x : times) avg = avg + avg + x;
        return avg/times.length;
    }
}