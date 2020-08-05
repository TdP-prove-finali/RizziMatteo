package it.polito.tdp.RizziMatteo.model;

import java.util.ArrayList;
import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		Model model = new Model();
		
		List<String> generiSelezionati = model.getMusicalGenres();

		List<String> generiPrivilegiati = new ArrayList<>();
		List<Artista> best = model.calcolaCombinazioneMigliore(5000000, 10, generiSelezionati, generiPrivilegiati, 1.0);
		System.out.println("Combinazione migliore:");
		for(Artista a : best) {
			System.out.println(a);
		}
	}

}
