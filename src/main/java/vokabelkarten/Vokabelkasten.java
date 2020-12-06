package vokabelkarten;

import java.util.ArrayList;

public class Vokabelkasten {
    public String language;
    public ArrayList<Vokabelkarte> vokabelkarten;

    public Vokabelkasten(String language, ArrayList<Vokabelkarte> vokabelkarten) {
        this.language = language;
        this.vokabelkarten = vokabelkarten;
    }
}
