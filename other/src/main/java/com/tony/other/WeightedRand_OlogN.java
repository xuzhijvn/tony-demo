/*
 *       Copyright© (2020).
 */
package com.tony.other;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Random;

/**
 * @author tony
 * @create 2021-10-24
 * @description:
 */
public class WeightedRand_OlogN {

    private int sum;

    private Integer[] array;

    private int[] input;

    private HashMap<Integer, Integer> map = new HashMap<>();

    public WeightedRand_OlogN(int[] input) {
        // show me your code
        this.input = input;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
            map.put(input[i], i);
        }
        this.array = Arrays.stream(input).boxed().toArray(Integer[]::new);
        Arrays.sort(this.array, Comparator.reverseOrder());
    }

    public int next() {
        // show me your code, please delete the next line
        Random random = new Random();
        int tmp = random.nextInt(sum);
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= tmp) {
                return map.get(array[i]);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = {4, 1, 3, 2};
        for (int i = 0; i < 10; i++) {
            System.out.println(new WeightedRand_OlogN(array).next());
        }
    }
}
