package frame;

import java.util.ArrayList;

public class Lobby {
    static final int MIN_PLAYERS = 3;
    private final ArrayList<Player> lobbyMembers;
    public Lobby(Player host) {
        lobbyMembers = new ArrayList<>();
        lobbyMembers.add(host);
    }
    /**
     * Gives the members of the lobby
     * @return Lobby Members in an array format
     */
    public Player[] getMembers() {return lobbyMembers.toArray(new Player[lobbyMembers.size()]);}
    
    /**
     * Adds a member to the lobby.
     * @param member - Player wishing to enter lobby.
     */
    public void addMember(Player member){lobbyMembers.add(member);}
    
    /**
     * Removes a member from the lobby.
     * @param member - Player wishing to leave lobby.
     */
    public void removeMember(Player member){lobbyMembers.remove(member);}
    
    /**
     * Removes a member from the lobby.
     * @param i - Index of player wishing to leave.
     */
    public void removeMember(int i){lobbyMembers.remove(i);}
    
    
}
