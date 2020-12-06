package vokabelkarten;

public class Meaning {

    String text;
    String ordering;

    public Meaning() {}

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getOrdering() {
        return ordering;
    }

    public void setOrdering(String ordering) {
        this.ordering = ordering;
    }

    public String toString()
    {
        return getOrdering() + getText();
    }
}
