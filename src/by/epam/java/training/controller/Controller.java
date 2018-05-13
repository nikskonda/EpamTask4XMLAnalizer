package by.epam.java.training.controller;

import by.epam.java.training.entity.Node;
import by.epam.java.training.entity.NodeType;
import by.epam.java.training.printer.NodePrinter;
import by.epam.java.training.servise.XMLAnalizer;
import by.epam.java.training.servise.impl.XMLAnalizerImpl;

import java.io.IOException;
import java.util.List;

public class Controller {
    public static void main(String[] args) {
        try (XMLAnalizer analizer = new XMLAnalizerImpl("resources/breakfastMenu.xml")) {
            Node node;
            while ((node = analizer.nextNode()) != null){
                NodePrinter.printlnNode(node);
            }
        } catch (Exception ex){
            System.out.println(ex);
        }

    }
}
