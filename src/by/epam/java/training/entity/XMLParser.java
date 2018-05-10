package by.epam.java.training.entity;

import java.util.HashMap;
import java.util.Map;

public class XMLParser {

    private static final long serialVersionUID = 1L;

    private String openTagParse = "";
    private String closeTagParse = "";
    private String bodyTagParse = "";
    private String withoutBodyTagParse = "";

    private Map<TagType, String> XMLparsers = new HashMap<>();

    public XMLParser(){
        this.XMLparsers.put(TagType.BODY_TAG, this.bodyTagParse);
        this.XMLparsers.put(TagType.OPEN_TAG, this.openTagParse);
        this.XMLparsers.put(TagType.CLOSE_TAG, this.closeTagParse);
        this.XMLparsers.put(TagType.TAG_WITHOUT_BODY, this.withoutBodyTagParse);
    }

    public Map<TagType, String> getXMLparsers(){
        return this.XMLparsers;
    }

}
