package co.edu.uniandes.dse.ParcialPractico1_202520.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.OneToMany;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

@Data
@Entity
public class SistemaSolarEntity extends BaseEntity {

    private String nombre;
    
    private String region;

    private long ratioMinimo;

    private int numStromtroopers;

    @PodamExclude
    @OneToMany(mappedBy = "sistema", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlanetaEntity> planetas = new ArrayList<>();

}
