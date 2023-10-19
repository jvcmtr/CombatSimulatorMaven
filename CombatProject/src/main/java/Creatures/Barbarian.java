package Creatures;

import combatRules.Dice;

public class Barbarian extends BaseClass {
    public Barbarian(){
        this.name = "Barbaro";
        this.FdD = new Dice(2, 6);
        this.PdV = 13;
        this.For = 6;
        this.Def = 1;
        this.Agi = 3;
    }
}
