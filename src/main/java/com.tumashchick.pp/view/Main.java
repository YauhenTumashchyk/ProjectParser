package com.tumashchick.pp.view;

import com.tumashchick.pp.logic.FileFinder;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        FileFinder fileFinder = new FileFinder();
        final String DIR_PATH = "D:/IHG/crm-dev-functional-tests/functional-tests/soapui/src/test/resources";

        List<File> resultList = fileFinder.findAll(DIR_PATH);



        System.out.println(resultList.size());

    }

}
