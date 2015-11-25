package com.ufu.travel.grafo;

public class Aresta  implements Cloneable {
	
	private ArestaTO dados;
	private Vertice v1, v2;

	public Aresta(ArestaTO dados, Vertice v1, Vertice v2) {
		this.dados = dados;
		this.v1 = v1;
		this.v2 = v2;
	}

	public ArestaTO getDados() {
		return dados;
	}

	public void setDados(ArestaTO dados) {
		this.dados = dados;
	}

	public Vertice getV1() {
		return v1;
	}

	public void setV1(Vertice v1) {
		this.v1 = v1;
	}

	public Vertice getV2() {
		return v2;
	}

	public void setV2(Vertice v2) {
		this.v2 = v2;
	}

	public String toString() {
		return "[" + v1 + ", " + v2 + "]";
	}
	
	public Object clone() throws CloneNotSupportedException {
	        return super.clone();
	}

}
