package dysfunctionalclassroom;
import frame.Character;
import frame.Classroom;
import modes.Default;
public class DysfunctionalClassroom {
    public static void main(String[] args) {
        Character.Role[] game = Default.getRoles();
        String[] names = {"Jim", "James", "Jerome", "Jerry", "Jeremy", "Justin", "Jake", "Joaquin", "John", "Jared", "Josh", "Jimmy", "Jason", "Josiah", "RNGesus"};            
        Classroom cls = new Classroom(names, game);
        for(int i = 1; true; i++)
            cls.test(i);
            
    }
    
}
