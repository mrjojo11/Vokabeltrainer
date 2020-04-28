package vokabelkarten;

import org.hibernate.annotations.OptimisticLockType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@org.hibernate.annotations.Entity(optimisticLock = OptimisticLockType.ALL)
@Table(name="vokabelkarten", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID") })

public class Vokabelkarte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    int id;


    String language;
    String eigenWort;
    String fremdWort;
    String set;
    String type;
    Date dateAdded;

    Date dateUsed;
    int difficulty;
    int numberCorrect;
    int numberFalse;


//    public Vokabelkarte(int id, String language, String eigenWort, String fremdWort, String set, String type, Date dateAdded) {
//        this.id = id;
//        this.language = language;
//        this.eigenWort = eigenWort;
//        this.fremdWort = fremdWort;
//        this.set = set;
//        this.type = type;
//        this.dateAdded = dateAdded;
//
//        this.dateUsed = dateAdded;
//        this.difficulty = 0;
//        this.numberCorrect = 0;
//        this.numberFalse = 0;
//    }

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

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
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

    public int getNumberFalse() {
        return numberFalse;
    }

    public void setNumberFalse(int numberFalse) {
        this.numberFalse = numberFalse;
    }
}
