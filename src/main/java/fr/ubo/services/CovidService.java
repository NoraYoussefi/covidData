package fr.ubo.services;

import fr.ubo.beans.CovidData;
import fr.ubo.dao.CovidDAO;
import org.springframework.javapoet.ClassName;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;


@Service
public class CovidService {
    private static final Logger logger = Logger.getLogger( ClassName.class.getName() );

    /**
     *
     * @param pays
     * @return
     */
    public static List<CovidData> showOneCountryData(String pays) {
        List<CovidData> data = new ArrayList<CovidData>();
        List<CovidData> result = new ArrayList<CovidData>();
        data = CovidDAO.readData();
        for (CovidData d : data) {
            if (d.getPays().equals(pays))
                result.add(d);

        }
        if(pays=="" || result == null || result.isEmpty())
            logger.info("pays vide ou inexistant");
        if (result != null && !result.isEmpty())
            logger.info("result found");
        return result;
    }

    /**
     *
     * @param pays
     * @param date
     * @return
     */
    public static List<CovidData> showOneCountryDataByDate(String pays, String date) {
        List<CovidData> resultDate = null;
        if (isValidDate(date)) {

            List<CovidData> dataDate = showOneCountryData(pays);
            resultDate = new ArrayList<CovidData>();
            List<CovidData> resultDateP = new ArrayList<CovidData>();
            SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");

            try {
                Date dateF = DateFor.parse(date);
                Calendar cal = Calendar.getInstance();
                cal.setTime(dateF); // convert your date to Calendar object
                int daysToDecrement = -1;
                cal.add(Calendar.DATE, daysToDecrement);
                dateF = cal.getTime(); // again get back your date object
                String datePrev = DateFor.format(dateF);

                for (CovidData d : dataDate) {
                    if (d.getDate().equals(datePrev)) {
                        resultDateP.add(d);
                    }
                    if (d.getDate().equals(date)) {

                        resultDate.add(d);
                    }
                }


                resultDate.get(0).setInfections(resultDate.get(0).getInfections() - resultDateP.get(0).getInfections());
                return resultDate;
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } else {
            logger.info("date invalid");
            return resultDate;
        }
    }

    /**
     *
     * @param pays
     * @return
     */
    public static List<CovidData> showOneCountryDataCurrentDate(String pays) {
        List<CovidData> dataDate = showOneCountryData(pays);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        String date = dtf.format(localDate);
        List<CovidData> resultDate = new ArrayList<CovidData>();
        List<CovidData> resultDateP = new ArrayList<CovidData>();
        SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dateF = DateFor.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(dateF); // convert your date to Calendar object
            int daysToDecrement = -1;
            cal.add(Calendar.DATE, daysToDecrement);
            dateF = cal.getTime(); // again get back your date object
            String datePrev = DateFor.format(dateF);
            for (CovidData d : dataDate) {
                if (d.getDate().equals(datePrev)) {
                    resultDateP.add(d);
                }
                if (d.getDate().equals(date)) {

                    resultDate.add(d);
                }


            }
            resultDate.get(0).setInfections(resultDate.get(0).getInfections() - resultDateP.get(0).getInfections());
            return resultDate;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * validate the format of a date
     * @param inDate
     * @return
     */
    public static boolean isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }
}
