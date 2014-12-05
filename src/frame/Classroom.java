package frame;
import dysfunctionalclassroom.Test;
import java.util.Arrays;
import java.util.LinkedList;
public class Classroom {
    Character[] classmates;
    Character.Role[] possibleRoles;
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
        classmates = people;
        possibleRoles = b;
        testing = new Test(this);
    }
    public Character[] classmates() {return classmates;}
    public void test(int testNo) {
        System.out.println("Test Number: " + testNo);
        testing.runTest();
    }
}
