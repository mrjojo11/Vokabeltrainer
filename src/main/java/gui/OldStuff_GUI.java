//package gui;
//
//import org.apache.poi.xwpf.usermodel.XWPFDocument;
//import util.io.OldStuff;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JTextField;
//import javax.swing.SwingConstants;
//
//public class OldStuff_GUI {
//
//        OldStuff programm;
//        XWPFDocument document;
//
//        JTextField fremdWort;
//        JTextField deutWort;
//
//        public OldStuff_GUI() {
//            programm = new OldStuff();
//            document = programm.read();
//
//            fremdWort = new JTextField();
//            deutWort = new JTextField();
//        }
//
//        public void start() {
//
//        programm.setTable(document.getTableArray(0));
//        programm.setBolArray(programm.analyse(programm.getTable()));
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
//                XWPFDocument document = programm.read();
//                programm.setTable(document.getTableArray(0));
//                programm.setBolArray(programm.analyse(programm.table));
//            }
//        });
//
//        JButton writeButton = new JButton("Write to file");//creating instance of JButton
//        writeButton.setBounds(800,100,100, 40);//x axis, y axis, width, height
//        frame.add(writeButton);//adding button in JFrame
//        writeButton.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent e){
//                programm.write(document);
//            }
//        });
//
//        //JTextField fremdWort=new JTextField();
//        fremdWort.setBounds(100,150, 300,80);
//        frame.add(fremdWort);//adding button in JFrame
//        JLabel fremdWortLabel = new JLabel("Add Fremdwort here");
//        fremdWortLabel.setBounds(100, 120, 300,30);
//        fremdWortLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        frame.add(fremdWortLabel);
//
//        //JTextField deutWort=new JTextField();
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
//                programm.addEntry(fremdIn, deutIn);
//                fremdWort.setText(null);
//                deutWort.setText(null);
//            }
//        });
//    }
//
//    public static void main(String[] args) {
//        OldStuff_GUI test = new OldStuff_GUI();
//
//        test.start();
//    }
//
//}
