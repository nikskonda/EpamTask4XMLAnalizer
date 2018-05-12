package by.epam.java.training.entity;

import java.util.*;

public enum NodeType {

    TAG_WITHOUT_BODY("(^<.+(/>)$)|(^(<\\?).+(\\?>)$)"),
    CLOSE_TAG("^(</).+>$"),
    OPEN_TAG("^<.+>$"),
    BODY(".+"),
    INDEFINED_TAG(".+");

    private String parser;

    private static List<NodeType> typeList = Arrays.asList(NodeType.values());


    NodeType(String parser){
        this.parser = parser;
    }

    public String getParser(){
        return this.parser;
    }

    public static List<NodeType> getListNodeType(){
        return typeList;
    }
}
