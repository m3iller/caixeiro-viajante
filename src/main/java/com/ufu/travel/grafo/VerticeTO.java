package com.ufu.travel.grafo;


public class VerticeTO {

	private Integer id;
	private String nome;
	private Double pos;
	private Double x;
	private Double y;
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPos() {
		return pos;
	}
	public void setPos(Double pos) {
		this.pos = pos;
	}
	public Double getX() {
		return x;
	}
	public void setX(Double x) {
		this.x = x;
	}
	public Double getY() {
		return y;
	}
	public void setY(Double y) {
		this.y = y;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VerticeTO other = (VerticeTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return this.getNome();
	}
	
}
