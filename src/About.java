import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class About implements ActionListener{
    JFrame frame = new JFrame();

    JMenuBar bar;
    JMenu convertMenu;
    JMenu modeMenu;
    JMenu aboutMenu;
    JMenu exitMenu;

    JMenuItem jpeg2pdf;
    JMenuItem pdf2jpeg;
    JMenuItem png2jpeg;
    JMenuItem jpeg2png;
    JMenuItem ppt2pdf;
    JMenuItem wav2mp3;
    JMenuItem mp3towav;


    JMenuItem singleWindow;
    JMenuItem multipleWindow;

    JMenuItem help;
    JMenuItem about;

    JMenuItem back;
    JMenuItem exit;

    
    JTextPane textPane;
    JScrollPane scrollPane;

    About() {

        String filePath = "C:\\Users\\HP\\SwingShift\\AboutUs.txt";
        String content = loadFileContent(filePath);

        frame.setTitle("About Us");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.setLayout(new BorderLayout());

        textPane = new JTextPane();
        textPane.setContentType("text/html"); 
        textPane.setEditable(false);
        textPane.setText(content);
        scrollPane = new JScrollPane(textPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(15, 100, 640, 550);


        bar = new JMenuBar();
        convertMenu = new JMenu("Convert");
        modeMenu = new JMenu("Mode");
        aboutMenu = new JMenu("About");
        exitMenu = new JMenu("Exit");

        jpeg2pdf = new JMenuItem("JPEG -> PDF");
        pdf2jpeg = new JMenuItem("PDF -> JPEG");
        png2jpeg = new JMenuItem("PNG -> JPEG");
        jpeg2png = new JMenuItem("JPEG -> PNG");
        ppt2pdf = new JMenuItem("PPT -> PDF");
        wav2mp3 = new JMenuItem("WAV -> MP3");
        mp3towav = new JMenuItem("MP3 -> WAV");


        singleWindow = new JMenuItem("Single File Conversion");
        multipleWindow = new JMenuItem("Multiple File Conversion");

        about = new JMenuItem("About Us");
        help = new JMenuItem("Help");

        back = new JMenuItem("Back to Main Menu");
        exit = new JMenuItem("Exit Application");




        convertMenu.add(jpeg2pdf);
        convertMenu.add(pdf2jpeg);
        convertMenu.add(ppt2pdf);
        convertMenu.add(png2jpeg);
        convertMenu.add(jpeg2png);
        convertMenu.add(mp3towav);
        convertMenu.add(wav2mp3);
        

        modeMenu.add(singleWindow);
        modeMenu.add(multipleWindow);

        aboutMenu.add(about);
        aboutMenu.add(help);

        exitMenu.add(back);
        exitMenu.add(exit);
        
        bar.add(convertMenu);
        bar.add(modeMenu);
        bar.add(aboutMenu);
        bar.add(exitMenu);

        frame.setJMenuBar(bar);
        //frame.add(downloadButton);
        frame.add(scrollPane,BorderLayout.CENTER);

        jpeg2pdf.addActionListener(this);
        pdf2jpeg.addActionListener(this);
        png2jpeg.addActionListener(this);
        jpeg2png.addActionListener(this);
        ppt2pdf.addActionListener(this);
        mp3towav.addActionListener(this);
        wav2mp3.addActionListener(this);
        help.addActionListener(this);

        back.addActionListener(this);
        exit.addActionListener(this);
        
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource()== back) {
            frame.dispose();
            new LaunchPage();
       }
       if (e.getSource()== exit) {
            System.exit(0);
       }
       if (e.getSource()== pdf2jpeg) {
            frame.dispose();
            new PDF2JPEG();
       }
       if (e.getSource()== png2jpeg) {
            frame.dispose();
            new PNG2JPEG();
       }
       if (e.getSource()== jpeg2png) {
            frame.dispose();
            new JPEG2PNG();
       }
       if (e.getSource()== ppt2pdf) {
            frame.dispose();
            System.setProperty("log4j2.disable", "true");
            new PPT2PDF();
       }
       if (e.getSource()== mp3towav) {
            frame.dispose();
            new MP3toWAV();
       }
       if (e.getSource()== wav2mp3) {
            frame.dispose();
            new WAV2MP3();
       }
       if (e.getSource()== jpeg2pdf) {
          frame.dispose();
          new JPEG2PDF();
       }
       if (e.getSource()== help) {
          frame.dispose();
          new Help();
       }
    } 
    private static String loadFileContent(String filePath) {
          StringBuilder contentBuilder = new StringBuilder();
          try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
              String line;
              while ((line = br.readLine()) != null) {
                  contentBuilder.append(line).append("\n");
              }
          } catch (IOException e) {
              e.printStackTrace();
          }
          return contentBuilder.toString();
     }
}
