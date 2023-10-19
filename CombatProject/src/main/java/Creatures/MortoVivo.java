package Creatures;

import combatRules.Dice;

public class MortoVivo extends BaseClass{
    public MortoVivo(){
        this.name = "Morto-Vivo";
        this.FdD = new Dice(2, 4);
        this.PdV = 25;
        this.For = 4;
        this.Def =0;
        this.Agi =1;
    }
}

