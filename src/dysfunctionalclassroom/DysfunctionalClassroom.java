package dysfunctionalclassroom;
import frame.Character;
import frame.Classroom;
import modes.Default;
import modes.Mode;
public class DysfunctionalClassroom {
    public static void main(String[] args) {
        Character.Role[] game = Default.getRoles();
        String[] names = {"Jim", "James", "Jerome", "Jerry", "Jeremy", "Justin", "Jake"};            
        Classroom cls = new Classroom(names, game);
        for(int i = 1; true; i++)
            cls.test(i);
            
    }
    
}
