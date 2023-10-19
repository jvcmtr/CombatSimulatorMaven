package Creatures;

import combatRules.Dice;

public class Fighter extends BaseClass {

    public Fighter(){
        this.name = "Guerreiro";
        this.FdD = new Dice(2, 4);
        this.PdV = 12;
        this.For = 4;
        this.Def =3;
        this.Agi =3;
    }

}

