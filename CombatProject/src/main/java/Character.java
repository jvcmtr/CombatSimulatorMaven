
import Creatures.BaseClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor @Getter @Setter
public class Character {
    @NonNull String nickname;
    @NonNull BaseClass heroi;
}