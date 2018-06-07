package by.epam.java.training.servise.impl;

import by.epam.java.training.entity.Node;
import by.epam.java.training.entity.TagSymbols;
import by.epam.java.training.builder.NodeBuilder;

public class SymbolAnalizer {

    private StringBuilder store;
    private NodeBuilder builder;

    private static final String SPECIAL_CHARACTER_STRING = "\n\t\r";
    private static final String STRING_OF_SPACES_PARSER = "^+\\s";

    public SymbolAnalizer(NodeBuilder nodeBuilder){
        store = new StringBuilder();
        builder = nodeBuilder;
    }

    private void clearStore(){
        store.setLength(0);
    }

    private boolean isEmptyStore(){
        return store.length()==0 ? true : false;
    }

    private boolean isSpecialChar(char c){
        return SPECIAL_CHARACTER_STRING.contains(c+"");
    }

    private boolean isSpacesStore(){
        return store.toString().matches(STRING_OF_SPACES_PARSER);
    }

    public Node analizeSymbol(char symbol){
        if (isSpacesStore()){
            clearStore();
        }
        if (!isSpecialChar(symbol)) {
            return analizeStore(symbol);
        }
        return null;
    }

    private Node analizeStore(char symbol){
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
}
