package com.tumashchick.pp.xml;

import com.tumashchick.pp.container.ObjContainer;

import java.io.File;
import java.util.List;

public interface ParserInt {

    List<ObjContainer> parse(File file) throws XMLException;

}
