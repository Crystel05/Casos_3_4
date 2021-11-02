package Model;

import org.json.simple.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class TXT {
    private String text = "";
    public char[] letters = null;
    private ArrayList<PosColor> posColors = new ArrayList<>();

    public void addLetter(Character letter){
        this.text += letter;
    }

    public void setText(String texto){
        this.text = texto;
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
                caracterLeido = fileReader.read();
            }
            this.text = texto;
            this.letters = texto.toCharArray();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public ArrayList<PosColor> getPosColors(Object objectConfig){
        int index = 0;
        return  this.posColors;
    }


}
