package Model;

import org.json.simple.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TXT {
    private String text = "";
    public char[] letters = null;

    public void addLetter(Character letter){
        this.text += letter;
    }

    public void saveFile(){
        try{
            FileWriter file = new FileWriter("Prueba.txt");
            file.write(this.text);
            file.flush();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readFile(String fileName){
        try{
            FileReader fileReader = new FileReader(fileName);
            int caracterLeido = fileReader.read();
            String texto = "";
            while(caracterLeido!= -1) {
                char caracter = (char) caracterLeido;
                texto += caracter;
//                System.out.print(caracter);
                caracterLeido = fileReader.read();
            }
            this.text = texto;
            this.letters = texto.toCharArray();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

//    public ArrayList getLetterConfig(int index, JSONObject jsonConfig){
//        char letter = this.letters[index];
//        ArrayList<String> letterColor = new ArrayList<>();
//        String color = jsonConfig.get(Integer.toString(index)).toString();
//        System.out.println(color);
//        if (color != null){
//            System.out.println("lskfhg");
//        }
////        if (jsonConfig.get(Integer.toString(index)).toString() == "rojo"){
////            System.out.println("ALALALAL");
////            color = jsonConfig.get(Integer.toString(index)).toString();
////            System.out.println("Mm");
////            System.out.println(color);
////        }
//
//        letterColor.add(Character.toString(letter));
//        letterColor.add(color);
//        System.out.println(jsonConfig);
//        return letterColor;
//
//    }

}
