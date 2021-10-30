package Model;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonConfig {
    private JSONObject textConfig = new JSONObject();

    private JSONObject txtFile = new JSONObject();
    private JSONObject csvFile = new JSONObject();
    private JSONObject jsonFile = new JSONObject();
    private JSONObject xmlFile = new JSONObject();


    public void saveLetters(PosColor posColor, FileType typeFile){
        JSONObject josnPosColor = new JSONObject();
        josnPosColor.put("ini", posColor.getPosInicial());
        josnPosColor.put("fin", posColor.getPosFinal());
        josnPosColor.put("color", posColor.getColor().toString());
        switch (typeFile){
            case TXT:
                this.txtFile.put(posColor.getPosInicial(), josnPosColor);
//                this.txtFile.put(posColor.getPosFinal(), "ff");
                break;
            case CSV:
                this.csvFile.put(posColor.getPosInicial(), josnPosColor);
                break;
            case XML:
                this.xmlFile.put(posColor.getPosInicial(), josnPosColor);
                break;
            case JSON:
                this.jsonFile.put(posColor.getPosInicial(), josnPosColor);
                break;
        }
//        JSONObject txtFile = new JSONObject();
//        this.txtFile.put(indexLetter, color);


    }

    public void saveConfig(FileType typeFile){
        try{
            if(!this.txtFile.isEmpty()) {
                this.textConfig.put(typeFile, this.txtFile);
            }
            if(!this.csvFile.isEmpty()) {
                this.textConfig.put(typeFile, this.csvFile);
            }
            if(!this.xmlFile.isEmpty()) {
                this.textConfig.put(typeFile, this.xmlFile);
            }
            if(!this.jsonFile.isEmpty()) {
                this.textConfig.put(typeFile, this.jsonFile);
            }

            FileWriter file = new FileWriter("config.json");
            file.write(this.textConfig.toJSONString());
            file.flush();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public Object readConfig(FileType typeFile){
        JSONParser jsonParser = new JSONParser();
        try{
            FileReader fileReader = new FileReader("config.json");



            Object obj = jsonParser.parse(fileReader);

            JSONObject jsonObject = (JSONObject) obj;

            return jsonObject.get(typeFile.toString());

        }catch (IOException e){
            e.printStackTrace();
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }
}
