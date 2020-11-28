package deadwood.XML;

import deadwood.PlayableRoom;
import deadwood.Room;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BoardParser extends XMLParser {
    /**
     * parseBoardXml
     * <p>
     * Parses the board.xml file
     *
     * TODO: more refactoring and method extractions so this makes more sense
     *
     *
     * @param XMLFile the board.xml File object
     * @return an Arraylist of Rooms that were in the XML
     * @throws ParserConfigurationException if XML file was not in correct format
     */
    public ArrayList<Room> parseBoardXML(File XMLFile) throws ParserConfigurationException {
        Document doc = getDocFromFile(XMLFile);
        NodeList sets = doc.getDocumentElement().getElementsByTagName("set");
        ArrayList<Room> roomsOnBoard = new ArrayList<>(sets.getLength());
        for (int i = 0; i < sets.getLength(); i++) {
            Node set = sets.item(i);
            String setName = set.getAttributes().getNamedItem("name").getNodeValue();

            Room room = new PlayableRoom(setName);
            addNeighboringRooms(set, room);
            //add setAreaData
            //add take/Shotcounter data
            roomsOnBoard.add(room);
        }
        return roomsOnBoard;
    }

    /**
     * processRoom
     * <p>
     * processRoom is for processing
     * - Neighbors
     * - Area
     * - Takes/shot-counter data
     *
     * @param set  The set/room to extract the neighbors out of
     * @param room Room to add the neighboring rooms on to
     */
    private void addNeighboringRooms(Node set, Room room) {
        NodeList setChildren = set.getChildNodes();
        ArrayList<Room> neighboringRooms = extractNeighborsFromXML(setChildren);
        room.adjacentRooms.addAll(neighboringRooms);
    }

    /**
     * Extract neighbors from XML
     * <p>
     * Given a NodeList set of neighboring rooms, creates an ArrayList of type Room
     * with the neighboring rooms/sets of the give set.
     *
     * @param roomName a set/room that has neighbors from a NodeList (provided through XML)
     * @return the set/arraylist of rooms neighboring the given
     */
    private ArrayList<Room> extractNeighborsFromXML(NodeList roomName) {
        ArrayList<Room> neighboringRooms = new ArrayList<>();
        for (int i = 0; i < roomName.getLength(); i++) {
            String nodeName = roomName.item(i).getNodeName();
            if (nodeName.equals("neighbors")) {
                NodeList neighbors = ((Element) roomName.item(i)).getElementsByTagName("neighbor");
                for (int neighborIndex = 0; neighborIndex < neighbors.getLength(); neighborIndex++) {
                    String neighboringRoom = neighbors.item(neighborIndex).getAttributes().getNamedItem("name").getNodeValue();
                    Room newNeighboringRoom = new PlayableRoom(neighboringRoom);
                    neighboringRooms.add(newNeighboringRoom);
                }
            }
        }
        return neighboringRooms;
    }
}
