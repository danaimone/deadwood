package deadwood;

import java.util.ArrayList;
import java.util.Collection;

public class Set {
    protected String setName;
    protected Collection<Set> adjacentSets = new ArrayList<>();
    protected int takes;

    public Set() {

    }

    protected class parts {
        protected String partName;
        protected int partLevel;
        protected String partLine;
    }

    public Set(String setName, int takes){
        this.setName = setName;
        this.takes = takes;
    }

    protected Collection<PlayerController> playersInRoom = new ArrayList<>();
    protected Scene currentScene; //what scene card does the room have?

    public Set(String name) {
        this.setName = name;
    }

    private Collection<PlayerController> getPlayersInRoom() {
        return playersInRoom;
    }

    private Collection<Set> getAdjacentRoom() {
        return adjacentSets;
    }

    private void addPlayer(PlayerController playerControllerToAdd) {
    }

    private void removePlayer(PlayerController playerControllerToAdd) {
    }

    private boolean checkInRoom(PlayerController playerController) {
        return false;
    }

    private void getScene(){
        //get data from the scene card in the room
    }
}
