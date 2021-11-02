package Model;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

//import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonConfig {
    private JSONObject textConfig = new JSONObject();

    private JSONArray txtFile = new JSONArray();
    private JSONArray csvFile = new JSONArray();
    private JSONArray jsonFile = new JSONArray();
    private JSONArray xmlFile = new JSONArray();


    public void saveLetters(PosColor posColor, FileType typeFile){
        JSONObject jsonPosColor = new JSONObject();
        jsonPosColor.put("ini", posColor.getPosInicial());
        jsonPosColor.put("fin", posColor.getPosFinal());
        jsonPosColor.put("color", posColor.getColor().toString());
        switch (typeFile){
            case TXT:
                this.txtFile.add(jsonPosColor);
                break;
            case CSV:
                this.csvFile.add(jsonPosColor);
                break;
            case XML:
                this.xmlFile.add(jsonPosColor);
                break;
            case JSON:
                this.jsonFile.add(jsonPosColor);
                break;
        }
//        JSONObject txtFile = new JSONObject();
//        this.txtFile.put(indexLetter, color);


    }

    public void saveConfig(FileType typeFile){
        try{
            if(!this.txtFile.isEmpty() && FileType.TXT == typeFile) {
                this.textConfig.put(typeFile, this.txtFile);
            }
            if(!this.csvFile.isEmpty() && FileType.CSV == typeFile) {
                this.textConfig.put(typeFile, this.csvFile);
            }
            if(!this.xmlFile.isEmpty() && FileType.XML == typeFile) {
                this.textConfig.put(typeFile, this.xmlFile);
            }
            if(!this.jsonFile.isEmpty() && FileType.JSON == typeFile) {
                this.textConfig.put(typeFile, this.jsonFile);
            }

            FileWriter file = new FileWriter("config.json");
            file.write(this.textConfig.toJSONString());
            file.flush();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public ArrayList<PosColor> readConfig(FileType typeFile){
        JSONParser jsonParser = new JSONParser();
        try{
            ArrayList<PosColor> listPosColors = new ArrayList<>();
            FileReader fileReader = new FileReader("config.json");
            Object obj = jsonParser.parse(fileReader);
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray filePosColor = (JSONArray) jsonObject.get(typeFile.toString());

            for (Object object: filePosColor) {
                JSONObject posObject = (JSONObject) object;
                Color color = Color.valueOf(posObject.get("color").toString());
                PosColor posColor = new PosColor(color, Integer.parseInt(posObject.get("ini").toString()), Integer.parseInt(posObject.get("ini").toString()));
                listPosColors.add(posColor);
            }
            return listPosColors;

        }catch (IOException e){
            e.printStackTrace();
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }

}
