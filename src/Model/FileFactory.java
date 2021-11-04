package Model;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileFactory {
    private File txtFile;
    private File xmlFile;
    private File csvFile;
    private File jsonFile;

    private FileReader txtFileReader;
    private FileReader xmlFileReader;
    private FileReader csvFileReader;
    private FileReader jasonFileReader;

    private FileWriter txtFileWriter;
    private FileWriter xmlFileWriter;
    private FileWriter csvFileWriter;
    private FileWriter jasonFileWriter;

    private String fileName;

    public File getRequestedFile(FileType tipo){
        switch (tipo){
            case TXT:
                return new File();
        }
    }


}
