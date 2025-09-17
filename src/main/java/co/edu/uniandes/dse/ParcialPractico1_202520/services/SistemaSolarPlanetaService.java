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
public class SistemaSolarPlanetaService {
    @Autowired
    private SistemaSolarRepository sistemaSolarRepository;

    @Autowired
    private PlanetaRepository planetaRepository;


    @Transactional
    public SistemaSolarEntity addPlaneta(long sistemaSolarId, long planetaId) throws IllegalOperationException{

        Optional<SistemaSolarEntity> sistemaSolarEntity = sistemaSolarRepository.findById(sistemaSolarId);
        Optional<PlanetaEntity> planetaEntity = planetaRepository.finById(planetaId);

        PlanetaEntity planeta = planetaEntity.get();
        SistemaSolarEntity sistemaSolar = sistemaSolarEntity.get();

        planeta.setSistemaSolar(sistemaSolar);
        if (!sistemaSolar.getPlanetas().contains(planeta)) {
            sistemaSolar.getPlanetas().add(planeta);
        }
        return sistemaSolar;
    }   

}

