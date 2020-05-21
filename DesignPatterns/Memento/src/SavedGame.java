import java.util.Stack;

public class SavedGame {

    private Stack<GameCharacter.GameCharacterMemento> characterMementos = new Stack<>();


    public void save(GameCharacter gameCharacter){
        characterMementos.push(gameCharacter.getMemento());
    }

    public void goBackToLastSave(GameCharacter gameCharacter){
        if(characterMementos.isEmpty()){
            System.out.println("Can't revert");
        }else{
            gameCharacter.loadFromMemento(characterMementos.pop());
        }
    }

}
