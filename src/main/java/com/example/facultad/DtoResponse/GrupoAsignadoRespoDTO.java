package com.example.facultad.DtoResponse;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class GrupoAsignadoRespoDTO {
    private Long id;
    private BigDecimal horas_asignadas;
    // gestion
    private Long gestion_id;
    private Integer anio;
    private Date gestion_inicio;
    private Date gestion_fin;
    // periodo
    private Long periodo_id;
    private String nombre_periodo;
    private Date inicio_clase;
    private Date fin_clase;
    private Date evaluacion1;
    private Date evaluacion2;
    private Date evaluacion3;
    // materia grupo
    // materia
    private Long materia_id;
    private String materia_nombre;
    private String materia_sigla;
    // grupo
    private Long grupo_id;
    private String grupo_nombre;
    private String grupo_sigla;
    // usuario
    private Long usuario_id;
    private String usuario;
    private String usuario_nombre;
    private String usuario_apellidos;
    // materia
    private List<ListaCursosRespoDTO> cursoLista;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getHoras_asignadas() {
        return horas_asignadas;
    }

    public void setHoras_asignadas(BigDecimal horas_asignadas) {
        this.horas_asignadas = horas_asignadas;
    }

    public Long getGestion_id() {
        return gestion_id;
    }

    public void setGestion_id(Long gestion_id) {
        this.gestion_id = gestion_id;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Date getGestion_inicio() {
        return gestion_inicio;
    }

    public void setGestion_inicio(Date gestion_inicio) {
        this.gestion_inicio = gestion_inicio;
    }

    public Date getGestion_fin() {
        return gestion_fin;
    }

    public void setGestion_fin(Date gestion_fin) {
        this.gestion_fin = gestion_fin;
    }

    public Long getPeriodo_id() {
        return periodo_id;
    }

    public void setPeriodo_id(Long periodo_id) {
        this.periodo_id = periodo_id;
    }

    public String getNombre_periodo() {
        return nombre_periodo;
    }

    public void setNombre_periodo(String nombre_periodo) {
        this.nombre_periodo = nombre_periodo;
    }

    public Long getMateria_id() {
        return materia_id;
    }

    public void setMateria_id(Long materia_id) {
        this.materia_id = materia_id;
    }

    public String getMateria_nombre() {
        return materia_nombre;
    }

    public void setMateria_nombre(String materia_nombre) {
        this.materia_nombre = materia_nombre;
    }

    public String getMateria_sigla() {
        return materia_sigla;
    }

    public void setMateria_sigla(String materia_sigla) {
        this.materia_sigla = materia_sigla;
    }

    public Long getGrupo_id() {
        return grupo_id;
    }

    public void setGrupo_id(Long grupo_id) {
        this.grupo_id = grupo_id;
    }

    public String getGrupo_nombre() {
        return grupo_nombre;
    }

    public void setGrupo_nombre(String grupo_nombre) {
        this.grupo_nombre = grupo_nombre;
    }

    public String getGrupo_sigla() {
        return grupo_sigla;
    }

    public void setGrupo_sigla(String grupo_sigla) {
        this.grupo_sigla = grupo_sigla;
    }

    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario_nombre() {
        return usuario_nombre;
    }

    public void setUsuario_nombre(String usuario_nombre) {
        this.usuario_nombre = usuario_nombre;
    }

    public String getUsuario_apellidos() {
        return usuario_apellidos;
    }

    public void setUsuario_apellidos(String usuario_apellidos) {
        this.usuario_apellidos = usuario_apellidos;
    }

    public List<ListaCursosRespoDTO> getCursoLista() {
        return cursoLista;
    }

    public void setCursoLista(List<ListaCursosRespoDTO> cursoLista) {
        this.cursoLista = cursoLista;
    }

    public GrupoAsignadoRespoDTO() {
    }

    public Date getInicio_clase() {
        return inicio_clase;
    }

    public void setInicio_clase(Date inicio_clase) {
        this.inicio_clase = inicio_clase;
    }

    public Date getFin_clase() {
        return fin_clase;
    }

    public void setFin_clase(Date fin_clase) {
        this.fin_clase = fin_clase;
    }

    public Date getEvaluacion1() {
        return evaluacion1;
    }

    public void setEvaluacion1(Date evaluacion1) {
        this.evaluacion1 = evaluacion1;
    }

    public Date getEvaluacion2() {
        return evaluacion2;
    }

    public void setEvaluacion2(Date evaluacion2) {
        this.evaluacion2 = evaluacion2;
    }

    public Date getEvaluacion3() {
        return evaluacion3;
    }

    public void setEvaluacion3(Date evaluacion3) {
        this.evaluacion3 = evaluacion3;
    }

    public GrupoAsignadoRespoDTO(Long id, BigDecimal horas_asignadas, Long gestion_id, Integer anio,
            Date gestion_inicio,
            Date gestion_fin, Long periodo_id, String nombre_periodo, Date inicio_clase, Date fin_clase,
            Date evaluacion1, Date evaluacion2, Date evaluacion3, Long materia_id, String materia_nombre,
            String materia_sigla, Long grupo_id, String grupo_nombre, String grupo_sigla, Long usuario_id,
            String usuario, String usuario_nombre, String usuario_apellidos, List<ListaCursosRespoDTO> cursoLista) {
        this.id = id;
        this.horas_asignadas = horas_asignadas;
        this.gestion_id = gestion_id;
        this.anio = anio;
        this.gestion_inicio = gestion_inicio;
        this.gestion_fin = gestion_fin;
        this.periodo_id = periodo_id;
        this.nombre_periodo = nombre_periodo;
        this.inicio_clase = inicio_clase;
        this.fin_clase = fin_clase;
        this.evaluacion1 = evaluacion1;
        this.evaluacion2 = evaluacion2;
        this.evaluacion3 = evaluacion3;
        this.materia_id = materia_id;
        this.materia_nombre = materia_nombre;
        this.materia_sigla = materia_sigla;
        this.grupo_id = grupo_id;
        this.grupo_nombre = grupo_nombre;
        this.grupo_sigla = grupo_sigla;
        this.usuario_id = usuario_id;
        this.usuario = usuario;
        this.usuario_nombre = usuario_nombre;
        this.usuario_apellidos = usuario_apellidos;
        this.cursoLista = cursoLista;
    }

}
