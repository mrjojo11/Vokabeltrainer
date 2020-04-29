//package util;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.util.ArrayList;
//
//import javax.swing.JButton;
//import javax.swing.JFileChooser;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JTextField;
//import javax.swing.SwingConstants;
//
//import org.apache.poi.xwpf.usermodel.XWPFDocument;
//import org.apache.poi.xwpf.usermodel.XWPFParagraph;
//import org.apache.poi.xwpf.usermodel.XWPFRun;
//import org.apache.poi.xwpf.usermodel.XWPFTable;
//import org.apache.poi.xwpf.usermodel.XWPFTableRow;
//
//public class Program implements ActionListener  {
//
//    String filePath;
//    static XWPFTable table;
//    static ArrayList<Boolean> bolArray;
//    static XWPFTableRow emptyRow;
//    static int positionEndArray;
//    static int positionFremd;
//    static int positionDeut;
//
//    public Program() {
//
//        filePath = null;
//        table = null;
//        bolArray = null;
//        emptyRow = null;
//        positionEndArray = 0;
//        positionFremd = 0;
//        positionDeut = 0;
//    }
//
//    public void setFilePath(String filePathIn) {
//        filePath = filePathIn;
//    }
//    public String getFilePath() {
//        return filePath;
//    }
//
//    public static int getPositionEndArray() {
//        return positionEndArray;
//    }
//
//    public static void incPositionEndArray() {
//        positionEndArray = positionEndArray +1;
//    }
//
//    public static int getPositionFremd() {
//        return positionFremd;
//    }
//
//    public static void setPositionFremd(int positionFremdIn) {
//        positionFremd = positionFremdIn;
//    }
//
//    public static void incPositionFremd() {
//        positionFremd = positionFremd +1;
//    }
//
//    public static int getPositionDeut() {
//        return positionDeut;
//    }
//
//    public static void setPositionDeut(int positionDeutIn) {
//        positionDeut = positionDeutIn;
//    }
//
//    public static void incPositionDeut() {
//        positionDeut = positionDeut +1;
//    }
//
//    public static void setTable(XWPFTable tableIn) {
//        table = tableIn;
//    }
//    public static XWPFTable getTable() {
//        return table;
//    }
//
//    public static void setBolArray(ArrayList<Boolean> bolArrayIn) {
//        bolArray = bolArrayIn;
//    }
//    public static ArrayList<Boolean> getBolArray() {
//        return bolArray;
//    }
//
//    public static void setEmptyRow(XWPFTableRow emptyRowIn) {
//        emptyRow = emptyRowIn;
//    }
//    public static XWPFTableRow getEmptyRow() {
//        return emptyRow;
//    }
//
//
//    public XWPFDocument read() {
//        try {
//            JFileChooser window = new JFileChooser();
//            int returnValue = window.showOpenDialog(null);
//
//            if(returnValue == JFileChooser.APPROVE_OPTION)
//            {
//                XWPFDocument document = new XWPFDocument(new FileInputStream(window.getSelectedFile()));
//                setFilePath(window.getSelectedFile().getAbsolutePath());
//                return document;
//            }
//            return null;
//        }
//        catch (Exception e)
//        {
//            e.getStackTrace();
//        }
//        return null;
//    }
//
//    public void write(XWPFDocument document) {
//        try {
//            FileOutputStream output = new FileOutputStream(getFilePath());
//            document.write(output);
//            output.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public ArrayList<Boolean> analyse(XWPFTable table) {
//
//        ArrayList<Boolean> bolArray = new ArrayList<Boolean>();
//
//        for(int r = 0; r < (table.getNumberOfRows()); r++) {
//            for (int c = 0; c < 3; c++) {
//                XWPFTableRow tableRowOne = table.getRow(r);
//                if(tableRowOne.getCell(c).getText().isEmpty() == true)
//                {
//                    bolArray.add(getPositionEndArray(), false);
//                    incPositionEndArray();
//                }
//                else
//                {
//                    bolArray.add(getPositionEndArray(), true);
//                    incPositionEndArray();
//                }
//            }
//        }
//
//
//        if (bolArray.size() < 96)
//        {
//            int temp = bolArray.size() % 96;
//
//
//            for (int r = (temp / 3); r < (96/3); r++)
//            {
//                int row = (int) ((Math.floor(getPositionEndArray() / 3)) - 1);
//                XWPFTableRow tableRowOne = getTable().getRow(row);
//                setEmptyRow(tableRowOne);
//                getTable().addRow(tableRowOne);
//            }
//
//            for (int r = temp; r < 96; r++)
//            {
//                bolArray.add(false);
//                incPositionEndArray();
//            }
//        }
//        else
//        {
//            int row = (int) ((Math.floor(getPositionEndArray() / 3)) - 1);
//            XWPFTableRow tableRowOne = getTable().getRow(row);
//            setEmptyRow(tableRowOne);
//        }
//
//        for(int r = 0; r < bolArray.size(); r++)
//        {
//            if (bolArray.get(r) == false)
//            {
//                setPositionFremd(r+1);
//                break;
//            }
//        }
//
//        int temp = getPositionFremd();
//
//        if (temp % 3 == 0)
//        {
//            setPositionDeut(temp + 22);
//        } else if (temp % 3 == 1)
//        {
//            setPositionDeut(temp + 26);
//        } else if (temp % 3 == 2)
//        {
//            setPositionDeut(temp + 24);
//        }
//
//        return bolArray;
//    }
//
//    public void addEntry(String fremdIn, String deutIn)
//    {
//        int rowFremd = ((getPositionFremd()-1) / 3);
//        XWPFTableRow tableRowFremd = table.getRow(rowFremd);
//        int colFremd = (getPositionFremd()-1) % 3;
//        XWPFParagraph paragraphFremd = tableRowFremd.getCell(colFremd).getParagraphArray(0);
//        XWPFRun runFremd = paragraphFremd.createRun();
//        runFremd.setText(fremdIn);
//        runFremd.setFontSize(14);
//
//        int rowDeut = ((getPositionDeut()-1) / 3);
//        XWPFTableRow tableRowDeut = table.getRow(rowDeut);
//        int colDeut = (getPositionDeut()-1) % 3;
//        XWPFParagraph paragraphDeut = tableRowDeut.getCell(colDeut).getParagraphArray(0);
//        XWPFRun runDeut = paragraphDeut.createRun();
//        runDeut.setText(deutIn);
//        runDeut.setFontSize(14);
//
//        if (getPositionFremd() % 24 == 0)
//        {
//
//            int temp = getPositionEndArray();
//            for (int r = temp; r < (temp+48); r = r + 3)
//            {
//
//                XWPFTable table = getTable();
//                XWPFTableRow tableRowOne = getEmptyRow();
//                table.addRow(tableRowOne);
//
//                for (int w = 0; w < 3; w ++)
//                {
//                    bolArray.add(false);
//                    incPositionEndArray();
//                }
//            }
//
//            setPositionFremd((getPositionFremd()+25));
//
//        }
//        else
//        {
//            incPositionFremd();
//        }
//
//        int temp = getPositionFremd();
//
//        if (temp % 3 == 0)
//        {
//            setPositionDeut(temp + 22);
//        } else if (temp % 3 == 1)
//        {
//            setPositionDeut(temp + 26);
//        } else if (temp % 3 == 2)
//        {
//            setPositionDeut(temp + 24);
//        }
//
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//
//    }
//
//    public static void main(String[] args) {
//
//        Program main = new Program();
//        XWPFDocument document = main.read();
//        setTable(document.getTableArray(0));
//        setBolArray(main.analyse(getTable()));
//
//        JFrame frame = new JFrame();
//        frame.setSize(1200,900);// width and height
//        frame.setLayout(null);//using no layout managers
//        frame.setVisible(true);//making the frame visible
//
//        JButton readButton = new JButton("Read a file");//creating instance of JButton
//        readButton.setBounds(800,50,100, 40);//x axis, y axis, width, height
//        frame.add(readButton);//adding button in JFrame
//        readButton.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent e){
//                XWPFDocument document = main.read();
//                setTable(document.getTableArray(0));
//                setBolArray(main.analyse(table));
//            }
//        });
//
//        JButton writeButton = new JButton("Write to file");//creating instance of JButton
//        writeButton.setBounds(800,100,100, 40);//x axis, y axis, width, height
//        frame.add(writeButton);//adding button in JFrame
//        writeButton.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent e){
//                main.write(document);
//            }
//        });
//
//
//        JTextField fremdWort=new JTextField();
//        fremdWort.setBounds(100,150, 300,80);
//        frame.add(fremdWort);//adding button in JFrame
//        JLabel fremdWortLabel = new JLabel("Add Fremdwort here");
//        fremdWortLabel.setBounds(100, 120, 300,30);
//        fremdWortLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        frame.add(fremdWortLabel);
//
//        JTextField deutWort=new JTextField();
//        deutWort.setBounds(450,150, 300,80);
//        frame.add(deutWort);//adding button in JFrame
//        JLabel deutWortLabel = new JLabel("Add Deutschwort here");
//        deutWortLabel.setBounds(450,120, 300,30);
//        deutWortLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        frame.add(deutWortLabel);
//
//        JButton addButton = new JButton("Add Words");//creating instance of JButton
//        addButton.setBounds(800,150,100, 40);//x axis, y axis, width, height
//        frame.add(addButton);//adding button in JFrame
//        addButton.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent e){
//                String fremdIn = fremdWort.getText();
//                String deutIn = deutWort.getText();
//                main.addEntry(fremdIn, deutIn);
//                fremdWort.setText(null);
//                deutWort.setText(null);
//            }
//        });
//
//    }
//}
//
