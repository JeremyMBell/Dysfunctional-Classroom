package dysfunctionalclassroom;
import frame.Lobby;
import frame.Player;
import io.Input;
import java.util.LinkedList;
public class Test {
    Lobby classmates;
    LinkedList<Player> testAbltClassmates = new LinkedList<>();
    public Test(Lobby a) {
        classmates = a;
        Player[] people = a.classmates();
        
        //Priority of people
        Player.Ability[] order = {Player.Ability.distract, Player.Ability.beatUp,
                       Player.Ability.charm, Player.Ability.report, 
                       Player.Ability.fail, Player.Ability.scare,
                       Player.Ability.swap, Player.Ability.tattle};
        for (Player.Ability curr:order)
            for (Player person: people)
                for (Player.Ability ablt: person.getAbilities())
                    if (ablt == curr)
                        testAbltClassmates.add(person);
        
    }
    public LinkedList<Player> runTest() {
        LinkedList<Player> failed = new LinkedList<>();
        for (Player testPerson: testAbltClassmates){
            System.out.println("\n" + testPerson + ":" + testPerson.getRole());
            Boolean targetSuccess = testPerson.target(classmates.classmates()[Input.receiveInput()]);
            if(testPerson.getRole().transferRole() && targetSuccess)
                failed.add(testPerson);
        }
        for (Player failedKid:failed)
            System.out.println(failedKid + " transferred since the last test.");
        return failed;
        
    }
    
}
