package com.ufu.travel.ant;

import java.util.ArrayList;
import java.util.List;

import com.ufu.travel.dataset.CreateData;
import com.ufu.travel.grafo.GrafoLista;

public class AntMain {

	public static List<GrafoLista> grafos = new ArrayList<GrafoLista>();
	public static List<Ant> ants = new ArrayList<Ant>();
	public static Integer interacoes = 2000;
	
	public static void createFormigas(int tam, GrafoLista grafo) throws CloneNotSupportedException{
		ants.clear();
		ants = new ArrayList<Ant>();
		for(int i=0; i< tam; i++) {
			ants.add(Ant.buildAnt(grafo));
		}
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {

		grafos.add(CreateData.createM6());
		grafos.add(CreateData.createM15());
		grafos.add(CreateData.createM29());
		grafos.add(CreateData.createM38());
		
		for (GrafoLista grafo : grafos) {
			System.out.println("Grafo:" + grafo.getNomeGrafo());
			AntSystem.TAMANHO_MENOR_CORRENT = 1000000d;
			
			createFormigas(grafo.getVertices().size() / 2, grafo);

			AntSystem aco = new AntSystem();
			Ant best = new Ant();
			for (int i = 0; i < interacoes; i++) {

				aco.caminhoForminha(grafo, ants);
				best = aco.melhorCaminho(ants, best);
				aco.depositoFeromonio(grafo, best);

				if (aco.estaganacao(ants)) {
					System.out.println("Iteracao:" + i);
					//Ant.printCaminho(best);
					break;
				}

				if (i == interacoes - 1) {
					break;
				}

				for (Ant a : ants) {
					a.getCaminho().clear();
					a.setTamanho(0d);
				}
			}

			for (Ant a : ants) {
				//System.out.println("");
				Ant.printCaminho(a);
			}
		}
	}

}
