package by.epam.java.training.servise.impl.builder;

import by.epam.java.training.entity.Node;
import by.epam.java.training.entity.NodeType;
import by.epam.java.training.servise.impl.builder.NodeBuilder;

public class NodeBuilderImpl implements NodeBuilder {

    public NodeBuilderImpl() {
    }

    private Node cheaker(String value, NodeType nodeType){
        if (value.matches(nodeType.getParser())) {
                return new Node(nodeType, value);
        }
        else {
            return null;
        }
    }

    @Override
    public Node build(String value){
        Node node = null;
        for (NodeType nodeType : NodeType.getListNodeType()){
            if ((node = cheaker(value, nodeType)) != null){
                return node;
            }
        }
        return node;
    }

}