package it.polito.tdp.RizziMatteo.model;

import java.util.List;

import it.polito.tdo.RizziMatteo.db.FestivalDiMusicaDAO;

public class Model {
	
	private FestivalDiMusicaDAO dao;
	
	public Model() {
		this.dao = new FestivalDiMusicaDAO();
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

}
