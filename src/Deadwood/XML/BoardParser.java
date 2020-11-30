package Deadwood.XML;

import Deadwood.Area;
import Deadwood.Board.BoardController;
import Deadwood.Room.CastingOffice;
import Deadwood.Room.PlayableRoom;
import Deadwood.Room.Room;
import Deadwood.Room.Trailer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.util.ArrayList;

public class BoardParser extends XMLParser {
    /**
     * parseBoardXml
     * <p>
     * Parses the board.xml file
     *
     * @param XMLFile the board.xml File object
     * @return an Arraylist of Rooms that were in the XML
     * @throws ParserConfigurationException if XML file was not in correct format
     */
    public void parseBoardXML(File XMLFile) throws ParserConfigurationException {
        Document doc = getDocFromFile(XMLFile);
        setupPlayableRooms(doc);
        setupTrailerRoom(doc);
        setupCastingOffice(doc);
    }

    private void setupCastingOffice(Document doc) {
        Node castingOfficeItem = doc.getElementsByTagName("office").item(0);
        Room castingOffice = new CastingOffice();
        Area castingOfficeArea = getRoomArea(castingOfficeItem, castingOffice);
        addNeighboringRooms(castingOfficeItem, castingOffice);
        castingOffice.setArea(castingOfficeArea);
        BoardController.getInstance().getBoardData().getRoomsOnBoard().put("CastingOffice", castingOffice);
    }

    private void setupPlayableRooms(Document doc) {
        NodeList sets = doc.getElementsByTagName("set");
        for (int i = 0; i < sets.getLength(); i++) {
            Node set = sets.item(i);
            String setName = set.getAttributes().getNamedItem("name").getNodeValue();
            Room room = new PlayableRoom(setName);
            Area area = getRoomArea(set, room);
            room.setArea(area);
            addNeighboringRooms(set, room);
            //add take/Shotcounter data
            BoardController.getInstance().getBoardData().getRoomsOnBoard().put(setName, room);
        }
    }

    private void setupTrailerRoom(Document doc) {
        Node trailerItem = doc.getElementsByTagName("trailer").item(0);
        Room trailer = new Trailer();
        Area trailerArea = getRoomArea(trailerItem, trailer);
        addNeighboringRooms(trailerItem, trailer);
        trailer.setArea(trailerArea);
        BoardController.getInstance().getBoardData().getRoomsOnBoard().put("Trailer", trailer);
    }

    private Area getRoomArea(Node set, Room room) {
        NodeList setChildren = set.getChildNodes();
        for (int i = 0; i < setChildren.getLength(); i++) {
            String nodeName = setChildren.item(i).getNodeName();
            Node node = setChildren.item(i);
            if (nodeName.equals("area")) {
                int x = Integer.parseInt(node.getAttributes().getNamedItem("x").getNodeValue());
                int y = Integer.parseInt(node.getAttributes().getNamedItem("y").getNodeValue());
                int h = Integer.parseInt(node.getAttributes().getNamedItem("h").getNodeValue());
                int w = Integer.parseInt(node.getAttributes().getNamedItem("w").getNodeValue());
                return new Area(x, y, h, w);
            }
        }
        return null;
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
    private Room addNeighboringRooms(Node set, Room room) {
        NodeList setChildren = set.getChildNodes();
        ArrayList<String> neighboringRooms = extractNeighborsFromXML(setChildren);
        room.setAdjacentRooms(neighboringRooms);
        return room;
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
    private ArrayList<String> extractNeighborsFromXML(NodeList roomName) {
        ArrayList<String> neighboringRooms = new ArrayList<>();
        for (int i = 0; i < roomName.getLength(); i++) {
            String nodeName = roomName.item(i).getNodeName();
            if (nodeName.equals("neighbors")) {
                NodeList neighbors = ((Element) roomName.item(i)).getElementsByTagName("neighbor");
                for (int neighborIndex = 0; neighborIndex < neighbors.getLength(); neighborIndex++) {
                    String neighboringRoom = neighbors.item(neighborIndex).getAttributes().getNamedItem("name").getNodeValue();
                    neighboringRooms.add(neighboringRoom);
                }
            }
        }
        return neighboringRooms;
    }
}
