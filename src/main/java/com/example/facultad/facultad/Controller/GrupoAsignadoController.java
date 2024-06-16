package com.example.facultad.facultad.Controller;

import java.math.BigDecimal;
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
            dto.setId(x.getId());
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
            dto.setUsuario_apellidos(x.getUsuario().getApellidos());
            dto.setHoras_asignadas(x.getHoras_asignadas());

            // encontrar los cursos;
            List<GrupoAula> grupoAulas = grupoAulaService.findByMateriaGrupoId(x.getMateriaGrupo().getId());
            // lista de cursos donde se guardaran, esta vacio
            List<ListaCursosRespoDTO> cursosTotal = new ArrayList<>();
            // BigDecimal totalHoras = BigDecimal.ZERO;
            for (GrupoAula y : grupoAulas) {
                ListaCursosRespoDTO cursoActual = new ListaCursosRespoDTO();
                cursoActual.setId(y.getId());
                cursoActual.setHora_fin(y.getHoraFin());
                cursoActual.setHora_inicio(y.getHoraInicio());
                cursoActual.setDuracionClase(y.getDuracionclase());

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
        // usuario
        Usuario usuario = usuarioService.findById(grupoAsignadoDTO.getUsuario_id());
        // gestio_periodo
        GestionPeriodo gestionPeriodo = gestionPeriodoService.findById(grupoAsignadoDTO.getGestionPeriodo_id());
        // materia_grupo
        MateriaGrupo materiaGrupo = materiaGrupoServicel.findById(grupoAsignadoDTO.getMateriaGrupo_id());
        // grupo_aula para sacar los horarios
        List<GrupoAula> grupoAula = grupoAulaService.findByMateriaGrupoId(grupoAsignadoDTO.getMateriaGrupo_id());

        GrupoAsignado nuevo = new GrupoAsignado();
        // calcular hora totales
        BigDecimal totalHoras = BigDecimal.ZERO;
        BigDecimal smenas = new BigDecimal(4);

        for (GrupoAula clase : grupoAula) {
            totalHoras = totalHoras.add(clase.getDuracionclase());
        }
        // calcular el total de horas por los dias trabajados
        nuevo.setHoras_asignadas(totalHoras.multiply(smenas));
        nuevo.setGestionPeriodo(gestionPeriodo);
        nuevo.setMateriaGrupo(materiaGrupo);
        nuevo.setUsuario(usuario);

        GrupoAsignado newCreado = grupoAsignadoService.save(nuevo);
        return ResponseEntity.ok(newCreado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GrupoAsignado> update(@PathVariable Long id, @RequestBody GrupoAsignadoDTO grupoAsignadoDTO) {
        GrupoAsignado editado = grupoAsignadoService.findById(id);
        Usuario usuario = usuarioService.findById(grupoAsignadoDTO.getUsuario_id());
        // gestio_periodo
        GestionPeriodo gestionPeriodo = gestionPeriodoService.findById(grupoAsignadoDTO.getGestionPeriodo_id());
        // materia_grupo
        MateriaGrupo materiaGrupo = materiaGrupoServicel.findById(grupoAsignadoDTO.getMateriaGrupo_id());
        // grupo_aula para sacar los horarios
        List<GrupoAula> grupoAula = grupoAulaService.findByMateriaGrupoId(grupoAsignadoDTO.getMateriaGrupo_id());
        // calcular hora totales
        BigDecimal totalHoras = BigDecimal.ZERO;
        BigDecimal smenas = new BigDecimal(4);

        for (GrupoAula clase : grupoAula) {
            totalHoras = totalHoras.add(clase.getDuracionclase());
        }
        // calcular el total de horas por los dias trabajados
        editado.setHoras_asignadas(totalHoras.multiply(smenas));
        editado.setGestionPeriodo(gestionPeriodo);
        editado.setMateriaGrupo(materiaGrupo);
        editado.setUsuario(usuario);

        grupoAsignadoService.save(editado);

        return ResponseEntity.ok(editado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        grupoAsignadoService.deleteById(id);
        return ResponseEntity.ok(null);
    }

}
