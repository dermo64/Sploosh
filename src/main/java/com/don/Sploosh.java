package com.don;

import java.util.*;

/**
 * Hello world!
 */
public class Sploosh {
    static Random rand = new Random();

    public static void main(String[] args) {
        Map<Integer, Integer> dice = new HashMap<>();
        dice.put(4, 1);
        dice.put(8, 1);
        dice.put(12, 3);
        dice.put(10, 1);
        dice.put(20, 3);

        List<Integer> rolls = genRolls(dice);
        for (Integer result : rolls) {
            System.out.println(result);
        }
        System.out.println("Hello World!");
    }


    private static List<Integer> get Result

    private static List<Integer> genRolls(Map<Integer, Integer> dice) {
        ArrayList rolls = new ArrayList();
        for (Integer die : dice.keySet()) {
            while (dice.get(die) > 0) {
                rolls.add(rand.nextInt(die)+1);
                dice.put(die, dice.get(die)-1);
            }
        }
        Collections.sort(rolls);
        return rolls;
    }
    class Outcome {
        int boat = 0;
        ArrayList<Integer> matches = new List<Integer>();
        public Outcome(List rolls){
            while (rolls.size()>0){

            }
        }
    }
}
