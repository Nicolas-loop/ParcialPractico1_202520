package co.edu.uniandes.dse.ParcialPractico1_202520.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uniandes.dse.ParcialPractico1_202520.entities.SistemaSolarEntity;

@Repository
public interface SistemaSolarRepository extends JpaRepository<SistemaSolarEntity, Long> {   
    List<SistemaSolarEntity> findByNombre(String nombre);
    List<SistemaSolarEntity> findByRegion(String region);
    List<SistemaSolarEntity> findByRatioMinimo(Long ratioMinimo);
    List<SistemaSolarEntity> findByNumStromtroopers(int numStromtroopers);
}
