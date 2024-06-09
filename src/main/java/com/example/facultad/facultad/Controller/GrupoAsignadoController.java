package com.example.facultad.facultad.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.facultad.DtoResponse.GrupoAsignadoRespoDTO;
import com.example.facultad.DtoResponse.ListaCursosRespoDTO;
import com.example.facultad.facultad.Dto.GrupoAsignadoDTO;
import com.example.facultad.facultad.Entity.*;
import com.example.facultad.facultad.Service.*;

@CrossOrigin
@RestController
@RequestMapping("api/grupo-asignado")
public class GrupoAsignadoController {

    @Autowired
    GrupoAsignadoService grupoAsignadoService;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    GestionPeriodoService gestionPeriodoService;
    @Autowired
    MateriaGrupoService materiaGrupoServicel;
    @Autowired
    GrupoAulaService grupoAulaService;

    @GetMapping
    public ResponseEntity<List<GrupoAsignadoRespoDTO>> getGestionPeriodo() {

        List<GrupoAsignado> grupos = grupoAsignadoService.findAll();
        List<GrupoAsignadoRespoDTO> asingados = new ArrayList<>();
        for (GrupoAsignado x : grupos) {
            GrupoAsignadoRespoDTO dto = new GrupoAsignadoRespoDTO();
            // gestion
            dto.setGestion_id(x.getGestionPeriodo().getGestion().getId());
            dto.setAnio(x.getGestionPeriodo().getGestion().getAnio());
            dto.setGestion_inicio(x.getGestionPeriodo().getGestion().getFechaIni());
            dto.setGestion_fin(x.getGestionPeriodo().getGestion().getFechaFin());
            // periodo
            dto.setPeriodo_id(x.getGestionPeriodo().getId());
            dto.setNombre_periodo(x.getGestionPeriodo().getPeriodo().getNombre());
            dto.setInicio_clase(x.getGestionPeriodo().getInicio_clase());
            dto.setFin_clase(x.getGestionPeriodo().getFin_clase());
            dto.setEvaluacion1(x.getGestionPeriodo().getEvaluacion1());
            dto.setEvaluacion2(x.getGestionPeriodo().getEvaluacion2());
            dto.setEvaluacion3(x.getGestionPeriodo().getEvaluacion3());
            // materia
            dto.setMateria_id(x.getMateriaGrupo().getMateria().getId());
            dto.setMateria_nombre(x.getMateriaGrupo().getMateria().getNombre());
            dto.setMateria_sigla(x.getMateriaGrupo().getMateria().getSigla());
            // grupo
            dto.setGrupo_id(x.getMateriaGrupo().getGrupo().getId());
            dto.setGrupo_nombre(x.getMateriaGrupo().getGrupo().getNombre());
            dto.setGrupo_sigla(x.getMateriaGrupo().getGrupo().getSigla());
            // usuario
            dto.setUsuario_id(x.getUsuario().getId());
            dto.setUsuario(x.getUsuario().getUsuario());
            dto.setUsuario_nombre(x.getUsuario().getNombre());
            ;
            dto.setUsuario_apellidos(x.getUsuario().getApellidos());

            // encontrar los cursos;
            List<GrupoAula> grupoAulas = grupoAulaService.findByMateriaGrupoId(x.getMateriaGrupo().getId());
            // lista de cursos donde se guardaran, esta vacio
            List<ListaCursosRespoDTO> cursosTotal = new ArrayList<>();
            for (GrupoAula y : grupoAulas) {
                ListaCursosRespoDTO cursoActual = new ListaCursosRespoDTO();
                cursoActual.setId(y.getId());
                cursoActual.setHora_fin(y.getHoraFin());
                cursoActual.setHora_inicio(y.getHoraInicio());

                cursoActual.setAula_id(y.getAula().getId());
                cursoActual.setAula_nombre(y.getAula().getNombre());
                cursoActual.setAula_piso(y.getAula().getPiso());

                cursoActual.setDia_id(y.getDia().getId());
                cursoActual.setDia_nombre(y.getDia().getNombre());
                cursosTotal.add(cursoActual);
            }

            dto.setCursoLista(cursosTotal);
            asingados.add(dto);
        }

        return ResponseEntity.ok(asingados);
    }

    @PostMapping
    public ResponseEntity<GrupoAsignado> createGestionPeriodo(@RequestBody GrupoAsignadoDTO grupoAsignadoDTO) {
        Usuario usuario = usuarioService.findById(grupoAsignadoDTO.getUsuario_id());
        GestionPeriodo gestionPeriodo = gestionPeriodoService.findById(grupoAsignadoDTO.getGestionPeriodo_id());
        MateriaGrupo materiaGrupo = materiaGrupoServicel.findById(grupoAsignadoDTO.getMateriaGrupo_id());

        GrupoAsignado nuevo = new GrupoAsignado();
        nuevo.setGestionPeriodo(gestionPeriodo);
        nuevo.setMateriaGrupo(materiaGrupo);
        nuevo.setUsuario(usuario);

        nuevo.setHoras_asignadas(grupoAsignadoDTO.getHoras_asignadas());

        // Gestion gestion = gestionService.findById(gestionPeriodoDTO.getGestion_id());
        // Periodo periodo = periodoService.findById(gestionPeriodoDTO.getPeriodo_id());

        // GestionPeriodo nuevo = new GrupoAsignado();
        // nuevo.setEvaluacion1(gestionPeriodoDTO.getEvaluacion1());
        // nuevo.setEvaluacion2(gestionPeriodoDTO.getEvaluacion2());
        // nuevo.setEvaluacion3(gestionPeriodoDTO.getEvaluacion3());
        // nuevo.setFin_clase(gestionPeriodoDTO.getFin_clase());
        // nuevo.setGestion(gestion);
        // nuevo.setPeriodo(periodo);
        // nuevo.setInicio_clase(gestionPeriodoDTO.getInicio_clase());

        GrupoAsignado newPeriodo = grupoAsignadoService.save(nuevo);
        return ResponseEntity.ok(newPeriodo);
    }

}
