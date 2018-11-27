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

      /*  List<Integer> rolls = genRolls(dice);
        for (Integer result : rolls) {
            System.out.println(result);
        }
        Map<Integer,Integer> outcomes = genOutcome(rolls);
        for(Integer key: outcomes.keySet()){
            System.out.println(outcomes.get(key) + " " + key + " of a kind");
        }*/


      //  AtomicInteger boats = new AtomicInteger(0);
        //AtomicInteger quads = new AtomicInteger(0);
        int boats=0;
        int quads=0;
        for(int i=0;i<1000000;i++){
            List<Integer> rolls = genRolls(dice);
       //     for (Integer result : rolls) {
         //       System.out.println(result);
         //   }
         //   System.out.println("i is " + i);
            Map<Integer,Integer> outcomes = genOutcome(rolls);

            if (hasBoat(outcomes)) boats++;
            if (hasQuads(outcomes)) quads++;
        }

        /*IntStream.range(0,1000000).forEach( nbr -> {
            List<Integer> rolls = genRolls(dice);
            Map<Integer,Integer> outcomes = genOutcome(rolls);
            if (hasBoat(outcomes)) boats.set(boats.getAndIncrement());
            if (hasQuads(outcomes)) quads.set(quads.getAndIncrement());

        });*/
        /*if (hasBoat(outcomes)) System.out.println("Has boat");
        if (hasQuads(outcomes)) System.out.println("Has quads");*/
        System.out.println("Hello World! Boats: " + boats + " quads: " + quads);
    }
    private static List<Integer> genRolls(Map<Integer, Integer> dice) {
        ArrayList rolls = new ArrayList();
        Map<Integer, Integer> mydice = new HashMap<>(dice);
        for (Integer die : mydice.keySet()) {
            while (mydice.get(die) > 0) {
                rolls.add(rand.nextInt(die)+1);
                mydice.put(die, mydice.get(die)-1);
            }
        }
        Collections.sort(rolls);
        return rolls;
    }
    public static Map<Integer, Integer> genOutcome(List<Integer> rolls){
        Map<Integer,Integer> matches = new HashMap<Integer,Integer>();
        while (rolls.size()>1){
            Integer roll = rolls.remove(0);
            int count = 1;
            while((rolls.size() > 0) && rolls.get(0).equals(roll)){
                count++;
                rolls.remove(0);
            }
            if (count > 1){
                if(matches.containsKey(count)){
                    matches.put(count, matches.get(count)+1);
                } else {
                    matches.put(count, 1);
                }
            }
        }
        return matches;
    }
    public static boolean hasBoat(Map<Integer,Integer>matches){
        return matches.containsKey(2) && matches.containsKey(3);
    }
    public static boolean hasQuads(Map<Integer,Integer>matches){
        return matches.containsKey(4);
    }
}
