package com.don;
import main.java.com.don.Die;
import java.util.*;

public class Sploosh {

    static int [] diceArray = {4,8,12,12,12,10,20,20,20};
    List<Integer> rolls = new ArrayList<Integer>();
    List<Die> dice = new ArrayList<Die>();
    List<Integer> outcomes = new ArrayList<Integer>();
    List<Integer> outcomes2 = new ArrayList<Integer>();

    private static final int ITERATIONS = 10000000;

    public static void main(String[] args) {
        Sploosh sploosh = new Sploosh();
        for (int sides: diceArray){
            sploosh.addDie(new Die(sides));
        }
        int boats=0, quads = 0, splooshes = 0, allMatch = 0, seven = 0 , eight = 0, five = 0, six = 0, four = 0;

        for(int i=0;i<ITERATIONS;i++){
            sploosh.genRolls();
            sploosh.getOutcomes();

            if (sploosh.hasBoat()) boats++;
            if (sploosh.nMatch(4)) four++;
            if (sploosh.hasQuads()) quads++;
            if (sploosh.isSploosh()) splooshes++;
            if (sploosh.allMatch()) allMatch++;
            if (sploosh.nMatch(5)) five++;
            if (sploosh.nMatch(6)) six++;
            if (sploosh.nMatch(7)) seven++;
            if (sploosh.nMatch(8)) eight++;
        }
        String summary = String.format(
                "Simulation results (%d iterations)%n" +
                        "  Boats:      %.6f%n" +
                        "  Quads:      %.6f%n" +
                        "  Splooshes:  %.6f%n" +
                        "  All match:  %d%n" +
                        "  4-match:    %d%n" +
                        "  5-match:    %.6f%n" +
                        "  6-match:    %.6f%n" +
                        "  7-match:    %d%n" +
                        "  8-match:    %d",
                ITERATIONS,
                (double) boats / ITERATIONS,
                (double) quads / ITERATIONS,
                (double) splooshes / ITERATIONS,
                allMatch,
                four,
                (double) five / ITERATIONS,
                (double) six / ITERATIONS,
                seven,
                eight
        );
        System.out.println(summary);
    }
    public void addDie(Die die){
        dice.add(die);
    }
    public List<Integer> genRolls() {
        rolls.clear();
        for (Die die : dice) {
            rolls.add(new Integer(die.roll()));
        }
        Collections.sort(rolls);
        return rolls;
    }
    public List<Integer> getOutcomes(){
         outcomes.clear();
        outcomes2.clear();
         int prev = 0, count =1;
         for(int roll: rolls){
             if(roll == prev){
                 count++;
             } else {
                 prev = roll;
                 if (count > 1){
                     outcomes.add(count);
                     count = 1;
                 }
             }
         }
        if (count > 1) {
            outcomes.add(count);
        }
        return outcomes;
    }
    public boolean hasBoat(){
        return outcomes.contains(2) && outcomes.contains(3);
    }
    public boolean hasQuads(){
        return outcomes.contains(4);
    }
    public boolean isSploosh(){
        return outcomes.size()==0;
    }
    public boolean allMatch(){
        return outcomes.size()==1 && outcomes.get(0) == rolls.size();
    }
    public boolean nMatch(int n){
        return rolls.size()>=n && outcomes.contains(n);
    }
}
