package org.podxboq.hcv.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "MASCOTAS", indexes = {
	@Index(name = "MASCOTAS_RESPONSABLE_INDEX", columnList = "RESPONSABLE_ID")
})
public class Mascota {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Long id;

	@Size(max = 100)
	@NotNull
	@Column(name = "ESPECIE", nullable = false, length = 100)
	private String especie;

	@Size(max = 100)
	@Column(name = "RAZA", length = 100)
	private String raza;

	@Column(name = "EDAD")
	private Integer edad;

	@Size(max = 10)
	@Column(name = "CODIGO", length = 10)
	private String codigo;

	@Size(max = 20)
	@NotNull
	@Column(name = "RESPONSABLE_ID", nullable = false, length = 20)
	private String responsableId;

	@Column(name = "F_BAJA")
	private LocalDate fBaja;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getResponsableId() {
		return responsableId;
	}

	public void setResponsableId(String responsableId) {
		this.responsableId = responsableId;
	}

	public LocalDate getFBaja() {
		return fBaja;
	}

	public void setFBaja(LocalDate fBaja) {
		this.fBaja = fBaja;
	}
}