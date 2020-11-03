package deadwood;

import java.util.ArrayList;
import java.util.Collection;

public class Set {
    protected String setName;
    protected Collection<Set> adjacentSets = new ArrayList<Set>();
    protected int takes;

    protected class parts{
        protected String partName;
        protected int partLevel;
        protected String partLine;
    }

    public Set(String setName, int takes){
        this.setName = setName;
        this.takes = takes;
    }

    protected Collection<Player> playersInRoom = new ArrayList<Player>();
    protected Scene currentScene; //what scene card does the room have?

    public Set(String name) {
        this.setName = name;
    }

    private Collection<Player> getPlayersInRoom() {
        return playersInRoom;
    }

    private Collection<Set> getAdjacentRoom() {
        return adjacentSets;
    }

    private void addPlayer(Player playerToAdd) {
        return;
    }

    private void removePlayer(Player playerToAdd) {
        return;
    }

    private boolean checkInRoom(Player player) {
        return false;
    }

    private void getScene(){
        //get data from the scene card in the room
    }
}
