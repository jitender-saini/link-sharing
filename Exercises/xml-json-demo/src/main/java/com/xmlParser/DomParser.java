package com.xmlParser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DomParser {
    public static void main(String[] args) throws Exception {
        File xmlFile = new File("src/Employee.xml");
        xmlDomParser(xmlFile);

    }

    public static void xmlDomParser(File file) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();
        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getElementsByTagName("Employee");
        System.out.println("-----------------------");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("com.xmlParser.Employee id : " + eElement.getAttribute("id"));
                System.out.println("Department : " + eElement.getElementsByTagName("Department").item(0).getTextContent());
                System.out.println("Name : " + eElement.getElementsByTagName("Name").item(0).getTextContent());
                System.out.println("Age : " + eElement.getElementsByTagName("Age").item(0).getTextContent());
                System.out.println("Contact Number : " + eElement.getElementsByTagName("ContactNumber").item(0).getTextContent());
                System.out.println("Address");
                System.out.println("City  : " + eElement.getElementsByTagName("City").item(0).getTextContent());
                System.out.println("State : " + eElement.getElementsByTagName("State").item(0).getTextContent());
                System.out.println("Zip : " + eElement.getElementsByTagName("Zip").item(0).getTextContent());
            }
        }

    }
}
