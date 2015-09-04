package com.tumashchick.pp.xml.impl;

import com.tumashchick.pp.container.ObjContainer;
import com.tumashchick.pp.container.ProjectObj;
import com.tumashchick.pp.container.TestSuiteObj;
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
import java.util.ArrayList;
import java.util.List;

public class ParserDOM implements ParserInt {

    private DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

    //get document headers
    public String checkHeader(File fXmlFile) throws XMLException {
        Document doc;

        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            throw new XMLException("ParserDOM error", e);
        }
        return doc.getDocumentElement().getNodeName();
    }

    public ObjContainer getSelectedTagObjects (String parentTag, String childTag, ObjContainer parentObj, ObjContainer childObj, Document doc) {
        Node selectedTag;
        NodeList selectedTagList;
        Element eElement;

        doc.getDocumentElement().normalize();

        //get object tag list                       project
        selectedTagList = doc.getElementsByTagName(parentTag);

        List<ObjContainer> parentObjList = parentObj.getRezultList();

        for (int temp = 0; temp < selectedTagList.getLength(); temp++) {

            List<ObjContainer>childObjList = childObj.getRezultList();

            selectedTag = selectedTagList.item(temp);

                //get object attribute "name"
                if (selectedTag.getNodeType() == Node.ELEMENT_NODE) {

                    eElement = (Element) selectedTagList.item(temp);
                    parentObj.setName(eElement.getAttribute("name"));

                }

            parentObj.setRezultList(parentObjList);
        }


        return objTags;
    }



    @Override
    public List<ObjContainer> parse(File file) throws XMLException {
        File fXmlFile = file;
        String projectTag = ":con:soapui-project";
        String testSuiteTag = ":testSuite";
        String testCaseTag = ":testCase";
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            //Create Project object and prepare
            ProjectObj projectObj = new ProjectObj();
            TestSuiteObj testSuiteObj = new TestSuiteObj();

            //in progress
            projectObj = (ProjectObj) getSelectedTagObjects(projectTag, testSuiteTag, projectObj, testSuiteObj, doc);

            //add project to list
            progectList.add(projectObj);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            throw new XMLException("ParserDOM error", e);
        }
        return progectList;
    }


    //    private Element getSingleChild(Element element, String childName){
//
//        NodeList nList = element.getElementsByTagName(childName);
//        Element child = (Element) nList.item(0);
//        return child;
//    }

}
