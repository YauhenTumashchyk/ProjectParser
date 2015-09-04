package com.tumashchick.pp.xml.parsingOperations;

import com.tumashchick.pp.operator.FileFinder;
import com.tumashchick.pp.xml.impl.ParserDOM;

import java.io.File;
import java.util.ArrayList;

public class ParsingOperations {

    private FileFinder fileFinder = new FileFinder();
    private final String DIR_PATH = "D:/IHG/crm-dev-functional-tests/functional-tests/soapui/src/test/resources";
    private ArrayList<File> resultList = null;
    private String patternHeader = "con:soapui-project";

    public ArrayList<File> getProjectList(){
        String header;

        try {
            resultList = (ArrayList<File>) fileFinder.findAll(DIR_PATH);
//            System.out.println("1 = " + resultList.size());
            ParserDOM parserDOM = new ParserDOM();

            // get list of projects
            for (int i = 0; i < resultList.size(); i++) {
                header = parserDOM.checkHeader(resultList.get(i));

                if (header != patternHeader){
                    resultList.remove(i);
                    i--;
                }
            }
            resultList.trimToSize();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }














}
