package com.tumashchick.pp.view;

import com.tumashchick.pp.xml.parsingOperations.ParsingOperations;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        ParsingOperations parsingOperations = new ParsingOperations();
        //get list of projects
        ArrayList<File> resultList = parsingOperations.getProjectList();

//        for (int i = 0; i < resultList.size(); i++) {
//            resultList.get(i);
//
//        }

        resultList.get(0);



    }


}
