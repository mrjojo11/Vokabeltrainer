package vokabelkarten;

import org.hibernate.annotations.OptimisticLockType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name="vokabelkasten")

public class Vokabelkarte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    int id;

    private static final long serialVersionUID = -1798070786993154676L;

    @Column(name = "language")
    public String language;

    @Column(name = "eigenWort")
    public ArrayList<Meaning> eigenWort;

    @Column(name = "fremdWort")
    public ArrayList<Meaning> fremdWort;

    @Column(name = "series")
    public String series;

    @Column(name = "type")
    public String type;

    @Column(name = "dateAdded")
    public Date dateAdded;

    @Column(name = "dateUsed")
    public Date dateUsed;

    @Column(name = "difficulty")
    public int difficulty;

    @Column(name = "numberCorrect")
    public int numberCorrect;

    @Column(name = "numberFalse")
    public int numberFalse;

    public ArrayList<Meaning> getEigenWort() {
        return eigenWort;
    }

    public void setEigenWort(ArrayList<Meaning> eigenWort) {
        this.eigenWort = eigenWort;
    }

    public ArrayList<Meaning> getFremdWort() {
        return fremdWort;
    }

    public void setFremdWort(ArrayList<Meaning> fremdWort) {
        this.fremdWort = fremdWort;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String set) {
        this.series = set;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getDateUsed() {
        return dateUsed;
    }

    public void setDateUsed(Date dateUsed) {
        this.dateUsed = dateUsed;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getNumberCorrect() {
        return numberCorrect;
    }

    public void setNumberCorrect(int numberCorrect) {
        this.numberCorrect = numberCorrect;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getNumberFalse() {
        return numberFalse;
    }

    public void setNumberFalse(int numberFalse) {
        this.numberFalse = numberFalse;
    }
}
