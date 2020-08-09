package it.polito.tdp.RizziMatteo.model;

import java.util.ArrayList;
import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		Model model = new Model();
		
		List<String> generiSelezionati = new ArrayList<>();
		generiSelezionati.add("pop");

		List<String> generiPrivilegiati = new ArrayList<>();
		List<Artista> best = model.calcolaCombinazioneMigliore(600000, null, generiSelezionati, generiPrivilegiati, 1.0, 'S');
		System.out.println("Combinazione migliore:");
		for(Artista a : best) {
			System.out.println(a);
		}
	}

}
