import java.util.ArrayList;

public class GameCharacter {

    private String name;
    private ArrayList<CharacterMovement> characterMovements;

    public GameCharacter(String name) {
        this.name = name;
        characterMovements = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void move(CharacterMovement characterMovement){
        characterMovements.add(characterMovement);
    }

    public ArrayList<CharacterMovement> getCharacterMovements() {
        return (ArrayList<CharacterMovement>) characterMovements.clone();
    }

    public GameCharacterMemento getMemento() {
        return new GameCharacterMemento(getCharacterMovements());
    }

    public void loadFromMemento(GameCharacterMemento gameCharacterMemento) {
        characterMovements = gameCharacterMemento.characterMovements;
    }

    @Override
    public String toString() {
        return "GameCharacter{" +
                "name='" + name + '\'' +
                ", characterMovements=" + characterMovements +
                '}';
    }

    public static class GameCharacterMemento {

        private ArrayList<CharacterMovement> characterMovements;

        public GameCharacterMemento(ArrayList<CharacterMovement> characterMovements) {
            this.characterMovements = characterMovements;
        }

        private ArrayList<CharacterMovement> getCharacterMovements() {
            return characterMovements;
        }

    }


}
