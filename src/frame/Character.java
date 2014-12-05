package frame;

import java.util.Arrays;
import java.util.LinkedList;

public class Character {
    private Role role;
    private final String name;
    private final Boolean isMale;
    private Boolean failed = false;
    public Character(Role a, String b) {
        role = a;
        name = b;
        double rand = Math.floor(Math.random() * 2);
        isMale = a == Role.queenBee || rand != 0;
        
    }
    public static enum Role {
        //======================================================================
        //Team
        //  Dorks
        //======================================================================
        //Nerd will score perfect on tests - no teacher/tutor intervention.
        nerd("Nerd", "You're the geek in the top-tenth percentile in your school.",
                Team.dork, new Ability[] {Ability.noFail},
                new Immunity[] {Immunity.teacher, Immunity.tutor}),
        
        //Tutor will make people fail by giving them bad information
        tutor("Tutor", "Everyone looks to you for advice before the test.",
                Team.dork, new Ability[] {Ability.falseInfo},
                new Immunity[]{Immunity.none}),
        
        //High Achiever isn't affected by popular kids
        highAchiever("High Achiever", "You're focused on your goals, and will not let the popular kids ruin it.",
                Team.dork, new Ability[] {Ability.none},
                new Immunity[]{Immunity.popular}),
        
        //Frantic won't let foul play happen, tattling on those who affect him
        frantic("Frantic", "You're paranoid someone else will ruin your grade.",
                Team.dork, new Ability[] {Ability.tattle},
                new Immunity[]{Immunity.popular, Immunity.cheater, Immunity.teacher}),
        
        //Class Clown has 3 votes since his words hold much weight
        classClown("Class Clown", "Everyone respects you and your silliness.",
                Team.dork, new Ability[]{Ability.tellJoke},
                new Immunity[] {Immunity.none}),
        
        //Newspaper Reporter will find out someone's role between tests
        newspaperReporter("Newspaper Reporter", "You stalk people under a pseudonym and find their secrets.",
            Team.dork, new Ability[] {Ability.report},
            new Immunity[] {Immunity.none}),
        
        //======================================================================
        //Team
        //  Popular Kids
        //======================================================================
        //Jock will beat up kids of the same gender for their answers.
        jock("Jock", "You need to keep your academic eligibility by \"asking\" for answers.",
                Team.popular, new Ability[]{Ability.beatUp},
                new Immunity[] {Immunity.popular}),
        
        //Queen Bee will scare people of class
        queenBee("Queen Bee", "You're like the most popular girl in school.",
                Team.popular, new Ability[]{Ability.scare},
                new Immunity[] {Immunity.cheater, Immunity.teacher, Immunity.popular}),
        
        //Flirt is a basically a jock, but copies the opposite gender
        flirt("Flirt", "You manipulate people into giving you their answers.",
                Team.popular, new Ability[] {Ability.charm},
                new Immunity[] {Immunity.popular}),
        
        //Chatty Cathy cancels most people's abilities.
        chattyCathy("Chatty Cathy", "You talk and talk and talk and ta...",
                Team.popular, new Ability[]{Ability.distract},
                new Immunity[] {Immunity.popular}),
        
        //======================================================================
        //Team
        //  Apathy
        //======================================================================
        
        //Cheater will switch tests with a person and give them a failing test
        cheater("Cheater", "You know how to swap names and that's it.",
                Team.apathy, new Ability[]{Ability.swap},
                new Immunity[] {Immunity.none}),
        
        //Loner wants to be ostracized to transfer
        loner("Loner", "None of your friends are in your class, and your parents don't want you to fail.",
                Team.apathy, new Ability[]{Ability.none},
                new Immunity[] {Immunity.none}),
        
        //Hater hates someone and wants them ostracize
        hater("Hater", "Ugh! You got stuck in class with the WORST person in the world.",
                Team.apathy, new Ability[]{Ability.none},
                new Immunity[] {Immunity.none}),
        
