package by.epam.java.training.controller;

import by.epam.java.training.entity.Node;
import by.epam.java.training.entity.NodeType;
import by.epam.java.training.printer.LogPrinter;
import by.epam.java.training.printer.NodePrinter;
import by.epam.java.training.servise.XMLAnalizer;
import by.epam.java.training.servise.impl.XMLAnalizerImpl;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class Controller {
    private static final Logger LOGGER = Logger.getLogger(Controller.class);

    public static void main(String[] args) {
        try (XMLAnalizer analizer = new XMLAnalizerImpl("resources/breakfastMenu.xml")) {
            Node node;
            while ((node = analizer.nextNode()) != null){
                NodePrinter.printlnNode(node);
            }
        } catch (Exception ex){

            LogPrinter.printLogError(ex.getMessage(), LOGGER);
        }

    }
}
