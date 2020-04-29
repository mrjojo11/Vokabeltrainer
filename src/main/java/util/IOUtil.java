package util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class IOUtil {

    String filePath;
    static XWPFTable table;
    static ArrayList<Boolean> bolArray;
    static XWPFTableRow emptyRow;
    static int positionEndArray;
    static int positionFremd;
    static int positionDeut;

    public IOUtil() {}

    public XWPFDocument read() {
        try {
            JFileChooser window = new JFileChooser();
            int returnValue = window.showOpenDialog(null);

            if(returnValue == JFileChooser.APPROVE_OPTION)
            {
                XWPFDocument document = new XWPFDocument(new FileInputStream(window.getSelectedFile()));
                setFilePath(window.getSelectedFile().getAbsolutePath());
                return document;
            }
            return null;
        }
        catch (Exception e)
        {
            e.getStackTrace();
        }
        return null;
    }

    public void setFilePath(String filePathIn) {
        filePath = filePathIn;
    }
    public String getFilePath() {
        return filePath;
    }

    public static int getPositionEndArray() {
        return positionEndArray;
    }

    public static void incPositionEndArray() {
        positionEndArray = positionEndArray +1;
    }

    public static int getPositionFremd() {
        return positionFremd;
    }

    public static void setPositionFremd(int positionFremdIn) {
        positionFremd = positionFremdIn;
    }

    public static void incPositionFremd() {
        positionFremd = positionFremd +1;
    }

    public static int getPositionDeut() {
        return positionDeut;
    }

    public static void setPositionDeut(int positionDeutIn) {
        positionDeut = positionDeutIn;
    }

    public static void incPositionDeut() {
        positionDeut = positionDeut +1;
    }

    public static void setTable(XWPFTable tableIn) {
        table = tableIn;
    }
    public static XWPFTable getTable() {
        return table;
    }

    public static void setBolArray(ArrayList<Boolean> bolArrayIn) {
        bolArray = bolArrayIn;
    }
    public static ArrayList<Boolean> getBolArray() {
        return bolArray;
    }

    public static void setEmptyRow(XWPFTableRow emptyRowIn) {
        emptyRow = emptyRowIn;
    }
    public static XWPFTableRow getEmptyRow() {
        return emptyRow;
    }

}
