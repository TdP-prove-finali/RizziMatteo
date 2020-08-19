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
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
    private TextField txtSpotify;

	@FXML
	private TextField txtCachet;

	@FXML
	private TextField txtNome;

	@FXML
	private Label lblErrore;
	
    @FXML
    private Label lblSuccesso;

	@FXML
	private Button btnRicerca;

	@FXML
	private Button btnAggiungi;
	
    @FXML
    private Button btnElimina;

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
    private TableColumn<Artista, Integer> tcSpotify;

	@FXML
	private TableColumn<Artista, Integer> tcCachet;

	@FXML
	void abilitaSelezione(ActionEvent event) {
		// in base alla scelta del filtro si potranno specificare i valori
		// per la ricerca per quel dato filtro
		switch (this.boxFiltro.getValue()) {
		case "Trova gli artisti appartenenti ad un genere musicale":
			this.boxGenere.setDisable(false);
			this.txtNome.setDisable(true);
			this.txtNumeroBiglietti.setDisable(true);
			this.txtCachet.setDisable(true);
			this.txtSpotify.setDisable(true);
			break;
		case "Trova gli artisti dato il nome o una parte di esso":
			this.txtNome.setDisable(false);
			this.txtNumeroBiglietti.setDisable(true);
			this.txtCachet.setDisable(true);
			this.boxGenere.setDisable(true);
			this.txtSpotify.setDisable(true);
			break;
		case "Trova gli artisti per numero medio di biglietti venduti":
			this.txtNumeroBiglietti.setDisable(false);
			this.txtCachet.setDisable(true);
			this.boxGenere.setDisable(true);
			this.txtNome.setDisable(true);
			this.txtSpotify.setDisable(true);
			break;
		case "Trova gli artisti per cachet":
			this.txtCachet.setDisable(false);
			this.boxGenere.setDisable(true);
			this.txtNome.setDisable(true);
			this.txtNumeroBiglietti.setDisable(true);
			this.txtSpotify.setDisable(true);
			break;
		case "Trova gli artisti per ascolti su Spotify nell'ultimo mese":
			this.txtSpotify.setDisable(false);
			this.txtCachet.setDisable(true);
			this.boxGenere.setDisable(true);
			this.txtNome.setDisable(true);
			this.txtNumeroBiglietti.setDisable(true);
			break;
		default:
			this.boxGenere.setDisable(true);
			this.txtNome.setDisable(true);
			this.txtNumeroBiglietti.setDisable(true);
			this.txtCachet.setDisable(true);
			this.txtSpotify.setDisable(true);
			break;
		}

	}

	@FXML
	void aggiungiSoluzioneParziale(ActionEvent event) {
		this.lblErrore.setText("");
		this.lblSuccesso.setText("");
		
		Artista artista = this.tableArtista.getSelectionModel().getSelectedItem();
		
		// se non è stato selezionato alcun artista
		if(artista == null) {
			this.lblErrore.setText("Errore! Per poter aggiungere un artista alla soluzione ottima devi selezionarne uno.");
			return;
		}
		
		// se l'artista in questione è stato già aggiunto alla soluzione parziale
		if(this.model.getParziale().contains(artista)) {
			this.lblErrore.setText("Errore! Hai già inserito l'artista selezionato alla soluzione ottima.");
			return;
		}
		
		this.model.getParziale().add(artista);
		this.lblSuccesso.setText("Artista aggiunto con successo!");
		this.model.aggiornaSpesa(artista.getCachetMedio());
		this.btnElimina.setDisable(false);

	}

	@FXML
	void attivaRicercaCombinata(ActionEvent event) {
		this.txtCachet.clear();
		this.txtNome.clear();
		this.txtNumeroBiglietti.clear();
		this.txtSpotify.clear();
		this.boxGenere.setValue(null);

		this.boxFiltro.setDisable(true);

		this.boxGenere.setDisable(false);
		this.txtNome.setDisable(false);
		this.txtNumeroBiglietti.setDisable(false);
		this.txtCachet.setDisable(false);
		this.txtSpotify.setDisable(false);
	}

	@FXML
	void attivaRicercaFiltro(ActionEvent event) {
		this.txtCachet.clear();
		this.txtNome.clear();
		this.txtNumeroBiglietti.clear();
		this.txtSpotify.clear();
		this.boxGenere.setValue(null);

		this.boxFiltro.setDisable(false);

		this.boxGenere.setDisable(true);
		this.txtNome.setDisable(true);
		this.txtNumeroBiglietti.setDisable(true);
		this.txtCachet.setDisable(true);
		this.txtSpotify.setDisable(true);
	}

	@FXML
	void avviaRicerca(ActionEvent event) {
		ObservableList<Artista> data;
		this.lblErrore.setText("");
		this.lblSuccesso.setText("");

		String genere = this.boxGenere.getValue();
		String nome = this.txtNome.getText();

		// RICERCA COMBINATA ---- intersezione liste
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
							"Errore! Devi inserire un valore decimale per il numero medio di biglietti venduti.");
					return;
				}
			}
			
			String spotifyTesto = this.txtSpotify.getText().trim();
			if (!spotifyTesto.equals("")) {
				try {
					Integer spotify = Integer.parseInt(spotifyTesto);
					if (nullo) {
						intersezione.addAll(this.model.getArtistsByStreamsOnSpotify(spotify));
						nullo = false;
					} else {
						List<Artista> artisti = new ArrayList<>();
						artisti.addAll(this.model.getArtistsByStreamsOnSpotify(spotify));
						intersezione = this.model.intersezioneArtisti(artisti, intersezione);
					}
				} catch (NumberFormatException e) {
					this.lblErrore.setText(
							"Errore! Devi inserire un valore intero per il numero di ascolti su Spotify.");
					return;
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
							"Errore! Devi inserire un valore intero per il cachet medio.");
					return;
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
							"Errore! Devi inserire il nome di un'artista o una parte di esso.");
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
							"Errore! Devi inserire un valore decimale per il numero medio di biglietti venduti.");
					return;
				}
				break;
			case "Trova gli artisti per ascolti su Spotify nell'ultimo mese":
				Integer spotify;
					try {
						spotify = Integer.parseInt(this.txtSpotify.getText().trim());
						data = FXCollections.observableArrayList(this.model.getArtistsByStreamsOnSpotify(spotify));
						this.tableArtista.setItems(data);
					} catch (NumberFormatException e) {
						this.lblErrore.setText(
								"Errore! Devi inserire un valore intero per il numero di ascolti su Spotify.");
						return;
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
							"Errore! Devi inserire un valore intero per il cachet medio.");
					return;
				}
				break;
			}
		}
		
		this.boxGenere.setValue(null);

	}
	
    @FXML
    void doElimina(ActionEvent event) {
    	this.lblErrore.setText("");
		this.lblSuccesso.setText("");
		
		this.model.getParziale().clear();
		this.model.resetSpesa();
		this.lblSuccesso.setText("Gli artisti aggiunti in precedenza alla soluzione sono stati eliminati correttamente!");
		
		this.btnElimina.setDisable(true);

    }

	@FXML
	void vaiAllaSoluzione(ActionEvent event) {
		try {
			Stage stage = null;
			BorderPane root = null;
			
			stage = (Stage) this.btnSoluzione.getScene().getWindow();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Ricorsione.fxml"));
			root = loader.load();
			
			RicorsioneController controller = loader.getController();
			controller.setModel(model);
			
			Scene scene = new Scene(root);
			
			stage.setTitle("Combinazione ottima degli artisti");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	void initialize() {
		assert radioFiltro != null : "fx:id=\"radioFiltro\" was not injected: check your FXML file 'Ricerca.fxml'.";
		assert groupRicerca != null : "fx:id=\"groupRicerca\" was not injected: check your FXML file 'Ricerca.fxml'.";
		assert radioCombinata != null : "fx:id=\"radioCombinata\" was not injected: check your FXML file 'Ricerca.fxml'.";
		assert boxFiltro != null : "fx:id=\"boxFiltro\" was not injected: check your FXML file 'Ricerca.fxml'.";
		assert boxGenere != null : "fx:id=\"boxGenere\" was not injected: check your FXML file 'Ricerca.fxml'.";
		assert txtNumeroBiglietti != null : "fx:id=\"txtNumeroBiglietti\" was not injected: check your FXML file 'Ricerca.fxml'.";
        assert txtSpotify != null : "fx:id=\"txtSpotify\" was not injected: check your FXML file 'Ricerca.fxml'.";
		assert txtCachet != null : "fx:id=\"txtCachet\" was not injected: check your FXML file 'Ricerca.fxml'.";
		assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Ricerca.fxml'.";
		assert lblErrore != null : "fx:id=\"lblErrore\" was not injected: check your FXML file 'Ricerca.fxml'.";
        assert lblSuccesso != null : "fx:id=\"lblSuccesso\" was not injected: check your FXML file 'Ricerca.fxml'.";
		assert btnRicerca != null : "fx:id=\"btnRicerca\" was not injected: check your FXML file 'Ricerca.fxml'.";
		assert btnAggiungi != null : "fx:id=\"btnAggiungi\" was not injected: check your FXML file 'Ricerca.fxml'.";
        assert btnElimina != null : "fx:id=\"btnElimina\" was not injected: check your FXML file 'Ricerca.fxml'.";
		assert btnSoluzione != null : "fx:id=\"btnSoluzione\" was not injected: check your FXML file 'Ricerca.fxml'.";
		assert tableArtista != null : "fx:id=\"tableArtista\" was not injected: check your FXML file 'Ricerca.fxml'.";
		assert tcNome != null : "fx:id=\"tcNome\" was not injected: check your FXML file 'Ricerca.fxml'.";
		assert tcGenere != null : "fx:id=\"tcGenere\" was not injected: check your FXML file 'Ricerca.fxml'.";
		assert tcBiglietti != null : "fx:id=\"tcBiglietti\" was not injected: check your FXML file 'Ricerca.fxml'.";
        assert tcSpotify != null : "fx:id=\"tcSpotify\" was not injected: check your FXML file 'Ricerca.fxml'.";
		assert tcCachet != null : "fx:id=\"tcCachet\" was not injected: check your FXML file 'Ricerca.fxml'.";

	}

	public void setModel(Model model) {
		this.model = model;
		List<String> filtri = new ArrayList<>();
		filtri.add(new String("Trova tutti gli artisti"));
		filtri.add(new String("Trova gli artisti appartenenti ad un genere musicale"));
		filtri.add(new String("Trova gli artisti per numero medio di biglietti venduti"));
		filtri.add(new String("Trova gli artisti per ascolti su Spotify nell'ultimo mese"));
		filtri.add(new String("Trova gli artisti per cachet"));
		filtri.add(new String("Trova gli artisti dato il nome o una parte di esso"));
		this.boxFiltro.getItems().addAll(filtri);

		this.boxGenere.getItems().addAll(this.model.getMusicalGenres());

		this.tcBiglietti.setCellValueFactory(new PropertyValueFactory<Artista, Double>("numeroMedioBigliettiVenduti"));
		this.tcCachet.setCellValueFactory(new PropertyValueFactory<Artista, Integer>("cachetMedio"));
		this.tcGenere.setCellValueFactory(new PropertyValueFactory<Artista, String>("genere"));
		this.tcNome.setCellValueFactory(new PropertyValueFactory<Artista, String>("nome"));
		this.tcSpotify.setCellValueFactory(new PropertyValueFactory<Artista, Integer>("ascoltiSpotifyUltimoMese"));

	}
}
