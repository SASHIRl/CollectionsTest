package set;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class ExemploSet {
	public static void main (String[]args) {
		System.out.println("Crie um conjunto e adicione as notas: ");
		Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 5d, 7d, 0d, 3.6));
		System.out.println(notas);
		//Em hashSet n�o existe m�todo "indexOf()" para selecionar o �ndice
		//Tamb�m n�o � poss�vel subistituir um n�mero
		System.out.println("Verifica se a nota 5 est� no conjunto: " + notas.contains(5d));
		//N�o � poss�vel exibir a terceira nota adicionada
		System.out.println("Exibe a menor nota: " + Collections.min(notas));
		System.out.println("Exibe a maior nota: " + Collections.max(notas));
		Iterator<Double> iterator =  notas.iterator();
		Double soma = 0.0;
		while(iterator.hasNext()) {
			Double next = iterator.next();
			soma = soma + next;
		}
		
		System.out.println("Exibe a soma dos valores: " + soma);
		
		System.out.println("Exibe a m�dia: " + soma / notas.size());
		
		System.out.println("Remove a nota '0': ");
		notas.remove(0d);
		System.out.println(notas);
		
		Set<Double> notas2 = new LinkedHashSet<>();
		notas2.add(7d);
		notas2.add(8.5);
		notas2.add(9.3);
		notas2.add(5d);
		notas2.add(7d); //LinkedHasSet n�o adiciona elementos iguais.
		notas2.add(3.6);
		System.out.println(notas2);
		
		System.out.println("Exibir na ordem crescente: ");
		Set<Double> notas3 = new TreeSet<>(notas2);
		System.out.println(notas3);
		
		System.out.println("Apague todo o conjunto");
		notas.clear();
		System.out.println(notas);
	}
}