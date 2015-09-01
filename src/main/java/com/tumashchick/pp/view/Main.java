package com.tumashchick.pp.view;

import com.tumashchick.pp.operator.FileFinder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        FileFinder fileFinder = new FileFinder();
        final String DIR_PATH = "D:/IHG/crm-dev-functional-tests/functional-tests/soapui/src/test/resources";

        ArrayList<File> resultList = (ArrayList<File>) fileFinder.findAll(DIR_PATH);



        System.out.println(resultList.size());

    }

}
