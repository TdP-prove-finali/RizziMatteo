package it.polito.tdp.RizziMatteo.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdo.RizziMatteo.db.FestivalDiMusicaDAO;

public class Model {
	
	private FestivalDiMusicaDAO dao;
	private List<Artista> best;
	private Integer spesa;
	
	public Model() {
		this.dao = new FestivalDiMusicaDAO();
		this.spesa = 0;
	}
	
	public List<Artista> listAllArtists() {
		return this.dao.listAllArtists();
	}
	
	public List<Artista> getArtistsByPartOfName(String nome) {
		return this.dao.getArtistsByPartOfName(nome);
	}
	
	public List<Artista> getArtistsByMusicalGenre(String genere) {
		return this.dao.getArtistsByMusicalGenre(genere);
	}
	
	public List<Artista> getArtistsByAverageTicketsSold(Double media) {
		return this.dao.getArtistsByAverageTicketsSold(media);
	}
	
	public List<Artista> getArtistsByCachet(Long cachet) {
		return this.dao.getArtistsByCachet(cachet);
	}
	
	public List<String> getMusicalGenres() {
		return this.dao.getMusicalGenres();
	}

	public List<Artista> intersezioneArtisti(List<Artista> artisti, List<Artista> intersezione) {
		List<Artista> risultato = new ArrayList<>(); 
		for(Artista a1 : artisti) {
			for(Artista a2 : intersezione) {
				if(a1.equals(a2)) {
					risultato.add(a1);
				}
			}
		}
		return risultato; 
	}

}
