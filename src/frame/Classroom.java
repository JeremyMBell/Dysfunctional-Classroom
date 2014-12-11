package frame;
import dysfunctionalclassroom.Test;
import java.util.Arrays;
import java.util.LinkedList;
import io.Output;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;
public class Classroom {
    LinkedList<Character> classmates;
    Character.Role[] possibleRoles;
    LinkedList<Character> transferred = new LinkedList<>();
    Output gui;
    AppGameContainer window;
    Test testing;
    public Classroom(String[] names, Character.Role[] b) {
        /** public Classroom(Character[] a, Character.Role[] b)
         *  Parameters:
         *      Character[] a - people playing and their names.
         *      Character.Role[] b - the roles that characters can choose.
        */
        //Precondition:
        //There's not enough roles for everyone if the roles are limited, so
        //we throw an exception
        if (names.length > b.length)throw new IllegalArgumentException();
        Character[] people = new Character[names.length];
        
        //Random role assignment. Removes from the linked list each iteration
        LinkedList<Character.Role> roles = new LinkedList<>(Arrays.asList(b));
        for(int i = 0; roles.size() > 0 && i < people.length; i++) {
            int iRole = (int) Math.floor(Math.random() * roles.size());
            people[i] = new Character(roles.get(iRole), names[i]);
            roles.remove(iRole);
        }
        classmates = new LinkedList<>(Arrays.asList(people));
        possibleRoles = b;
        testing = new Test(this);
        try {
                gui = new Output("Dysfunctional Classroom");
                window = new AppGameContainer(gui);
                window.setDisplayMode(900, 600, false);
                window.start();
        }
        catch (SlickException ex) {
                Logger.getLogger(Output.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Character[] classmates() {return classmates.toArray(new Character[classmates.size()]);}
    /**
     * 
     * @param students - students to be transferred out of class
     *          Removes the students who transferred out of class and add them
     *          to the list of transfers.
     */
    public void addTransfers(LinkedList<Character> students) {
        transferred.addAll(students);
        classmates.removeAll(students);
    }
    public void test(int testNo) {
        System.out.println("Test Number: " + testNo);
        addTransfers(testing.runTest());
        System.out.println("In Class:" + classmates.toString());
        System.out.println("Transferred:" + transferred.toString());
    }
}
