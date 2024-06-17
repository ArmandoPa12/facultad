package com.example.facultad.facultad.Controller;

import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.facultad.facultad.Dto.RegistroDTO;
import com.example.facultad.facultad.Entity.GrupoAsignado;
import com.example.facultad.facultad.Entity.Registro;
import com.example.facultad.facultad.Entity.ResPersonalizada;
import com.example.facultad.facultad.Entity.Usuario;
import com.example.facultad.facultad.Service.GrupoAsignadoService;
import com.example.facultad.facultad.Service.RegistroService;
import com.example.facultad.facultad.Service.UsuarioService;

@CrossOrigin
@RestController
@RequestMapping("api/registro")
public class RegistroController {
    @Autowired
    RegistroService registroService;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    GrupoAsignadoService grupoAsignadoService;
    @Autowired
    private EntityManager entityManager;

    @GetMapping
    public ResponseEntity<List<Registro>> get() {
        List<Registro> lista = registroService.findAll();
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<Registro> create(@RequestBody RegistroDTO registroDTO) {
        LocalDate fechaActual = LocalDate.now();
        LocalTime horaPrueba = LocalTime.of(9, 15, 25);

        // Obtener el día de la semana
        DayOfWeek diaSemana = fechaActual.getDayOfWeek();

        // Obtener el nombre del día en español
        String nombreDia = diaSemana.getDisplayName(TextStyle.FULL, new Locale("es",
                "ES"));

        System.out.println("Hoy es " + nombreDia);

        Usuario usuario = usuarioService.findById(registroDTO.getUsuario_id());
        LocalDateTime now = LocalDateTime.now();

        LocalTime tiempo = now.toLocalTime();
        LocalTime horaActual = tiempo.truncatedTo(ChronoUnit.SECONDS);
        Date fecha = java.sql.Date.valueOf(now.toLocalDate());

        String sql = "SELECT ga.id, gra.hora_inicio,gra.hora_fin FROM grupo_asignado ga " +
                "JOIN materia_grupo mg ON ga.materia_grupo_id = mg.id " +
                "JOIN grupo_aula gra ON mg.id = gra.materia_grupo_id " +
                "JOIN dia d ON gra.dia_id = d.id " +
                "WHERE d.nombre = :diaNombre " +
                "AND ga.usuario_id = :usuarioId " +
                "AND :hora BETWEEN gra.hora_inicio AND gra.hora_fin";

        Query query = entityManager.createNativeQuery(sql, ResPersonalizada.class);
        query.setParameter("diaNombre", "jueves");
        // query.setParameter("diaNombre", nombreDia);

        query.setParameter("usuarioId", registroDTO.getUsuario_id());
        query.setParameter("hora", horaPrueba);
        // query.setParameter("hora", horaActual);

        List<ResPersonalizada> resultado = query.getResultList();

        Registro nuevo = new Registro();
        nuevo.setUsuario(usuario);
        nuevo.setTiempo(horaActual);
        nuevo.setFecha(fecha);
        nuevo.setLugar(registroDTO.getLugar());
        nuevo.setTipo_check("IN");
        if (resultado.isEmpty()) {
            nuevo.setGrupoasignado(null);
        } else {
            ResPersonalizada resPersonalizada = resultado.get(0);
            Long grupoAsignadoId = resPersonalizada.getId();
            GrupoAsignado grupoAsignado = grupoAsignadoService.findById(grupoAsignadoId);
            nuevo.setGrupoasignado(grupoAsignado);
        }
        Registro guardado = registroService.save(nuevo);
        return ResponseEntity.ok(guardado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Registro>> show(@PathVariable Long id) {
        List<Registro> lista = registroService.findAllByUsuarioId(id);
        return ResponseEntity.ok(lista);
    }
}
