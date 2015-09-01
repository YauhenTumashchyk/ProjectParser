package com.tumashchick.pp.xml.impl;

import com.tumashchick.pp.container.ObjContainer;
import com.tumashchick.pp.container.ProjectObj;
import com.tumashchick.pp.xml.ParserInt;
import com.tumashchick.pp.xml.XMLException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOMParser implements ParserInt {

    @Override
    public List<ObjContainer> parse(File fileToParse) throws XMLException {

        ProjectObj projectObj = new ProjectObj();
        List<ProjectObj> project;
        String projectNameTag = "soapui-project"
        String Title = "Title";
        String Author = "Author";
        String CreateDate = "CreateDate";
        String NoteValue = "NoteValue";


        DOMParser parser = new DOMParser();
        try {
            parser.parse(pathToFile);
            Document document = parser.getDocument();
            Element root = document.getDocumentElement();
            noteList = new ArrayList<Note>();

            NodeList noteNodes = root.getElementsByTagName("Note");
            Note note = null;

            for (int i = 0; i < noteNodes.getLength(); i++) {
                note = new Note();
                Element noteElement = (Element) noteNodes.item(i);

                note.setTitle(getSingleChild(noteElement,Title).getTextContent().trim());
                note.setAuthor(getSingleChild(noteElement,Author).getTextContent().trim());
                note.setCreateDate(getSingleChild(noteElement,CreateDate).getTextContent().trim());
                note.setNoteValue(getSingleChild(noteElement,NoteValue).getTextContent().trim());
                noteList.add(note);
            }

        } catch (SAXException | IOException e) {
            throw new XMLException("DOMParser error", e);
        }

        return noteList;
    }

    private Element getSingleChild(Element element, String childName){

        NodeList nList = element.getElementsByTagName(childName);
        Element child = (Element) nList.item(0);
        return child;
    }



}
