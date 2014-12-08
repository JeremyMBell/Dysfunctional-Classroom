package dysfunctionalclassroom;
import frame.Classroom;
import frame.Character;
import io.Input;
import java.util.LinkedList;
public class Test {
    Classroom classmates;
    LinkedList<Character> testAbltClassmates = new LinkedList<>();
    public Test(Classroom a) {
        classmates = a;
        Character[] people = a.classmates();
        Character.Ability[] order = {Character.Ability.distract, Character.Ability.beatUp,
                       Character.Ability.charm, Character.Ability.report, 
                       Character.Ability.fail, Character.Ability.scare,
                       Character.Ability.tattle};
        for (Character.Ability curr:order)
            for (Character person: people)
                for (Character.Ability ablt: person.getAbilities())
                    if (ablt == curr)
                        testAbltClassmates.add(person);
        
    }
    public void runTest() {
        LinkedList<Character> failed = new LinkedList<>();
        for (Character testPerson: testAbltClassmates){
            System.out.println("\n" + testPerson + ":" + testPerson.getRole());
            Boolean targetSuccess = testPerson.target(classmates.classmates()[Input.receiveInput()]);
            if(testPerson.getRole().transferRole() && targetSuccess)
                failed.add(testPerson);
        }
        for (Character failedKid:failed)
            System.out.println(failedKid + " transferred since the last test.");
        
    }
    
}
