package fr.ubo.dao;

import fr.ubo.beans.CovidData;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CovidDAO {

    /**
     *
     * @return returns the csv file's data in an array
     */
    public static List readData() {
        List allData = new ArrayList<CovidData>();
        try (BufferedReader br = new BufferedReader(new FileReader("data.csv"))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                i++;
                if (i >= 9) {
                    String[] values = line.split(";");
                    //System.out.println(values);
                    CovidData data = createData(values);
                    allData.add(data);
                }
            }


        }


     catch (IOException e) {
            throw new RuntimeException(e);
        }
        return allData;
    }

    /**
     * this function combine between csv file columns and the beans attributs
     * @param metadata
     * @return
     */
    private static CovidData createData(String[] metadata)
    {


         String Date = metadata[0];
         String Pays= metadata[1];
         int Infections = Integer.parseInt(metadata[2]);
         int Deces= Integer.parseInt(metadata[3]);
         int Guerisons= Integer.parseInt(metadata[4]);
         float TauxDeces = Float.parseFloat(metadata[5]);
         float TauxInfection = Float.parseFloat(metadata[6]);



        return new CovidData( Date, Pays,Infections, Deces,Guerisons, TauxDeces, TauxInfection);


    }


}
