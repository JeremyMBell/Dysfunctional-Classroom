package dysfunctionalclassroom;
import frame.Classroom;
import frame.Character;
import java.util.LinkedList;
public class Test {
    Classroom classmates;
    LinkedList<Character> testAbltClassmates = new LinkedList<>();
    public Test(Classroom a) {
        classmates = a;
        Character[] people = a.classmates();
        int[] order = {6, 3, 4, 12, 10, 8, 2};
        for (int i = 0; i < order.length; i++)
            for (int i2 = 0; i2 < people.length; i++)
                for (Character.Role.Ability ablt: people[i2].getAbilities())
                    if (ablt.getID() == order[i])
                        testAbltClassmates.add(people[i2]);
        
    }
    public void runTest() {
        for (Character testPerson: testAbltClassmates)
            for (Character.Role.Ability ablt:testPerson.getAbilities())
                ablt.perform(testPerson, classmates.classmates()[0]);//They have to choose target...
    }
    
}
