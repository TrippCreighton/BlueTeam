package Main;

import org.w3c.dom.*;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.*;
import java.io.File;

public class XMLReader {
    public void readXML(String filePath) {
        try {
            // Load the XML file
            File file = new File(filePath);

            // Create a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file and create a DOM Document object
            Document document = builder.parse(file);

            // Normalize the document
            document.getDocumentElement().normalize();

            // Access the root element
            Element root = document.getDocumentElement();

            // Access child elements
            NodeList nodeList = document.getElementsByTagName("momentum");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                }
            }
            
            NodeList nodeList2 = document.getElementsByTagName("score");
            for (int i = 0; i < nodeList2.getLength(); i++) {
                Node node = nodeList2.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String readMomentum(String filePath) {
        try {
            // Load the XML file
            File file = new File(filePath);

            // Create a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file and create a DOM Document object
            Document document = builder.parse(file);

            // Normalize the document
            document.getDocumentElement().normalize();

            // Access the root element
            Element root = document.getDocumentElement();

            // Access child elements
            NodeList nodeList = document.getElementsByTagName("momentum");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    return element.getAttribute("num");
                }
            }    
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
		return "0";
    }
    
    public static String readScore(String filePath) {
        try {
            // Load the XML file
            File file = new File(filePath);

            // Create a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file and create a DOM Document object
            Document document = builder.parse(file);

            // Normalize the document
            document.getDocumentElement().normalize();

            // Access the root element
            Element root = document.getDocumentElement();

            // Access child elements
            NodeList nodeList = document.getElementsByTagName("score");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    return element.getAttribute("score");
                }
            }    
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
		return "0";
    }

	public static String readSession(String filePath) {
		try {
            // Load the XML file
            File file = new File(filePath);

            // Create a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file and create a DOM Document object
            Document document = builder.parse(file);

            
            // Normalize the document
            	document.getDocumentElement().normalize();

            // Access the root element
            	Element root = document.getDocumentElement();
            	
             

            // Access child elements
            NodeList nodeList = document.getElementsByTagName("session");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    return element.getAttribute("session");
                }
            }    
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
		return "0";
	}
	public static String readCharacter(String filePath) {
		try {
            // Load the XML file
            File file = new File(filePath);

            // Create a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file and create a DOM Document object
            Document document = builder.parse(file);

            
            // Normalize the document
            	document.getDocumentElement().normalize();

            // Access the root element
            	Element root = document.getDocumentElement();
            	
             

            // Access child elements
            NodeList nodeList = document.getElementsByTagName("character");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    return element.getAttribute("character");
                }
            }    
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
		return "0";
	}
	
	public static String readDifficult(String filePath) {
		try {
            // Load the XML file
            File file = new File(filePath);

            // Create a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file and create a DOM Document object
            Document document = builder.parse(file);

            
            // Normalize the document
            	document.getDocumentElement().normalize();

            // Access the root element
            	Element root = document.getDocumentElement();
            	
             

            // Access child elements
            NodeList nodeList = document.getElementsByTagName("difficult");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    return element.getAttribute("difficult");
                }
            }    
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
		return "0";
	}
	
	public static String readAdapt(String filePath) {
		try {
            // Load the XML file
            File file = new File(filePath);

            // Create a DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file and create a DOM Document object
            Document document = builder.parse(file);

            
            // Normalize the document
            	document.getDocumentElement().normalize();

            // Access the root element
            	Element root = document.getDocumentElement();
            	
             

            // Access child elements
            NodeList nodeList = document.getElementsByTagName("adapt");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    return element.getAttribute("adapt");
                }
            }    
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
		return "0";
	}
}
