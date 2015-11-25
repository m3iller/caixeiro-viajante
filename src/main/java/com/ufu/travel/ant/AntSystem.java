package com.ufu.travel.ant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ufu.travel.grafo.Aresta;
import com.ufu.travel.grafo.GrafoLista;
import com.ufu.travel.grafo.Vertice;

public class AntSystem {

	public static float beta  = 0.8f; //visibilidade
	public static float alfa = 0.2f; //feronomio
	
	public static float menorCaminho = 50000f;
	public static List<Passo> melhorCaminho;
	public static Double TAMANHO_MENOR_CORRENT = 1000000d;
	public static Float TAXA_EVAPORACAO = 0.5f;
	public static Float DEPOSITO_FERONOMIO = 1f;
	
	public boolean estaganacao(List<Ant> ants) {

		Integer stagnacao = ants.size() - 1;

		int igual = 0;
		Ant ant = ants.get(0);
		for (Ant ant2 : ants) {
			if (!ant.equals(ant2)) {
				if (ant.getTamanho().intValue() == ant2.getTamanho().intValue()) {
					igual++;
				} else if (ant.getTamanho().intValue() >= ant2.getTamanho().intValue()) {
					igual--;
				} else {
					igual--;
				}
			}
		}

		if (igual == stagnacao) {
			return true;
		}

		return false;
	}
	
	public void depositoFeromonio(GrafoLista mapa, Ant ant) {
		
		Double feron = DEPOSITO_FERONOMIO / ant.getTamanho();
		
		for(Passo p: ant.getCaminho()) {
			Aresta aresta = mapa.getArestas().get(p.getAresta().getDados());
			Double deposito = ((1-TAXA_EVAPORACAO) * aresta.getDados().getFeronomio()) + feron;
			aresta.getDados().setFeronomio(aresta.getDados().getFeronomio() + deposito);	
		}
	}
	
	public void caminhoForminha(GrafoLista mapa, List<Ant> ants) {
		for (Ant ant : ants) {
			int cidadeVizitadas = 1;
			int formigaPerdida = 0;
			while (cidadeVizitadas <  mapa.getVertices().size()) {
				Vertice v = proximaCidade(mapa, ant);
				if (v != null) {
					cidadeVizitadas++;
				} else {
					formigaPerdida++;
					if(formigaPerdida == 4) {
						break;
					}
					System.out.println("Cidade nula");
				}
			}

			//adiciona ultimo caminho
			Aresta a = mapa.getArestaFromVertices(ant.getCurrentVertice(), ant.getOrigem());
			Passo p = new Passo();
			p.setAresta(a);
			p.setVertice(ant.getCurrentVertice());
			ant.setCurrentVertice(ant.getOrigem());
			ant.getCaminho().add(p);
			ant.setTamanho(ant.getTamanho()+a.getDados().getDistancia());
			
			cidadeVizitadas = 1;
			//Ant.printCaminho(ant);
			
			for(Vertice v: ant.getGrafoAnt().getVertices().values()) {
				v.getDados().setFormigaPassou(false);
			}
			for(Aresta a1:ant.getGrafoAnt().getArestas().values()) {
				a1.getDados().setFormigaPassou(false);
			}
		}
	}
	
	
	public Ant melhorCaminho(List<Ant> ants, Ant best) throws CloneNotSupportedException {
		for(Ant ant: ants) {
			if( ant.getTamanho() < TAMANHO_MENOR_CORRENT) {
				TAMANHO_MENOR_CORRENT = ant.getTamanho();
				best = (Ant) ant.clone();
				best.setCaminho(new ArrayList<Passo>());
				for(Passo p: ant.getCaminho()) {
					best.getCaminho().add((Passo) p.clone());
				}
			}
		}
		
		return best;
	}
	
	public Vertice proximaCidade(GrafoLista mapa, Ant ant) {
		
		try {
		Double somaFeromonioVisibilidade= 0d;
		
		Vertice curretVertice = ant.getCurrentVertice();
		// soma o fator de vizinhancas
		for(Vertice vertice: ant.getGrafoAnt().getVizinhos(ant.getCurrentVertice().getDados())) {
			if(!vertice.getDados().getFormigaPassou()) {
				Double distance = 0d;
				Aresta aresta = mapa.getArestaFromVertices(curretVertice, vertice);
					aresta.getDados().getDistancia();
					distance = aresta.getDados().getDistancia();
				Double visibidade = 1 / distance;
				
				somaFeromonioVisibilidade += Math.pow(aresta.getDados().getFeronomio(),alfa) * Math.pow(visibidade,beta);
			} else {
				continue;
			}
		}
		
		Double numMaximo = 0d;
		for(Vertice vertice: ant.getGrafoAnt().getVizinhos(ant.getCurrentVertice().getDados())) {
			if(!vertice.getDados().getFormigaPassou()) {
				
				Double distance = 0d;
				Aresta aresta = mapa.getArestaFromVertices(curretVertice, vertice);
					aresta.getDados().getDistancia();
					distance = aresta.getDados().getDistancia();
				
				Double visibidade = 1 / distance;
				
				numMaximo +=  (Math.pow(aresta.getDados().getFeronomio(),alfa) * Math.pow(visibidade,beta)) / somaFeromonioVisibilidade;
			} else {
				continue;
			}
		}
		
		double probabilidade = 0d;
		Random r = new Random();
		double randomValue = 0 + (numMaximo - 0) * r.nextDouble();
		
		for(Vertice vertice: ant.getGrafoAnt().getVizinhos(ant.getCurrentVertice().getDados())) {
			if(!vertice.getDados().getFormigaPassou()) {
				
				Double distance = 0d;
				Aresta aresta = mapa.getArestaFromVertices(curretVertice, vertice);
					aresta.getDados().getDistancia();
					distance = aresta.getDados().getDistancia();
				
				Double visibidade = 1 / distance;
				
				probabilidade +=  (Math.pow(aresta.getDados().getFeronomio(),alfa) * Math.pow(visibidade,beta)) / somaFeromonioVisibilidade;
				
				if(probabilidade >= randomValue) {
					
					boolean continua = false;
					if(vertice.getDados().getId() == ant.getOrigem().getDados().getId()) {
						for(Aresta arestaAux: ant.getGrafoAnt().getArestas().values()) {
							if(arestaAux.getDados().getFormigaPassou() == false) {
								continua =true;
								break;
							}
						}
					}
					
					if(continua) {
						continue;
					}
					// atualiza o caminho vertice e aresta
					Passo p = new Passo();
					p.setAresta(aresta);
					p.setVertice(curretVertice);
					ant.getCaminho().add(p);
					ant.getGrafoAnt().getArestas().get(aresta.getDados()).getDados().setFormigaPassou(true);
					ant.getGrafoAnt().getVertices().get(vertice.getDados()).getDados().setFormigaPassou(true);
					ant.getGrafoAnt().getVertices().get(curretVertice.getDados()).getDados().setFormigaPassou(true);
					
					// atualiza o vertice corrente
					ant.setCurrentVertice(vertice);
					
					//atualiza distancia percorrida da formiga
					ant.setTamanho(ant.getTamanho() + aresta.getDados().getDistancia());
					
					return vertice;
				}
			} else {
				continue;
			}
		}
		
		} catch (Exception e) {
			System.out.println("Erro ao procurar proxima cidade" + e.getMessage());
		}
		
		return null;
	}
	
}
