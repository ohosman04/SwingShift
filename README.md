# SwingShift

SwingShift is a powerful desktop application designed to simplify the process of converting various file types quickly and efficiently. Whether you need to convert images, documents, or audio files, SwingShift has you covered. This user-friendly tool offers seamless and fast conversion options for a wide range of formats.

## Installation Instructions:

1.Extract the downloaded .zip file and navigate to it on your Command Prompt. 

2.Package as JAR:

Now, use the jar command that comes with the Java Development Kit (JDK) to package your compiled classes and the manifest file into a JAR file. Open a command prompt (or terminal) and navigate to the SwingShift directory and manifest.txt are located. Then run the following command:

jar cfm SwingShift.jar manifest.txt -C bin . -C lib . *.png *.txt logo.png AboutUs.txt Help.txt jpg.png mp3.png pdf.png pngpic.png ppt.png right-arrow.png wav.png

  
3.Run the Batch File in the same directoy by typing this command:

launcher.bat

## Supported File Conversions:

SwingShift covers an extensive array of formats, offering conversion options for the most commonly used file types. Our application currently supports the following conversions:

- JPEG to PDF
- PDF to JPEG
- PNG to JPEG
- PPT to PDF
- PDF to JPEG
- JPEG to PDF
- WAV to MP3
- MP3 to WAV

## System Requirements:

Before using SwingShift, make sure your system meets the following minimum requirements:

-Operating System: Windows 10, macOS 10.12, or above

-Java Development Kit (JDK) 16 or above installed

-Processor: 1.5 GHz dual-core CPU

-RAM: 2 GB

-Free Disk Space: At least 150 MB

## How to Convert Files with SwingShift:

1.Launch SwingShift: Open the project in your IDE and locate the main class (e.g., Main.java). Run the application by executing the main method.

2.Select Conversion Type: Choose the desired file conversion type from the list of supported formats.

3.Add Files: Click the "Add Files" button to select the files you want to convert.

4.Destination Folder: After the conversion is complete, click the "Download" button to choose the destination folder for the converted files.

## Tips for Optimal Results:

- When converting images, higher quality input files will generally yield better results.
- When converting audio files, consider the trade-off between sound quality and file size when selecting the output format.

## Troubleshooting:

If you encounter any issues while using SwingShift, consider the following steps:

1.Ensure you have JDK 16 or above installed.

2.Verify that your system meets the minimum requirements.

3.Make sure you have correctly set up the "lib" directory with the required external libraries.

## Technologies used:

1- Java

2- VSCode

3- Java Swing Module

4- VSCode

5- Java Abstract Window Toolkit Module

6- Java ilovePDF API

7- Java imageIO

8- Java Apache's PDFBox

9- Java Apache's POIXSLF

## Contributing:

We welcome contributions to improve SwingShift! Feel free to fork this repository, make changes, and submit a pull request.

We hope this help page has provided you with the necessary information to use SwingShift effectively. Enjoy seamless file conversions with SwingShift!
