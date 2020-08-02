package it.polito.tdp.RizziMatteo;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.RizziMatteo.model.Artista;
import it.polito.tdp.RizziMatteo.model.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class RicercaController {

	Model model;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private RadioButton radioFiltro;

	@FXML
	private ToggleGroup groupRicerca;

	@FXML
	private RadioButton radioCombinata;

	@FXML
	private ComboBox<String> boxFiltro;

	@FXML
	private ComboBox<String> boxGenere;

	@FXML
	private TextField txtNumeroBiglietti;

	@FXML
	private TextField txtCachet;

	@FXML
	private TextField txtNome;

	@FXML
	private Label lblErrore;

	@FXML
	private Button btnRicerca;

	@FXML
	private Button btnAggiungi;

	@FXML
	private Button btnSoluzione;

	@FXML
	private TableView<Artista> tableArtista;

	@FXML
	private TableColumn<Artista, String> tcNome;

	@FXML
	private TableColumn<Artista, String> tcGenere;

	@FXML
	private TableColumn<Artista, Double> tcBiglietti;

	@FXML
	private TableColumn<Artista, Long> tcCachet;

	@FXML
	void abilitaSelezione(ActionEvent event) {
		switch (this.boxFiltro.getValue()) {
		case "Trova gli artisti appartenenti ad un genere musicale":
			this.boxGenere.setDisable(false);
			this.txtNome.setDisable(true);
			this.txtNumeroBiglietti.setDisable(true);
			this.txtCachet.setDisable(true);
			break;
		case "Trova gli artisti dato il nome o una parte di esso":
			this.txtNome.setDisable(false);
			this.txtNumeroBiglietti.setDisable(true);
			this.txtCachet.setDisable(true);
			this.boxGenere.setDisable(true);
			break;
		case "Trova gli artisti per numero medio di biglietti venduti":
			this.txtNumeroBiglietti.setDisable(false);
			this.txtCachet.setDisable(true);
			this.boxGenere.setDisable(true);
			this.txtNome.setDisable(true);
			break;
		case "Trova gli artisti per cachet":
			this.txtCachet.setDisable(false);
			this.boxGenere.setDisable(true);
			this.txtNome.setDisable(true);
			this.txtNumeroBiglietti.setDisable(true);
			break;
		default:
			this.boxGenere.setDisable(true);
			this.txtNome.setDisable(true);
			this.txtNumeroBiglietti.setDisable(true);
			this.txtCachet.setDisable(true);
			break;
		}

	}

	@FXML
	void aggiungiSoluzioneParziale(ActionEvent event) {

	}

	@FXML
	void attivaRicercaCombinata(ActionEvent event) {
		this.txtCachet.clear();
		this.txtNome.clear();
		this.txtNumeroBiglietti.clear();

		this.boxFiltro.setDisable(true);

		this.boxGenere.setDisable(false);
		this.txtNome.setDisable(false);
		this.txtNumeroBiglietti.setDisable(false);
		this.txtCachet.setDisable(false);
	}

	@FXML
	void attivaRicercaFiltro(ActionEvent event) {
		this.txtCachet.clear();
		this.txtNome.clear();
		this.txtNumeroBiglietti.clear();

		this.boxFiltro.setDisable(false);

		this.boxGenere.setDisable(true);
		this.txtNome.setDisable(true);
		this.txtNumeroBiglietti.setDisable(true);
		this.txtCachet.setDisable(true);

	}

	@FXML
	void avviaRicerca(ActionEvent event) {
		ObservableList<Artista> data;
		this.lblErrore.setText("");

		String genere = this.boxGenere.getValue();
		String nome = this.txtNome.getText();

		// RICERCA COMBINATA
		if (this.radioCombinata.isSelected()) {
			List<Artista> intersezione = new ArrayList<>();
			boolean nullo = true;

			if (genere != null) {
				intersezione.addAll(this.model.getArtistsByMusicalGenre(genere));
				nullo = false;
			}
			if (!nome.equals("")) {
				if (nullo) {
					intersezione.addAll(this.model.getArtistsByPartOfName(nome));
					nullo = false;
				} else {
					List<Artista> artisti = new ArrayList<>();
					artisti.addAll(this.model.getArtistsByPartOfName(nome));
					intersezione = this.model.intersezioneArtisti(artisti, intersezione);
				}
			}
			String mediaTesto = this.txtNumeroBiglietti.getText().trim();
			if (!mediaTesto.equals("")) {
				try {
					Double media = Double.parseDouble(mediaTesto);
					if (nullo) {
						intersezione.addAll(this.model.getArtistsByAverageTicketsSold(media));
						nullo = false;
					} else {
						List<Artista> artisti = new ArrayList<>();
						artisti.addAll(this.model.getArtistsByAverageTicketsSold(media));
						intersezione = this.model.intersezioneArtisti(artisti, intersezione);
					}
				} catch (NumberFormatException e) {
					this.lblErrore.setText(
							"Errore! Devi inserire un valore decimale per il numero medio di biglietti venduti nell'apposita casella di testo.");
				}
			}

			String cachetTesto = this.txtCachet.getText().trim();
			if (!cachetTesto.equals("")) {
				try {
					Long cachet = Long.parseLong(cachetTesto);
					if (nullo) {
						intersezione.addAll(this.model.getArtistsByCachet(cachet));
						nullo = false;
					} else {
						List<Artista> artisti = new ArrayList<>();
						artisti.addAll(this.model.getArtistsByCachet(cachet));
						intersezione = this.model.intersezioneArtisti(artisti, intersezione);
					}
				} catch (NumberFormatException e) {
					this.lblErrore.setText(
							"Errore! Devi inserire un valore intero per il cachet medio nell'apposita casella di testo.");
				}
			}

			data = FXCollections.observableArrayList(intersezione);
			this.tableArtista.setItems(data);

		}

		// RICERCA TRAMITE FILTRO
		else if (this.radioFiltro.isSelected()) {
			String filtro = this.boxFiltro.getValue();
			if (filtro == null) {
				this.lblErrore.setText("Errore! Devi selezionare un filtro dall'apposito menu a tendina.");
				return;
			}

			switch (filtro) {
			case "Trova tutti gli artisti":
				data = FXCollections.observableArrayList(this.model.listAllArtists());
				this.tableArtista.setItems(data);
				break;
			case "Trova gli artisti appartenenti ad un genere musicale":
				if (genere == null) {
					this.lblErrore.setText("Errore! Devi selezionare un genere musicale.");
				} else {
					data = FXCollections.observableArrayList(this.model.getArtistsByMusicalGenre(genere));
					this.tableArtista.setItems(data);
				}
				break;
			case "Trova gli artisti dato il nome o una parte di esso":
				if (nome.equals("")) {
					this.lblErrore.setText(
							"Errore! Devi inserire il nome di un'artista o una parte di esso nell'apposita casella di testo.");
				} else {
					data = FXCollections.observableArrayList(this.model.getArtistsByPartOfName(nome.trim()));
					this.tableArtista.setItems(data);
				}
				break;
			case "Trova gli artisti per numero medio di biglietti venduti":
				Double media;
				try {
					media = Double.parseDouble(this.txtNumeroBiglietti.getText().trim());
					data = FXCollections.observableArrayList(this.model.getArtistsByAverageTicketsSold(media));
					this.tableArtista.setItems(data);
				} catch (NumberFormatException e) {
					this.lblErrore.setText(
							"Errore! Devi inserire un valore decimale per il numero medio di biglietti venduti nell'apposita casella di testo.");
				}
				break;
			case "Trova gli artisti per cachet":
				Long cachet;
				try {
					cachet = Long.parseLong(this.txtCachet.getText().trim());
					data = FXCollections.observableArrayList(this.model.getArtistsByCachet(cachet));
					this.tableArtista.setItems(data);
				} catch (NumberFormatException e) {
					this.lblErrore.setText(
							"Errore! Devi inserire un valore intero per il cachet medio nell'apposita casella di testo.");
				}
				break;
			}
		}

	}

	@FXML
	void vaiAllaSoluzione(ActionEvent event) {

	}

	@FXML
	void initialize() {
		assert radioFiltro != null : "fx:id=\"radioFiltro\" was not injected: check your FXML file 'Ricerca.fxml'.";
		assert groupRicerca != null : "fx:id=\"groupRicerca\" was not injected: check your FXML file 'Ricerca.fxml'.";
		assert radioCombinata != null : "fx:id=\"radioCombinata\" was not injected: check your FXML file 'Ricerca.fxml'.";
		assert boxFiltro != null : "fx:id=\"boxFiltro\" was not injected: check your FXML file 'Ricerca.fxml'.";
		assert boxGenere != null : "fx:id=\"boxGenere\" was not injected: check your FXML file 'Ricerca.fxml'.";
		assert txtNumeroBiglietti != null : "fx:id=\"txtNumeroBiglietti\" was not injected: check your FXML file 'Ricerca.fxml'.";
		assert txtCachet != null : "fx:id=\"txtCachet\" was not injected: check your FXML file 'Ricerca.fxml'.";
		assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Ricerca.fxml'.";
		assert lblErrore != null : "fx:id=\"lblErrore\" was not injected: check your FXML file 'Ricerca.fxml'.";
		assert btnRicerca != null : "fx:id=\"btnRicerca\" was not injected: check your FXML file 'Ricerca.fxml'.";
		assert btnAggiungi != null : "fx:id=\"btnAggiungi\" was not injected: check your FXML file 'Ricerca.fxml'.";
		assert btnSoluzione != null : "fx:id=\"btnSoluzione\" was not injected: check your FXML file 'Ricerca.fxml'.";
		assert tableArtista != null : "fx:id=\"tableArtista\" was not injected: check your FXML file 'Ricerca.fxml'.";
		assert tcNome != null : "fx:id=\"tcNome\" was not injected: check your FXML file 'Ricerca.fxml'.";
		assert tcGenere != null : "fx:id=\"tcGenere\" was not injected: check your FXML file 'Ricerca.fxml'.";
		assert tcBiglietti != null : "fx:id=\"tcBiglietti\" was not injected: check your FXML file 'Ricerca.fxml'.";
		assert tcCachet != null : "fx:id=\"tcCachet\" was not injected: check your FXML file 'Ricerca.fxml'.";

	}

	public void setModel(Model model) {
		this.model = model;
		List<String> filtri = new ArrayList<>();
		filtri.add(new String("Trova tutti gli artisti"));
		filtri.add(new String("Trova gli artisti appartenenti ad un genere musicale"));
		filtri.add(new String("Trova gli artisti per numero medio di biglietti venduti"));
		filtri.add(new String("Trova gli artisti per cachet"));
		filtri.add(new String("Trova gli artisti dato il nome o una parte di esso"));
		this.boxFiltro.getItems().addAll(filtri);

		this.boxGenere.getItems().addAll(this.model.getMusicalGenres());

		this.tcBiglietti.setCellValueFactory(new PropertyValueFactory<Artista, Double>("numeroMedioBigliettiVenduti"));
		this.tcCachet.setCellValueFactory(new PropertyValueFactory<Artista, Long>("cachetMedio"));
		this.tcGenere.setCellValueFactory(new PropertyValueFactory<Artista, String>("genere"));
		this.tcNome.setCellValueFactory(new PropertyValueFactory<Artista, String>("nome"));

	}
}
