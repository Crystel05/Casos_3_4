package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class CSV {
    public String text = "";
    public char[] letters = null;

    public void addLetter(Character letter){
        this.text += letter;
    }

    public void setText(String texto){
        this.text = texto;
    }

    public void saveFile(){
        try{

            FileWriter file = new FileWriter("Prueba.csv");
            String lines[] = text.split("\n");
            for (int i = 0; i < lines.length; i++) {
                file.write(lines[i]+";\n");
            }
            file.flush();

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void readFile(String fileName){
        try{
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linea = "";
            String texto = "";
            while ((linea = bufferedReader.readLine()) != null){
                String arrreglo[] = linea.split(";");
                texto += arrreglo[0];
            }
            text = texto;
            this.letters = text.toCharArray();


        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
