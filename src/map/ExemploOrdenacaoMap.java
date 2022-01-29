package map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

public class ExemploOrdenacaoMap {
	public static void main(String[]args) {
		
		System.out.println("Ordem aleatória");
		Map<String, Livro> meusLivros = new HashMap<>();
		meusLivros.put("King, Stephen", new Livro("It", 1000));
		meusLivros.put("Tolkien, J.R.R", new Livro("Lord of The Rings", 1500));
		meusLivros.put("Adams, Douglas", new Livro("O Guia do Mochileiro das Galáxias", 600));
		

		for(Map.Entry<String, Livro> livro : meusLivros.entrySet()) {
			System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
		}
		

		
		System.out.println("Ordem de inserção");
		Map<String, Livro> meusLivros1 = new LinkedHashMap<>();
		meusLivros1.put("King, Stephen", new Livro("It", 1000));
		meusLivros1.put("Tolkien, J.R.R", new Livro("Lord of The Rings", 1500));
		meusLivros1.put("Adams, Douglas", new Livro("O Guia do Mochileiro das Galáxias", 600));
		

		for(Map.Entry<String, Livro> livro : meusLivros1.entrySet()) {
			System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
		}
		
		System.out.println("Ordem alfabética dos autores");
		Map<String, Livro> meusLivros2 = new TreeMap<>(meusLivros1);
		for(Map.Entry<String, Livro> livro : meusLivros2.entrySet()) {
			System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
		}
		
		System.out.println("Ordem alfabética dos livros");
		
		Set<Map.Entry<String, Livro>> meusLivros3 = new TreeSet<>(new ComparatorNome());
		
		meusLivros3.addAll(meusLivros.entrySet()); 
		System.out.println(meusLivros3);
		for(Map.Entry<String, Livro> livro : meusLivros3) {
			System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
		}
		
		System.out.println("Por ordem de páginas");
		Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<> (new ComparatorPaginas());
		
		meusLivros4.addAll(meusLivros.entrySet());
		System.out.println(meusLivros4);
		for(Map.Entry<String, Livro> livro : meusLivros4) {
			System.out.println(livro.getKey() + " - " + livro.getValue().getPaginas());
		}
	}
}






class Livro {
	private String nome;
	private int paginas;
	
	public Livro(String nome, int paginas) {
		super();
		this.nome = nome;
		this.paginas = paginas;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + paginas;
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
		Livro other = (Livro) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (paginas != other.paginas)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Livro [nome=" + nome + ", paginas=" + paginas + "]";
	}
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>> {
	@Override
	public int compare(Entry<String, Livro> l1, Entry<String, Livro> l2) {
		// TODO Auto-generated method stub
		return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
	}
}

class ComparatorPaginas implements Comparator<Map.Entry<String, Livro>> {
	public int compare(Entry<String, Livro> l1, Entry<String, Livro> l2) {
		if (l1.getValue().getPaginas() > l2.getValue().getPaginas()) {
			return l1.getValue().getPaginas();
		} else {
			return l2.getValue().getPaginas();
		}
	}
}