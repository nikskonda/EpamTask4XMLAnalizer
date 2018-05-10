package by.epam.java.training.servise.impl;

import by.epam.java.training.entity.TagUnit;
import by.epam.java.training.entity.XMLDocument;
import by.epam.java.training.servise.XMLAnalizer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class XMLAnalizerImpl implements XMLAnalizer {


    @Override
    public XMLDocument analyzeXML(String fileName) {
        XMLDocument document = new XMLDocument(fileName);
        readAndParseDocument(document);
        return document;
    }


    private void readAndParseDocument(XMLDocument xmlDocument){
        try (BufferedReader reader = new BufferedReader(new FileReader(xmlDocument.getDocName()))){
            String line;
            while ((line = reader.readLine()) != null) {
                xmlDocument.addTagUnitList(parseTagUnits(line));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private List<TagUnit> parseTagUnits(String line){
        List<TagUnit> tagUnitList = new ArrayList<>();

        return tagUnitList;
    }

}
