package com.ufu.travel.dataset;

import com.ufu.travel.grafo.Aresta;
import com.ufu.travel.grafo.ArestaTO;
import com.ufu.travel.grafo.GrafoLista;
import com.ufu.travel.grafo.Vertice;
import com.ufu.travel.grafo.VerticeTO;

public class CreateData {

	public static Integer idArestas = 1;
	public static Integer idVertices = 1;
	public static Double FEROMONIO = 1d;
	public static Integer idGrafo =1;
	
	public static GrafoLista createM6(){
		GrafoLista grafo = new GrafoLista();
		grafo.setId(idGrafo++);
		grafo.setNomeGrafo("M6");
		//vertices
		VerticeTO aveiro = new VerticeTO();
		aveiro.setNome("Aveiro");
		aveiro.setId(idVertices++);
		
		VerticeTO evora = new VerticeTO();
		evora.setNome("Evora");
		evora.setId(idVertices++);
		
		VerticeTO faro = new VerticeTO();
		faro.setNome("Faro");
		faro.setId(idVertices++);
		
		VerticeTO badajoz = new VerticeTO();
		badajoz.setNome("Badajoz");
		badajoz.setId(idVertices++);
		
		VerticeTO cordoba = new VerticeTO();
		cordoba.setNome("Cordoba");
		cordoba.setId(idVertices++);
		
		VerticeTO madrid = new VerticeTO();
		madrid.setNome("Madrid");
		madrid.setId(idVertices++);
		
		// arestas
		ArestaTO a1 = new ArestaTO();
		a1.setDistancia(353d);
		a1.setId(idArestas++);
		a1.setFeronomio(FEROMONIO);
		ArestaTO a2 = new ArestaTO();
		a2.setDistancia(582d);
		a2.setId(idArestas++);
		a2.setFeronomio(FEROMONIO);
		ArestaTO a3 = new ArestaTO();
		a3.setDistancia(372d);
		a3.setId(idArestas++);
		a3.setFeronomio(FEROMONIO);
		ArestaTO a4 = new ArestaTO();
		a4.setDistancia(641d);
		a4.setId(idArestas++);
		a4.setFeronomio(FEROMONIO);
		ArestaTO a5 = new ArestaTO();
		a5.setDistancia(559d);
		a5.setId(idArestas++);
		a5.setFeronomio(FEROMONIO);
		
		// adicionando vertices
		grafo.addVertice(aveiro);
		grafo.addVertice(evora);
		grafo.addVertice(faro);
		grafo.addVertice(badajoz);
		grafo.addVertice(cordoba);
		grafo.addVertice(madrid);
		
		//cidade de aveiros
		grafo.addAresta(aveiro, evora, a1);
		grafo.addAresta(aveiro, faro, a2);
		grafo.addAresta(aveiro, badajoz, a3);
		grafo.addAresta(aveiro, cordoba, a4);
		grafo.addAresta(aveiro, madrid, a5);
		
		
		//cidade de evora
		ArestaTO b1 = new ArestaTO();
		b1.setDistancia(231d);
		b1.setId(idArestas++);
		b1.setFeronomio(FEROMONIO);
		ArestaTO b2 = new ArestaTO();
		b2.setDistancia(99d);
		b2.setId(idArestas++);
		b2.setFeronomio(FEROMONIO);
		ArestaTO b3 = new ArestaTO();
		b3.setDistancia(426d);
		b3.setId(idArestas++);
		b3.setFeronomio(FEROMONIO);
		ArestaTO b4 = new ArestaTO();
		b4.setId(idArestas++);
		b4.setDistancia(502d);
		b4.setFeronomio(FEROMONIO);
		
		grafo.addAresta(evora, faro, b1);
		grafo.addAresta(evora, badajoz, b2);
		grafo.addAresta(evora, cordoba, b3);
		grafo.addAresta(evora, madrid, b4);
		
		//cidade de Faro
		ArestaTO c1 = new ArestaTO();
		c1.setDistancia(331d);
		c1.setId(idArestas++);
		c1.setFeronomio(FEROMONIO);
		
		ArestaTO c2 = new ArestaTO();
		c2.setDistancia(326d);
		c2.setId(idArestas++);
		c2.setFeronomio(FEROMONIO);
		ArestaTO c3 = new ArestaTO();
		c3.setDistancia(750d);
		c3.setId(idArestas++);
		c3.setFeronomio(FEROMONIO);

		grafo.addAresta(faro, badajoz, c1);
		grafo.addAresta(faro, cordoba, c2);
		grafo.addAresta(faro, madrid, c3);
		
		ArestaTO d1 = new ArestaTO();
		d1.setDistancia(269d);
		d1.setId(idArestas++);
		d1.setFeronomio(FEROMONIO);
		ArestaTO d2 = new ArestaTO();
		d2.setDistancia(403d);
		d2.setId(idArestas++);
		d2.setFeronomio(FEROMONIO);
		
		grafo.addAresta(badajoz, cordoba, d1);
		grafo.addAresta(badajoz, madrid, d2);
		
		ArestaTO e1 = new ArestaTO();
		e1.setDistancia(424d);
		e1.setId(idArestas++);
		e1.setFeronomio(FEROMONIO);
		
		grafo.addAresta(cordoba, madrid, e1);
		
		return grafo;
	}
	
	
	public static GrafoLista createM15(){
		
		VerticeTO c1 = new VerticeTO();
		c1.setX(200f);
		c1.setY(300f);
		c1.setNome("c1");
		c1.setId(idVertices++);
		
		VerticeTO c2 = new VerticeTO();
		c2.setX(300f);
		c2.setY(700f);
		c2.setNome("c2");
		c2.setId(idVertices++);
		
		VerticeTO c3 = new VerticeTO();
		c3.setX(300f);
		c3.setY(1700f);
		c3.setNome("c3");
		c3.setId(idVertices++);
		
		VerticeTO c4 = new VerticeTO();
		c4.setX(1000f);
		c4.setY(1900f);
		c4.setNome("c4");
		c4.setId(idVertices++);

		VerticeTO c5 = new VerticeTO();
		c5.setX(600f);
		c5.setY(1400f);
		c5.setNome("c5");
		c5.setId(idVertices++);
		
		VerticeTO c6 = new VerticeTO();
		c6.setX(1700f);
		c6.setY(1600f);
		c6.setNome("c6");
		c6.setId(idVertices++);
		
		VerticeTO c7 = new VerticeTO();
		c7.setX(1400f);
		c7.setY(800f);
		c7.setNome("c7");
		c7.setId(idVertices++);
		
		VerticeTO c8 = new VerticeTO();
		c8.setX(1200f);
		c8.setY(500f);
		c8.setNome("c8");
		c8.setId(idVertices++);
		
		VerticeTO c9 = new VerticeTO();
		c9.setX(200f);
		c9.setY(1000f);
		c9.setNome("c9");
		c9.setId(idVertices++);
		
		VerticeTO c10 = new VerticeTO();
		c10.setX(1200f);
		c10.setY(1100f);
		c10.setNome("c10");
		c10.setId(idVertices++);
		
		VerticeTO c11 = new VerticeTO();
		c11.setX(500f);
		c11.setY(700f);
		c11.setNome("c11");
		c11.setId(idVertices++);
		
		VerticeTO c12 = new VerticeTO();
		c12.setX(1000f);
		c12.setY(900f);
		c12.setNome("c12");
		c12.setId(idVertices++);
		
		VerticeTO c13 = new VerticeTO();
		c13.setX(1900f);
		c13.setY(1000f);
		c13.setNome("c13");
		c13.setId(idVertices++);
		
		VerticeTO c14 = new VerticeTO();
		c14.setX(400f);
		c14.setY(500f);
		c14.setNome("c14");
		c14.setId(idVertices++);

		VerticeTO c15 = new VerticeTO();
		c15.setX(1600f);
		c15.setY(200f);
		c15.setNome("c15");
		c15.setId(idVertices++);
		
		GrafoLista grafo = new GrafoLista();
		grafo.setId(idGrafo++);
		grafo.setNomeGrafo("M13");
		grafo.addVertice(c1);
		grafo.addVertice(c2);
		grafo.addVertice(c3);
		grafo.addVertice(c4);
		grafo.addVertice(c5);
		grafo.addVertice(c6);
		grafo.addVertice(c7);
		grafo.addVertice(c8);
		grafo.addVertice(c9);
		grafo.addVertice(c10);
		grafo.addVertice(c11);
		grafo.addVertice(c12);
		grafo.addVertice(c13);
		grafo.addVertice(c14);
		grafo.addVertice(c15);
		
		for (Vertice v1 : grafo.getVertices().values()) {
			double distancia = 0d;
			for (Vertice v2 : grafo.getVertices().values()) {
				if(!(v1.getDados().getId() == v2.getDados().getId())) {
					Aresta a1 = grafo.getArestaFromVertices(v1, v2);
					if (a1 == null) {
	
						distancia = distance(v1.getDados().getX(), v1.getDados()
								.getY(), v2.getDados().getX(), v2.getDados().getY());
	
						ArestaTO a = new ArestaTO();
						a.setId(idArestas++);
						a.setDistancia(distancia);
						a.setFeronomio(FEROMONIO);
						grafo.addAresta(a, v1, v2);
					}
				}
			}
			
		}
		
		return grafo;
	}
	
	
	public static GrafoLista createM29() {
		
		VerticeTO c1 = new VerticeTO();
		c1.setX(20833.3333f);
		c1.setY(17100.0000f);
		c1.setNome("c1");
		c1.setId(idVertices++);
		
		VerticeTO c2 = new VerticeTO();
		c2.setX(20900.0000f);
		c2.setY(17066.6667f);
		c2.setNome("c2");
		c2.setId(idVertices++);
		
		VerticeTO c3 = new VerticeTO();
		c3.setX(21300.0000f);
		c3.setY(13016.6667f);
		c3.setNome("c3");
		c3.setId(idVertices++);
		
		VerticeTO c4 = new VerticeTO();
		c4.setX(21600.0000f);
		c4.setY(14150.0000f);
		c4.setNome("c4");
		c4.setId(idVertices++);

		VerticeTO c5 = new VerticeTO();
		c5.setX(21600.0000f);
		c5.setY(14966.6667f);
		c5.setNome("c5");
		c5.setId(idVertices++);
		
		VerticeTO c6 = new VerticeTO();
		c6.setX(21600.0000f);
		c6.setY(16500.0000f);
		c6.setNome("c6");
		c6.setId(idVertices++);
		
		VerticeTO c7 = new VerticeTO();
		c7.setX(22183.3333f);
		c7.setY(13133.3333f);
		c7.setNome("c7");
		c7.setId(idVertices++);
		
		VerticeTO c8 = new VerticeTO();
		c8.setX(22583.3333f);
		c8.setY(14300.0000f);
		c8.setNome("c8");
		c8.setId(idVertices++);
		
		VerticeTO c9 = new VerticeTO();
		c9.setX(22683.3333f);
		c9.setY(12716.6667f);
		c9.setNome("c9");
		c9.setId(idVertices++);
		
		VerticeTO c10 = new VerticeTO();
		c10.setX(23616.6667f);
		c10.setY(15866.666f);
		c10.setNome("c10");
		c10.setId(idVertices++);
		
		VerticeTO c11 = new VerticeTO();
		c11.setX(23700.0000f);
		c11.setY(15933.3333f);
		c11.setNome("c11");
		c11.setId(idVertices++);
		
		VerticeTO c12 = new VerticeTO();
		c12.setX(23883.3333f);
		c12.setY(14533.3333f);
		c12.setNome("c12");
		c12.setId(idVertices++);
		
		VerticeTO c13 = new VerticeTO();
		c13.setX(24166.6667f);
		c13.setY(13250.0000f);
		c13.setNome("c13");
		c13.setId(idVertices++);
		
		VerticeTO c14 = new VerticeTO();
		c14.setX(25149.1667f);
		c14.setY(12365.8333f);
		c14.setNome("c14");
		c14.setId(idVertices++);

		VerticeTO c15 = new VerticeTO();
		c15.setX(26133.3333f);
		c15.setY(14500.0000f);
		c15.setNome("c15");
		c15.setId(idVertices++);
		
		VerticeTO c16 = new VerticeTO();
		c16.setX(26150.0000f);
		c16.setY(10550.0000f);
		c16.setNome("c16");
		c16.setId(idVertices++);
		
		VerticeTO c17 = new VerticeTO();
		c17.setX(26283.3333f);
		c17.setY(12766.6667f);
		c17.setNome("c17");
		c17.setId(idVertices++);
		
		VerticeTO c18 = new VerticeTO();
		c18.setX(26433.3333f);
		c18.setY(13433.3333f);
		c18.setNome("c18");
		c18.setId(idVertices++);
		
		VerticeTO c19 = new VerticeTO();
		c19.setX(26550.0000f);
		c19.setY(13850.0000f);
		c19.setNome("c19");
		c19.setId(idVertices++);
		
		VerticeTO c20 = new VerticeTO();
		c20.setX(26733.3333f);
		c20.setY(11683.3333f);
		c20.setNome("c20");
		c20.setId(idVertices++);
		
		VerticeTO c21 = new VerticeTO();
		c21.setX(27026.1111f);
		c21.setY(13051.9444f);
		c21.setNome("c21");
		c21.setId(idVertices++);
		
		VerticeTO c22 = new VerticeTO();
		c22.setX(27096.1111f);
		c22.setY(13415.8333f);
		c22.setNome("c22");
		c22.setId(idVertices++);
		
		VerticeTO c23 = new VerticeTO();
		c23.setX(27153.6111f);
		c23.setY(13203.3333f);
		c23.setNome("c23");
		c23.setId(idVertices++);
		
		VerticeTO c24 = new VerticeTO();
		c24.setX(27166.6667f);
		c24.setY(9833.3333f);
		c24.setNome("c24");
		c24.setId(idVertices++);
		
		VerticeTO c25 = new VerticeTO();
		c25.setX(27233.3333f);
		c25.setY(10450.0000f);
		c25.setNome("c25");
		c25.setId(idVertices++);
		
		VerticeTO c26 = new VerticeTO();
		c26.setX(27233.3333f);
		c26.setY(11783.3333f);
		c26.setNome("c26");
		c26.setId(idVertices++);
		
		VerticeTO c27 = new VerticeTO();
		c27.setX(27266.6667f);
		c27.setY(10383.3333f);
		c27.setNome("c27");
		c27.setId(idVertices++);
		
		VerticeTO c28 = new VerticeTO();
		c28.setX(27433.3333f);
		c28.setY(12400.0000f);
		c28.setNome("c28");
		c28.setId(idVertices++);
		
		VerticeTO c29 = new VerticeTO();
		c29.setX(27462.5000f);
		c29.setY(12992.2222f);
		c29.setNome("c29");
		c29.setId(idVertices++);
		
		GrafoLista grafo = new GrafoLista();
		grafo.setId(idGrafo++);
		grafo.setNomeGrafo("M29");
		grafo.addVertice(c1);
		grafo.addVertice(c2);
		grafo.addVertice(c3);
		grafo.addVertice(c4);
		grafo.addVertice(c5);
		grafo.addVertice(c6);
		grafo.addVertice(c7);
		grafo.addVertice(c8);
		grafo.addVertice(c9);
		grafo.addVertice(c10);
		grafo.addVertice(c11);
		grafo.addVertice(c12);
		grafo.addVertice(c13);
		grafo.addVertice(c14);
		grafo.addVertice(c15);
		grafo.addVertice(c16);
		grafo.addVertice(c17);
		grafo.addVertice(c18);
		grafo.addVertice(c19);
		grafo.addVertice(c20);
		grafo.addVertice(c21);
		grafo.addVertice(c22);
		grafo.addVertice(c23);
		grafo.addVertice(c24);
		grafo.addVertice(c25);
		grafo.addVertice(c26);
		grafo.addVertice(c27);
		grafo.addVertice(c28);
		grafo.addVertice(c29);
		
		for (Vertice v1 : grafo.getVertices().values()) {
			double distancia = 0d;
			for (Vertice v2 : grafo.getVertices().values()) {
				if(!(v1.getDados().getId() == v2.getDados().getId())) {
					Aresta a1 = grafo.getArestaFromVertices(v1, v2);
					if (a1 == null) {
	
						distancia = distance(v1.getDados().getX(), v1.getDados()
								.getY(), v2.getDados().getX(), v2.getDados().getY());
	
						ArestaTO a = new ArestaTO();
						a.setId(idArestas++);
						a.setDistancia(distancia);
						a.setFeronomio(FEROMONIO);
						grafo.addAresta(a, v1, v2);
					}
				}
			}
			
		}
		
		return grafo;
		
	}
	
	public static double distance(double x1, double y1, double x2, double y2) {
	    return Math.sqrt(  (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
	}
	
	
}
