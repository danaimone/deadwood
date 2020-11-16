package deadwood;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BoardXMLParser {

    public Document getDocFromFile(String filename)
            throws ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = null;

        try {
            doc = db.parse(filename);
        } catch (Exception ex) {
            System.out.println("BoardController XML parse failure");
            ex.printStackTrace();
        }
        return doc;
    }

    public ArrayList<Scene> readCardData(Document doc) {
        ArrayList<Scene> allCards = new ArrayList<Scene>(); //arraylist of cards to return;

        Element root = doc.getDocumentElement();
        NodeList cards = root.getElementsByTagName("card");

        //for each 'card'
        for (int i = 0; i < cards.getLength(); i++) {
            Node card = cards.item(i);
            String cardName;
            String cardImg;
            String cardBudget;
            String sceneNumber = "";
            String sceneDescription = "";
            int totalRoles = 0;
            ArrayList<Role> roles = new ArrayList<Role>();


            //get the name of the card, budget, and image
            //instead of printing create card object?
            cardName = card.getAttributes().getNamedItem("name").getNodeValue();
            cardImg = card.getAttributes().getNamedItem("img").getNodeValue();
            cardBudget = card.getAttributes().getNamedItem("budget").getNodeValue();

            NodeList cardChildren = card.getChildNodes();
            for (int j = 0; j < cardChildren.getLength(); j++) {
                Node sub = cardChildren.item(j);

                //get scene data
                if ("scene".equals(sub.getNodeName())) {
                    sceneNumber = sub.getAttributes().getNamedItem("number").getNodeValue();
                    sceneDescription = sub.getTextContent();
                } else if ("part".equals(sub.getNodeName())) {
                    Role tempRole = new Role();

                    String partName = sub.getAttributes().getNamedItem("name").getNodeValue();
                    String partLevel = sub.getAttributes().getNamedItem("level").getNodeValue();

                    tempRole.roleName = partName;
                    tempRole.roleDifficulty = Integer.parseInt(partLevel);

                    totalRoles++;

                    NodeList partData = sub.getChildNodes();

                    for (int x = 0; x < partData.getLength(); x++) {
                        Node partDataNode = partData.item(x);
                        if ("area".equals(partDataNode.getNodeName())) {
                            String pX = partDataNode.getAttributes().getNamedItem("x").getNodeValue();
                            String pY = partDataNode.getAttributes().getNamedItem("y").getNodeValue();
                            String pW = partDataNode.getAttributes().getNamedItem("w").getNodeValue();
                            String pH = partDataNode.getAttributes().getNamedItem("h").getNodeValue();

                            tempRole.x = pX;
                            tempRole.y = pY;
                            tempRole.w = pW;
                            tempRole.h = pH;

                        }
                        if ("line".equals(partDataNode.getNodeName())) {
                            String line = partDataNode.getTextContent();

                            tempRole.roleDescription = line;

                        }
                    }
                    roles.add(tempRole);
                }
            }
            Scene newScene = new Scene(cardName, cardImg, Integer.parseInt(cardBudget), sceneNumber, sceneDescription, totalRoles, roles);
            allCards.add(newScene);
        }
        return allCards;
    }

    /**
     * parseBoardXml
     *
     * Parses the board.xml file
     * @param XMLFile the board.xml File object
     * @return an Arraylist of Rooms that were in the XML
     * @throws ParserConfigurationException if XML file was not in correct format
     * @throws IOException if file could not be found
     * @throws SAXException general XML exception
     */
    public ArrayList<Room> parseBoardXML(File XMLFile) throws ParserConfigurationException, IOException, SAXException {
        Document doc = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(XMLFile);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        NodeList sets = doc.getDocumentElement().getElementsByTagName("set");
        ArrayList<Room> roomsOnBoard = new ArrayList<>(sets.getLength());
        for (int i = 0; i < sets.getLength(); i++) {
            Node set = sets.item(i);
            String setName = set.getAttributes().getNamedItem("name").getNodeValue();

            Room room = new PlayableRoom(setName);
            addNeighboringRooms(set, room);
            //add setAreaData
            //add take/Shotcounter data
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
