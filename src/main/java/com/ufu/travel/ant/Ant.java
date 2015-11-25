package com.ufu.travel.ant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

import com.ufu.travel.grafo.Aresta;
import com.ufu.travel.grafo.ArestaTO;
import com.ufu.travel.grafo.GrafoLista;
import com.ufu.travel.grafo.Vertice;
import com.ufu.travel.grafo.VerticeTO;

public class Ant implements Cloneable{

	public static Integer ID_ANT = 1;
	
	private GrafoLista grafoAnt;
	private Double tamanho;
	private Vertice currentVertice;
	private List<Passo> caminho;
	private Integer idAnt;
	private Vertice origem;
	
	public Ant() {
		super();
	}
	
	public static Ant buildAnt(GrafoLista mapa) throws CloneNotSupportedException {
		Ant ant = new Ant();
		Random rand = new Random();
		
		ant.setIdAnt(ID_ANT++);
		ant.setGrafoAnt(mapa);
		int ran = rand.nextInt(((ant.getGrafoAnt().getVertices().size()-1) - 1) + 1) + 1;
		
		ant.setTamanho(0d);
		ant.setCaminho(new ArrayList<Passo>());
		List<Vertice> vs=new ArrayList<Vertice>(ant.getGrafoAnt().getVertices().values());
		ant.setCurrentVertice(vs.get(ran));
		ant.setOrigem(vs.get(ran));
		return ant;
	}
	
	public static GrafoLista clonaGrafo(GrafoLista mapa) throws CloneNotSupportedException {
		GrafoLista novoMapa = new GrafoLista();
		
		for(Entry<VerticeTO, Vertice> map: mapa.getVertices().entrySet()) {
			VerticeTO vt = map.getKey();
			
			VerticeTO vNovo = new VerticeTO();
			vNovo.setFormigaPassou(false);
			vNovo.setId(vt.getId());
			vNovo.setNome(vt.getNome());
			vNovo.setPos(vt.getPos());
			vNovo.setX(vt.getX());
			vNovo.setY(vt.getY());
			
			novoMapa.addVertice(vNovo);
		}
		
		for(Entry<ArestaTO, Aresta> map: mapa.getArestas().entrySet()) {
			ArestaTO at = map.getKey();
			Aresta  a = map.getValue();
			
			ArestaTO atNova = new ArestaTO();
			atNova.setDistancia(at.getDistancia());
			atNova.setFeronomio(at.getFeronomio());
			atNova.setFormigaPassou(false);
			atNova.setId(at.getId());
			
			Aresta aNova = (Aresta) a.clone();
			
			Vertice v1 = (Vertice) aNova.getV1().clone();
			Vertice v2 = (Vertice) aNova.getV2().clone();
			
			novoMapa.addAresta(atNova, v1, v2);
		}

		return novoMapa;
	}
	
	public static void printCaminho(Ant ant) {
		StringBuilder s = new StringBuilder();
		for(Passo p : ant.getCaminho()) {
			//System.out.println( p.getVertice().getDados() + "---" +  p.getAresta().getDados() + "-->"  );
			s.append( p.getVertice().getDados() + "---" +  p.getAresta().getDados() + "-->"  );
		}
		s.append(ant.getCurrentVertice().getDados());
		s.append(" (" + ant.getTamanho() + ")");
		System.out.println("Ant:" + ant.getIdAnt() + " | " + s  );
	}
	
	public Vertice getOrigem() {
		return origem;
	}

	public void setOrigem(Vertice origem) {
		this.origem = origem;
	}

	public List<Passo> getCaminho() {
		return caminho;
	}

	public void setCaminho(List<Passo> caminho) {
		this.caminho = caminho;
	}

	public Integer getIdAnt() {
		return idAnt;
	}

	public void setIdAnt(Integer idAnt) {
		this.idAnt = idAnt;
	}

	public GrafoLista getGrafoAnt() {
		return grafoAnt;
	}
	public void setGrafoAnt(GrafoLista grafoAnt) {
		this.grafoAnt = grafoAnt;
	}
	public Double getTamanho() {
		return tamanho;
	}
	public void setTamanho(Double tamanho) {
		this.tamanho = tamanho;
	}
	public Vertice getCurrentVertice() {
		return currentVertice;
	}
	public void setCurrentVertice(Vertice currentVertice) {
		this.currentVertice = currentVertice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAnt == null) ? 0 : idAnt.hashCode());
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
		Ant other = (Ant) obj;
		if (idAnt == null) {
			if (other.idAnt != null)
				return false;
		} else if (!idAnt.equals(other.idAnt))
			return false;
		return true;
	}
	
	public Object clone() throws CloneNotSupportedException {
        return super.clone();
	}
	
	
}
