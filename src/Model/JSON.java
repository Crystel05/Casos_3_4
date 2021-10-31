package Model;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSON {
    public String text = "";
    public char[] letters = null;
    public JSONObject jsonfile = new JSONObject();

    public void addLetter(Character letter){
        this.text += letter;
    }

    public void setText(String texto){
        this.text = texto;
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

    public void readFile(String fileName){
        JSONParser jsonParser = new JSONParser();
        try{
            FileReader fileReader = new FileReader(fileName);
            Object obj = jsonParser.parse(fileReader);
            JSONObject jsonObject = (JSONObject) obj;

            this.text =  jsonObject.get("texto").toString();
            this.letters = text.toCharArray();

        }catch (IOException e){
            e.printStackTrace();
        }
        catch (ParseException e){
            e.printStackTrace();
        }
    }


}
