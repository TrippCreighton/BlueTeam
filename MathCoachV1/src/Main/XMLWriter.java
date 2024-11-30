package Main;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLWriter {

    // Method to create and write XML file
    public static void writeXML(String filePath) {
        try {
            // Create a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Create a new DOM Document
            Document document = builder.newDocument();

            // Create root element
            Element root = document.createElement("UserData");
            document.appendChild(root);

            Element momentum = document.createElement("momentum");
            momentum.setAttribute("num", "0");
            root.appendChild(momentum);

            Element score = document.createElement("score");
            score.setAttribute("score", "0");
            root.appendChild(score);
            
            Element session = document.createElement("session");
            session.setAttribute("session", "1");
            root.appendChild(session);
            
            Element character = document.createElement("character");
            character.setAttribute("character", "1");
            root.appendChild(character);
            
            Element difficult = document.createElement("difficult");
            difficult.setAttribute("difficult", "3");
            root.appendChild(difficult);
            
            Element adapt = document.createElement("adapt");
            adapt.setAttribute("adapt", "0");
            root.appendChild(adapt);

            // Write content to XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void updateMomentumXML(String filePath, int momentumValue) {
        try {
            // Load the existing XML file
            File file = new File(filePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            
            // Normalize the document (optional but recommended)
            document.getDocumentElement().normalize();

            // Find the "momentum" and "score" elements and update their values
            NodeList momentumList = document.getElementsByTagName("momentum");
            if (momentumList.getLength() > 0) {
                Element momentum = (Element) momentumList.item(0);
                momentum.setAttribute("num", String.valueOf(momentumValue));
            }
         // Write the updated content back to the XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);

        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void updateScoreXML(String filePath, int scoreValue) {
        try {
            // Load the existing XML file
            File file = new File(filePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            
            // Normalize the document (optional but recommended)
            document.getDocumentElement().normalize();

            // Find the "momentum" and "score" elements and update their values
            NodeList momentumList = document.getElementsByTagName("score");
            if (momentumList.getLength() > 0) {
                Element score = (Element) momentumList.item(0);
                score.setAttribute("score", String.valueOf(scoreValue));
            }
         // Write the updated content back to the XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);

        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void updateSessionXML(String filePath, int sessionValue) {
        try {
            // Load the existing XML file
            File file = new File(filePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            document.getDocumentElement().normalize();

            NodeList momentumList = document.getElementsByTagName("session");
            if (momentumList.getLength() > 0) {
                Element session = (Element) momentumList.item(0);
                session.setAttribute("session", String.valueOf(sessionValue));
            }
         // Write the updated content back to the XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void updateCharacterXML(String filePath, int characterValue) {
        try {
            // Load the existing XML file
            File file = new File(filePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            document.getDocumentElement().normalize();

            NodeList momentumList = document.getElementsByTagName("character");
            if (momentumList.getLength() > 0) {
                Element character = (Element) momentumList.item(0);
                character.setAttribute("character", String.valueOf(characterValue));
            }
         // Write the updated content back to the XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void updateDifficultXML(String filePath, int difficultValue) {
        try {
            // Load the existing XML file
            File file = new File(filePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            document.getDocumentElement().normalize();

            NodeList momentumList = document.getElementsByTagName("difficult");
            if (momentumList.getLength() > 0) {
                Element difficult = (Element) momentumList.item(0);
                difficult.setAttribute("difficult", String.valueOf(difficultValue));
            }
         // Write the updated content back to the XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void updateAdaptXML(String filePath, int adaptValue) {
        try {
            // Load the existing XML file
            File file = new File(filePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            document.getDocumentElement().normalize();

            NodeList momentumList = document.getElementsByTagName("adapt");
            if (momentumList.getLength() > 0) {
                Element adapt = (Element) momentumList.item(0);
                adapt.setAttribute("adapt", String.valueOf(adaptValue));
            }
         // Write the updated content back to the XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
