package Deadwood.XML;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;

public abstract class XMLParser {
    /**
     * Given an opened file, return the corresponding Document
     *
     * @param filename XML document to open
     * @return the XML file as a Document
     * @throws ParserConfigurationException
     */
    public Document getDocFromFile(File filename)
            throws ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = null;

        try {
            doc = db.parse(filename);
        } catch (Exception ex) {
            System.out.println("XMLParser Failure");
            ex.printStackTrace();
        }
        return doc;
    }

}
