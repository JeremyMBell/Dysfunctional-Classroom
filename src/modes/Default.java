package modes;
import frame.Character;
public class Default extends Mode {
    public static Character.Role[] getRoles() {
        Character.Role[] defaultRoles = new Character.Role[Mode.NUM_ROLES];
        
        //Team Dorks - 8 Players - one of them will be random
        defaultRoles[0] = Character.Role.nerd;//Nerd
        defaultRoles[1] = Character.Role.nerd;//Nerd
        defaultRoles[2] = Character.Role.tutor;//Tutor
        defaultRoles[3] = Character.Role.highAchiever;//High Achiever
        defaultRoles[4] = Character.Role.frantic;//Frantic
        defaultRoles[5] = Character.Role.classClown;//Class Clown
        defaultRoles[6] = Character.Role.newspaperReporter;//Newspaper Reporter
        
        //Team Popular Kids - 3 Players
        defaultRoles[7] = Character.Role.queenBee;//Queen Bee
        defaultRoles[8] = Character.Role.chattyCathy;//Chatty Cathy
        defaultRoles[9] = Character.Role.jock;//Jock
        
        //Team Apathy - 4 Players
        defaultRoles[10] = Character.Role.cheater;//Cheater
        defaultRoles[11] = Character.Role.loner;//Loner
        defaultRoles[12] = Character.Role.hater;//Hater
        defaultRoles[13] = Character.Role.teacher;//Teacher
        
        defaultRoles[14] = getRandom(Character.Team.dork);//Random Dork
        
        return defaultRoles;
    }
    
}
