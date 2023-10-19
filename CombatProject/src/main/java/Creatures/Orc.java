package Creatures;
import combatRules.Dice;

public class Orc extends BaseClass {
    public Orc(){
        this.name = "Orc";
        this.FdD = new Dice(1, 8);
        this.PdV = 20;
        this.For = 6;
        this.Def =2;
        this.Agi =2;
    }
}
