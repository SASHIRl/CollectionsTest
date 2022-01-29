package map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ExemploMap {
	public static void main(String[]args) {
		System.out.println("Crie um dicionário que relacione os modelos e seus respectivos consumos: ");
		Map<String, Double> carrosPopulares = new HashMap();
		carrosPopulares.put("gol", 10.4);
		carrosPopulares.put("uno", 11.5);
		carrosPopulares.put("mobi", 12.4);
		carrosPopulares.put("hb20", 13.4);
		carrosPopulares.put("kwid", 15.4);
		System.out.println(carrosPopulares);
		
		System.out.println("Substitua o consumo do gol por 15,2");
		carrosPopulares.put("gol", 15.2);
		System.out.println(carrosPopulares);
		
		System.out.println("Confira se o modelo tucson está no dicionário");
		System.out.println(carrosPopulares.containsKey("uno"));
		System.out.println(carrosPopulares.containsKey("tucson"));

		System.out.println("Exiba os modelos");
		System.out.println(carrosPopulares.keySet());
		
		System.out.println("Exiba os consumos");
		System.out.println(carrosPopulares.values());
		
		System.out.println("O mais economico");
		System.out.println(Collections.max(carrosPopulares.values()));
		System.out.println(Collections.min(carrosPopulares.values()));
		Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
		String modeloMaisEficiente = "";
		String modeloMenosEficiente = "";
		
		for (Map.Entry<String, Double> entry: entries) {
			if(entry.getValue().equals(Collections.max(carrosPopulares.values()))) {
				modeloMaisEficiente = entry.getKey(); 
			}
		}
		
		for (Map.Entry<String, Double> entry: entries) {
			if(entry.getValue().equals(Collections.min(carrosPopulares.values()))) {
				modeloMenosEficiente = entry.getKey(); 
			}
		}
		
		System.out.println("Modelo mais eficiente: " + modeloMaisEficiente + " - " + Collections.max(carrosPopulares.values()));
		System.out.println("Modelo menos eficiente: " + modeloMenosEficiente + " - " + Collections.min(carrosPopulares.values()));
		
		System.out.println("Exiba a soma dos consumos");
		Iterator<Double> iterator = carrosPopulares.values().iterator();
		Double soma = 0d;
		
		while(iterator.hasNext()) {
			soma = soma + iterator.next();
		}
		System.out.println(soma);
		
		System.out.println("Media do consumo: " + (soma/carrosPopulares.size()));
		
		System.out.println("Remova os modelos com consumo igual a 12.4");
		
		System.out.println(carrosPopulares);
		Iterator<Double> iterator1 = carrosPopulares.values().iterator();
		while(iterator1.hasNext()) {
			if(iterator1.next().equals(12.4)) {
				iterator1.remove();
			}
		}
		System.out.println(carrosPopulares);
		
		System.out.println("Exiba o dicionário ordenado pelo modelo: ");
		Map<String, Double> carrosPopulares1 = new TreeMap<>(carrosPopulares);
		System.out.println(carrosPopulares1);
		
		System.out.println("Apague o dicionário de carros");
		carrosPopulares.clear();
		
		System.out.println("Veja se está vazio");
		
		System.out.println("Vazio? " + carrosPopulares.isEmpty());
	}
}
