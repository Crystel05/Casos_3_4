import Model.*;
import org.json.simple.JSONObject;

import java.util.concurrent.ThreadLocalRandom;

public class MainPruebasFiles {
    public static void main(String[] args) {
        JsonConfig jsonConfig = new JsonConfig();
        TXT txt = new TXT();
        JSON json = new JSON();
        String texto = "Esto es un texto de prueba, donde se guardará su información.";
        for (int index = 0; index <  texto.length(); index++) {
//            System.out.println(texto.toCharArray()[index]);
//            int rand = ThreadLocalRandom.current().nextInt(0, 10);
//            if (rand < 3) {
//
//                jsonConfig.saveLetters(index,"rojo", FileType.TXT);
//            }
            txt.addLetter(texto.toCharArray()[index]);
            json.addLetter(texto.toCharArray()[index]);
//            System.out.println(rand);
//            jsonConfig.saveLetter(index,"rojo");
        }


        PosColor posColor = new PosColor(Color.AZUL, 0, 6);
        System.out.println();
        jsonConfig.saveLetters(posColor, FileType.TXT);
        jsonConfig.saveLetters(posColor, FileType.JSON);

////        jsonConfig.saveLetters(15,"rojo", FileType.TXT);
        txt.addLetter("$".toCharArray()[0]);
        txt.saveFile();
        json.saveFile();
        jsonConfig.saveConfig(FileType.TXT);
        jsonConfig.saveConfig(FileType.JSON);

        Object txtObjectConfig = jsonConfig.readConfig(FileType.TXT);

        System.out.println(((JSONObject)txtObjectConfig));

        // Simulación readTXT
        txt.readFile("Prueba.txt");
        System.out.println(txt.letters);
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
        System.out.println(textoPrueba);
        String jsontext = json.readFile("Prueba.json");
        System.out.println(jsontext);
    }
}
