package frame;

import java.util.LinkedList;

public class Character {
    public final static Role[] allRoles = 
    {
        //----------------------------------------------------------------------
        //  TEAM DORKS
        //----------------------------------------------------------------------
        //Nerd will score perfect on tests
        new Role("Nerd", "You're the geek in the top-tenth percentile in your school.", Role.DORK, new int[] {Role.CANT_FAIL}),
        
        //Know-it-all thinks they're a nerd until teacher fails them
        new Role("Nerd", "You're the geek in the top-tenth percentile in your school.", Role.DORK, new int[] {Role.NONE}),
        
        //High Achiever will not be distracted by popular kids
        new Role("High Achiever", "You're focused on your goals, and will not let the popular kids ruin it.", Role.DORK, new int[] {Role.POPULAR_KID}),
        
        //Frantic won't let cheating happen and will have teacher fired if they
        //fail their test
        new Role("Frantic", "You're paranoid someone else will ruin your grade.", Role.DORK, new int[] {Role.TATTLE}),
        
        //Class Clown has 3 votes since his words hold much weight
        new Role("Class Clown", "Everyone respects you and your silliness.", Role.DORK, new int[]{Role.VOTE}),
        
        //Newspaper Reporter will find out someone's role between tests
        new Role("Newspaper Reporter", "You stalk people under a pseudonym and find their secrets.", Role.DORK, new int[]{Role.PUBLISH}),
        
        //----------------------------------------------------------------------
        //  TEAM POPULAR KIDS
        //----------------------------------------------------------------------
        //Jock will beat up kids of the same gender for their answers.
        new Role("Jock", "You need to keep your academic eligibility by \"asking\" for answers.", Role.POPULAR_KID, new int[]{Role.BEAT_UP}),
        
        //Queen Bee will scare people of class
        new Role("Queen Bee", "You're like the most popular girl in school.", Role.POPULAR_KID, new int[]{Role.SCARE}),
        
        //Nympho is a basically a jock, but copies the opposite gender
        new Role("Nympho", "You manipulate people into giving you their answers.", Role.POPULAR_KID, new int[] {Role.CHARM}),
        
        //Chatty Cathy cancels most people's abilities.
        new Role("Chatty Cathy", "You talk and talk and talk and ta...", Role.POPULAR_KID, new int[]{Role.DISTRACT}),
        
        //----------------------------------------------------------------------
        //  TEAM APATHY
        //----------------------------------------------------------------------
        
        //Cheater will switch tests with a person and give them a failing test
        new Role("Cheater", "You know how to swap names and that's it.", Role.NEUTRAL, new int[]{Role.SWITCH_TESTS}),
        
        //Loner wants to be ostracized to transfer
        new Role("Loner", "None of your friends are in your class, and your parents don't want you to fail.", Role.LONER, new int[]{Role.NONE}),
        
        //Hater hates someone and wants them ostracize
        new Role("Hater", "Ugh! You got stuck in class with the WORST person in the world.", Role.BETRAYER, new int[]{Role.NONE}),
        
        //Teacher hates everyone and can fail someone -- before someone notices
        new Role("Teacher", "You're stuck with these rascals.", Role.TEACHER, new int[]{Role.FAIL})
    };
    private Role role;
    private final String name;
    private final Boolean isMale;
    private Boolean failed = false;
    public Character(Role a, String b) {
        role = a;
        name = b;
        double rand = Math.floor(Math.random() * 2);
        if(a.getRole().toString().equals("Queen Bee") || rand != 0)
            isMale = false;
        else isMale = true;
        
    }
    