        //Teacher hates everyone and can fail someone -- before someone notices
        teacher("Teacher", "You're stuck with these rascals.",
                Team.apathy, new Ability[]{Ability.fail, Ability.chooseTutor},
                new Immunity[] {Immunity.all});
        
        
        
        private final String name, description;
        private final Team team;
        private final Ability[] ablts;
        private final Immunity[] immunities;
        Role(String a, String b, Team c, Ability[] d, Immunity[] e) {
            name = a;
            description = b;
            team = c;
            ablts = d;
            immunities = e;
        }
        static Role[] getTeamMembers(Team team) {
            LinkedList<Role> roles = new LinkedList<>();
            for (Role role : Role.values())
                if (role.team == team)
                    roles.add(role);
            return roles.toArray(new Role[roles.size()]);
        }
        static Ability[] getTeamAbilities(Team team) {
            LinkedList<Ability> abilities = new LinkedList<>();
            for (Role role : Role.values())
                if (role.team == team)
                    abilities.addAll(Arrays.asList(role.ablts));
            return abilities.toArray(new Ability[abilities.size()]);
        }
        Boolean immuneTo(Role role){
            for(Immunity immune: immunities)
                if (immune.immuneTo(role)) return true;
            return false;
        }
        Team getTeam(){return this.team;}
        Ability[] getAbilities() {return ablts;}
        public String toString(){return name;}
        public String getDescription(){return description;}
    }
    
    public static enum Ability {
        noFail("The teacher and tutor have no effect on you."),
        falseInfo("Make people fail between tests by giving them bad information."),
        popImmune("You aren't affected by popular kids."),
        fail("Fail people, but be carefull, parents or the frantic may notice."),
        tattle("Anyone trying to get you failing will get tattled on (except tutor)."),
        tellJoke("Class respect will earn you 3 votes when you start joking."),
        report("Stalk people to find out their secrets and publish it in the school paper."),
        beatUp("Beat up kids of the same gender to get their answers."),
        scare("Scare people out the class."),
        charm("You charm the opposite gender to give you their answers."),
        distract("Prevent a person from performing by talking to them during the test."),
        swap("Swap a person's test with your failing one."),
        chooseTutor("Choose a tutor before a test to help someone with the material."),
        none("None");
        private final String description;
        Ability(String a) {
            description = a;
        }
        public String toString(){return description;}
        
    }
    public static enum Immunity {
        all(Role.values()),
        teacher(new Role[] {Role.teacher}),
        tutor(new Role[]{Role.tutor}),
        popular(Role.getTeamMembers(Team.popular)),
        cheater(new Role[] {Role.cheater}),
        none(new Role[0]);
        
        private final Role[] roles;
        Immunity(Role[] a) {
            roles = a;
        }
        /**
         * 
         * @param role
         * @return true if this immunity includes the role.
         */
        public Boolean immuneTo(Role role) {
            if (role == Role.frantic) return false;
            for (Role immuneRole: roles)
                if (immuneRole == role)
                    return true;
            return false;
        }
    }
    public static enum Team {
        dork("Get rid of the popular kids."),
        popular("Get rid of the nonpopular kids."),
        apathy("Win the game for yourself.")
        ;
        private final String objective;
        Team(String a) {
            objective = a;
        }
    }
    
    //Item hiding
    public Role getRole() {return role;}
    public String getRoleDesc() {return role.getDescription();}
    public Team getTeam() {return role.getTeam();}
    public Ability[] getAbilities() {return role.getAbilities();}
    public String toString() {return name;}
    public Boolean isMale() {return isMale;}
    public void setRole(Role newRole) {role = newRole;}
    public Boolean targetedBy(Character attacker) {
        for (Role.Ability ablt:getAbilities())
            for (Role.Ability atkAblt: attacker.getAbilities())
                if (!ablt.targetedBy(atkAblt, attacker)) return false;
        failed = true;
        return true;
    }
    
    
}
