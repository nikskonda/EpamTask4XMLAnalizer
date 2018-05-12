package by.epam.java.training.printer;

import by.epam.java.training.entity.Node;

public class NodePrinter {

    private NodePrinter(){

    }

    public static void printlnNode(Node node){
        System.out.println(node.toConsole());
    }
}
