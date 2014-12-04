package frame;
import java.util.Arrays;
import java.util.LinkedList;
public class Classroom {
    Character[] classmates;
    Character.Role[] possibleRoles;
    public Classroom(Character[] a, Character.Role[] b) {
        /** public Classroom(Character[] a, Character.Role[] b)
         *  Parameters:
         *      Character[] a - people playing and their names.
         *      Character.Role[] b - the roles that characters can choose.
        */
        //Precondition:
        //There's not enough roles for everyone if the roles are limited, so
        //we throw an exception
        if (a.length < b.length)throw new IllegalArgumentException();
        
        //Random role assignment. Removes from the linked list each iteration
        LinkedList<Character.Role> roles = new LinkedList<>(Arrays.asList(b));
        for(int iChara = 0; roles.size() > 0; iChara++) {
            int iRole = (int) Math.floor(Math.random() * roles.size());
            a[iChara].setRole(roles.get(iRole));
            roles.remove(iRole);
        }
        classmates = a;
        possibleRoles = b;
    }
    
}
