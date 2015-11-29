package com.ufu.travel.pso;

import com.ufu.travel.grafo.VerticeTO;

public class City {

		private Double posx = 0d;
		private Double posy = 0d;
		private String nome;
		private VerticeTO vertice;
	
		public VerticeTO getVertice() {
			return vertice;
		}

		public void setVertice(VerticeTO vertice) {
			this.vertice = vertice;
		}

		public Double x()
		{
		    return posx;
		}
		
		public void x(final Double xCoordinate)
		{
		    posx = xCoordinate;
		    return;
		}
	
		public Double y()
		{
		    return posy;
		}
		
		public void y(final Double yCoordinate)
		{
		    posy = yCoordinate;
		    return;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
}
