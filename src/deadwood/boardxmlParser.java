package deadwood;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class boardxmlParser{
    public Document getDocFromFile(String filename)
    throws ParserConfigurationException{
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = null;

        try{
            doc = db.parse(filename);
        }
        catch(Exception ex){
            System.out.println("Board XML parse failure");
            ex.printStackTrace();
        }
        return doc;
    }

    //reads the board.xml file
    public void readBoardData(Document doc){
        Element root = doc.getDocumentElement();
        NodeList sets = root.getElementsByTagName("set");

        //for each 'set' on the board
        for (int i = 0; i < sets.getLength(); i++){
            Node set = sets.item(i);

            //get the sets name and print it
            //instead of printing, create Set object??
            String setName = set.getAttributes().getNamedItem("name").getNodeValue();
            System.out.println("Set: " + setName);

            //get the rest of the elements in the current set
            NodeList setChildren = set.getChildNodes();
            for(int j = 0; j < setChildren.getLength(); j++){
                Node sub = setChildren.item(j);

                //gets neighbor data
                if("neighbors".equals(sub.getNodeName())){
                    Element el = (Element) setChildren.item(j);
                    NodeList neighbors = el.getElementsByTagName("neighbor");
                    for(int x = 0; x < neighbors.getLength(); x++){
                        Node neighbor = neighbors.item(x);
                        String neighborName = neighbor.getAttributes().getNamedItem("name").getNodeValue();

                        System.out.println("    Neighbor: " + neighborName);
                    }
                }
                //gets set area data
                else if("area".equals(sub.getNodeName())){
                    String sX = sub.getAttributes().getNamedItem("x").getNodeValue();
                    String sY = sub.getAttributes().getNamedItem("y").getNodeValue();
                    String sH = sub.getAttributes().getNamedItem("w").getNodeValue();
                    String sW = sub.getAttributes().getNamedItem("h").getNodeValue();
                    System.out.printf("    Set area; x: %s, y: %s, h: %s, w: %s%n", sX, sY, sH, sW);
                }
                //gets takes/shotcounter data
                else if("takes".equals(sub.getNodeName())){
                    Element el = (Element) setChildren.item(j);
                    NodeList takes = el.getElementsByTagName("take");
                    int totalTakes = takes.getLength();
                    System.out.println("    Set Takes: "+ totalTakes);

                    //gets take data for later (gui stuff)
                    for(int x = 0; x < takes.getLength(); x++){
                        Node take = takes.item(x);
                        String takeNumber = take.getAttributes().getNamedItem("number").getNodeValue();

                        Element takeEl = (Element) takes.item(x);
                        NodeList takeData = takeEl.getElementsByTagName("area");
                        for(int y = 0; y < takeData.getLength(); y++){
                            Node takeArea = takeData.item(y);
                            String tX = takeArea.getAttributes().getNamedItem("x").getNodeValue();
                            String tY = takeArea.getAttributes().getNamedItem("y").getNodeValue();
                            String tH = takeArea.getAttributes().getNamedItem("h").getNodeValue();
                            String tW = takeArea.getAttributes().getNamedItem("w").getNodeValue();
                            System.out.printf("        Take area %s; x: %s, y: %s, h: %s, w: %s%n", takeNumber, tX, tY, tH, tW);
                        }
                    }
                }
                //gets set parts data
                else if("parts".equals(sub.getNodeName())){
                    Element el = (Element) setChildren.item(j);
                    NodeList parts = el.getElementsByTagName("part");

                    for(int y = 0; y < parts.getLength(); y++){
                        Node part = parts.item(y);
                        String partName = part.getAttributes().getNamedItem("name").getNodeValue();
                        String difficulty = part.getAttributes().getNamedItem("level").getNodeValue();
                        System.out.printf("    Part: %s, Difficulty: %s%n", partName, difficulty);

                        NodeList partData = part.getChildNodes();
                        for(int z = 0; z < partData.getLength(); z++){
                            Node partDataNode = partData.item(z);
                            if("area".equals(partDataNode.getNodeName())){
                                String pX = partDataNode.getAttributes().getNamedItem("x").getNodeValue();
                                String pY = partDataNode.getAttributes().getNamedItem("y").getNodeValue();
                                String pH = partDataNode.getAttributes().getNamedItem("w").getNodeValue();
                                String pW = partDataNode.getAttributes().getNamedItem("h").getNodeValue();
                                System.out.printf("        Part area; x: %s, y: %s, h: %s, w: %s%n", pX, pY, pH, pW);
                            }
                            if("line".equals(partDataNode.getNodeName())){
                                String line = partDataNode.getTextContent();
                                System.out.printf("        Line: %s%n", line);
                            }
                        }
                    }
                }
            }
        }
    }
}
