package Model;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.sound.midi.Soundbank;
import javax.swing.text.AbstractDocument;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class XML {
    public String text = "";
    public char[] letters = null;

    public void addLetter(Character letter){
        this.text += letter;
    }

    public void setText(String texto){
        this.text = texto;
    }

    public String getText(){
        return this.text;
    }


    public void saveFile(String path){
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();

            Document document = implementation.createDocument(null, "contenido", null);
            document.setXmlVersion("1.0");

            Element text = document.createElement("texto");
            Text texto = document.createTextNode( this.text);
            text.appendChild(texto);

            document.getDocumentElement().appendChild(text);

            Source source = new DOMSource(document);
            Result result = new StreamResult(new File(path));

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);



        }catch (ParserConfigurationException | TransformerConfigurationException e){
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public void readFile(String fileName){
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File(fileName));

            NodeList listaEtiquetasTexto = document.getElementsByTagName("texto");

            // Obtiene la etiqueta texto y despues su hijo que es el contenido.
            this.text = listaEtiquetasTexto.item(0).getChildNodes().item(0).getNodeValue();
            this.letters = text.toCharArray();

        }catch (ParserConfigurationException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

}
