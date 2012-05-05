/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.fileservice.reader;

import java.util.List;
import java.util.Map;

/**
 *
 * @author nsorenson
 */
public interface Reader {
    public abstract List<Map<String,String>> getAllRecords ();
}
