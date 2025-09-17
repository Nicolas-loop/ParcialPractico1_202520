package co.edu.uniandes.dse.ParcialPractico1_202520.entities;

import jakarta.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;
import jakarta.persistence.Entity;



public class PlanetaEntity {
    private String nombre;

    private int poblacion;

    private long diametro;

    @PodamExclude
    @ManyToOne
    private SistemaSolarEntity sistemaSolar;

}
