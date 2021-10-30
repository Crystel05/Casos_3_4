package Model;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class XML {
    private String text = "";
    public char[] letters = null;

    public void addLetter(Character letter){
        this.text += letter;
    }

    public void saveFile(){
        try{

            FileWriter file = new FileWriter("Prueba.xml");


            file.flush();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readFile(String fileName){
        try{
            FileReader fileReader = new FileReader(fileName);


        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
