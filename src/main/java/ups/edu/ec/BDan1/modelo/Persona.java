package ups.edu.ec.BDan1.modelo;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Persona {
	@Id
	@Column(name="per_id")
	private String id;
	
	@Column(name="per_cedula")
	private String cedula;
	
	@Column(name="per_nombre")
	private String nombre;
	
	@Column(name="per_altura")
	private double altura;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", altura=" + altura + "]";
	}
}
