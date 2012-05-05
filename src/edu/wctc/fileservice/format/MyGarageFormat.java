package edu.wctc.fileservice.format;

import java.io.BufferedWriter;
import java.io.*;
import java.util.*;

/**
 * This format will accept a list of hours parked only.  Garage program will 
 * calculate the fee.
 */
public class MyGarageFormat implements Formatter{
    
    //takes formatted data from the Reader and puts it into a uniform HashMap
    public List<Map<String,String>> decode(String formattedData){
        List<Map<String,String>> decodedData = 
                new ArrayList<Map<String,String>>();
        
        String [] dataPieces = formattedData.split("\n");
        
        for (int i = 0;i<dataPieces.length;i++){
            Map record = new HashMap();
            record.put("totalHours",dataPieces[i]);
            record.put("totalFees",0);
            decodedData.add(record);
        }
               
        return decodedData;
    }
    
    /**
     * takes the map and encodes it back into MyGarageFormat style on a given
     * file path.
    **/
    
    public void encodeAll(List<Map<String,String>> dataToPrint, 
            String writePath) throws IOException{
        boolean append = false;
        File data = new File(writePath);
        PrintWriter out = new PrintWriter(
                new BufferedWriter(
                new FileWriter(data,append)));
        for (int i = 0;i<dataToPrint.size();i++){
            String s = dataToPrint.get(i).get("totalHours");
            out.print(s + "\n");
        }
        out.close();
    }
    
    public static void main(String[] args) throws IOException{
        MyGarageFormat garage = new MyGarageFormat();
        String fakeData = "12.00\n3.00";
        List<Map<String,String>> data = garage.decode(fakeData);
        garage.encodeAll(data,"src/data.out");
        System.out.println("done");
    }
}
    
