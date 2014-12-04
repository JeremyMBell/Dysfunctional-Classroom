package modes;
import frame.Character;
public class Mode {
    public static final int NUM_ROLES = 15;
    public static Character.Role getRandom(int team) {
        //----------------------------------------------------------------------
        //Picks a random role. Specific to a team. If no team, put -1 as team.
        //----------------------------------------------------------------------
        Character.Role[] allRoles = Character.allRoles;
        Character.Role chosenRole = allRoles[(int) Math.floor(Math.random() * allRoles.length)];
        if (team == -1) return chosenRole;
        while(chosenRole.getTeamID() != team)
            chosenRole = allRoles[(int) Math.floor(Math.random() * allRoles.length)];
        return chosenRole;
    }
    public static Character.Role[] getRoles() {
        //----------------------------------------------------------------------
        //  This mode has any roles up for grab. All roles are random and not
        //  specific to a team.
        //----------------------------------------------------------------------
        Character.Role[] chosenRoles = new Character.Role[NUM_ROLES];
        for (int i = 0; i < chosenRoles.length; i++)
            chosenRoles[i] = getRandom(-1);
        return chosenRoles;
    }
}
