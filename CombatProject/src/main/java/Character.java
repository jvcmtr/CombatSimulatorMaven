
import Creatures.BaseClass;

public class Character {
    private BaseClass Heroi;
    private String Nickname;

    public BaseClass getHeroi() {
        return Heroi;
    }

    public void setHeroi(BaseClass heroi) {
        Heroi = heroi;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String nickname) {
        Nickname = nickname;
    }

    public Character(String nick, BaseClass heroi){
        this.Heroi = heroi;
        this.Nickname = nick;
    }


}