package com.ufu.travel.grafo;

import java.util.ArrayList;
import java.util.HashMap;

public class GrafoLista implements Cloneable {

	private Integer id;
	private String nomeGrafo;
	private HashMap<ArestaTO, Aresta> arestas; // lista de arestas
	private HashMap<VerticeTO, Vertice> vertices; // lista de vértices

	public GrafoLista() {
		this.arestas = new HashMap<ArestaTO, Aresta>();
		this.vertices = new HashMap<VerticeTO, Vertice>();
	}

	// Insere um novo vértice com o dado 'v'.
	public void addVertice(VerticeTO v) {
		// cria novo vértice
		Vertice objVertice = new Vertice(v);
		this.vertices.put(v, objVertice);
	}

	// Insere uma nova aresta com vértices finais 'v1' e 'v2' e dado 'a'
	public void addAresta(VerticeTO v1, VerticeTO v2, ArestaTO a) {
		Vertice objVertice1 = this.vertices.get(v1);
		Vertice objVertice2 = this.vertices.get(v2);
		// criando a nova aresta
		addAresta(a, objVertice1, objVertice2);
	}

	public void addAresta(ArestaTO a, Vertice objVertice1, Vertice objVertice2) {
		Aresta objAresta = new Aresta(a, objVertice1, objVertice2);
		// obtendo a lista de incidência dos vértices finais para inserir a nova
		// aresta
		// a nova aresta deve ser inserida na lista de incidência de cada
		// vértice final (v1 e v2)
		ArrayList<Aresta> listaIncidencia = objVertice1
				.getListaIncidencia();
		listaIncidencia.add(objAresta);
		ArrayList<Aresta> listaIncidencia2 = objVertice2
				.getListaIncidencia();
		listaIncidencia2.add(objAresta);
		// inserindo na lista de arestas
		this.arestas.put(a, objAresta);
	}

	// Remove o vértice 'v'. Retorna true se 'v' foi encontrado e removido,
	// false caso contrário
	public boolean delVertice(VerticeTO v) {
		// removendo vértice da lista de vértices
		Vertice objVertice = this.vertices.get(v);
		if (objVertice != null) {
			// obtendo a lista de incidência do vértice para deletar suas
			// arestas
			ArrayList<Aresta> listaIncidencia = objVertice
					.getListaIncidencia();
			Object arestasDaLista[] = listaIncidencia.toArray();
			for (int i = 0; i < arestasDaLista.length; i++) {
				Aresta objAresta = (Aresta) arestasDaLista[i];
				// chama método delAresta() que deleta a aresta na lista de
				// incidência de seus 2 vértices finais
				delAresta(objAresta);
			}
			this.vertices.remove(v);
		}
		return (objVertice != null);
	}

	// Remove a aresta de dado 'a'. Retorna true se 'a' foi encontrada e
	// removida,
	// false caso contrário
	public boolean delAresta(ArestaTO a) {
		// obtendo aresta que liga os respectivos vértices
		Aresta objAresta = arestas.get(a);
		if (objAresta != null) {
			delAresta(objAresta);
			return true;
		}
		return false;
	}

	// Remove o objeto Aresta 'objAresta'.
	// Método delAresta() é sobrecarregado: pode receber tanto o rótulo da
	// aresta
	// como uma referência para o objeto aresta
	private void delAresta(Aresta objAresta) {
		// Uma aresta liga dois vértices: v1 e v2. Obtendo vértice v1
		Vertice vertice = this.vertices.get(objAresta.getV1().getDados());
		// obtendo a lista de incidência do vértice para deletar a aresta da
		// lista
		ArrayList<Aresta> listaIncidencia = vertice.getListaIncidencia();
		listaIncidencia.remove(objAresta);

		// Uma aresta liga dois vértices: v1 e v2. Obtendo vértice v2
		vertice = this.vertices.get(objAresta.getV2().getDados());
		// obtendo a lista de incidência do vértice para deletar a aresta da
		// lista
		listaIncidencia = vertice.getListaIncidencia();
		listaIncidencia.remove(objAresta);

		// deletando a aresta da lista de arestas
		this.arestas.remove(objAresta.getDados());
	}

	// Retorna uma lista contendo todos os vértices adjacentes (vizinhos) a um
	// vértice 'v'
	public ArrayList<Vertice> getVizinhos(VerticeTO v) {
		ArrayList<Vertice> vizinhos = new ArrayList<Vertice>();
		// obtendo vértice da lista de vértices
		Vertice objVertice = this.vertices.get(v);

		if (objVertice != null) {
			// obtendo a lista de incidência do vértice para obter suas arestas
			// e seus vizinhos
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

	// Testa se os vértices 'v1' e 'v2' são adjacentes (vizinhos)
	public boolean isAdjacente(VerticeTO v1, VerticeTO v2) {
		// obtendo vértice da lista de vértices
		Vertice objVertice = this.vertices.get(v1);
		if (objVertice != null) {
			// obtendo a lista de incidência do vértice para obter suas arestas
			// e seus vizinhos
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
	
	// Testa se os vértices 'v1' e 'v2' são adjacentes (vizinhos)
	public Aresta getArestaFromVertices(Vertice v1, Vertice v2) {
			// obtendo vértice da lista de vértices
			Vertice objVertice = this.vertices.get(v1.getDados());
			if (objVertice != null) {
				// obtendo a lista de incidência do vértice para obter suas arestas
				// e seus vizinhos
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
}
