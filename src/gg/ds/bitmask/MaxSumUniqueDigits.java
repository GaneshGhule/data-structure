package gg.ds.bitmask;

import java.util.HashMap;
import java.util.Map;

public class MaxSumUniqueDigits {

    HashMap<Integer, Integer> masks = new HashMap<>();

    public int getMask(int number){
        if(masks.containsKey(number)){
            return masks.get(number);
        }
        int mask = 0;
        while (number != 0){
            int digit = number%10;
            mask |= 1 << digit;
            number = number/10;
        }
        masks.put(number, mask);
        return mask;
    }

    public int maxSum(int []arr, int digits, Map<Integer, Integer> dp){
        if(dp.containsKey(digits)){
            return dp.get(digits);
        }
        int max = 0;
        for (int number: arr) {
            int mask = getMask(number);
            if((digits | mask) == digits){
                max = Math.max(max, number + maxSum(arr, digits ^ mask, dp));
            }
        }

        dp.put(digits, max);
        return max;
    }

    public static void main(String[] args) {
        MaxSumUniqueDigits obj = new MaxSumUniqueDigits();
        System.out.println(obj.maxSum(new int[]{24, 13, 42, 31}, 1023, new HashMap<>()));
        System.out.println(obj.maxSum(new int[]{22, 132, 4, 45, 12, 223}, 1023, new HashMap<>()));
        System.out.println(obj.maxSum(new int[]{1, 21, 32, 4, 5 }, 1023, new HashMap<>()));
        System.out.println(obj.maxSum(new int[]{12,22,42}, 1023, new HashMap<>()));
    }
}
