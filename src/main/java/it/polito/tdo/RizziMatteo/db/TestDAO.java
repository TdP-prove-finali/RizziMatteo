package it.polito.tdo.RizziMatteo.db;

import it.polito.tdp.RizziMatteo.model.Artista;

public class TestDAO {
	
	public static void main(String[] args) {
		TestDAO testDAO = new TestDAO();
		testDAO.run();
	}
	
	public void run() {
		FestivalDiMusicaDAO dao = new FestivalDiMusicaDAO();
		System.out.println("Artisti:");
		for(Artista artista : dao.listAllArtists()) {
			System.out.println(artista);
		}
		System.out.println("\n-----------------\n");
		System.out.println("Artisti che hanno all'interno del nome la sequenza 'Red':");
		for(Artista artista : dao.getArtistsByPartOfName("Red")) {
			System.out.println(artista);
		}
		
		System.out.println("\n-----------------\n");
		System.out.println("Artisti di genere rap/trap:");
		for(Artista artista : dao.getArtistsByMusicalGenre("rap/trap")) {
			System.out.println(artista);
		}
		
		System.out.println("\n-----------------\n");
		System.out.println("Artisti che hanno venduto in media almeno 50.000 biglietti:");
		for(Artista artista : dao.getArtistsByAverageTicketsSold(50000.0)) {
			System.out.println(artista + " " + artista.getNumeroMedioBigliettiVenduti());
		}
		
		System.out.println("\n-----------------\n");
		System.out.println("Artisti con cachet medio massimo di 300.000 $:");
		for(Artista artista : dao.getArtistsByCachet((long) 300000)) {
			System.out.println(artista + " " + artista.getCachetMedio() + " $");
		}
		
	}

}
