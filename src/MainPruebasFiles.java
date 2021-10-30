import Model.*;
import org.json.simple.JSONObject;

import java.sql.SQLOutput;
import java.util.concurrent.ThreadLocalRandom;

public class MainPruebasFiles {
    public static void main(String[] args) {
        JsonConfig jsonConfig = new JsonConfig();
        TXT txt = new TXT();
        JSON json = new JSON();
        CSV csv = new CSV();

        // cargar texto en los archivos.
        String texto = "Esto es un texto de prueba, donde se guardará su \ninformación.";
        for (int index = 0; index <  texto.length(); index++) {
            txt.addLetter(texto.toCharArray()[index]);
            json.addLetter(texto.toCharArray()[index]);
            csv.addLetter(texto.toCharArray()[index]);

        }

        // PosColors de ejemplos.
        PosColor posColor = new PosColor(Color.AZUL, 0, 6);

        // guardamos la config en el Json de cada archivo.
        jsonConfig.saveLetters(posColor, FileType.TXT);
        jsonConfig.saveLetters(posColor, FileType.JSON);
        jsonConfig.saveLetters(posColor, FileType.CSV);


        // guardamos lo archivos
        txt.saveFile();
        json.saveFile();
        csv.saveFile();

        // guardamos el archivo JSONConfig
        jsonConfig.saveConfig(FileType.TXT);
        jsonConfig.saveConfig(FileType.JSON);
        jsonConfig.saveConfig(FileType.CSV);

        //cargamos la config del Json de cada tipo
        Object txtObjectConfig = jsonConfig.readConfig(FileType.TXT);
        Object jsonObjectConfig = jsonConfig.readConfig(FileType.JSON);
        Object csvObjectConfig = jsonConfig.readConfig(FileType.CSV);

        System.out.println("JsonConfig: "+ ((JSONObject)txtObjectConfig));

        // Simulación

        txt.readFile("Prueba.txt");
        json.readFile("Prueba.json");
        csv.readFile("Prueba.csv");

        //***** SIMULACIÓN TXT
        String textoPrueba = "";
        int index = 0;
        while(index < txt.letters.length){
            Object textoColor = ((JSONObject)txtObjectConfig).get(Integer.toString(index));
            if(textoColor != null){
                int posIni = Integer.parseInt(((JSONObject)textoColor).get("ini").toString());
                int posFin = Integer.parseInt(((JSONObject)textoColor).get("fin").toString());
                String color = ((JSONObject)textoColor).get("color").toString();
//                System.out.println(((JSONObject) txtObjectConfig).get("0"));
//                System.out.println("Sï");
                textoPrueba += "{";
                while (posIni <= posFin){
                    textoPrueba += txt.letters[posIni];
                    posIni++;
                }
                textoPrueba += "("+ color + ")";
                index = posFin + 1;

            }
            else{
                textoPrueba += txt.letters[index];
                index++;
            }
//            index++;
        }
        System.out.println("\nTexto con config txt: " + textoPrueba);

        System.out.println("\nTexto Json después de readFile: " + json.text);

        System.out.println("\nTexto CSV despues del read: " + csv.text);

    }
}
