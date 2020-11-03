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

                /*
                current the rest of this only prints out each sets
                neighbors, can probably change to print out #ofTakes
                and 'parts' data
                */
                if(setChildren.item(j).getNodeType() == Node.ELEMENT_NODE){
                    Element el = (Element) setChildren.item(j);
                    NodeList neighbors = el.getElementsByTagName("neighbor");
                    NodeList takes = el.getElementsByTagName("takes");
                    NodeList parts = el.getElementsByTagName("part");

                    for(int x = 0; x < neighbors.getLength(); x++){
                        Node neighbor = neighbors.item(x);
                        String neighborName = neighbor.getAttributes().getNamedItem("name").getNodeValue();

                        System.out.println("    Neighbor: " + neighborName);
                    }

                    for(int x = 0; x < parts.getLength(); x++){
                        Node part = parts.item(x);
                        String partName = part.getAttributes().getNamedItem("name").getNodeValue();
                        String difficulty = part.getAttributes().getNamedItem("level").getNodeValue();
                        System.out.printf("        Part: %s, Difficulty: %s%n", partName, difficulty);
                        
                    }


                    /*
                    if(el.getNodeName().contains("neighbor")){
                    }
                    */
                }
            }
        }
    }
}
