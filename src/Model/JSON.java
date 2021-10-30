package Model;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JSON {
    private String text = "";
    public char[] letters = null;
    public JSONObject jsonfile = new JSONObject();

    public void addLetter(Character letter){
        this.text += letter;
    }

    public void saveFile(){
        try{
            FileWriter file = new FileWriter("Prueba.json");
            jsonfile.put("texto",this.text);
            file.write(jsonfile.toJSONString());
            file.flush();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public String readFile(String fileName){
        JSONParser jsonParser = new JSONParser();
        try{
            FileReader fileReader = new FileReader(fileName);
            Object obj = jsonParser.parse(fileReader);
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);
            return jsonObject.get("texto").toString();

        }catch (IOException e){
            e.printStackTrace();
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        return "";
    }


}
