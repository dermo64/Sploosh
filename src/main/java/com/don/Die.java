package main.java.com.don;

import java.util.Random;

public class Die {
    private int sides;

    static Random rand = new Random();

    public Die(int sides){
        this.sides = sides;
    }

    public int roll(){
        return rand.nextInt(sides)+1;
    }
}
