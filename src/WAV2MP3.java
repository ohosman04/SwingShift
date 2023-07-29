import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


//import java.nio.file.Path;
//import java.nio.file.Paths;

public class WAV2MP3 implements ActionListener{
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
    

    JMenuItem help;
    JMenuItem about;

    JMenuItem back;
    JMenuItem exit;

    JButton selectFileButton;
    JButton downloadButton;

    JLabel label1;
    JLabel label2;
    JLabel arrow;
    JLabel confirmLabel;

    File file;
    File selectedFile;

    WAV2MP3() {

        ImageIcon mp3 = new ImageIcon("mp3.png");
        ImageIcon wav = new ImageIcon("wav.png");
        ImageIcon arrowImg = new ImageIcon("right-arrow.png");

        frame.setTitle("SwingShift File Converter");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.setLayout(null);

        bar = new JMenuBar();
        convertMenu = new JMenu("Convert");
        modeMenu = new JMenu("Mode");
        aboutMenu = new JMenu("About");
        exitMenu = new JMenu("Exit");

        jpeg2pdf = new JMenuItem("JPEG -> PDF");
        pdf2jpeg = new JMenuItem("PDF -> JPEG");
        png2jpeg = new JMenuItem("PNG -> JPEG");
        jpeg2png = new JMenuItem("JPEG -> PNG");
        ppt2pdf = new JMenuItem("PPTX -> PDF");
        wav2mp3 = new JMenuItem("WAV -> MP3");
        mp3towav = new JMenuItem("MP3 -> WAV");


        singleWindow = new JMenuItem("Single File Conversion");
        

        about = new JMenuItem("About Us");
        help = new JMenuItem("Help");

        back = new JMenuItem("Back to Main Menu");
        exit = new JMenuItem("Exit Application");

        selectFileButton = new JButton("Select File");
        selectFileButton.addActionListener(this);
        selectFileButton.setBounds(10, 350, 150, 60);
        selectFileButton.setFocusable(false);
        selectFileButton.setBorder(BorderFactory.createEmptyBorder());
        selectFileButton.setBackground(new Color(0, 0, 100));
        selectFileButton.setForeground(Color.white);

        downloadButton = new JButton("Download File");
        downloadButton.setBounds(270, 450, 150, 60);
        downloadButton.setFocusable(false);
        downloadButton.setBorder(BorderFactory.createEmptyBorder());
        downloadButton.setBackground(new Color(55,170,136));
        downloadButton.setForeground(Color.white);
        downloadButton.addActionListener(this);
        

        label1 = new JLabel();
        label2 = new JLabel();
        arrow =  new JLabel();
        confirmLabel = new JLabel();

        label1.setBounds(200, 250, 64, 64);
        label2.setBounds(440, 250, 64, 64);
        arrow.setBounds(290, 240, 130, 100);
        label1.setBackground(Color.green);
        label2.setBackground(Color.blue);
        label1.setIcon(wav);
        label2.setIcon(mp3);
        arrow.setIcon(arrowImg);

        confirmLabel.setBounds(170, 365, 500, 20);
        confirmLabel.setBorder(BorderFactory.createDashedBorder(null));
        confirmLabel.setFont(new Font(null, Font.BOLD, 15));
        confirmLabel.setText("Selected File: ");

        convertMenu.add(jpeg2pdf);
        convertMenu.add(pdf2jpeg);
        convertMenu.add(ppt2pdf);
        convertMenu.add(png2jpeg);
        convertMenu.add(jpeg2png);
        convertMenu.add(mp3towav);
        convertMenu.add(wav2mp3);
        

        modeMenu.add(singleWindow);
        

        aboutMenu.add(about);
        aboutMenu.add(help);

        exitMenu.add(back);
        exitMenu.add(exit);
        
        bar.add(convertMenu);
        bar.add(modeMenu);
        bar.add(aboutMenu);
        bar.add(exitMenu);

        frame.setJMenuBar(bar);
        frame.add(selectFileButton);
        frame.add(label1);
        frame.add(label2);
        frame.add(arrow);
        frame.add(confirmLabel);
        //frame.add(downloadButton);

        jpeg2pdf.addActionListener(this);
        pdf2jpeg.addActionListener(this);
        png2jpeg.addActionListener(this);
        jpeg2png.addActionListener(this);
        ppt2pdf.addActionListener(this);
        mp3towav.addActionListener(this);
        wav2mp3.addActionListener(this);
        about.addActionListener(this);
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
        if (e.getSource()== jpeg2pdf) {
            frame.dispose();
            new JPEG2PDF();
       }
       if (e.getSource()== about) {
        frame.dispose();
        new About();
       }
       if (e.getSource()== help) {
        frame.dispose();
        new Help();
       }
       if (e.getSource() == selectFileButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();
                confirmLabel.setText("Selected File: " + selectedFile.getAbsolutePath());
                frame.add(downloadButton);
            }
        } 
        else if (e.getSource() == downloadButton) {
            if (selectedFile != null && selectedFile.exists()) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setSelectedFile(new File(selectedFile.getName().replace(".wav", ".mp3")));
                int response = fileChooser.showSaveDialog(null);
                if (response == JFileChooser.APPROVE_OPTION) {
                    File destinationFile = fileChooser.getSelectedFile();
                    String outputMp3Path = destinationFile.getAbsolutePath();
                    convertWavToMp3(selectedFile.getAbsolutePath(), outputMp3Path);
                    JOptionPane.showMessageDialog(null, "Your Converted MP3 file is downloaded.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select a WAV file to convert.");
            }
        }
    }

    public void convertWavToMp3(String inputWavFile, String outputMp3File) {
        try {
            String lamePath = "\"C:\\Lame\\lame.exe\""; 
    
            String lameCommand = lamePath + " -b 128 \"" + inputWavFile + "\" \"" + outputMp3File + "\"";
            ProcessBuilder processBuilder = new ProcessBuilder(lameCommand);
            processBuilder.redirectErrorStream(true);
    
            Process process = processBuilder.start();
    
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                JOptionPane.showMessageDialog(null, "Failed to convert WAV to MP3. Exit code: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to convert WAV to MP3.");
        }
    }
}

