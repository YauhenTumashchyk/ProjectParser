package com.tumashchick.pp.xml;

public class XMLException extends Exception {


    public XMLException(String message, Exception e) {
        super(message, e);
    }

    public XMLException(Exception e) {
        super(e);
    }


}
