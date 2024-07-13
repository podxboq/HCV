package org.podxboq.hcv.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Entity
@Table(name = "INGRESOS", indexes = {
	@Index(name = "INGRESOS_RESPONSABLE_INDEX", columnList = "RESPONSABLE_ID")
})
public class Ingreso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Long id;

	@NotNull
	@Column(name = "F_ALTA", nullable = false)
	private LocalDate fAlta;

	@Column(name = "F_BAJA")
	private LocalDate fBaja;

	@Column(name = "F_ANULA")
	private LocalDate fAnula;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@OnDelete(action = OnDeleteAction.RESTRICT)
	@JoinColumn(name = "ID_MASCOTA", nullable = false)
	private Mascota idMascota;

	@Size(max = 20)
	@NotNull
	@Column(name = "RESPONSABLE_ID", nullable = false, length = 20)
	private String responsableId;

	public Long getId() {
		return id;
	}

	public LocalDate getFAlta() {
		return fAlta;
	}

	public void setFAlta(LocalDate fAlta) {
		this.fAlta = fAlta;
	}

	public LocalDate getFBaja() {
		return fBaja;
	}

	public void setFBaja(LocalDate fBaja) {
		this.fBaja = fBaja;
	}

	public LocalDate getFAnula() {
		return fAnula;
	}

	public void setFAnula(LocalDate fAnula) {
		this.fAnula = fAnula;
	}

	public Mascota getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(Mascota idMascota) {

		this.idMascota = idMascota;
		this.responsableId = idMascota.getResponsableId();
	}

	public String getResponsableId() {
		return responsableId;
	}

}