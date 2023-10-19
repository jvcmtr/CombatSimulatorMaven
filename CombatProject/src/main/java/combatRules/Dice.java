package combatRules;

import java.util.Random;

public class Dice {
    private int d;
    private int ammount;

    public Dice(int ammount, int max){
        this.d = max;
        this.ammount = ammount;
    }
    public Dice(int max){
        this.d = max;
        this.ammount = 1;
    }

    public String toString(){
        return ammount+"d"+d;
    }

    public int roll(){
        Random rng = new Random();
        int total = 0;
        for (int i = 0; i < ammount; i++)
            total += rng.nextInt(d)+1;

        return total;
    }

    public static int roll(int D){
        Random rng = new Random();
        return (rng.nextInt(D)+1);
    }
}