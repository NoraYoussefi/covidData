package fr.ubo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.event.EventListener;

import java.io.*;
import java.net.URL;


@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})
public class CovidDataApplication {
    private static final String url = "https://coronavirus.politologue.com/data/coronavirus/coronacsv.aspx?format=csv&t=pays ";

    @EventListener
    public static void main(String[] args) throws UnsupportedEncodingException {
        SpringApplication.run(CovidDataApplication.class, args);
        try (BufferedInputStream inputStream = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fileOS = new FileOutputStream("/home/dosi/scrum/covidDATA/data.csv")) {
            byte data[] = new byte[1024];
            int byteContent;
            while ((byteContent = inputStream.read(data, 0, 1024)) != -1) {
                fileOS.write(data, 0, byteContent);
            }
            System.out.println("data displayed");
        } catch (IOException e) {
            // handles IO exceptions
        }

        //testDAO
        //System.out.println(CovidDAO.readData());
      //  System.out.println(CovidService.showOneCountryData("France"));

      //  System.out.println(CovidService.showOneCountryDataCurrentDate("France"));
        //
        //System.out.println(CovidService.showOneCountryDataByDate("France","2022-12-12"));


      // System.out.println(CovidController.ListData());
    }

}
