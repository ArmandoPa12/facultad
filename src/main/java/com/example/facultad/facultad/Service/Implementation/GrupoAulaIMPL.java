package com.example.facultad.facultad.Service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.facultad.facultad.Entity.GrupoAula;
import com.example.facultad.facultad.Repository.GrupoAulaRepository;
import com.example.facultad.facultad.Service.GrupoAulaService;

@Service
public class GrupoAulaIMPL implements GrupoAulaService {
    @Autowired
    GrupoAulaRepository grupoAulaRepository;

    @Override
    public List<GrupoAula> findAll() {
        return grupoAulaRepository.findAll();
    }

    @Override
    public GrupoAula findById(Long id) {
        return grupoAulaRepository.findById(id).orElseThrow();
    }

    @Override
    public GrupoAula save(GrupoAula grupoAula) {

        // System.err.println(grupoAula.toString());
        // return grupoAula;
        return grupoAulaRepository.save(grupoAula);
    }

    public boolean verificarConflictoHorario(GrupoAula grupoAula) {

        List<GrupoAula> horariosExistentes = grupoAulaRepository.findByAulaIdAndDiaId(grupoAula.getAula().getId(),
                grupoAula.getDia().getId());

        for (GrupoAula horario : horariosExistentes) {
            if (horario.getId().equals(grupoAula.getId())) {
                continue;
            }
            if ((grupoAula.getHoraInicio().isBefore(horario.getHoraFin())
                    && grupoAula.getHoraFin().isAfter(horario.getHoraInicio())) ||
                    (grupoAula.getHoraInicio().equals(horario.getHoraInicio())
                            || grupoAula.getHoraFin().equals(horario.getHoraFin()))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void deleteById(Long id) {
        grupoAulaRepository.deleteById(id);
    }

    @Override
    public List<GrupoAula> findByMateriaGrupoId(Long aula_id) {
        return grupoAulaRepository.findByMateriaGrupoId(aula_id);
    }
}
