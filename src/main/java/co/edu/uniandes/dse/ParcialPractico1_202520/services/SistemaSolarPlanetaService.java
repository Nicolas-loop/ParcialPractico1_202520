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
    private PlanetaRepository planetaRepository;

    private static final String[] regionesValidas = {"CORE", "MID_RIM", "OUTER_RIM", "COLONIES", "WILD_SPACE"};

    @Transactional
    public addPlaneta createSistemaSolar(String nombreSistema, String nombrePlaneta) throws IllegalOperationException{

        PlanetaEntity imagen = PlanetaEntity.get();
        SistemaSolarEntity servicio = sistemaSolarEntity.get();
        
        //Validar que la imagen no esté ya asociada a otro servicio
        if (imagen.getServicio() != null && !imagen.getServicio().getId().equals(servicioId)) {
            throw new IllegalOperationException("La imagen ya está asociada a otro servicio");
        }
        
        //Validar que el servicio no tenga demasiadas imágenes
        if (servicio.getImagenes() != null && servicio.getImagenes().size() >= 10) {
            throw new IllegalOperationException("El servicio ya tiene el máximo de 10 imágenes permitidas");
        }
        
        //Validar que la URL de la imagen sea válida
        if (imagen.getUrl() == null || imagen.getUrl().trim().isEmpty()) {
            throw new IllegalOperationException("La imagen debe tener una URL válida");
        }
        
        //Asociar la imagen al servicio
        imagen.setServicio(servicio);
        if (!servicio.getImagenes().contains(imagen)) {
            servicio.getImagenes().add(imagen);
        }
        
        log.info("Termina proceso de asociar la imagen con id = {} al servicio con id = {}", imagenId, servicioId);
        return imagen;
    }   

}

