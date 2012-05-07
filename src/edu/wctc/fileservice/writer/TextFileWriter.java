package edu.wctc.fileservice.writer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Map;

/**
 * This class will write on disk, given a list of String, String maps and a
 * file path in String format.
 */
public class TextFileWriter implements Writer{
    private String filePath;
    private Formatter f;
    
    public TextFileWriter(){}

    public TextFileWriter(String filePath, Formatter f) {
        this.filePath = filePath;
        this.f = f;
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
    
    public void writeAllRecords(List<Map<String,String>> dataToPrint, 
            String writePath)throws IOException{
        List<Map<String,String>> passedData = 
                new ArrayList<Map<String,String>>();
//        f.encodeAll(passedData,writePath);
    }
    
}
