package com.ufu.travel.grafo;

import java.util.ArrayList;

public class Vertice implements Cloneable {

	private VerticeTO dados;
	private ArrayList<Aresta> listaIncidencia;

	public ArrayList<Aresta> getListaIncidencia() {
		if (listaIncidencia == null) {
			this.listaIncidencia = new ArrayList<Aresta>();
		}
		return listaIncidencia;
	}

	public void setListaIncidencia(ArrayList<Aresta> listaIncidencia) {
		this.listaIncidencia = listaIncidencia;
	}

	public Vertice(VerticeTO d) {
		this.dados = d;
	}

	public VerticeTO getDados() {
		return this.dados;
	}

	public void setDados(VerticeTO d) {
		this.dados = d;
	}

	public String toString() {
		return this.dados.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dados == null) ? 0 : dados.hashCode());
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
		Vertice other = (Vertice) obj;
		if (dados == null) {
			if (other.dados != null)
				return false;
		} else if (!dados.equals(other.dados))
			return false;
		return true;
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
