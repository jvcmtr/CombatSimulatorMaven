package Creatures;

import combatRules.Dice;

public class Kobold extends BaseClass {
    public Kobold(){
        this.name = "Kobold";
        this.FdD = new Dice(3, 2);
        this.PdV = 20;
        this.For = 4;
        this.Def =2;
        this.Agi =4;
    }
}

