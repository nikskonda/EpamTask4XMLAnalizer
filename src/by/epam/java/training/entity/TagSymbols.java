package by.epam.java.training.entity;

public enum TagSymbols {

    OPENNIG_TAG('<'),
    CLOSING_TAG('>');

    private char symbol;

    TagSymbols(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