    //Item hiding
    public String getRole() {return role.getRole();}
    public String getRoleDesc() {return role.getDescription();}
    public String getObjective() {return role.getObjective();}
    public Role.Ability[] getAbilities() {return role.getAbilities();}
    public String getName() {return name;}
    public int getTeamID() {return role.getTeamID();}
    public Boolean isMale() {return isMale;}
    public void setRole(Role newRole) {role = newRole;}
    public Boolean targetedBy(Character attacker) {
        for (Role.Ability ablt:getAbilities())
            for (Role.Ability atkAblt: attacker.getAbilities())
                if (!ablt.targetedBy(atkAblt, attacker)) return false;
        failed = true;
        return true;
    }
    public static class Role {
        //----------------------------------------------------------------------
        //  Parent Class for all the roles.
        //  Each character needs a role.
        //  And roles determine objectives + abilities.
        //----------------------------------------------------------------------
        public final String[] objs = {
            "Get rid of the popular kids.",///////////////////////0
            "Get rid of the dorks.",//\\\\\\\\\\\\\\\\\\\\\\\\\\\\1
            "Get ostracized by the class.",///////////////////////2
            "Teach only one kid.",//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\3
            "Stay in class to the end.",//////////////////////////4
            "Get the person you hate ostracized at any cost."//\\\5
        };
        public static final int DORK = 0;
        public static final int POPULAR_KID = 1;
        public static final int LONER = 2;
        public static final int TEACHER = 3;
        public static final int NEUTRAL = 4;
        public static final int BETRAYER = 5;
        
        
        public static final Ability[] ablts = {
            new Ability("Teacher can't fail you", 0),
            new Ability("The popular kids don't affect you.", 1),
            new Ability("Tell on the cheater or the teacher if they try some foul play.", 2),
            new Ability("Beat up a same gender person for test answers. Beating up wrong people will make you fail.", 3),
            new Ability("Use your charms to get answers. Hitting on some people will rub them the wrong way.", 4),
            new Ability("Once you start joking around, class respect earns you 3 votes to ostracize.", 5),
            new Ability("Talk a person to death that they forget what they were doing.", 6),
            new Ability("Switch tests with someone, giving them a failing test.", 7),
            new Ability("Scare people out of the class during tests.", 8),
            new Ability("Text other popular kids during a test.", 9),
            new Ability("Fail a student you don't like. If you fail too many times, parents will notice.", 10),
            new Ability("None", 11),
            new Ability("Publish someone's role in the newspaper between tests.", 12)        
        };
        public static final int CANT_FAIL = 0;
        public static final int FOCUS = 1;
        public static final int TATTLE = 2;
        public static final int BEAT_UP = 3;
        public static final int CHARM = 4;
        public static final int VOTE = 5;
        public static final int DISTRACT = 6;
        public static final int SWITCH_TESTS = 7;
        public static final int SCARE = 8;
        public static final int FAIL = 10;
        public static final int TEXT = 9;
        public static final int NONE = 11;
        public static final int PUBLISH = 12;
        
        
        private final String role, desc;
        private final int obj;
        private final int[] ablt;
        public Role(String a, String b, int c, int[] d) {
            /** public Role(String a, String b, int c, int[] d)
             *  Parameters
             * String a - name of the Role.
             * String b - description of the role.
             * int c - an objective picked from the array
             * int[] d - abilities picked from the array
             */
            role = a;
            desc = b;
            obj = c;
            ablt = d;            
        }
        public String getRole() {return role;}
        public String getDescription() {return desc;}
        public String getObjective() {return objs[obj];}
        public Ability[] getAbilities() {
            Ability[] rtrn = new Ability[ablt.length];
            for (int i = 0; i < ablt.length; i++)
                rtrn[i] = ablts[ablt[i]];
            return rtrn;                
        }
        public int getTeamID() {return obj;}
        public int[] getAbilitiesID() {return ablt;}
        
        public static class Ability {
            private final String flavorText;
            private final int id;
            private Boolean attacked;
            private LinkedList<Character> attackedBy = new LinkedList<>();
            public Ability(String desc, int id) {
                flavorText = desc;
                this.id = id;
            }
            public Boolean targetedBy(Ability attacker, Character person) {
                attackedBy.add(person);
                attacked = true;
                Boolean isPopular = attacker.getID() == 3 ||
                            attacker.getID() == 4 || attacker.getID() == 6 ||
                            attacker.getID() == 8 || attacker.getID() == 9;
                //Nerd & Queen Bee & Frantic not affected by Teacher.
                if ((id == 0 || id == 2 || id == 8) && attacker.getID() == 10)
                    return false;
                
                //Queen Bee & Frantic not affected by Cheater
                else if ((id == 8 || id == 2) && attacker.getID() == 7)
                    return false;
                
                //Frantic not affected by popular kids.
                else if ((id == 2) && isPopular) return false;
                
                //Frantic isn't affected by Teacher
                else if (id == 2 && attacker.getID() == 10) return false;
                
                //Teacher isn't affected by anyone but frantic
                else if (id == 10 && attacker.getID() != 2) return false;
                
                //If it goes thru this whole thing, then they were successfully attacked
                else return true;
            }
            public void perform(Character me, Character victim) {
                if(!(id == 5 || id == 9 || id == 11 || id == 0 || id == 1 ||
                   id == 2 || victim == null)) victim.targetedBy(me);
                else if(id == 2 && attacked)
                    for (Character assailant:attackedBy)
                        assailant.targetedBy(me);
                        
            }
            
            public String toString(){return flavorText;}
            public int getID() {return id;}
            
        }
    }
    
}
