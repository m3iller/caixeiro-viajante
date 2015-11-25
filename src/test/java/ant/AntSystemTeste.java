package ant;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ufu.travel.ant.Ant;
import com.ufu.travel.ant.AntSystem;
import com.ufu.travel.dataset.CreateData;
import com.ufu.travel.grafo.GrafoLista;

public class AntSystemTeste {

	
	@Test
	public void nextCityTeste() throws CloneNotSupportedException {
		
		GrafoLista mapa = CreateData.createM6();
		
		List<Ant> ants = new ArrayList<Ant>();
		for(int i=0;i<=3;i++) {
			Ant ant = Ant.buildAnt(mapa);
			ants.add(ant);
		}
		
		AntSystem aco = new AntSystem();
		
		for(Ant ant : ants) {
			aco.proximaCidade(mapa, ant);
			Ant.printCaminho(ant);
		}
		
		System.out.println();
	}
	
}
