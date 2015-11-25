package com.ufu.travel.ant;

import com.ufu.travel.grafo.Aresta;
import com.ufu.travel.grafo.Vertice;

public class Passo implements Cloneable {

	private Vertice vertice;
	private Aresta aresta;
	
	public Vertice getVertice() {
		return vertice;
	}
	public void setVertice(Vertice vertice) {
		this.vertice = vertice;
	}
	public Aresta getAresta() {
		return aresta;
	}
	public void setAresta(Aresta aresta) {
		this.aresta = aresta;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aresta == null) ? 0 : aresta.hashCode());
		result = prime * result + ((vertice == null) ? 0 : vertice.hashCode());
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
		Passo other = (Passo) obj;
		if (aresta == null) {
			if (other.aresta != null)
				return false;
		} else if (!aresta.equals(other.aresta))
			return false;
		if (vertice == null) {
			if (other.vertice != null)
				return false;
		} else if (!vertice.equals(other.vertice))
			return false;
		return true;
	}
	
	public Object clone() throws CloneNotSupportedException {
        return super.clone();
	}
	
}
