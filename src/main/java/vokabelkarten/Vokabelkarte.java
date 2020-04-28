package vokabelkarten;

import org.hibernate.annotations.OptimisticLockType;

import javax.persistence.*;
import java.io.Serializable;
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
    String language;

    @Column(name = "eigenWort")
    String eigenWort;

    @Column(name = "fremdWort")
    String fremdWort;

    @Column(name = "series")
    String series;

    @Column(name = "type")
    String type;

    @Column(name = "dateAdded")
    Date dateAdded;

    @Column(name = "dateUsed")
    Date dateUsed;

    @Column(name = "difficulty")
    int difficulty;

    @Column(name = "numberCorrect")
    int numberCorrect;

    @Column(name = "numberFalse")
    int numberFalse;

    public static void main(String[] args) {
        System.out.println("test");
    }

    public String getEigenWort() {
        return eigenWort;
    }

    public void setEigenWort(String eigenWort) {
        this.eigenWort = eigenWort;
    }

    public String getFremdWort() {
        return fremdWort;
    }

    public void setFremdWort(String fremdWort) {
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
