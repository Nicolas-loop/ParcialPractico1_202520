package co.edu.uniandes.dse.ParcialPractico1_202520.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.ParcialPractico1_202520.entities.PlanetaEntity;
import co.edu.uniandes.dse.ParcialPractico1_202520.entities.SistemaSolarEntity;
import co.edu.uniandes.dse.ParcialPractico1_202520.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.ParcialPractico1_202520.repositories.PlanetaRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PlanetaService {
    @Autowired
    private PlanetaRepository planetaRepository;

    @Autowired
    private SistemaSolarEntity sistemaSolarEntity;

    private static final String[] regionesValidas = {"CORE", "MID_RIM", "OUTER_RIM", "COLONIES", "WILD_SPACE"};

    @Transactional
    public PlanetaEntity createPlaneta(PlanetaEntity planetaEntity) throws IllegalOperationException{
        log.info("Inicia proceso de creación del planeta");

        //Verificar la longitud del nombre
        int longitud = planetaEntity.getNombre().length();
        String nombre = planetaEntity.getNombre();
        if (nombre.equals(nombre)){
            throw new IllegalOperationException("El nombre no puede terminas así");
        }

        if (planetaEntity.getPoblacion() < 0){
            throw new IllegalOperationException("La población no puede ser negativa");

        }

        log.info("Termina proceso de creación");
        return planetaRepository.save(planetaEntity);
    }   

}
