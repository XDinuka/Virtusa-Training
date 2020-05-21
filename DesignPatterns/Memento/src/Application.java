public class Application {


    public static void main(String[] args) {


        SavedGame savedGame = new SavedGame();

        GameCharacter ezio_auditore = new GameCharacter("Ezio Auditore");

        ezio_auditore.move(CharacterMovement.MOVE_FORWARD);
        savedGame.save(ezio_auditore);
        System.out.println(ezio_auditore);

        ezio_auditore.move(CharacterMovement.TURN_LEFT);
        savedGame.save(ezio_auditore);
        System.out.println(ezio_auditore);

        ezio_auditore.move(CharacterMovement.JUMP_FORWARD);
        savedGame.save(ezio_auditore);
        System.out.println(ezio_auditore);

        ezio_auditore.move(CharacterMovement.MOVE_FORWARD);
        savedGame.save(ezio_auditore);
        System.out.println(ezio_auditore);

        ezio_auditore.move(CharacterMovement.TURN_RIGHT);
        savedGame.save(ezio_auditore);
        System.out.println(ezio_auditore);

        savedGame.goBackToLastSave(ezio_auditore);
        System.out.println(ezio_auditore);

        savedGame.goBackToLastSave(ezio_auditore);
        System.out.println(ezio_auditore);

        savedGame.goBackToLastSave(ezio_auditore);
        System.out.println(ezio_auditore);





        SavedGame savedGame1 = new SavedGame();

        GameCharacter shay_cormac = new GameCharacter("Shay Cormac");

        shay_cormac.move(CharacterMovement.MOVE_FORWARD);
        System.out.println(shay_cormac);

        shay_cormac.move(CharacterMovement.MOVE_FORWARD);
        System.out.println(shay_cormac);

        shay_cormac.move(CharacterMovement.MOVE_FORWARD);
        System.out.println(shay_cormac);

        shay_cormac.move(CharacterMovement.MOVE_FORWARD);
        System.out.println(shay_cormac);

        shay_cormac.move(CharacterMovement.MOVE_FORWARD);
        System.out.println(shay_cormac);

        savedGame1.save(shay_cormac);
        System.out.println(shay_cormac);

        shay_cormac.move(CharacterMovement.JUMP_FORWARD);
        System.out.println(shay_cormac);

        savedGame1.goBackToLastSave(shay_cormac);
        System.out.println(shay_cormac);







    }
}
