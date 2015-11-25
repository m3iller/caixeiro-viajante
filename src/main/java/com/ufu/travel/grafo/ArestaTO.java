package com.ufu.travel.grafo;

public class ArestaTO implements Cloneable{

	private Integer id;
	private Double distancia;
	private Double feronomio;
	private Boolean formigaPassou = false;
	
	public Boolean getFormigaPassou() {
		return formigaPassou;
	}
	public void setFormigaPassou(Boolean formigaPassou) {
		this.formigaPassou = formigaPassou;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getDistancia() {
		return distancia;
	}
	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}
	public Double getFeronomio() {
		return feronomio;
	}
	public void setFeronomio(Double feronomio) {
		this.feronomio = feronomio;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.getDistancia().intValue());
	}
	
	public Object clone() throws CloneNotSupportedException {
        return super.clone();
	}
	
}
