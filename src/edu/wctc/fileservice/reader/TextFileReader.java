
package edu.wctc.fileservice.reader;

import edu.wctc.fileservice.format.MyGarageFormat;
import edu.wctc.fileservice.format.Formatter;
import java.io.*;
import java.util.*;

public class TextFileReader implements Reader{
    private String filePath;
    private Formatter f;
    
    public TextFileReader(){}

    public TextFileReader(String filePath, Formatter f) {
        this.filePath = filePath;
        this.f = f;
    }
    
    public List<Map<String,String>> getAllRecords (){
        List<Map<String,String>> data = new ArrayList<Map<String,String>>();
        File file = new File(filePath);
        BufferedReader in = null;
        String formattedData = "";
        
        try{
            in = new BufferedReader(new FileReader(file));
            String line = in.readLine();
            while (line != null){
                formattedData += (line + "\n");
                line = in.readLine();
            }
        }
        catch(IOException ioe){
            System.out.println("Problem finding data.");
        }
        finally{
            try {in.close();}
            catch (Exception e){}
            }
        
        data = f.decode(formattedData);
        return data;
    }

    public Formatter getF() {
        return f;
    }

    public void setF(Formatter f) {
        this.f = f;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    public static void main(String[] args) throws IOException {
        Formatter garage = new MyGarageFormat();
        TextFileReader text = new TextFileReader();
        text.setFilePath("/garagedata.txt");
        text.setF(garage);
        List<Map<String,String>> dataFromDisk = text.getAllRecords();
        System.out.println("Data read");
        garage.encodeAll(dataFromDisk, "src/data.out");
        System.out.println("Data written");
    }
}
