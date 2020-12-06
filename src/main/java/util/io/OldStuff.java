
package util.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;


import javax.swing.JFileChooser;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import vokabelkarten.Meaning;
import vokabelkarten.Vokabelkarte;
import vokabelkarten.Vokabelkasten;

public class OldStuff {

    String filePath;
    static XWPFTable table;
    static ArrayList<Boolean> bolArray;
    static ArrayList<String> content_of_file_array;
    static XWPFTableRow emptyRow;
    static int positionEndArray;
    static int positionFremd;
    static int positionDeut;

    public OldStuff() {

        filePath = null;
        table = null;
        bolArray = null;
        content_of_file_array = null;
        emptyRow = null;
        positionEndArray = 0;
        positionFremd = 0;
        positionDeut = 0;
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


    public File temp_pop_up() {
        JFileChooser file_selection_pop_up = new JFileChooser();
        int returnValue = file_selection_pop_up.showOpenDialog(null);

        if(returnValue == JFileChooser.APPROVE_OPTION) {
            return file_selection_pop_up.getSelectedFile();
        }
        return null;
    }

    public void read(File file) {
        try {
                XWPFDocument document = new XWPFDocument(new FileInputStream(file));
                setFilePath(file.getAbsolutePath());
                setTable(document.getTableArray(0));
            }
        catch (Exception e)
        {
            e.getStackTrace();
        }
    }

    public Vokabelkasten create_vokabelkasten_from_file(String language) {

        ArrayList<ArrayList<Vokabelkarte> > vokabelkarten_array_list = new ArrayList<ArrayList<Vokabelkarte>>();
        ArrayList<Vokabelkarte> one_page_vokabelkarten = new ArrayList<Vokabelkarte>();

        for(int cell = 0; cell < (table.getNumberOfRows()*3); cell++) {
            
            Integer cell_in_row = cell % 3;
            Integer fremd_or_deut = cell % 48;

            int row = (int) (Math.floor(cell/3));
            List<XWPFParagraph> paragraphs = table.getRow(row).getCell(cell_in_row).getParagraphs();
            ArrayList<Meaning> meaning_list = new ArrayList<Meaning>();
            Integer current_ordering = 1;

            for(XWPFParagraph paragraph : paragraphs)
            {
                String new_text = paragraph.getText();
                if(new_text.length() != 0) {
                    Meaning new_meaning = new Meaning();
                    new_meaning.setText(new_text);

                    String new_ordering = paragraph.getNumFmt();
                    if (new_ordering == "decimal") {
                        new_meaning.setOrdering(current_ordering.toString() + ". ");
                        current_ordering++;
                    } else {
                        new_meaning.setOrdering("");
                    }
                    meaning_list.add(new_meaning);
                }
            }

//            table.getRow(row).getHeight();
//            table.getRow(row).getCell(cell_in_row).getWidth();

            if(fremd_or_deut == 0)
            {
                one_page_vokabelkarten = new ArrayList<Vokabelkarte>();
            }

            if(meaning_list.size() > 0)
            {
                if(fremd_or_deut < 24)
                {
                    Vokabelkarte vokabelkarte = new Vokabelkarte();
                    vokabelkarte.setFremdWort(meaning_list);
                    vokabelkarte.setLanguage(language);

                    one_page_vokabelkarten.add(vokabelkarte);
                }
                if(fremd_or_deut >= 24)
                {
                    Integer position = fremd_or_deut % 3;

                    if(position == 0)
                    {
                        Vokabelkarte vokabelkarte = one_page_vokabelkarten.get(fremd_or_deut - 22);
                        vokabelkarte.setEigenWort(meaning_list);
                        one_page_vokabelkarten.set(fremd_or_deut - 22, vokabelkarte);
                    }
                    if(position == 1)
                    {
                        Vokabelkarte vokabelkarte = one_page_vokabelkarten.get(fremd_or_deut - 24);
                        vokabelkarte.setEigenWort(meaning_list);
                        one_page_vokabelkarten.set(fremd_or_deut - 24, vokabelkarte);
                    }
                    if(position == 2)
                    {
                        Vokabelkarte vokabelkarte = one_page_vokabelkarten.get(fremd_or_deut - 26);
                        vokabelkarte.setEigenWort(meaning_list);
                        one_page_vokabelkarten.set(fremd_or_deut - 26, vokabelkarte);
                    }
                }
            }
            if(fremd_or_deut == 47)
            {
                vokabelkarten_array_list.add(one_page_vokabelkarten);
            }
        }

        ArrayList<Vokabelkarte> result_vokabeln  = new ArrayList<Vokabelkarte>();

        for(ArrayList<Vokabelkarte> one_page : vokabelkarten_array_list)
        {
            for(Vokabelkarte vokabelkarte : one_page)
            {
                result_vokabeln.add(vokabelkarte);
            }
        }

        Vokabelkasten vokabelkasten = new Vokabelkasten(language, result_vokabeln);

        return vokabelkasten;
    }

    public void write(XWPFDocument document) {
        try {
            FileOutputStream output = new FileOutputStream(getFilePath());
            document.write(output);
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Boolean> analyse(XWPFTable table) {

        ArrayList<Boolean> bolArray = new ArrayList<Boolean>();

        for(int r = 0; r < (table.getNumberOfRows()); r++) {
            for (int c = 0; c < 3; c++) {
                XWPFTableRow tableRowOne = table.getRow(r);

                if(tableRowOne.getCell(c).getText().length() == 0)
                {
                    bolArray.add(getPositionEndArray(), false);
                    incPositionEndArray();
                } else {
                    bolArray.add(getPositionEndArray(), true);
                    incPositionEndArray();
                }
            }
        }
        //Pad the array if we have less than 4 pages
        if (bolArray.size() < 96)
        {
            int temp = bolArray.size() % 96;


            for (int r = (temp / 3); r < (96/3); r++)
            {
                int row = (int) ((Math.floor(getPositionEndArray() / 3)) - 1);
                XWPFTableRow tableRowOne = getTable().getRow(row);
                setEmptyRow(tableRowOne);
                getTable().addRow(tableRowOne);
            }

            for (int r = temp; r < 96; r++)
            {
                bolArray.add(false);
                incPositionEndArray();
            }
        }
        else
        {
            int row = (int) ((Math.floor(getPositionEndArray() / 3)) - 1);
            XWPFTableRow tableRowOne = getTable().getRow(row);
            setEmptyRow(tableRowOne);
        }

        //Find the position of the last fremd wort in the array
        for(int r = 0; r < bolArray.size(); r++)
        {
            if (bolArray.get(r) == false)
            {
                setPositionFremd(r+1);
                break;
            }
        }
        //Find the position of the last deutschwort
        int temp = getPositionFremd();

        if (temp % 3 == 0)
        {
            setPositionDeut(temp + 22);
        } else if (temp % 3 == 1)
        {
            setPositionDeut(temp + 26);
        } else if (temp % 3 == 2)
        {
            setPositionDeut(temp + 24);
        }

        return bolArray;
    }

    public void addEntry(String fremdIn, String deutIn)
    {
        int rowFremd = ((getPositionFremd()-1) / 3);
        XWPFTableRow tableRowFremd = table.getRow(rowFremd);
        int colFremd = (getPositionFremd()-1) % 3;

        XWPFParagraph paragraphFremd = tableRowFremd.getCell(colFremd).getParagraphArray(0);
        XWPFRun runFremd = paragraphFremd.createRun();
        runFremd.setText(fremdIn);
        runFremd.setFontSize(14);

        int rowDeut = ((getPositionDeut()-1) / 3);
        XWPFTableRow tableRowDeut = table.getRow(rowDeut);
        int colDeut = (getPositionDeut()-1) % 3;
        XWPFParagraph paragraphDeut = tableRowDeut.getCell(colDeut).getParagraphArray(0);
        XWPFRun runDeut = paragraphDeut.createRun();
        runDeut.setText(deutIn);
        runDeut.setFontSize(14);

        if (getPositionFremd() % 24 == 0)
        {

            int temp = getPositionEndArray();
            for (int r = temp; r < (temp+48); r = r + 3)
            {

                XWPFTable table = getTable();
                XWPFTableRow tableRowOne = getEmptyRow();
                table.addRow(tableRowOne);

                for (int w = 0; w < 3; w ++)
                {
                    bolArray.add(false);
                    incPositionEndArray();
                }
            }

            setPositionFremd((getPositionFremd()+25));

        }
        else
        {
            incPositionFremd();
        }

        int temp = getPositionFremd();

        if (temp % 3 == 0)
        {
            setPositionDeut(temp + 22);
        } else if (temp % 3 == 1)
        {
            setPositionDeut(temp + 26);
        } else if (temp % 3 == 2)
        {
            setPositionDeut(temp + 24);
        }

    }
}
