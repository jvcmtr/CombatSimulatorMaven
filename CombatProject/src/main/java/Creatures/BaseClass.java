package Creatures;

import combatRules.Dice;
import lombok.Data;
import lombok.Getter;

@Data
public abstract class BaseClass {

    @Getter protected String name;
    protected Dice FdD;
    protected int PdV;
    protected int For;
    protected int Def;
    protected int Agi;


    public boolean isDead(){
        return (PdV <= 0);
    }

    public void attack(BaseClass target){
        target.takeDamage( FdD.roll() );
    }

    public void takeDamage(int dmg){
        PdV -= dmg;
    };

    public int getIniciativa(){
        return Dice.roll(10)+Agi;
    }

    public int getFatorDeAtaque(){
        return Agi + For + Dice.roll(10);
    }

    public int getFatorDeDefesa(){
        return Agi + Def + Dice.roll(10);
    }

    public String getDetails(){
        int j = 10 - name.length();
        String spacing = "";
        for (int i = 0; i < j; i++)
            spacing += " ";

        return spacing + name + "  | Vida: " +  PdV + "  | Força: " + For + "  | Defesa: " + Def+ "  | Agilidade: "+Agi+ "  | Dano: "+FdD.toString();
    }


}