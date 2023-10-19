package Creatures;
import combatRules.Dice;

public class Paladin extends BaseClass {
    public Paladin(){
        this.name = "Paladino";
        this.FdD = new Dice(2, 4);
        this.PdV = 15;
        this.For = 2;
        this.Def =5;
        this.Agi =1;
    }
}
