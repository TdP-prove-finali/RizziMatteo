package it.polito.tdp.RizziMatteo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.polito.tdp.RizziMatteo.db.FestivalDiMusicaDAO;

public class Model {

	private FestivalDiMusicaDAO dao;
	private List<Artista> best;
	private Integer spesaAggiunti;
	private List<Artista> parziale;

	public Model() {
		this.dao = new FestivalDiMusicaDAO();
		this.spesaAggiunti = 0;
		this.parziale = new ArrayList<>();
	}

	public Integer getSpesaAggiunti() {
		return this.spesaAggiunti;
	}

	public void aggiornaSpesa(Integer spesa) {
		this.spesaAggiunti += spesa;
	}

	public void resetSpesa() {
		this.spesaAggiunti = 0;
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
	
	public List<Artista> getArtistsByStreamsOnSpotify(Integer spotify) {
		return this.dao.getArtistsByStreamsOnSpotify(spotify);
	}

	public List<Artista> getParziale() {
		return parziale;
	}

	public List<Artista> intersezioneArtisti(List<Artista> artisti, List<Artista> intersezione) {
		List<Artista> risultato = new ArrayList<>();
		for (Artista a1 : artisti) {
			for (Artista a2 : intersezione) {
				if (a1.equals(a2)) {
					risultato.add(a1);
				}
			}
		}
		return risultato;
	}

	public List<Artista> calcolaCombinazioneMigliore(Integer budgetMassimo, Integer numeroArtisti,
			List<String> generiSelezionati, List<String> generiPrivilegiati, Double fattoreCorrettivo, char tipo) {

		this.best = new ArrayList<>();
		List<ArtistaPesato> artistiConsentiti = this.getArtistiPesati(generiPrivilegiati, generiSelezionati,
				fattoreCorrettivo, budgetMassimo, tipo);
		Collections.sort(artistiConsentiti);

		// System.out.println("Size artisti consentiti: " + artistiConsentiti.size());
		List<Artista> parziale = new ArrayList<>(this.parziale);

		this.ricorsione(budgetMassimo, parziale, artistiConsentiti, numeroArtisti, 0);

		return best;
	}

	private void ricorsione(Integer budgetMassimo, List<Artista> parziale, List<ArtistaPesato> artistiConsentiti,
			Integer numeroArtisti, Integer L) {
		//System.out.println(parziale);
		//System.out.println("Spesa: " + spesa(parziale));
		//System.out.println("best" + best);
		//System.out.println("somma pesi parziale: " + sommaPesi(parziale, artistiConsentiti));
		//System.out.println("somma pesi best: " + sommaPesi(best, artistiConsentiti));

		if (this.spesaAggiunti > budgetMassimo)
			return;

		if (numeroArtisti == null) {

			if (sommaPesi(parziale, artistiConsentiti) > sommaPesi(best, artistiConsentiti)) {
				best = new ArrayList<>(parziale);
			}
			
		} else {
			if (parziale.size() > numeroArtisti) {
				return;
			}
			if (parziale.size() == numeroArtisti) {

				if (sommaPesi(parziale, artistiConsentiti) > sommaPesi(best, artistiConsentiti)) {
					best = new ArrayList<>(parziale);
					return;
					}

			}

			// sicuramente parziale.size() < numeroArtisti
			if (spesa(parziale) > budgetMassimo)
				return;
		}

		if (L == artistiConsentiti.size())
			return;

		Integer spesaIpotetica = spesa(parziale) + artistiConsentiti.get(L).getArtista().getCachetMedio();
		if (spesaIpotetica <= budgetMassimo) {
			// provo ad aggiungerlo
			parziale.add(artistiConsentiti.get(L).getArtista());
			this.ricorsione(budgetMassimo, parziale, artistiConsentiti, numeroArtisti, L + 1);
			parziale.remove(artistiConsentiti.get(L).getArtista());
		}
		// provo a non aggiungerlo
		this.ricorsione(budgetMassimo, parziale, artistiConsentiti, numeroArtisti, L + 1);

	}

	private Double sommaPesi(List<Artista> artisti, List<ArtistaPesato> artistiConsentiti) {
		Double peso = 0.0;
		for (Artista artista : artisti) {
			for (ArtistaPesato a : artistiConsentiti) {
				if (artista.equals(a.getArtista())) {
					peso += a.getPeso();
				}
			}
		}
		return peso;
	}

	private Integer spesa(List<Artista> parziale) {
		Integer spesa = 0;
		for (Artista artista : parziale) {
			spesa += artista.getCachetMedio();
		}
		return spesa;
	}

	private List<ArtistaPesato> getArtistiPesati(List<String> generiPrivilegiati, List<String> generiSelezionati,
			Double fattoreCorrettivo, Integer budgetMassimo, char tipo) {
		List<ArtistaPesato> artistiConsentiti = new ArrayList<>();

		if (generiPrivilegiati.size() == 0) {
			fattoreCorrettivo = 1.0;
		}

		Double pesoMinore = 1 / (fattoreCorrettivo * generiPrivilegiati.size()
				+ (generiSelezionati.size() - generiPrivilegiati.size()));
		Double pesoMaggiore = fattoreCorrettivo * pesoMinore;

		//System.out.println("Peso minore: " + pesoMinore);
		//System.out.println("Peso maggiore: " + pesoMaggiore);

		for (Artista artista : this.dao.listAllArtists()) {
			if (artista.getCachetMedio() <= budgetMassimo) {
				if (generiPrivilegiati.size() != 0 && generiPrivilegiati.contains(artista.getGenere())) {
					// 'B' sta per numero medio di biglietti venduti, 'S' sta per ascolti su Spotify nell'ultimo mese
					if(tipo == 'B') {
					ArtistaPesato a = new ArtistaPesato(artista,
							artista.getNumeroMedioBigliettiVenduti() * pesoMaggiore);
					artistiConsentiti.add(a);
					}
					else if (tipo == 'S') {
						ArtistaPesato a = new ArtistaPesato(artista,
								artista.getAscoltiSpotifyUltimoMese() * pesoMaggiore);
						artistiConsentiti.add(a);
					}
				} else if (generiSelezionati.size() != 0 && generiSelezionati.contains(artista.getGenere())) {
					if(tipo == 'B') {
						ArtistaPesato a = new ArtistaPesato(artista,
								artista.getNumeroMedioBigliettiVenduti() * pesoMinore);
						artistiConsentiti.add(a);
						}
						else if (tipo == 'S') {
							ArtistaPesato a = new ArtistaPesato(artista,
									artista.getAscoltiSpotifyUltimoMese() * pesoMinore);
							artistiConsentiti.add(a);
						}
				}
			}
		}

		return artistiConsentiti;
	}

	public Integer spesaTotale() {
		return spesa(this.best);
	}

}
