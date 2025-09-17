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
import co.edu.uniandes.dse.ParcialPractico1_202520.repositories.SistemaSolarRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SistemaSolarService {
    @Autowired
    private SistemaSolarRepository sistemaSolarRepository;

    @Autowired
    private SistemaSolarEntity sistemaSolarEntity;

    private static final String[] regionesValidas = {"CORE", "MID_RIM", "OUTER_RIM", "COLONIES", "WILD_SPACE"};

    @Transactional
    public SistemaSolarEntity createSistemaSolar(SistemaSolarEntity sistemaSolarEntity) throws IllegalOperationException{
        log.info("Inicia proceso de creación del planeta");

        //Verificar la longitud del nombre
        if (sistemaSolarEntity.getNombre().length() > 31){
            throw new IllegalOperationException("El nombre no puede ser tan largo");
        }

        if (sistemaSolarEntity.getRatioMinimo() >= 0.6 || sistemaSolarEntity.getRatioMinimo() <= 0.2){
            throw new IllegalOperationException("El ratio no puede tomar esos valores");
        }

        if (sistemaSolarEntity.getNumStromtroopers() < 1000){
            throw new IllegalOperationException("Son muy poco Stromtroopers");
        }

        if (sistemaSolarEntity.getNombre() != "CORE" && sistemaSolarEntity.getNombre() != "MID_RIM" && sistemaSolarEntity.getNombre() != "OUTER_RIM" && sistemaSolarEntity.getNombre() != "COLONIES" && sistemaSolarEntity.getNombre() != "WILD_SPACE"){
            throw new IllegalOperationException("La region es invalida");
        }

        log.info("Termina proceso de creación");
        return sistemaSolarRepository.save(sistemaSolarEntity);
    }   

}

