package by.epam.java.training.servise.impl;

import by.epam.java.training.entity.Node;
import by.epam.java.training.entity.TagSymbols;
import by.epam.java.training.servise.XMLAnalizer;
import by.epam.java.training.servise.impl.builder.BuilderFactory;
import by.epam.java.training.servise.impl.builder.NodeBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class XMLAnalizerImpl implements XMLAnalizer {

    private BufferedReader reader;
    private StringBuilder store;
    private NodeBuilder builder;
    private Node node;

    private String specialChars = "\n\t\r";

    public XMLAnalizerImpl(String fileName) throws IOException {
        reader = new BufferedReader(new FileReader(fileName));
        store = new StringBuilder();
        builder = BuilderFactory.getInstance().getNodeBuilder();
    }

    private void clearStore(){
        store.setLength(0);
    }

    private boolean isEmptyStore(){
        return store.length()==0 ? true : false;
    }

    private boolean isSpecialChar(char c){
        return specialChars.contains(c+"");
    }

    private boolean isSpacesStore(){
        return store.toString().matches("^+\\s");
    }

    private Node analizeGotSymbol(char symbol){
        if (isSpacesStore()){
            clearStore();
        }
        if (!isSpecialChar(symbol)) {
            return analizeTempState(symbol);
        }
        return null;
    }

    private Node analizeTempState(char symbol){
        Node node = null;
        if (TagSymbols.OPENNIG_TAG.getSymbol() == symbol && !isEmptyStore()){
            node = builder.build(store.toString());
            clearStore();
            store.append(symbol);
            return node;
        }
        if (TagSymbols.CLOSING_TAG.getSymbol() == symbol && !isEmptyStore()) {
            store.append(symbol);
            node = builder.build(store.toString());
            clearStore();
            return node;
        }
        store.append(symbol);
        return node;
    }

    @Override
    public Node nextNode() {
        Node node = null;
        try {
            int c = -1;
            while ((c = reader.read()) != -1) {
                if ((node=analizeGotSymbol((char)c)) != null){
                    return node;
                }
            }
        } catch (Exception ex){
            System.out.println(ex);
        }
        return node;
    }

    @Override
    public void close() throws Exception {
        reader.close();
    }
}
