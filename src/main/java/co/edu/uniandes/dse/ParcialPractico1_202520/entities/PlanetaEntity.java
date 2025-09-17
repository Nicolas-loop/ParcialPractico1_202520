package co.edu.uniandes.dse.ParcialPractico1_202520.entities;

import jakarta.persistence.ManyToOne;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;
import jakarta.persistence.Entity;


@Data
@Entity
public class PlanetaEntity extends BaseEntity{
    private String nombre;

    private int poblacion;

    private long diametro;

    @PodamExclude
    @ManyToOne
    private SistemaSolarEntity sistemaSolar;

}
