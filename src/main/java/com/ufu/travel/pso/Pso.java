package com.ufu.travel.pso;

import java.util.ArrayList;
import java.util.Random;

import com.ufu.travel.dataset.CreateData;
import com.ufu.travel.grafo.Aresta;
import com.ufu.travel.grafo.GrafoLista;
import com.ufu.travel.grafo.Vertice;
import com.ufu.travel.grafo.VerticeTO;

public class Pso {
	
	private static int MAX_PARTICULAS = 0;
	private static int V_MAX = 0;
	private static int NUM_CITY = 0;
	private static final int ITERATE = 10000;

	private static ArrayList<Particle> particles = new ArrayList<Particle>();
	private static ArrayList<City> map = new ArrayList<City>();

	private static void initializeMap(GrafoLista grafo) {
		for (Vertice v : grafo.getVertices().values()) {
			City city = new City();
			city.x(v.getDados().getX());
			city.y(v.getDados().getY());
			city.setNome(v.getDados().getNome());
			city.setVertice(v.getDados());
			map.add(city);
		}

		return;
	}

	private static void PSOAlgorithm(GrafoLista grafo) {
		int epoch = 0;
		boolean fim = false;
		initialize(grafo);
		while (!fim) {
			if (epoch < ITERATE) {

				for (int i = 0; i < MAX_PARTICULAS; i++) {
					getTotalDistance(i,grafo);
				} 
				ordena();
				getVelocity();
				updateparticles(grafo);
				epoch++;
			} else {
				fim = true;
			}
		}
		return;
	}

	private static void initialize(GrafoLista grafo) {
		for (int i = 0; i < MAX_PARTICULAS; i++) {
			Particle newParticle = new Particle();
			newParticle.setmData(new int[grafo.getVertices().size()]);

			for (int j = 0; j < NUM_CITY; j++) {
				newParticle.data(j, j);
			} // j
			particles.add(newParticle);
			for (int j = 0; j < 10; j++) {
				randomlyArrange(particles.indexOf(newParticle));
			}
			getTotalDistance(particles.indexOf(newParticle), grafo);
		}
		return;
	}

	private static void randomlyArrange(final int index) {
		int cityA = new Random().nextInt(NUM_CITY);
		int cityB = 0;
		boolean done = false;
		while (!done) {
			cityB = new Random().nextInt(NUM_CITY);
			if (cityB != cityA) {
				done = true;
			}
		}

		int temp = particles.get(index).data(cityA);
		particles.get(index).data(cityA, particles.get(index).data(cityB));
		particles.get(index).data(cityB, temp);
		return;
	}

	private static void getVelocity() {
		double worstResults = 0;
		double vValue = 0.0;

		worstResults = particles.get(MAX_PARTICULAS - 1).pBest();

		for (int i = 0; i < MAX_PARTICULAS; i++) {
			vValue = (V_MAX * particles.get(i).pBest()) / worstResults;

			if (vValue > V_MAX) {
				particles.get(i).velocity(V_MAX);
			} else if (vValue < 0.0) {
				particles.get(i).velocity(0.0);
			} else {
				particles.get(i).velocity(vValue);
			}
		}
		return;
	}

	private static void updateparticles(GrafoLista grafo) {
		// Best is at index 0, so start from the second best.
		for (int i = 1; i < MAX_PARTICULAS; i++) {
			int changes = (int) Math.floor(Math
					.abs(particles.get(i).velocity()));
			for (int j = 0; j < changes; j++) {
				if (new Random().nextBoolean()) {
					randomlyArrange(i);
				}
				copyFromParticle(i - 1, i);
			}

			getTotalDistance(i,grafo);
		}

		return;
	}

	private static void printBestSolution(GrafoLista grafo) {
		System.out.print("Melhor RoutRota: ");
		Integer soma = 0;
		for (int j = 0; j < NUM_CITY-1; j++) {
			
			
			System.out.print(map.get(particles.get(0).data(j)).getNome() + ", ");
			
			VerticeTO v1to = map.get(particles.get(0).data(j)).getVertice();
			VerticeTO v2to = map.get(particles.get(0).data(j+1)).getVertice();
			
			Aresta a = grafo.getArestaFromVertices( grafo.getVertices().get(v1to) ,
					grafo.getVertices().get(v2to));
			System.out.print("--"+ a.getDados().getDistancia() + "-->");
			soma +=  a.getDados().getDistancia().intValue();
			System.out.print(map.get(particles.get(0).data(j+1)).getNome() + ", ");
			
		} 
		
		System.out.print(" \nDistance: " + particles.get(0).pBest() / 2+  "\n");
		return;
	}

