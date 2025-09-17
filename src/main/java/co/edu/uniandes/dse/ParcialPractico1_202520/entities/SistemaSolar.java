package co.edu.uniandes.dse.ParcialPractico1_202520.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

public class SistemaSolar extends BaseEntity {

    private String nombre;
    
    private String region;

    private long ratio_minimo;

    private int num_stromtroopers;

    @PodamExclude
    @OneToMany(mappedBy = "sistema", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlanetaEntity> planetas;

}
