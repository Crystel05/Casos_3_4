import Model.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class MainPruebasFiles {
    public static void main(String[] args) {
        JsonConfig jsonConfig = new JsonConfig();
        TXT txt = new TXT();
        JSON json = new JSON();
        CSV csv = new CSV();
        XML xml = new XML();

        // cargar texto en los archivos.
        String texto = "Esto es un texto de prueba, donde se guardará su \ninformación.";

        txt.setText(texto);
        json.setText(texto);
        csv.setText(texto);
        xml.setText(texto);
//        for (int index = 0; index <  texto.length(); index++) {
//            txt.addLetter(texto.toCharArray()[index]);
//            json.addLetter(texto.toCharArray()[index]);
//            csv.addLetter(texto.toCharArray()[index]);
//
//
//        }

        // PosColors de ejemplos.
        PosColor posColor = new PosColor(Color.AZUL, 0, 6);
        PosColor posColor2 = new PosColor(Color.ROJO, 15, 25);

        // guardamos la config en el Json de cada archivo.
        jsonConfig.saveLetters(posColor, FileType.TXT);
        jsonConfig.saveLetters(posColor, FileType.JSON);
        jsonConfig.saveLetters(posColor, FileType.CSV);
        jsonConfig.saveLetters(posColor, FileType.XML);

        jsonConfig.saveLetters(posColor2, FileType.TXT);
        jsonConfig.saveLetters(posColor2, FileType.JSON);
        jsonConfig.saveLetters(posColor2, FileType.CSV);
        jsonConfig.saveLetters(posColor2, FileType.XML);


        // guardamos lo archivos
        txt.saveFile();
        json.saveFile();
        csv.saveFile();
        xml.saveFile();

        // guardamos el archivo JSONConfig
        jsonConfig.saveConfig(FileType.TXT);
        jsonConfig.saveConfig(FileType.JSON);
        jsonConfig.saveConfig(FileType.CSV);
        jsonConfig.saveConfig(FileType.XML);

        //Devuelve una lista con los objetos PosColor que contiene.
        ArrayList<PosColor> txtListPostColors = jsonConfig.readConfig(FileType.TXT);
        ArrayList<PosColor> jsonListPostColors = jsonConfig.readConfig(FileType.JSON);
        ArrayList<PosColor> csvListPostColors = jsonConfig.readConfig(FileType.CSV);
        ArrayList<PosColor> xmlListPostColors = jsonConfig.readConfig(FileType.XML);


        txt.readFile("Prueba.txt");
        json.readFile("Prueba.json");
        csv.readFile("Prueba.csv");
        xml.readFile("Prueba.xml");


//        System.out.println("\nTexto Json después de readFile: " + json.text);
//
//        System.out.println("\nTexto CSV despues del read: " + csv.text);
//
//        System.out.println("\nTexto XML despues del read: " + xml.text);

    }


}
