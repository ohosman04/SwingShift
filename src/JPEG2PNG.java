import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.io.IOException;


import java.awt.image.BufferedImage;
import java.io.File;

public class JPEG2PNG implements ActionListener{
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

    JPEG2PNG() {

        ImageIcon jpg = new ImageIcon("pngpic.png");
        ImageIcon png = new ImageIcon("jpg.png");
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

        label1.setBounds(440, 250, 64, 64);
        label2.setBounds(200, 250, 64, 64);
        arrow.setBounds(290, 240, 130, 100);
        label1.setBackground(Color.green);
        label2.setBackground(Color.blue);
        label1.setIcon(jpg);
        label2.setIcon(png);
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
           if (e.getSource()== jpeg2pdf) {
                frame.dispose();
                new JPEG2PDF();
           }
           if (e.getSource()== pdf2jpeg) {
                frame.dispose();
                new PDF2JPEG();
           }    
           if (e.getSource()== png2jpeg) {
                frame.dispose();
                new PNG2JPEG();
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
                    file = fileChooser.getSelectedFile();
                    confirmLabel.setText("Selected File: " + file.getAbsolutePath());
                    frame.add(downloadButton);
                    frame.revalidate();
                    frame.repaint();
                }
           } 
           else if (e.getSource() == downloadButton) {
                if (file != null) {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setDialogTitle("Choose Destination Folder");
                    fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    int response = fileChooser.showSaveDialog(null);
                    if (response == JFileChooser.APPROVE_OPTION) {
                        File destinationFolder = fileChooser.getSelectedFile();
                        String outputFilePath = new File(destinationFolder, file.getName().replace(".jpeg", ".png")).getAbsolutePath();
                        jpegToPng(file, outputFilePath);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a JPG file first.");
                }
            }
        }
        public static void jpegToPng(File inputFile, String outputFilePath) {
            try {
                BufferedImage image = ImageIO.read(inputFile);
                File outputFile = new File(outputFilePath);
                ImageIO.write(image, "png", outputFile);
                JOptionPane.showMessageDialog(null, "JPEG image converted to PNG successfully.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error converting JPEG to PNG: " + e.getMessage());
            }
        }
}


