package br.com.ufpb.Laboratorio.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ufpb.Laboratorio.Entity.Disciplinas;


@Service
public class DiciplinasService {
	
	
	
	
	private List<Disciplinas> listaDasDisciplinas = new ArrayList<Disciplinas>();
	
	
	public Disciplinas addDisciplinas(Disciplinas disciplina) {
		
		System.out.println(listaDasDisciplinas.size());
		int quantElementos = listaDasDisciplinas.size();
		
		disciplina.setId(quantElementos); 
		
		double[] nota =  disciplina.getNotas();
		
		double media = 0;
		int quantNotas= 0; 
		for (double d : nota) {
			media += d;
			quantNotas++;
		}
		
		media = media/quantNotas;
		
		disciplina.setMedia(media);
		
		listaDasDisciplinas.add(disciplina);
		List<Disciplinas> list = getListaDasDisciplinas();
		System.out.println(list.get(0).getNome());
		return disciplina ;
		
		
		
	}
	
public Disciplinas getByid(int id) {
		/*if(id < 0 || id > listaDasDisciplinas.size() || listaDasDisciplinas.isEmpty()) {
			
			return 
		}*/
		
		return listaDasDisciplinas.get(id) ;
		
		
		
	}

public Disciplinas setNome(int id , Disciplinas disciplina) {
	listaDasDisciplinas.get(id).setNome(disciplina.getNome());
	
	return listaDasDisciplinas.get(id) ;
	
	
	
}

public Disciplinas setNota(int id , Disciplinas disciplina) {
	listaDasDisciplinas.get(id).setMedia(disciplina.getMedia());
	
	return listaDasDisciplinas.get(id) ;
	
	
	
}


public Disciplinas deleteDisciplinas(int id ) {
	
	Disciplinas disciplinaDeletada = listaDasDisciplinas.get(id);
	this.listaDasDisciplinas.remove(disciplinaDeletada);
	return disciplinaDeletada;
	
}



public List<Disciplinas> getListaDasDisciplinasOrdenadas() {
	List<Disciplinas> listaOrdenada = listaDasDisciplinas; 
	Collections.sort(listaOrdenada);
	return listaOrdenada;
}


	public List<Disciplinas> getListaDasDisciplinas() {
		return listaDasDisciplinas;
	}


	public void setListaDasDisciplinas(List<Disciplinas> listaDasDisciplinas) {
		this.listaDasDisciplinas = listaDasDisciplinas;
	}
	
	

}
