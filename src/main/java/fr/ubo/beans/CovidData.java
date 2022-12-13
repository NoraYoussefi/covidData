package fr.ubo.beans;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Id;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
public class CovidData {


    @NotBlank
    @Size(max = 50)
    @JsonFormat(pattern="yyyy-MM-dd")
    private String Date;
    @NotBlank
    @Size(max = 50)
    private String Pays;
    private int Infections;
    private int Deces;
    private int Guerisons;
    private float TauxDeces;
    private float TauxInfection;

    public CovidData(String date, String pays, int infections, int deces, int guerisons, float tauxDeces, float tauxInfection) {
        Date = date;
        Pays = pays;
        Infections = infections;
        Deces = deces;
        Guerisons = guerisons;
        TauxDeces = tauxDeces;
        TauxInfection = tauxInfection;
    }
}
