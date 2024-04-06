package com.project.sbws.backend.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {
    
    public static List<String> readCommaSeparatedValuesAndStoreInAList(String csvFile) {
        ArrayList<String> teamList = new ArrayList<String>();
        String path = csvFile; 
        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                // Use comma as separator
                String[] values = line.split(",");
                // Process each value as needed
                System.out.println("Column 1= " + values[0]);
                teamList.add(values[0]);
                return teamList;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
