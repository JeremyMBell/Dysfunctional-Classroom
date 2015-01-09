package dysfunctionalclassroom;
import frame.Player;
import frame.Lobby;
import io.Initializer;
public class DysfunctionalClassroom {
    public static void main(String[] args) {
        Player host = new Player("So Close to Host");
        Player plyr1 = new Player("Player 1");
        Player plyr2 = new Player("Player 2");
        Player plyr3 = new Player("Player 3");
        Lobby lob = new Lobby(host);
        lob.addMember(plyr1);
        lob.addMember(plyr2);
        lob.addMember(plyr3);
        while(true) {
            for (int i = 0; i < lob.getMembers().length; i++) {
                lob.getMembers()[i].toggleCardCzar();
            }
            
        }
            
    }
    
}
