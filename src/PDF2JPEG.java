import javax.imageio.ImageIO;
import javax.swing.*;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import java.awt.event.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;


public class PDF2JPEG implements ActionListener{
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

    PDF2JPEG() {

        ImageIcon jpg = new ImageIcon("jpg.png");
        ImageIcon pdf = new ImageIcon("pdf.png");
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

        label1 = new JLabel();
        label2 = new JLabel();
        arrow =  new JLabel();
        confirmLabel = new JLabel();

        label1.setBounds(440, 250, 64, 64);
        label2.setBounds(200, 230, 100, 100);
        arrow.setBounds(290, 240, 130, 100);
        label1.setBackground(Color.green);
        label2.setBackground(Color.blue);
        label1.setIcon(jpg);
        label2.setIcon(pdf);
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
        if (e.getSource()== about) {
            frame.dispose();
            new About();
       }
       if (e.getSource()== help) {
        frame.dispose();
        new Help();
       }
       else if (e.getSource() == selectFileButton) {
        JFileChooser fileChooser = new JFileChooser();
        int response = fileChooser.showOpenDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
            file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            confirmLabel.setText("Selected File: " + file.getAbsolutePath());
            convertToJPEG(file);
            frame.add(downloadButton);
            downloadButton.addActionListener(this);
        }
    } else if (e.getSource() == downloadButton) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose Destination Folder");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int response = fileChooser.showSaveDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
            File destinationFolder = fileChooser.getSelectedFile();
            String sourceFolderPath = System.getProperty("user.home") + File.separator + "convertedImages";
            File sourceFolder = new File(sourceFolderPath);
            File[] jpegFiles = sourceFolder.listFiles((dir, name) -> name.endsWith(".jpg"));
            
            if (jpegFiles != null && jpegFiles.length > 0) {
                for (File jpegFile : jpegFiles) {
                    File destinationFile = new File(destinationFolder, jpegFile.getName());
                    try {
                        java.nio.file.Files.copy(jpegFile.toPath(), destinationFile.toPath());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Failed to download the JPEG image(s).");
                    }
                }
                JOptionPane.showMessageDialog(null, "JPEG image(s) downloaded successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "No JPEG image(s) found to download.");
            }
        }
    }
    }  
    public static void convertToJPEG(File inputFile) {
        try (InputStream inputStream = new FileInputStream(inputFile)) {
            PDDocument document = Loader.loadPDF(inputFile);
            PDFRenderer pdfRenderer = new PDFRenderer(document);

            String outputDirPath = System.getProperty("user.home") + File.separator + "convertedImages";
            File outputDir = new File(outputDirPath);
            if (!outputDir.exists()) {
                outputDir.mkdir();
            }

            int pageCount = document.getNumberOfPages();
            for (int page = 0; page < pageCount; page++) {
                BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 300);
                String outputImagePath = outputDirPath + File.separator + "page_" + (page + 1) + ".jpg";
                ImageIO.write(bim, "jpg", new File(outputImagePath));
            }

            document.close();

            JOptionPane.showMessageDialog(null, "PDF converted to JPEG image(s) successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to convert the PDF to JPEG image(s).");
        }
    }
}