	private static void copyFromParticle(final int source, final int destination) {
		Particle best = particles.get(source);
		int targetA = new Random().nextInt(NUM_CITY); // source's city to
														// target.
		int targetB = 0;
		int indexA = 0;
		int indexB = 0;
		int tempIndex = 0;

		int i = 0;
		for (; i < NUM_CITY; i++) {
			if (best.data(i) == targetA) {
				if (i == NUM_CITY - 1) {
					targetB = best.data(0); // if end of array, take from
											// beginning.
				} else {
					targetB = best.data(i + 1);
				}
				break;
			}
		}

		// Move targetB next to targetA by switching values.
		for (int j = 0; j < NUM_CITY; j++) {
			if (particles.get(destination).data(j) == targetA) {
				indexA = j;
			}
			if (particles.get(destination).data(j) == targetB) {
				indexB = j;
			}
		}
		if (indexA == NUM_CITY - 1) {
			tempIndex = 0;
		} else {
			tempIndex = indexA + 1;
		}

		int temp = particles.get(destination).data(tempIndex);
		particles.get(destination).data(tempIndex,
				particles.get(destination).data(indexB));
		particles.get(destination).data(indexB, temp);

		return;
	}

	private static void getTotalDistance(final int index, GrafoLista grafo) {
		Particle thisParticle = null;
		thisParticle = particles.get(index);
		thisParticle.pBest(0.0);

		for (int i = 0; i < NUM_CITY; i++) {
			if (i == NUM_CITY - 1) {
				thisParticle.pBest(thisParticle.pBest()
						+ getDistance(thisParticle.data(NUM_CITY - 1),
								thisParticle.data(0),grafo));
			} else {
				thisParticle.pBest(thisParticle.pBest()
						+ getDistance(thisParticle.data(i),
								thisParticle.data(i + 1),grafo  ));
			}
		}
		return;
	}

	private static double getDistance(final int firstCity, final int secondCity, GrafoLista grafo) {
		
		City cityA = null;
		City cityB = null;
		double a2 = 0;
		double b2 = 0;
		cityA = map.get(firstCity);
		cityB = map.get(secondCity);
		
		if(cityA.x() == null && cityB.x() == null) {
			Aresta aresta = grafo.getArestaFromVertices(grafo.getVertices().get(cityA.getVertice()), grafo.getVertices().get(cityB.getVertice()));
			if(aresta == null) {
				return 0d;
			}
			return aresta.getDados().getDistancia();
		}
		
		a2 = Math.pow(Math.abs(cityA.x() - cityB.x()), 2);
		b2 = Math.pow(Math.abs(cityA.y() - cityB.y()), 2);
		
		return Math.sqrt(a2 + b2);
	}

	private static void ordena() {
		boolean done = false;
		while (!done) {
			int changes = 0;
			int listSize = particles.size();
			for (int i = 0; i < listSize - 1; i++) {
				if (particles.get(i).compareTo(particles.get(i + 1)) == 1) {
					Particle temp = particles.get(i);
					particles.set(i, particles.get(i + 1));
					particles.set(i + 1, temp);
					changes++;
				}
			}
			if (changes == 0) {
				done = true;
			}
		}
		return;
	}

	public static void main(String[] args) {
		ArrayList<GrafoLista> grafos = new ArrayList<GrafoLista>();
		//grafos.add(CreateData.createM15());
		//grafos.add(CreateData.createM29());
		grafos.add(CreateData.createM6());
		//grafos.add(CreateData.createM38());
		
		for (GrafoLista grafo : grafos) {
			MAX_PARTICULAS = grafo.getVertices().size();
			V_MAX = grafo.getVertices().size() / 5; 
			NUM_CITY = grafo.getVertices().size();
			initializeMap(grafo);
			PSOAlgorithm(grafo);
			printBestSolution(grafo);
		}
	}

}
