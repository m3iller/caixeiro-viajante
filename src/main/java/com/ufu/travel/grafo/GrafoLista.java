package com.ufu.travel.grafo;

import java.util.ArrayList;
import java.util.HashMap;

public class GrafoLista implements Cloneable {

	private Integer id;
	private String nomeGrafo;
	private HashMap<ArestaTO, Aresta> arestas;
	private HashMap<VerticeTO, Vertice> vertices;
	private Double meta;
	
	public GrafoLista() {
		this.arestas = new HashMap<ArestaTO, Aresta>();
		this.vertices = new HashMap<VerticeTO, Vertice>();
	}

	public void addVertice(VerticeTO v) {
		Vertice objVertice = new Vertice(v);
		this.vertices.put(v, objVertice);
	}

	public void addAresta(VerticeTO v1, VerticeTO v2, ArestaTO a) {
		Vertice objVertice1 = this.vertices.get(v1);
		Vertice objVertice2 = this.vertices.get(v2);
		// criando a nova aresta
		addAresta(a, objVertice1, objVertice2);
	}

	public void addAresta(ArestaTO a, Vertice objVertice1, Vertice objVertice2) {
		Aresta objAresta = new Aresta(a, objVertice1, objVertice2);
		ArrayList<Aresta> listaIncidencia = objVertice1
				.getListaIncidencia();
		listaIncidencia.add(objAresta);
		ArrayList<Aresta> listaIncidencia2 = objVertice2
				.getListaIncidencia();
		listaIncidencia2.add(objAresta);
		// inserindo na lista de arestas
		this.arestas.put(a, objAresta);
	}

	public boolean delVertice(VerticeTO v) {
		Vertice objVertice = this.vertices.get(v);
		if (objVertice != null) {
			ArrayList<Aresta> listaIncidencia = objVertice
					.getListaIncidencia();
			Object arestasDaLista[] = listaIncidencia.toArray();
			for (int i = 0; i < arestasDaLista.length; i++) {
				Aresta objAresta = (Aresta) arestasDaLista[i];
				delAresta(objAresta);
			}
			this.vertices.remove(v);
		}
		return (objVertice != null);
	}

	public boolean delAresta(ArestaTO a) {
		Aresta objAresta = arestas.get(a);
		if (objAresta != null) {
			delAresta(objAresta);
			return true;
		}
		return false;
	}

	private void delAresta(Aresta objAresta) {
		Vertice vertice = this.vertices.get(objAresta.getV1().getDados());
		ArrayList<Aresta> listaIncidencia = vertice.getListaIncidencia();
		listaIncidencia.remove(objAresta);

		vertice = this.vertices.get(objAresta.getV2().getDados());
		listaIncidencia = vertice.getListaIncidencia();
		listaIncidencia.remove(objAresta);

		this.arestas.remove(objAresta.getDados());
	}

	public ArrayList<Vertice> getVizinhos(VerticeTO v) {
		ArrayList<Vertice> vizinhos = new ArrayList<Vertice>();
		Vertice objVertice = this.vertices.get(v);

		if (objVertice != null) {
			ArrayList<Aresta> listaIncidencia = objVertice
					.getListaIncidencia();
			for (int i = 0; i < listaIncidencia.size(); i++) {
				Aresta objAresta = listaIncidencia.get(i);
				Vertice objV1 = objAresta.getV1();
				Vertice objV2 = objAresta.getV2();
				if (objV1.getDados().equals(v))
					vizinhos.add(objV2);
				else
					vizinhos.add(objV1);
			}
		}
		return vizinhos;
	}

	public boolean isAdjacente(VerticeTO v1, VerticeTO v2) {
		Vertice objVertice = this.vertices.get(v1);
		if (objVertice != null) {
			ArrayList<Aresta> listaIncidencia = objVertice
					.getListaIncidencia();
			for (int i = 0; i < listaIncidencia.size(); i++) {
				Aresta objAresta = listaIncidencia.get(i);
				Vertice objV1 = objAresta.getV1();
				Vertice objV2 = objAresta.getV2();
				if (v1.equals(objV1.getDados()) && v2.equals(objV2.getDados())) {
					return true;
				}
				else if (v1.equals(objV2.getDados())
						&& v2.equals(objV1.getDados())) {
					return true;
				
				}
			}
		}
		return false;
	}
	
	public Aresta getArestaFromVertices(Vertice v1, Vertice v2) {
			Vertice objVertice = this.vertices.get(v1.getDados());
			if (objVertice != null) {
				ArrayList<Aresta> listaIncidencia = objVertice
						.getListaIncidencia();
				for (int i = 0; i < listaIncidencia.size(); i++) {
					Aresta objAresta = listaIncidencia.get(i);
					Vertice objV1 = objAresta.getV1();
					Vertice objV2 = objAresta.getV2();
					if (v1.getDados().equals(objV1.getDados()) && v2.getDados().equals(objV2.getDados())) {
						return objAresta;
					}
					else if (v1.getDados().equals(objV2.getDados())
							&& v2.getDados().equals(objV1.getDados())) {
						return objAresta;
					}
				}
			}
			return null;
		}

	public HashMap<ArestaTO, Aresta> getArestas() {
		return arestas;
	}

	public void setArestas(HashMap<ArestaTO, Aresta> arestas) {
		this.arestas = arestas;
	}

	public HashMap<VerticeTO, Vertice> getVertices() {
		return vertices;
	}

	public void setVertices(HashMap<VerticeTO, Vertice> vertices) {
		this.vertices = vertices;
	}
	
	 public Object clone() throws CloneNotSupportedException {
	        return super.clone();
	 }

	public String getNomeGrafo() {
		return nomeGrafo;
	}

	public void setNomeGrafo(String nomeGrafo) {
		this.nomeGrafo = nomeGrafo;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		GrafoLista other = (GrafoLista) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Double getMeta() {
		return meta;
	}

	public void setMeta(Double meta) {
		this.meta = meta;
	}
	
	
}
