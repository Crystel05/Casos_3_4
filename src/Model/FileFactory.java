package Model;

import javafx.geometry.Pos;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileFactory {
    private TXT txtFile = new TXT();
    private XML xmlFile = new XML();
    private CSV csvFile = new CSV();
    private JSON jsonFile = new JSON();
    private JsonConfig jsonConfigFile = new JsonConfig();

    private String texto;

    private FileReader txtFileReader;
    private FileReader xmlFileReader;
    private FileReader csvFileReader;
    private FileReader jasonFileReader;

    private FileWriter txtFileWriter;
    private FileWriter xmlFileWriter;
    private FileWriter csvFileWriter;
    private FileWriter jasonFileWriter;

    private String fileName;

//    public void getRequestedFile(FileType tipo){
//        switch (tipo){
//            case TXT:
//
//        }
//    }


    public String getTexto() {
        return texto;
    }

    public void setFile(File file, String name) {
        fileName = name;
    }

    public void saveFile(FileType type, String texto, String path, ArrayList<PosColor> posColors) {
        switch (type){
            case TXT:
                txtFile.setText(texto);
                txtFile.saveFile(path);
                jsonConfigFile.saveLetters(posColors, type);
                jsonConfigFile.saveConfig(type, path);
                break;
            case CSV:
                csvFile.setText(texto);
                csvFile.saveFile(path);
                jsonConfigFile.saveLetters(posColors, type);
                jsonConfigFile.saveConfig(type, path);
                break;
            case JSON:
                jsonFile.setText(texto);
                jsonFile.saveFile(path);
                jsonConfigFile.saveLetters(posColors, type);
                jsonConfigFile.saveConfig(type, path);
                break;
            case XML:
                xmlFile.setText(texto);
                xmlFile.saveFile(path);
                jsonConfigFile.saveLetters(posColors, type);
                jsonConfigFile.saveConfig(type, path);
                break;
        }

    }

    public ArrayList<PosColor> readFile(FileType type, String path) {
        ArrayList<PosColor> posColors;
        switch (type){
            case TXT:
                txtFile.readFile(path);
                texto = txtFile.getText();
                posColors = jsonConfigFile.readConfig(type, path);
                return posColors;
            case CSV:
                csvFile.readFile(path);
                texto = csvFile.getText();
                posColors = jsonConfigFile.readConfig(type, path);
                return posColors;
            case JSON:
                jsonFile.readFile(path);
                texto = jsonFile.getText();
                posColors = jsonConfigFile.readConfig(type, path);
                return posColors;
            case XML:
                xmlFile.readFile(path);
                texto = xmlFile.getText();
                posColors = jsonConfigFile.readConfig(type, path);
                return posColors;
        }
        return null;

    }




}
