/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.fileservice.format;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nsorenson
 */
public interface Formatter {
    public abstract List<Map<String,String>> decode(String formattedData);
    public abstract void encodeAll(List<Map<String,String>> dataToPrint, 
            String writePath)throws IOException;
}
