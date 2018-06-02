package by.epam.java.training.servise.impl;

import by.epam.java.training.entity.Node;
import by.epam.java.training.entity.TagSymbols;
import by.epam.java.training.printer.LogPrinter;
import by.epam.java.training.servise.XMLAnalizer;
import by.epam.java.training.servise.impl.builder.BuilderFactory;
import by.epam.java.training.servise.impl.builder.NodeBuilder;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class XMLAnalizerImpl implements XMLAnalizer {

    private static final Logger LOGGER = Logger.getLogger(XMLAnalizerImpl.class);

    private Node node;

    private SymbolAnalizer symbolAnalizer;
    private BufferedReader reader;
    private final int EOF = -1;

    public XMLAnalizerImpl(String fileName) throws IOException {
        reader = new BufferedReader(new FileReader(fileName));
        symbolAnalizer = new SymbolAnalizer(BuilderFactory.getInstance().getNodeBuilder());
    }

    @Override
    public Node nextNode() {
        Node node = null;
        try {
            int c;
            while ((c = reader.read()) != EOF) {
                if ((node= symbolAnalizer.analizeSymbol((char)c)) != null){
                    return node;
                }
            }
        } catch (IOException ex){
            LogPrinter.printLogError(ex.getMessage(), LOGGER);
        }
        return node;
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
}
