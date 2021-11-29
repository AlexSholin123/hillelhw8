import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Character> characters = characterFactory();
        doFight(characters);
        massWeaponSetter(characters, new KnifeBehavior());
        System.out.println("Fight after switch weapons:\n");
        doFight(characters);
    }

    public static List<Character> characterFactory() {
        return List.of(
                new King(new SwordBehavior(), "Arthur"),
                new Queen(new BowAndArrowBehavior(), "Alice"),
                new Knight(new AxeBehavior(), "Richard"),
                new Troll(new KnifeBehavior(), "Grendel")
        );
    }

    public static void doFight(List<Character> characters) {
        for (Character c : characters) {
            c.fight();
        }
    }

    public static void massWeaponSetter(List<Character> characters, WeaponBehavior weapon) {
        for (Character c : characters) {
            c.setWeapon(weapon);
        }
    }
}
