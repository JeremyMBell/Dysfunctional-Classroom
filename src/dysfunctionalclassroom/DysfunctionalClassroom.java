package dysfunctionalclassroom;
import frame.Character;
import modes.Default;
import modes.Mode;
public class DysfunctionalClassroom {
    public static void main(String[] args) {
        Character.Role[] game = Default.getRoles();
        for (int i = 0; i < game.length; i++)
            System.out.println(game[i].getRole() + " \n\tObj.:\t" + game[i].getDescription() + "\n\tTeam:\t" + game[i].getObjective());
    }
    
}
