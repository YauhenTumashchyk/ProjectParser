package com.tumashchick.pp.xml.impl;

import com.tumashchick.pp.container.ObjContainer;
import com.tumashchick.pp.xml.ParserInt;
import com.tumashchick.pp.xml.XMLException;
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
import java.util.List;

public class ParserDOM implements ParserInt {

    private DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

    public String checkHeader(File file) throws XMLException {
        Document doc= null;
        try {
            File fXmlFile = file;
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            throw new XMLException("ParserDOM error", e);
        }

        return doc.getDocumentElement().getNodeName();
    }

    @Override
    public List<ObjContainer> parse(File file) throws XMLException {
        String projectNameTag = "soapui-project";
        try {
            File fXmlFile = file;
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName(projectNameTag);

            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Project name : " + eElement.getAttribute("name"));
//                    System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            throw new XMLException("ParserDOM error", e);
        }
        return null;
    }

}
