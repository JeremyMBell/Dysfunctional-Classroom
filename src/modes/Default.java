package modes;
import frame.Character;
public class Default extends Mode {
    public static Character.Role[] getRoles() {
        Character.Role[] allRoles = Character.allRoles;
        Character.Role[] defaultRoles = new Character.Role[Mode.NUM_ROLES];
        
        //Team Dorks - 8 Players - one of them will be random
        defaultRoles[0] = allRoles[0];//Nerd
        defaultRoles[1] = allRoles[0];//Nerd
        defaultRoles[2] = allRoles[1];//Know-It-All
        defaultRoles[3] = allRoles[2];//High Achiever
        defaultRoles[4] = allRoles[3];//Frantic
        defaultRoles[5] = allRoles[4];//Class Clown
        defaultRoles[6] = allRoles[5];//Newspaper Reporter
        
        //Team Popular Kids - 3 Players
        defaultRoles[7] = allRoles[7];//Queen Bee
        defaultRoles[8] = allRoles[9];//Chatty Cathy
        defaultRoles[9] = allRoles[6];//Jock
        
        //Team Apathy - 4 Players
        defaultRoles[10] = allRoles[10];//Cheater
        defaultRoles[11] = allRoles[11];//Loner
        defaultRoles[12] = allRoles[12];//Hater
        defaultRoles[13] = allRoles[13];//Teacher
        
        defaultRoles[14] = Mode.getRandom(Character.Role.DORK);//Random Town Guy
        
        return defaultRoles;
    }
    
}
