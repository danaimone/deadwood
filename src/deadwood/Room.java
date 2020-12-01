package deadwood;

import deadwood.Area;
import deadwood.Role;
import deadwood.SceneCard;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Room is an abstract class that is implemented
 * by more specific Rooms, such as CastingOffice.
 * <p>
 * Name details the actual Room type, although this should be inferred by
 * each Room having a specific name.
 * <p>
 * Rooms has off-card roles
 * Each room holds a SceneCard, a SceneCard holds a card, and a SceneCard also knows the off-card roles
 */
public abstract class Room {
    public boolean isActive;
    public Collection<Role> roles = new ArrayList<>();
    private SceneCard sceneCardInPlay;
    private String name;
    private Area area;
    private ArrayList<String> adjacentRooms = new ArrayList<>();

    public Room() {

    }

    public boolean isActive() {
        return isActive;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public SceneCard getSceneCardInPlay() {
        return sceneCardInPlay;
    }

    public void setSceneCardInPlay(SceneCard sceneCardInPlay) {
        this.sceneCardInPlay = sceneCardInPlay;
    }

    public void addRoles(Collection<Role> rolesToAdd) {
        roles.addAll(rolesToAdd);
    }

    public ArrayList<String> getAdjacentRooms() {
        return this.adjacentRooms;
    }

    public void setAdjacentRooms(ArrayList<String> adjacentRoomsToAdd) {
        this.adjacentRooms = adjacentRoomsToAdd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
