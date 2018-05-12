package by.epam.java.training.entity;

public class Node {

    private static final long serialVersionUID = 1L;

    private NodeType nodeType;
    private String value;

    public Node() {
    }

    public Node(NodeType nodeType, String value) {
        this.nodeType = nodeType;
        this.value = value;
    }

    public NodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(NodeType nodeType) {
        this.nodeType = nodeType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Node node = (Node) obj;

        if (!this.nodeType.equals(node.nodeType)){
            return false;
        }
        if (!this.value.equals(node.value)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode += this.nodeType.hashCode();
        hashCode += this.value.hashCode();
        return hashCode;
    }

    public String toConsole() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.nodeType.toString()).append(": ").append(this.value);
        return sb.toString();
    }
}
