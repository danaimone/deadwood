package deadwood.XML;

import deadwood.Card;
import deadwood.Role;
import deadwood.SceneCard;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.util.ArrayList;

public class SceneParser extends XMLParser {
    public ArrayList<SceneCard> parseCardXML(File cardData) throws ParserConfigurationException {
        Document doc = getDocFromFile(cardData);
        ArrayList<SceneCard> allCards = new ArrayList<SceneCard>(); //arraylist of cards to return;

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

                    tempRole.setRoleName(partName);
                    tempRole.setRoleDifficulty(Integer.parseInt(partLevel));

                    totalRoles++;

                    NodeList partData = sub.getChildNodes();

                    for (int x = 0; x < partData.getLength(); x++) {
                        Node partDataNode = partData.item(x);
                        if ("area".equals(partDataNode.getNodeName())) {
                            String pX = partDataNode.getAttributes().getNamedItem("x").getNodeValue();
                            String pY = partDataNode.getAttributes().getNamedItem("y").getNodeValue();
                            String pW = partDataNode.getAttributes().getNamedItem("w").getNodeValue();
                            String pH = partDataNode.getAttributes().getNamedItem("h").getNodeValue();

                            tempRole.setX(pX);
                            tempRole.setY(pY);
                            tempRole.setW(pW);
                            tempRole.setH(pH);

                        }
                        if ("line".equals(partDataNode.getNodeName())) {
                            String line = partDataNode.getTextContent();
                            tempRole.setRoleDescription(line);
                        }
                    }
                    roles.add(tempRole);
                }
            }
//            SceneCard newSceneCard = new SceneCard(cardName, cardImg, Integer.parseInt(cardBudget), sceneNumber, sceneDescription, totalRoles, roles);
            SceneCard newSceneCard = new SceneCard();

            allCards.add(newSceneCard);
        }
        return allCards;
    }
}
